package com.klutch.kay.gangproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.rajasharan.widget.SearchableSpinner;

public class MainActivity extends AppCompatActivity implements SearchableSpinner.OnSelectionChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grace: 스피너 구현
        SearchableSpinner spinner1 = (SearchableSpinner) findViewById(R.id.main_spinner);
        spinner1.setOnSelectionChangeListener(this);
    }

    //Grace: 스피너에서 도시 선택하면 도시 이름을 인자로 ListPageActivity에 넘김
    public void onSelectionChanged(String selection){
        Toast.makeText(this, selection + " selected", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ListPageActivity.class);
        intent.putExtra("selectedItemId", selection);
        startActivity(intent);
        //Grace: 액티비티 전환 애니메이션 효과
        overridePendingTransition(R.anim.fade, R.anim.cycle_7);
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
}
