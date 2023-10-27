package com.example.preparcial.utils;

/*import co.edu.uniquindio.banco.bancouq.exceptions.UsuarioExcepcion;
import co.edu.uniquindio.banco.bancouq.model.*;*/

import com.example.preparcial.model.Cliente;
import com.example.preparcial.model.Pedidos;
import com.example.preparcial.model.Productos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Persistencia {



//--------------------------------------RUTAS----------------------------------------
    public static final String RUTA_ARCHIVO_ESTUDIANTES = "C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\estudiantes";

    public static final String RUTA_ARCHIVO_LOG ="C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\log";

    public static final String RUTA_ARCHICO_CLIENTE ="C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\clientes";



    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
//-------------------------------------------GUARDAR ARCHIVOS------------------------------
    public static void guardarProdcutos(ArrayList<Productos> listaClientes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Productos productos:listaClientes)
        {
            contenido+= productos.getNombre()+"--"+productos.getCodigo()+"--"+productos.getPrecio()+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
    }
    public static void guardarCientes(ArrayList<Cliente> listaClientes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Cliente cliente:listaClientes)

        {
            contenido+= cliente.getCodigo()+"--"+cliente.getCedula()+"--"+cliente.getTipoDeId()+"--"+cliente.getNombre()+"--"+cliente.getApellido()+"--"+cliente.getTelefono()+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHICO_CLIENTE, contenido, false);
    }




//	----------------------CARGAR ARCHIVOS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> archivoPropiedades() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("modalidades", new Locale("", ""));
        ArrayList<String>modalidades=new ArrayList<>();
        modalidades.add(resourceBundle.getString("usuario"));
        modalidades.add(resourceBundle.getString("password"));
        return modalidades;
    }
    public static ArrayList<Productos> cargarProductos() throws FileNotFoundException, IOException
    {
        ArrayList<Productos> productos =new ArrayList<Productos>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Productos producto = new Productos();
            producto.setNombre(linea.split("--")[0]);
            producto.setCodigo(linea.split("--")[1]);
            producto.setPrecio(Float.parseFloat(linea.split("--")[2]));
            productos.add(producto);
        }
        return productos;
    }
    public static ArrayList<Cliente>cargarClientes() throws FileNotFoundException, IOException
    {
        ArrayList<Cliente> clientes =new ArrayList<Cliente>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHICO_CLIENTE);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {

                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454ClienteproducCliente();
            Cliente cliente=new Cliente();
            cliente.setCodigo(linea.split("--")[0]);
            cliente.setCedula(linea.split("--")[1]);
            cliente.setTipoDeId(linea.split("--")[2]);
            cliente.setNombre(linea.split("--")[3]);
            cliente.setApellido(linea.split("--")[4]);
            cliente.setTelefono(linea.split("--")[5]);
            clientes.add(cliente);
        }
        return clientes;
    }

    //------------------------------REGISTRO LOG-----------------------------------------
    public static void guardaRegistroLog(String mensaje, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLog(mensaje, nivel, accion, RUTA_ARCHIVO_LOG);
    }
    //----------------------archivosXml--------------------------
    public static void guardarRecursoBancoXML(ArrayList<Pedidos> LISTADEPROGAMAS) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML("C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\pedidos.xml", LISTADEPROGAMAS);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
    public static ArrayList<Pedidos> cargarRecursoBancoXML() {
        ArrayList<Pedidos> lista = null;

        try {
            lista = (ArrayList)ArchivoUtil.cargarRecursoSerializadoXML("C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\pedidos.xml");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return lista;
    }













}
