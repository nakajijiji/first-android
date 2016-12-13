package com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.activity;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.adapter.CustomAdapter;
import com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuhei on 2016/12/09.
 */

public class ExampleFragment extends Fragment {
    private final static String BACKGROUND_COLOR = "background_color";
    private final static String FRAGMENT_ID = "fragment_id";

    public static Fragment newInstance(@ColorRes int IdRes, int id) {
        ExampleFragment result = new ExampleFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, IdRes);
        b.putInt(FRAGMENT_ID, id);
        result.setArguments(b);
        return result;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, null);
        GridView gridView =(GridView) view.findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), getAllItemObject(getArguments().getInt(FRAGMENT_ID)));
        gridView.setAdapter(customAdapter);
        gridView.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
        return view;
    }

    private List<Item> getAllItemObject(int id){
        List<Item> items = new ArrayList<>();
        if(id == 0) {
            items.add(new Item("AAA", "baby-sample.jpeg"));
            items.add(new Item("BBB", "baby-sample2.jpg"));
            items.add(new Item("CCC", "baby-sample.jpeg"));
            items.add(new Item("DDD", "baby-sample2.jpg"));
            items.add(new Item("EEE", "baby-sample.jpeg"));
            items.add(new Item("FFF", "baby-sample2.jpg"));
            items.add(new Item("GGG", "baby-sample.jpeg"));
            items.add(new Item("HHH", "baby-sample2.jpg"));
            items.add(new Item("III", "baby-sample.jpeg"));
        }else{
            items.add(new Item("AAA", "baby-sample.jpeg"));
            items.add(new Item("BBB", "baby-sample.jpeg"));
            items.add(new Item("CCC", "baby-sample.jpeg"));
            items.add(new Item("DDD", "baby-sample.jpeg"));
            items.add(new Item("EEE", "baby-sample.jpeg"));
            items.add(new Item("FFF", "baby-sample.jpeg"));
            items.add(new Item("GGG", "baby-sample.jpeg"));
            items.add(new Item("HHH", "baby-sample.jpeg"));
            items.add(new Item("III", "baby-sample.jpeg"));
        }
        return items;
    }
}
