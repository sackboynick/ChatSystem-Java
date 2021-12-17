package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.GroupChat;
import model.PrivateChat;
import viewmodel.ChatsViewModel;
import viewmodel.ViewState;

public class ChatsController extends ViewController{

    @FXML
    private TableView<PrivateChat> privateChatTableView;
    @FXML
    private TableView<GroupChat> groupChatTableView;
    @FXML
    private TableColumn<PrivateChat,String> name, privateMessages,privateDateTime;
    @FXML
    private TableColumn<GroupChat,String> groupName, groupMessages,groupDateTime;
    @FXML
    private Label usernameLabel;

    private ChatsViewModel chatsViewModel;

    @Override
    protected void init() {
        chatsViewModel=getViewModelFactory().getChatsViewModel();
        this.name.setCellValueFactory(cellData -> !cellData.getValue().getParticipant1().equals(ViewState.getInstance().getUser().getUsername()) ? new SimpleStringProperty(cellData.getValue().getParticipant1()) : new SimpleStringProperty(cellData.getValue().getParticipant2()));
        this.privateMessages.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastMessage().getText()));
        this.privateDateTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastMessage().getLocaldatetime()));
        this.groupName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGroupName()));
        this.groupMessages.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastMessage().getText()));
        this.groupDateTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastMessage().getLocaldatetime()));
        reset();
    }
    public void reset(){
        update();
        this.privateChatTableView.setItems(chatsViewModel.getPrivateChats());
        this.groupChatTableView.setItems(chatsViewModel.getGroupChats());
        this.usernameLabel.setText(chatsViewModel.getUsernameLabelProperty().get());
    }

    @FXML public void openGroupChat(){
        ViewState.getInstance().setGroupChat(groupChatTableView.getSelectionModel().getSelectedItem());
        getViewHandler().openView("groupChat");
    }

    @FXML public void openPrivateChat(){
        ViewState.getInstance().setPrivateChat(privateChatTableView.getSelectionModel().getSelectedItem());
        getViewHandler().openView("privateChat");
    }

    @FXML public void openCreateGroupInterface(){
        getViewHandler().openView("createGroup");
    }

    @FXML public void openFriendList(){
        getViewHandler().openView("friendsList");
    }

    @FXML public void update(){
        this.chatsViewModel.update();
    }



}
