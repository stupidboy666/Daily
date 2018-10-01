package com.example.ano.daily;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import org.jsoup.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView title;
    private TextView author;
    private TextView content;
    private Artical at;
    private List<String> list;
    private static String context="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=(TextView)findViewById(R.id.at_title);
        author=(TextView)findViewById(R.id.at_author);
        content=(TextView)findViewById(R.id.at_content);

        //using LitePal to save the book
        LitePal.initialize(this);

        //set ToolBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //Init the Dawerlayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        //set the fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private Handler mhandler=new Handler()
    {
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            if (msg.what==1)
            {
                list=at.getContent();
                for(int i=0;i<list.size();i++)
                {
                    context=context+"  "+ list.get(i) +"\n\n";
                }
                title.setText(at.getTitle());
                author.setText(at.getAuthour());
                content.setText(context);
            }
        }
    };

    //get the article from the website
    protected void onResume() {
        super.onResume();
        //从网页爬取数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                at=ParseWeb.http_getnovel();
                if(at!=null)
                {
                    mhandler.sendEmptyMessage(1);
                }
            }
        }).start();
    }






    /*
     * 获取ToolBar菜单
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.music:
                Intent intent=new Intent(this,PlayActivity.class);
                startActivity(intent);
        }
        return true;
    }



}
