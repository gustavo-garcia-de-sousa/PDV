package br.com.uemg.autopecas.model;

/**
 *
 * @author gustavo
 */
public class Fornecedor {

    private Integer id;
    private Pessoa pessoa;
    private String contato;
    private String email;
    private String responsavel;
    private String cadastro;

    public Fornecedor() {
    }

    public Fornecedor(Integer id) {
        this.id = id;
    }

    public Fornecedor(Integer id, Pessoa pessoa, String contato, String email, String responsavel) {
        this.id = id;
        this.pessoa = pessoa;
        this.contato = contato;
        this.email = email;
        this.responsavel = responsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    @Override
    public String toString() {
        return "id:" + this.id
                + "\ntipo: " + this.pessoa.getTipo()
                + "\ninscrição: " + this.pessoa.getInscricao()
                + "\napelido: " + this.pessoa.getApelido()
                + "\ncontato: " + this.getContato()
                + "\nemail: " + this.getEmail();
    }

}
