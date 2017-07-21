package com.example.administrator.my_ali_im.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.my_ali_im.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目：My_Ali_IM
 * 作者：Administrator
 * 时间：2017/7/19
 * 功能：
 */

public class MailListAdapter extends BaseAdapter {

    private List<String> mList = new ArrayList<>();
    private Context mContext;

    private LayoutInflater mInflater;

    public MailListAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.mail_list_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTxFriend.setText(mList.get(position));

        return convertView;
    }





    static class ViewHolder {
        @BindView(R.id.tx_friend)
        TextView mTxFriend;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
