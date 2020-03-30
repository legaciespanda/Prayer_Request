package com.ernest.prayerrequest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ernest.prayerrequest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomBar)
    SmoothBottomBar sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buterknife initialized
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        sm.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int pos) {
                switch (pos){
                    case 0:
                        Intent home = new Intent(MainActivity, MainActivity.class);
                        startActivity(home);
                        break;
                    case 1:
                        Intent newsletter = new Intent(this, Newsletter.class);
                        startActivity(newsletter);
                        break;
                    case 2:
                        Intent profile = new Intent(this, Profile.class);
                        startActivity(profile);
                        break;
                }

            }
        });

    }


}
