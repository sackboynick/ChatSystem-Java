package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Participant;
import model.User;

public class ParticipantListViewModel {
    private final Model model;
    private StringProperty usernameLabelProperty;
    private ObservableList<Participant>  participants;
    private StringProperty friendUsernameProperty;


    public ParticipantListViewModel(Model model){
        this.model=model;
        this.usernameLabelProperty=new SimpleStringProperty();
        this.friendUsernameProperty =new SimpleStringProperty();
        update();
    }

    public void update(){
        if(ViewState.getInstance().getUser()!=null) {
            System.out.println(ViewState.getInstance().getUser().getUsername());
            this.usernameLabelProperty = new SimpleStringProperty(ViewState.getInstance().getUser().getUsername());
        }
        this.participants= FXCollections.observableArrayList();
        try {
            if(ViewState.getInstance().getUser()!=null)
                this.participants.addAll(this.model.getParticipants(ViewState.getInstance().getGroupChat().getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User getUser(String username){
        try {
            return model.getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Participant> getParticipants() {
        return participants;
    }

    public StringProperty getUsernameLabelProperty() {
        return usernameLabelProperty;
    }

    public StringProperty getFriendUsernameProperty() {
        return friendUsernameProperty;
    }

    public void addParticipant(int participantId){
        try {
            this.model.addParticipant(new Participant(getUserUsernameFromId(participantId),false,ViewState.getInstance().getGroupChat().id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeParticipant(int participantId){
        try {
            this.model.removeParticipant(participantId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void promoteParticipant(int participantId){
        try {
            this.model.promoteUser(ViewState.getInstance().getGroupChat().id,participantId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public String getUserUsernameFromId(int userId){
        try {
            return this.model.getUserFromId(userId).getUsername();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
