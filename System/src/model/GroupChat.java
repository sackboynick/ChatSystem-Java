package model;

import java.util.ArrayList;
import java.util.Collection;

public class GroupChat extends Chat{
    public int id;
    private final String groupName;
    private final Collection<Participant> participants;

    public GroupChat(String groupName) {
        super();
        this.groupName = groupName;
        this.participants =new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public int getId() {
        return id;
    }

    public boolean isUsernameInGroup(Participant participant){
        return participants.contains(participant);
    }

    public Collection<Participant> getParticipants() {
        return participants;
    }



    @Override
    public Collection<Message> getMessages() {
        return super.getMessages();
    }

}
