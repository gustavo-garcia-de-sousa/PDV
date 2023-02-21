package br.com.uemg.autopecas.model;

/**
 *
 * @author gustavo
 */
public class PedidoProduto {

    private Integer id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;
    private Double subtotal;
    private Double desconto;
    private Double total;

    public PedidoProduto(Integer id, Pedido pedido, Produto produto, Integer quantidade, Double subtotal, Double desconto, Double total) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
