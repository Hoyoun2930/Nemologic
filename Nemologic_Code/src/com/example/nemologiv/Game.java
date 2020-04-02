package com.example.nemologiv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Game extends Activity implements OnItemClickListener{

	int[]que=new int[100];
	int[][] answer = {{
		1,0,1,1,1,1,1,1,0,1,
		0,1,1,1,1,0,1,1,1,0,
		0,1,0,0,1,0,0,1,1,1,
		1,1,1,1,0,1,1,0,1,1,
		1,1,0,1,0,0,1,0,1,1,
		1,1,0,0,0,0,0,0,1,1,
		1,0,1,0,1,1,0,1,0,1,
		1,1,1,1,0,0,1,1,1,1,
		1,1,1,1,1,1,0,1,1,1,
		1,0,1,1,0,0,0,1,1,0},{
			0,0,1,1,0,1,1,0,0,0,
			0,1,0,0,1,0,0,1,0,0,
			0,1,0,1,1,0,1,1,0,0,
			1,1,1,0,1,1,0,1,1,0,
			1,0,0,0,0,0,0,0,1,1,
			0,1,0,1,0,0,0,0,0,1,
			0,0,0,0,0,0,1,0,0,1,
			0,0,0,0,0,0,1,1,0,1,
			1,0,0,0,1,1,0,0,1,1,
			1,1,1,1,1,0,0,1,1,0},{
				0,0,1,1,1,0,0,1,1,1,
				0,1,1,1,1,1,0,1,0,1,
				1,1,0,1,0,1,1,0,0,1,
				1,1,1,0,1,1,1,0,0,1,
				0,1,0,0,0,1,0,0,0,1,
				0,1,1,0,1,1,1,1,0,1,
				0,0,1,1,1,1,1,1,1,0,
				1,1,1,1,1,1,1,1,0,0,
				1,0,0,1,1,0,1,1,1,1,
				0,1,1,1,0,1,1,1,1,0}};
	String [][]ques={{"1\n7","5\n2","2\n1\n4","2\n2\n3","3\n1\n1","1\n1\n1\n1","2\n2\n1","3\n4","5\n3","1\n7","1 6 1","4 3","1 1 3","4 2 2","2 1 1 2","2 2","1 1 2 1 1","4 4","6 3","1 2 2"},
			{"2\n2","3\n1\n1","1\n1\n1","1\n1\n1\n1","3\n2","1\n1\n1","1\n1\n2","3\n1\n1","2\n2","5","2 2","1 1 1","1 2 2","3 2 2","1 2","1 1 1","1 1 ","2 1","1 2 2","5 2"},
			{"2\n2","5\n1\n1","2\n1\n3\n1","3\n4","2\n1\n4","7\n1","2\n5","2\n5","1\n1\n2","6\n1","3 3","5 1 1","2 1 2 1","3 3 1","1 1 1","2 4 1","7","8","1 2 4","3 4"}};
	GridView grid;
	int num,sum,k=0;
	Myadapter ad;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent it1=getIntent();
		num=it1.getStringExtra("it_name").trim().length();
		num=num-1;
		if(num==0)
			setContentView(R.layout.logicmain);
		else if(num==1)
			setContentView(R.layout.logicmain1);
		else
			setContentView(R.layout.logicmain2);
		ad=new Myadapter(this);
		for(int i=num*10;i<num*10+10;i++)
		{

		}
		for(int i=0;i<100;i++){

			ad.m[i]=R.drawable.bt;
			que[i]=0;
		}

		grid=(GridView)findViewById(R.id.grid01);
		grid.setAdapter(ad);
		grid.setOnItemClickListener(this);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_logic, menu);
		return true;
	}
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		if(que[position]==0)
		{
			ad.m[position]=R.drawable.bttx;;
			que[position]=1;
			grid.setAdapter(ad);
		}
		else if(que[position]==1)
		{
			ad.m[position]=R.drawable.btx;
			que[position]=2;
			grid.setAdapter(ad);

		}
		else
		{
			ad.m[position]=R.drawable.bt;
			que[position]=0;
			grid.setAdapter(ad);
		}
		sum=0;
		for(int i=0;i<100;i++)
		{
			if(que[i]%2==answer[num][i])
				sum++;
		}
		if(sum==100)
		{
			AlertDialog.Builder alert=new AlertDialog.Builder(Game.this);
			alert.setTitle("알림창");
			alert.setMessage("전부 맞추셨습니다.\n끝내시려면 뒤로가기를 눌러주세요.");
			alert.setIcon(R.drawable.ic_launcher);
			alert.setNegativeButton("감상하기",null);
			alert.show();
			grid.setEnabled(false);
		}

	}

}
