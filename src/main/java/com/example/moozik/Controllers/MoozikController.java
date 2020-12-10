/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.moozik.Controllers;

import com.example.moozik.Models.Playlist;
import com.example.moozik.Models.Singer;
import com.example.moozik.Models.Song;
import com.example.moozik.Repository.PlaylistRepository;
import com.example.moozik.Repository.SingerRepository;
import com.example.moozik.Repository.SongRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Annie Samarpitha Chandolu
 */
@Controller
public class MoozikController {
    // as we are going to use this variable for every method.

    ModelAndView mv = new ModelAndView();

    @Autowired
    PlaylistRepository prepo;
    @Autowired
    SingerRepository sgrepo;
    @Autowired
    SongRepository srepo;
    
    @RequestMapping("home")
    public ModelAndView home() {
        mv.setViewName("home.html");
        Iterable<Song> songList = srepo.findAll();
        mv.addObject("songs",songList);
        return mv;
    }

     @RequestMapping("addNewSong")
     public ModelAndView addNewSong(){
        Iterable<Singer> singersList = sgrepo.findAll();
        mv.addObject("singers", singersList);
        Iterable<Playlist> playlistsList = prepo.findAll();
        mv.addObject("playlists", playlistsList);
         mv.setViewName("addNewSong.html");
         return mv;
     }
    
    @RequestMapping("addNewSongactual")
    public ModelAndView addNewSongactual(Song s) {
        Iterable<Singer> singersList = sgrepo.findAll();
        mv.addObject("singers", singersList);
        Iterable<Playlist> playlistsList = prepo.findAll();
        mv.addObject("playlists", playlistsList);
        mv.setViewName("home");
        srepo.save(s);
        return mv;
    }
      

    @RequestMapping("addNewSinger")
    public ModelAndView addNewSinger() {
        mv.setViewName("addNewSinger.html");
        return mv;
    }
    
     @RequestMapping("addNewSingeractual")
    public ModelAndView addNewSingeractual(Singer s) {
        sgrepo.save(s);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("addNewPlaylist")
    public ModelAndView addNewPlaylist() {
        mv.setViewName("addNewPlaylist.html");

        return mv;
    }
    
    @RequestMapping("addNewPlaylistactual")
    public ModelAndView addNewPlaylistactual(Playlist p) {
        prepo.save(p);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("singerAdded")
    public ModelAndView addNewSinger(Singer singer) {
        sgrepo.save(singer);
        mv.setViewName("singer.html");
        return mv;
    }

    @RequestMapping("playlistAdded")
    public ModelAndView addNewPlaylist(Playlist playlist) {
        prepo.save(playlist);
        mv.setViewName("playlist.html");
        return mv;
    }

    @RequestMapping("songAdded")
    public ModelAndView songAdded(Song song, @RequestParam("sgid") int sgid, @RequestParam("playid") int pid) {
        Singer singer = sgrepo.findById(sgid).orElse(new Singer());
        Playlist playlist = prepo.findById(pid).orElse(new Playlist());
        song.setSinger(singer);
        song.setPlaylist(playlist);
        srepo.save(song);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("viewSingers")
    public ModelAndView viewSingers() {
        mv.setViewName("singer.html");
        Iterable<Singer> singersList = sgrepo.findAll();
        mv.addObject("singers", singersList);
        return mv;
    }

    @RequestMapping("advancedSearch")
    public ModelAndView advancedSearch() {
        mv.setViewName("advancedSearch.html");
        Iterable<Singer> singersList = sgrepo.findAll();
        mv.addObject("singers", singersList);
        return mv;
    }

    @RequestMapping("viewSongs")
    public ModelAndView viewSongs() {
        mv.setViewName("editSongView.html");
        Iterable<Song> songsList = srepo.findAll();
        mv.addObject("songs", songsList);
        return mv;
    }

    @RequestMapping("viewPlaylists")
    public ModelAndView viewPlaylists() {
        mv.setViewName("playlist.html");
        Iterable<Playlist> playlistsList = prepo.findAll();
        mv.addObject("playlists", playlistsList);
        return mv;
    }

    @RequestMapping("searchSong")
    public ModelAndView searchBySongId(int sid) {
        Song songFound = srepo.findById(sid).orElse(new Song());
        mv.addObject(songFound);
        mv.setViewName("searchResultSong.html");
        return mv;
    }

    @RequestMapping("searchSinger")
    public ModelAndView searchBySingerId(int sgid) {
        Singer singerFound = sgrepo.findById(sgid).orElse(new Singer());
        mv.addObject(singerFound);
        mv.setViewName("searchResultSinger.html");
        return mv;
    }

    @RequestMapping("searchPlaylist")
    public ModelAndView searchByPlaylistId(int pid) {
        Playlist playlistFound = prepo.findById(pid).orElse(new Playlist());
        mv.addObject(playlistFound);
        mv.setViewName("searchResultPlaylist.html");
        return mv;
    }

    @RequestMapping("editSongView")
    public ModelAndView editSongView(Song song) {
        srepo.save(song);
        mv.setViewName("editSongView.html");
        return mv;
    }

    @RequestMapping("editSingerView")
    public ModelAndView editSingerView(Singer singer) {
        sgrepo.save(singer);
        mv.setViewName("editSingerView.html");
        return mv;
    }

    @RequestMapping("editPlaylistView")
    public ModelAndView editPlaylistView(Playlist playlist) {
        prepo.save(playlist);
        mv.setViewName("editPlaylistView.html");
        return mv;
    }

    @RequestMapping("deleteSong")
    public ModelAndView deleteSong(Song song) {
        // delete by id
        Optional<Song> songFound = srepo.findById(song.getSid());
        if (songFound.isPresent()) {
            srepo.delete(song);
        }
        return home();
    }

    @RequestMapping("deleteSinger")
    public ModelAndView deleteSinger(Singer singer) {
        // delete by id
        Optional<Singer> singerFound = sgrepo.findById(singer.getSgid());
        if (singerFound.isPresent()) {
            sgrepo.delete(singer);
        }
        return home();
    }

    @RequestMapping("deletePlaylist")
    public ModelAndView deletePlaylist(Playlist playlist) {
        // delete by id
        Optional<Playlist> playlistFound = prepo.findById(playlist.getPlayid());
        if (playlistFound.isPresent()) {
            prepo.delete(playlist);
        }
        return home();
    }

}
