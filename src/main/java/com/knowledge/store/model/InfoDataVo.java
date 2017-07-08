/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knowledge.store.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author KRISHNA
 */
public class InfoDataVo {
    
    private SimpleIntegerProperty id;
    
    private SimpleStringProperty date;
    
    private SimpleStringProperty label;  
    
    private SimpleStringProperty description;
    

    public InfoDataVo(int id, String date, String label, String description) {
        this.id = new SimpleIntegerProperty(id);
        this.date =new SimpleStringProperty(date);
        this.label = new SimpleStringProperty(label);
        this.description = new SimpleStringProperty(description);
    }

    public Integer getId() {
        return id.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getLabel() {
        return label.get();
    }

    public String getDescription() {
        return description.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
    
    
    

}
