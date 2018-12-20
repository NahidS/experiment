package com.nseidi.experiment.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nseidi.experiment.entity.Music;

@EnableScan
@Repository
public interface MusicRepository extends CrudRepository<Music, String> {
}
