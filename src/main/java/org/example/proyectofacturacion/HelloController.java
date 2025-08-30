package org.example.proyectofacturacion;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private Label lblID;
    @FXML private Label lblNombre;
    @FXML private Label lblDirecccion;
    @FXML private Label lblEmail;
    @FXML private TextField txtID;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDirecccion;
    @FXML private TextField txtEmail;
    @FXML private Button btnIngresar;
    @FXML private Button btnActualizar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnIngresar.setOnAction(e-> Ingresar());
        btnActualizar.setOnAction(e -> actualizar());
    }

    public void Ingresar(){
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDirecccion.getText();
        String email = txtEmail.getText();

        if (id.trim().isEmpty()){
            System.out.println("EL ID NO PUEDE ESTAR VACIO");
            txtID.requestFocus();
            return;
        }
        if (nombre.trim().isEmpty()){
            System.out.println("EL NOMBRE NO PUEDE ESTAR VACIO");
            txtNombre.requestFocus();
            return;
        }
        if (direccion.trim().isEmpty()){
            System.out.println("EL ID NO PUEDE ESTAR VACIO");
            txtDirecccion.requestFocus();
            return;
        }
        if (email.trim().isEmpty()){
            System.out.println("EL ID NO PUEDE ESTAR VACIO");
            txtEmail.requestFocus();
            return;
        }
        System.out.println("=== INGRESANDO CLIENTE ===");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Email: " + email);
        System.out.println("Cliente ingresado exitosamente!");

        Limpiar();
    }
    public void actualizar (){
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDirecccion.getText();
        String email = txtEmail.getText();

        System.out.println("=== Datos Actualizados del Cliente ===");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Email: " + email);
        System.out.println("Cliente actualizado exitosamente!");
    }
    private void Limpiar(){
        txtID.clear();
        txtNombre.clear();
        txtDirecccion.clear();
        txtEmail.clear();
    }
    public void cargarCliente(String id , String nombre , String direccion , String email){
        lblID.setText(id);
        lblNombre.setText(nombre);
        lblDirecccion.setText(direccion);
        lblEmail.setText(email);
    }

}





