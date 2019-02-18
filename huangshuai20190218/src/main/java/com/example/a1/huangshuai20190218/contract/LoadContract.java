package com.example.a1.huangshuai20190218.contract;

import com.example.a1.huangshuai20190218.net.RequestCallBack;

import java.util.HashMap;

public interface LoadContract {

    public abstract class Lloadpresenter{
        public abstract void ppresenter(HashMap<String,String> map);
    }
    interface LloadModel{
        void model(HashMap<String,String> map, RequestCallBack callBack);
    }
    interface LloadView{
        void onSuccess(String result);
        void onFailUre(String msg);

    }
}
