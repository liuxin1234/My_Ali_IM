package com.example.administrator.my_ali_im.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.my_ali_im.IMsample.contact.FindContactActivity;
import com.example.administrator.my_ali_im.R;
import com.example.administrator.my_ali_im.adapter.MailListAdapter;
import com.example.administrator.my_ali_im.widget.NoScrollListview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目：OkHttp_Retrofit
 * 作者：nbcei
 * 时间：2017/7/7
 * 功能：通讯录
 */

public class MailListFragment extends BaseFragment {

    @BindView(R.id.Layout_add_find)
    LinearLayout mLayoutAddFind;
    @BindView(R.id.list_mail)
    NoScrollListview mListMail;

    private MailListAdapter mMailListAdapter;

    private List<String> mList = new ArrayList<>();

    @Override
    public void initView() {
        mList = new ArrayList<>();
        mList.add("小白1");
        mList.add("小白2");
        mList.add("小白3");
        mList.add("小白4");
        mList.add("小白5");
        mList.add("小白6");
        mList.add("小白7");
        mList.add("小白8");
        mList.add("小白1");
        mList.add("小白2");
        mList.add("小白3");
        mList.add("小白4");
        mList.add("小白5");
        mList.add("小白6");
        mList.add("小白7");
        mList.add("小白8");

        mMailListAdapter = new MailListAdapter(getActivity(),mList);
        mListMail.setAdapter(mMailListAdapter);
        mListMail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), "点击了："+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_maillist;
    }

    @OnClick(R.id.Layout_add_find)
    public void onClick() {
        Intent intent = new Intent(getActivity(), FindContactActivity.class);
        startActivity(intent);

    }


}
