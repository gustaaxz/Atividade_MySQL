package org.example;

public class Pedido {
    private int id, cliente_id;
    private String data_pedido, volume_m3, peso_kg, statusPedido;

    public Pedido(int id, int cliente_id, String data_pedido, String volume_m3, String peso_kg, String statusPedido) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.statusPedido = statusPedido;
    }

    public Pedido(int cliente_id, String data_pedido, String volume_m3, String peso_kg, String statusPedido) {
        this.cliente_id = cliente_id;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.statusPedido = statusPedido;
    }

    public int getId() {
        return id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public String getVolume_m3() {
        return volume_m3;
    }

    public String getPeso_kg() {
        return peso_kg;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public void setVolume_m3(String volume_m3) {
        this.volume_m3 = volume_m3;
    }

    public void setPeso_kg(String peso_kg) {
        this.peso_kg = peso_kg;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
