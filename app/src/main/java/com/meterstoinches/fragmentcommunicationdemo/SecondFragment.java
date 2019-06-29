package com.meterstoinches.fragmentcommunicationdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondFragment extends Fragment {
    SecondFragmentListener secondFragmentListener;
    EditText editText_secondfragment;
    Button btn_secondfragment;

    public interface SecondFragmentListener{
        void sendSecondEdittextInput(CharSequence input);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        editText_secondfragment = view.findViewById(R.id.editText_secondfragment);
        btn_secondfragment = view.findViewById(R.id.btn_secondfragment);
        btn_secondfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText_secondfragment.getText();
                secondFragmentListener.sendSecondEdittextInput(input);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof SecondFragmentListener){
            secondFragmentListener = (SecondFragmentListener) context;
        }else {
            throw new RuntimeException(context.toString()+ " must implement secondFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        secondFragmentListener = null;
    }
    public void updateEditText(CharSequence input){
        editText_secondfragment.setText(input);
    }
}
