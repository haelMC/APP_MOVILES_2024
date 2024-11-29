package pe.edu.upeu.calcxml

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var valAnt=0.0
    var valAct=0.0
    var operador=""
    private lateinit var resultado:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        resultado=findViewById(R.id.txtResult)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonSetup()
    }

    fun buttonSetup(){
        var listaB= arrayOf( R.id.btn9, R.id.btn8, R.id.btn7, R.id.btn6, R.id.btn5,
            R.id.btn4, R.id.btnSum, R.id.btnIgual)
        for (button in listaB){
            val butonx=findViewById<Button>(button)
            butonx.setOnClickListener { onclikListener(butonx) }
        }

    }

    fun onclikListener(view:View){
        var butonx=findViewById<Button>(view.id)
        when(view.id){
            R.id.btn9, R.id.btn8, R.id.btn7, R.id.btn6, R.id.btn5, R.id.btn4->{
                apenddNum(butonx.text.toString())
            }
            R.id.btnSum, R.id.btnMult->{
                operador(butonx.text.toString())
            }
            R.id.btnIgual->{
                funObenerResultado()
            }
        }
    }

    fun apenddNum(valor:String){
        resultado.append(valor)
    }

    fun operador(valor: String){
        operador=valor
        valAnt=resultado.text.toString().toDouble()
        resultado.text.clear()
    }

    fun funObenerResultado(){
        valAct=resultado.text.toString().toDouble()
        val result=when(operador){
            "+"->valAnt+valAct
            "*"->valAnt*valAct
            else->0
        }
        resultado.setText(result.toString())
    }

    fun borrarContenido(){
        valAnt=0.0
        valAct=0.0
        operador=""
        resultado.text.clear()
    }



}