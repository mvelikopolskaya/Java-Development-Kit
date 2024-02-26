package controller;

import view.ClientView;

public class ClientController {
    private ClientView clientView;
    private ServerController serverController;

    public ClientController(ClientView clientView, ServerController serverController) {
        this.clientView = clientView;
        this.serverController = serverController;
    }

    public boolean clientConnect(String clientName){
        if(serverController.isWorking()) {
            serverController.addClientController(this, clientName);
            return true;
        }
        return false;
    }

    public void clientUpdate(String message){
        clientView.update(message);
    }

    public void sendToServer(String message){
        if(isServerWorking()){
            serverController.sendMessage(message);
        }
    }

    public boolean isLogged(){
        return serverController.clientLogged(this);
    }

    public void disconnect(){
        clientView.disconnect();
    }

    public boolean isServerWorking(){
        return serverController.isWorking();
    }
    public String loadServerHistory(){
       return serverController.loadHistory();
    }


}
