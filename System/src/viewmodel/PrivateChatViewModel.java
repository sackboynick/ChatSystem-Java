package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Message;
import model.Model;

public class PrivateChatViewModel {
    private final Model model;
    private StringProperty usernameLabelProperty,messageBoxProperty;
    private ObservableList<Message> messages;


    public PrivateChatViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        this.messageBoxProperty=new SimpleStringProperty();
        update();
    }

    public void update(){
        if(ViewState.getInstance().getUser()!=null)
        this.usernameLabelProperty=new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
        this.messages= FXCollections.observableArrayList();
        try {
            if(ViewState.getInstance().getPrivateChat()!=null)
            this.messages.addAll(this.model.getPrivateMessages(ViewState.getInstance().getPrivateChat().getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Message> getMessages() {
        return messages;
    }
    public StringProperty getUsernameLabelProperty(){
        return usernameLabelProperty;
    }

    public StringProperty getMessageBoxProperty(){
        return messageBoxProperty;
    }

    public void sendMessage(){
        Message message;
        if(ViewState.getInstance().getPrivateChat().getParticipant1().equals(ViewState.getInstance().getUser().getUsername()))
            message=new Message(ViewState.getInstance().getUser().getUsername(),ViewState.getInstance().getPrivateChat().getParticipant2(), messageBoxProperty.get());
        else
            message=new Message(ViewState.getInstance().getUser().getUsername(),ViewState.getInstance().getPrivateChat().getParticipant1(),messageBoxProperty.get());
        try {
            message.setPrivateChatId(ViewState.getInstance().getPrivateChat().getId());
            message.setText(messageBoxProperty.get());
            this.model.sendMessage(message);
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
}
