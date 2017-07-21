package com.example.administrator.my_ali_im.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目：MVP_Dagger_RxJava
 * 作者：nbcei
 * 时间：2017/6/2
 * 功能：
 */

public abstract class BaseFragment extends Fragment{



    private View mRootView;


    private Unbinder mUnbinder;




    private boolean isViewCreated;
    private boolean isLoadDataCompleted;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        mRootView= inflater.inflate(setLayout(), container, false);
        mUnbinder=  ButterKnife.bind(this, mRootView);
        Log.e("main", "onCreateView: " );
        isViewCreated=true;
        return mRootView;

    }

    /***
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //View的初始化View
        initView();
        if (getUserVisibleHint()){
            loadData();
        }
    }

    /***
     * 当用户可见当时候加载数据
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser&&isViewCreated&&isLoadDataCompleted){
            loadData();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    /***
     * 初始化view
     */
    public abstract void  initView();

    /***
     * 加载数据
     */
    public  void  loadData(){
        isLoadDataCompleted=true;
    }








    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
        }

    }




    public abstract int setLayout();




}
