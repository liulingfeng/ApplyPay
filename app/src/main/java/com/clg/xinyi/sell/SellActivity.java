package com.clg.xinyi.sell;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.clg.xinyi.R;
import com.clg.xinyi.weight.NestGridView;

public class SellActivity extends Activity{
	private NestGridView mGridView;
	private int[] ids = new int[6];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		
		initView();
	}
	
	private void initView(){
		mGridView = (NestGridView)findViewById(R.id.grideview);
		ids[0] = R.drawable.good_one;
		ids[1] = R.drawable.good_two;
		ids[2] = R.drawable.good_three;
	    ids[3] = R.drawable.good_four;
	    ids[4] = R.drawable.good_five;
	    ids[5] = R.drawable.good_six;
	    
	    GoodAdapter adapter = new GoodAdapter(this, ids);
	    mGridView.setAdapter(adapter);
	    
	    mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				DetailActivity.lanuch(SellActivity.this,position);
			}
		});
	}
}
