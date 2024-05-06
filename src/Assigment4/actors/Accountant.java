package Assigment4.actors;

import Assigment4.log.Log;
import Assigment4.model.Valuables;

import java.util.List;
import java.util.Random;

public class Accountant implements Runnable {
    private final TreasureRoomGuardsman treasureRoom;
    private final Door door;
    private final Random random = new Random();

    public Accountant(TreasureRoomGuardsman treasureRoom, Door door) {
        this.treasureRoom = treasureRoom;
        this.door = door;
    }

    @Override
    public void run() {
        while (true) {
            door.acquireReadAccess();

            List<Valuables> valuables = treasureRoom.look("Accountant");
            int totalValue = 0;

            for (Valuables valuable : valuables) {
                totalValue ++;
            }

            Log.getInstance().logAction("Accountant", "Number of valuables in Treasure Room: " + totalValue);

            door.releaseReadAccess();

            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
