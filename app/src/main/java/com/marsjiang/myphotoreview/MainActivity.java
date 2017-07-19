package com.marsjiang.myphotoreview;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.marsjiang.myphotoreview.adapter.MyPageAdapter;
import com.marsjiang.myphotoreview.util.CommonUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mShowBottomSheet;
    private ViewPager viewPager;
    private ArrayList<String> imagePaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        imagePaths = new ArrayList<String>();
        imagePaths.add("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=e38382fec3ea15ce55e3e85bd7695196/3ac79f3df8dcd1005a19145a788b4710b8122fc0.jpg");
        imagePaths.add("https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=832677fd72899e516c83324623ceb256/500fd9f9d72a605993f1451a2134349b023bbac9.jpg");
        imagePaths.add("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=66e569c2bb119313d34ef7e2045167b2/9345d688d43f87949164ef2edb1b0ef41bd53a12.jpg");
    }

    /**
     * 初始化布局
     */
    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.vp_image);
        MyPageAdapter myPageAdapter = new MyPageAdapter(this, imagePaths);
        viewPager.setAdapter(myPageAdapter);
        //获取到Bottom Sheet对象
        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        behavior.setPeekHeight(CommonUtil.getScreenHeight(this));
        mShowBottomSheet = (Button) findViewById(R.id.button);
        mShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(behavior);
            }
        });
    }

    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

}
