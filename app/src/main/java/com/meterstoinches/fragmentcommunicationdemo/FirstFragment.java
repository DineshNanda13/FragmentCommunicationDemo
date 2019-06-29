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

public class FirstFragment extends Fragment {
    FirstFragmentListener firstFragmentListener;
    EditText editText_firstfragment;
    Button btn_firstfragment;

    public interface FirstFragmentListener{
        void sendFirstEdittextInput(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        editText_firstfragment = view.findViewById(R.id.editText_firstfragment);
        btn_firstfragment = view.findViewById(R.id.btn_firstfragment);
        btn_firstfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText_firstfragment.getText();
                firstFragmentListener.sendFirstEdittextInput(input);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FirstFragmentListener){
            firstFragmentListener = (FirstFragmentListener) context;
        }else {
            throw new RuntimeException(context.toString()+ " must implement firstFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        firstFragmentListener = null;
    }
    public void updateEditText(CharSequence input){
        editText_firstfragment.setText(input);
    }
}
