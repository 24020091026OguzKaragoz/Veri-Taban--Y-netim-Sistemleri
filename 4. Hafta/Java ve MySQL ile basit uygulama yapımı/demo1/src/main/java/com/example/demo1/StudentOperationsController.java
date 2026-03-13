package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentOperationsController {

    @FXML
    private TextField tcNoField;
    @FXML
    private TextField ogrenciAdiField;
    @FXML
    private TextField ogrenciTelefonuField;
    @FXML
    private ComboBox<String> cinsiyetComboBox;
    @FXML
    private ComboBox<String> bolumComboBox;
    @FXML
    private TableView<Ogrenci> ogrenciTableView;
    @FXML
    private TableColumn<Ogrenci, String> tcNoCol;
    @FXML
    private TableColumn<Ogrenci, String> adCol;
    @FXML
    private TableColumn<Ogrenci, String> telefonCol;
    @FXML
    private TableColumn<Ogrenci, String> cinsiyetCol;
    @FXML
    private TableColumn<Ogrenci, String> bolumCol;


    private final ObservableList<Ogrenci> ogrenciList = FXCollections.observableArrayList();
    private final ObservableList<String> bolumList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        cinsiyetComboBox.setItems(FXCollections.observableArrayList("Erkek", "Kadın"));
        bolumComboBox.setItems(bolumList);
        loadBolumler();

        tcNoCol.setCellValueFactory(new PropertyValueFactory<>("tcNo"));
        adCol.setCellValueFactory(new PropertyValueFactory<>("ad"));
        telefonCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        cinsiyetCol.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
        bolumCol.setCellValueFactory(new PropertyValueFactory<>("bolum"));

        ogrenciTableView.setItems(ogrenciList);
    }

    private void loadBolumler() {
        String sql = "SELECT bolum_adi FROM Bolumler";
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
    private void ogrencileriGoster() {
        ogrenciList.clear();
        String sql = "SELECT * FROM Ogrenciler";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ogrenciList.add(new Ogrenci(
                        rs.getString("tc_no"),
                        rs.getString("ogrenci_adi"),
                        rs.getString("ogrenci_telefonu"),
                        rs.getString("cinsiyet"),
                        rs.getString("bolum_adi")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ogrenciEkle() {
        String sql = "INSERT INTO Ogrenciler(tc_no, ogrenci_adi, ogrenci_telefonu, cinsiyet, bolum_adi) VALUES(?,?,?,?,?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tcNoField.getText());
            pstmt.setString(2, ogrenciAdiField.getText());
            pstmt.setString(3, ogrenciTelefonuField.getText());
            pstmt.setString(4, cinsiyetComboBox.getValue());
            pstmt.setString(5, bolumComboBox.getValue());
            pstmt.executeUpdate();
            ogrencileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void seciliOgrenciyiGuncelle() {
        Ogrenci selectedOgrenci = ogrenciTableView.getSelectionModel().getSelectedItem();
        if (selectedOgrenci == null) return;

        String sql = "UPDATE Ogrenciler SET ogrenci_adi = ?, ogrenci_telefonu = ?, cinsiyet = ?, bolum_adi = ? WHERE tc_no = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ogrenciAdiField.getText());
            pstmt.setString(2, ogrenciTelefonuField.getText());
            pstmt.setString(3, cinsiyetComboBox.getValue());
            pstmt.setString(4, bolumComboBox.getValue());
            pstmt.setString(5, selectedOgrenci.getTcNo());
            pstmt.executeUpdate();
            ogrencileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void seciliOgrenciyiSil() {
        Ogrenci selectedOgrenci = ogrenciTableView.getSelectionModel().getSelectedItem();
        if (selectedOgrenci == null) return;

        String sql = "DELETE FROM Ogrenciler WHERE tc_no = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, selectedOgrenci.getTcNo());
            pstmt.executeUpdate();
            ogrencileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}