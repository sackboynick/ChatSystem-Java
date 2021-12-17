package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Message;
import model.Model;

public class GroupChatViewModel {
    private final Model model;
    private StringProperty usernameLabelProperty,messageBoxProperty;
    private ObservableList<Message> messages;


    public GroupChatViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        this.messageBoxProperty=new SimpleStringProperty();
        update();
    }


    public ObservableList<Message> getMessages() {
        return messages;
    }

    public StringProperty getMessageBoxProperty() {
        return messageBoxProperty;
    }

    public void update(){
        if(ViewState.getInstance().getUser()!=null)
        this.usernameLabelProperty=new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
        this.messages= FXCollections.observableArrayList();
        try {
            if(ViewState.getInstance().getGroupChat()!=null)
            this.messages.addAll(this.model.getGroupMessages(ViewState.getInstance().getGroupChat().id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        try {
            Message message=new Message(ViewState.getInstance().getUser().getUsername(),messageBoxProperty.get());
            if(ViewState.getInstance().getGroupChat()!=null)
            message.setGroupChatId(ViewState.getInstance().getGroupChat().id);
            this.model.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replyMessage(int messageId){
        Message message=new Message(ViewState.getInstance().getUser().getUsername(),messageBoxProperty.get());
        if(ViewState.getInstance().getGroupChat()!=null)
        message.setGroupChatId(ViewState.getInstance().getGroupChat().id);
        message.setRepliedMessageId(messageId);
        try {
            this.model.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void pinMessage(int messageId){
        try {
            this.model.pinMessage(messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message getMessageById(int messageId){
        try {
            return model.getMessage(messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }
}
