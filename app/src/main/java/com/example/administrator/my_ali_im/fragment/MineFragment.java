package com.example.administrator.my_ali_im.fragment;


import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.my_ali_im.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目：OkHttp_Retrofit
 * 作者：nbcei
 * 时间：2017/7/7
 * 功能：我的
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.button)
    Button mButton;

    @Override
    public void initView() {

    }

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }


    @OnClick(R.id.button)
    public void onClick() {
        Toast.makeText(getActivity(), "点击了按钮", Toast.LENGTH_SHORT).show();
    }
}
