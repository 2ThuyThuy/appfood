package com.example.app.mainlayout;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.login.MainActivity;

public class Welcome extends AppCompatActivity {
    ImageView imgIntroduce,imgFood,imgMode,imgTower;
    TextView textView, tvLogout;
    int age;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        AnhXa();
        getSupportActionBar().hide();

        Intent intent=getIntent();
        //set textview username và lấy age từ SingUp và MainActivity
        textView.setText(String.valueOf(intent.getStringExtra("username")));
        age= Integer.parseInt(intent.getStringExtra("age"));
        tvLogout.setPaintFlags(tvLogout.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLog=new Intent(Welcome.this, MainActivity.class);
                startActivity(intentLog);
            }
        });
        imgIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Welcome.this, Introduce.class);

                startActivity(intent1);
            }
        });
        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Welcome.this, ListFood.class);
                startActivity(intent1);
            }
        });
        imgMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Welcome.this, ModeEat.class);
                startActivity(intent1);
            }
        });
//                Intent intentAge = getIntent();
//               int Age= intentAge.getIntExtra("age",0);
//               Toast.makeText(Welcome.this, String.valueOf(age), Toast.LENGTH_SHORT).show();
        imgTower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Welcome.this, TowerDD.class);
                intent1.putExtra("age",String.valueOf(age));//đâu,phải để ns sang string,vì age là int
//                intent1.putExtra("age",Age);
                startActivity(intent1);
            }
        });
    }
    public void AnhXa(){
        imgIntroduce=findViewById(R.id.imgIntroduce);
        imgFood=findViewById(R.id.imgFood);
        imgMode=findViewById(R.id.imgMode);
        imgTower=findViewById(R.id.imgTower);
        textView=findViewById(R.id.tvsetUsername);
        tvLogout= findViewById(R.id.tvLogout);
    }
}
