package org.techtown.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

//    MainHandler handler;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });

//        handler = new MainHandler();
    }

    class BackgroundThread extends Thread {
        int value = 0;
        public void run() {
            for(int i=0; i<100; i++) {
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {

                }
                value += 1;
                Log.d("MyThread", "value : " + value);
                // 1. 오류
//                textView.setText("값 : " + value);

                // 2. Handler 사용
//                Message message = handler.obtainMessage();
//                Bundle bundle = new Bundle();
//                bundle.putInt("value", value);
//                message.setData(bundle);
//
//                handler.sendMessage(message);

                // 3. Handler 객체를 그대로 사용
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("값 : " + value);
                    }
                });

                // 참고) 실행 지연시간 줄때
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("값 : " + value);
//                    }
//                }, 5000);
            }
        }
    }

    class MainHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");

            textView.setText("값 : " + value);
        }
    }
}
