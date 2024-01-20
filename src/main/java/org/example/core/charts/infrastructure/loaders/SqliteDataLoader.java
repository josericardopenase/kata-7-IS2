package org.example.core.charts.infrastructure.loaders;

import org.example.core.charts.application.ports.DataLoader;
import org.example.core.charts.application.ports.ModelSerializer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqliteDataLoader<Model> implements DataLoader<Model> {
    private final Connection connection;
    private final ModelSerializer<Model> serializer;
    private static String query = "SELECT * FROM movies";

    public SqliteDataLoader(Connection connection, ModelSerializer<Model> serializer) {
        this.connection = connection;
        this.serializer = serializer;
    }

    @Override
    public List<Model> load() {
        try(var result = this.findAll()){
           return load(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Model> load(ResultSet result) throws SQLException {
        var data = new ArrayList<Model>();
        while(result.next()){
            data.add(serializer.deserialize(new ModelSerializer.Input() {
                @Override
                public String get(String key) {
                    try {
                        return result.getString(key);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public String get(int index) {
                    try {
                        return result.getString(index+1);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }));
        }
        return data;
    }

    private ResultSet findAll() throws SQLException {
        return this.connection.createStatement().executeQuery(query);
    }
}
