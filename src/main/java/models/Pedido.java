package models;

import java.util.Objects;

public class Pedido {
    private int codigoPedido;
    private int codigoProductoPedido;
    private int unidadPedida;
    private double precioPedido;
    private double totalPedido;
    private String fechapedido;

    public Pedido(int codigoPedido, int codigoProductoPedido, int unidadPedida, double precioPedido, double totalPedido, String fechapedido) {
        this.codigoPedido = codigoPedido;
        this.codigoProductoPedido = codigoProductoPedido;
        this.unidadPedida = unidadPedida;
        this.precioPedido = precioPedido;
        this.totalPedido = totalPedido;
        this.fechapedido = fechapedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoProductoPedido() {
        return codigoProductoPedido;
    }

    public void setCodigoProductoPedido(int codigoProductoPedido) {
        this.codigoProductoPedido = codigoProductoPedido;
    }

    public int getUnidadPedida() {
        return unidadPedida;
    }

    public void setUnidadPedida(int unidadPedida) {
        this.unidadPedida = unidadPedida;
    }

    public double getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(double precioPedido) {
        this.precioPedido = precioPedido;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return codigoPedido == pedido.codigoPedido && codigoProductoPedido == pedido.codigoProductoPedido && unidadPedida == pedido.unidadPedida && Double.compare(precioPedido, pedido.precioPedido) == 0 && Double.compare(totalPedido, pedido.totalPedido) == 0 && Objects.equals(fechapedido, pedido.fechapedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPedido, codigoProductoPedido, unidadPedida, precioPedido, totalPedido, fechapedido);
    }
}
