package d.aninterface;

public class Message {
    public static final int RECEIVED = 0;
    public static final int SENT = 1;

    private String content;
    private int type;
    private int profile_photo;

    public Message(String content, int type, int profile_photo) {
        this.content = content;
        this.type = type;
        this.profile_photo = profile_photo;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getProfile_photo() {
        return profile_photo;
    }
}
