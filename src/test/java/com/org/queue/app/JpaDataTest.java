package com.org.queue.app;

import com.org.queue.app.model.AEData;
import com.org.queue.app.repository.AEDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaDataTest {
    @Autowired
    private AEDataRepository repository;

    @Test
    public void whenFindByPublicationDate_thenArticles1And2Returned() {
//        List<AppExtender> result = repository.findAllWithCreationDateTimeBefore(
//                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00"));

        Optional<AEData> result = repository.findById(1);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertTrue("",result.stream()
                .map(AEData::getId)
                .allMatch(id -> Arrays.asList(1).contains(id)));
    }


    @Test
    public void whenQueryIncomplete_thenCorrectDataReturned() {
//        List<AppExtender> result = repository.findAllWithCreationDateTimeBefore(
//                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00"));

        List<AEData> result = repository.getIncompleteQueue();
        assertFalse(result.isEmpty());
     }

    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect() {
        List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findAny();

        assertTrue(result.isPresent());
        //assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }
}
