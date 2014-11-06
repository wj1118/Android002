package com.tcxy.settings;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class MainActivity extends Activity {


	private RadioButton fly ;
	private RadioButton standard;
	private RadioButton silent;
	private RadioButton metting;
	private RadioButton outing;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fly=(RadioButton) findViewById(R.id.rb_fly);
		standard=(RadioButton) findViewById(R.id.rb_standard);
		silent=(RadioButton) findViewById(R.id.rb_silent);
		metting=(RadioButton) findViewById(R.id.rb_metting);
		outing=(RadioButton) findViewById(R.id.rb_outing);
		
		fly.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ContentResolver resolver =	getContentResolver();
				Uri uri=Settings.Global.CONTENT_URI;
				ContentValues values =new ContentValues();
				values.put(Settings.Global.AIRPLANE_MODE_ON, 1);
				resolver.update(uri,values ,null, null );
				
			}
		});
		
		standard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				ContentResolver resolver =	getContentResolver();
				Uri uri =Settings.Global.CONTENT_URI;
				ContentValues values =new ContentValues();
				values.put(Settings.System.VOLUME_RING, 4);
				resolver.update(uri,values ,null, null );
				
			}
		});
		
		silent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				ContentResolver resolver =	getContentResolver();
				Uri uri =Settings.Global.CONTENT_URI;
				ContentValues values =new ContentValues();
				values.put(Settings.System.VOLUME_RING, 0);
				resolver.update(uri,values ,null, null );
			}
		});
		
		
		metting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//设置为不震动
				ContentResolver resolver =	getContentResolver();
				Uri uri =Settings.Global.CONTENT_URI;
				ContentValues values =new ContentValues();
				values.put(Settings.System.VIBRATE_ON, 0);
				resolver.update(uri,values ,null, null );
				//设置为静音
				ContentResolver resolver1 =	getContentResolver();
				Uri uri1 =Settings.Global.CONTENT_URI;
				ContentValues values1 =new ContentValues();
				values1.put(Settings.System.VOLUME_RING, 0);
				resolver1.update(uri1,values1 ,null, null );
				
				
			}
		});
		
		outing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ContentResolver resolver1 =	getContentResolver();
				Uri uri =Settings.Global.CONTENT_URI;
				ContentValues values =new ContentValues();
				values.put(Settings.System.VOLUME_RING, 7);
				resolver1.update(uri,values ,null, null );
				
			}
		});

	}


}
