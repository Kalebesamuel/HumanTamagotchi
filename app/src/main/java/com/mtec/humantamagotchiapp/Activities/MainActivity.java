package com.mtec.humantamagotchiapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mtec.humantamagotchiapp.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager slideViewPage;
    private LinearLayout dotLayout;
    private TextView[] dots;
    private SliderHome sliderHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideViewPage = findViewById(R.id.slidePage);
        dotLayout = findViewById(R.id.containerDot);

        sliderHome = new SliderHome(this);
        slideViewPage.setAdapter(sliderHome);

        addDotsIndicator(0);

        slideViewPage.addOnPageChangeListener(viewListener);
    }

    //Metodo para adicionar os idicadores das páginas do slide
    public void addDotsIndicator(int position){

        dots = new TextView[3];
        dotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            dotLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    //Chama evento quando a página for mudada.
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



        }

        //Quando a página for mudada chama-se o metodo para adicionar os indicadores.
        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
 }
