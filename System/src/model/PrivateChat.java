package model;

import java.util.ArrayList;

public class PrivateChat extends Chat{
    private final String sender, receiver;

    public PrivateChat(String sender,String receiver){
        this.sender=sender;
        this.receiver=receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public ArrayList<Message> getMessages() {
        return super.getMessages();
    }
}
