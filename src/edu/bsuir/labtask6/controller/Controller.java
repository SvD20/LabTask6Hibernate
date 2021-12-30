package edu.bsuir.labtask6.controller;


import edu.bsuir.labtask6.entities.Medication;
import edu.bsuir.labtask6.workingwithMySQL.CRUDmaker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class Controller {

    private CRUDmaker cruDmaker = new CRUDmaker();
    private List<Medication> medications = null;

    @FXML
    private TextField country_field;

    @FXML
    private Button create_button;

    @FXML
    private Button delete_button;

    @FXML
    private TextField manufacturer_field;

    @FXML
    private TextField price_field;

    @FXML
    private TextField purpose_field;

    @FXML
    private Button read_button;

    @FXML
    private TextArea tipps_textarea;

    @FXML
    private TextField title_field;

    @FXML
    private Button update_button;

    @FXML
    private TextArea view_textarea;

    @FXML
    private Button close_button;

    public void initialize(){

        create_button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            cruDmaker.create(title_field.getText(),manufacturer_field.getText(),country_field.getText(),purpose_field.getText(),Integer.parseInt(price_field.getText()));
        });

        read_button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            medications = cruDmaker.read(purpose_field.getText());
            StringBuilder stringBuilder = new StringBuilder();
            for(Medication e: medications){
                stringBuilder.append(e.toString() + " ");
            }
            view_textarea.setText(String.valueOf(stringBuilder));
        });

        update_button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            cruDmaker.update(title_field.getText(),Integer.parseInt(price_field.getText()));
        });

        delete_button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            cruDmaker.delete(title_field.getText(),manufacturer_field.getText());
        });

        close_button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            cruDmaker.factoryClose();
        });

    }


}

