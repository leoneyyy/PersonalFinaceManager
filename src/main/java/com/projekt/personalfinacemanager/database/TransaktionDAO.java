package com.projekt.personalfinacemanager.database;

import com.projekt.personalfinacemanager.model.Transaktion;

import java.sql.*;
import java.util.ArrayList;

public class TransaktionDAO {

    public void speicherTransaktion(Transaktion t) {
        String sql = "INSERT INTO Transaktion (betrag, kategorie, datum, typ) VALUES (?, ?, ?, ?)";


        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, t.getBetrag());
            pstmt.setString(2, t.getKategorie());
            pstmt.setDate(3, Date.valueOf(t.getDatum()));
            pstmt.setString(4, t.getTyp());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Transaktion> zeigeTransaktionen() {
        String sql = "SELECT * FROM Transaktion;";
        ArrayList<Transaktion> alle = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                java.math.BigDecimal betrag = rs.getBigDecimal("betrag");
                String kategorie = rs.getString("kategorie");
                java.time.LocalDate datum = rs.getDate("datum").toLocalDate();
                String typ = rs.getString("typ");
                alle.add(new Transaktion(betrag, kategorie, datum, typ, id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alle;
    }

    public void loescheAlleTransaktionen() {
        String sql = "DELETE FROM Transaktion;";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
