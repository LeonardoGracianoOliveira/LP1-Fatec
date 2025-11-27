package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    public boolean create(Alien a) {
        String sql = "INSERT INTO alien (nome, raca, dna) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, a.getNome());
            ps.setString(2, a.getRaca());
            ps.setInt(3, a.getDna());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro inserir Alien: " + e.getMessage());
            return false;
        }
    }

    public List<Alien> readAll() {
        List<Alien> list = new ArrayList<>();
        String sql = "SELECT nome, raca, dna FROM alien";
        try (Statement st = Database.getConn().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Alien(rs.getString("raca"), rs.getString("nome"), rs.getInt("dna")));
            }
        } catch (SQLException e) {
            System.err.println("Erro listar Aliens: " + e.getMessage());
        }
        return list;
    }

    public boolean update(Alien a) {
        String sql = "UPDATE alien SET raca = ?, dna = ? WHERE nome = ?";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, a.getRaca());
            ps.setInt(2, a.getDna());
            ps.setString(3, a.getNome());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro atualizar Alien: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteByName(String nome) {
        String sql = "DELETE FROM alien WHERE nome = ?";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, nome);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro deletar Alien: " + e.getMessage());
            return false;
        }
    }
}