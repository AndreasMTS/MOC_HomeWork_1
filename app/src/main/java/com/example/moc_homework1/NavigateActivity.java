package com.example.moc_homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NavigateActivity extends AppCompatActivity {

    TextView calcualtionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        calcualtionResult = (TextView) findViewById(R.id.navigate_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra("calc_result", 0);

        calcualtionResult.setText(String.valueOf(result));
    }
}
