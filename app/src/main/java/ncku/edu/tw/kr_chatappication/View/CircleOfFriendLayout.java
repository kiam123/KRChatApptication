package ncku.edu.tw.kr_chatappication.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import ncku.edu.tw.kr_chatappication.R;

public class CircleOfFriendLayout extends RelativeLayout {
    private final View mView;

    public CircleOfFriendLayout(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.recycler_view_layout_circle_of_friend, null);
        addView(mView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }
}