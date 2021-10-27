package model;

public class MentionMessage extends Message{
    private final String mentionedUsername;

    public MentionMessage(String senderUsername, String text,String mentionedUsername) {
        super(senderUsername, text);
        this.mentionedUsername=mentionedUsername;
    }

    public String getMentionedUsername() {
        return mentionedUsername;
    }
}
