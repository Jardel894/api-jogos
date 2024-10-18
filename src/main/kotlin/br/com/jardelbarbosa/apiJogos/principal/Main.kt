package br.com.jardelbarbosa.apiJogos.principal

import br.com.jardelbarbosa.apiJogos.modelo.Jogo
import br.com.jardelbarbosa.apiJogos.servicos.CosumoApi
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um codigo de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = CosumoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {

        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }
    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", ignoreCase = true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
            println(meuJogo)
        } else if (opcao.equals("n", ignoreCase = true)) {
            meuJogo?.descricao = meuJogo?.titulo
            println(meuJogo)
        } else {
            println("opção invalida!")
        }
    }
}
