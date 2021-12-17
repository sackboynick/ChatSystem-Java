package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.List;

public class FriendsListViewModel {
    private final Model model;
    private StringProperty usernameLabelProperty;
    private ObservableList<Friendship> friendships;
    private StringProperty messageBoxProperty;


    public FriendsListViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        this.messageBoxProperty=new SimpleStringProperty();
        update();
    }

    public void update(){
        if(ViewState.getInstance().getUser()!=null) {
            System.out.println(ViewState.getInstance().getUser().getUsername());
            this.usernameLabelProperty = new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
        }
        this.friendships= FXCollections.observableArrayList();
        try {
            if(ViewState.getInstance().getUser()!=null)
                this.friendships.addAll(this.model.userFriendships(ViewState.getInstance().getUser().getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Friendship> getFriendships() {
        return friendships;
    }

    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }

    public StringProperty getMessageBoxProperty(){
        return messageBoxProperty;
    }

    public void removeFriend(int friendShipId){
        try {
            this.model.removeFriend(friendShipId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToFriend(String username){

        Message message=new Message(ViewState.getInstance().getUser().getUsername(),username,messageBoxProperty.get());
        try {
            boolean found=false;
            for (PrivateChat privateChat:model.getUserPrivateChats(ViewState.getInstance().getUser().getId())
                 ) {
                if((privateChat.getParticipant1().equals(message.getSenderusername()) && privateChat.getParticipant2().equals(username)) || privateChat.getParticipant2().equals(message.getSenderusername()) && privateChat.getParticipant1().equals(username)) {
                    message.setPrivateChatId(privateChat.getId());
                    found=true;
                }
            }
            if(!found) {
                model.addPrivateChat(new PrivateChat(message.getSenderusername(), message.getReceiverusername()));
                List<PrivateChat> privateChatList = model.getAllPrivateChats();
                message.setPrivateChatId(privateChatList.get(privateChatList.size() - 1).getId());
            }
            this.model.sendMessage(message);
            messageBoxProperty.set("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User getUserFromId(int userId){
        try {
            return this.model.getUserFromId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserUsernameFromId(int userId){
        try {
            return this.model.getUserFromId(userId).getUsername();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserFullNameFromId(int userId){
        User user=null;
        try {
            user=this.model.getUserFromId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert user != null;
        return user.getFirstName()+" "+user.getLastName();
    }


}
