package model;

import java.util.ArrayList;

public class ChatList {
    private final ArrayList<Chat> chats;

    public ChatList(){
        this.chats=new ArrayList<>();
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }
}
