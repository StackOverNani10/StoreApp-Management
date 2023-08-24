package controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class FormController implements Initializable {

    // Declaramos los botones
    @FXML private Button btnVistaProducto;
    @FXML private Button btnVistaVenta;
    @FXML private Button btnVistaCompra;
    @FXML private Button btnVistaPedido;
    @FXML private Button btnVistaProveedor;

    // Declaramos los TextFields
    @FXML private TextField txtNombre;
    @FXML private TextField txtModelo;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;
    @FXML private TextField txtCodigoVenta;
    @FXML private TextField txtUnidades;
    @FXML private TextField txtCodCompra;
    @FXML private TextField txtNumDoc;
    @FXML private TextField txtUnidadCompra;
    @FXML private TextField txtCodigoPedido;
    @FXML private TextField txtUnidadesPedidas;
    @FXML private TextField txtCodigoProveedor;
    @FXML private TextField txtNombreProveedor;
    @FXML private TextField txtRuta;
    @FXML private TextField txtPrecioProductoProveedor;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEmail;
    @FXML private TextField txtFax;
    @FXML private TextField txtFormula;
    @FXML private TextField txtFactor;

    //Declaramos y definimos los ComboBox
    @FXML private ComboBox cboxCodProductoProveedor;
    @FXML private ComboBox cboxCodProductoPedido;
    @FXML private ComboBox cboxCodProductoCompra;
    @FXML private ComboBox cboxCodProveedorCompra;
    @FXML private ComboBox cboxCodProductoVenta;

    // Creamos las listas de los ComboBox
    ObservableList<String> listaCodProducto = FXCollections.observableArrayList();
    ObservableList<String> listaCodProveedor = FXCollections.observableArrayList();
    ObservableList<String> listaCodProductosProveedor = FXCollections.observableArrayList();

    // Diccionario de proveedores con sus productos
    Map<Integer, List<Integer>> diccProductoProveedor = new HashMap<>();

    // Lista de productos
    List<Producto> listaProductos = new ArrayList<>();

    // Declaramos los AnchorPane
    @FXML private AnchorPane welcome_form;
    @FXML private AnchorPane agregarProducto_form;
    @FXML private AnchorPane agregarVenta_form;
    @FXML private AnchorPane agregarCompra_form;
    @FXML private AnchorPane agregarPedido_form;
    @FXML private AnchorPane agregarProveedor_form;

    // Declaramos la tabla de Productos y sus columnas
    @FXML private TableView<Producto> tbl_producto;
    @FXML private TableColumn cl_codigo_producto;
    @FXML private TableColumn cl_nombre_product;
    @FXML private TableColumn cl_modelo_product;
    @FXML private TableColumn cl_cantidad_product;
    @FXML private TableColumn cl_precio_producto;
    @FXML private TableColumn cl_stock_product;
    @FXML private TableColumn cl_margen_product;
    private ObservableList<Producto> productos;
    private int posicionProductoTabla;

    // Declaramos la tabla de Ventas y sus columnas
    @FXML private TableView<Venta> tbl_venta;
    @FXML private TableColumn cl_codigo_venta;
    @FXML private TableColumn cl_codigo_producto_detalle;
    @FXML private TableColumn cl_nombre_product_detalle;
    @FXML private TableColumn cl_unidad_product;
    @FXML private TableColumn cl_subtotal;
    @FXML private TableColumn cl_iva;
    @FXML private TableColumn cl_total;
    @FXML private TableColumn cl_fecha_venta;
    private ObservableList<Venta> ventas;

    // Declaramos la tabla de Compra y sus columnas
    @FXML private TableView<Compra> tbl_compra;
    @FXML private TableColumn cl_codigo_compra;
    @FXML private TableColumn cl_num_doc;
    @FXML private TableColumn cl_cod_proveedor;
    @FXML private TableColumn cl_cod_producto_compra;
    @FXML private TableColumn cl_unidad_compra;
    @FXML private TableColumn cl_precio_compra;
    @FXML private TableColumn cl_subtotal_compra;
    @FXML private TableColumn cl_iva_compra;
    @FXML private TableColumn cl_total_compra;
    @FXML private TableColumn cl_fecha_compra;
    private ObservableList<Compra> compras;

    // Declaramos la tabla de Pedido y sus columnas
    @FXML private TableView<Pedido> tbl_pedido;
    @FXML private TableColumn cl_codigo_pedido;
    @FXML private TableColumn cl_codigo_producto_pedido;
    @FXML private TableColumn cl_unidad_pedido;
    @FXML private TableColumn cl_precio_pedido;
    @FXML private TableColumn cl_total_pedido;
    @FXML private TableColumn cl_fecha_pedido;
    private ObservableList<Pedido> pedidos;

    // Declaramos la tabla de Proveedor y sus columnas
    @FXML private TableView<Proveedor> tbl_Proveedor;
    @FXML private TableColumn cl_codigo_proveedor;
    @FXML private TableColumn cl_nombre_proveedor;
    @FXML private TableColumn cl_cod_producto_proveedor;
    @FXML private TableColumn cl_precio_producto_proveedor;
    @FXML private TableColumn cl_ruta;
    @FXML private TableColumn cl_dirección;
    @FXML private TableColumn cl_ciudad;
    @FXML private TableColumn cl_telefono;
    @FXML private TableColumn cl_fax;
    @FXML private TableColumn cl_email;
    @FXML private TableColumn cl_formula;
    @FXML private TableColumn cl_factor;
    private ObservableList<Proveedor> proveedores;

    private int posicionProveedorTabla;

    //Importamos los modelos
    private Venta venta;
    private Producto producto;
    private Compra compra;
    private Pedido pedido;
    private Proveedor proveedor;

    //Variables para mostrar fecha
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    // Este es el codigo inicial del producto
    private static int codigoInicial = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        agregarDatosProducto();

        agregarDatosVenta();
        cboxCodProductoVenta.setItems(listaCodProducto);

        agregarDatosCompra();
        cboxCodProveedorCompra.setItems(listaCodProveedor);
        cboxCodProductoCompra.setItems(listaCodProductosProveedor);

        agregarDatosPedido();
        cboxCodProductoPedido.setItems(listaCodProducto);

        agregarDatosProveedor();
        cboxCodProductoProveedor.setItems(listaCodProducto);
    }

    public void agregarDatosProducto(){

        // Inizializar Tabla de producto
        productos = FXCollections.observableArrayList();

        this.cl_codigo_producto.setCellValueFactory(new PropertyValueFactory("codigoProducto"));
        this.cl_nombre_product.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.cl_modelo_product.setCellValueFactory(new PropertyValueFactory("modeloProducto"));
        this.cl_cantidad_product.setCellValueFactory(new PropertyValueFactory("cantidadProducto"));
        this.cl_precio_producto.setCellValueFactory(new PropertyValueFactory("precioProducto"));
        this.cl_stock_product.setCellValueFactory(new PropertyValueFactory("stockProducto"));
        this.cl_margen_product.setCellValueFactory(new PropertyValueFactory("margenProducto"));

        final ObservableList<Producto> tablaProductoCelda = tbl_producto.getSelectionModel().getSelectedItems();
        tablaProductoCelda.addListener(SelectorProductoTabla);
    }

    public void agregarDatosVenta(){

        // Inizializar Tabla de venta
        ventas = FXCollections.observableArrayList();

        this.cl_codigo_venta.setCellValueFactory(new PropertyValueFactory("codigoVenta"));
        this.cl_codigo_producto_detalle.setCellValueFactory(new PropertyValueFactory("codProducto"));
        this.cl_nombre_product_detalle.setCellValueFactory(new PropertyValueFactory("nomProducto"));
        this.cl_unidad_product.setCellValueFactory(new PropertyValueFactory("unidades"));
        this.cl_subtotal.setCellValueFactory(new PropertyValueFactory("subtotal"));
        this.cl_iva.setCellValueFactory(new PropertyValueFactory("iva"));
        this.cl_total.setCellValueFactory(new PropertyValueFactory("precioVenta"));
        this.cl_fecha_venta.setCellValueFactory(new PropertyValueFactory("fechaVenta"));
    }

    public void agregarDatosCompra(){

        // Inizializar Tabla de compra
        compras = FXCollections.observableArrayList();

        this.cl_codigo_compra.setCellValueFactory(new PropertyValueFactory("codigoCompra"));
        this.cl_num_doc.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        this.cl_cod_proveedor.setCellValueFactory(new PropertyValueFactory("codigoProveedor"));
        this.cl_cod_producto_compra.setCellValueFactory(new PropertyValueFactory("codigoProductoComprado"));
        this.cl_unidad_compra.setCellValueFactory(new PropertyValueFactory("unidadesCompradas"));
        this.cl_precio_compra.setCellValueFactory(new PropertyValueFactory("precioCompra"));
        this.cl_subtotal_compra.setCellValueFactory(new PropertyValueFactory("subTotalCompra"));
        this.cl_iva_compra.setCellValueFactory(new PropertyValueFactory("ivaCompra"));
        this.cl_total_compra.setCellValueFactory(new PropertyValueFactory("totalCompra"));
        this.cl_fecha_compra.setCellValueFactory(new PropertyValueFactory("fechaCompra"));
    }

    public void agregarDatosPedido(){

        // Inizializar Tabla de pedido
        pedidos = FXCollections.observableArrayList();

        this.cl_codigo_pedido.setCellValueFactory(new PropertyValueFactory("codigoPedido"));
        this.cl_codigo_producto_pedido.setCellValueFactory(new PropertyValueFactory("codigoProductoPedido"));
        this.cl_unidad_pedido.setCellValueFactory(new PropertyValueFactory("unidadPedida"));
        this.cl_precio_pedido.setCellValueFactory(new PropertyValueFactory("precioPedido"));
        this.cl_total_pedido.setCellValueFactory(new PropertyValueFactory("totalPedido"));
        this.cl_fecha_pedido.setCellValueFactory(new PropertyValueFactory("fechapedido"));

    }

    public void agregarDatosProveedor(){

        // Inizializar Tabla de proveedor
        proveedores = FXCollections.observableArrayList();

        this.cl_codigo_proveedor.setCellValueFactory(new PropertyValueFactory("codigoProveedor"));
        this.cl_nombre_proveedor.setCellValueFactory(new PropertyValueFactory("nombreProveedor"));
        this.cl_cod_producto_proveedor.setCellValueFactory(new PropertyValueFactory("codigoProductoProveedor"));
        this.cl_precio_producto_proveedor.setCellValueFactory(new PropertyValueFactory("precioProductoProveedor"));
        this.cl_ruta.setCellValueFactory(new PropertyValueFactory("rutaProveedor"));
        this.cl_dirección.setCellValueFactory(new PropertyValueFactory("direccionProveedor"));
        this.cl_ciudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        this.cl_telefono.setCellValueFactory(new PropertyValueFactory("telefonoProveedor"));
        this.cl_fax.setCellValueFactory(new PropertyValueFactory("faxProveedor"));
        this.cl_email.setCellValueFactory(new PropertyValueFactory("emailProveedor"));
        this.cl_formula.setCellValueFactory(new PropertyValueFactory("formulaProveedor"));
        this.cl_factor.setCellValueFactory(new PropertyValueFactory("factorProveedor"));

        final ObservableList<Proveedor> tablaProveedorCelda = tbl_Proveedor.getSelectionModel().getSelectedItems();
        tablaProveedorCelda.addListener(SelectorProveedorTabla);
    }

    // Funcion para navegar entre los distintos Forms
    public void cambiarForm(ActionEvent event) {

        if(event.getSource() == btnVistaProducto) {
            welcome_form.setVisible(false);
            agregarProducto_form.setVisible(true);
            agregarVenta_form.setVisible(false);
            agregarCompra_form.setVisible(false);
            agregarPedido_form.setVisible(false);
            agregarProveedor_form.setVisible(false);
        } else if (event.getSource() == btnVistaVenta) {
            welcome_form.setVisible(false);
            agregarProducto_form.setVisible(false);
            agregarVenta_form.setVisible(true);
            agregarCompra_form.setVisible(false);
            agregarPedido_form.setVisible(false);
            agregarProveedor_form.setVisible(false);
        } else if (event.getSource() == btnVistaCompra) {
            welcome_form.setVisible(false);
            agregarProducto_form.setVisible(false);
            agregarVenta_form.setVisible(false);
            agregarCompra_form.setVisible(true);
            agregarPedido_form.setVisible(false);
            agregarProveedor_form.setVisible(false);
        } else if (event.getSource() == btnVistaPedido) {
            welcome_form.setVisible(false);
            agregarProducto_form.setVisible(false);
            agregarVenta_form.setVisible(false);
            agregarCompra_form.setVisible(false);
            agregarPedido_form.setVisible(true);
            agregarProveedor_form.setVisible(false);
        } else if (event.getSource() == btnVistaProveedor) {
            welcome_form.setVisible(false);
            agregarProducto_form.setVisible(false);
            agregarVenta_form.setVisible(false);
            agregarCompra_form.setVisible(false);
            agregarPedido_form.setVisible(false);
            agregarProveedor_form.setVisible(true);
        }
    }

    //====================================Controles de Producto==========================================
    @FXML
    private void ingresar_producto(ActionEvent event) {
        try {
            int codigoProducto = codigoInicial;
            String nombreProducto = txtNombre.getText();
            String modeloProducto = txtModelo.getText();
            int cantidadProducto = Integer.parseInt(txtCantidad.getText());
            double precioProducto = Double.parseDouble(txtPrecio.getText());
            int stockProducto = Integer.parseInt(txtStock.getText());

            producto = new Producto(codigoProducto, nombreProducto, modeloProducto, cantidadProducto, precioProducto, stockProducto);
            if(!this.productos.contains(producto)){
                if (stockProducto>10) {
                    codigoInicial++; // Incremento valor del codigo producto
                    this.productos.add(producto);
                    this.tbl_producto.setItems(productos);
                    this.listaProductos.add(producto);
                    this.listaCodProducto.add(String.valueOf(producto.getCodigoProducto())); // Agregamos el codigo de producto a la lista.
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El stock debe ser mayor que 10");
                    alert.showAndWait();
                }
            } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El producto ya existe");
                    alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    @FXML
    public void modificar_producto(ActionEvent event) {
        try {
            Producto productoAModificar = getTablaProductoSeleccionado();
            int codigoProducto = productos.indexOf(productoAModificar) + 1;
            String nombreProducto = txtNombre.getText();
            String modeloProducto = txtModelo.getText();
            int cantidadProducto = Integer.parseInt(txtCantidad.getText());
            double precioProducto = Double.parseDouble(txtPrecio.getText());
            int stockProducto = Integer.parseInt(txtStock.getText());

            producto = new Producto(codigoProducto, nombreProducto, modeloProducto, cantidadProducto, precioProducto, stockProducto);
            if (stockProducto>10) {
                this.productos.set(posicionProductoTabla ,producto);
                this.tbl_producto.setItems(productos);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El stock debe ser mayor que 10");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    public static Producto consultarProductoPorCodigo(List<Producto> productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigoProducto() == codigo) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }

    @FXML
    public void consultar_producto(ActionEvent event) {
        int codigo = Integer.parseInt(txtNombre.getText());
        Producto productoEncontrado = consultarProductoPorCodigo(productos, codigo);

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    @FXML
    public void clearProductoFields(ActionEvent event) {
        txtNombre.setText("");
        txtModelo.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

    private final ListChangeListener<Producto> SelectorProductoTabla = new ListChangeListener<Producto>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Producto> change) {
            ponerProductoSeleccionado();
        }
    };

    public Producto getTablaProductoSeleccionado() {
        if (tbl_producto != null) {
            List<Producto> tabla = tbl_producto.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Producto competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private void ponerProductoSeleccionado() {
        final Producto producto = getTablaProductoSeleccionado();
        posicionProductoTabla = productos.indexOf(producto);

        if (producto != null) {

            // Colocamos los datos correspondientes en los TextFields
            txtNombre.setText(producto.getNombreProducto());
            txtModelo.setText(producto.getModeloProducto());
            txtCantidad.setText(String.valueOf(producto.getCantidadProducto()));
            txtPrecio.setText(String.valueOf(producto.getPrecioProducto()));
            txtStock.setText(String.valueOf(producto.getStockProducto()));
        }
    }


    //====================================Controles de Venta==========================================
    @FXML
    public void ingresar_venta(ActionEvent event) {
        try {
            int codigoVenta = Integer.parseInt(this.txtCodigoVenta.getText());
            int codigoProducto = Integer.parseInt(cboxCodProductoVenta.getSelectionModel().getSelectedItem().toString());
            Producto productoIndicado = productos.get(codigoProducto - 1); //Tomamos los valores pertenecientes al codigo de producto indicado
            String nombreProducto = productoIndicado.getNombreProducto();
            int unidades = Integer.parseInt(txtUnidades.getText());
            double subtotal = calcularSubTotal(codigoProducto, txtUnidades);
            double iva = calcularIva(codigoProducto, txtUnidades);
            double precioVenta = subtotal + iva;
            String fechaVenta = formatter.format(date);

            venta = new Venta(codigoVenta, codigoProducto, nombreProducto, unidades, subtotal, iva, precioVenta, fechaVenta);
            if(!this.ventas.contains(venta)) {
                if (unidades <= productoIndicado.getStockProducto()) {
                    this.ventas.add(venta);
                    this.tbl_venta.setItems(ventas);
                    // Llamamos la funcion para que reste las unidades vendidas al stock del producto.
                    reajusteStock("Restar", codigoProducto, unidades);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("No hay stock suficiente");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La venta ya existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    public static Venta consultarVentaPorCodigo(List<Venta> ventas, int codigo) {
        for (Venta venta : ventas) {
            if (venta.getCodigoVenta() == codigo) {
                return venta;
            }
        }
        return null; // Venta no encontrada
    }

    @FXML
    public void consultar_venta(ActionEvent event) {
        int codigo = Integer.parseInt(txtCodigoVenta.getText());
        Venta ventaEncontrada = consultarVentaPorCodigo(ventas, codigo);

        if (ventaEncontrada != null) {
            System.out.println("Venta encontrado: " + ventaEncontrada);
        } else {
            System.out.println("Venta no encontrado.");
        }
    }

    @FXML
    public void clearVentaFields(ActionEvent event) {
        txtCodigoVenta.setText("");
        txtUnidades.setText("");
    }

    //====================================Controles de Compra==========================================
    @FXML
    public void ingresar_compra(ActionEvent event){
        try {
            int codigoCompra = Integer.parseInt(this.txtCodCompra.getText());
            String numeroDocumento = txtNumDoc.getText();
            int codigoProveedor = Integer.parseInt(cboxCodProveedorCompra.getSelectionModel().getSelectedItem().toString());
            int codigoProductoComprado = Integer.parseInt(cboxCodProductoCompra.getSelectionModel().getSelectedItem().toString());
            Producto productoElegido = productos.get(codigoProductoComprado - 1); // Obtenemos los datos del producto indicado
            double precioVenta = productoElegido.getPrecioProducto(); // Guardamos el precio de venta del producto para calcular margen.
            int unidadesCompradas = Integer.parseInt(this.txtUnidadCompra.getText());
            Proveedor proveedorIndicado = proveedores.get(codigoProveedor - 1); // Obtenemos los datos del proveedor indicado
            double precioCompra = proveedorIndicado.getPrecioProductoProveedor();
            double subTotalCompra = unidadesCompradas * precioCompra;
            double ivaCompra = subTotalCompra * 0.18;
            double totalCompra = subTotalCompra + ivaCompra;
            String fechaCompra = formatter.format(date);

            compra = new Compra(codigoCompra, numeroDocumento, codigoProveedor, codigoProductoComprado, unidadesCompradas, precioCompra, subTotalCompra, ivaCompra, totalCompra,fechaCompra);
            if(!this.compras.contains(compra)) {
                this.compras.add(compra);
                this.tbl_compra.setItems(compras);
                // Llamamos la funcion para que sume las unidades compradas al stock del producto.
                reajusteStock("Sumar", codigoProductoComprado, unidadesCompradas);
                // Llamamos a la funcion de reajustar margen del producto
                calcularMargen(precioVenta, precioCompra, codigoProductoComprado);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La compra ya existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    public static Compra consultarCompraPorCodigo(List<Compra> compras, int codigo) {
        for (Compra compra : compras) {
            if (compra.getCodigoCompra() == codigo) {
                return compra;
            }
        }
        return null; // Compra no encontrada
    }

    @FXML
    public void consultar_compra(ActionEvent event){
        int codigo = Integer.parseInt(txtCodCompra.getText());
        Compra compraEncontrada = consultarCompraPorCodigo(compras, codigo);

        if (compraEncontrada != null) {
            System.out.println("Compra encontrada: " + compraEncontrada);
        } else {
            System.out.println("Compra no encontrada.");
        }
    }

    @FXML
    public void clearCompraFields(ActionEvent event){
        txtCodCompra.setText("");
        txtNumDoc.setText("");
        txtUnidadCompra.setText("");
    }

    //====================================Controles de Pedido==========================================
    @FXML
    public void ingresar_pedido(ActionEvent event){
        try {
            int codigoPedido = Integer.parseInt(this.txtCodigoPedido.getText());
            int codigoProductoPedido = Integer.parseInt(cboxCodProductoPedido.getSelectionModel().getSelectedItem().toString());
            Producto productoElegido = productos.get(codigoProductoPedido - 1); //Tomamos los valores pertenecientes al codigo de producto indicado
            int unidadPedida = Integer.parseInt(this.txtUnidadesPedidas.getText());
            double precioPedido = productoElegido.getPrecioProducto();
            double totalPedido = unidadPedida * precioPedido;
            String fechapedido = formatter.format(date);

            pedido = new Pedido(codigoPedido, codigoProductoPedido, unidadPedida, precioPedido, totalPedido, fechapedido);
            if(!this.pedidos.contains(pedido)) {
                this.pedidos.add(pedido);
                this.tbl_pedido.setItems(pedidos);
                // Llamamos la funcion para que sume las unidades pedidas al stock del producto.
                reajusteStock("Sumar", codigoProductoPedido, unidadPedida);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El pedido ya existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    public static Pedido consultarPedidoPorCodigo(List<Pedido> pedidos, int codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoPedido() == codigo) {
                return pedido;
            }
        }
        return null; // Pedido no encontrado
    }

    @FXML
    public void consultar_pedido(ActionEvent event){
        int codigo = Integer.parseInt(txtCodigoPedido.getText());
        Pedido pedidoEncontrado = consultarPedidoPorCodigo(pedidos, codigo);

        if (pedidoEncontrado != null) {
            System.out.println("Pedido encontrado: " + pedidoEncontrado);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    @FXML
    public void clearPedidoFields(ActionEvent event){
        txtCodigoPedido.setText("");
        txtUnidadesPedidas.setText("");
    }

    //====================================Controles de Proveedor==========================================
    @FXML
    public void ingresar_proveedor(ActionEvent event){
        try {
            int codigoProveedor = Integer.parseInt(this.txtCodigoProveedor.getText());
            String nombreProveedor = txtNombreProveedor.getText();
            int codigoProductoProveedor = Integer.parseInt(cboxCodProductoProveedor.getSelectionModel().getSelectedItem().toString());
            double precioProductoProveedor = Double.parseDouble(txtPrecioProductoProveedor.getText());
            String rutaProveedor = txtRuta.getText();
            String direccionProveedor = txtDireccion.getText();
            String ciudad = txtCiudad.getText();
            String telefonoProveedor = txtTelefono.getText();
            String faxProveedor = txtFax.getText();
            String emailProveedor = txtEmail.getText();
            String formulaProveedor = txtFormula.getText();
            String factorProveedor = txtFactor.getText();

            proveedor = new Proveedor(codigoProveedor, nombreProveedor, codigoProductoProveedor, precioProductoProveedor, rutaProveedor, direccionProveedor, ciudad, telefonoProveedor, faxProveedor, emailProveedor, formulaProveedor, factorProveedor);
            if(!this.proveedores.contains(proveedor)) {
                this.proveedores.add(proveedor);
                this.tbl_Proveedor.setItems(proveedores);
                if (!this.listaCodProveedor.contains(String.valueOf(codigoProveedor))){
                    this.listaCodProveedor.add(String.valueOf(codigoProveedor)); // Agregamos el codigo de proveedor a la lista.
                }
                if (!diccProductoProveedor.containsKey(codigoProveedor)) { // Preguntamos si el diccionario ya contiene la clave del proveedor ingresado.
                    diccProductoProveedor.put(codigoProveedor, new ArrayList<>()); // Creamos una nueva lista para la nueva clave del proveedor.
                    diccProductoProveedor.get(codigoProveedor).add(codigoProductoProveedor);// Agregamos el productos a la clave del proveedor.
                } else {
                    diccProductoProveedor.get(codigoProveedor).add(codigoProductoProveedor); // Si ya existe la clave, agregamos otro valor a su lista.
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El proveedor ya existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    @FXML
    public void modificar_proveedor(ActionEvent event) {
        try {
            int codigoProveedor = Integer.parseInt(this.txtCodigoProveedor.getText());
            String nombreProveedor = txtNombreProveedor.getText();
            int codigoProductoProveedor = Integer.parseInt(cboxCodProductoProveedor.getSelectionModel().getSelectedItem().toString());
            double precioProductoProveedor = Double.parseDouble(txtPrecioProductoProveedor.getText());
            String rutaProveedor = txtRuta.getText();
            String direccionProveedor = txtDireccion.getText();
            String ciudad = txtCiudad.getText();
            String telefonoProveedor = txtTelefono.getText();
            String faxProveedor = txtFax.getText();
            String emailProveedor = txtEmail.getText();
            String formulaProveedor = txtFormula.getText();
            String factorProveedor = txtFactor.getText();

            proveedor = new Proveedor(codigoProveedor, nombreProveedor, codigoProductoProveedor, precioProductoProveedor, rutaProveedor, direccionProveedor, ciudad, telefonoProveedor, faxProveedor, emailProveedor, formulaProveedor, factorProveedor);
            if(!this.proveedores.contains(proveedor)) {
                this.proveedores.set(posicionProveedorTabla, proveedor);
                this.tbl_Proveedor.setItems(proveedores);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El proveedor ya existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    public static Proveedor consultarProveedorPorCodigo(List<Proveedor> proveedores, int codigo) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCodigoProveedor() == codigo) {
                return proveedor;
            }
        }
        return null; // Proveedor no encontrado
    }

    @FXML
    public void consultar_proveedor(ActionEvent event){
        int codigo = Integer.parseInt(txtCodigoProveedor.getText());
        Proveedor proveedorEncontrado = consultarProveedorPorCodigo(proveedores, codigo);
        if (proveedorEncontrado != null) {
            System.out.println("Proveedor encontrado: " + proveedorEncontrado);
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    @FXML
    public void clearProveedorFields(ActionEvent event){
        txtCodigoProveedor.setText("");
        txtNombreProveedor.setText("");
        txtRuta.setText("");
        txtPrecioProductoProveedor.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtFax.setText("");
        txtFormula.setText("");
        txtFactor.setText("");
    }

    private final ListChangeListener<Proveedor> SelectorProveedorTabla = new ListChangeListener<Proveedor>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Proveedor> change) {
            ponerProveedorSeleccionado();
        }
    };

    public Proveedor getTablaProveedorSeleccionado() {
        if (tbl_Proveedor != null) {
            List<Proveedor> tabla = tbl_Proveedor.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Proveedor proveedorSeleccionado = tabla.get(0);
                return proveedorSeleccionado;
            }
        }
        return null;
    }

    private void ponerProveedorSeleccionado() {
        final Proveedor proveedor = getTablaProveedorSeleccionado();
        posicionProveedorTabla = proveedores.indexOf(proveedor);

        if (proveedor != null) {

            // Colocamos los datos correspondientes en los TextFields
            txtCodigoProveedor.setText(String.valueOf(proveedor.getCodigoProveedor()));
            txtNombreProveedor.setText(proveedor.getNombreProveedor());
            txtRuta.setText(proveedor.getRutaProveedor());
            txtPrecioProductoProveedor.setText(String.valueOf(proveedor.getPrecioProductoProveedor()));
            txtDireccion.setText(proveedor.getDireccionProveedor());
            txtCiudad.setText(proveedor.getCiudad());
            txtTelefono.setText(proveedor.getTelefonoProveedor());
            txtEmail.setText(proveedor.getEmailProveedor());
            txtFax.setText(proveedor.getFaxProveedor());
            txtFormula.setText(proveedor.getFormulaProveedor());
            txtFactor.setText(proveedor.getFactorProveedor());
        }
    }

    // Funciones de Calculo
    public double calcularIva(int codigoProducto, TextField textFieldUnidades) {
        double iva = 0.18;
        double und = Double.parseDouble(textFieldUnidades.getText());
        Producto productoIndicado = productos.get(codigoProducto - 1); //Tomamos los valores pertenecientes al codigo de producto indicado
        double precioProducto = productoIndicado.getPrecioProducto();
        double totalIva = (und * precioProducto) * iva;
        return totalIva;
    }

    public double calcularSubTotal(int codigoProducto, TextField textFieldUnidades) {
        double und = Double.parseDouble(textFieldUnidades.getText());
        Producto productoIndicado = productos.get(codigoProducto - 1); //Tomamos los valores pertenecientes al codigo de producto indicado
        double precioProducto = productoIndicado.getPrecioProducto();
        double subTotal = (und * precioProducto);
        return subTotal;
    }

    public void calcularMargen(Double subtotalVenta, Double totalCompra, int codigoproducto){
        double gananciaNeta = subtotalVenta - totalCompra;
        double ventas = subtotalVenta;
        double margenPorcentual = (gananciaNeta/ventas) * 100;
        String margen = String.valueOf(margenPorcentual);
        String resultado = margen + " %";

        Producto productoElegido = productos.get(codigoproducto - 1);
        productoElegido.setMargenProducto(resultado);
        tbl_producto.refresh(); // Refrescamos la tabla productos para que se reflejen los cambios.
    }

    public void reajusteStock(String accion, int codigoProducto, int unidades) {

        Producto productoElegido = productos.get(codigoProducto - 1);
        int stockActual = productoElegido.getStockProducto();

        if (accion == "Sumar"){
            productoElegido.setStockProducto(stockActual + unidades);
        } else {
            productoElegido.setStockProducto(stockActual - unidades);
        }
        tbl_producto.refresh(); // Refrescamos la tabla productos para que se reflejen los cambios.
    }

    // Funcion de generar el comboBox de productos de acuerdo con su proveedor
    public void generarCBoxProducto(ActionEvent event) {
        cboxCodProductoCompra.getSelectionModel().clearSelection(); // limpiamos el comboBox
        int clave = Integer.parseInt(cboxCodProveedorCompra.getSelectionModel().getSelectedItem().toString()); // Obtenemos el valor de la clave que utilazaremos del diccionario.
        List<Integer> listaDeProductos = diccProductoProveedor.get(clave); // Creamos lista con valores obtenidos por la clave

        listaCodProductosProveedor.clear(); //Limpiamos la lista que rellena el comboBox
        for (Integer producto : listaDeProductos) {
            listaCodProductosProveedor.add(String.valueOf(producto)); // Iteramos la lista para colocar sus valores en la lista del comboBox.
        }
    }
}
