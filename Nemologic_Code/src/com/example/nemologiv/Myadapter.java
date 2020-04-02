package com.example.nemologiv;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class Myadapter extends BaseAdapter{
	private Context mc;
	public int[] m=new int[100];
	public Myadapter(Context c){
		mc=c;
	}
	public int getCount() { //어댑터 데이터 개수리턴
		return m.length;
	}
	public Object getItem(int pos) { //어댑터에서 값 가져오기
		return m[pos];
	}
	public long getItemId(int pos) { // 위치 값 가져오기
		return pos;
	}
	public View getView(int pos, View cv, ViewGroup parent) {
		ImageView img=new ImageView(mc);
		img.setImageResource(m[pos]);
		img.setLayoutParams(new GridView.LayoutParams(60,98));
		return img;
	}
}