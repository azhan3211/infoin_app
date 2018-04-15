package com.r.seminarevent.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.r.seminarevent.R;

/**
 * Created by Unknown on 3/18/2018.
 */

public class FragmentSetting extends Fragment {

    RelativeLayout relativeLayout;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_layout, container, false);
        initialVariable(view);
        moveText();
        return view;
    }

    private void initialVariable(View view) {
        relativeLayout = (RelativeLayout) view.findViewById(R.id.textMoveAreaCL);
        textView = (TextView) view.findViewById(R.id.moveTextTV);
    }

    private void moveText(){
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                    textView.setX(motionEvent.getX());
                    textView.setY(motionEvent.getY());
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    textView.setX(motionEvent.getX());
                    textView.setY(motionEvent.getY());
                }
                return true;
            }
        });
    }
}
