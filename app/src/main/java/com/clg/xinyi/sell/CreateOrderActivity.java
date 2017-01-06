package com.clg.xinyi.sell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.clg.xinyi.App;
import com.clg.xinyi.R;

public class CreateOrderActivity extends Activity{
	public static void lanuch(Context context, int position) {
		Intent intent = new Intent(context, CreateOrderActivity.class);
		intent.putExtra("position", position);
		context.startActivity(intent);
	}
	
	private int position;
	private ImageView pic;
	private TextView name,price,tvShouldPay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_order);
		
		init();
	}
	
	private void init(){
		position = getIntent().getIntExtra("position", 0);
		pic = (ImageView)findViewById(R.id.pic);
		name = (TextView)findViewById(R.id.name);
		price = (TextView)findViewById(R.id.price);
		tvShouldPay = (TextView)findViewById(R.id.tvShouldPay);
		
		switch (position) {
		case 0:
			pic.setBackgroundResource(R.drawable.good_one);
			name.setText("山东青岛特产崂山绿茶");
			price.setText("￥578");
			tvShouldPay.setText("￥578");
			break;

		case 1:
			pic.setBackgroundResource(R.drawable.good_two);
			name.setText("十月稻田八种杂粮大礼包3.2kg");
			price.setText("￥88");
			tvShouldPay.setText("￥88");
			break;
		case 2:
			pic.setBackgroundResource(R.drawable.good_three);
			name.setText("海豚电弧打火机usb充电个性电子点烟器");
			price.setText("￥78");
			tvShouldPay.setText("￥78");
			break;
		case 3:
			pic.setBackgroundResource(R.drawable.good_four);
			name.setText("片仔癀仙泉凝世水妍礼盒");
			price.setText("￥588");
			tvShouldPay.setText("￥588");
			break;
		case 4:
			pic.setBackgroundResource(R.drawable.good_five);
			name.setText("铁观音礼盒装500g");
			price.setText("￥350");
			tvShouldPay.setText("￥350");
			break;
		case 5:
			pic.setBackgroundResource(R.drawable.good_six);
			name.setText("云南特产 野生菌菌菇干货山珍礼盒");
			price.setText("￥168");
			tvShouldPay.setText("￥168");
			break;
		}
	}
	
	public void submit(View v){
		Toast.makeText(this, "订单提交成功", Toast.LENGTH_SHORT).show();
		App.orderList.add(position);
	}
	
	public void back(View v){
		finish();
	}
}
