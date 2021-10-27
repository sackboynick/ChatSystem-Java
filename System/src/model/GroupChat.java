package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class GroupChat extends Chat{
    private final ArrayList<String> participants;
    private String[] admins;

    public GroupChat(String groupCreator) {
        super();
        this.participants =new ArrayList<>();
        this.participants.add(groupCreator);
        this.getMessages().add(new Message("Server", participants.get(0)+" just created the group on date "+ LocalDate.now()));
        this.admins[0]=groupCreator;
    }

    public boolean isUsernameInGroup(String participant){
        return participants.contains(participant);
    }


    @Override
    public ArrayList<Message> getMessages() {
        return super.getMessages();
    }
}
