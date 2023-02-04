package br.com.uemg.autopecas.model;

/**
 *
 * @author gustavo
 */
public class ProdutoPedido {

    private Integer id;
    private Produto produto;
    private Pedido pedido;

    public ProdutoPedido() {
    }

    public ProdutoPedido(Integer id, Produto produto, Pedido pedido) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
