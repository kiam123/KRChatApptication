package ncku.edu.tw.kr_chatappication.ItemView;

public class FriendChatItem implements ViewType {
    String id;
    String name;
    String chatContent;

    public FriendChatItem() {
    }

    public FriendChatItem(String id, String name, String chatContent) {
        this.id = id;
        this.name = name;
        this.chatContent = chatContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }
}
