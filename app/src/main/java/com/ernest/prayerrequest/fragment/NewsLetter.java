package com.ernest.prayerrequest.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ernest.prayerrequest.R;
import com.ernest.prayerrequest.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsLetter extends Fragment {
    private View root_view, parent_view;
    private MainActivity mainActivity;
    LinearLayout lyt_root;


    public NewsLetter() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root_view =  inflater.inflate(R.layout.fragment_news_letter, container, false);
        //root_view = inflater.inflate(R.layout.fragment_news_letter,null);
        parent_view = root_view.findViewById(R.id.main);

        return root_view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
