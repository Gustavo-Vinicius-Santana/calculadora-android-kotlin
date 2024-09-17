package com.example.aula2teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os widgets
        val numberDisplay = findViewById<TextView>(R.id.numberDisplay)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)

        // Botões de operação
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        // Função para calcular e exibir o resultado
        fun calculate(operation: (Int, Int) -> Int) {
            val value1 = editText1.text.toString().toIntOrNull() ?: 0
            val value2 = editText2.text.toString().toIntOrNull() ?: 0
            val result = operation(value1, value2)
            numberDisplay.text = result.toString()
        }

        // Configuração do clique dos botões
        addButton.setOnClickListener {
            calculate { a, b -> a + b }
        }

        subtractButton.setOnClickListener {
            calculate { a, b -> a - b }
        }

        multiplyButton.setOnClickListener {
            calculate { a, b -> a * b }
        }

        divideButton.setOnClickListener {
            if (editText2.text.toString().toIntOrNull() == 0) {
                numberDisplay.text = "Erro: Divisão por zero"
            } else {
                calculate { a, b -> a / b }
            }
        }

    }
}