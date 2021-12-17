package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Friendship;
import viewmodel.FriendsListViewModel;

public class FriendsListController extends ViewController{
    private FriendsListViewModel friendsListViewModel;

    @FXML
    public Label usernameLabel;
    @FXML public TableView<Friendship> friendshipTableView;
    @FXML public TableColumn<Friendship, String> friendUsername,friendFullName;
    @FXML public TextField messageBox;

    @Override
    protected void init() {
        this.friendsListViewModel=getViewModelFactory().getFriendsListViewModel();
        this.messageBox.textProperty().bindBidirectional(friendsListViewModel.getMessageBoxProperty());
        this.friendUsername.setCellValueFactory(cellData -> new SimpleStringProperty(friendsListViewModel.getUserUsernameFromId(cellData.getValue().getFriendUserId())));
        this.friendFullName.setCellValueFactory(cellData -> new SimpleStringProperty(friendsListViewModel.getUserFullNameFromId(cellData.getValue().getFriendUserId())));
        reset();
    }

    public void reset(){
        update();
        this.friendshipTableView.setItems(friendsListViewModel.getFriendships());
        this.usernameLabel.setText(friendsListViewModel.getUsernameLabelProperty().get());
    }

    @FXML public void onBack(){
        getViewHandler().openView("chats");
    }


    @FXML public void addNewFriend(){
        getViewHandler().openView("addFriend");
    }

    @FXML public void removeFriend(){
        this.friendsListViewModel.removeFriend(friendshipTableView.getSelectionModel().getSelectedItem().getId());
        reset();
    }

    @FXML public void sendMessage(){
        this.friendsListViewModel.sendMessageToFriend(friendsListViewModel.getUserFromId(friendshipTableView.getSelectionModel().getSelectedItem().getFriendUserId()).getUsername());
    }
    @FXML public void update(){
        this.friendsListViewModel.update();
    }
}
