package eg.edu.edraak.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    double input0, input1, result;
    boolean addition, subtraction, multiplication, division;

    Button one,two,three,four,five,six,seven,eight,nine,zero,d_zero,decimal;
    Button sum,sub,mul,div;
    Button del,equal;

    TextView screen;
    String currentScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one  = findViewById(R.id.one_btn);
        two = findViewById(R.id.two_btn);
        three = findViewById(R.id.three_btn);
        four= findViewById(R.id.four_btn);
        five = findViewById(R.id.five_btn);
        six = findViewById(R.id.six_btn);
        seven = findViewById(R.id.seven_btn);
        eight = findViewById(R.id.eight_btn);
        nine = findViewById(R.id.nine_btn);
        zero = findViewById(R.id.zero_btn);
        d_zero = findViewById(R.id.doubleZero_btn);
        decimal = findViewById(R.id.decimalPoint_btn);
        sum = findViewById(R.id.addition_btn);
        sub = findViewById(R.id.subtraction_btn);
        mul = findViewById(R.id.multiplication_btn);
        div = findViewById(R.id.division_btn);
        del = findViewById(R.id.delete_btn);
        equal = findViewById(R.id.equal_btn);

        one.setOnClickListener(new View.OnClickListener()       {@Override public void onClick(View v) {screen.setText(screen.getText() + "1");}});
        two.setOnClickListener(new View.OnClickListener()       {@Override public void onClick(View v) {screen.setText(screen.getText() + "2");}});
        three.setOnClickListener(new View.OnClickListener()     {@Override public void onClick(View v) {screen.setText(screen.getText() + "3");}});
        four.setOnClickListener(new View.OnClickListener()      {@Override public void onClick(View v) {screen.setText(screen.getText() + "4");}});
        five.setOnClickListener(new View.OnClickListener()      {@Override public void onClick(View v) {screen.setText(screen.getText() + "5");}});
        six.setOnClickListener(new View.OnClickListener()       {@Override public void onClick(View v) {screen.setText(screen.getText() + "6");}});
        seven.setOnClickListener(new View.OnClickListener()     {@Override public void onClick(View v) {screen.setText(screen.getText() + "7");}});
        eight.setOnClickListener(new View.OnClickListener()     {@Override public void onClick(View v) {screen.setText(screen.getText() + "8");}});
        nine.setOnClickListener(new View.OnClickListener()      {@Override public void onClick(View v) {screen.setText(screen.getText() + "9");}});
        zero.setOnClickListener(new View.OnClickListener()      {@Override public void onClick(View v) {screen.setText(screen.getText() + "0");}});
        d_zero.setOnClickListener(new View.OnClickListener()    {@Override public void onClick(View v) {screen.setText(screen.getText() + "00");}});
        decimal.setOnClickListener(new View.OnClickListener()   {@Override public void onClick(View v) {screen.setText(screen.getText() + ".");}});

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScreen = screen.getText().toString();
                screen.setText(currentScreen.substring(0,currentScreen.length() - 1));
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0 = Double.parseDouble((String) screen.getText());
                screen.setText("");
                addition = true;
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0 = Double.parseDouble((String) screen.getText());
                screen.setText("");
                subtraction = true;
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0 = Double.parseDouble((String) screen.getText());
                screen.setText("");
                multiplication = true;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0 = Double.parseDouble((String) screen.getText());
                screen.setText("");
                division = true;
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Double.parseDouble((String) screen.getText());

                if (addition){
                    result = input0 + input1;
                    screen.setText(String.valueOf(result));
                }//end if 1
                else if (subtraction){
                    result = input0 - input1;
                    screen.setText(String.valueOf(result));
                }//end else if 2
                else if(multiplication){
                    result = input0 * input1;
                    screen.setText(String.valueOf(result));
                }//end else if 3
                else if(division){
                    if (input1 != 0){
                        result = input0 / input1;
                        screen.setText(String.valueOf(result));
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Not Allowed",Toast.LENGTH_LONG).show();
                    }
                }//end else if 4
            }
        });
    }//end onCreate()
}//end class
