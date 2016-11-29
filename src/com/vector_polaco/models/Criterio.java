package com.vector_polaco.models;

import com.vector_polaco.utilities.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Criterio extends BaseModel {
    int valor, puntos_deducido_por_error;
    int id;

    public Criterio(int id, int valor, int puntos_deducido_por_error) {
        this.id = id;
        this.valor = valor;
        this.puntos_deducido_por_error = puntos_deducido_por_error;
    }

    public Criterio(int id){
        String query = "Select * FROM criterio WHERE id =" + id;
        ResultSet result = ConnectionManager.getInstance().executeQuery(query);

        try {
            if (result.next()) {
                this.id = id;
                this.valor = result.getInt("valor");
                this.puntos_deducido_por_error = result.getInt("porcentaje_deducido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        String query = "DELETE criterio WHERE id=" + id;
        ConnectionManager.getInstance().execute(query);
    }

    @Override
    public void update() {
        String query = "UPDATE criterio SET "+
                "valor=" + this.valor +
                ", puntos_deducido_por_error="       + this.puntos_deducido_por_error +
                " WHERE criterio.id=" + id + ";"
                ;
        ConnectionManager.getInstance().execute(query);
    }

    public static Criterio getOne(int id) {
        return new Criterio(id);
    }

    public static Criterio createOne(int valor, int puntos_deducido_por_error){
        String query = "INSERT INTO criterio(valor, porcentaje_deducido) VALUES(" +
                valor + ", " + puntos_deducido_por_error + ");";
        System.out.println(query);
        int id = ConnectionManager.getInstance().executeInsert(query);
        return new Criterio(id, valor, puntos_deducido_por_error);
    }

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPuntos_deducido_por_error() {
        return puntos_deducido_por_error;
    }

    public void setPuntos_deducido_por_error(int puntos_deducido_por_error) {
        this.puntos_deducido_por_error = puntos_deducido_por_error;
    }
}
