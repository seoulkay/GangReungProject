package com.klutch.kay.gangproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rajasharan.widget.SearchableSpinner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity implements SearchableSpinner.OnSelectionChangeListener {
    public static skiGolfList skiGolfVo = new skiGolfList();
    public static skiGolfList museumVo = new skiGolfList();
    public static skiGolfList templeVo = new skiGolfList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, SplashActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String skiGolfStr = "";
        String museumStr = "";
        String templeStr = "";
        try {
            InputStream is = getAssets().open("skiENG.json");
            skiGolfStr = readFile(is);
            InputStream is2 = getAssets().open("museumENG.json");
            museumStr = readFile(is2);
            InputStream is3 = getAssets().open("templeENG.json");
            templeStr = readFile(is3);
        }catch(Exception e){
            e.printStackTrace();
        }
        Gson skiGolf = new Gson();
        skiGolfVo = skiGolf.fromJson(skiGolfStr, skiGolfList.class);
        Gson museum = new Gson();
        museumVo = museum.fromJson(museumStr, skiGolfList.class);
        Gson temple = new Gson();
        templeVo = temple.fromJson(templeStr, skiGolfList.class);


        //Grace: 스피너 구현
        SearchableSpinner spinner1 = (SearchableSpinner) findViewById(R.id.main_spinner);
        spinner1.setOnSelectionChangeListener(this);

    }

    //Grace: 스피너에서 도시 선택하면 도시 이름을 인자로 ListPageActivity에 넘김
    public void onSelectionChanged(String selection) {
        Toast.makeText(this, selection + " selected", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ListPageActivity.class);
        intent.putExtra("selectedItemId", selection);
        startActivity(intent);
        //Grace: 액티비티 전환 애니메이션 효과
        //overridePendingTransition(R.anim.fade, R.anim.cycle_7);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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
            //System.out.println("================== 파일 내용 출력 ==================");
            //System.out.println(content);

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
