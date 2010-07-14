package com.svenhenrik.cardlife;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSFilter extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//SMS_RECEIVED
        Bundle extras = intent.getExtras();
        if (extras == null)
            return;

        Object[] pdus = (Object[]) extras.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String fromAddress = message.getOriginatingAddress();
            String messageBody = message.getMessageBody();
            //String messageBody = "[KB체크]\nHENRIKMA님\n07월14일13:28\n마라도\n6,000원 사용";
 
            Log.d("CardLife", "CardLife got SMS from " + fromAddress + ": " + messageBody);
            Toast.makeText(context, messageBody, Toast.LENGTH_SHORT).show();
            // if (fromAddress in Banks)
        }		
		
	}

}
