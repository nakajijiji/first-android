package com.example.mayuhei.helloworld.activity;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.adapter.DefaultPagerAdapter;
import com.example.mayuhei.helloworld.api.DummyGetItemApi;
import com.example.mayuhei.helloworld.api.DummyGetItemRequest;
import com.example.mayuhei.helloworld.api.GetItemApi;
import com.example.mayuhei.helloworld.entity.GetItemRequest;
import com.example.mayuhei.helloworld.entity.GetItemResult;
import com.example.mayuhei.helloworld.handler.GetItemResultHandler;
import com.example.mayuhei.helloworld.handler.JustSleep;
import com.example.mayuhei.helloworld.handler.UpdateTabView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GetItemApi getItemApi = new DummyGetItemApi();
    private List<GetItemResultHandler> handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupRefresh();
    }

    private GetItemRequest buildGetItemRequest(){
        return new DummyGetItemRequest();
    }

    private void setupRefresh(){
        final GetItemRequest request = buildGetItemRequest();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        GetItemResult result = getItemApi.getItem(request);
                        handlers = Arrays.asList(new UpdateTabView((ViewPager) findViewById(R.id.viewPager)), new JustSleep());
                        for(GetItemResultHandler handler : handlers){
                            handler.handle(result);
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    private void setupViews(){
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        DefaultPagerAdapter adapter = new DefaultPagerAdapter(manager, Arrays.asList("服", "ズボン", "おもちゃ"));
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
