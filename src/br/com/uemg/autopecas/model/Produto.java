package br.com.uemg.autopecas.model;

import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Produto {

    private Integer id;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private String descricao;
    private Double custo;
    private Double venda;
    private Integer estoque;
    private Integer quantidade;
    private String unidade;
    private Date cadastro;

    public Produto() {
    }

    public Produto(Integer id) {

        this.id = id;
    }

    public Produto(Integer id, Categoria categoria, Fornecedor fornecedor, String descricao, Double custo, Double venda, Integer estoque, Integer quantidade, String unidade) {
        this.id = id;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.custo = custo;
        this.venda = venda;
        this.estoque = estoque;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getVenda() {
        return venda;
    }

    public void setVenda(Double venda) {
        this.venda = venda;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    @Override
    public String toString() {
        return " *** CLASSE PRODUTO ***"
                + "\nID PRODUTO: " + this.id
                + "\nCATEGORIA: " + this.categoria
                + "\nFORNECEDOR: " + this.fornecedor
                + "\nDESCRICAO: " + this.descricao
                + "\nTIPO UNIDADE: " + this.unidade;
    }

}
