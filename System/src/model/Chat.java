package model;

import java.util.ArrayList;

public class Chat {
    private final ArrayList<Message> messages;

    public Chat(){
        this.messages=new ArrayList<>();
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
