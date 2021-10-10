package com.example.vtbhackthoncc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
        ImageView actImg=(ImageView) view.findViewById(R.id.actImg);
        ImageView depImg1=(ImageView) view.findViewById(R.id.depImg1);
        ImageView depImg2=(ImageView) view.findViewById(R.id.depImg2);
        ImageView depImg3=(ImageView) view.findViewById(R.id.depImg3);
        ImageView depImg4=(ImageView) view.findViewById(R.id.depImg4);

        name.setText(act.getName());
        price.setText(""+act.getPrice());
        int dur =(i+1)*150;

        actImg.setImageResource(act.getImg());
        depImg1.setImageResource(act.dA[0].getImg());
        depImg1.setTranslationY(-500f);
        depImg1.animate().translationYBy(500f).alpha(1f).setDuration(dur);
        depImg2.setImageResource(act.dA[1].getImg());
        depImg2.setTranslationY(-500f);
        depImg2.animate().translationYBy(500f).alpha(1f).setDuration(dur);
        depImg3.setImageResource(act.dA[2].getImg());
        depImg3.setTranslationY(-500f);
        depImg3.animate().translationYBy(500f).alpha(1f).setDuration(dur);
        depImg4.setImageResource(act.dA[3].getImg());
        depImg4.setTranslationY(-500f);
        depImg4.animate().translationYBy(500f).alpha(1f).setDuration(dur);


        return view;
    }

    private Actii getAction(int i){
        return (Actii) getItem(i);
    }
}
