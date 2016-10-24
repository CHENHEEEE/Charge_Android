package com.he.charge.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.he.charge.R;

public class PayActivity extends Activity implements View.OnClickListener{

    TextView editText_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pay);

        ImageButton backButton = (ImageButton) findViewById(R.id.topBack);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayActivity.this.finish();
            }
        });

        TextView textView = (TextView) findViewById(R.id.topTextView);
        textView.setText("充值");

        editText_amount = (EditText) findViewById(R.id.editText_amount);
        Button button_50 = (Button) findViewById(R.id.button_50);
        Button button_100 = (Button) findViewById(R.id.button_100);
        Button button_300 = (Button) findViewById(R.id.button_300);
        Button button_500 = (Button) findViewById(R.id.button_500);
        button_50.setTag("50.00");
        button_100.setTag("100.00");
        button_300.setTag("300.00");
        button_500.setTag("500.00");
        button_50.setOnClickListener(this);
        button_100.setOnClickListener(this);
        button_300.setOnClickListener(this);
        button_500.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        editText_amount.setText((String)v.getTag());
    }
}
