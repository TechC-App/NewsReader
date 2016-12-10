package com.example.student.newsreader;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.view.NestedScrollingChild;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.newsreader.Dto.CustomerDto;
import com.example.student.newsreader.Dto.NewsDto;
import com.example.student.newsreader.adapter.ReaderAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<NewsDto> testLst = createTestCustomer();

        ReaderAdapter adapter = new ReaderAdapter(this);

        // Adapterへリストを追加
        adapter.add(testLst);

        ListView listview = (ListView) findViewById(R.id.NewsList);
        listview.setAdapter(adapter);
    }

    // 20人分のテスト顧客データ　※本当はサーバから情報を取得するはず
    private List<NewsDto> createTestCustomer(){

        List<NewsDto> lst = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            NewsDto dto = new NewsDto();
            dto.setId(i);
            dto.setName("Test" + i);
            dto.setDate(new Date());
            lst.add(dto);
        }
        return lst;
    }
}
