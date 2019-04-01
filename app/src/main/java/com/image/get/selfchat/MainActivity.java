package com.image.get.selfchat;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String MESSAGES = "messages";
    Button sendButton;
    EditText messageEditText;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button) findViewById(R.id.button3);
        result = (TextView) findViewById(R.id.textView3);
        messageEditText = (EditText) findViewById(R.id.editText);



        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                messageEditText.setText("");
                result.setText(message);


            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("wrote_message", messageEditText.getText().toString());
        outState.putString("shown_message", result.getText().toString());
    }



    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String wrote_message = savedInstanceState.getString("wrote_message");
        String shown_message = savedInstanceState.getString("shown_message");
        messageEditText.setText(wrote_message);
        result.setText(shown_message);

    }


}
