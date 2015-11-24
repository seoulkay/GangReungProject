package com.klutch.kay.gangproject;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        String str2 = "";

        //파일이름으로 제이슨 객체 받기
        try {

            InputStream is = getAssets().open("Exam.json");
            JsonReader reader = new JsonReader(new InputStreamReader(is));
            reader.setLenient(true);

            //Log.d("J obj", jobj.getAsString());
            //str2 = jobj.get("0").toString();
        }catch(Exception je){
            Log.d("JSON Error", je.toString());
        }

        String Json = "{\"computer\":[{\"Product\":\"mouse\",\"Maker\":\"Samsung\",\"Price\":23000},"
                +"{\"Product\":\"keyboard\",\"Maker\":\"LG\",\"Price\":12000},"
                +"{\"Product\":\"hdd\",\"Maker\":\"westorn digital\",\"Price\":15600}]}";
        try{
            String txt1 = "주문 목록\n";

            Gson gson = new Gson();//Gson 객체 및 인스턴스 생성.
            Prod prod = gson.fromJson(Json, Prod.class);//다른 클래스(InnerClass)를 생성하여
            //그곳에 Json문서를 넣음.

            for(Item item : prod.getComputer()){//for문을 돌려서 각각에 맞는 배열 name의 값을 추
                txt1 += "제품명:"+item.getProduct() + ",제조사:"+item.getMaker()
                        +",가격:"+item.getPrice()+"\n";
            }

            str2 = prod.getComputer().get(1).getMaker();
        }catch(Exception e){
            Log.d("JJSON ERROR", e.getMessage());

        }

        System.out.println("ddddddddeweeerewrewr"+str2);

        // Android에서 제공하는 string 문자열 하나를 출력 가능한 layout으로 어댑터 생성
        m_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) findViewById(R.id.listview);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        // ListView 아이템 터치 시 이벤트 추가
        m_ListView.setOnItemClickListener(onClickListItem);

        // ListView에 아이템 추가
        m_Adapter.add("강릉아이템1");
        m_Adapter.add(str2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀습니다", Toast.LENGTH_LONG).show();
            }
        });

    }

    // 아이템 터치 이벤트
    private AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
            Toast.makeText(getApplicationContext(), m_Adapter.getItem(arg2), Toast.LENGTH_SHORT).show();
        }
    };

    public void ClickButton(View v) {
        Toast.makeText(getApplicationContext(), "버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
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

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("skiGolf.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    //배열 키값에 대한 내용..
    public class Prod{
        private ArrayList<Item> computer;

        public ArrayList<Item> getComputer() {
            return computer;
        }

        public void setComputer(ArrayList<Item> computer) {
            this.computer = computer;
        }
    }
    //배열에 있는 내용. 배열명
    public class Item{
        private String Product;
        private String Maker;
        private Integer Price;


        public String getProduct() {
            return Product;
        }
        public void setProduct(String product) {
            Product = product;
        }
        public String getMaker() {
            return Maker;
        }
        public void setMaker(String maker) {
            Maker = maker;
        }
        public Integer getPrice() {
            return Price;
        }
        public void setPrice(Integer price) {
            Price = price;
        }

    }

    public class skiGolf{
        private String GOV_NM;
        private String CTGRY_NM;
        private String SEQ_NUM;
        private String IMG;

    }
}
