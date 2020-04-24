package com.seniorglez.cobid.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;

public class DataLine {
    SimpleStringProperty date;
    SimpleStringProperty provincia;
    SimpleStringProperty confirmedCases;
    SimpleStringProperty newPositives;
    SimpleStringProperty discharged;
    SimpleStringProperty deaths;
    SimpleStringProperty ineCode;
    SimpleStringProperty position;


    public DataLine(String date, String provincia, String confirmedCases, String newPositives,
                    String dischargued, String deaths,String ineCode, String position)  {
        this.date = new SimpleStringProperty(date);
        this.provincia = new SimpleStringProperty(provincia);
        this.confirmedCases = new SimpleStringProperty(confirmedCases);
        this.newPositives = new SimpleStringProperty(newPositives);
        this.discharged = new SimpleStringProperty(dischargued);
        this.deaths = new SimpleStringProperty(deaths);
        this.ineCode= new SimpleStringProperty(ineCode);
        this.position = new SimpleStringProperty(position);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getProvincia() {
        return provincia.get();
    }

    public void setProvincia(String provincia) {
        this.provincia.set(provincia);
    }

    public String getConfirmedCases() {
        return confirmedCases.get();
    }

    public void setConfirmedCases(String confirmedCases) {
        this.confirmedCases.set(confirmedCases);
    }

    public String getNewPositives() {
        return newPositives.get();
    }

    public void setNewPositives(String newPositives) {
        this.newPositives.set(newPositives);
    }

    public String getDischarged() {
        return discharged.get();
    }

    public void setDischarged(String discharged) {
        this.discharged.set(discharged);
    }

    public String getDeaths() {
        return deaths.get();
    }

    public void setDeaths(String deaths) {
        this.deaths.set(deaths);
    }

    public String getIneCode() {
        return ineCode.get();
    }

    public void setIneCode(String ineCode) {
        this.ineCode.set(ineCode);
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
