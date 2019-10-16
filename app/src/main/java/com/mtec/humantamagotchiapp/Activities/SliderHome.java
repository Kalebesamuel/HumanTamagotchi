package com.mtec.humantamagotchiapp.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.mtec.humantamagotchiapp.R;

/**Esta classe define os slides que serão mostrados na página inicial do App
 * apresentando as suas funcionalidades principais.
 */

public class SliderHome extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderHome(Context context) {
        this.context = context;
    }

    //icones que serão usados no slide
    public int[] slideImages = {

            R.drawable.comidasaudavel,
            R.drawable.criasrpersonagensecompartilhar,
            R.drawable.reeducacaoalimentar

    };

    //headers de cada slide
    public String[] headers = {

            "Alimentação Saúdavel",
            "Compartilhamento",
            "Reeducação alimentar"

    };

    //descrições das funcionalidades
    public String[] slideDescricao = {

            "Nós te ajudaremos a obter uma alimentação muito mais saúdavel.",
            "Crie quantos personagens quiser, compartilhe com toda a família e amigos.",
            "Defina uma dieta e ative as notificaçõe e nós te lembraremos de cumpri-lá todo dia."

    };

    //define a quantidade de slides
    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slideImage);
        TextView headerSlides = view.findViewById(R.id.sliderHeader);
        TextView descSlide =  view.findViewById(R.id.descSlide);

        slideImageView.setImageResource(slideImages[position]);
        headerSlides.setText(headers[position]);
        descSlide.setText(slideDescricao[position]);

        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }


}
