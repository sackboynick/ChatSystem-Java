package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.List;

public class ForwardMessageViewModel {
    private Model model;
    private StringProperty usernameLabelProperty,messageSenderProperty,messageTextProperty;
    private ObservableList<Friendship> friendships;

    public ForwardMessageViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        this.messageSenderProperty=new SimpleStringProperty();
        this.messageTextProperty=new SimpleStringProperty();

        this.friendships= FXCollections.observableArrayList();
        update();
    }

    public ObservableList<Friendship> getFriendships() {
        return friendships;
    }

    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }

    public StringProperty getMessageSenderProperty() {
        return messageSenderProperty;
    }
    public StringProperty getMessageTextProperty(){
        return messageTextProperty;
    }

    public void update(){
        if(ViewState.getInstance().getUser()!=null) {
            System.out.println(ViewState.getInstance().getUser().getUsername());
            this.usernameLabelProperty = new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
        }
        try {
            if(ViewState.getInstance().getUser()!=null) {
                this.friendships=FXCollections.observableArrayList();
                this.friendships.addAll(this.model.userFriendships(ViewState.getInstance().getUser().getId()));
            }
            if(ViewState.getInstance().getMessage()!=null) {
                this.messageTextProperty.set(ViewState.getInstance().getMessage().getText());
                this.messageSenderProperty.set(ViewState.getInstance().getMessage().getSenderusername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forwardMessage(int userId){
        try {
            Message message= new Message(ViewState.getInstance().getUser().getUsername(),this.model.getMessage(ViewState.getInstance().getMessage().getId()).getText());
            if(ViewState.getInstance().getPrivateChat()!=null) {
                message.setReceiverusername(getUserUsernameFromId(userId));
            }
                boolean found=false;
                for (PrivateChat privateChat:model.getUserPrivateChats(ViewState.getInstance().getUser().getId())
                ) {
                    if((privateChat.getParticipant1().equals(message.getSenderusername()) && privateChat.getParticipant2().equals(message.getReceiverusername())) || privateChat.getParticipant2().equals(message.getSenderusername()) && privateChat.getParticipant1().equals(message.getReceiverusername())) {
                        message.setPrivateChatId(privateChat.getId());
                        found=true;
                    }
                }
                if(!found) {
                    model.addPrivateChat(new PrivateChat(message.getSenderusername(), message.getReceiverusername()));
                    List<PrivateChat> privateChatList = model.getAllPrivateChats();
                    message.setPrivateChatId(privateChatList.get(privateChatList.size() - 1).getId());
                }
            this.model.forwardMessage(message,ViewState.getInstance().getMessage().getId());
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
