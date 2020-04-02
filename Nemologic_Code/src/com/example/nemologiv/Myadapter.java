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
	public int getCount() { //����� ������ ��������
		return m.length;
	}
	public Object getItem(int pos) { //����Ϳ��� �� ��������
		return m[pos];
	}
	public long getItemId(int pos) { // ��ġ �� ��������
		return pos;
	}
	public View getView(int pos, View cv, ViewGroup parent) {
		ImageView img=new ImageView(mc);
		img.setImageResource(m[pos]);
		img.setLayoutParams(new GridView.LayoutParams(60,98));
		return img;
	}
}