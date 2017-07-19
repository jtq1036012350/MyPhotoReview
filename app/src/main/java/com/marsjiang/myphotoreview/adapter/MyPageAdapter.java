package com.marsjiang.myphotoreview.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.marsjiang.myphotoreview.R;

import java.util.ArrayList;

/**
 * Created by Jiang on 2017-07-19.
 */

public class MyPageAdapter extends PagerAdapter {
    private ArrayList<String> imagePaths;
    private Context context;

    public MyPageAdapter(Context context, ArrayList<String> imagePaths) {
        this.context = context;
        this.imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.image_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_test);
        Glide.with(context).load(imagePaths.get(position)).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
