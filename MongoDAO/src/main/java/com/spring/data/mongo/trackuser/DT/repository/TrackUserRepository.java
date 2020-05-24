package com.spring.data.mongo.trackuser.DT.repository;

import com.spring.data.mongo.trackuser.DT.TrackUserDT;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackUserRepository extends CrudRepository<TrackUserDT, Long>, QueryByExampleExecutor<TrackUserDT> {

    public TrackUserDT find(ObjectId id);

}
