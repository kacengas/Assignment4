package Assigment4.actors;

import Assigment4.interfaces.Treasury;
import Assigment4.log.Log;
import Assigment4.model.Valuables;

import java.util.ArrayList;

public class TreasureRoomGuardsman implements Treasury {
    private TreasureRoom treasureRoom;

    public TreasureRoomGuardsman(TreasureRoom treasureRoom) {
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void add(String actor, Valuables valuable) {
        if (actor.equals("ValuableTransporter")) {
            treasureRoom.add(actor, valuable);
        } else {
            Log.getInstance().logAction(actor, "Access denied. Only ValuableTransporters can add valuables.");
        }
    }

    @Override
    public Valuables retrieve(String actor) {
        if (actor.equals("King")) {
            return treasureRoom.retrieve(actor);
        } else {
            Log.getInstance().logAction(actor, "Access denied. Only the King can retrieve valuables.");
            return null;
        }
    }

    @Override
    public ArrayList<Valuables> look(String actor) {
        if (actor.equals("Accountant")) {
            return treasureRoom.look(actor);
        } else {
            Log.getInstance().logAction(actor, "Access denied. Only Accountants can look at valuables.");
            return null;
        }
    }
}
