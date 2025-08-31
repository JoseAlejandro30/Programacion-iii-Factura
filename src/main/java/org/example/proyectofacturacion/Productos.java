package org.example.proyectofacturacion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

@NoArgsConstructor
@Setter
@Getter
public class Productos implements Initializable {
    private String Id;
    private String Nombre;
    private int Cantidad;
    private double Precio;
    @FXML
    private Label lblid;
    @FXML private Label lblAmount;
    @FXML private TextField txtid;
    @FXML private TextField txtNameProduct;
    @FXML private TextField txtPriceProduct;
    @FXML private TextField txtAmount;
    @FXML private Button btnSave;
    @FXML private Button btnUpdate;
    private static ArrayList<Productos> productos=new ArrayList<Productos>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (btnSave !=  null){
            btnSave.setOnAction(e -> Guardar());
        }else{
            System.out.println("NO SE PUEDE GUARDAR");
        }
        if (btnUpdate !=null) {
            btnUpdate.setOnAction(e-> Actualizar());
        }else{
            System.out.println("NO SE PUEDE ACTUALIZAR");
        }

    }

    public static Scene createScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Productos.class.getResource("Productos-view.fxml"));
        return new Scene(loader.load(), 800, 600);
    }


    public void Guardar(){
        String id = txtid.getText();
        String name = txtNameProduct.getText();
        String amounttxt = txtAmount.getText();
        String PriceProducttxt = txtPriceProduct.getText();

        if (id.trim().isEmpty()) {
            System.out.println("EL ID NO PUEDE ESTAR VACIO");
            txtid.requestFocus();
            return;
        }
        if (name.trim().isEmpty()) {
            System.out.println("EL NOMBRE NO PUEDE ESTAR VACIO");
            txtNameProduct.requestFocus();
            return;
        }
        if (amounttxt.trim().isEmpty()) {
            System.out.println("LA CANTIDAD NO PUEDE ESTAR VACÍA");
            txtAmount.requestFocus();
            return;
        }
        if (PriceProducttxt.trim().isEmpty()) {
            System.out.println("EL PRECIO NO PUEDE ESTAR VACÍO");
            txtPriceProduct.requestFocus();
            return;
        }
        try{
            int amount = Integer.parseInt(txtAmount.getText().trim());
            double PriceProduct = Double.parseDouble(txtPriceProduct.getText().trim());
            if (amount < 0) {
                System.out.println("Porfavor digite un Valor positivo");
                return;
            }
            if (PriceProduct < 0){
                System.out.println("Digite el Valor Correcto del Producto");
                return;
            }
            Productos NewOrder = createProducto(id.trim(), name.trim() , amount , PriceProduct);
            productos.add(NewOrder);
            System.out.println("Producto guardado exitosamente");
            Clean();
        }catch(NumberFormatException e){
            System.out.println("ERROR : NUMEROS INVALIDOS");
        }
    }

    public void Actualizar (){
        if (productos.isEmpty()) {
            System.out.println(" No hay productos para mostrar");
        } else {
            System.out.println("Productos actuales (" + productos.size() + " productos):");
            StringBuilder listado = new StringBuilder();
            listado.append("Productos registrados (").append(productos.size()).append(" productos):\n\n");
            for (int i = 0; i < productos.size(); i++) {
                Productos p = productos.get(i);
                System.out.println("   " + (i+1) + ". ID: " + p.getId() +
                        ", Nombre: " + p.getNombre() +
                        ", Cantidad: " + p.getCantidad() +
                        ", Precio: $" + p.getPrecio());
                listado.append(p).append("\n\n");
            }
        }

        Clean();
    }
    private void Clean(){
        txtid.clear();
        txtNameProduct.clear();
        txtPriceProduct.clear();
        txtAmount.clear();
        txtid.requestFocus();
    }

    public static Productos createProducto(String id, String nombre, int cantidad, double precio) {
        Productos producto = new Productos();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);
        return producto;
    }
    public static ArrayList<Productos> getProductos() {
        return productos;
    }
}
