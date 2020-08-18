package com.shik.toyproject.shikprogrammers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shik.toyproject.shikprogrammers.augst04.WhiteSnow
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn1 ->{
                startActivity<WhiteSnow>()
            }

            R.id.btn2 ->{

            }

            R.id.btn3 ->{

            }
        }
    }

}