package mediator;

import com.google.gson.Gson;
import model.*;
import viewmodel.ViewState;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class HttpDataRetriever implements IData{

    public HttpDataRetriever(){

    }

    @Override
    public User getUser(String username) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/UserServer/"+username;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new Gson().fromJson(response.toString(), User.class);
    }


    @Override
    public void promoteUser(int groupId, int participantId) throws Exception{
        URL url = new URL("http://localhost:5003/ParticipantServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'PUT' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        Participant participant=null;
        ArrayList<Participant> groupParticipants=getParticipants(groupId);
        for (Participant groupParticipant : groupParticipants) {
            if (groupParticipant.getId() == participantId)
                participant = groupParticipant;

        }
        if (participant != null) {
            participant.setAdmin(true);
        }
        os.write(new Gson().toJson(participant).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public void sendMessage(Message message) throws Exception{
        URL url = new URL("http://localhost:5003/MessageServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'POST' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        System.out.println(new Gson().toJson(message));
        os.write(new Gson().toJson(message).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public ArrayList<Friendship> userFriendships(int userId) throws Exception {
        HttpURLConnection con;
        String url = "http://localhost:5003/FriendsOf/"+userId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print


        System.out.println("result after Reading JSON Response");
        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), Friendship[].class)));
    }

    @Override
    public ArrayList<PrivateChat> getUserPrivateChats(int userId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/PrivateChatServer/OfUser/"+userId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), PrivateChat[].class)));
    }

    @Override
    public ArrayList<GroupChat> getUserGroupChats(int userId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/GroupChatServer/OfUser/"+userId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), GroupChat[].class)));
    }

    @Override
    public ArrayList<Participant> getParticipants(int groupId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/ParticipantServer/Group/"+groupId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), Participant[].class)));

    }

    @Override
    public ArrayList<Message> getPrivateMessages(int chatId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/MessageServer/PrivateChat/"+chatId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), Message[].class)));
    }

    @Override
    public ArrayList<Message> getGroupMessages(int groupId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/MessageServer/Group/"+groupId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), Message[].class)));
    }

    @Override
    public Message getMessage(int messageId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/MessageServer/"+messageId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new Gson().fromJson(response.toString(), Message.class);
    }


    @Override
    public void removeMessage(int messageId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/MessageServer/"+messageId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("DELETE");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'DELETE' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

    }

    @Override
    public void addFriendship(int userId, int friendUserId, boolean closeFriend) throws Exception{
        URL url = new URL("http://localhost:5003/FriendshipServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'POST' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        os.write(new Gson().toJson(new Friendship(userId,friendUserId,closeFriend)).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public void removeFriend(int friendshipId) throws Exception {
        HttpURLConnection con;
        String url = "http://localhost:5003/FriendshipServer/"+friendshipId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("DELETE");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'DELETE' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

    }

    @Override
    public Friendship getFriendship(int friendshipId) throws Exception {
        HttpURLConnection con;
        String url = "http://localhost:5003/FriendshipServer/"+friendshipId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new Gson().fromJson(response.toString(), Friendship.class);
    }

    @Override
    public void createGroup(String groupName, String groupCreator) throws Exception {
        URL url = new URL("http://localhost:5003/GroupChatServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'POST' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        String groupJson=new Gson().toJson(new GroupChat(groupName));
        System.out.println(groupJson);
        os.write(groupJson.getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());

        ArrayList<GroupChat> groupChats=getAllGroupChats();
        int groupId=groupChats.get(groupChats.size()-1).id;
        Participant participant=new Participant(groupCreator,true,groupId);
        participant.setUser(groupCreator);
        addParticipant(participant);

        Message message=new Message("Server", groupCreator+" just created the group on date "+ LocalDate.now());
        message.setGroupChatId(groupId);
        sendMessage(message);
    }



    @Override
    public void addParticipant(Participant participant) throws Exception{
        URL url = new URL("http://localhost:5003/ParticipantServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'POST' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        System.out.println(new Gson().toJson(participant));
        os.write(new Gson().toJson(participant).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public void removeParticipant(int participantId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/ParticipantServer/"+participantId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("DELETE");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'DELETE' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

    }

    @Override
    public void forwardMessage(Message message, int forwardedMessageId) throws Exception{
        message.setForwardedMessageId(forwardedMessageId);
        message.setText(getMessage(forwardedMessageId).getText());

        sendMessage(message);
    }

    @Override
    public void pinMessage(int messageId) throws Exception{
        URL url = new URL("http://localhost:5003/MessageServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'PUT' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        Message message=getMessage(messageId);
        message.setPinnedMessageProperty(true);
        System.out.println(new Gson().toJson(message));
        os.write(new Gson().toJson(message).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public ArrayList<GroupChat> getAllGroupChats() throws Exception {
        HttpURLConnection con;
        String url = "http://localhost:5003/GroupChatServer/";
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), GroupChat[].class)));
    }

    @Override
    public User getUserFromId(int userId) throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/ById/"+userId;
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new Gson().fromJson(response.toString(), User.class);
    }

    @Override
    public void addPrivateChat(PrivateChat privateChat) throws Exception {
        URL url = new URL("http://localhost:5003/PrivateChatServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'POST' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        System.out.println(new Gson().toJson(privateChat));
        os.write(new Gson().toJson(privateChat).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public ArrayList<PrivateChat> getAllPrivateChats() throws Exception{
        HttpURLConnection con;
        String url = "http://localhost:5003/PrivateChatServer/";
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print

        return new ArrayList<>(Arrays.asList(new Gson().fromJson(response.toString(), PrivateChat[].class)));
    }
}
