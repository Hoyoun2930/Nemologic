package com.example.nemologiv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Logic extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);
        Button btn1=(Button)findViewById(R.id.btn01);
        btn1.setOnClickListener(this);
        Button btn2=(Button)findViewById(R.id.btn02);
        btn2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_logic, menu);
        return true;
    }

	public void onClick(View v) {
		if(v==findViewById(R.id.btn01))
		{
			Intent it=new Intent(this,Gamemenu.class);
			startActivity(it);
			
		}
		else
		{
			Intent it=new Intent(this,Manual.class);
			startActivity(it);
		}
	}
}
