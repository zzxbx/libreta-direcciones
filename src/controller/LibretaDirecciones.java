/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LibretaDirecciones extends Application {
    
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaPersona;
    
    @Override
    public void start(Stage escenarioPrincipal) {
        
        //Debo hacerlo para que luego me funcione en l carga de escenas
        this.escenarioPrincipal = escenarioPrincipal;
        
        //Establezco el título
        this.escenarioPrincipal.setTitle("Libreta de direcciones");
        
        //Inicializo el layout principal
        initLayoutPrincipal();
        
        //Muestro la vista persona
        muestraVistaPersona();
    }
    
    public void initLayoutPrincipal(){
        
        //Cargo el layout principal a partir de la vista VistaPrincipal.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDirecciones.class.getResource("../view/VistaPrincipal.fxml");
        loader.setLocation(location);
        try {
            layoutPrincipal = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LibretaDirecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Cargo y muestro la escena que contiene ese layout principal
        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
        
    }
    
    public void muestraVistaPersona(){
        
        //Cargo la vista persona a partir de VistaPersona.fxml
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDirecciones.class.getResource("../view/VistaPersona.fxml");
        loader.setLocation(location);
        try {
            vistaPersona = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LibretaDirecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Añado la vista al centro del layoutPrincipal
        layoutPrincipal.setCenter(vistaPersona);
        
    }
    
    //Invoco el método getPrimaryStage para que devuelva mi escenario principal
    public Stage getPrimaryStage() {
        return escenarioPrincipal;
    }

    //Método main
    public static void main(String[] args) {
        launch(args);
    }
    
}
