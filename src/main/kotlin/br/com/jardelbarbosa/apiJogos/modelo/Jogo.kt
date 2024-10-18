package br.com.jardelbarbosa.apiJogos.modelo

data class Jogo(val titulo:String, val capa:String){

    var descricao: String? = null

    override fun toString(): String {
        return "Meu br.com.jardelbarbosa.apiJogos.modelo.Jogo:\n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }


}

