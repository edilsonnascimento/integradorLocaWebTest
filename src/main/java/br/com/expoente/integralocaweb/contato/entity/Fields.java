package br.com.expoente.integralocaweb.contato.entity;

/**
 *
 * @author ednascimento
 */
public class Fields {

    private String data_de_nascimento;
    private String nome;
    private String chave;
    private String unidade;
    private String url;
    private String cidade;

    public Fields() {
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Fields{" + "data_de_nascimento=" + data_de_nascimento + ", nome=" + nome + ", chave=" + chave + ", unidade=" + unidade + ", url=" + url + ", cidade=" + cidade + '}';
    }

}
