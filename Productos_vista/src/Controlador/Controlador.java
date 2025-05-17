/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Productos;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Frank
 */
public class Controlador implements Initializable {
    
    @FXML
    private TextField TXT_Nombre;
    @FXML
    private TextField TXT_Cantidad;
    @FXML
    private TextField TXT_Ubicacion;
    @FXML
    private TableView<Productos> Muestra_Datos;
    @FXML
    private TableColumn<?, ?> Columna_ID;
    @FXML
    private TableColumn<?, ?> Columna_Nombre;
    @FXML
    private TableColumn<?, ?> Columna_Cantidad;
    @FXML
    private TableColumn<?, ?> Columna_Ubicacion;
    private ObservableList<Productos> lista_productos;
    private Integer id_Productos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }    
    
    public void limpiar(){
    TXT_Nombre.setText("");
    TXT_Ubicacion.setText("");
    TXT_Cantidad.setText("");
    }
    
    public void mostrar(){
        lista_productos=FXCollections.observableArrayList();
        for(Iterator it = CRUDS.CRUDS_Productos.universo().iterator(); it.hasNext();){
            Object[] item = (Object[]) it.next();
            lista_productos.add(new Productos(
                    (Integer) item[0],
                    (String) item[1],
                    (Integer) item[2],
                    (String) item[3]
            ));
        }
        
        this.Columna_ID.setCellValueFactory(new PropertyValueFactory("idProductos56"));
        this.Columna_Nombre.setCellValueFactory(new PropertyValueFactory("nombre56"));
        this.Columna_Cantidad.setCellValueFactory(new PropertyValueFactory("cantidad56"));
        this.Columna_Ubicacion.setCellValueFactory(new PropertyValueFactory("ubicacion56"));
        
            Muestra_Datos.setItems(lista_productos);
    }
    
    @FXML
    private void Selecionar_Datos(MouseEvent event) {
        Productos p=this.Muestra_Datos.getSelectionModel().getSelectedItem();
        id_Productos=p.getIdProductos56();
        TXT_Nombre.setText(p.getNombre56()+"");
        TXT_Cantidad.setText(p.getCantidad56()+"");
        TXT_Ubicacion.setText(p.getUbicacion56()+"");
    }
    
    @FXML
    public void insertar(){
        try{
        String Nombre, Ubicacion;
        int Cantidad;
        Nombre= TXT_Nombre.getText();
        Cantidad=Integer.parseInt(TXT_Cantidad.getText());
        Ubicacion=TXT_Ubicacion.getText();
        if(CRUDS.CRUDS_Productos.insertar(Nombre, Cantidad, Ubicacion)){
            limpiar();
            mostrar();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Ingresado");
            
            alerta.showAndWait();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Ingresado");
            
            alerta.showAndWait();
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
            }
    }
    
    @FXML
    public void modificar(){
        try{
        String Nombre, Ubicacion;
        int Cantidad;
        Nombre= TXT_Nombre.getText();
        Cantidad=Integer.parseInt(TXT_Cantidad.getText());
        Ubicacion=TXT_Ubicacion.getText();
        if(CRUDS.CRUDS_Productos.modificar(id_Productos, Nombre, Cantidad, Ubicacion)){
            mostrar();
            limpiar();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Modificado");
            
            alerta.showAndWait();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Ingresado");
            
            alerta.showAndWait();
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
            }
    }
    
    @FXML
    public void eliminar(){
        try{
        if(CRUDS.CRUDS_Productos.eliminar(id_Productos)){
            mostrar();
            limpiar();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro Eliminado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Registro no Eliminado");
            
            alerta.showAndWait();
            //Muestra una alerta que los datos fueron ingresados
        }
            }catch(Exception e){
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Revise sus datos: "+e);

                    alerta.showAndWait();
                    //Muestra una alerta que los datos fueron ingresados
            }
    }

    /**
     * @return the id_Productos
     */
    public Integer getId_Productos() {
        return id_Productos;
    }

    /**
     * @param id_Productos the id_Productos to set
     */
    public void setId_Productos(Integer id_Productos) {
        this.id_Productos = id_Productos;
    }
}
