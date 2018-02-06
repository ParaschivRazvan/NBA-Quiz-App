package com.example.android.nbaquizapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int score=0;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void questionOne(View view) {

        boolean checked = ((RadioButton) view).isChecked() ;
        if (view.getId() == R.id.michael_jordan && checked)
            score++ ;
    }

    public void questionTwo(View view) {

        boolean checked = ((RadioButton) view).isChecked() ;
        if (view.getId() == R.id.lebron_james && checked)
            score++ ;

    }

    public void questionThree() {

        CheckBox checkBoxa = findViewById(R.id.checkbox3a) ;
        CheckBox checkBoxb = findViewById(R.id.checkbox3b) ;
        CheckBox checkBoxc = findViewById(R.id.checkbox3c) ;
        CheckBox checkBoxd = findViewById(R.id.checkbox3d) ;

        if (checkBoxd.isChecked() && checkBoxc.isChecked() && !checkBoxb.isChecked() && checkBoxa.isChecked())

            score++ ;

        checkBoxa.setChecked(false) ;
        checkBoxb.setChecked(false) ;
        checkBoxc.setChecked(false) ;
        checkBoxd.setChecked(false) ;

    }

    public void questionFour() {

    EditText editText = (EditText) findViewById(R.id.edit_text_4) ;

    String editMessage = editText.getText().toString() ;
        if (editMessage.equals("5"))
            score++ ;

        editText.setText("") ;
    }

    public void questionFive(View view) {

        boolean checked = ((RadioButton) view).isChecked() ;

        if(view.getId() == R.id.kareem_abdul_jabar && checked)

            score++ ;

    }

    public void questionSix(){

    CheckBox checkBoxa = findViewById(R.id.checkbox6a) ;
    CheckBox checkBoxb = findViewById(R.id.checkbox6b) ;
    CheckBox checkBoxc = findViewById(R.id.checkbox6c) ;
    CheckBox checkBoxd = findViewById(R.id.checkbox6d) ;

    if (!checkBoxd.isChecked() && checkBoxc.isChecked() && checkBoxb.isChecked() && checkBoxa.isChecked())

        score++ ;

    checkBoxa.setChecked(false) ;
    checkBoxb.setChecked(false) ;
    checkBoxc.setChecked(false) ;
    checkBoxd.setChecked(false) ;
    }

    public void questionSeven(View view){

        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.russel_westbrook && checked)

            score++;

    }
    public void questionEight(View view){
        boolean checked = ((RadioButton) view).isChecked() ;

        if (view.getId() == R.id.donovan_mitchell && checked)
            score++ ;

    }
    public void questionNine(){

        EditText editText = (EditText) findViewById(R.id.edit_text_9) ;

        String editMessage = editText.getText().toString() ;

        if (editMessage.equals("2011"))
            score++ ;

        editText.setText("") ;



    }

    public void questionTen(){

        CheckBox checkBoxa = findViewById(R.id.checkbox10a) ;
        CheckBox checkBoxb = findViewById(R.id.checkbox10b) ;
        CheckBox checkBoxc = findViewById(R.id.checkbox10c) ;
        CheckBox checkBoxd = findViewById(R.id.checkbox10d) ;

        if(!checkBoxd.isChecked() && checkBoxc.isChecked() && !checkBoxb.isChecked() && checkBoxa.isChecked())
            score++ ;
        checkBoxa.setChecked(false) ;
        checkBoxb.setChecked(false) ;
        checkBoxc.setChecked(false) ;
        checkBoxd.setChecked(false) ;
    }

    public void done(View view){

        questionThree();
        questionFour();
        questionSix();
        questionNine();
        questionTen();

        RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radio1);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radio2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup5 = (RadioGroup)findViewById(R.id.radio5);
        radioGroup5.clearCheck();

        RadioGroup radioGroup7 = (RadioGroup)findViewById(R.id.radio7);
        radioGroup7.clearCheck();

        RadioGroup radioGroup8 = (RadioGroup)findViewById(R.id.radio8);
        radioGroup8.clearCheck();

        Context context = getApplicationContext() ;

        String text = "You scored " + score ;
        if (score == 1)
            text = text +  " point!" ;
                    else
                        text = text + " points!" ;
        int duration = Toast.LENGTH_SHORT ;


        Toast toast = Toast.makeText(context, (CharSequence) text, duration) ;
        toast.show() ;

        CheckBox checkBoxShare = findViewById(R.id.checkboxShare) ;

        if (checkBoxShare.isChecked()) {

            Intent intent = new Intent(Intent.ACTION_SENDTO) ;
        intent.setData(Uri.parse("mailto:")) ;
        intent.putExtra(Intent.EXTRA_SUBJECT,"My NBA knowledge") ;
        intent.putExtra(Intent.EXTRA_TEXT,"Hi there! I just scored " + score + " points!\n How much do you think you can score? " ) ;

        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }
            checkBoxShare.setChecked(false);
        }
        score = 0 ;

    }

}
