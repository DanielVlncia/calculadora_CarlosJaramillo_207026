package jaramillo.carlos.calculadora2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener { appendOnClick(true, "0") }
        btn1.setOnClickListener { appendOnClick(true, "1") }
        btn2.setOnClickListener { appendOnClick(true, "2") }
        btn3.setOnClickListener { appendOnClick(true, "3") }
        btn4.setOnClickListener { appendOnClick(true, "4") }
        btn5.setOnClickListener { appendOnClick(true, "5") }
        btn6.setOnClickListener { appendOnClick(true, "6") }
        btn7.setOnClickListener { appendOnClick(true, "7") }
        btn8.setOnClickListener { appendOnClick(true, "8") }
        btn9.setOnClickListener { appendOnClick(true, "9") }

        btnMas.setOnClickListener { appendOnClick(false, "+") }
        btnMenos.setOnClickListener { appendOnClick(false, "-") }
        btnPor.setOnClickListener { appendOnClick(false, "*") }
        btnEntre.setOnClickListener { appendOnClick(false, "/") }
        btnResult.setOnClickListener { appendOnClick(false, "=") }
        btnAC.setOnClickListener { appendOnClick(false, "AC") }

        btnAC.setOnClickListener {
            limpiar()
        }
        btnResult.setOnClickListener {
            calcular()
        }
    }

        fun appendOnClick(limpiar: Boolean, string: String) {
            if (limpiar) {
                tvOutput.text = ""
                tvInput.append(string)
            } else {
                tvInput.append(tvOutput.text)
                tvInput.append(string)
                tvOutput.text = ""
            }
        }

        fun limpiar() {
            tvInput.text = ""
            tvOutput.text = ""

        }

        fun calcular() {
            try {
                val input = ExpressionBuilder(tvInput.text.toString()).build()
                val output = input.evaluate()
                val longOutput = output.toLong()
                if (output == longOutput.toDouble()) {
                    limpiar()
                    tvOutput.text = longOutput.toString()
                } else {
                    tvOutput.text = output.toString()
                }

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
