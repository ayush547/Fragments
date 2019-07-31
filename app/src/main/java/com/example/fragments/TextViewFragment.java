package com.example.fragments;


import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextViewFragment extends Fragment {

    android.widget.TextView textView;

    public TextViewFragment() {
        // Required empty public constructor
    }

    public void updateText(String text){
        textView.setText(text);
    }
    public void updateSize(float size){
        textView.setTextSize(size);
    }
    public float getSize(){
        return textView.getTextSize();
    }

    public void updateStyle(Boolean bold,Boolean italics,Boolean underline){
        textView.setTypeface(null,Typeface.NORMAL);
        textView.setPaintFlags(0);
        if(bold) textView.setTypeface(textView.getTypeface(),Typeface.BOLD);
        else if(italics) textView.setTypeface(textView.getTypeface(),Typeface.ITALIC);
        else if(underline) textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_view, container, false);
        textView = view.findViewById(R.id.textView);
        return view;
    }

}
