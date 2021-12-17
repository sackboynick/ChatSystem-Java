package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Message;
import viewmodel.GroupChatViewModel;
import viewmodel.ViewState;

public class GroupChatController extends ViewController{

    private GroupChatViewModel groupChatViewModel;

    @FXML private Label usernameLabel;
    @FXML private TableView<Message> messageTableView;
    @FXML
    private TableColumn<Message,String> sender,messages,datetime;
    @FXML private TextField messageBox;


    @Override
    protected void init() {
        this.groupChatViewModel=getViewModelFactory().getGroupChatViewModel();
        this.sender.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSenderusername()));
        this.messages.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getText()));
        this.datetime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocaldatetime()));
        this.messageBox.textProperty().bindBidirectional(this.groupChatViewModel.getMessageBoxProperty());
        reset();
    }

    public void reset(){
        update();
        this.messageTableView.setItems(this.groupChatViewModel.getMessages());
        this.usernameLabel.setText(groupChatViewModel.getUsernameLabelProperty().get());
    }

    @FXML public void onBack(){
        ViewState.getInstance().setGroupChat(null);
        getViewHandler().openView("chats");
    }
    @FXML public void onParticipantList(){
        getViewHandler().openView("participantList");
    }
    @FXML public void onForwardMessage(){
        ViewState.getInstance().setMessage(groupChatViewModel.getMessageById(messageTableView.getSelectionModel().getSelectedItem().getId()));
        getViewHandler().openView("forwardMessage");
    }
    @FXML public void replyMessage(){
        this.groupChatViewModel.replyMessage(messageTableView.getSelectionModel().getSelectedItem().getId());
        messageBox.setText("");
        reset();
    }
    @FXML public void pinMessage(){
        this.groupChatViewModel.pinMessage(messageTableView.getSelectionModel().getSelectedItem().getId());
        reset();
    }
    @FXML public void sendMessage(){
        this.groupChatViewModel.sendMessage();
        reset();
    }
    @FXML public void update(){
        groupChatViewModel.update();

    }
}
