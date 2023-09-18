package repository.db.impl;

import domain.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import repository.DBRepository;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.DatabaseFactoryRepository;

public class RepositoryDBGeneric implements DBRepository<GenericEntity> {

    @Override
    public List<GenericEntity> get(GenericEntity entity) {
        List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(entity.getSelectValues());
            String query = sb.toString();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                entities.add(entity.getNewObject(rs));
            }
            return entities;
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public GenericEntity create(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rs.close();
            return entity;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public GenericEntity save(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ").append(entity.getUpdateSetValues(entity))
                    .append(" WHERE ").append(entity.getDeleteAndUpdateCondition(entity));
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            return entity;
        } catch (Exception e) {
            Logger.getLogger(RepositoryDBGeneric.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean delete(GenericEntity entity) throws Exception {
        try {
            Connection connection = DatabaseFactoryRepository.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ").append(entity.getDeleteAndUpdateCondition(entity));
            Statement statement = connection.createStatement();
            String query = sb.toString();
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
