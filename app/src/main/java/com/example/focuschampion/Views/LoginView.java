package com.example.focuschampion.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.focuschampion.Data.DAOUser;
import com.example.focuschampion.Models.User;
import com.example.focuschampion.R;

public class LoginView extends AppCompatActivity {

    EditText txtLoginNickname, txtLoginPassword;
    Button btnLogin;

    String nickname, password;

    DAOUser daoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        Context self = this;
        daoUser = new DAOUser(this);

        txtLoginNickname = (EditText) findViewById(R.id.txtLoginNickname);
        txtLoginPassword = (EditText) findViewById(R.id.txtLoginPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nickname = txtLoginNickname.getText().toString();
                password = txtLoginPassword.getText().toString();
                //Toast.makeText(self, nickname + "-" + password, Toast.LENGTH_SHORT).show();
                if(emptyField()){
                    Toast.makeText(self, "Empty nickname or password", Toast.LENGTH_SHORT).show();
                }
                else {
                    User user = new User(nickname, password);
                    daoUser.insert(user);
                }
            }
        });
    }

    boolean emptyField(){
        return (nickname.isEmpty() || password.isEmpty());
    }
}