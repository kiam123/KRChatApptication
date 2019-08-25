package ncku.edu.tw.kr_chatappication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ncku.edu.tw.kr_chatappication.Activity.FriendChatActivity;
import ncku.edu.tw.kr_chatappication.Data.FriendListData;
import ncku.edu.tw.kr_chatappication.R;

public class FriendListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ArrayList list;

    public FriendListAdapter(Context mContext) {
        this.mContext = mContext;
        this.list = new ArrayList<FriendListData>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new FriendChatViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.recycler_view_layout_friend_chat, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        FriendListData friendChatData = (FriendListData)list.get(position);
        bindToFriendChatData(friendChatData);
    }

    public void bindToFriendChatData(FriendListData friendChatData) {

    }

    public void addItem(FriendListData friendChatData) {
        list.add(friendChatData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FriendChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public FriendChatViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            FriendListData tempList = (FriendListData) list.get(getLayoutPosition());

            Intent intent = new Intent();
            intent.setClass(mContext, FriendChatActivity.class);
            intent.putExtra("position",""+getLayoutPosition());
            mContext.startActivity(intent);
        }
    }
}
