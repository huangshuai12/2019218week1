package com.example.a1.huangshuai20190218.presenter;

import com.example.a1.huangshuai20190218.contract.LoadContract;
import com.example.a1.huangshuai20190218.model.LoadModel;
import com.example.a1.huangshuai20190218.net.RequestCallBack;

import java.util.HashMap;

public class LoadPresenter extends LoadContract.Lloadpresenter {
    private LoadContract.LloadView lloadView;
    private final LoadModel loadModel;

    public LoadPresenter(LoadContract.LloadView lloadView) {
        this.lloadView = lloadView;
        loadModel = new LoadModel();
    }

    @Override
    public void ppresenter(HashMap<String, String> map) {
        loadModel.model(map, new RequestCallBack() {
            @Override
            public void onSuccess(String result) {
                if (lloadView!=null){
                    lloadView.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (lloadView!=null){
                    lloadView.onFailUre(msg);
                }
            }
        });
    }
}
