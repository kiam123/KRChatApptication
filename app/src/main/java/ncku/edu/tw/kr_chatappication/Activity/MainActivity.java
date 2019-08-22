package ncku.edu.tw.kr_chatappication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ncku.edu.tw.kr_chatappication.Adapter.MainAdapter;
import ncku.edu.tw.kr_chatappication.ItemView.FriendChatItem;
import ncku.edu.tw.kr_chatappication.ItemView.SearchViewItem;
import ncku.edu.tw.kr_chatappication.ItemView.ViewType;
import ncku.edu.tw.kr_chatappication.R;

public class MainActivity extends AppCompatActivity {
    MainAdapter mainAdapter;
    RecyclerView recyclerView;
    List<ViewType> viewList;
    SearchViewItem searchView;
    FriendChatItem friendChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListView();
        addView();
    }

    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    public void setListView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewList = new ArrayList<>();
        mainAdapter = new MainAdapter(this, viewList);
        recyclerView.setAdapter(mainAdapter);
    }

    public void addView() {
        searchView = new SearchViewItem();
        friendChat = new FriendChatItem();

        mainAdapter.addItem(friendChat);
        mainAdapter.addItem(searchView);
    }
}
