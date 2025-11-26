package dao;

import database.Database;
import model.Relogio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RelogioDao implements GenericDao<Relogio> {
    @Override
    public List<Relogio> findAll() throws Exception {
        String sql = "SELECT * FROM relogio";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Relogio> list = new ArrayList<>();
            while (rs.next()) {
                Relogio r = new Relogio(rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("versao"));
                list.add(r);
            }
            return list;
        }
    }

    @Override
    public Optional<Relogio> findById(int id) throws Exception {
        String sql = "SELECT * FROM relogio WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Relogio r = new Relogio(rs.getInt("id"),
                            rs.getString("modelo"),
                            rs.getString("cor"),
                            rs.getInt("versao"));
                    return Optional.of(r);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean create(Relogio obj) throws Exception {
        String sql = "INSERT INTO relogio (modelo, cor, versao) VALUES (?, ?, ?)";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getModelo());
            ps.setString(2, obj.getCor());
            ps.setInt(3, obj.getVersao());
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
    public boolean update(Relogio obj) throws Exception {
        String sql = "UPDATE relogio SET modelo=?, cor=?, versao=? WHERE id=?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, obj.getModelo());
            ps.setString(2, obj.getCor());
            ps.setInt(3, obj.getVersao());
            ps.setInt(4, obj.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM relogio WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
