package model;

public class ForwardedMessage extends Message{
    private final boolean forwarded;
    public ForwardedMessage(String senderUsername, String text,boolean forwarded) {
        super(senderUsername, text);
        this.forwarded=forwarded;
    }

    public boolean isForwarded() {
        return forwarded;
    }
}
