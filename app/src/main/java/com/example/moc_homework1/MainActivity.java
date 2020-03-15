package com.example.moc_homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText inputValueFirst;
    EditText inputValueSecond;
    Button btn_calcualte;
    Button btn_navigate;
    TextView result_calculate;
    TextView result_seekbar;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValueFirst = (EditText) findViewById(R.id.value_input_first);
        inputValueSecond = (EditText) findViewById(R.id.value_input_second);
        btn_calcualte = (Button) findViewById(R.id.btn_calculate);
        btn_navigate = (Button) findViewById(R.id.btn_navigate);
        result_calculate = (TextView) findViewById(R.id.value_result_calculate);
        result_seekbar = (TextView) findViewById(R.id.value_seekbar);
        seekbar = (SeekBar) findViewById(R.id.seekbar);

        btn_calcualte.setOnClickListener((v)->
        {
            result_calculate.setText(String.valueOf(getFirstValue() + getSecondValue()));
        });

        btn_navigate.setOnClickListener((v)->
        {
            int calc_result = getFirstValue() + getSecondValue();

            Intent intent_navigate = new Intent(MainActivity.this, NavigateActivity.class);
            intent_navigate.putExtra("calc_result", calc_result);

            startActivity(intent_navigate);
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub

                result_seekbar.setText(String.valueOf(progress));
            }
        });
    }

    private int getFirstValue() {
        String firstValue = inputValueFirst.getText().toString();
        try {
            return Integer.parseInt(firstValue);
        }
        catch (Exception e) {
            return 0;
        }
    }

    private int getSecondValue() {
        String secondValue = inputValueSecond.getText().toString();
        try {
            return Integer.parseInt(secondValue);
        }
        catch (Exception e) {
            return 0;
        }
    }
}
