package com.project.journalApp.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.project.journalApp.entity.JournalEntry;
import com.project.journalApp.entity.User;
import com.project.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// foloow of request = controller ---> Service ------> Repositry
@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserEntryService userEntryService;
//    @Transactional
    public  void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userEntryService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved=journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUserName(null); //that reson we use Transection for not completeing operation
            userEntryService.saveUser(user);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving  the entry",e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try {
            User user = userEntryService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userEntryService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("an error occured while deleteing the entry");
        }
        return removed;
    }

//    public List<JournalEntry>findByUserName(String userName){
//
//    }
}
