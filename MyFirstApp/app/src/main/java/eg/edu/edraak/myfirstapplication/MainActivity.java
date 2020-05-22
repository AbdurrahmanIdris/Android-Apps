package eg.edu.edraak.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText username, password;
    Button ok, cancel;

    String correctUserName = "abdurrahman_idris";
    String correctPassword = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        ok = findViewById(R.id.ok);
        ok.setOnClickListener(this);

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }//end onCreate()

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                String inputUserName = username.getText().toString();
                String inputPassWord = password.getText().toString();

                if (inputUserName.equals(correctUserName) && inputPassWord.equals(correctPassword)){
                    Toast.makeText(this,"Succes",Toast.LENGTH_LONG).show();

                    //save username and password
                    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username_pref ",inputUserName);
                    editor.putString("password_pref ",inputPassWord);
                    editor.commit();

                    //read from shared preferences
                    SharedPreferences readPref = getPreferences(Context.MODE_PRIVATE);
                    String savedUserName = readPref.getString("username_pref ","");
                    Toast.makeText(this,"Username is "+savedUserName,Toast.LENGTH_LONG).show();

                }//end if
                else {
                    Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
                }//end else

                break;
            case R.id.cancel:
                username.setText("");
                password.setText("");
                break;
        }//end switch

    }//end onClick
}//end class
