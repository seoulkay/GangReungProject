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
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListPageActivity extends AppCompatActivity {

    ArrayList<MyPlace> arPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);


        String skiGolfStr = "";
        String museumStr = "";
        String templeStr = "";
        try {
            InputStream is = getAssets().open("skiENG.json");
            skiGolfStr = readFile(is);
            InputStream is2 = getAssets().open("museum.json");
            museumStr = readFile(is2);
            InputStream is3 = getAssets().open("temple.json");
            templeStr = readFile(is3);
        }catch(Exception e){
            e.printStackTrace();
        }


        Gson skiGolf = new Gson();
        skiGolfList skiGolfVo = skiGolf.fromJson(skiGolfStr, skiGolfList.class);
        Gson museum = new Gson();
        skiGolfList museumVo = museum.fromJson(museumStr, skiGolfList.class);
        Gson temple = new Gson();
        skiGolfList templeVo = temple.fromJson(templeStr, skiGolfList.class);

        Intent intent = getIntent();
        String location = intent.getStringExtra("selectedItemId");
        switch (location) {
            case "Journey":
                //locationName.setText("Journey!");
                arPlace = getSkiGOlfVo("Journey!", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("Journey!", museumVo));
                arPlace.addAll(getSkiGOlfVo("Journey!", templeVo));
                break;
            case "GANG NEUNG":
                //locationName.setText("강릉시");
                arPlace = getSkiGOlfVo("강릉시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("강릉시", museumVo));
                arPlace.addAll(getSkiGOlfVo("강릉시", templeVo));
                break;
            case "PYEONG CHANG":
                //locationName.setText("평창군");
                arPlace = getSkiGOlfVo("평창군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("평창군", museumVo));
                arPlace.addAll(getSkiGOlfVo("평창군", templeVo));
                break;
            case "GO SEONG":
                //locationName.setText("고성군");
                arPlace = getSkiGOlfVo("고성군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("고성군", museumVo));
                arPlace.addAll(getSkiGOlfVo("고성군", templeVo));
                break;
            case "DONG HAE":
                //locationName.setText("동해시");
                arPlace = getSkiGOlfVo("동해시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("동해시", museumVo));
                arPlace.addAll(getSkiGOlfVo("동해시", templeVo));
                break;
            case "SAM CHEOK":
                //locationName.setText("삼척시");
                arPlace = getSkiGOlfVo("삼척시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("삼척시", museumVo));
                arPlace.addAll(getSkiGOlfVo("삼척시", templeVo));
                break;
            case "SOK CHO":
                //locationName.setText("속초시");
                arPlace = getSkiGOlfVo("속초시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("속초시", museumVo));
                arPlace.addAll(getSkiGOlfVo("속초시", templeVo));
                break;
            case "YANG GU":
                //locationName.setText("양구군");
                arPlace = getSkiGOlfVo("양구군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("양구군", museumVo));
                arPlace.addAll(getSkiGOlfVo("양구군", templeVo));
                break;
            case "YANG YANG":
                //locationName.setText("양양군");
                arPlace = getSkiGOlfVo("양양군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("양양군", museumVo));
                arPlace.addAll(getSkiGOlfVo("양양군", templeVo));
                break;
            case "YEONG WOL":
                //locationName.setText("영월군");
                arPlace = getSkiGOlfVo("영월군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("영월군", museumVo));
                arPlace.addAll(getSkiGOlfVo("영월군", templeVo));
                break;
            case "WON JU":
                //locationName.setText("원주시");
                arPlace = getSkiGOlfVo("원주시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("원주시", museumVo));
                arPlace.addAll(getSkiGOlfVo("원주시", templeVo));
                break;
            case "IN JE":
                //locationName.setText("인제군");
                arPlace = getSkiGOlfVo("인제군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("인제군", museumVo));
                arPlace.addAll(getSkiGOlfVo("인제군", templeVo));
                break;
            case "JEONG SEON":
                //locationName.setText("정선군");
                arPlace = getSkiGOlfVo("정선군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("정선군", museumVo));
                arPlace.addAll(getSkiGOlfVo("정선군", templeVo));
                break;
            case "CHEOR WON":
                //locationName.setText("철원군");
                arPlace = getSkiGOlfVo("철원군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("철원군", museumVo));
                arPlace.addAll(getSkiGOlfVo("철원군", templeVo));
                break;
            case "CHUN CHEON":
                //locationName.setText("춘천시");
                arPlace = getSkiGOlfVo("춘천시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("춘천시", museumVo));
                arPlace.addAll(getSkiGOlfVo("춘천시", templeVo));
                break;
            case "TAE BAEK":
                //locationName.setText("태백시");
                arPlace = getSkiGOlfVo("태백시", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("태백시", museumVo));
                arPlace.addAll(getSkiGOlfVo("태백시", templeVo));
                break;
            case "HONG CHEON":
                //locationName.setText("홍천군");
                arPlace = getSkiGOlfVo("홍천군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("홍천군", museumVo));
                arPlace.addAll(getSkiGOlfVo("홍천군", templeVo));
                break;
            case "HWA CHEON":
                //locationName.setText("화천군");
                arPlace = getSkiGOlfVo("화천군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("화천군", museumVo));
                arPlace.addAll(getSkiGOlfVo("화천군", templeVo));
                break;
            case "HOENG SEONG":
                //locationName.setText("횡성군");
                arPlace = getSkiGOlfVo("횡성군", skiGolfVo);
                arPlace.addAll(getSkiGOlfVo("횡성군", museumVo));
                arPlace.addAll(getSkiGOlfVo("횡성군", templeVo));
                break;
        }

        MyPlaceAdapter adapter = new MyPlaceAdapter(this, R.layout.list_item, arPlace);

        ListView list;
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

    }

    public String readFile(InputStream name){


        // 버퍼 생성
        BufferedReader br = null;

        // Input 스트림 생성
        InputStreamReader isr = null;

        // File Input 스트림 생성
        //FileInputStream fis = null;
        InputStream fis = name;

        // File 경로
        //File file = new File("temp/target.txt");


        // 버퍼로 읽어들일 임시 변수
        String temp = "";

        // 최종 내용 출력을 위한 변수
        String content = "";
        try {

            // 파일을 읽어들여 File Input 스트림 객체 생성
            //fis = new FileInputStream(file);

            // File Input 스트림 객체를 이용해 Input 스트림 객체를 생서하는데 인코딩을 UTF-8로 지정
            isr = new InputStreamReader(fis, "UTF-8");

            // Input 스트림 객체를 이용하여 버퍼를 생성
            br = new BufferedReader(isr);

            // 버퍼를 한줄한줄 읽어들여 내용 추출
            while( (temp = br.readLine()) != null) {
                content += temp + "\n";
            }

            System.out.println("================== 파일 내용 출력 ==================");
            System.out.println(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return content;
    }

    public ArrayList<MyPlace> getSkiGOlfVo(String city, skiGolfList skiGolfVo){
        ArrayList<MyPlace> result = new ArrayList<>();
        MyPlace myplace;

        for(int i = 0; skiGolfVo.getDATA().size() > i; i++) {
            skiGolf vo = skiGolfVo.getDATA().get(i);
            if(vo.getGOV_NM().equals(city)) {
                //장르에 따라 바뀌는 아이콘 필요
                if(vo.getCTGRY_NM().equals("05.박물관/기념관/미술관")) {
                    myplace = new MyPlace(R.mipmap.ic_hotel, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }else if(vo.getCTGRY_NM().equals("03.사찰/불상/탑/동종")){
                    myplace = new MyPlace(R.mipmap.ic_golf, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }else if(vo.getCTGRY_NM().equals("01.스키/골프/리조트")){
                    myplace = new MyPlace(R.mipmap.ic_snow, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
                }else{
                    myplace = new MyPlace(R.mipmap.ic_golf, skiGolfVo.getDATA().get(i).getSUBJECT(), vo);
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

