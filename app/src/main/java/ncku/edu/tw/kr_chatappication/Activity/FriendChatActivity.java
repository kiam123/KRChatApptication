package ncku.edu.tw.kr_chatappication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ncku.edu.tw.kr_chatappication.Adapter.FriendChatAdapter;
import ncku.edu.tw.kr_chatappication.Data.FriendChatData;
import ncku.edu.tw.kr_chatappication.R;

public class FriendChatActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    EditText edtReply;
    FriendChatAdapter friendChatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_chat);

        initView();
        setToolbar();

        friendChatAdapter = new FriendChatAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(friendChatAdapter);
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));
        friendChatAdapter.addItem(new FriendChatData(2));

//        Intent intent = getIntent();
//        String ac = intent.getStringExtra("position");
//        Toast.makeText(this,ac, Toast.LENGTH_SHORT).show();
    }

    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        edtReply = (EditText) findViewById(R.id.edt_reply);
    }

    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void onSendClick(View view) {
        Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
        friendChatAdapter.addItem(new FriendChatData(1));
        friendChatAdapter.addItem(new FriendChatData(2));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.friend_chat_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
