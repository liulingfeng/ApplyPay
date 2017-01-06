package com.clg.xinyi.trolley;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import com.clg.xinyi.App;
import com.clg.xinyi.R;

public class TrolleyActivity extends Activity {
	private ListView listView;
	private TrolleyAdapter adapter;
	private TextView tvTotalMoney;
	private CheckBox allCb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trolley);

		init();
	}

	private void init() {
		listView = (ListView) findViewById(R.id.lvcart);
		tvTotalMoney = (TextView) findViewById(R.id.tvTotalMoney);
		allCb = (CheckBox) findViewById(R.id.allCb);
		adapter = new TrolleyAdapter(this, App.cartList);
		listView.setAdapter(adapter);

		allCb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (!allCb.isChecked()){
					adapter.setAllfalse();
					tvTotalMoney.setText("总价:￥0.00");
				}
				else{
					tvTotalMoney.setText("总价:￥" + App.cartList.size() * 188);
				}
			}
		});

		allCb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					adapter.setAllTrue();
				}
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();

		adapter.notifyDataSetChanged();
		tvTotalMoney.setText("总价:￥" + App.cartList.size() * 188);
	}
}
