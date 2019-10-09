package edu.tam.sample.repository;

import edu.tam.sample.model.Speciality;
import edu.tam.sample.model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends MongoRepository<Speciality, String> {
}
