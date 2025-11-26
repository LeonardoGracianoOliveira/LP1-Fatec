package dao;

import database.Database;
import model.Alien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlienDao implements GenericDao<Alien> {
    @Override
    public List<Alien> findAll() throws Exception {
        String sql = "SELECT * FROM alien";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Alien> list = new ArrayList<>();
            while (rs.next()) {
                Alien a = new Alien(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("planetaDeOrigem"),
                        rs.getInt("dna"));
                list.add(a);
            }
            return list;
        }
    }

    @Override
    public Optional<Alien> findById(int id) throws Exception {
        String sql = "SELECT * FROM alien WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Alien a = new Alien(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("planetaDeOrigem"),
                            rs.getInt("dna"));
                    return Optional.of(a);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean create(Alien obj) throws Exception {
        String sql = "INSERT INTO alien (nome, planetaDeOrigem, dna) VALUES (?, ?, ?)";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getPlanetaDeOrigem());
            ps.setInt(3, obj.getDna());
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
    public boolean update(Alien obj) throws Exception {
        String sql = "UPDATE alien SET nome=?, planetaDeOrigem=?, dna=? WHERE id=?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getPlanetaDeOrigem());
            ps.setInt(3, obj.getDna());
            ps.setInt(4, obj.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM alien WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
