package com.example.vtbhackthoncc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vtbhackthoncc.ActiiFragment;
import com.example.vtbhackthoncc.NewsFragment;
import com.example.vtbhackthoncc.R;
import com.example.vtbhackthoncc.classes.Actii;
import com.example.vtbhackthoncc.classes.News;

import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private List<News> list;
    private LayoutInflater layoutInflater;

    public NewsAdapter(NewsFragment context, List<News> list){
        this.list=list;
        layoutInflater=(LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = layoutInflater.inflate(R.layout.news_layout,viewGroup,false);
        }
        News news = getAction(i);
        TextView head=(TextView) view.findViewById(R.id.headline);
        TextView textView=(TextView) view.findViewById(R.id.textView);


        head.setText(news.getHead());
        textView.setText(""+news.getMess());


        return view;
    }

    private News getAction(int i){
        return (News) getItem(i);
    }
}
