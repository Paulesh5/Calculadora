package com.paul.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->multi, 4->div, 5->sen, 6->cos, 7->tan
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnIgual: Button = findViewById(R.id.btnIgual)

        btnIgual.setOnClickListener {
            var numero2: Double = tv_num2.text.toString().toDoubleOrNull() ?: 0.0
            var resp: Double = 0.0

            when (oper) {
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
                5 -> resp = sin(numero1)
                6 -> resp = cos(numero1)
                7 -> resp = tan(numero1)
            }

            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }
    }

    fun presionarDigito(view: View) {
        //val tv_num2: TextView = findViewById(R.id.tv_num2)
        val num2: String = tv_num2.text.toString()

        when (view.id) {
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
            R.id.btnPunto -> tv_num2.setText(num2 + ".")
        }
    }

    fun clickOperacion(view: View) {
        numero1 = tv_num2.text.toString().toDouble()
        val num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when (view.id) {
            R.id.btnSumar -> {
                tv_num1.setText(num2_text + "+")
                oper = 1
            }
            R.id.btnRestar -> {
                tv_num1.setText(num2_text + "-")
                oper = 2
            }
            R.id.btnMult -> {
                tv_num1.setText(num2_text + "*")
                oper = 3
            }
            R.id.btnDividir -> {
                tv_num1.setText(num2_text + "/")
                oper = 4
            }
            R.id.btnSen -> {
                tv_num1.setText("sin($num2_text)")
                oper = 5
            }
            R.id.btnCos -> {
                tv_num1.setText("cos($num2_text)")
                oper = 6
            }
            R.id.btnTan -> {
                tv_num1.setText("tan($num2_text)")
                oper = 7
            }
        }
    }
}
