/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.moozik.Repository;

import com.example.moozik.Models.Playlist;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Annie Samarpitha Chandolu
 */
public interface PlaylistRepository extends CrudRepository<Playlist, Integer>{
    
}
