package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Friendship;
import model.Participant;
import viewmodel.ParticipantListViewModel;

public class ParticipantListController extends ViewController{
    private ParticipantListViewModel participantListViewModel;

    @FXML
    public Label usernameLabel;
    @FXML public TableView<Participant> participantTableView;
    @FXML public TableColumn<Participant, String> participantUsername;
    @FXML public TextField friendUsername;

    @Override
    protected void init() {
        this.participantListViewModel =getViewModelFactory().getParticipantListViewModel();
        this.friendUsername.textProperty().bindBidirectional(participantListViewModel.getFriendUsernameProperty());
        this.participantUsername.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser()));
        reset();
    }

    public void reset(){
        update();
        this.participantTableView.setItems(participantListViewModel.getParticipants());
        this.usernameLabel.setText(participantListViewModel.getUsernameLabelProperty().get());
    }

    @FXML public void onBack(){
        getViewHandler().openView("chats");
    }


    @FXML public void addParticipant(){
        this.participantListViewModel.addParticipant(participantListViewModel.getUser(friendUsername.getText()).getId());
        reset();
    }

    @FXML public void removeParticipant(){
        this.participantListViewModel.removeParticipant(participantTableView.getSelectionModel().getSelectedItem().getId());
        reset();
    }

    @FXML public void promoteParticipant(){
        this.participantListViewModel.promoteParticipant(participantTableView.getSelectionModel().getSelectedItem().getId());
        reset();
    }
    @FXML public void update(){
        this.participantListViewModel.update();
    }
}
