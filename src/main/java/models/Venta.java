package models;

import java.util.Objects;

public class Venta {
    private int codigoVenta;
    private int codProducto;
    private String nomProducto;
    private int unidades;
    private double subtotal;
    private double iva;
    private double precioVenta;
    private String fechaVenta;

    public Venta(int codigoVenta, int codProducto, String nomProducto, int unidades, double subtotal, double iva, double precioVenta, String fechaVenta) {
        this.codigoVenta = codigoVenta;
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.unidades = unidades;
        this.subtotal = subtotal;
        this.iva = iva;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta venta)) return false;
        return codigoVenta == venta.codigoVenta && codProducto == venta.codProducto && unidades == venta.unidades && Double.compare(subtotal, venta.subtotal) == 0 && Double.compare(iva, venta.iva) == 0 && Double.compare(precioVenta, venta.precioVenta) == 0 && Objects.equals(nomProducto, venta.nomProducto) && Objects.equals(fechaVenta, venta.fechaVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoVenta, codProducto, nomProducto, unidades, subtotal, iva, precioVenta, fechaVenta);
    }
}
