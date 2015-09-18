package com.example.kotchaphan.floatinglabeledittext;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editUsername;
    private TextInputLayout inputUserLayout;
    private EditText editPassword;
    private TextInputLayout inputPasswordLayout;
    private EditText editEmail;
    private TextInputLayout inputEmailLayout;
    private CoordinatorLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();
        setSupportActionBar(toolbar);


        inputUserLayout.setErrorEnabled(true);
        inputUserLayout.setError("max than 2 chars");

        inputPasswordLayout.setErrorEnabled(true);
        inputPasswordLayout.setError("max than 4 chars");

        inputEmailLayout.setErrorEnabled(true);

        editUsername.addTextChangedListener(new TextCheck(editUsername));
        editPassword.addTextChangedListener(new TextCheck(editPassword));
        editEmail.addTextChangedListener(new TextCheck(editEmail));

    }

    public void initialView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        inputUserLayout = (TextInputLayout) findViewById(R.id.inputUsernameLayout);
        editUsername = (EditText) findViewById(R.id.edtUsername);
        editPassword = (EditText) findViewById(R.id.edtPassword);
        editEmail = (EditText) findViewById(R.id.edtEmail);
        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);
        inputPasswordLayout = (TextInputLayout) findViewById(R.id.inputPasswordLayout);
        inputEmailLayout = (TextInputLayout) findViewById(R.id.inputEmailLayout);
    }

    public String validInput() {
        String isValid = "";
        String pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$";
        //pattern obj
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(editEmail.getText().toString());

        Log.i("Matcher", matcher.matches() + "");

        if (editUsername.getText().toString().trim().equals("") || editUsername.getText().toString().trim().length() <= 2)
            isValid += "user";
        if (editPassword.getText().toString().trim().equals("") || editPassword.getText().toString().trim().length() <= 2)
            isValid += " password";
        if (editEmail.getText().toString().trim().equals("") || editEmail.getText().toString().trim().length() <= 2 || !matcher.matches())
            isValid += " email";
        return isValid;
    }

    class TextCheck implements TextWatcher {
        private View view;

        public TextCheck(View vView) {
            this.view = vView;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = validInput();
            int id = view.getId();
            switch (id) {
                case R.id.edtUsername:
                    if (str.contains("user"))
                        editUsername.setError("Required");
                    break;
                case R.id.edtPassword:
                    if (str.contains("password"))
                        editPassword.setError("Required");
                    break;
                case R.id.edtEmail:
                    if (str.contains("email"))
                        editEmail.setError("Required or Invalid email");
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
