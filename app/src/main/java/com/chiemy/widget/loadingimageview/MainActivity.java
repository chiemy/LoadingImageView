package com.chiemy.widget.loadingimageview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RadioGroup;

import com.larswerkman.holocolorpicker.ColorPicker;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LoadingImageView loadingImageView = (LoadingImageView) findViewById(R.id.loadingiv);

        ColorPicker colorPicker = (ColorPicker) findViewById(R.id.picker);
        colorPicker.setOnColorSelectedListener(new ColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int i) {
                loadingImageView.setMaskColor(i);
            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        rg.check(rg.findViewWithTag(loadingImageView.getMaskOrientation() + "").getId());
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String tag = (String) group.findViewById(checkedId).getTag();
                loadingImageView.setMaskOrientation(Integer.parseInt(tag));
            }
        });

    }

}
