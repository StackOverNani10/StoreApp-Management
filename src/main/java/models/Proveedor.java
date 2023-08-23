package models;

import java.util.Objects;

public class Proveedor {
    private int codigoProveedor;
    private String nombreProveedor;
    private int codigoProductoProveedor;
    private double precioProductoProveedor;
    private String rutaProveedor;
    private String direccionProveedor;
    private String ciudad;
    private String telefonoProveedor;
    private String faxProveedor;
    private String emailProveedor;
    private String formulaProveedor;
    private String factorProveedor;

    public Proveedor(int codigoProveedor, String nombreProveedor, int codigoProductoProveedor, double precioProductoProveedor, String rutaProveedor, String direccionProveedor, String ciudad, String telefonoProveedor, String faxProveedor, String emailProveedor, String formulaProveedor, String factorProveedor) {
        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.codigoProductoProveedor = codigoProductoProveedor;
        this.precioProductoProveedor = precioProductoProveedor;
        this.rutaProveedor = rutaProveedor;
        this.direccionProveedor = direccionProveedor;
        this.ciudad = ciudad;
        this.telefonoProveedor = telefonoProveedor;
        this.faxProveedor = faxProveedor;
        this.emailProveedor = emailProveedor;
        this.formulaProveedor = formulaProveedor;
        this.factorProveedor = factorProveedor;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getCodigoProductoProveedor() {
        return codigoProductoProveedor;
    }

    public void setCodigoProductoProveedor(int codigoProductoProveedor) {
        this.codigoProductoProveedor = codigoProductoProveedor;
    }

    public double getPrecioProductoProveedor() {
        return precioProductoProveedor;
    }

    public void setPrecioProductoProveedor(double precioProductoProveedor) {
        this.precioProductoProveedor = precioProductoProveedor;
    }

    public String getRutaProveedor() {
        return rutaProveedor;
    }

    public void setRutaProveedor(String rutaProveedor) {
        this.rutaProveedor = rutaProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getFaxProveedor() {
        return faxProveedor;
    }

    public void setFaxProveedor(String faxProveedor) {
        this.faxProveedor = faxProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getFormulaProveedor() {
        return formulaProveedor;
    }

    public void setFormulaProveedor(String formulaProveedor) {
        this.formulaProveedor = formulaProveedor;
    }

    public String getFactorProveedor() {
        return factorProveedor;
    }

    public void setFactorProveedor(String factorProveedor) {
        this.factorProveedor = factorProveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proveedor proveedor)) return false;
        return codigoProveedor == proveedor.codigoProveedor && codigoProductoProveedor == proveedor.codigoProductoProveedor && Double.compare(precioProductoProveedor, proveedor.precioProductoProveedor) == 0 && Objects.equals(nombreProveedor, proveedor.nombreProveedor) && Objects.equals(rutaProveedor, proveedor.rutaProveedor) && Objects.equals(direccionProveedor, proveedor.direccionProveedor) && Objects.equals(ciudad, proveedor.ciudad) && Objects.equals(telefonoProveedor, proveedor.telefonoProveedor) && Objects.equals(faxProveedor, proveedor.faxProveedor) && Objects.equals(emailProveedor, proveedor.emailProveedor) && Objects.equals(formulaProveedor, proveedor.formulaProveedor) && Objects.equals(factorProveedor, proveedor.factorProveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProveedor, nombreProveedor, codigoProductoProveedor, precioProductoProveedor, rutaProveedor, direccionProveedor, ciudad, telefonoProveedor, faxProveedor, emailProveedor, formulaProveedor, factorProveedor);
    }
}
