package org.techtown.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PersonAdapter();

        adapter.addItem(new Person("1최현우", "010-1234-1234"));
        adapter.addItem(new Person("2최현우", "010-1234-1234"));
        adapter.addItem(new Person("3최현우", "010-1234-1234"));
        adapter.addItem(new Person("4최현우", "010-1234-1234"));
        adapter.addItem(new Person("5최현우", "010-1234-1234"));
        adapter.addItem(new Person("11최현우", "010-1234-1234"));
        adapter.addItem(new Person("12최현우", "010-1234-1234"));
        adapter.addItem(new Person("13최현우", "010-1234-1234"));
        adapter.addItem(new Person("14최현우", "010-1234-1234"));
        adapter.addItem(new Person("15최현우", "010-1234-1234"));
        adapter.addItem(new Person("21최현우", "010-1234-1234"));
        adapter.addItem(new Person("22최현우", "010-1234-1234"));
        adapter.addItem(new Person("23최현우", "010-1234-1234"));
        adapter.addItem(new Person("24최현우", "010-1234-1234"));
        adapter.addItem(new Person("25최현우", "010-1234-1234"));

        adapter.setOnItemClickListener(new onPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                showToast("아이템 선택됨 : " + item.getName());
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public  void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}
