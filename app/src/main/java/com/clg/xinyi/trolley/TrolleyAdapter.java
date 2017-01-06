package com.clg.xinyi.trolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.clg.xinyi.R;
import java.util.List;

public class TrolleyAdapter extends BaseAdapter{
	private LayoutInflater inflater;
	private List<Integer> datas;
	private boolean isCheck = true;
	
	public TrolleyAdapter(Context context, List<Integer> datas) {
		inflater = LayoutInflater.from(context);
		this.datas = datas;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHoder holder;
		if (convertView == null) {
			holder = new ViewHoder();
			convertView = inflater.inflate(R.layout.cart_list_item, parent, false);
			holder.image = (ImageView) convertView.findViewById(R.id.ivPicture);
			holder.checkBox = (CheckBox)convertView.findViewById(R.id.checkBox);
			convertView.setTag(holder);
		} else {
			holder = (ViewHoder) convertView.getTag();
		}

		switch (datas.get(position)) {
		case 0:
			holder.image.setBackgroundResource(R.drawable.good_one);
			break;
		case 1:
			holder.image.setBackgroundResource(R.drawable.good_two);
			break;
		case 2:
			holder.image.setBackgroundResource(R.drawable.good_three);
			break;
		case 3:
			holder.image.setBackgroundResource(R.drawable.good_four);
			break;
		case 4:
			holder.image.setBackgroundResource(R.drawable.good_five);
			break;
		case 5:
			holder.image.setBackgroundResource(R.drawable.good_six);
			break;
		}
		holder.checkBox.setChecked(isCheck);
		return convertView;
	}

	public void setAllfalse(){
		isCheck = false;
		notifyDataSetChanged();
	}
	
	public void setAllTrue(){
		isCheck = true;
		notifyDataSetChanged();
	}
	
	private class ViewHoder {
		ImageView image;
		CheckBox checkBox;
	}
}
