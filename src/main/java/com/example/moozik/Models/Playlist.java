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
public class Playlist {
    @Id
    private int playid;
    private String pname;
    private String descr;

    public int getPlayid() {
        return playid;
    }

    public void setPlayid(int playid) {
        this.playid = playid;
    }

   

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Playlist{" + "playid=" + playid + ", pname=" + pname + ", descr=" + descr + '}';
    }

   

    
   
    
    
    
}
