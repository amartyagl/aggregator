package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.modal.GloQuoraPost;

@Repository
public interface GloQuoraRepository extends MongoRepository<GloQuoraPost, String> {

}
