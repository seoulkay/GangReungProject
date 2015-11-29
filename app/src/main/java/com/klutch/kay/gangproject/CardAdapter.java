package com.klutch.kay.gangproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Edwin on 18/01/2015.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<NatureItem> mItems;

    public CardAdapter(Context context) {
        super();
        mItems = new ArrayList<NatureItem>();
        NatureItem nature = new NatureItem();
        nature.setName("Purchase Tickets");
        nature.setEng("How much is the admission fee/ticket?");
        nature.setKor("입장료(티켓) 얼마예요?");
        nature.setSound("Ticket eol ma ye yo?");
        nature.setThumbnail(R.drawable.img_ticket);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Purchase Ticket");
        nature.setEng("Where can I buy the admission ticket?");
        nature.setKor("티켓 어디서 사요?");
        nature.setSound("Ticket Eo di seo sa yo?");
        nature.setThumbnail(R.drawable.img_ticket);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Buy Stuff");
        nature.setEng("How much is this?");
        nature.setKor("얼마예요?");
        nature.setSound("Eol ma ye yo?");
        nature.setThumbnail(R.drawable.img_purchase);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Buy Stuff");
        nature.setEng("This is too expensive. Please give me some discount.");
        nature.setKor("너무 비싸요. 좀 깎아주세요.");
        nature.setSound("Neo mu bi ssa yo. jom kka kka ju se yo.");
        nature.setThumbnail(R.drawable.img_purchase);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Tax Free");
        nature.setEng("Is this tax free?");
        nature.setKor("면세 되나요?");
        nature.setSound("Tax-free de na yo?");
        nature.setThumbnail(R.drawable.img_info);
        mItems.add(nature);

        nature = new NatureItem();
        nature.setName("Taxi");
        nature.setEng("Sir, I would like to go to this place.");
        nature.setKor("기사님. 여기로 가주세요.");
        nature.setSound("Gi sa nim, yeo gi jom ga ju se yo.");
        nature.setThumbnail(R.drawable.img_taxi);
        mItems.add(nature);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //누를때 호출
                //v.setBackgroundColor(Color.RED);
            }
        });
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        NatureItem nature = mItems.get(i);
        viewHolder.tvNature.setText(nature.getName());
        viewHolder.eng_expression.setText(nature.getEng());
        viewHolder.kor_expression.setText(nature.getKor());
        viewHolder.kor_sound.setText(nature.getSound());
        //썸네일 메모리에러
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvNature;
        public TextView eng_expression;
        public TextView kor_expression;
        public TextView kor_sound;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvNature = (TextView)itemView.findViewById(R.id.tv_nature);
            eng_expression = (TextView)itemView.findViewById(R.id.eng_expression);
            kor_expression = (TextView)itemView.findViewById(R.id.kor_expression);
            kor_sound = (TextView)itemView.findViewById(R.id.kor_sound);
        }
    }

}