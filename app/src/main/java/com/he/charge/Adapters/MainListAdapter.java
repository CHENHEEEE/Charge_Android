package com.he.charge.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.he.charge.R;

/**
 * Created by HE on 2016/10/23.
 * 重写baseAdapter，提高listview载入速度
 */
public class MainListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private String[] mainItems = {"我要充电","预约充电","快速充值","充电桩搜索","充电资讯"};
    private String[] subItems = {
            "接通电源后，点击此处进行充电",
            "提前申请，助您充电无忧",
            "随时随地，快速充值",
            "搜索您附近的充电桩位置",
            "获取最新最权威的充电信息"};
    private int[] ids = {
            R.drawable.ic_tocharge,
            R.drawable.ic_appointment,
            R.drawable.ic_pay,
            R.drawable.ic_search,
            R.drawable.ic_info};

    public MainListAdapter(Context context){
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mainItems.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_mainlist,parent,false);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.mainText = (TextView) convertView.findViewById(R.id.mainText);
            holder.subText = (TextView) convertView.findViewById(R.id.subText);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        try {
            holder.mainText.setText(mainItems[position]);
            holder.subText.setText(subItems[position]);
            holder.icon.setBackgroundResource(ids[position]);

        }catch (Exception e){
        }
        return convertView;
    }

    private static class ViewHolder{
        TextView mainText;
        TextView subText;
        ImageView icon;
    }
}


