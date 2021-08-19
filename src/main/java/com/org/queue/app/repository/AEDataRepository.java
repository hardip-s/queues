package com.org.queue.app.repository;

import com.org.queue.app.model.AEData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AEDataRepository extends CrudRepository<AEData,Integer> {
   public List<AEData> findAll();


   /* @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<AppExtender> findAllWithCreationDateTimeBefore(
            @Param("creationDateTime") Date creationDateTime);*/
}
