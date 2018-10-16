package com.restApp.religiousIndia.data.repositry;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.FamousThoughts;

public interface ThoughtRepositry extends CrudRepository<FamousThoughts, String> {

}
