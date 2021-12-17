package mediator;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IData {
    User getUser(String username) throws Exception;
    void promoteUser(int groupId,int participantId) throws Exception;

    void sendMessage(Message message) throws Exception;

    ArrayList<Friendship> userFriendships(int userId) throws Exception;
    ArrayList<PrivateChat> getUserPrivateChats(int userId) throws Exception;
    ArrayList<GroupChat> getUserGroupChats(int userId) throws Exception;
    ArrayList<Participant> getParticipants(int groupId) throws Exception;
    ArrayList<Message> getPrivateMessages(int chatId) throws Exception;
    ArrayList<Message> getGroupMessages(int groupId) throws Exception;

    Message getMessage(int messageId) throws Exception;
    void removeMessage(int messageId) throws Exception;

    void addFriendship(int userId,int friendUserId, boolean closeFriend) throws Exception;
    void removeFriend(int friendshipId) throws Exception;
    Friendship getFriendship(int friendshipId) throws Exception;


    void createGroup(String groupName, String groupCreator) throws Exception;

    void addParticipant(Participant participant) throws Exception;
    void removeParticipant(int participantId) throws Exception;

    void forwardMessage(Message message,int forwardedMessageId) throws Exception;
    void pinMessage(int messageId) throws Exception;
    ArrayList<GroupChat> getAllGroupChats() throws Exception;

    User getUserFromId(int userId) throws Exception;

    void addPrivateChat(PrivateChat privateChat) throws Exception;

    ArrayList<PrivateChat> getAllPrivateChats() throws Exception;
}
