package br.com.jardelbarbosa.apiJogos.principal

import br.com.jardelbarbosa.apiJogos.modelo.Gamer
import br.com.jardelbarbosa.apiJogos.modelo.Jogo
import br.com.jardelbarbosa.apiJogos.servicos.ConsumoApi
import transformarEmIdade
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso. Dados do gamer:")
    println(gamer)
    println("Idade do gamer:" + gamer.dataNascimento?.transformarEmIdade())

    do {
        println("Digite um codigo de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
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
            gamer.jogosBuscados.add(meuJogo)
        }
        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()
    } while (resposta.equals("s", ignoreCase = true))

    println("Jogos buscados")
    println(gamer.jogosBuscados)

    println("\n Jogos ordenados por titulos: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }
    val jogosFiltrados = gamer.jogosBuscados.filter{
        it?.titulo?.contains("batman", true) ?: false
    }

    println("|n jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original S/N")
    val opcao = leitura.nextLine()
    if(opcao.equals("s", ignoreCase = true)) {
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir:")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista Atualizada:")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso!")
}
