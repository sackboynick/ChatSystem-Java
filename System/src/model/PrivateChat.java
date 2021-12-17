package model;

import java.util.Collection;

public class PrivateChat extends Chat{
    private int id;
    private final String participant1, participant2;

    public PrivateChat(String participant1,String participant2){
        this.participant1=participant1;
        this.participant2 = participant2;
    }

    public int getId() {
        return id;
    }

    public String getParticipant2() {
        return participant2;
    }

    public String getParticipant1() {
        return participant1;
    }

    @Override
    public Collection<Message> getMessages() {
        return super.getMessages();
    }
}
