package eg.edu.edraak.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SplashActivity extends Activity implements View.OnClickListener {
    LinearLayout mySplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        mySplash = findViewById(R.id.mySplash);
        mySplash.setOnClickListener(this);
    }//end onCreate()

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"you are on pause",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        //what to do on click
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }//end onClick
}//end class