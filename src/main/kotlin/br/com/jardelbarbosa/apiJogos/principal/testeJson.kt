package br.com.jardelbarbosa.apiJogos.principal

import br.com.jardelbarbosa.apiJogos.servicos.ConsumoApi

fun main() {

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("151")

    println(listaGamers)
    println(jogoApi)
}