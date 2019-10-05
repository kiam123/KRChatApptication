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
import ncku.edu.tw.kr_chatappication.Data.CircleOfFriendListData;
import ncku.edu.tw.kr_chatappication.R;


public class CircleOfFriendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ArrayList list;

    public CircleOfFriendAdapter(Context mContext) {
        this.mContext = mContext;
        this.list = new ArrayList<CircleOfFriendListData>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new FriendChatViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.recycler_view_layout_circle_of_friend, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        CircleOfFriendListData friendChatData = (CircleOfFriendListData) list.get(position);
        ((FriendChatViewHolder) viewHolder).bindToFriendChatData(friendChatData);
    }



    public void addItem(CircleOfFriendListData friendChatData) {
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

        public void bindToFriendChatData(CircleOfFriendListData friendChatData) {

        }

        @Override
        public void onClick(View view) {
            CircleOfFriendListData tempList = (CircleOfFriendListData) list.get(getLayoutPosition());

            Intent intent = new Intent();
            intent.setClass(mContext, FriendChatActivity.class);
            intent.putExtra("position", "" + getLayoutPosition());
            mContext.startActivity(intent);
        }
    }
}