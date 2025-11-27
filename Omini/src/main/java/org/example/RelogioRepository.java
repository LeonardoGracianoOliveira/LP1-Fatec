package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelogioRepository {

    public boolean create(Relogio r) {
        String sql = "INSERT INTO relogio (nome, cor, versao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, r.getNome());
            ps.setString(2, r.getCor());
            ps.setInt(3, r.getVersao());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro inserir Relogio: " + e.getMessage());
            return false;
        }
    }

    public List<Relogio> readAll() {
        List<Relogio> list = new ArrayList<>();
        String sql = "SELECT nome, cor, versao FROM relogio";
        try (Statement st = Database.getConn().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Relogio(rs.getString("cor"), rs.getString("nome"), rs.getInt("versao")));
            }
        } catch (SQLException e) {
            System.err.println("Erro listar Relogios: " + e.getMessage());
        }
        return list;
    }

    public boolean update(Relogio r) {
        String sql = "UPDATE relogio SET cor = ?, versao = ? WHERE nome = ?";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, r.getCor());
            ps.setInt(2, r.getVersao());
            ps.setString(3, r.getNome());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro atualizar Relogio: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteByName(String nome) {
        String sql = "DELETE FROM relogio WHERE nome = ?";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, nome);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro deletar Relogio: " + e.getMessage());
            return false;
        }
    }
}