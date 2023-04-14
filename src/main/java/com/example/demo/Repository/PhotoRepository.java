package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String>{

}
