/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.Repository;

 
import com.bkwitten.Digitalisierung.model.Historie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karahtqc
 */
@Repository
public interface HistorieRepository extends JpaRepository<Historie, Integer>{

    
    
    @Query(nativeQuery = true, value = "SELECT datenbank.test(:value)")
    public int search(@Param("value") int value);
    
    
}
