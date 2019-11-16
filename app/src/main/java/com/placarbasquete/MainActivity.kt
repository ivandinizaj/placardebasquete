package com.placarbasquete

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var pontuacaoListaA = arrayListOf<Int>()
    private var pontuacaoListaB = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tresPontosA.setOnClickListener { adicionarPontos(3, "A") }
        doisPontosA.setOnClickListener { adicionarPontos(2, "A") }
        tiroLivreA.setOnClickListener { adicionarPontos(1, "A") }
        removerA.setOnClickListener { removerPontos("A") }

        tresPontosB.setOnClickListener { adicionarPontos(3, "B") }
        doisPontosB.setOnClickListener { adicionarPontos(2, "B") }
        tiroLivreB.setOnClickListener { adicionarPontos(1, "B") }
        removerB.setOnClickListener { removerPontos("B") }

        reiniciarPartida.setOnClickListener { reiniciarPartida() }
    }


    private fun adicionarPontos(pontos: Int, time: String) {
        when (time) {
            "A" -> pontuacaoListaA.add(pontos)
            else -> pontuacaoListaB.add(pontos)
        }
        atualizaPlacar(time)
    }

    private fun atualizaPlacar(time: String) {
        if (time == "A")
            placarTimeA.text = pontuacaoListaA.sum().toString()
        else
            placarTimeB.text = pontuacaoListaB.sum().toString()
    }

    private fun removerPontos(time: String) {
        when (time) {
            "A" -> pontuacaoListaA.removeLast{}
            else -> pontuacaoListaB.removeLast{}
        }
        atualizaPlacar(time)
    }

    private fun reiniciarPartida() {
        placarTimeA.text = "0"
        placarTimeB.text = "0"
        pontuacaoListaA.clear()
        pontuacaoListaB.clear()
        Toast.makeText(this, "Placar reiniciado", Toast.LENGTH_SHORT).show()
    }

    private inline fun ArrayList<Int>.removeLast(after: () -> Unit) {
        if (!this.isNullOrEmpty()) {
            this.removeAt(this.size - 1)
            after()
        }
    }
}



