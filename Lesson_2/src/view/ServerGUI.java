package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ServerController;

public class ServerGUI extends JFrame implements ServerView{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private JPanel jPanel;
    private JButton btnStart, btnStop;
    private JTextArea log;
    private ServerController serverController;

    public ServerGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chat server");
        serverController = new ServerController(this);
        this.jPanel = createServerWindow();
        this.log = new JTextArea();
        add(this.log);
        add(jPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public JPanel createServerWindow() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        btnStart = createStartButton();
        btnStop = createStopButton();
        jPanel.add(btnStart);
        jPanel.add(btnStop);
        return jPanel;
    }

    public JButton createStartButton(){
        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!serverController.isWorking()){
                    serverController.connectServer();
                    appendLog("Server connected");
                    appendLog(serverController.loadHistory());
                } else{
                    appendLog("Server is already working");
                }
            }
        });
        return startBtn;
    }

    public JButton createStopButton(){
        JButton stopBtn = new JButton("Stop");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!serverController.isWorking()){
                    appendLog("Server isn't working");
                } else{
                    serverController.disconnectServer();
                    appendLog("Server stopped");
                }
            }
        });
        return stopBtn;
    }

    public ServerController getController() {
        return serverController;
    }

    @Override
    public void appendLog(String text){
        log.append(text);
        log.append("\n");
    }

    @Override
    public void clientConnectMessage(String clientName){
        appendLog(clientName + " logged in");
    }
}
