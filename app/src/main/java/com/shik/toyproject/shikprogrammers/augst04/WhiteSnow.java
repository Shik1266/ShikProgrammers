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

    private int total = 0;

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
                int startIdx = 0;
                while (!isRealDwarfs(intputArr, startIdx)) {
                    Log.e("khs", "a = " + startIdx);
                    if (startIdx == 9) {
                        break;
                    }
                    startIdx++;
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
        Arrays.sort(intputArr);

        showArrString(intputArr);
        Log.w("khs", "after");
        showArrString(intputArr);
    }

    private void showArrString(int[] array) {

        for (int i = 0; i < array.length; i++) {
            Log.d("khstest", "array[" + i + "] = " + array[i]);
        }
    }

    private void showArrString(int[] array,int a,int b) {
        Log.e("showArrString","a = "+a+",,, b = "+b);
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if(i != a && i != b){
                Log.e("khstest", "array[" + i + "] = " + array[i]);

                System.out.println(array[i]);
            }
        }
    }

    private boolean isRealDwarfs(int[] array, int start) {
        int sum = 0;
        int second;
        for (second = start + 1; second < array.length; second++) {
            Log.e("khs", "세컨드 시작  = " + second);
            if (sum != 100) {
                sum = 0;
            } else {
                Log.e("khstest", "정답이다!!!!!!!start = " + start + "// second = " + second);
                showArrString(array,start,second);
//                Log.e("total"," 1total = "+total);
                return true;
            }
            for (int i = 0; i < array.length; i++) {
                total++;
                Log.e("khs", "i = " + i + ", start = " + start + ", second = " + second);
                if (i == start || i == second) {
                    //TODO NOTHING
                } else {
                    sum += array[i];
                    Log.i("khssum ","array[i] = +"+array[i]);
                    Log.e("khssum ","sum = +"+sum);
                    if (sum > 100) {
                        Log.e("khs", "break");
                        sum = 0;
                        break;
                    }
                }
            }
            if (sum == 100) {
                Log.e("khstest", "정답이다!!!!!!!start = " + start + "// second = " + second);
                showArrString(array,start,second);
//                Log.e("total"," 1total = "+total);
                return true;
            }
        }
        Log.e("khs", "sum = " + sum);
        if (sum != 100) {
            return false;
        } else {
            Log.e("total"," 2total = "+total);
            Log.e("khs", "정답이다!!!!!!!start = " + start + "// second = " + second);
            return true;
        }
    }
}
