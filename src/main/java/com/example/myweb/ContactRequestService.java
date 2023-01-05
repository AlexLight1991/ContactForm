package com.example.myweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactRequestService {

    @Autowired
    private ContactRequestRepository repository;

    public void save(ContactRequest request) {
        repository.save(request);
    }

    public List<ContactRequest> getAllContactRequests() {
        return new ArrayList<>(repository.findAll());
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
