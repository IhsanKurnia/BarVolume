package com.ihsankurnia.barvolume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Atribut
    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLeght;
    private TextView ivResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState( @NonNull  Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, ivResult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Lsyout xml text dan editText
        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLeght = findViewById(R.id.edt_lenght);
        Button btnCalculate = findViewById(R.id.btn_calculte);
        ivResult =  findViewById(R.id.iv_result);

        //Inisialisai button xml
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            ivResult.setText(result);
        }
    }
    @Override
    public void onClick(View v) {
        //contraflow
        if (v.getId() == R.id.btn_calculte){
            String inputLenght = edtLeght.getText().toString().trim();
            String inputwidth = edtWidth.getText().toString().trim();
            String inputheight = edtHeight.getText().toString().trim();

            boolean isEmptyField = false;

            if (TextUtils.isEmpty(inputLenght)){
                isEmptyField = true;
                edtLeght.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputwidth)){
                isEmptyField = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputheight)){
                isEmptyField = true;
                edtHeight.setError("Field ini tidak boleh kosonh");
            }

            if (!isEmptyField){
                double volume = Double.parseDouble(inputLenght) * Double.parseDouble(inputwidth) * Double.parseDouble(inputLenght);
                ivResult.setText(String.valueOf(volume));
            }
        }
    }
}