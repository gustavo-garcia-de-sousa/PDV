package br.com.uemg.autopecas.model;

import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Pedido {

    private Integer id;
    private Cliente cliente;
    private Double subtotal;
    private Double desconto;
    private Double total;
    private String pagamento;
    private Date data;

    public Pedido() {
    }

    public Pedido(Integer id) {

        this.id = id;
    }

    public Pedido(Integer id, Cliente cliente, Double subtotal, Double desconto, Double total, String pagamento) {
        this.id = id;
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.total = total;
        this.pagamento = pagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "*** CLASSE PEDIDO ***"
                + "\nID PEDIDO: " + this.id
                + "\nCLIENTE: " + this.cliente.getId()
                + "\nSUBTOTAL: " + this.subtotal
                + "\nDESCONTO: " + this.desconto
                + "\nTOTAL: " + this.total
                + "\nPAGAMENTO: " + this.getPagamento();
    }

}
