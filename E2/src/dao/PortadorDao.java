package dao;

import database.Database;
import model.Portador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PortadorDao implements GenericDao<Portador> {
    @Override
    public List<Portador> findAll() throws Exception {
        String sql = "SELECT * FROM portador";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Portador> list = new ArrayList<>();
            while (rs.next()) {
                Portador p = new Portador(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("aparencia"),
                        rs.getInt("idade"));
                list.add(p);
            }
            return list;
        }
    }

    @Override
    public Optional<Portador> findById(int id) throws Exception {
        String sql = "SELECT * FROM portador WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Portador p = new Portador(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("aparencia"),
                            rs.getInt("idade"));
                    return Optional.of(p);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean create(Portador obj) throws Exception {
        String sql = "INSERT INTO portador (nome, aparencia, idade) VALUES (?, ?, ?)";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getAparencia());
            ps.setInt(3, obj.getIdade());
            int affected = ps.executeUpdate();
            if (affected > 0) {
                try (ResultSet gk = ps.getGeneratedKeys()) {
                    if (gk.next()) obj.setId(gk.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Portador obj) throws Exception {
        String sql = "UPDATE portador SET nome=?, aparencia=?, idade=? WHERE id=?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getAparencia());
            ps.setInt(3, obj.getIdade());
            ps.setInt(4, obj.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM portador WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
