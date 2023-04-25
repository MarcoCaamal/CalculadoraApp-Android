package com.example.calculadoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textview.MaterialTextView
import java.io.Console

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int? = null;

    private lateinit var btnSumar: MaterialButton
    private lateinit var btnRestar: MaterialButton
    private lateinit var btnProducto: MaterialButton
    private lateinit var btnDividir: MaterialButton
    private lateinit var btnCalcular: MaterialButton

    private lateinit var tfNumero: MaterialAutoCompleteTextView

    private lateinit var tvResultado: MaterialTextView

    companion object {
        val SUMA = 0
        val RESTA = 1
        val PRODUCTO = 2
        val DIVISION = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()

    }

    private fun initComponents() {
        this.btnSumar = findViewById(R.id.btnSumar)
        this.btnRestar = findViewById(R.id.btnRestar)
        this.btnProducto = findViewById(R.id.btnProducto)
        this.btnDividir = findViewById(R.id.btnDivision)
        this.btnCalcular = findViewById(R.id.btnCalcular)

        this.tfNumero = findViewById(R.id.tfNumero)
        this.tvResultado = findViewById(R.id.tvResultado)
    }

    private fun initListeners() {
        this.btnSumar.setOnClickListener() { sumar() }
        this.btnRestar.setOnClickListener() { restar() }
        this.btnProducto.setOnClickListener() { producto() }
        this.btnDividir.setOnClickListener() { dividir() }
        this.btnCalcular.setOnClickListener() { calcular() }
    }

    private fun sumar() {
        val resultado = this.tfNumero.text.toString()

        if(resultado.isNotEmpty()) {
            this.num1 = resultado.toDouble()
            this.operacion = SUMA
            this.tfNumero.setText("")
            this.activarCalcular()
            this.desactivarOperaciones()
            return
        }

        this.tvResultado.text = "Se debe ingresar un número"
    }

    private fun restar() {
        val resultado = this.tfNumero.text.toString()

        if(resultado.isNotEmpty()) {
            this.num1 = resultado.toDouble()
            this.operacion = RESTA
            this.tfNumero.setText("")
            this.activarCalcular()
            this.desactivarOperaciones()
            return
        }

        this.tvResultado.text = "Se debe ingresar un número"
    }

    private fun producto() {
        val resultado = this.tfNumero.text.toString()

        if(resultado.isNotEmpty()) {
            this.num1 = resultado.toDouble()
            this.operacion = PRODUCTO
            this.tfNumero.setText("")
            this.activarCalcular()
            this.desactivarOperaciones()
            return
        }

        this.tvResultado.text = "Se debe ingresar un número"
    }

    private fun dividir() {
        val resultado = this.tfNumero.text.toString()

        if(resultado.isNotEmpty()) {
            this.num1 = resultado.toDouble()
            this.operacion = DIVISION
            this.tfNumero.setText("")
            this.activarCalcular()
            this.desactivarOperaciones()
            return
        }

        this.tvResultado.text = "Se debe ingresar un número"
    }

    private fun calcular() {
        if(this.operacion == null) {
            return
        }

        val resultado = this.tfNumero.text.toString()

        if(resultado.isNotEmpty()) {
            this.num2 = resultado.toDouble()

            when(this.operacion) {
                0 -> {
                    this.tvResultado.text = "El resultado es: ${this.num1 + this.num2}"
                    this.activarOperaciones()
                    this.desactivarCalcular()
                    this.tfNumero.setText("")
                }
                1 -> {
                    this.tvResultado.text = "El resultado es: ${this.num1 - this.num2}"
                    this.activarOperaciones()
                    this.desactivarCalcular()
                    this.tfNumero.setText("")
                }
                2 -> {
                    this.tvResultado.text = "El resultado es: ${this.num1 * this.num2}"
                    this.activarOperaciones()
                    this.desactivarCalcular()
                    this.tfNumero.setText("")
                }
                3 -> {
                    this.tvResultado.text = "El resultado es: ${this.num1 / this.num2}"
                    this.activarOperaciones()
                    this.desactivarCalcular()
                    this.tfNumero.setText("")
                }
            }
        }
    }

    private fun desactivarOperaciones() {
        this.btnSumar.visibility = View.INVISIBLE
        this.btnRestar.visibility = View.INVISIBLE
        this.btnProducto.visibility = View.INVISIBLE
        this.btnDividir.visibility = View.INVISIBLE
    }

    private fun activarOperaciones() {
        this.btnSumar.visibility = View.VISIBLE
        this.btnRestar.visibility = View.VISIBLE
        this.btnProducto.visibility = View.VISIBLE
        this.btnDividir.visibility = View.VISIBLE
    }

    private fun activarCalcular() {
        this.btnCalcular.visibility = View.VISIBLE
    }

    private fun desactivarCalcular() {
        this.btnCalcular.visibility = View.INVISIBLE
    }
}