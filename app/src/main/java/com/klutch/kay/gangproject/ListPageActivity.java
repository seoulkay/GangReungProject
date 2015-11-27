package com.klutch.kay.gangproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;

public class ListPageActivity extends AppCompatActivity {

    ArrayList<MyPlace> arPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);



        Intent intent = getIntent();
        String location = intent.getStringExtra("selectedItemId");
        switch (location) {
            case "HERE!":
                //locationName.setText("Hello Gangwon!");
                arPlace = getSkiGOlfVo("Hello Gangwon!", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("Hello Gangwon!", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("Hello Gangwon!", MainActivity.templeVo));
                break;
            case "GANG NEUNG":
                //locationName.setText("강릉시");
                arPlace = getSkiGOlfVo("강릉시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("강릉시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("강릉시", MainActivity.templeVo));
                break;
            case "PYEONG CHANG":
                //locationName.setText("평창군");
                arPlace = getSkiGOlfVo("평창군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("평창군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("평창군", MainActivity.templeVo));
                break;
            case "GO SEONG":
                //locationName.setText("고성군");
                arPlace = getSkiGOlfVo("고성군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("고성군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("고성군", MainActivity.templeVo));
                break;
            case "DONG HAE":
                //locationName.setText("동해시");
                arPlace = getSkiGOlfVo("동해시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("동해시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("동해시", MainActivity.templeVo));
                break;
            case "SAM CHEOK":
                //locationName.setText("삼척시");
                arPlace = getSkiGOlfVo("삼척시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("삼척시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("삼척시", MainActivity.templeVo));
                break;
            case "SOK CHO":
                //locationName.setText("속초시");
                arPlace = getSkiGOlfVo("속초시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("속초시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("속초시", MainActivity.templeVo));
                break;
            case "YANG GU":
                //locationName.setText("양구군");
                arPlace = getSkiGOlfVo("양구군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("양구군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("양구군", MainActivity.templeVo));
                break;
            case "YANG YANG":
                //locationName.setText("양양군");
                arPlace = getSkiGOlfVo("양양군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("양양군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("양양군", MainActivity.templeVo));
                break;
            case "YEONG WOL":
                //locationName.setText("영월군");
                arPlace = getSkiGOlfVo("영월군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("영월군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("영월군", MainActivity.templeVo));
                break;
            case "WON JU":
                //locationName.setText("원주시");
                arPlace = getSkiGOlfVo("원주시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("원주시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("원주시", MainActivity.templeVo));
                break;
            case "IN JE":
                //locationName.setText("인제군");
                arPlace = getSkiGOlfVo("인제군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("인제군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("인제군", MainActivity.templeVo));
                break;
            case "JEONG SEON":
                //locationName.setText("정선군");
                arPlace = getSkiGOlfVo("정선군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("정선군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("정선군", MainActivity.templeVo));
                break;
            case "CHEOR WON":
                //locationName.setText("철원군");
                arPlace = getSkiGOlfVo("철원군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("철원군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("철원군", MainActivity.templeVo));
                break;
            case "CHUN CHEON":
                //locationName.setText("춘천시");
                arPlace = getSkiGOlfVo("춘천시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("춘천시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("춘천시", MainActivity.templeVo));
                break;
            case "TAE BAEK":
                //locationName.setText("태백시");
                arPlace = getSkiGOlfVo("태백시", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("태백시", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("태백시", MainActivity.templeVo));
                break;
            case "HONG CHEON":
                //locationName.setText("홍천군");
                arPlace = getSkiGOlfVo("홍천군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("홍천군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("홍천군", MainActivity.templeVo));
                break;
            case "HWA CHEON":
                //locationName.setText("화천군");
                arPlace = getSkiGOlfVo("화천군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("화천군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("화천군", MainActivity.templeVo));
                break;
            case "HOENG SEONG":
                //locationName.setText("횡성군");
                arPlace = getSkiGOlfVo("횡성군", MainActivity.skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("횡성군", MainActivity.museumVo));
                arPlace.addAll(getSkiGOlfVo("횡성군", MainActivity.templeVo));
                break;
        }

        MyPlaceAdapter adapter = new MyPlaceAdapter(this, R.layout.list_item, arPlace);

        ListView list;
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    

    public ArrayList<MyPlace> getSkiGOlfVo(String city, skiGolfList skiGolfVo){
        ArrayList<MyPlace> result = new ArrayList<>();
        MyPlace myplace;

        for(int i = 0; skiGolfVo.getDATA().size() > i; i++) {
            skiGolf vo = skiGolfVo.getDATA().get(i);
            if(vo.getGOV_NM().equals(city)) {
                //장르에 따라 바뀌는 아이콘 필요
                if(vo.getCTGRY_NM().equals("05.박물관/기념관/미술관")) {
                    myplace = new MyPlace(R.mipmap.ic_museum, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }else if(vo.getCTGRY_NM().equals("03.사찰/불상/탑/동종")){
                    myplace = new MyPlace(R.mipmap.ic_buddhism, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }else if(vo.getCTGRY_NM().equals("01.스키/골프/리조트")){
                    myplace = new MyPlace(R.mipmap.ic_snow, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }else{
                    myplace = new MyPlace(R.mipmap.ic_beach, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }
                result.add(myplace);
            }
        }

        return result;
    }

}

//리스트뷰에 출력할 항목 클래스
class MyPlace {
    int Icon;
    String Name;
    skiGolf skiGolf;

    MyPlace(int aIcon, String aName, skiGolf askiGolf) {
        Icon = aIcon;
        Name = aName;
        skiGolf = askiGolf;
    }
}

//어댑터 클래스
class MyPlaceAdapter extends BaseAdapter {
    Context con;
    LayoutInflater inflater;
    ArrayList<MyPlace> arP;
    int layout;

    public MyPlaceAdapter(Context context, int alayout, ArrayList<MyPlace> aarP) {
        con = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arP = aarP;
        layout = alayout;
    }

    //어댑터에 몇 개의 항목이 있는지 조사
    public int getCount(){
        return arP.size();
    }

    //position 위치의 항목 Name 반환
    public Object getItem(int position) {
        return arP.get(position).Name;
    }

    //position 위치의 항목 Id 반환
    public long getItemId(int position) {
        return position;
    }


    //각 항목의 뷰 생성 후 반환
    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = inflater.inflate(layout, parent, false);
        }
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        img.setImageResource(arP.get(position).Icon);


        TextView txt = (TextView) convertView.findViewById(R.id.txt);
        txt.setText(arP.get(position).Name);

        //rating
        final RatingBar rate_bar = (RatingBar) convertView.findViewById(R.id.rating);
        rate_bar.setStepSize((float) 0.5);
        rate_bar.setMax(5);
        //난수 레이트 ㅋ
        float rate = (float)Math.random()*5;
        if(rate < 3.0f) rate = 3.0f;
        rate_bar.setRating(rate);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String str = arP.get(position).Name + "버튼";
                Toast.makeText(con, str, Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(con, DetailActivity.class);
                intent.putExtra("Place", arP.get(position).skiGolf.getSUBJECT());
                intent.putExtra("NEW address", arP.get(position).skiGolf.getNEW_ADDR());
                intent.putExtra("detail_content", arP.get(position).skiGolf.getTOUR_INFM());
                intent.putExtra("phone", arP.get(position).skiGolf.getCONTACT());
                intent.putExtra("homepage", arP.get(position).skiGolf.getHOMPAGE());
                intent.putExtra("attractions", arP.get(position).skiGolf.getSURROUNDINGS_ATTRACTION());


                String img = arP.get(position).skiGolf.getIMG();
                String[] imgs = img.split("http://");

                intent.putExtra("imgs", imgs);

                con.startActivity(intent);
            }
        });
        return convertView;
    }

}

