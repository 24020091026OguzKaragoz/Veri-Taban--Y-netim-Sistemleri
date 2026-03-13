package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminOperationsController {

    @FXML
    private TextField bolumAdiField;
    @FXML
    private TextField bolumAdresiField;
    @FXML
    private TextField bolumTelefonuField;
    @FXML
    private ListView<String> bolumListView;

    private final ObservableList<String> bolumList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        bolumListView.setItems(bolumList);
    }

    @FXML
    private void verileriGoster() {
        bolumList.clear();
        String sql = "SELECT * FROM Bolumler";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                bolumList.add(rs.getString("bolum_adi"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void bolumEkle() {
        String sql = "INSERT INTO Bolumler(bolum_adi, bolum_adresi, bolum_telefonu) VALUES(?,?,?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bolumAdiField.getText());
            pstmt.setString(2, bolumAdresiField.getText());
            pstmt.setString(3, bolumTelefonuField.getText());
            pstmt.executeUpdate();
            verileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void seciliBolumuGuncelle() {
        String selectedBolum = bolumListView.getSelectionModel().getSelectedItem();
        if (selectedBolum == null) return;

        String sql = "UPDATE Bolumler SET bolum_adresi = ?, bolum_telefonu = ? WHERE bolum_adi = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bolumAdresiField.getText());
            pstmt.setString(2, bolumTelefonuField.getText());
            pstmt.setString(3, selectedBolum);
            pstmt.executeUpdate();
            verileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void seciliBolumuSil() {
        String selectedBolum = bolumListView.getSelectionModel().getSelectedItem();
        if (selectedBolum == null) return;

        String sql = "DELETE FROM Bolumler WHERE bolum_adi = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, selectedBolum);
            pstmt.executeUpdate();
            verileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}