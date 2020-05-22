package eg.edu.edraak.intenthandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendMessage;
    Button call;
    EditText mobileNumber;
    EditText messageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessage = findViewById(R.id.sendBtn);
        call = findViewById(R.id.callBtn);
        mobileNumber = findViewById(R.id.mobileNumberText);
        messageBody = findViewById(R.id.messageText);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address",    new String(mobileNumber.getText().toString()));
                    i.putExtra("sms-body", new String(messageBody.getText().toString()));
                    startActivity(Intent.createChooser(i,"Send sms via:"));
                }//end try
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
                }//end catch
            }//end onClick
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = mobileNumber.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phoneNumber,null));
                startActivity(callIntent);
            }//end onClick
        });

    }//end onCreate
}//end class
