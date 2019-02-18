package com.example.a1.huangshuai20190218.model;

import android.os.Handler;

import com.example.a1.huangshuai20190218.Api.UserApi;
import com.example.a1.huangshuai20190218.contract.LoadContract;
import com.example.a1.huangshuai20190218.net.OkHttpCallBack;
import com.example.a1.huangshuai20190218.net.OkHttpUtiles;
import com.example.a1.huangshuai20190218.net.RequestCallBack;

import java.util.HashMap;

public class LoadModel implements LoadContract.LloadModel {
    private Handler handler=new Handler();
    @Override
    public void model(HashMap<String, String> map, final RequestCallBack callBack) {
        OkHttpUtiles.getmInsxcvczmn().doPost(UserApi.USER_API, map, new OkHttpCallBack() {
            @Override
            public void onSuccess(final String result) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });
                }
            }

            @Override
            public void onFailUre(final String msg) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onFailUre(msg);
                        }
                    });
                }
            }
        });
    }
}
