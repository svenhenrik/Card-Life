package com.svenhenrik.cardlife;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CardLife extends Activity {
	private TransactionDB db;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        db = new TransactionDB(this);
        
        TextView text = (TextView)this.findViewById(R.id.TextView01);
        
        List<String> entries = db.selectAll();
        StringBuilder sb = new StringBuilder();
        for (String entry : entries) {
        	sb.append(entry + "\n");
        }

        text.setText(sb.toString());
    }
}