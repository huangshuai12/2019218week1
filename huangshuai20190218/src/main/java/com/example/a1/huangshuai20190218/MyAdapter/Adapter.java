package com.example.a1.huangshuai20190218.MyAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a1.huangshuai20190218.R;
import com.example.a1.huangshuai20190218.entity.UserBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends XRecyclerView.Adapter<Adapter.ViewHoder> {
    private Context context;
    private List<UserBean.DataBean> list;
    private static final int one=0;
    private static final int two=1;
    public Adapter(Context context) {
        this.context = context;
        this.list=new ArrayList<>();
    }

    public void setList(List<UserBean.DataBean> list){
        if (list!=null){
            this.list=list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Adapter.ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view=LayoutInflater.from(context).inflate(R.layout.linear,viewGroup,false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHoder viewHoder, int i) {
        list.get(i);
        viewHoder.name.setText(list.get(i).getTitle());
        viewHoder.price.setText(list.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        private TextView name,price;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
        }
    }
}
