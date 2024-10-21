package br.com.jardelbarbosa.apiJogos.utilitario

import br.com.jardelbarbosa.apiJogos.modelo.Gamer
import br.com.jardelbarbosa.apiJogos.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}