package pl.lukaszwiszniewski.hotchpotch;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Switch switchLoginRegister;
    private Button buttonLogin;
    String textFromPreferences ;
    boolean isCheck=false;
    private SharedPreferences sharedPreferences;
    String savedLogin;
    String savedPassword;
    Boolean logedIn=false;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.sharedPreferences_name), Activity.MODE_PRIVATE);

        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        switchLoginRegister = (Switch) findViewById(R.id.switchLoginRegister);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        Log.e("logowanie","metoda onCreate i zmienna logedIn "+logedIn );
       buttonLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               buttonLoginClick();
               if (logedIn){
                   Intent intent = new Intent(getBaseContext(),ActionActivity.class);
                   startActivity(intent);
               }
           }
       });


    }





    public void buttonLoginClick() {
        // Reset errors.
        editTextLogin.setError(null);
        editTextPassword.setError(null);

        // Store values at the time of the login attempt.
        String login = editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        String typedLogin = editTextLogin.getText().toString();
        textFromPreferences = sharedPreferences.getString(typedLogin, "");
        Log.e("logowaniem/rejestracja","wpisane dane: "+login+"   "+password);

        if (switchLoginRegister.isChecked()) {
            if (TextUtils.isEmpty(password)) {
                editTextPassword.setError(getString(R.string.error_field_required));
                focusView = editTextPassword;
                cancel = true;
                Log.e("rejestracja","puste pole hasla");
            }

            // Check for a valid login .
            if (TextUtils.isEmpty(login)) {
                editTextLogin.setError(getString(R.string.error_field_required));
                focusView = editTextLogin;
                cancel = true;
                Log.e("rejestracja","puste pole loginu");
            }

            if (cancel) {
                // There was an error; don't attempt login and focus the first
                // form field with an error.
                focusView.requestFocus();
                Log.e("rejestracja","cos bylo puste");
                logedIn=false;
            } else {
                SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
                String loginAndPassword = login + " " + password;
                preferencesEditor.putString(typedLogin, loginAndPassword);
                preferencesEditor.commit();
                Toast.makeText(this, "Registered new account", Toast.LENGTH_LONG).show();
                logedIn=false;
                Log.e("rejestracja","wszystko wypelnione i konto zalozone");
            }
        }else{
            if (textFromPreferences.equals("")) {
                editTextPassword.setError(getString(R.string.error_incorrect_password));
                editTextLogin.setError(getString(R.string.error_invalid_email));
                Toast.makeText(this, "Account not exist", Toast.LENGTH_LONG).show();
                Log.e("logowanie","nie ma takiego konta");
            }else {
                String string = new String(textFromPreferences);
                String[] splited = string.split(" ");
                savedLogin = splited[0];
                savedPassword = splited[1];
                Log.e("logowanie","dzielenie zapisanych danych na login: "+savedLogin+" i haslo: "+savedPassword);

                // Check for a valid password, if the user entered one.
                if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError(getString(R.string.error_field_required));
                    focusView = editTextPassword;
                    cancel = true;
                    Log.e("logowanie","haslo jest puste "+password);
                }else if ((!password.equals(savedPassword))) {
                    editTextPassword.setError(getString(R.string.error_incorrect_password));
                    focusView = editTextPassword;
                    cancel = true;
                    Log.e("logowanie","haslo jest niepoprawne "+password);
                }

                // Check for a valid login .
                if (TextUtils.isEmpty(login)) {
                    editTextLogin.setError(getString(R.string.error_field_required));
                    focusView = editTextLogin;
                    cancel = true;
                    Log.e("logowanie","login jest pusty " +login);
                } else if (!login.equals(savedLogin)) {
                    editTextLogin.setError(getString(R.string.error_invalid_email));
                    focusView = editTextLogin;
                    cancel = true;
                    Log.e("logowanie","login jest niepoprawny "+login);
                }
                if (cancel) {
                    // There was an error; don't attempt login and focus the first
                    // form field with an error.
                    focusView.requestFocus();
                    Log.e("logowanie","cancel "+logedIn );
                    logedIn=false;
                } else {
                    logedIn = true;
                    Log.e("logowanie","zalogowane"+ logedIn);
                }
            }
        }


    }


}
