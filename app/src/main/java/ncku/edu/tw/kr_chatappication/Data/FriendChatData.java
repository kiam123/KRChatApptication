package ncku.edu.tw.kr_chatappication.Data;

public class FriendChatData {
    String id, content;
    int type;

    public FriendChatData(int type, String content){
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
