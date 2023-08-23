package models;

import java.util.Objects;

public class Producto {

    private int codigoProducto;
    private String nombreProducto;
    private String modeloProducto;
    private int cantidadProducto;
    private double precioProducto;
    private int stockProducto;
    private String margenProducto;

    public Producto(int codigoProducto, String nombreProducto, String modeloProducto, int cantidadProducto, double precioProducto, int stockProducto, String margenProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.modeloProducto = modeloProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.margenProducto = margenProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(String modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getMargenProducto() {
        return margenProducto;
    }

    public void setMargenProducto(String margenProducto) {
        this.margenProducto = margenProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return codigoProducto == producto.codigoProducto && cantidadProducto == producto.cantidadProducto && precioProducto == producto.precioProducto && stockProducto == producto.stockProducto && Objects.equals(nombreProducto, producto.nombreProducto) && Objects.equals(modeloProducto, producto.modeloProducto) && Objects.equals(margenProducto, producto.margenProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProducto, nombreProducto, modeloProducto, cantidadProducto, precioProducto, stockProducto, margenProducto);
    }
}

