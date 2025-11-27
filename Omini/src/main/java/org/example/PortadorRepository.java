package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PortadorRepository {

    public boolean create(Portador p) {
        String sql = "INSERT INTO portador (nome, descricao, idade) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setInt(3, p.getIdade());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro inserir Portador: " + e.getMessage());
            return false;
        }
    }

    public List<Portador> readAll() {
        List<Portador> list = new ArrayList<>();
        String sql = "SELECT nome, descricao, idade FROM portador";
        try (Statement st = Database.getConn().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Portador(rs.getString("nome"), rs.getString("descricao"), rs.getInt("idade")));
            }
        } catch (SQLException e) {
            System.err.println("Erro listar Portadores: " + e.getMessage());
        }
        return list;
    }

    public boolean update(Portador p) {
        String sql = "UPDATE portador SET descricao = ?, idade = ? WHERE nome = ?";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, p.getDescricao());
            ps.setInt(2, p.getIdade());
            ps.setString(3, p.getNome());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro atualizar Portador: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteByName(String nome) {
        String sql = "DELETE FROM portador WHERE nome = ?";
        try (PreparedStatement ps = Database.getConn().prepareStatement(sql)) {
            ps.setString(1, nome);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro deletar Portador: " + e.getMessage());
            return false;
        }
    }
}