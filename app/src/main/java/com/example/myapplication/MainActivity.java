package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private long score = 0;
    private TextView scoreText;
    private Button mainBtn;

    private RecyclerView recyclerView;
    private UpdateAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainBtn = findViewById(R.id.main_btn);
        scoreText = findViewById(R.id.score_text);
        recyclerView = findViewById(R.id.updateListView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new UpdateAdapter(new ArrayList<Upgrade>(){{
            add(new Upgrade("Молния","Электризует вас, что способствует увелечению силе клика", R.drawable.ic_lightning, 10,1.07));
            add(new Upgrade("Огурчики","Бодрят не только тело, но и дух", R.drawable.ic_pickles, 50, 1.08));
            add(new Upgrade("Пивасик","Пивасик... МММ", R.drawable.ic_pint, 100, 1.09));
            add(new Upgrade("Топорик","Руби на отмашь!", R.drawable.ic_axe,500, 1.1));
        }});

        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        // TODO: 17.04.2019 лонг тап
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score += 1;
                updateScore();
            }
        });
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

    public void updateScore(){
        scoreText.setText(String.format(getString(R.string.score_ph), score));
    }
}
