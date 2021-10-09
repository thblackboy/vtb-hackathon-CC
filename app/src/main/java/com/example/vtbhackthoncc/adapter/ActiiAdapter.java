package com.example.vtbhackthoncc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vtbhackthoncc.ActiiFragment;
import com.example.vtbhackthoncc.R;
import com.example.vtbhackthoncc.classes.Actii;

import java.util.List;

public class ActiiAdapter extends BaseAdapter {

    private List<Actii> list;
    private LayoutInflater layoutInflater;

    public ActiiAdapter(ActiiFragment context, List<Actii> list){
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
            view = layoutInflater.inflate(R.layout.actiidep_layout,viewGroup,false);
        }
        Actii act = getAction(i);
        TextView name=(TextView) view.findViewById(R.id.actName);
        TextView price=(TextView) view.findViewById(R.id.actprice);
        name.setText(act.getName());
        price.setText(""+act.getPrice());

        return view;
    }

    private Actii getAction(int i){
        return (Actii) getItem(i);
    }
}
