package model;

import mediator.HttpDataRetriever;
import mediator.HttpLogInValidator;

import java.util.ArrayList;

public class ModelManager implements Model{
    private final HttpLogInValidator httpLogInValidator=new HttpLogInValidator();
    private final HttpDataRetriever httpDataRetriever=new HttpDataRetriever();

    @Override
    public User getUser(String username) throws Exception {
        return httpDataRetriever.getUser(username);
    }

    @Override
    public void promoteUser(int groupId, int participantId) throws Exception {
        httpDataRetriever.promoteUser(groupId,participantId);
    }

    @Override
    public void sendMessage(Message message) throws Exception {
        httpDataRetriever.sendMessage(message);
    }

    @Override
    public ArrayList<Friendship> userFriendships(int userId) throws Exception {
        return httpDataRetriever.userFriendships(userId);
    }

    @Override
    public ArrayList<PrivateChat> getUserPrivateChats(int userId) throws Exception {
        return httpDataRetriever.getUserPrivateChats(userId);
    }

    @Override
    public ArrayList<GroupChat> getUserGroupChats(int userId) throws Exception {
        return httpDataRetriever.getUserGroupChats(userId);
    }


    @Override
    public ArrayList<Participant> getParticipants(int groupId) throws Exception {
        return httpDataRetriever.getParticipants(groupId);
    }

    @Override
    public ArrayList<Message> getPrivateMessages(int chatId) throws Exception {
        return httpDataRetriever.getPrivateMessages(chatId);
    }

    @Override
    public ArrayList<Message> getGroupMessages(int groupId) throws Exception {
        return httpDataRetriever.getGroupMessages(groupId);
    }

    @Override
    public Message getMessage(int messageId) throws Exception {
        return httpDataRetriever.getMessage(messageId);
    }

    @Override
    public void removeMessage(int messageId) throws Exception {
        httpDataRetriever.removeMessage(messageId);
    }

    @Override
    public void addFriendship(int userId, int friendUserId, boolean closeFriend) throws Exception {
        httpDataRetriever.addFriendship(userId,friendUserId,closeFriend);
    }

    @Override
    public void removeFriend(int friendshipId) throws Exception {
        httpDataRetriever.removeFriend(friendshipId);
    }

    @Override
    public Friendship getFriendship(int friendshipId) throws Exception {
        return httpDataRetriever.getFriendship(friendshipId);
    }

    @Override
    public void createGroup(String groupName, String groupCreator) throws Exception {
        httpDataRetriever.createGroup(groupName, groupCreator);
    }

    @Override
    public void addParticipant(Participant participant) throws Exception {
        httpDataRetriever.addParticipant(participant);
    }

    @Override
    public void removeParticipant(int participantId) throws Exception {
        httpDataRetriever.removeParticipant(participantId);
    }

    @Override
    public void forwardMessage(Message message, int forwardedMessageId) throws Exception {
        httpDataRetriever.forwardMessage(message,forwardedMessageId);
    }

    @Override
    public void pinMessage(int messageId) throws Exception {
        httpDataRetriever.pinMessage(messageId);
    }

    @Override
    public ArrayList<GroupChat> getAllGroupChats() throws Exception {
        return httpDataRetriever.getAllGroupChats();
    }

    @Override
    public User getUserFromId(int userId) throws Exception {
        return httpDataRetriever.getUserFromId(userId);
    }

    @Override
    public void addPrivateChat(PrivateChat privateChat) throws Exception {
        httpDataRetriever.addPrivateChat(privateChat);
    }

    @Override
    public ArrayList<PrivateChat> getAllPrivateChats() throws Exception {
        return httpDataRetriever.getAllPrivateChats();
    }

    @Override
    public void registerUser(User user) throws Exception {
        httpLogInValidator.registerUser(user);
    }

    @Override
    public User logIn(String username, String password) throws Exception {
        return httpLogInValidator.logIn(username,password);
    }
}
