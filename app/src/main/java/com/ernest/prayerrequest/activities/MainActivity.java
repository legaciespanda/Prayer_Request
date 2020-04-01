package com.ernest.prayerrequest.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.ernest.prayerrequest.R;
import com.ernest.prayerrequest.fragment.NewsLetter;
import com.ernest.prayerrequest.fragment.Prayer;
import com.ernest.prayerrequest.fragment.Profile;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.ibrahimsn.lib.OnItemReselectedListener;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomBar)
    SmoothBottomBar sm;
    Fragment fragment = null;
    private long exitTime = 0;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buterknife initialized
        ButterKnife.bind(this);

        initViews(); 
    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    private void initViews() {
        sm.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int pos) {
                switch (pos){
                    case 0:
                        Prayer prayer = new Prayer();
                        switchFragment(prayer);
                        break;
                    case 1:
                        NewsLetter newsLetter = new NewsLetter();
                        switchFragment(newsLetter);
                        break;
                    case 2:
                        Profile profile = new Profile();
                        switchFragment(profile);
                        break;
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
            showAlertDialog();
    }

    public void showAlertDialog(){
        if ((System.currentTimeMillis() - exitTime) > 2000){
            exitTime = System.currentTimeMillis();
        }
        else{
            //init alert dialog
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("Close App!");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Are you sure you want to exit Prayer Request?");
            //set listeners for dialog buttons
            builder.setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            //create alert dialog box and shows it
            builder.create().show();
        }
    }


}
