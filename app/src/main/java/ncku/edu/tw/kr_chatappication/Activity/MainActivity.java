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

import java.util.List;

import ncku.edu.tw.kr_chatappication.Adapter.MainAdapter;
import ncku.edu.tw.kr_chatappication.ItemView.CircleOfFriendsItem;
import ncku.edu.tw.kr_chatappication.ItemView.FriendChatItem;
import ncku.edu.tw.kr_chatappication.ItemView.SearchViewItem;
import ncku.edu.tw.kr_chatappication.ItemView.ViewType;
import ncku.edu.tw.kr_chatappication.R;

public class MainActivity extends AppCompatActivity {
    MainAdapter mainAdapter;
    RecyclerView recyclerView;
    List<ViewType> viewTypeList;
    SearchViewItem searchView;
    FriendChatItem friendChat;
    CircleOfFriendsItem circleOfFriendsItem;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setToolbar();
        setListView();
        addView();
    }

    public void initView() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    public void setListView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mainAdapter);
    }

    public void addView() {
        searchView = new SearchViewItem();
        friendChat = new FriendChatItem();
        circleOfFriendsItem = new CircleOfFriendsItem();

        mainAdapter.addItem(searchView);
        mainAdapter.addItem(circleOfFriendsItem);
        mainAdapter.addItem(friendChat);
    }

    public void setToolbar(){
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add_friends:
                Intent intent = new Intent(this, AddFriendListActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
