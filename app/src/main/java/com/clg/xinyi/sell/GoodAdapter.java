package com.clg.xinyi.sell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.clg.xinyi.R;

public class GoodAdapter extends BaseAdapter{
	private LayoutInflater inflater;
	private int[] ids;
	
	public GoodAdapter(Context context,int[] ids){
		inflater = LayoutInflater.from(context);
		this.ids = ids;
	}
	@Override
	public int getCount() {
		return ids.length;
	}

	@Override
	public Object getItem(int position) {
		return ids[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHoder holder;
		if(convertView == null){
			holder = new ViewHoder();
			convertView = inflater.inflate(R.layout.good_item, parent,false);
			holder.image = (ImageView)convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		}else{
			holder = (ViewHoder)convertView.getTag();
		}
		holder.image.setBackgroundResource(ids[position]);
		return convertView;
	}

	private class ViewHoder{
		ImageView image;
	}
}
