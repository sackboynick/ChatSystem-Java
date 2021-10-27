package model;

import java.time.LocalDateTime;

public class Message {
    private final String senderUsername;
    private final LocalDateTime localDateTime;
    private final String text;

    public Message(String senderUsername,String text){
        this.senderUsername=senderUsername;
        this.localDateTime=LocalDateTime.now();
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
