package model;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private final String senderusername;
    private String receiverusername;
    private final String localdatetime;
    private String text;
    public Integer forwardedMessageId, repliedMessageId;
    private boolean pinnedMessageProperty;
    private Integer privateChatId,groupChatId;

    public Message(String senderusername, String text){
        this.senderusername = senderusername;
        this.localdatetime =LocalDateTime.now().toString();
        this.text=text;
        this.forwardedMessageId=null;
        this.repliedMessageId=null;
        this.pinnedMessageProperty=false;
        this.privateChatId=null;
        this.groupChatId=null;
    }
    public Message(String senderusername, String receiverusername, String text){
        this.senderusername = senderusername;
        this.receiverusername = receiverusername;
        this.localdatetime =LocalDateTime.now().toString();
        this.text=text;
        this.forwardedMessageId=null;
        this.repliedMessageId=null;
        this.pinnedMessageProperty=false;
        this.privateChatId=null;
        this.groupChatId=null;
    }

    public void setReceiverusername(String receiverusername) {
        this.receiverusername = receiverusername;
    }

    public void setForwardedMessageId(Integer forwardedMessageId) {
        this.forwardedMessageId = forwardedMessageId;
    }

    public void setPrivateChatId(Integer privateChatId) {
        this.privateChatId = privateChatId;
    }

    public void setGroupChatId(Integer groupChatId) {
        this.groupChatId = groupChatId;
    }

    public void setRepliedMessageId(Integer repliedMessageId) {
        this.repliedMessageId = repliedMessageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupChatId(int groupChatId) {
        this.groupChatId = groupChatId;
    }

    public void setPrivateChatId(int privateChatId) {
        this.privateChatId = privateChatId;
    }

    public int getGroupChatId() {
        return groupChatId;
    }

    public int getPrivateChatId() {
        return privateChatId;
    }

    public int getForwardedMessageId() {
        return forwardedMessageId;
    }

    public boolean isPinnedMessageProperty() {
        return pinnedMessageProperty;
    }

    public int getRepliedMessageId() {
        return repliedMessageId;
    }

    public void setForwardedMessageId(int forwardedMessageId) {
        this.forwardedMessageId = forwardedMessageId;
    }

    public void setRepliedMessageId(int repliedMessageId) {
        this.repliedMessageId = repliedMessageId;
    }

    public void setPinnedMessageProperty(boolean pinnedMessageProperty) {
        this.pinnedMessageProperty = pinnedMessageProperty;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getSenderusername() {
        return senderusername;
    }

    public String getLocaldatetime() {
        return localdatetime;
    }

    public String getReceiverusername() {
        return receiverusername;
    }
}
