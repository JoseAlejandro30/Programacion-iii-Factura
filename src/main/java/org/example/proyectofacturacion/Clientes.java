package org.example.proyectofacturacion;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
@NoArgsConstructor
@Getter
@Setter
public class Clientes implements Initializable {
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
        btnIngresar.setOnAction(e -> {
            try {
                Ingresar(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btnActualizar.setOnAction(e -> actualizar());
    }


    public void Ingresar(ActionEvent event) throws IOException {
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDirecccion.getText();
        String email = txtEmail.getText();


        if (id.trim().isEmpty()) {
            System.out.println("EL ID NO PUEDE ESTAR VACIO");
            txtID.requestFocus();
            return;
        }
        if (nombre.trim().isEmpty()) {
            System.out.println("EL NOMBRE NO PUEDE ESTAR VACIO");
            txtNombre.requestFocus();
            return;
        }
        if (direccion.trim().isEmpty()) {
            System.out.println("LA DIRECCIÓN NO PUEDE ESTAR VACÍA");
            txtDirecccion.requestFocus();
            return;
        }
        if (email.trim().isEmpty()) {
            System.out.println("EL EMAIL NO PUEDE ESTAR VACÍO");
            txtEmail.requestFocus();
            return;
        }


        try {
            System.out.println("=== INGRESANDO CLIENTE ===");
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Dirección: " + direccion);
            System.out.println("Email: " + email);
            System.out.println("Cliente ingresado exitosamente!");


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(Productos.createScene());
            stage.setTitle("Captura de Productos");


            Limpiar();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cambiar de vista: " + e.getMessage());
        }
    }

    public void actualizar() {
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
        Limpiar();
    }

    private void Limpiar() {
        txtID.clear();
        txtNombre.clear();
        txtDirecccion.clear();
        txtEmail.clear();
    }

    public void cargarCliente(String id, String nombre, String direccion, String email) {
        txtID.setText(id);
        txtNombre.setText(nombre);
        txtDirecccion.setText(direccion);
        txtEmail.setText(email);
    }
}





