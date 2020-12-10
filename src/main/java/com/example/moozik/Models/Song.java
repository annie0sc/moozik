/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.moozik.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Annie Samarpitha Chandolu
 */
@Entity
public class Song {
    @Id
    private int sid;
    private String sname;
    private int year;
    private String genre;
    private String album;
    private int ratings;
    
    @ManyToOne
    private Singer singer;
    
    @ManyToOne
    private Playlist playlist;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
    
    @Override
    public String toString() {
        return "Song Details: " + "\nID: " + sid + " Name: " + sname 
                + " Year: " + year + " Genre: " + genre + " Album: " + album 
                + " Rating: " + ratings
                + " Singer: " + singer + " Playlist: " + playlist;
    }
    
    
    
}
