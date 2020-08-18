package com.shik.toyproject.shikprogrammers.augst04;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shik.toyproject.shikprogrammers.R;

import java.util.Arrays;

public class WhiteSnow extends AppCompatActivity {

    private static final int SUM_TALL = 100;

    private TextView tvAnswer;
    private EditText etTall;
    private Button btnFinish;

    private int[] intputArr;
    private int[] answerArr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_snow);
        tvAnswer = findViewById(R.id.tvAnswer);
        etTall = findViewById(R.id.etTall);
        btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("khs", "onClick");

                setInputData();
                int a = 0;
                while (!test(intputArr, a)) {
                    Log.e("khs", "a = " + a);
                    if (a == 9) {
                        break;
                    }
                    a++;
                }

            }
        });
    }

    private void setInputData() {
        String str = etTall.getText().toString();
        String[] arr = str.split(" ");

        intputArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            intputArr[i] = Integer.parseInt(arr[i]);
        }

//        showArrString(intputArr);
        Arrays.sort(intputArr);
        Log.w("khs", "after");
        showArrString(intputArr);
    }

    private void showArrString(int[] array) {
        for (int i = 0; i < array.length; i++) {
            Log.e("khstest", "array[" + i + "] = " + array[i]);
        }
    }

    private boolean test(int[] array, int start) {
        Log.d("khs", "test====================================================================");
        int sum = 0;
        int second;
        Log.i("khs", "포문시작");
        for (second = start + 1; second < array.length; second++) {
            Log.e("khs", "세컨드 시작  = " + second);
            if (sum != 100) {
                sum = 0;
            } else {
                Log.e("khs", "정답이다!!!!!!!start = " + start + "// second = " + second);
                return true;
            }
            for (int i = 0; i < array.length; i++) {
                Log.e("khs", "i = " + i + ", start = " + start + ", second = " + second);
                if (i == start || i == second) {
                    //TODO NOTHING
                } else {
                    sum += array[i];
                    if (sum > 100) {
                        Log.e("khs", "break");
                        break;
                    }
                }
            }

        }
        Log.e("khs", "sum = " + sum);
        if (sum != 100) {
            return false;
        } else {
            Log.e("khs", "정답이다!!!!!!!start = " + start + "// second = " + second);
            return true;
        }
    }
}
