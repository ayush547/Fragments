package com.example.fragments;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Controller extends Fragment {
    ControllerListener listener;

    Boolean isBold=false,isItalic=false,isUnderline=false;
    String text;
    float size;
    EditText inputText;
    Button saveText,minus,plus;
    TextView bold,italics,underline;
    public Controller() {
        // Required empty public constructor
    }

    public interface ControllerListener{
        void onSaveClicked(String input);
        void update();
        void setSize();
        void size(float size);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_controller, container, false);
        inputText = view.findViewById(R.id.inputText);
        saveText = view.findViewById(R.id.saveText);
        minus = view.findViewById(R.id.minus);
        plus = view.findViewById(R.id.plus);
        bold = view.findViewById(R.id.bold);
        italics = view.findViewById(R.id.italics);
        underline = view.findViewById(R.id.underline);

        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = inputText.getText().toString();
                listener.onSaveClicked(text);
            }
        });

        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBold = true;
                isItalic = false;
                isUnderline = false;
                bold.setTypeface(null, Typeface.ITALIC);
                italics.setTypeface(null, Typeface.NORMAL);
                underline.setTypeface(null, Typeface.NORMAL);
                listener.update();
            }
        });
        italics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBold = false;
                isItalic = true;
                isUnderline = false;
                bold.setTypeface(null, Typeface.NORMAL);
                italics.setTypeface(null, Typeface.ITALIC);
                underline.setTypeface(null, Typeface.NORMAL);
                listener.update();
            }
        });
        underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBold = false;
                isItalic = false;
                isUnderline = true;
                bold.setTypeface(null, Typeface.NORMAL);
                italics.setTypeface(null, Typeface.NORMAL);
                underline.setTypeface(null, Typeface.ITALIC);
                listener.update();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.setSize();
                size-=0.2;
                listener.size(size);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.setSize();
                size+=0.2;
                listener.size(size);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ControllerListener) context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
    }
}
