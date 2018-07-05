package com.alliant.listner.repo;

import com.alliant.listner.domain.VideoResume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoResumeRepository extends CrudRepository<VideoResume, Long>{


}
