package com.example.iniciando
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iniciando.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //adicionando o sintetic -> va no arquivo build.gradle > no 'plugins' adicione esse arquivo: id 'kotlin-android-extensions'

        //Existem duas formas de pegar o id dos componentes
        //Com viewBinding e Sintetic
        //aqui usaremos sintetic
        binding.btnCalcular.setOnClickListener {
            //setOnClickListener -> para ativar o clique do botão

            //Usando viewBinding
            //val altura = findViewById<EditText>(R.id.editAltura)
            //val peso = findViewById<EditText>(R.id.editPeso)
            //val resultado = findViewById<TextView>(R.id.txtResultado)

            //Usando Sintetic (foi depreciado nao da pra usar mais em 2023)
            //val altura = editAltura.text.toString().toFloat()
            //val peso = editPeso.text.toString().toFloat()
            //val resultado = txtResultado

            //ao usar "var", você pode reatribuir um novo valor à variável ao longo do código. Por outro lado,
            //ao usar "val", o valor atribuído inicialmente não pode ser alterado. (seria tipo um final no dart)


            //peso / altura * 2

            val peso = binding.editPeso.text.toString().toDouble()
            val altura = binding.editAltura.text.toString().toDouble()

            val resultado = peso / (altura * altura)

            //formatar o resultado para receber duas casa decimal
            val decimalFormat = DecimalFormat("0.00")
            val resultadoFormatado = decimalFormat.format(resultado).toDouble()

            binding.textResult.text = "Seu IMC é: $resultadoFormatado"

       }
    }
}