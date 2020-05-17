package org.techtown.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        int num = intent.getExtras().getInt("number");
        Toast.makeText(this, "보낸 데이터: " + num, Toast.LENGTH_LONG).show();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "hyeonwoo");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
