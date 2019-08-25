package ncku.edu.tw.kr_chatappication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import ncku.edu.tw.kr_chatappication.Adapter.FriendChatAdapter;
import ncku.edu.tw.kr_chatappication.Data.FriendChatData;
import ncku.edu.tw.kr_chatappication.R;

public class FriendChatActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FriendChatAdapter friendChatAdapter = new FriendChatAdapter(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(friendChatAdapter);
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));

//        Intent intent = getIntent();
//        String ac = intent.getStringExtra("position");
//        Toast.makeText(this,ac, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
