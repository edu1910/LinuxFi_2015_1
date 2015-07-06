package br.com.ceducarneiro.exemplogrid;

public class City {

    private String nome;
    private String condicaoClimatica;
    private String temperatura;

    public City() {
        /* Empty */
    }

    public City(String nome, String condicaoClimatica, String temperatura) {
        setNome(nome);
        setCondicaoClimatica(condicaoClimatica);
        setTemperatura(temperatura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCondicaoClimatica() {
        return condicaoClimatica;
    }

    public void setCondicaoClimatica(String condicaoClimatica) {
        this.condicaoClimatica = condicaoClimatica;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return nome;
    }
}
