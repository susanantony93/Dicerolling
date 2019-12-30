package com.example.dicerolling;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity  {

    //defining the objects
    private ImageView diceimage1;
    private ImageView diceimage2;
    private ImageView diceimage3;
    private ImageView diceimage4;
    private ImageView diceimage5;
    private ImageView diceimage6;
    private Button rollbutton;
    EditText count;
    private int finalValue;
    private Random randnumber = new Random();
    private SensorManager sm;
    private float val;
    private float last;
    private float shake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//tagging the imageviews to the dice pictures
        diceimage1 = findViewById(R.id.dice1);
        diceimage2 = findViewById(R.id.dice2);
        diceimage3 = findViewById(R.id.dice3);
        diceimage4 = findViewById(R.id.dice4);
        diceimage5 = findViewById(R.id.dice5);
        diceimage6 = findViewById(R.id.dice6);
        rollbutton = findViewById(R.id.button);
        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand1, rand2, rand3, rand4, rand5, rand6, res1, res2, res3, res4, res5, res6;

                //the value entered by user is saved as count
                count = (EditText) findViewById(R.id.dicecount);
                String value = count.getText().toString();

               //converting string to integer
                finalValue = Integer.parseInt(value);

               //handling different values from1 to 6 to show the respective number of dice
                switch (finalValue) {
                    case 1:
                        rand1 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.INVISIBLE);
                        diceimage3.setVisibility(View.INVISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.INVISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 4:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.VISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 5:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        rand5 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        res5 = getResources().getIdentifier("dice_" + rand5, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage5.setImageResource(res5);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.VISIBLE);
                        diceimage5.setVisibility(View.VISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 6:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        rand5 = RollDice();
                        rand6 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        res5 = getResources().getIdentifier("dice_" + rand5, "drawable", "com.example.dicerolling");
                        res6 = getResources().getIdentifier("dice_" + rand6, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage5.setImageResource(res5);
                        diceimage6.setImageResource(res6);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.VISIBLE);
                        diceimage5.setVisibility(View.VISIBLE);
                        diceimage6.setVisibility(View.VISIBLE);
                        break;

                    default:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        rand5 = RollDice();
                        rand6 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        res5 = getResources().getIdentifier("dice_" + rand5, "drawable", "com.example.dicerolling");
                        res6 = getResources().getIdentifier("dice_" + rand6, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage5.setImageResource(res5);
                        diceimage6.setImageResource(res6);
                        diceimage1.setVisibility(View.INVISIBLE);
                        diceimage2.setVisibility(View.INVISIBLE);
                        diceimage3.setVisibility(View.INVISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        Toast toast=Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_SHORT);
                        toast.show();
                        break;


                }

            }
        });

        //accelerometer to detect shake
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        val = SensorManager.GRAVITY_EARTH;
        last = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

    }

    //function to create random number from 1 to 6
    private int RollDice() {

        int randnum = randnumber.nextInt(6) + 1;
        return randnum;


    }

    //function to listen to the shake
    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            last = val;
            val = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = val-last;
            shake = shake* 0.9f + delta;
            if(shake>12)
            {

                int rand1, rand2, rand3, rand4, rand5, rand6, res1, res2, res3, res4, res5, res6;
                count = (EditText) findViewById(R.id.dicecount);
                String value = count.getText().toString();
                finalValue = Integer.parseInt(value);

                //handling the number of dice entered by user to show the respective number of dice
                switch (finalValue) {
                    case 1:
                        rand1 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.INVISIBLE);
                        diceimage3.setVisibility(View.INVISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.INVISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 4:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.VISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 5:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        rand5 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        res5 = getResources().getIdentifier("dice_" + rand5, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage5.setImageResource(res5);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.VISIBLE);
                        diceimage5.setVisibility(View.VISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);
                        break;

                    case 6:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        rand5 = RollDice();
                        rand6 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        res5 = getResources().getIdentifier("dice_" + rand5, "drawable", "com.example.dicerolling");
                        res6 = getResources().getIdentifier("dice_" + rand6, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage5.setImageResource(res5);
                        diceimage6.setImageResource(res6);
                        diceimage1.setVisibility(View.VISIBLE);
                        diceimage2.setVisibility(View.VISIBLE);
                        diceimage3.setVisibility(View.VISIBLE);
                        diceimage4.setVisibility(View.VISIBLE);
                        diceimage5.setVisibility(View.VISIBLE);
                        diceimage6.setVisibility(View.VISIBLE);
                        break;

                    default:
                        rand1 = RollDice();
                        rand2 = RollDice();
                        rand3 = RollDice();
                        rand4 = RollDice();
                        rand5 = RollDice();
                        rand6 = RollDice();
                        res1 = getResources().getIdentifier("dice_" + rand1, "drawable", "com.example.dicerolling");
                        res2 = getResources().getIdentifier("dice_" + rand2, "drawable", "com.example.dicerolling");
                        res3 = getResources().getIdentifier("dice_" + rand3, "drawable", "com.example.dicerolling");
                        res4 = getResources().getIdentifier("dice_" + rand4, "drawable", "com.example.dicerolling");
                        res5 = getResources().getIdentifier("dice_" + rand5, "drawable", "com.example.dicerolling");
                        res6 = getResources().getIdentifier("dice_" + rand6, "drawable", "com.example.dicerolling");
                        diceimage1.setImageResource(res1);
                        diceimage2.setImageResource(res2);
                        diceimage3.setImageResource(res3);
                        diceimage4.setImageResource(res4);
                        diceimage5.setImageResource(res5);
                        diceimage6.setImageResource(res6);
                        diceimage1.setVisibility(View.INVISIBLE);
                        diceimage2.setVisibility(View.INVISIBLE);
                        diceimage3.setVisibility(View.INVISIBLE);
                        diceimage4.setVisibility(View.INVISIBLE);
                        diceimage5.setVisibility(View.INVISIBLE);
                        diceimage6.setVisibility(View.INVISIBLE);

                        //to show invalid input if user enters more than 6
                        Toast toast=Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_SHORT);
                        toast.show();
                        break;



                }

            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


}
