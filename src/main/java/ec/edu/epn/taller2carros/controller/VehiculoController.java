package ec.edu.epn.taller2carros.controller;

import ec.edu.epn.taller2carros.db.ConexionMongo;
import ec.edu.epn.taller2carros.model.Vehiculo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class VehiculoController {

    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtPrecio;

    @FXML
    public void guardarDatos(ActionEvent event) {
        try {
            String codigo = txtCodigo.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            Vehiculo vehiculo = new Vehiculo(codigo, marca, modelo, precio);

            Thread hiloMongo = new Thread(() -> {
                ConexionMongo db = new ConexionMongo();

                db.guardarVehiculo(vehiculo);

                Vehiculo vehiculoRecuperado = db.buscarPorCodigo(vehiculo.getCodigo());

                Platform.runLater(() -> {
                    if (vehiculoRecuperado != null) {
                        String detalle = String.format(
                                "Los siguientes datos fueron registrados y recuperados de la nube:\n\n" +
                                        "Código:\t %s\n" +
                                        "Marca:\t %s\n" +
                                        "Modelo:\t %s\n" +
                                        "Precio:\t $ %.2f",
                                vehiculoRecuperado.getCodigo(),
                                vehiculoRecuperado.getMarca(),
                                vehiculoRecuperado.getModelo(),
                                vehiculoRecuperado.getPrecio()
                        );
                        mostrarAlerta("Vehículo Registrado Exitosamente", detalle);
                    } else {
                        mostrarAlerta("Aviso", "El vehículo se guardó, pero hubo un error al recuperarlo.");
                    }
                    limpiarCampos();
                });
            });

            hiloMongo.setName("Hilo-BD-ESFOTCAR");
            hiloMongo.start();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio debe ser un número válido.");
        }
    }


    private void limpiarCampos() {
        txtCodigo.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtPrecio.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}