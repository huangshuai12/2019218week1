package com.example.a1.huangshuai20190218;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.a1.huangshuai20190218.MyAdapter.Adapter;
import com.example.a1.huangshuai20190218.contract.LoadContract;
import com.example.a1.huangshuai20190218.entity.UserBean;
import com.example.a1.huangshuai20190218.presenter.LoadPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements LoadContract.LloadView {

    private XRecyclerView xrec;
    private LoadPresenter loadPresenter;
    private int page=1;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadPresenter = new LoadPresenter(this);
        xrec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        HashMap<String,String> map = new HashMap<>();
        map.put("page","1");
        loadPresenter.ppresenter(map);
        adapter = new Adapter(this);
        xrec.setAdapter(adapter);

    }

    @Override
    public void onSuccess(String result) {
        UserBean userBean = new Gson().fromJson(result, UserBean.class);
        adapter.setList(userBean.getData());
    }

    @Override
    public void onFailUre(String data) {

    }

    private void initView() {
        xrec = (XRecyclerView) findViewById(R.id.xrec);
    }
}
