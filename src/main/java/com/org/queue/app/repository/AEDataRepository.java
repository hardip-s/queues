package com.org.queue.app.repository;

import com.org.queue.app.model.AEData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AEDataRepository extends CrudRepository<AEData,Integer> {

   public List<AEData> findAll();


   /*
   SELECT FIELD4,FIELD8,receipt_dt,process_dt,docid,field6,field7, field1 from ae_dt1
                   Where receipt_dt> SYSDATE()-30 and (( field4 ='FAXIN' and FIELD8 ='OPERATIONSSUPPORTFAX')
                   OR (field4 = 'CUST CORR' and field8 = 'CUST CORRESPONDENCE')) order by docid;
    */
   @Query(
           value = " select * from ae_dt1 " +
                   " where receipt_dt> sysdate() - 30 and (( field4 ='FAXIN' and FIELD8 ='OPERATIONSSUPPORTFAX') " +
                   " OR (field4 = 'CUST CORR' and field8 = 'CUST CORRESPONDENCE')) order by docid",
           nativeQuery = true
   )

   public List<AEData> getIncompleteQueue() ;

   /* @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    List<AppExtender> findAllWithCreationDateTimeBefore(
            @Param("creationDateTime") Date creationDateTime);*/
}
