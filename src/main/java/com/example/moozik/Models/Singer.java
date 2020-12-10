/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.moozik.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Annie Samarpitha Chandolu
 */
@Entity
public class Singer {
    @Id
    private int sgid;
    private String sgname;
    private String label;

    public int getSgid() {
        return sgid;
    }

    public void setSgid(int sgid) {
        this.sgid = sgid;
    }

    public String getSgname() {
        return sgname;
    }

    public void setSgname(String sgname) {
        this.sgname = sgname;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Singer Details: " + "\nId: " + sgid + " Name: " + sgname 
                + " Label: " + label;
    }
    
    
}
