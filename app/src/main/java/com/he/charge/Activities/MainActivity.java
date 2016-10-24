package com.he.charge.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.he.charge.Adapters.MainListAdapter;
import com.he.charge.Adapters.MeListAdapter;
import com.he.charge.R;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements android.view.View.OnClickListener,
        AdapterView.OnItemClickListener{

    private ViewPager mViewpager;
    private PagerAdapter mAdapter;
    private List<View> mViews=new ArrayList<View>();
    //TAB
    private LinearLayout mTabCharge, mTabMe;
    private ImageButton mChargeImg, mMeImg;
    private TextView mChargeText,mMeText;
    private ListView mainList,meList;
    private TextView mTopTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvents();
    }

    private void initEvents() {
        mTabCharge.setOnClickListener(this);
        mTabMe.setOnClickListener(this);

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {

                int currentItem = mViewpager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImg();
                        mChargeImg.setBackgroundResource(R.drawable.ic_charge);
                        mTopTextView.setText("充电");
                        mChargeText.setTextColor(getResources().getColor(R.color.colorGreen));
                        break;
                    case 1:
                        resetImg();
                        mMeImg.setBackgroundResource(R.drawable.ic_me);
                        mTopTextView.setText("我的");
                        mMeText.setTextColor(getResources().getColor(R.color.colorGreen));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


    private void initView() {
        mViewpager = (ViewPager)findViewById(R.id.id_viewpager);
        mTopTextView = (TextView) findViewById(R.id.topTextView);
        //Tabs
        mTabCharge =(LinearLayout)findViewById(R.id.id_tab_charge);
        mTabMe =(LinearLayout)findViewById(R.id.id_tab_me);
        //ImageButtons
        mChargeImg =(ImageButton)findViewById(R.id.id_tab_charge_img);
        mMeImg =(ImageButton)findViewById(R.id.id_tab_me_img);
        //Texts
        mChargeText = (TextView) findViewById(R.id.id_tab_charge_text);
        mMeText = (TextView) findViewById(R.id.id_tab_me_text);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01=mInflater.inflate(R.layout.tab01, null);
        View tab02=mInflater.inflate(R.layout.tab02, null);
        mViews.add(tab01);
        mViews.add(tab02);

        mAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
                super.destroyItem(container, position, object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0==arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return mViews.size();
            }
        };

        mViewpager.setAdapter(mAdapter);

        //tab01内容布局
        mainList = (ListView) tab01.findViewById(R.id.mainList);
        MainListAdapter mainListAdapter = new MainListAdapter(this);
        mainList.setAdapter(mainListAdapter);
        mainList.setOnItemClickListener(this);

        //tab02内容布局
        meList = (ListView) tab02.findViewById(R.id.meList);
        MeListAdapter meListAdapter = new MeListAdapter(this);
        meList.setAdapter(meListAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_tab_charge:
                resetImg();
                mViewpager.setCurrentItem(0);
                mChargeImg.setBackgroundResource(R.drawable.ic_charge);
                mTopTextView.setText("充电");
                mChargeText.setTextColor(getResources().getColor(R.color.colorGreen));
                break;

            case R.id.id_tab_me:
                resetImg();
                mViewpager.setCurrentItem(1);
                mMeImg.setBackgroundResource(R.drawable.ic_me);
                mTopTextView.setText("我的");
                mMeText.setTextColor(getResources().getColor(R.color.colorGreen));
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class nextActivity = null;
        switch (position){
            case 0:
                nextActivity = ToChargeActivity.class;
                break;
            case 1:
                nextActivity = AppointmentActivity.class;
                break;
            case 2:
                nextActivity = PayActivity.class;
                break;
            case 3:
                nextActivity = SearchActivity.class;
                break;
            case 4:
                nextActivity = InfoActivity.class;
                break;
        }
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,nextActivity);
        startActivity(intent);
        overridePendingTransition(R.animator.to_right, R.animator.to_left);
    }

    private void resetImg() {
        mChargeImg.setBackgroundResource(R.drawable.ic_charge_black);
        mMeImg.setBackgroundResource(R.drawable.ic_me_black);
        mChargeText.setTextColor(Color.BLACK);
        mMeText.setTextColor(Color.BLACK);
    }

}
