import com.google.gson.Gson;
import javafx.application.Application;
import mediator.HttpDataRetriever;
import mediator.HttpLogInValidator;
import mediator.IData;
import mediator.IUserValidator;
import model.Chat;
import model.Message;
import model.Participant;
import model.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IUserValidator iUserValidator=new HttpLogInValidator();
        IData iData=new HttpDataRetriever();

        Application.launch(MyApplication.class);

        try {
            /*
            User user= iUserValidator.logIn("sackboynick","Password");
            System.out.println(user.getFriends().size());
            ArrayList<Chat> chats=iData.userChats(user.getId());
            System.out.println(chats.size());
            iData.addFriendship(0,8,true);

             User user=iData.getUser("sackboynick");
            iData.promoteUser(7,11);
            iData.sendMessage(new Message("sackboynick","CR7","ciao"));
            System.out.println(iData.userFriendships(0).get(2).getFriendUserId());
            System.out.println(iData.getGroupMessages(1).get(0).getText());
            System.out.println(iData.getPrivateMessages(1).get(0).getId());
            System.out.println(iData.getMessage(13).getText());
            System.out.println(iData.getUserGroupChats(0).size());
            iData.pinMessage(17);
            System.out.println(iData.getMessage(17).isPinnedMessageProperty());
            System.out.println(iData.getFriendship(1).getFriendUserId());
            iData.removeMessage(17);
            iData.removeFriend(5);
            iData.removeParticipant(11);
            Message message= new Message("sackboynick","CR7","ciao");
            message.setId(16);
            iData.forwardMessage(message, 9);
            iData.addFriendship(2,3,false);
            iData.createGroup("ciao");
            iData.addParticipant(new Participant("sackboynick",false,12)); */





        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
