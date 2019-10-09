package edu.tam.sample.services.speciality.interfaces;

import edu.tam.sample.model.Speciality;

import java.util.List;

public interface ISpecialityServices {
    List<Speciality> getAll();
    Speciality get(String id);
}
