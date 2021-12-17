package viewmodel;

import model.*;

/**
 * The class represents the State of the views, storing the information needed to display the details of users, offers or
 * renting deals. The class follows the Singleton pattern.
 * @author Group8-SEP2
 * @version 1.0.0 2021
 */

public class ViewState {
    private static ViewState instance;
    private User user;
    private GroupChat groupChat;
    private PrivateChat privateChat;
    private Message message;

    /**
     * Zero-argument private constructor.
     */
    private ViewState(){}

    /**
     * Getter for the instance of the ViewState object.
     * @return The stored instance of the ViewState object.
     */
    public static ViewState getInstance(){
        if(instance==null)
            instance=new ViewState();
        return instance;
    }


    /**
     * Setter for the user in the state.
     * @param user User object to set in the state.
     */
    public void setUser(User user) {
        this.user = user;
    }


    public GroupChat getGroupChat() {
        return groupChat;
    }

    public PrivateChat getPrivateChat() {
        return privateChat;
    }

    public void setGroupChat(GroupChat groupChat) {
        this.groupChat = groupChat;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setPrivateChat(PrivateChat privateChat) {
        this.privateChat = privateChat;
    }

    /**
     * Getter for the user in the state.
     * @return User object to get from the state.
     */
    public User getUser() {
        return user;
    }

    public Message getMessage() {
        return message;
    }

}
