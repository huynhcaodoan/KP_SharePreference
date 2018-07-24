package com.cdh.nguyetbong.kp_sharepreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTexttk, editTextmk;
    Button button;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextmk = findViewById(R.id.edittextMatkhau);
        editTexttk = findViewById(R.id.edittextTaikhoan);
        button = findViewById(R.id.buttondangnhap);
        checkBox = findViewById(R.id.checkboxLuu);

        sharedPreferences = getSharedPreferences("thongtinuser",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        boolean checked = sharedPreferences.getBoolean("save",false);
        if(checked == true){
            String taikhoan = sharedPreferences.getString("taikhoan","");
            String matkhau = sharedPreferences.getString("matkhau","");
            editTexttk.setText(taikhoan);
            editTextmk.setText(matkhau);
            checkBox.setChecked(checked);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = editTexttk.getText().toString();
                String matkhau = editTextmk.getText().toString();
                if(taikhoan.equals("huynh") && matkhau.equals("123")){
                    if(checkBox.isChecked()){

                        editor.putString("taikhoan",taikhoan);
                        editor.putString("mat khau",matkhau);
                        editor.putBoolean("save",true);
                        editor.commit();

                    }else {
                        editor.clear();
                    }
                    Toast.makeText(MainActivity.this, "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
