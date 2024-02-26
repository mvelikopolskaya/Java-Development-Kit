package view;

public interface ServerView {
    void appendLog(String text);

    void clientConnectMessage(String clientName);
}
