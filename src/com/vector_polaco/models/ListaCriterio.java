package com.vector_polaco.models;

import com.vector_polaco.utilities.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaCriterio extends BaseModel {
    private int id_cr_nombre_archivo, id_cr_vars_ctes, id_criterio_espacios, id_criterio_comentario_inicial, id_criterio_comentarios_funcs;
    private String nombre;

    private ListaCriterio(int id, int id_cr_nombre_archivo, int id_cr_vars_ctes, int id_criterio_espacios,
                          int id_criterio_comentario_inicial, int id_criterio_comentarios_funcs, String nombre) {
        this.id = id;
        this.id_cr_nombre_archivo = id_cr_nombre_archivo;
        this.id_cr_vars_ctes = id_cr_vars_ctes;
        this.id_criterio_espacios = id_criterio_espacios;
        this.id_criterio_comentario_inicial = id_criterio_comentario_inicial;
        this.id_criterio_comentarios_funcs = id_criterio_comentarios_funcs;
        this.nombre = nombre;
    }

    private ListaCriterio(int id) {
        String query = "SELECT * FROM lista_criterios WHERE id = " + id;

        ResultSet result = ConnectionManager.getInstance().executeQuery(query);

        try {
            if (result.next()) {
                this.id = id;
                this.id_cr_nombre_archivo = result.getInt("id_criterio_nombre_archivo");
                this.id_cr_vars_ctes = result.getInt("id_criterio_vars_ctes");
                this.id_criterio_espacios = result.getInt("id_criterio_espacios");
                this.id_criterio_comentario_inicial = result.getInt("id_criterio_comentario_inicial");
                this.id_criterio_comentarios_funcs = result.getInt("id_criterio_comentarios_funcs");
                this.nombre = result.getString("nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        String query = "DELETE lista_criterios WHERE id=" + id;
        ConnectionManager.getInstance().execute(query);
    }

    @Override
    public void update() {
        String query = "UPDATE lista_criterios SET " +
                "nombre=" + nombre +
                ", id_criterio_nombre_archivo=" + id_cr_nombre_archivo +
                ", id_criterio_vars_ctes=" + id_cr_vars_ctes +
                ", id_criterio_espacios=" + id_criterio_espacios +
                ", id_criterio_comentario_inicial=" + id_criterio_comentario_inicial +
                ", id_criterio_comentarios_funcs=" + id_criterio_comentarios_funcs +
                " WHERE lista_criterios.id=" + id + ";";
        ConnectionManager.getInstance().execute(query);
    }

    public static ArrayList<ListaCriterio> getAll() {
        String query = "SELECT * FROM lista_criterios;";
        ResultSet rs = ConnectionManager.getInstance().executeQuery(query);
        ArrayList<ListaCriterio> al = new ArrayList<>();
        try {
            System.out.println(rs.getFetchSize());
            while (rs.next()) {
                ListaCriterio lc = new ListaCriterio(rs.getInt("id"), rs.getInt("id_criterio_nombre_archivo"),
                        rs.getInt("id_criterio_vars_ctes"), rs.getInt("id_criterio_espacios"), rs.getInt("id_criterio_comentario_inicial"), rs.getInt("id_criterio_comentarios_funcs"), rs.getString("nombre"));
                al.add(lc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(al.size());
        return al;
    }

    public static ListaCriterio getOne(int id) {
        return new ListaCriterio(id);
    }

    public static ListaCriterio createOne(int id_cr_nombre_archivo, int id_cr_vars_ctes, int id_criterio_espacios,
                                          int id_criterio_comentario_inicial, int id_criterio_comentarios_funcs, String nombre) {
        String query = "INSERT INTO lista_criterios(nombre, id_criterio_nombre_archivo, id_criterio_vars_ctes, " +
                "id_criterio_espacios, id_criterio_comentario_inicial, id_criterio_comentarios_funcs) VALUES ('" +
                nombre + "', " + id_cr_nombre_archivo + ", " + id_cr_vars_ctes + ", "
                + id_criterio_espacios + ", " + id_criterio_comentario_inicial + ", " + id_criterio_comentarios_funcs + ");";
        int id = ConnectionManager.getInstance().executeInsert(query);
        return new ListaCriterio(id, id_cr_nombre_archivo, id_cr_vars_ctes, id_criterio_espacios,
                id_criterio_comentario_inicial, id_criterio_comentarios_funcs, nombre);
    }

    public int getId_cr_nombre_archivo() {
        return id_cr_nombre_archivo;
    }

    public void setId_cr_nombre_archivo(int id_cr_nombre_archivo) {
        this.id_cr_nombre_archivo = id_cr_nombre_archivo;
    }

    public int getId_cr_vars_ctes() {
        return id_cr_vars_ctes;
    }

    public void setId_cr_vars_ctes(int id_cr_vars_ctes) {
        this.id_cr_vars_ctes = id_cr_vars_ctes;
    }

    public int getId_criterio_espacios() {
        return id_criterio_espacios;
    }

    public void setId_criterio_espacios(int id_criterio_espacios) {
        this.id_criterio_espacios = id_criterio_espacios;
    }

    public int getId_criterio_comentario_inicial() {
        return id_criterio_comentario_inicial;
    }

    public void setId_criterio_comentario_inicial(int id_criterio_comentario_inicial) {
        this.id_criterio_comentario_inicial = id_criterio_comentario_inicial;
    }

    public int getId_criterio_comentarios_funcs() {
        return id_criterio_comentarios_funcs;
    }

    public void setId_criterio_comentarios_funcs(int id_criterio_comentarios_funcs) {
        this.id_criterio_comentarios_funcs = id_criterio_comentarios_funcs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return this.nombre;
    }
}
