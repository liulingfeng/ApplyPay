package com.clg.xinyi.order;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.clg.xinyi.App;
import com.clg.xinyi.R;

public class OrderActivity extends Activity{
	private ListView listView;
	private OrderAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		init();
	}
	
	private void init(){
		listView = (ListView)findViewById(R.id.listview);
		adapter = new OrderAdapter(this, App.orderList);
		listView.setAdapter(adapter);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		adapter.notifyDataSetChanged();
	}
}
