package br.com.uemg.autopecas.model;

/**
 *
 * @author gustavo
 */
public class Pedido {

    private Integer id;
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Integer id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
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

}
