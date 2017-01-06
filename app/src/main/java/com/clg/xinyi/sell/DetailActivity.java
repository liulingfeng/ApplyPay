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

public class DetailActivity extends Activity {
	public static void lanuch(Context context, int position) {
		Intent intent = new Intent(context, DetailActivity.class);
		intent.putExtra("position", position);
		context.startActivity(intent);
	}

	private ImageView image;
	private int position;
	private TextView name,price;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		init();
	}

	private void init() {
		position = getIntent().getIntExtra("position", 0);
		image = (ImageView) findViewById(R.id.goods);
		name = (TextView)findViewById(R.id.name);
		price = (TextView)findViewById(R.id.price);
		
		switch (position) {
		case 0:
			image.setBackgroundResource(R.drawable.detail_one);
			name.setText("山东青岛特产崂山绿茶");
			price.setText("￥578");
			break;

		case 1:
			image.setBackgroundResource(R.drawable.detail_two);
			name.setText("十月稻田八种杂粮大礼包3.2kg");
			price.setText("￥88");
			break;
		case 2:
			image.setBackgroundResource(R.drawable.detail_three);
			name.setText("海豚电弧打火机usb充电个性电子点烟器");
			price.setText("￥78");
			break;
		case 3:
			image.setBackgroundResource(R.drawable.detail_four);
			name.setText("片仔癀仙泉凝世水妍礼盒");
			price.setText("￥588");
			break;
		case 4:
			image.setBackgroundResource(R.drawable.detail_five);
			name.setText("铁观音礼盒装500g");
			price.setText("￥350");
			break;
		case 5:
			image.setBackgroundResource(R.drawable.detail_six);
			name.setText("云南特产 野生菌菌菇干货山珍礼盒");
			price.setText("￥168");
			break;
		}
	}
	
	public void addCart(View v){
		Toast.makeText(this, "加入购物车成功", Toast.LENGTH_SHORT).show();
		App.cartList.add(position);
	}
	
	public void buy(View v){
		CreateOrderActivity.lanuch(this, position);
	}
}
