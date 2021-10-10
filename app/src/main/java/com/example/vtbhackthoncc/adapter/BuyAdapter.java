package com.example.vtbhackthoncc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vtbhackthoncc.ActiiFragment;
import com.example.vtbhackthoncc.BuyFragment;
import com.example.vtbhackthoncc.R;
import com.example.vtbhackthoncc.classes.Actii;

import java.util.List;

public class BuyAdapter extends BaseAdapter {

    private List<Actii> list;
    private LayoutInflater layoutInflater;

    public BuyAdapter(BuyFragment context, List<Actii> list){
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
            view = layoutInflater.inflate(R.layout.buyactii_layout,viewGroup,false);
        }
        Actii act = getAction(i);
        TextView name=(TextView) view.findViewById(R.id.buyactName);
        TextView price=(TextView) view.findViewById(R.id.buyactprice);
        ImageView actImg=(ImageView) view.findViewById(R.id.buyactImg);
        Button buy = (Button) view.findViewById(R.id.butbuy);
        Button sell = (Button) view.findViewById(R.id.butsell);
        TextView currentCount = (TextView) view.findViewById(R.id.currentcount);


        name.setText(act.getName());
        price.setText(""+act.getPrice());
        buy.setTag(act.getName());
        sell.setTag(act.getName());

        actImg.setImageResource(act.getImg());




        return view;
    }

    private Actii getAction(int i){
        return (Actii) getItem(i);
    }
}
