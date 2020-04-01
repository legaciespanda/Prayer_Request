package com.ernest.prayerrequest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ernest.prayerrequest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class Profile extends AppCompatActivity {
    @BindView(R.id.bottomBar)
    SmoothBottomBar sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Buterknife initialized
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        sm.setOnItemSelectedListener(new OnItemSelectedListener() {
            Intent intent;
            @Override
            public void onItemSelect(int pos) {
                switch (pos){
                    case 0:
                        intent = new Intent(Profile.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Profile.this, Newsletter.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Profile.this, Profile.class);
                        startActivity(intent);
                        break;
                }

            }
        });

    }
}
