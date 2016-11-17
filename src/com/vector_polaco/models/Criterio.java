package com.vector_polaco.models;

import com.vector_polaco.utilities.ConnectionManager;

import java.util.ArrayList;

/**
 * Created by robil on 02/11/2016.
 */
public class Criterio extends BaseModel {
    double valor, puntos_deducido_por_error;

    public Criterio(double valor, double puntos_deducido_por_error) {
        this.valor = valor;
        this.puntos_deducido_por_error = puntos_deducido_por_error;
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
                ", id_criterio_nombre_archivo="       + this.puntos_deducido_por_error +
                " WHERE lista_criterios.id=" + id + ";"
                ;
        ConnectionManager.getInstance().execute(query);
    }

    public static Criterio getOne(int id) {
        return null;
    }

    public static ArrayList<Criterio> getAll(){
        return null;
    }

    public static Criterio createOne(){
        return null;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPuntos_deducido_por_error() {
        return puntos_deducido_por_error;
    }

    public void setPuntos_deducido_por_error(double puntos_deducido_por_error) {
        this.puntos_deducido_por_error = puntos_deducido_por_error;
    }
}
