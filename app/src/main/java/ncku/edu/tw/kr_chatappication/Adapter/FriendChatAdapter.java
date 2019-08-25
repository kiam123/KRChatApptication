package ncku.edu.tw.kr_chatappication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ncku.edu.tw.kr_chatappication.Data.FriendChatData;
import ncku.edu.tw.kr_chatappication.R;

public class FriendChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ArrayList<FriendChatData> chatList;
    private static int NO_TYPE = 0;
    private static int TYPE_SELF = 1;
    private static int TYPE_OTHER_SIDE = 2;

    public FriendChatAdapter(Context context) {
        mContext = context;
        chatList = new ArrayList<FriendChatData>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == TYPE_SELF) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_friend_chat_self_view, viewGroup, false);
            return new FriendChatSelfViewHolder(view);
        } else if (viewType == TYPE_OTHER_SIDE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_friend_chat_other_side_view, viewGroup, false);
            return new FriendChatOtherSelfViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == TYPE_SELF) {
            FriendChatData friendChatData = (FriendChatData) chatList.get(position);
            bindToSelf(friendChatData);
        } else if (getItemViewType(position) == TYPE_OTHER_SIDE) {
            FriendChatData friendChatData = (FriendChatData) chatList.get(position);
            bindToOtherSide(friendChatData);
        }
    }

    class FriendChatSelfViewHolder extends RecyclerView.ViewHolder {

        public FriendChatSelfViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class FriendChatOtherSelfViewHolder extends RecyclerView.ViewHolder {

        public FriendChatOtherSelfViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void bindToSelf(FriendChatData friendChatData) {

    }

    public void bindToOtherSide(FriendChatData friendChatData) {

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public void addItem(FriendChatData friendChatData) {
        chatList.add(friendChatData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (chatList.get(position).getType() == TYPE_SELF) {
            return TYPE_SELF;
        } else if (chatList.get(position).getType() == TYPE_OTHER_SIDE) {
            return TYPE_OTHER_SIDE;
        } else {
            return NO_TYPE;
        }
    }
}
