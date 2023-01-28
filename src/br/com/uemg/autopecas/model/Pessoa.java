package br.com.uemg.autopecas.model;

/**
 *
 * @author gustavo
 */
public class Pessoa {

    private String tipo;
    private String inscricao;
    private String apelido;
    private String nome;
    private String nascimento;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String CEP;

    public Pessoa() {
    }

    public Pessoa(String tipo, String inscricao, String apelido, String nome, String abertura, String logradouro, String bairro, String cidade, String uf, String CEP) {
        this.tipo = tipo;
        this.inscricao = inscricao;
        this.apelido = apelido;
        this.nome = nome;
        this.nascimento = abertura;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.CEP = CEP;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
