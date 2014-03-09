package com.example.fragmenttutorial;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 
		android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
		StartFragment startFragment = new StartFragment();
		
		transaction.add(R.id.fragment_holder, startFragment);
		transaction.commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void selectFragment(View view){
		android.support.v4.app.Fragment newFragment;
		
		if( view == findViewById(R.id.btnStartFragment)){
			newFragment = new StartFragment();
		}else if( view == findViewById(R.id.btnFragment01)){
			newFragment = new Fragment01();
		}else if( view == findViewById(R.id.btnFragment02)){
			newFragment = new Fragment02();
		}else{
			newFragment = new StartFragment();
		}
		
		android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_holder, newFragment);
		transaction.addToBackStack(null);
		transaction.commit();
		
	}

}
