package com.example.kursah_v2_0;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Err_label;

    @FXML
    private Button enter_but;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    int count=0;

    @FXML
    void initialize() {
        enter_but.setOnAction(event -> {
            Err_label.setText("");
            String login = login_field.getText().trim();
            int hashLogin = login.hashCode();
            String pass = pass_field.getText().trim();
            int hashPass = pass.hashCode();
                if (hashLogin!=3506402 || hashPass!=3506402)
                    Err_label.setText(Err_label.getText() + "Введен неверный логин или пароль!");
                 else {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("AddDelBus.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Parent root = loader.getRoot();
                    Main.mainStage.setScene(new Scene(root));
                }
        });
    }
}
