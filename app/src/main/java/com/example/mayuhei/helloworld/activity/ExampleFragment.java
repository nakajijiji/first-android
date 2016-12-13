package com.example.mayuhei.helloworld.activity;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.adapter.CustomAdapter;
import com.example.mayuhei.helloworld.entity.Channel;
import com.example.mayuhei.helloworld.entity.GridResource;
import com.example.mayuhei.helloworld.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuhei on 2016/12/09.
 */

public class ExampleFragment extends Fragment {
    private final static String BACKGROUND_COLOR = "background_color";
    private final static String FRAGMENT_ID = "fragment_id";
    private final static String GRID_RESOURCE = "grid_resource";

    private GridResource resource;

    public static Fragment newInstance(@ColorRes int IdRes, int id, GridResource resource) {
        ExampleFragment result = new ExampleFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, IdRes);
        b.putInt(FRAGMENT_ID, id);
        result.setArguments(b);
        result.resource = resource;
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
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), resource.getIdToChannels().get(getArguments().getInt(FRAGMENT_ID)).getItems());
        gridView.setAdapter(customAdapter);
        gridView.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));
        return view;
    }
}
