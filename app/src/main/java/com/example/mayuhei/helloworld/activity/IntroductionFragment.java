package com.example.mayuhei.helloworld.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.mayuhei.helloworld.R;
import com.example.mayuhei.helloworld.data.SharedPreferenceKey;
import com.example.mayuhei.helloworld.entity.Baby;
import com.example.mayuhei.helloworld.introduction.HeightValidator;
import com.example.mayuhei.helloworld.introduction.NameValidator;
import com.example.mayuhei.helloworld.introduction.UserProfile;
import com.example.mayuhei.helloworld.introduction.Validator;
import com.example.mayuhei.helloworld.util.BabyUtils;
import com.example.mayuhei.helloworld.util.JsonSerializer;
import com.example.mayuhei.helloworld.util.Timestamp;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class IntroductionFragment extends Fragment {
    private IntroFinishListner introFinishListner;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Validator> validators = Arrays.asList(new NameValidator(), new HeightValidator());

    public IntroductionFragment() {
        // Required empty public constructor
    }

    public static IntroductionFragment newInstance() {
        IntroductionFragment fragment = new IntroductionFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(!(context instanceof IntroFinishListner)){
            throw new IllegalStateException();
        }
        introFinishListner = (IntroFinishListner)context;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void finish(){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.remove(this).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_introduction, container, false);
        Button button = (Button)view.findViewById(R.id.intro_send);
        button.setOnClickListener(new View.OnClickListener() {
            private UserProfile buildProfile(View v){
                // name
                EditText editText = (EditText)v.findViewById(R.id.intro_baby_name);
                CharSequence seq = editText.getText();
                String name = seq == null ? null : seq.toString();

                // gender
                RadioGroup genderButton = (RadioGroup)v.findViewById(R.id.intro_baby_gender);
                int selectedId = genderButton.getCheckedRadioButtonId();
                Log.d("id", String.valueOf(selectedId));
                RadioButton selectedButton = (RadioButton)v.findViewById(selectedId);
                String gender = selectedButton.getText().toString();

                // age
                NumberPicker picker = (NumberPicker)v.findViewById(R.id.intro_baby_height);
                int value = picker.getValue();

                UserProfile result = new UserProfile();
                Baby baby = new Baby();
                baby.setName(name);
                baby.setGender(BabyUtils.toGender(gender));
                baby.setSize(BabyUtils.toSize(value, Timestamp.now()));
                result.setBaby(baby);
                return result;
            }

            @Override
            public void onClick(View v) {
                UserProfile profile = buildProfile(view);
                for(Validator validator : validators) {
                    Validator.Status status = validator.handle(profile);
                    if(status == Validator.Status.INVALID){
                        //TODO
                    }
                }
                save(profile.getBaby());
                introFinishListner.onIntroFinish();
                finish();
            }

            public void save(Baby baby){
                SharedPreferences sp = getContext().getSharedPreferences(SharedPreferenceKey.BABY, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(SharedPreferenceKey.BABY, JsonSerializer.serialize(baby));
                editor.commit();
            }
        });
        return view;
    }
}
