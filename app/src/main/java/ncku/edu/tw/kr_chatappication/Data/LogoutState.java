package ncku.edu.tw.kr_chatappication.Data;

import android.content.Context;
import android.content.Intent;

import ncku.edu.tw.kr_chatappication.Activity.LoginActivity;

/**
 * Created by yuhong on 2017/10/12.
 */

public class LogoutState implements UserState {

    @Override
    public void forward(Context context) {
        gotoLoginActivity(context);
    }

    @Override
    public void commend(Context context) {
        gotoLoginActivity(context);
    }

    @Override
    public void setAccount(String account) {
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public String getAccount() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    private void gotoLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
