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
public class MeListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private String[] mainItems = {"充电记录","充值记录","关于","注销"};
    private int[] ids = {
            R.drawable.ic_payrecord,
            R.drawable.ic_chargerecord,
            R.drawable.ic_about,
            R.drawable.ic_logoff};

    public MeListAdapter(Context context){
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
            convertView = mInflater.inflate(R.layout.item_melist,parent,false);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.label = (TextView) convertView.findViewById(R.id.textView_label);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        try {
            holder.label.setText(mainItems[position]);
            holder.icon.setBackgroundResource(ids[position]);

        }catch (Exception e){
        }
        return convertView;
    }

    private static class ViewHolder{
        TextView label;
        ImageView icon;
    }
}


