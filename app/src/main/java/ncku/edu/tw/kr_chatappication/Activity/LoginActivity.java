package ncku.edu.tw.kr_chatappication.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import ncku.edu.tw.kr_chatappication.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtAccount, edtPassword;
    Button btnLogin, btnRegister;
    CheckBox chkRememberPassword;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.sharedprefs";
    String account = null, password = null;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtAccount = (EditText) findViewById(R.id.edtAccount);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        chkRememberPassword = (CheckBox) findViewById(R.id.chkRememberPassword);

        btnLogin.setOnClickListener(loginListener);
        btnRegister.setOnClickListener(registerListener);

        mPreferences = getSharedPreferences(
                sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        check = mPreferences.getBoolean("check", false);
        if (check) {
            account = mPreferences.getString("account", null);
            password = mPreferences.getString("password", null);
        }
    }

    View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (chkRememberPassword.isChecked()) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString("account", edtAccount.getText().toString());
                preferencesEditor.putString("password", edtPassword.getText().toString());
                preferencesEditor.putBoolean("check", true);
                preferencesEditor.apply();
            }
        }
    };

    View.OnClickListener registerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    public boolean loginCheck(String account, String password) {
//        if(account )

        return false;
    }

}
