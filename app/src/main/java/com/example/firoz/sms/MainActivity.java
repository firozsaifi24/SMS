package com.example.firoz.sms;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mobile,msg;
    Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobile=(EditText)findViewById(R.id.editText);
        msg=(EditText)findViewById(R.id.editText2);
        sendsms=(Button)findViewById(R.id.button);

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileno=mobile.getText().toString();
                String message=msg.getText().toString();

                //Create Intent and PendingIntent object to use in sms manager class
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,intent,0);

                //create sms manager object and call the sendTextMessage to send text message
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(mobileno,null,message,pi,null);

                Toast.makeText(getApplicationContext(),"SMS sent successfully",Toast.LENGTH_SHORT).show();


            }
        });

    }
}
