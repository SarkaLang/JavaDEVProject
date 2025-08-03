package org.example.person;

import org.example.entity.ParkingPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PersonRepository extends JpaRepository<ParkingPerson, Long> {

}

