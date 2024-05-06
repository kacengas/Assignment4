package Assigment4.interfaces;

import Assigment4.model.Valuables;

import java.util.ArrayList;

public interface Treasury {
    void add(String actor, Valuables valuable);
    Valuables retrieve(String actor);
    ArrayList<Valuables> look(String actor);

}
