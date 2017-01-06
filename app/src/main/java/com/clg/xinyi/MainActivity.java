package com.clg.xinyi;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import com.clg.xinyi.order.OrderActivity;
import com.clg.xinyi.sell.SellActivity;
import com.clg.xinyi.trolley.TrolleyActivity;

public class MainActivity extends TabActivity implements OnClickListener{
    private TabHost tabhost;
    private Intent intent;
    private TextView tabIem1;
    private TextView tabIem2;
    private TextView tabIem3;

    private LinearLayout tabItemLL1;
    private LinearLayout tabItemLL2;
    private LinearLayout tabItemLL3;

    private ImageView tabItemIv1;
    private ImageView tabItemIv2;
    private ImageView tabItemIv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        initData();
    }

    private void initWidgets(){
        tabIem1 = (TextView) findViewById(R.id.tabIem1);
        tabIem2 = (TextView) findViewById(R.id.tabIem2);
        tabIem3 = (TextView) findViewById(R.id.tabIem3);

        tabItemLL1 = (LinearLayout) findViewById(R.id.tabItemLL1);
        tabItemLL2 = (LinearLayout) findViewById(R.id.tabItemLL2);
        tabItemLL3 = (LinearLayout) findViewById(R.id.tabItemLL3);

        tabItemIv1 = (ImageView) findViewById(R.id.tabItemIv1);
        tabItemIv2 = (ImageView) findViewById(R.id.tabItemIv2);
        tabItemIv3 = (ImageView) findViewById(R.id.tabItemIv3);

        tabItemLL1.setOnClickListener(this);
        tabItemLL2.setOnClickListener(this);
        tabItemLL3.setOnClickListener(this);
    }

    private void initData(){
        tabhost = getTabHost();
        intent = new Intent(this, SellActivity.class);
        tabhost.addTab(tabhost.newTabSpec("SellActivity").setIndicator("SellActivity").setContent(intent));

        intent = new Intent(this, TrolleyActivity.class);
        tabhost.addTab(tabhost.newTabSpec("TrolleyActivity").setIndicator("TrolleyActivity").setContent(intent));

        intent = new Intent(this, OrderActivity.class);
        tabhost.addTab(tabhost.newTabSpec("OrderActivity").setIndicator("OrderActivity").setContent(intent));

        tabhost.setCurrentTabByTag("SellActivity");
        tabItemIv1.setSelected(true);
        tabIem1.setTextColor(Color.parseColor("#e42d6b"));
    }

    @Override
    public void onClick(View v) {
        tabItemIv1.setSelected(false);
        tabItemIv2.setSelected(false);
        tabItemIv3.setSelected(false);

        tabIem1.setTextColor(Color.parseColor("#7e7e7e"));
        tabIem2.setTextColor(Color.parseColor("#7e7e7e"));
        tabIem3.setTextColor(Color.parseColor("#7e7e7e"));

        switch (v.getId()) {
            case R.id.tabItemLL1:
                tabItemIv1.setSelected(true);
                tabIem1.setTextColor(Color.parseColor("#e42d6b"));
                tabhost.setCurrentTabByTag("SellActivity");
                break;
            case R.id.tabItemLL2:
                tabItemIv2.setSelected(true);
                tabIem2.setTextColor(Color.parseColor("#e42d6b"));
                tabhost.setCurrentTabByTag("TrolleyActivity");
                break;
            case R.id.tabItemLL3:
                tabItemIv3.setSelected(true);
                tabhost.setCurrentTabByTag("OrderActivity");
                tabIem3.setTextColor(Color.parseColor("#e42d6b"));
                break;
        }
    }
}
