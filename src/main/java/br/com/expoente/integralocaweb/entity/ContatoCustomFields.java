package br.com.expoente.integralocaweb.entity;

/**
 *
 * @author ednascimento
 */
public class ContatoCustomFields {

    private String nome;
    private String cidade;
    private String data_de_nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    @Override
    public String toString() {
        return "ContatoCustomFields{" + "nome=" + nome + ", cidade=" + cidade + ", data_de_nascimento=" + data_de_nascimento + '}';
    }
}
