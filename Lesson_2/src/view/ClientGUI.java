package view;

import controller.ClientController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClientGUI extends JFrame implements ClientView {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private ClientController clientController;
    private TextField login, password, ipAddress, serverPort, message;
    private TextArea log;
    private JButton connectServer, btnSend;

    public ClientGUI(ServerGUI serverGUI){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chat client");
        this.login = new TextField("Login");
        this.password = new TextField("Password");
        this.ipAddress = new TextField("IP Address");
        this.serverPort = new TextField("Server port");
        this.message = new TextField();
        this.log = new TextArea();
        clientController = new ClientController(this, serverGUI.getController());
        add(createClientPanel());
        setVisible(true);
    }

    public JPanel createClientPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add(createInputPanel(), BorderLayout.NORTH);
        jPanel.add(createLogPanel());
        jPanel.add(createMessagePanel(), BorderLayout.SOUTH);
        return jPanel;
    }

    public JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(2, 3));
        connectServer = new JButton("Login");
        connectServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               connect();
            }
        });
        inputPanel.add(ipAddress);
        inputPanel.add(serverPort);
        inputPanel.add(login);
        inputPanel.add(password);
        inputPanel.add(connectServer);
        return inputPanel;
    }

    public JPanel createLogPanel(){
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(log);
        return logPanel;
    }

    public JPanel createMessagePanel() {
        JPanel sendPanel = new JPanel(new BorderLayout());
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendClientMessage();
            }
        });
        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    sendClientMessage();
                }
            }
        });
        sendPanel.add(message);
        sendPanel.add(btnSend, BorderLayout.EAST);
        return sendPanel;
    }

    @Override
    public void update(String messageText) {
        log.append(messageText);
        log.append("\n");
    }

    @Override
    public void connect() {
        if(clientController.clientConnect(login.getText())){
            log.append("You're logged in\n");
            log.append(clientController.loadServerHistory());
        }
        else
            log.append("Server isn't working\n");
    }

    @Override
    public void disconnect(){
        log.append("Server disconnected\n");
    }

    public void sendClientMessage(){
        if(clientController.isServerWorking()){
            if(clientController.isLogged()){
                clientController.sendToServer(login.getText() + ": " + message.getText());
                message.setText("");
            }
            else
                log.append("You're not logged in\n");
        }
        else
            log.append("Server isn't working");
    }
}