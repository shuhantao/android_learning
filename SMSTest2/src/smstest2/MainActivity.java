package smstest2;

import com.example.smstest2.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.CursorJoiner.Result;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	private TextView sender;
	private TextView content;
	private IntentFilter receiveFilter;
	private MessageReceiver messageReceiver;
	private Button send;
	private EditText to;
	private EditText msgInput;
	private IntentFilter sendFilter;
	private SendStatusReceiver sendStatusReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sender = (TextView) findViewById(R.id.sender);
		content = (TextView)findViewById(R.id.content);
		send = (Button) findViewById(R.id.send);
		to = (EditText)findViewById(R.id.to);
		msgInput = (EditText) findViewById(R.id.msg_input);
		receiveFilter = new IntentFilter();
		receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		messageReceiver = new MessageReceiver();
		registerReceiver(messageReceiver, receiveFilter);
		sendFilter =new IntentFilter();
		sendStatusReceiver = new SendStatusReceiver();
		sendFilter.addAction("SENT_SMS_ACTION");
		registerReceiver(sendStatusReceiver, sendFilter);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager smsManager = SmsManager.getDefault();
				Intent sendIntent = new Intent("SENT_SMS_ACTION");
				PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 0, sendIntent, 0);
				smsManager.sendTextMessage(to.getText().toString(), null, msgInput.getText().toString(), pi, null);
				
			}
		});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(messageReceiver);
		unregisterReceiver(sendStatusReceiver);
	}
	class MessageReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Bundle bundle=intent.getExtras();
			Object[] pdus=(Object[]) bundle.get("pdus");
			SmsMessage[] messages = new SmsMessage[pdus.length];
			for(int i=0; i<messages.length; i++){
				byte[] pdu=(byte[]) pdus[i];
				messages[i] = SmsMessage.createFromPdu(pdu);

			}
			String address = messages[0].getOriginatingAddress();
			String fullMessage = "";
			for(SmsMessage message1 :messages){
				fullMessage += message1.getMessageBody();
			}
			sender.setText(address);
			content.setText(fullMessage);
		}
	}
	class SendStatusReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if(getResultCode() == RESULT_OK){
				Toast.makeText(context, "send succeed", Toast.LENGTH_LONG).show();
			}
			else {
				Toast.makeText(context, "send failed", Toast.LENGTH_LONG).show();
			}
			
		}
		
	}
}
