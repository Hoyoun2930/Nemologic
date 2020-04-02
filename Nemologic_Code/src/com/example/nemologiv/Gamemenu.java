package com.example.nemologiv;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Gamemenu extends Activity implements OnItemClickListener{

	Button btn;
	String []m={"a","aa","aaa"};
	ListView memo;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		//1. 데이터 원본
		ArrayList<String> ar=new ArrayList<String>();
		for(int i=1;i<4;i++)
			ar.add("문제"+i);

		//2. 어뎁터 관리
		ArrayAdapter<String> ad;
		ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ar);
		
		//3. 어뎁터 연결 (어뎁터뷰<리스트뷰>로 화면에 표시
		ListView list=(ListView)findViewById(R.id.list);
		list.setAdapter(ad);
		list.setOnItemClickListener(this);
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu me) {
		getMenuInflater().inflate(R.menu.activity_logic, me);
		return true;
	}




	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		Intent it=new Intent(this,Game.class);
		it.putExtra("it_name", m[position]);
		startActivity(it);
	}
}

