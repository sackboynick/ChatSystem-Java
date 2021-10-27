package model;

public class ReplyMessage extends Message{
    private final Message reply;
    public ReplyMessage(String senderUsername, String text,Message reply) {
        super(senderUsername, text);
        this.reply=reply;
    }

    public Message getReply() {
        return reply;
    }
}
