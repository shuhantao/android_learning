package smstest2;

import com.example.smstest2.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
	private TextView sender;
	private TextView content;
	private IntentFilter receiveFilter;
	private MessageReceiver messageReceiver;
	private Button send;
	private EditText to;
	private EditText msgInput;
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
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(messageReceiver);
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
}