package com.example.android.riddlemethis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] ids = {R.id.q1a1, R.id.q1a2, R.id.q1a3, R.id.q1a4, R.id.q2a1, R.id.q2a2, R.id.q2a3, R.id.q2a4, R.id.q3a1, R.id.q3a2, R.id.q3a3, R.id.q3a4, R.id.q4a1, R.id.q4a2, R.id.q4a3, R.id.q4a4, R.id.q5a1, R.id.q5a2, R.id.q5a3, R.id.q5a4, R.id.q6a1, R.id.q6a2, R.id.q6a3, R.id.q6a4, R.id.q7a1, R.id.q7a2, R.id.q7a3, R.id.q7a4};
    int ans[] = {1,3,4,2,3,3,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void getScore(View view) {
    int score = 0;
    for (int i = 0; i < ans.length; i++) {

        if (((RadioButton) findViewById(ids[(i*4)+ans[i]-1])).isChecked()) {
            score++;
        }
    }
    Toast.makeText(MainActivity.this,""+ score,
            Toast.LENGTH_LONG).show();
//    return score;

}
}