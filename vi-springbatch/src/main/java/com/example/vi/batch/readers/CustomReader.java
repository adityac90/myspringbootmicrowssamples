package com.example.vi.batch.readers;

import com.example.vi.batch.model.Tutorial;
import com.example.vi.batch.repositories.TutorialRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class CustomReader implements ItemReader<Tutorial> {
    private Iterator<Tutorial> data;


    public CustomReader(TutorialRepository tutorialRepository) {
        final List<Tutorial> all = tutorialRepository.findAll();
        data = all.iterator();

    }

    @Override
    public Tutorial read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (this.data.hasNext()) {
            return this.data.next();
        } else {
            return null;
        }
    }
}
