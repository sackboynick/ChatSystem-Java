package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Friendship;
import viewmodel.ForwardMessageViewModel;

public class ForwardMessageController extends ViewController{
    private ForwardMessageViewModel forwardMessageViewModel;

    @FXML
    public Label usernameLabel;
    @FXML public TableView<Friendship> friendshipTableView;
    @FXML public TableColumn<Friendship, String> friendUsername,friendFullName;
    @FXML public Label sender,text;

    @Override
    protected void init() {
        this.forwardMessageViewModel=getViewModelFactory().getForwardMessageViewModel();
        this.friendUsername.setCellValueFactory(cellData -> new SimpleStringProperty(forwardMessageViewModel.getUserUsernameFromId(cellData.getValue().getFriendUserId())));
        this.friendFullName.setCellValueFactory(cellData -> new SimpleStringProperty(forwardMessageViewModel.getUserFullNameFromId(cellData.getValue().getFriendUserId())));
        reset();
    }

    public void reset(){
        update();
        this.friendshipTableView.setItems(forwardMessageViewModel.getFriendships());
        this.usernameLabel.setText(forwardMessageViewModel.getUsernameLabelProperty().get());
        this.text.setText(forwardMessageViewModel.getMessageTextProperty().get());
        this.sender.setText(forwardMessageViewModel.getMessageSenderProperty().get());
    }

    @FXML public void onBack(){
        getViewHandler().openView("chats");
    }



    @FXML public void forwardMessage(){
        this.forwardMessageViewModel.forwardMessage(friendshipTableView.getSelectionModel().getSelectedItem().getFriendUserId());
        onBack();
    }
    @FXML public void update(){
        this.forwardMessageViewModel.update();
    }
}
