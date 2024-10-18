package br.com.jardelbarbosa.apiJogos.principal

import br.com.jardelbarbosa.apiJogos.modelo.Gamer

fun main() {

    val gamer1 = Gamer("Jardel", "jardel@jogador2.com")
    println(gamer1)

    val gamer2 = Gamer("Wendell", "wendell@jogador.com", "24/03/2021", "wendo")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "16/03/1996"
        it.usuario = "jaja894"
    }.also {
        println(gamer1.idInterno)
    }
    println(gamer1)
}