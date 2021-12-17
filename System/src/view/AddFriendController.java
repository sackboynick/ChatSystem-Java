package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.*;
import javafx.scene.control.*;
import model.User;
import viewmodel.AddFriendViewModel;


public class AddFriendController extends ViewController{

    @FXML
    private TableView<User> userTableView;
    @FXML
    private TableColumn<User,String> username;
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField searchUser;

    private AddFriendViewModel addFriendViewModel;
    @Override
    protected void init() {
        this.addFriendViewModel=getViewModelFactory().getAddFriendViewModel();
        this.username.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
        this.searchUser.textProperty().bindBidirectional(addFriendViewModel.getUsername());
        this.addFriendViewModel=getViewModelFactory().getAddFriendViewModel();
        reset();
    }

    public void reset(){
        addFriendViewModel.update();
        this.usernameLabel.setText(addFriendViewModel.getUsernameLabelProperty().get());
        this.userTableView.setItems(addFriendViewModel.getUsers());
    }

    @FXML
    public void back(){
        getViewHandler().openView("friendsList");
    }

    @FXML
    public void addFriend(){
        addFriendViewModel.addFriend(this.userTableView.getSelectionModel().getSelectedItem().getUsername());
        back();
    }

    @FXML
    public void searchUser(){
        addFriendViewModel.searchUserByUsername();
    }
}
