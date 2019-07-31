package com.example.fragments;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity implements Controller.ControllerListener{

    Controller controller;
    TextViewFragment textViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller();
        textViewFragment = new TextViewFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment,controller)
                .add(R.id.fragment2,textViewFragment)
                .commit();
    }

    @Override
    public void onSaveClicked(String input) {
        textViewFragment.updateText(input);
    }

    @Override
    public void update() {
        textViewFragment.updateStyle(controller.isBold,controller.isItalic,controller.isUnderline);
    }

    @Override
    public void setSize() {
        controller.size = textViewFragment.getSize();
    }

    @Override
    public void size(float size) {
        textViewFragment.updateSize(size);
    }

}
