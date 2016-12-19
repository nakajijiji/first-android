package com.example.mayuhei.helloworld.activity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.adapter.DefaultPagerAdapter;
import com.example.mayuhei.helloworld.api.DummyGetItemApi;
import com.example.mayuhei.helloworld.api.DummyGetItemApi_V2;
import com.example.mayuhei.helloworld.api.DummyGetItemRequest;
import com.example.mayuhei.helloworld.api.GetItemApi;
import com.example.mayuhei.helloworld.data.SharedPreferenceKey;
import com.example.mayuhei.helloworld.entity.Baby;
import com.example.mayuhei.helloworld.entity.GetItemRequest;
import com.example.mayuhei.helloworld.entity.GetItemResult;
import com.example.mayuhei.helloworld.handler.GetItemResultHandler;
import com.example.mayuhei.helloworld.handler.JustSleep;
import com.example.mayuhei.helloworld.handler.UpdateTabView;
import com.example.mayuhei.helloworld.util.JsonSerializer;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IntroFinishListner{
    private Toolbar toolbar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private GetItemApi getItemApi = new DummyGetItemApi_V2();
    private List<GetItemResultHandler> handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.handlers = Arrays.asList(new UpdateTabView((ViewPager) findViewById(R.id.viewPager)), new JustSleep());
        setupViews();
        setupRefresh();
        if(showsIntroduction()){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.FragmentContainer, IntroductionFragment.newInstance());
            transaction.replace(R.id.FragmentContainer, IntroductionFragment.newInstance());
            transaction.commit();
        }

    }

    private boolean showsIntroduction(){
        SharedPreferences preferences = getSharedPreferences(SharedPreferenceKey.SHOW_INTRODUCTION, MODE_PRIVATE);
        return preferences.getBoolean(SharedPreferenceKey.SHOW_INTRODUCTION, true);
    }

    private GetItemRequest buildGetItemRequest(){
        GetItemRequest request = new GetItemRequest();
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferenceKey.BABY, MODE_PRIVATE);
        Baby baby = JsonSerializer.deserialize(sharedPreferences.getString(SharedPreferenceKey.BABY, null), Baby.class);
        request.setBaby(baby);
        return request;
    }

    private void doRefresh(){
        GetItemRequest request = buildGetItemRequest();
        GetItemResult result = getItemApi.getItem(request);

        for(GetItemResultHandler handler : handlers){
            handler.handle(result);
        }
    }

    private void setupRefresh(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doRefresh();
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
        DefaultPagerAdapter adapter = new DefaultPagerAdapter(manager, new DummyGetItemApi().getItem(new DummyGetItemRequest()).getChannels());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onIntroFinish() {
        doRefresh();
        SharedPreferences preferences = getSharedPreferences(SharedPreferenceKey.SHOW_INTRODUCTION, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(SharedPreferenceKey.SHOW_INTRODUCTION, false);
        Log.d("debug", "succeed");
    }
}
