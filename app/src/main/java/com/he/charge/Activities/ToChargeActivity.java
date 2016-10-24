package com.he.charge.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.he.charge.R;

import org.w3c.dom.Text;

public class ToChargeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_to_charge);

        ImageButton backButton = (ImageButton) findViewById(R.id.topBack);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToChargeActivity.this.finish();
            }
        });

        TextView textView = (TextView) findViewById(R.id.topTextView);
        textView.setText("充电");

        final NumberPicker numberPicker_hour = (NumberPicker) findViewById(R.id.numberPicker_hour);
        final NumberPicker numberPicker_min = (NumberPicker) findViewById(R.id.numberPicker_min);
        numberPicker_hour.setMaxValue(23);
        numberPicker_hour.setMinValue(0);
        numberPicker_min.setMinValue(0);
        numberPicker_min.setMaxValue(59);

        final EditText editText_amount = (EditText) findViewById(R.id.editText_amount);

        editText_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPicker_hour.setValue(0);
                numberPicker_min.setValue(0);
            }
        });

        numberPicker_hour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                editText_amount.setText("");
            }
        });

        numberPicker_min.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                editText_amount.setText("");
            }
        });

        TextView textView_toPay = (TextView) findViewById(R.id.textView_toPay);
        textView_toPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ToChargeActivity.this,PayActivity.class);
                startActivity(intent);
                overridePendingTransition(R.animator.to_right, R.animator.to_left);
            }
        });

        Button button_toCharge = (Button) findViewById(R.id.button_toCharge);
        button_toCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "未检测到车辆连接充电桩", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
