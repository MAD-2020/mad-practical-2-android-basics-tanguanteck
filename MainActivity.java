package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button buttonLeft;
    Button buttonMiddle;
    Button buttonRight;
    int randomLocation, Score;
    TextView textScores;
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    final String TAG = "Whack-a-mole!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLeft = (Button) findViewById(R.id.button1);
        buttonMiddle = (Button) findViewById(R.id.button2);
        buttonRight = (Button) findViewById(R.id.button3);
        textScores = (TextView) findViewById(R.id.textView1);


        buttonLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG, "Button Left clicked!");
                if (buttonLeft.getText() == "*"){
                    Score++;
                    Log.v(TAG, "Hit Score added!");
                }
                else{
                    Score--;
                    Log.v(TAG, "Missed, score deducted!");
                }
                textScores.setText(Integer.toString(Score));
                setNewMole();
        }

    });
        buttonMiddle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG, "Button Middle clicked!");
                if (buttonMiddle.getText() == "*"){
                    Score++;
                    Log.v(TAG, "Hit Score added!");
                }
                else{
                    Score--;
                    Log.v(TAG, "Missed, score deducted!");
                }
                textScores.setText(Integer.toString(Score));
                setNewMole();
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG, "Button Right clicked!");
                if (buttonRight.getText() == "*"){
                    Score++;
                    Log.v(TAG, "Hit Score added!");
                }
                else{
                    Score--;
                    Log.v(TAG, "Missed, score deducted!");
                }
                textScores.setText(Integer.toString(Score));
                setNewMole();
            }
        });
        Log.v(TAG, "Finished Pre-Initialisation!");

    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        buttonLeft.setText("O");
        buttonMiddle.setText("O");
        buttonRight.setText("O");
        if (randomLocation == 0){
            buttonLeft.setText("*");
        }
        else if (randomLocation == 1){
            buttonMiddle.setText("*");
        }
        else if (randomLocation == 2){
            buttonRight.setText("*");
        }
    }
}
