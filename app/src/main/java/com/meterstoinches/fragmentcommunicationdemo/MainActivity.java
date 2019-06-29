package com.meterstoinches.fragmentcommunicationdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements FirstFragment.FirstFragmentListener, SecondFragment.SecondFragmentListener {

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout1,firstFragment).replace(R.id.framelayout2,
                secondFragment).commit();
    }

    @Override
    public void sendFirstEdittextInput(CharSequence input) {
        secondFragment.updateEditText(input);
        firstFragment.updateEditText("");
    }

    @Override
    public void sendSecondEdittextInput(CharSequence input) {
        firstFragment.updateEditText(input);
        secondFragment.updateEditText("");
    }
}
