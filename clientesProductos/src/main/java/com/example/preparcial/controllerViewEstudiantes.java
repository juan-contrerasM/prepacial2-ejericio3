package com.example.preparcial;

import com.example.preparcial.model.Cliente;
import com.example.preparcial.model.Pedidos;
import com.example.preparcial.model.Productos;
import com.example.preparcial.utils.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controllerViewEstudiantes implements Initializable {
    //-----------------------------atributo globales-----------------------------

    //listas
    private ObservableList<Productos> listaPrincipal = FXCollections.observableArrayList();
    private ArrayList<Productos> listaProductos = new ArrayList<>();
    private Productos productos;

    //----------------------------------fxml iniciarsesion--------------------
    @FXML
    private Label lblLogin;
    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblpassword;
    @FXML
    private Pane paneLoggin;
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsuario;
    //--------------------------------fxml cliente-----------------------------------------
    @FXML
    private TextField BuscadorCliente;
    @FXML
    private Button btnAgregarCliente;
    @FXML
    private Button btnBuscarCliente;
    @FXML
    private Button btnGuardarCliente;
    @FXML
    private Button btnListarCliente;
    @FXML
    private Label lblApellido;
    @FXML
    private Label lblCedula;
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblCodigoCliente;
    @FXML
    private Label lblIdentificacion;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblNombreCliente;
    @FXML
    private Label lblNota1;
    @FXML
    private Label lblRegistrarCliente;
    @FXML
    private Label lblTelefono;
    @FXML
    private Pane paneBotonesCliente1;
    @FXML
    private Pane paneCamposCliente;
    @FXML
    private Pane panePrincipalCliente;
    @FXML
    private Pane paneTableCliente;
    @FXML
    private TextField txtApellidoCliente;
    @FXML
    private TextField txtCedulaCliente;
    @FXML
    private TextField txtCodigoCliente;
    @FXML
    private TextField txtIdentificacionCliente;
    @FXML
    private TextField txtNombreCliente;
    @FXML
    private TextField txtTelefonoCliente;
    @FXML
    private TableView<Cliente> tableDatosCliente;
    @FXML
    private TableColumn<Cliente, String> columnaUnoCliente;
    @FXML
    private TableColumn<Cliente, String> columnaDosCliente;
    @FXML
    private TableColumn<Cliente, String> columnaTresCliente;
    @FXML
    private TableColumn<Cliente, String> columna4Cliente;
    @FXML
    private TableColumn<Cliente, String> columna5Cliente;
    @FXML
    private TableColumn<Cliente, String> columna6Cliente;

    //----------------------------------------pedidos-------------------------
    @FXML
    private Button btnRefrescar;
    @FXML
    private Label lblPedidos;
    @FXML
    private TextArea txtAreaC;
    @FXML
    private TextArea txtAreaP;
    @FXML
    private Label lblProductos;
    @FXML
    private Label lblCliente;
    @FXML
    private Label lblTotal;
    @FXML
    private Button btnLimpiar;
    //---------------------------------atributos fxml productos-----------------------------
    @FXML
    private Button btnListar;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField Buscador;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtNota2;
    @FXML
    private Label lblNota2;
    @FXML
    private TextField txtNota3;
    @FXML
    private Pane paneBotones;
    @FXML
    private Pane paneCampos;
    @FXML
    private Pane panePrincipal;
    @FXML
    private Pane paneTable;
    @FXML
    private TableView<Productos> tableDatos;
    @FXML
    private TableColumn<Productos, String> columnaUno;
    @FXML
    private TableColumn<Productos, String> columnaDos;
    @FXML
    private TableColumn<Productos, String> columnaTres;
    @FXML
    private TableColumn<Productos, String> columnaCuatro;
    @FXML
    private TableColumn<Productos, String> columnaCinco;
    @FXML
    private DatePicker fechaPedido;
    // -----------------------------atributos java producto---------------------------------------

    //se crean atributos para obtener campos de texto
    private String nombre = "";
    private String codigo = "";
    private float precio = 0;
    private float sumaTotal = 0;
    private String mensaje = "";
    //------------------------Atributos de tipo java cliente--------------
    private ArrayList<Cliente> listaClienta = new ArrayList<>();
    private ObservableList<Cliente> listaPrincipalCliente = FXCollections.observableArrayList();
    private Cliente clienteSeleccionado;
    private Productos productoSeleccionado;
    private ArrayList<Pedidos> listaPedidos = new ArrayList<>();

    //------------------------------------------------------AGREGAR-------------------------------------------------------------
    @FXML
    void agregar(ActionEvent event) throws IOException {

        //se guarda lo que se escribio en los txt
        nombre = txtNombre.getText();
        codigo = txtCodigo.getText();
        //se validan que todos los campos se hallan rellenado
        if (datosValidos()) {
            try {
                //se captura exception si  en el campo de valor ingresan letras
                precio = Float.parseFloat(txtPrecio.getText());


                // se verifica que el prodcuto no halla sido creado

                productos = new Productos(nombre, codigo, precio);
                listaProductos = Persistencia.cargarProductos();
                listaProductos.add(productos);
                listaPrincipal.clear();
                listaPrincipal.addAll(listaProductos);

                //se agrega la informaciona  la tabla
                columnaUno.setCellValueFactory(new PropertyValueFactory<Productos, String>("nombre"));
                columnaDos.setCellValueFactory(new PropertyValueFactory<Productos, String>("codigo"));
                columnaTres.setCellValueFactory(new PropertyValueFactory<Productos, String>("precio"));
                tableDatos.setItems(listaPrincipal);

                //se guarda en el txt
                Persistencia.guardarProdcutos(listaProductos);

                //se registra en el log que  se guardo un producto
                registrarAcciones("Producto agregado", 1, "Agregar Producto");
                mostrarMensaje("Crear Producto", "Producto creado", "El producto fue creado ", Alert.AlertType.CONFIRMATION);


                // se envian mesnajes y registro del log, del manejo de la exception
            } catch (NumberFormatException e) {
                mostrarMensaje("Datos invalidos", "campo valor", "no se pueden ingresar letras \nen el campo valor debe ingresar un valor numerico", Alert.AlertType.ERROR);
                registrarAcciones("Exception Producto campo numerico", 1, "En un campo llamado valor en la view de prodcuto se lanza exception por que ingresan letras y deben ser numeros");
            }
        }


    }

    @FXML
    void buscar(ActionEvent event) throws IOException {
        listaProductos = Persistencia.cargarProductos();
        boolean bandera = true;
        for (Productos e1 : listaProductos) {
            if (e1.getCodigo().equalsIgnoreCase(Buscador.getText())) {
                listaPrincipal.clear();
                listaPrincipal.addAll(e1);


                tableDatos.setItems(listaPrincipal);
                tableDatos.refresh();


                //se guarda en el txt
                Persistencia.guardarProdcutos(listaProductos);


                registrarAcciones(" Estudiante encontrado", 1, "se encontro el estudiantes buscado por el codigo");
                bandera = false;
                break;

            }

        }
        if (bandera == true) {
            registrarAcciones("No se encontro", 1, "No se encontro al usuario");
            mostrarMensaje("No se encontro", "No existe el estudiante", "no se encontro al estudiante", Alert.AlertType.WARNING);

        }


    }

    @FXML
    void listar(ActionEvent event) {
        try {
            //se carga en txt
            listaProductos = Persistencia.cargarProductos();
            listaPrincipal.clear();
            listaPrincipal.addAll(listaProductos);


            //se agrega la informaciona  la tabla
            columnaUno.setCellValueFactory(new PropertyValueFactory<Productos, String>("nombre"));
            columnaDos.setCellValueFactory(new PropertyValueFactory<Productos, String>("codigo"));
            columnaTres.setCellValueFactory(new PropertyValueFactory<Productos, String>("precio"));
            tableDatos.setItems(listaPrincipal);

            //se guarda en el txt
            Persistencia.guardarProdcutos(listaProductos);


            registrarAcciones("en listar productos", 1, "se carga la informacion del txt");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //--------------------------------------------------INITIALIZABLE----------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        panePrincipal.setDisable(true);
        panePrincipalCliente.setDisable(true);


        try {
            //se carga en txt
            listaProductos = Persistencia.cargarProductos();
            listaPrincipal.clear();
            listaPrincipal.addAll(listaProductos);


            //se agrega la informaciona  la tabla
            columnaUno.setCellValueFactory(new PropertyValueFactory<Productos, String>("nombre"));
            columnaDos.setCellValueFactory(new PropertyValueFactory<Productos, String>("codigo"));
            columnaTres.setCellValueFactory(new PropertyValueFactory<Productos, String>("precio"));
            tableDatos.setItems(listaPrincipal);

            //se guarda en el txt
            Persistencia.guardarProdcutos(listaProductos);


            registrarAcciones("Productos cargados", 1, "se carga la informacion del txt");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //cliente
        try {
            //se carga en txt
            listaClienta = Persistencia.cargarClientes();
            listaPrincipalCliente.clear();
            listaPrincipalCliente.addAll(listaClienta);


            //se agrega la informaciona  la tabla
            columnaUnoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
            columnaDosCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
            columnaTresCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tipoDeId"));
            columna4Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("nombre")));
            columna5Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("apellido")));
            columna6Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("telefono")));
            tableDatosCliente.setItems(listaPrincipalCliente);


            //se guarda en el txt
            Persistencia.guardarCientes(listaClienta);


            registrarAcciones("Productos cargados", 1, "se carga la informacion del txt");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //-------------------------cliente-------------------------------
    @FXML
    void guardarCliente(ActionEvent event) throws IOException {
        Cliente cliente = new Cliente(txtCodigoCliente.getText(), txtCedulaCliente.getText(), txtIdentificacionCliente.getText(), txtNombreCliente.getText(), txtApellidoCliente.getText(), txtTelefonoCliente.getText());
        listaClienta = Persistencia.cargarClientes();
        listaClienta.add(cliente);
        listaPrincipalCliente.clear();
        listaPrincipalCliente.addAll(listaClienta);
        columnaUnoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
        columnaDosCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
        columnaTresCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tipoDeId"));
        columna4Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("nombre")));
        columna5Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("apellido")));
        columna6Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("telefono")));
        tableDatosCliente.setItems(listaPrincipalCliente);
        Persistencia.guardarCientes(listaClienta);
        mostrarMensaje("cliente Creado", null, "el cliente fue creado ", Alert.AlertType.CONFIRMATION);

    }

    @FXML
    void listarCliente(ActionEvent event) {
        try {
            //se carga en txt
            listaClienta = Persistencia.cargarClientes();
            listaPrincipalCliente.clear();
            listaPrincipalCliente.addAll(listaClienta);
            columnaUnoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
            columnaDosCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cedula"));
            columnaTresCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tipoDeId"));
            columna4Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("nombre")));
            columna5Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("apellido")));
            columna6Cliente.setCellValueFactory((new PropertyValueFactory<Cliente, String>("telefono")));
            tableDatosCliente.setItems(listaPrincipalCliente);


            //se agrega la informaciona  la tabla


            //se guarda en el txt
            Persistencia.guardarCientes(listaClienta);


            registrarAcciones("en listar productos", 1, "se carga la informacion del txt");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void buscarCliente(ActionEvent event) throws IOException {
        listaClienta = Persistencia.cargarClientes();
        boolean bandera = true;
        for (Cliente c1 : listaClienta) {
            if (c1.getCodigo().equalsIgnoreCase(Buscador.getText())) {
                listaPrincipalCliente.clear();
                listaPrincipalCliente.addAll(c1);


                tableDatosCliente.setItems(listaPrincipalCliente);
                tableDatosCliente.refresh();


                //se guarda en el txt
                Persistencia.guardarCientes(listaClienta);


                registrarAcciones(" Estudiante encontrado", 1, "se encontro el estudiantes buscado por el codigo");
                bandera = false;
                break;

            }

        }
        if (bandera == true) {
            registrarAcciones("No se encontro", 1, "No se encontro al usuario");
            mostrarMensaje("No se encontro", "No existe el estudiante", "no se encontro al estudiante", Alert.AlertType.WARNING);
        }
    }

    //------------------------------------------------inicio sesion--------------------------------
    @FXML
    void entrar(ActionEvent event) {
        ArrayList<String> Usuarios = Persistencia.archivoPropiedades();
        boolean banderaU = false;
        boolean banderaP = false;

        for (String u : Usuarios) {
            if (u.equals(txtUsuario.getText())) {
                banderaU = true;
            }
            if (u.equals(txtPassword.getText())) {
                banderaP = true;
            }
            if (banderaP == true && banderaU == true) {
                panePrincipal.setDisable(false);
                paneLoggin.setDisable(true);
                panePrincipalCliente.setDisable(false);
                break;
            }
        }
    }


    //-----------------------------------------------log---------------------------------------------------------------

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
    //--------------------------------------------------Pedidos---------------------------

    @FXML
    void selecionar(MouseEvent event) {

        // se toomana los datos del producto seleccionado
        SelectionModel<Productos> selectionModel = tableDatos.getSelectionModel();
        productoSeleccionado = selectionModel.getSelectedItem();


        // Aquí guardamos la propiedades del producto seleccionado
        String nombreProducto = productoSeleccionado.getNombre();
        String codigo = productoSeleccionado.getCodigo();
        float valor = productoSeleccionado.getPrecio();
        sumaTotal += valor;
        mensaje += "nombre: " + nombreProducto + " codigo: " +codigo+ " valor" + valor + "\n";
    }

    @FXML
    void selecionarCliente(MouseEvent event) {
        SelectionModel<Cliente> selectionModel = tableDatosCliente.getSelectionModel();
        clienteSeleccionado = selectionModel.getSelectedItem();
        txtAreaC.setText(clienteSeleccionado.getNombre());
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtAreaP.setText("");
        txtAreaC.setText("");
        lblTotal.setText("");
        sumaTotal = 0;
    }

    @FXML
    void refrescar(ActionEvent event) {
        txtAreaP.setText(mensaje);
        Pedidos pedido = new Pedidos(fechaPedido.getValue(), clienteSeleccionado, productoSeleccionado, sumaTotal);
        if (Persistencia.cargarRecursoBancoXML() == null) {
            listaPedidos.add(pedido);
        } else {
            listaPedidos = Persistencia.cargarRecursoBancoXML();
            listaPedidos.add(pedido);
        }
        lblTotal.setText(sumaTotal + "");

        Persistencia.guardarRecursoBancoXML(listaPedidos);
        //imprio el vlor de cada pedido del xml que estan guardados
        for (Pedidos p1 : listaPedidos) {
            System.out.println(p1.getTotal());
        }
    }

    //------------------------------codigo reutilizable---------------------------------------
    //validar que no esten en campos nulls o vacios
    private boolean datosValidos() {
        String mensaje = "";
        if (txtNombre.getText() == null || txtNombre.getText().equals(""))
            mensaje += "El campo del nombre debe rellnarlo  \n";
        if (txtCodigo.getText() == null || txtCodigo.getText().equals(""))
            mensaje += "El campo de la descripcion debe rellenarlo \n";
        if (txtPrecio.getText() == null || txtPrecio.getText().equals(""))
            mensaje += "El campo de url debe rellenarlo \n";

        if (mensaje.equals("")) {
            return true;
        } else {
            mostrarMensaje("Notificación cliente", "Datos invalidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    //enviamos un mensaje
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}