package com.clg.xinyi.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.clg.xinyi.R;

import java.util.List;

public class OrderAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Integer> datas;

	public OrderAdapter(Context context, List<Integer> datas) {
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
			convertView = inflater.inflate(R.layout.order_item, parent, false);
			holder.image = (ImageView) convertView.findViewById(R.id.good);
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
		
		return convertView;
	}

	private class ViewHoder {
		ImageView image;
	}

}
