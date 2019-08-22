package ncku.edu.tw.kr_chatappication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ncku.edu.tw.kr_chatappication.ItemView.CircleOfFriendsItem;
import ncku.edu.tw.kr_chatappication.ItemView.FriendChatItem;
import ncku.edu.tw.kr_chatappication.ItemView.SearchViewItem;
import ncku.edu.tw.kr_chatappication.ItemView.ViewType;
import ncku.edu.tw.kr_chatappication.R;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<ViewType> list;
    Context mContext;
    private static int NO_TYPE = 0;
    private static int TYPE_SEARCHVIEW = 1;
    private static int TYPE_CircleOfFriends = 2;
    private static int TYPE_FRIENDCHAT = 3;

    public MainAdapter(Context context, List<ViewType> list) {
        this.mContext = context;
        this.list = list;
    }

    //檢查是要用哪一個View
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_SEARCHVIEW){
            SearchViewItem searchViewItem = (SearchViewItem) list.get(position);
            bindToSearchItem(searchViewItem);
        } else if(getItemViewType(position) == TYPE_CircleOfFriends) {
            CircleOfFriendsItem circleOfFriendsItem = (CircleOfFriendsItem) list.get(position);
            bindToCircleOfFriendsItem(circleOfFriendsItem);
        } else if(getItemViewType(position) == TYPE_FRIENDCHAT) {
            FriendChatItem friendChat = (FriendChatItem) list.get(position);
            bindToFriendChatItem(friendChat);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if(viewType  == TYPE_SEARCHVIEW){
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_seach_view, viewGroup, false);
            return new SearchViewHolder(view);
        } else if(viewType  == TYPE_CircleOfFriends) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_circle_of_friend, viewGroup, false);
            return new CircleOfFriendsViewHolder(view);
        } else if(viewType  == TYPE_FRIENDCHAT) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_friend_view, viewGroup, false);
            return new FriendChatViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof SearchViewItem){
            return TYPE_SEARCHVIEW;
        } else if(list.get(position) instanceof CircleOfFriendsItem){
            return TYPE_CircleOfFriends;
        } else if(list.get(position) instanceof FriendChatItem){
            return TYPE_FRIENDCHAT;
        } else {
            return NO_TYPE;
        }
    }

    public void addItem(ViewType viewType) {
        list.add(viewType);
        notifyDataSetChanged();
    }

    public void bindToSearchItem(SearchViewItem searchView) {

    }

    public void bindToCircleOfFriendsItem(CircleOfFriendsItem friendChat) {

    }

    public void bindToFriendChatItem(FriendChatItem friendChat) {

    }

    class SearchViewHolder extends RecyclerView.ViewHolder{

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    class CircleOfFriendsViewHolder extends RecyclerView.ViewHolder{

        public CircleOfFriendsViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    class FriendChatViewHolder extends RecyclerView.ViewHolder{

        public FriendChatViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
