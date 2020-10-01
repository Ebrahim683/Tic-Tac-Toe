package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Importing variable

    TextView topTx;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnR;
    int[] fill_position = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] win_position = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean game_active = true;
    int player_o = 0;
    int player_x = 1;
    int active_player = player_o;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Finding ID

        topTx = findViewById(R.id.topT);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btnR = findViewById(R.id.btnR);


        //Set Listener

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);


    }

    //Listener

    @Override
    public void onClick(View v) {

        //Button clicked and work
        Button clickedButton = findViewById(v.getId());
        //Get tha Tag and work
        int clickedTag = Integer.parseInt(v.getTag().toString());

        //Game start
        if (!game_active) {
            return;
        }

        //Do not work clicked button before reset
        {
            if (fill_position[clickedTag] != 2) {
                return;
            }else {
                fill_position[clickedTag] = active_player;
            }
        }


            //Player's Turn
        {
            if (active_player == 0) {
                clickedButton.setText("O");
                topTx.setText("X Turn");
                active_player = 1;
            }else {
                clickedButton.setText("X");
                topTx.setText("O Turn");
                active_player = 0;
            }
        }


        //Winner Declare
        winner();
        reset();







    }
    //Winner Selection Logic
    private void winner(){


        //Winning position selection
        for (int i =0; i<win_position.length; i++){

            int val0 = win_position[i][0];
            int val1 = win_position[i][1];
            int val2 = win_position[i][2];

            if (fill_position[val0]!=2 && fill_position[val0]==fill_position[val1] && fill_position[val1]==fill_position[val2]){

                if (fill_position[val0]==0){
                    topTx.setText("Winner Is O");
                }else if(fill_position[val0]==1){
                    topTx.setText("Winner Is X");
                }
                game_active = false;
            }
            //Draw Logic
            else if (fill_position[0]!=2 && fill_position[1]!=2 && fill_position[2]!=2 && fill_position[3]!=2 && fill_position[4]!=2 && fill_position[5]!=2 && fill_position[6]!=2 && fill_position[7]!=2 && fill_position[8]!=2){

                if (fill_position[val0]!=fill_position[val1] && fill_position[val1]!=fill_position[val2]){
                    topTx.setText("Draw");
                }

            }


        }



    }


    //Reset Game
    private void reset(){

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                game_active =true;
                fill_position = new int[] {2,2,2,2,2,2,2,2,2};
                btn0.setText("");
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                topTx.setText("Play Again");
                active_player = 0;
            }
        });

    }





}
