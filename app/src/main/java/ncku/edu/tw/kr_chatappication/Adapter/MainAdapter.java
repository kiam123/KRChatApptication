package ncku.edu.tw.kr_chatappication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ncku.edu.tw.kr_chatappication.Activity.FriendChatActivity;
import ncku.edu.tw.kr_chatappication.Activity.SearchActivity;
import ncku.edu.tw.kr_chatappication.Data.CircleOfFriendListData;
import ncku.edu.tw.kr_chatappication.ItemView.CircleOfFriendsItem;
import ncku.edu.tw.kr_chatappication.ItemView.FriendChatItem;
import ncku.edu.tw.kr_chatappication.ItemView.SearchViewItem;
import ncku.edu.tw.kr_chatappication.ItemView.ViewType;
import ncku.edu.tw.kr_chatappication.R;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ViewType> list;
    Context mContext;
    private static int NO_TYPE = 0;
    private static int TYPE_SEARCHVIEW = 1;
    private static int TYPE_CircleOfFriends = 2;
    private static int TYPE_FRIENDCHAT = 3;


    public MainAdapter(Context context) {
        this.mContext = context;
        this.list = new ArrayList<>();
    }

    //檢查是要用哪一個View
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == TYPE_SEARCHVIEW) {
            SearchViewItem searchViewItem = (SearchViewItem) list.get(position);
            ((SearchViewHolder)viewHolder).bindToSearchItem(searchViewItem);
        } else if (getItemViewType(position) == TYPE_CircleOfFriends) {
            CircleOfFriendsItem circleOfFriendsItem = (CircleOfFriendsItem) list.get(position);
            ((CircleOfFriendsViewHolder)viewHolder).bindToCircleOfFriendsItem(circleOfFriendsItem);
        } else if (getItemViewType(position) == TYPE_FRIENDCHAT) {
            FriendChatItem friendChat = (FriendChatItem) list.get(position);
            ((FriendChatViewHolder)viewHolder).bindToFriendChatItem(friendChat);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        android.view.View view;
        if (viewType == TYPE_SEARCHVIEW) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_seach_view, viewGroup, false);
            return new SearchViewHolder(view);
        } else if (viewType == TYPE_CircleOfFriends) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_circle_of_friend, viewGroup, false);
            return new CircleOfFriendsViewHolder(view);
        } else if (viewType == TYPE_FRIENDCHAT) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_friend_list_view, viewGroup, false);
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
        if (list.get(position) instanceof SearchViewItem) {
            return TYPE_SEARCHVIEW;
        } else if (list.get(position) instanceof CircleOfFriendsItem) {
            return TYPE_CircleOfFriends;
        } else if (list.get(position) instanceof FriendChatItem) {
            return TYPE_FRIENDCHAT;
        } else {
            return NO_TYPE;
        }
    }

    public void addItem(ViewType view) {
        list.add(view);
        notifyDataSetChanged();
    }


    class SearchViewHolder extends RecyclerView.ViewHolder {
        Button searchButton;
        public SearchViewHolder(@NonNull android.view.View itemView) {
            super(itemView);
            searchButton = (Button) itemView.findViewById(R.id.search);
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, SearchActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindToSearchItem(SearchViewItem searchView) {

        }
    }

    class CircleOfFriendsViewHolder extends RecyclerView.ViewHolder {
//        ViewPager viewpager;
        RecyclerView recyclerView;

        public CircleOfFriendsViewHolder(@NonNull android.view.View itemView) {
            super(itemView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

            CircleOfFriendAdapter circleOfFriendAdapter = new CircleOfFriendAdapter(mContext);
            recyclerView.setAdapter(circleOfFriendAdapter);

            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
            circleOfFriendAdapter.addItem(new CircleOfFriendListData());
        }

        public void bindToCircleOfFriendsItem(CircleOfFriendsItem friendChat) {

        }
    }

    class FriendChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public FriendChatViewHolder(@NonNull android.view.View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }

        public void bindToFriendChatItem(FriendChatItem friendChat) {

        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.setClass(mContext, FriendChatActivity.class);
            intent.putExtra("position", "" + getLayoutPosition());
            mContext.startActivity(intent);
        }
    }


}
