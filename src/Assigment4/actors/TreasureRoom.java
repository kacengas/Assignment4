package Assigment4.actors;

import Assigment4.interfaces.Treasury;
import Assigment4.log.Log;
import Assigment4.model.Valuables;

import java.util.ArrayList;

public class TreasureRoom implements Treasury {
    private ArrayList<Valuables> valuablesList;
    private Log log;

    public TreasureRoom() {
        this.valuablesList = new ArrayList<>();
    }

    @Override
    public void add(String actor, Valuables valuable) {
        if (valuable != null) {
            this.valuablesList.add(valuable);
            Log.getInstance().logAction(actor, "Added " + valuable.getType() + " to Treasure Room.");
        } else {
            Log.getInstance().logAction(actor, "Failed to add valuable to Treasure Room; valuable is null.");
        }
    }

    @Override
    public Valuables retrieve(String actor) {
        if (!valuablesList.isEmpty()) {
            Valuables valuable = valuablesList.remove(0);
            if (valuable != null) {
                Log.getInstance().logAction(actor, "Retrieved " + valuable.getType() + " from Treasure Room.");
                return valuable;
            } else {
                Log.getInstance().logAction(actor, "Failed to retrieve valuable; retrieved null from list.");
                return null;
            }
        } else {
            Log.getInstance().logAction(actor, "Failed to retrieve valuable. Treasure Room is empty.");
            return null;
        }
    }

    @Override
    public ArrayList<Valuables> look(String actor) {
        Log.getInstance().logAction(actor, "Looking at valuables in the Treasure Room.");
        return new ArrayList<>(valuablesList);
    }
}
