package controller;

import fileservice.FileService;
import view.*;
import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private FileService fileService;
    private ServerGUI serverGUI;
    private List<ClientController> clientControllerList;
    private boolean isWorking = false;

    public ServerController(ServerGUI serverGUI) {
        this.fileService = new FileService();
        this.serverGUI = serverGUI;
        this.clientControllerList = new ArrayList<>();
    }

    public void addClientController(ClientController client, String clientName){
        if(!clientLogged(client)){
            clientControllerList.add(client);
            serverGUI.clientConnectMessage(clientName);
        }
    }

    public boolean clientLogged(ClientController client){
        return clientControllerList.contains(client);
    }

    public void sendMessage(String message){
        fileService.saveLog(message);
        for(ClientController client : clientControllerList){
            client.clientUpdate(message);
        }
        addToLog(message);
    }

    public String loadHistory(){
        return fileService.loadLog();
    }

    public void addToLog(String message){
        serverGUI.appendLog(message);
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void connectServer() {
        isWorking = true;
    }

    public void disconnectServer(){
        for(ClientController client : clientControllerList){
            client.disconnect();
        }
        clientControllerList.clear();
        isWorking = false;
    }
}