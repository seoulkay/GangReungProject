package com.klutch.kay.gangproject;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        arPlace = new ArrayList<MyPlace>();
        MyPlace myplace;
        myplace = new MyPlace(R.mipmap.ic_launcher, "경포대");
        arPlace.add(myplace);
        myplace = new MyPlace(R.mipmap.ic_launcher, "허균허난설헌생가");
        arPlace.add(myplace);
        myplace = new MyPlace(R.mipmap.ic_launcher, "초당두부마을");
        arPlace.add(myplace);

        MyPlaceAdapter adapter = new MyPlaceAdapter(this, R.layout.list_item, arPlace);

        ListView list;
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
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
                Toast.makeText(con, str,Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
