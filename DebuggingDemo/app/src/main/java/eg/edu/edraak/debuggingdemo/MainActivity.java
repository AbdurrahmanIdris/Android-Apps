package eg.edu.edraak.debuggingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button print;
    TextView values;
    String [] value = {"One","Two","Three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print = findViewById(R.id.printArrayBtn);
        values = findViewById(R.id.arrayTextView);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueString = "Values are: " ;
                for (int i = 0; i < value.length; i++){
                    valueString += value[i] + ", ";
                }//end for
                values.setText(valueString);
            }//end of onClick
        });
    }//end onCreate
}//end class MainActivity
