package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Message;
import viewmodel.PrivateChatViewModel;
import viewmodel.ViewState;

public class PrivateChatController extends ViewController{

    private PrivateChatViewModel privateChatViewModel;

    @FXML private Label usernameLabel;
    @FXML private TableView<Message> messageTableView;
    @FXML
    private TableColumn<Message,String> sender,messages,datetime;
    @FXML private TextField messageBox;


    @Override
    protected void init() {
        this.privateChatViewModel =getViewModelFactory().getPrivateChatViewModel();
        this.sender.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSenderusername()));
        this.messages.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getText()));
        this.datetime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocaldatetime()));
        this.messageBox.textProperty().bindBidirectional(this.privateChatViewModel.getMessageBoxProperty());
        reset();
    }

    public void reset(){
        update();
        this.messageTableView.setItems(this.privateChatViewModel.getMessages());
        this.usernameLabel.setText(privateChatViewModel.getUsernameLabelProperty().get());
    }

    @FXML public void onBack(){
        ViewState.getInstance().setPrivateChat(null);
        getViewHandler().openView("chats");
    }

    @FXML public void onForwardMessage(){
        ViewState.getInstance().setMessage(privateChatViewModel.getMessageById(messageTableView.getSelectionModel().getSelectedItem().getId()));
        getViewHandler().openView("forwardMessage");
    }
    @FXML public void sendMessage(){
        this.privateChatViewModel.sendMessage();
        reset();
    }
    @FXML public void update(){
        privateChatViewModel.update();
    }
}
