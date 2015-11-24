package com.klutch.kay.gangproject;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class ListPageActivity extends AppCompatActivity {

    ArrayList<MyPlace> arPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String skiGolfStr = "";

            try {
                InputStream is = getAssets().open("skiGolf.json");
                skiGolfStr = readFile(is);
            }catch(Exception e){
                e.printStackTrace();
            }


            Gson skiGolf = new Gson();
            skiGolfList skiGolfVo = skiGolf.fromJson(skiGolfStr, skiGolfList.class);



            arPlace = new ArrayList<MyPlace>();
            MyPlace myplace;


            for(int i = 0; skiGolfVo.getDATA().size() > i; i++) {
                myplace = new MyPlace(R.mipmap.ic_launcher, skiGolfVo.getDATA().get(i).getSUBJECT());
                arPlace.add(myplace);
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

}



//리스트뷰에 출력할 항목 클래스
class MyPlace {
    int Icon;
    String Name;

    MyPlace(int aIcon, String aName) {
        Icon = aIcon;
        Name = aName;
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

        Button btn = (Button) convertView.findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                String str = arP.get(position).Name + "버튼";
                Toast.makeText(con, str, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }


}

