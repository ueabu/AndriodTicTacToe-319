package com.example.umaabu.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    boolean Player1 = true;
    int count = 0;

    Button b00;
    Button b01;
    Button b02;

    Button b10;
    Button b11;
    Button b12;

    Button b20;
    Button b21;
    Button b22;

    Button Reset;
    int[][] BoardStatus = new int[3][3];

    TextView GameStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        Reset = (Button) findViewById(R.id.bReset);
        Reset.setOnClickListener(this);

        GameStatus = (TextView) findViewById(R.id.GameStatus);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);

        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        initializeBoardStatus();
    }

    public void onClick(View view) {
        boolean ResetButton = false;

        switch (view.getId()) {
            case R.id.b00:
                if (Player1) {
                    b00.setText("X");
                    BoardStatus[0][0] = 1;
                } else {
                    b00.setText("O");
                    BoardStatus[0][0] = 0;
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if (Player1) {
                    b01.setText("X");
                    BoardStatus[0][1] = 1;
                } else {
                    b01.setText("O");
                    BoardStatus[0][1] = 0;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if (Player1) {
                    b02.setText("X");
                    BoardStatus[0][2] = 1;
                } else {
                    b02.setText("O");
                    BoardStatus[0][2] = 0;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if (Player1) {
                    b10.setText("X");
                    BoardStatus[1][0] = 1;
                } else {
                    b10.setText("O");
                    BoardStatus[1][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if (Player1) {
                    b11.setText("X");
                    BoardStatus[1][1] = 1;
                } else {
                    b11.setText("O");
                    BoardStatus[1][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if (Player1) {
                    b12.setText("X");
                    BoardStatus[1][2] = 1;
                } else {
                    b12.setText("O");
                    BoardStatus[1][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if (Player1) {
                    b20.setText("X");
                    BoardStatus[2][0] = 1;
                } else {
                    b20.setText("O");
                    BoardStatus[2][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if (Player1) {
                    b21.setText("X");
                    BoardStatus[2][1] = 1;
                } else {
                    b21.setText("O");
                    BoardStatus[2][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if (Player1) {
                    b22.setText("X");
                    BoardStatus[2][2] = 1;
                } else {
                    b22.setText("O");
                    BoardStatus[2][2] = 0;
                }
                b22.setEnabled(false);
                break;

            case R.id.bReset:
                ResetButton = true;
                break;

            default:
                break;

        }

        if (ResetButton) {
            resetBoard();
        } else {
            count++;
            Player1 = !Player1;
            if (Player1) {
                SetGameStatus("Player X turn");
            } else {
                SetGameStatus("Player O turn");
            }

            if (count == 9) {
                result("Draw");
            }


            CheckWinner();
        }


    }

    private void CheckWinner() {

        //Horizontal --- rows
        for (int i = 0; i < 3; i++) {
            if (BoardStatus[i][0] == BoardStatus[i][1] && BoardStatus[i][0] == BoardStatus[i][2]) {
                if (BoardStatus[i][0] == 1) {
                    result("Player X winner\n" + (i + 1) + " row");
                    break;
                } else if (BoardStatus[i][0] == 0) {
                    result("Player 0 winner\n" + (i + 1) + " row");
                    break;
                }
            }
        }

        //Vertical --- columns
        for (int i = 0; i < 3; i++) {
            if (BoardStatus[0][i] == BoardStatus[1][i] && BoardStatus[0][i] == BoardStatus[2][i]) {
                if (BoardStatus[0][i] == 1) {
                    result("Player X winner\n" + (i + 1) + " column");
                    break;
                } else if (BoardStatus[0][i] == 0) {
                    result("Player 0 winner\n" + (i + 1) + " column");
                    break;
                }
            }
        }

        //First diagonal
        if (BoardStatus[0][0] == BoardStatus[1][1] && BoardStatus[0][0] == BoardStatus[2][2]) {
            if (BoardStatus[0][0] == 1) {
                result("Player X winner\nFirst Diagonal");
            } else if (BoardStatus[0][0] == 0) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //Second diagonal
        if (BoardStatus[0][2] == BoardStatus[1][1] && BoardStatus[0][2] == BoardStatus[2][0]) {
            if (BoardStatus[0][2] == 1) {
                result("Player X winner\nSecond Diagonal");
            } else if (BoardStatus[0][2] == 0) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }


    private void result(String Info){
        SetGameStatus(Info);
        enableAllBoxes(false);
    }

    private void SetGameStatus(String info) {
        GameStatus.setText(info);
    }

    private void enableAllBoxes(boolean value) {
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);

        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);

        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }

    private void resetBoard() {
        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");

        enableAllBoxes(true);

        Player1 = true;
        count = 0;

        initializeBoardStatus();
        SetGameStatus("Play again");
    }

    private void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                BoardStatus[i][j] = -1;
            }
        }


    }
}