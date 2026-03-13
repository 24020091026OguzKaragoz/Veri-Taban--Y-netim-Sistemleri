package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen {

    @FXML
    private void openStudentScreen() throws IOException {
        openNewWindow("student-operations.fxml", "Öğrenci İşlemleri");
    }

    @FXML
    private void openAdminScreen() throws IOException {
        openNewWindow("admin-operations.fxml", "Yönetim İşlemleri");
    }

    private void openNewWindow(String fxmlFile, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}