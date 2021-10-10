package com.example.vtbhackthoncc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.vtbhackthoncc.adapter.ActiiAdapter;
import com.example.vtbhackthoncc.classes.Actii;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActiiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActiiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static List<Actii> actiiList= loadList();




    public ActiiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActiiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActiiFragment newInstance(String param1, String param2) {
        ActiiFragment fragment = new ActiiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_actii, container, false);

        ActiiAdapter adapter = new ActiiAdapter(this,actiiList);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return rootView;


    }
    public static List loadList(){
        List<Actii> list = new ArrayList<>();
        list.add(new Actii("pig",10000,R.drawable.pig));
        list.add(new Actii("cow",1525,R.drawable.cow));
        list.add(new Actii("mil",9778,R.drawable.camel));
        list.add(new Actii("dog",33,R.drawable.dog));
        list.get(0).addDepAct(list.get(1));
        list.get(0).addDepAct(list.get(1));
        list.get(0).addDepAct(list.get(2));
        list.get(0).addDepAct(list.get(3));

        list.get(1).addDepAct(list.get(0));
        list.get(1).addDepAct(list.get(3));
        list.get(1).addDepAct(list.get(2));
        list.get(1).addDepAct(list.get(1));

        list.get(2).addDepAct(list.get(1));
        list.get(2).addDepAct(list.get(1));
        list.get(2).addDepAct(list.get(0));
        list.get(2).addDepAct(list.get(3));

        list.get(3).addDepAct(list.get(0));
        list.get(3).addDepAct(list.get(1));
        list.get(3).addDepAct(list.get(2));
        list.get(3).addDepAct(list.get(0));
        for(Actii act:list){
            Data.actions.put(act.getName(),act);
        }
        return  list;
    }
}