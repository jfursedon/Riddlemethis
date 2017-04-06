package com.example.android.riddlemethis;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //    list of all radio button ids
    int[] ids = {R.id.q1a1, R.id.q1a2, R.id.q1a3, R.id.q1a4, R.id.q2a1, R.id.q2a2, R.id.q2a3, R.id.q2a4, R.id.q3a1, R.id.q3a2, R.id.q3a3, R.id.q3a4, R.id.q4a1, R.id.q4a2, R.id.q4a3, R.id.q4a4, R.id.q5a1, R.id.q5a2, R.id.q5a3, R.id.q5a4, R.id.q6a1, R.id.q6a2, R.id.q6a3, R.id.q6a4, R.id.q7a1, R.id.q7a2, R.id.q7a3, R.id.q7a4};
    //    list of the answers for radio buttons, each answer is between 1 and 4 inclusive
    int ans[] = {1, 3, 4, 2, 3, 4, 3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Closes keyboard when focus is lost from EditText. From http://stackoverflow.com/a/28939113
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }


    /*
    *
    * When the submit button is clicked, iterate through the button ids in ids[] and check if the radio button for the answer number found in ans[] is checked then compares q8 and 9 with correct answers
    * Popup a toast with the score
    *
    * @param ButtonView
    * @toast final score
    * */

    public void getScore(View view) {
        int score = 0;
        for (int i = 0; i < ans.length; i++) {

            if (((RadioButton) findViewById(ids[(i * 4) + ans[i] - 1])).isChecked()) {
                score++;
            }
        }
        //Only the second answer is correct!
        if ((((CheckBox) findViewById(R.id.q8a2)).isChecked()) && !(((CheckBox) findViewById(R.id.q8a1)).isChecked()) && !(((CheckBox) findViewById(R.id.q8a3)).isChecked()) && !(((CheckBox) findViewById(R.id.q8a4)).isChecked())) {
            score++;
        }
        //Did you read the question?
        EditText q9EditText = (EditText) findViewById(R.id.q9a1);
        String q9a1 = q9EditText.getText().toString();
        if ("colour the American way.".equals(q9a1)) {
            score++;
        }

        Toast.makeText(MainActivity.this, "You scored " + score + " out of 9!",
                Toast.LENGTH_LONG).show();

    }
}