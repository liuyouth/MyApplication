package com.example.brzt.text;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView text_btn ;
    private LinearLayout m_linearlayout ;
    private ImageView m_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        text_btn = (TextView)findViewById(R.id.text_btn);
        m_linearlayout = (LinearLayout) findViewById(R.id.m_linearlayout);
        m_img = (ImageView) findViewById(R.id.img_walk);
        m_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator oa = ObjectAnimator.ofFloat(m_linearlayout, "scaleX", 0, 50);
                ObjectAnimator oa1 = ObjectAnimator.ofFloat(m_linearlayout, "scaleY", 0, 100);
                ObjectAnimator oa2 = ObjectAnimator.ofFloat(m_img, "X", m_img.getX(), m_img.getX()+100);
                ObjectAnimator oa3 = ObjectAnimator.ofFloat(m_img, "Y", m_img.getY(), m_img.getY()-100);
                ObjectAnimator oa4 = ObjectAnimator.ofFloat(m_img, "X", m_img.getX(), m_img.getX()-200);
                ObjectAnimator oa5 = ObjectAnimator.ofFloat(m_img, "Y", m_img.getY(), m_img.getY()-50);
                ObjectAnimator oa6 = ObjectAnimator.ofFloat(m_img, "rotationX", 0f,270f);
                oa.setDuration(1500);
                oa1.setDuration(1500);
                oa2.setDuration(1000);
                oa3.setDuration(1000);
                oa4.setDuration(1000);
                oa5.setDuration(1000);
                oa6.setDuration(10);

                AnimatorSet as= new AnimatorSet();
                as.play(oa3).with(oa2);
                as.play(oa).after(oa2);
                as.play(oa).with(oa1);
                as.play(oa6).after(oa1);
                as.play(oa6).with(oa5);
                as.play(oa5).with(oa4);
                as.start();
                as.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);



                        }
                });






            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
