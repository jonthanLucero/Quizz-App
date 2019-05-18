package com.jlucero.quizapp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizAppActivity extends AppCompatActivity
{

    //Question 1
    EditText edit_answer1;

    //Question 2
    CheckBox check_answer2_op1;
    CheckBox check_answer2_op2;
    CheckBox check_answer2_op3;

    //Question 3
    RadioButton radio_answer3_op1;
    RadioButton radio_answer3_op2;
    RadioButton radio_answer3_op3;

    //Question 4
    EditText edit_answer4;

    //Question 5
    EditText edit_answer5;

    //Resolve Button
    Button btnResolveQuiz;

    int quizzPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);

        setupToolBar();

        edit_answer1 = findViewById(R.id.txtedit_answer1);

        check_answer2_op1 = findViewById(R.id.check_answer2_op1);
        check_answer2_op2 = findViewById(R.id.check_answer2_op2);
        check_answer2_op3 = findViewById(R.id.check_answer2_op3);

        radio_answer3_op1 = findViewById(R.id.opt_answer3_1);
        radio_answer3_op2 = findViewById(R.id.opt_answer3_2);
        radio_answer3_op3 = findViewById(R.id.opt_answer3_3);

        edit_answer4 = findViewById(R.id.txtedit_answer4);
        edit_answer5 = findViewById(R.id.txtedit_answer5);

        btnResolveQuiz = findViewById(R.id.btn_resolve_quiz);

        btnResolveQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LOG_TAG","Resolve data");
                quizzPoints = evaluateQuiz();
                showMessageResult("Your Qualification is "+quizzPoints+"/10",getContext());
            }
        });


    }

    public Context getContext()
    {
        return  this;
    }

    public void setupToolBar()
    {
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Quiz App");
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public int evaluateQuiz()
    {
        int result = 0;

        //Question 1 (EditText)
        if(edit_answer1.getText().toString().toUpperCase().equalsIgnoreCase("GOTHAM CITY"))
            result += 1;

        //Question 2 (Check)
        if(check_answer2_op1.isChecked())
            result += 1;

        if(check_answer2_op2.isChecked())
            result += 1;

        //Question 3 (Option)
        if(radio_answer3_op3.isChecked())
            result += 2;

        //Question 4
        if(edit_answer4.getText().toString().toUpperCase().equalsIgnoreCase("RED"))
            result += 2;

        //Question 5
        if(edit_answer5.getText().toString().toUpperCase().equalsIgnoreCase("BRUCE WAYNE"))
            result += 3;

        return result;
    }

    private void showMessageResult(String message,Context context)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Accept",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}


