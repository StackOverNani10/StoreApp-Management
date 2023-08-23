package models;

import java.util.Objects;

public class Compra {
    private int codigoCompra;
    private String numeroDocumento;
    private int codigoProveedor;
    private int codigoProductoComprado;
    private int unidadesCompradas;
    private double precioCompra;
    private double subTotalCompra;
    private double ivaCompra;
    private String fechaCompra;

    public Compra(int codigoCompra, String numeroDocumento, int codigoProveedor, int codigoProductoComprado, int unidadesCompradas, double precioCompra, double subTotalCompra, double ivaCompra, String fechaCompra) {
        this.codigoCompra = codigoCompra;
        this.numeroDocumento = numeroDocumento;
        this.codigoProveedor = codigoProveedor;
        this.codigoProductoComprado = codigoProductoComprado;
        this.unidadesCompradas = unidadesCompradas;
        this.precioCompra = precioCompra;
        this.subTotalCompra = subTotalCompra;
        this.ivaCompra = ivaCompra;
        this.fechaCompra = fechaCompra;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public int getCodigoProductoComprado() {
        return codigoProductoComprado;
    }

    public void setCodigoProductoComprado(int codigoProductoComprado) {
        this.codigoProductoComprado = codigoProductoComprado;
    }

    public int getUnidadesCompradas() {
        return unidadesCompradas;
    }

    public void setUnidadesCompradas(int unidadesCompradas) {
        this.unidadesCompradas = unidadesCompradas;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getSubTotalCompra() {
        return subTotalCompra;
    }

    public void setSubTotalCompra(double subTotalCompra) {
        this.subTotalCompra = subTotalCompra;
    }

    public double getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra compra)) return false;
        return codigoCompra == compra.codigoCompra && codigoProveedor == compra.codigoProveedor && codigoProductoComprado == compra.codigoProductoComprado && unidadesCompradas == compra.unidadesCompradas && Double.compare(precioCompra, compra.precioCompra) == 0 && Double.compare(subTotalCompra, compra.subTotalCompra) == 0 && Double.compare(ivaCompra, compra.ivaCompra) == 0 && Objects.equals(numeroDocumento, compra.numeroDocumento) && Objects.equals(fechaCompra, compra.fechaCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCompra, numeroDocumento, codigoProveedor, codigoProductoComprado, unidadesCompradas, precioCompra, subTotalCompra, ivaCompra, fechaCompra);
    }
}
