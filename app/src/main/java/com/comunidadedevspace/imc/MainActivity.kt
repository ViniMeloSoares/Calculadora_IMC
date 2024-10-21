package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtpeso = findViewById<TextInputEditText>(R.id.edtpeso)
        val edtaltura =findViewById<TextInputEditText>(R.id.edtaltura)
        val btn_calcular =findViewById<Button>(R.id.btn_calcular)


        btn_calcular.setOnClickListener {
        val PesoStr:String = edtpeso.text.toString()
        val AlturaStr: String = edtaltura.text.toString()

        if (PesoStr == "" || AlturaStr =="") {

            Snackbar.make(
                edtpeso,
                "Preencha todos os campos",
            Snackbar.LENGTH_LONG
            )
            .show()

        } else {
         val peso: Float = PesoStr.toFloat()
         val altura: Float = AlturaStr.toFloat()

         val alturaQ2 = altura * altura
         val resultado = peso / alturaQ2


         val intent = Intent (this, ResultActivity::class.java)
         intent.putExtra(KEY_RESULT_IMC, resultado)
         startActivity(intent)


           }
        }
    }
}