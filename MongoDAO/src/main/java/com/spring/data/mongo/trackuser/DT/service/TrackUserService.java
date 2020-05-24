package com.spring.data.mongo.trackuser.DT.service;

import com.spring.data.mongo.trackuser.DT.TrackUserDT;
import com.spring.data.mongo.trackuser.DT.repository.TrackUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class TrackUserService {

    @Autowired
    private TrackUserRepository trackUserRepository;

    public void saveTrackUser(TrackUserDT trackUserDT) {
        trackUserRepository.save(trackUserDT);
    }

    public void saveTrackUser(List<TrackUserDT> trackUserDTList) {
        trackUserRepository.saveAll(trackUserDTList);
    }

    public Iterator<TrackUserDT> getAllData() {
        return trackUserRepository.findAll().iterator();
    }

}
