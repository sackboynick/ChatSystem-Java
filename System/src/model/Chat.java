package model;

import java.util.ArrayList;
import java.util.Collection;

public class Chat {
    private final Collection<Message> messages;

    public Chat(){
        this.messages=new ArrayList<>();
    }

    public Collection<Message> getMessages() {
        return messages;
    }

    public Message getLastMessage(){
        if(messages.size()==0)
            return null;
        return (Message) this.messages.toArray()[messages.size()-1];
    }
}
