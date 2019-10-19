package com.mtec.humantamagotchiapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.mtec.humantamagotchiapp.R;

public class MainActivity extends AppCompatActivity {

    //===========PageHome
    private ViewPager slideViewPage;
    private LinearLayout dotLayout;
    private TextView[] dots;
    private SliderHome sliderHome;
    private Button leftPage;
    private Button rightPage;
    private int currentPage;

//===================================================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideViewPage = findViewById(R.id.slidePage);
        dotLayout = findViewById(R.id.containerDot);

        sliderHome = new SliderHome(this);
        slideViewPage.setAdapter(sliderHome);

        leftPage = findViewById(R.id.bt_slideLeft);
        rightPage = findViewById(R.id.bt_slideRight);

        addDotsIndicator(0);

        slideViewPage.addOnPageChangeListener(viewListener);

//===================================================================================================================================

        leftPage.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                slideViewPage.setCurrentItem(currentPage - 1);
            }

        });

//===================================================================================================================================

        rightPage.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(currentPage != dots.length - 1){

                    slideViewPage.setCurrentItem(currentPage + 1);
                } else {
                    //transaciona para a activity de login
                    callLoginScreen();
                }
            }

        });

    }

//===================================================================================================================================

    public void callLoginScreen(){
        Intent intent = new Intent(this, LoginGoogle.class);
        startActivity(intent);
    }

//===================================================================================================================================

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

//===================================================================================================================================

    //Chama evento quando a página for alterada de alguma forma.
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

//===================================================================================================================================

        //Quando a página for mudada chama-se o metodo para adicionar os indicadores e para controlar os botões.
        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;

            if(position == 0){
                rightPage.setEnabled(true);
                leftPage.setEnabled(false);
                leftPage.setVisibility(View.INVISIBLE);

                rightPage.setText("Próximo");
                leftPage.setText("");

            } else if(position == dots.length -1){
                rightPage.setEnabled(true);
                leftPage.setEnabled(true);
                leftPage.setVisibility(View.VISIBLE);

                rightPage.setText("Finish");
                leftPage.setText("Anterior");

            } else {
                rightPage.setEnabled(true);
                leftPage.setEnabled(true);
                leftPage.setVisibility(View.VISIBLE);

                rightPage.setText("Próximo");
                leftPage.setText("Anterior");
            }

        }

//===================================================================================================================================

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
 }
