package Assigment4.actors;

import Assigment4.log.Log;
import Assigment4.model.Valuables;

import java.util.Random;

public class King implements Runnable {
    private final TreasureRoomGuardsman treasureRoom;
    private final Door door;
    private final Random random = new Random();

    public King(TreasureRoomGuardsman treasureRoom, Door door) {
        this.treasureRoom = treasureRoom;
        this.door = door;
    }

    @Override
    public void run() {
        while (true) {
            door.acquireWriteAccess();

            int partyCost = random.nextInt(101) + 50;
            int collectedCount = 0;

            while (collectedCount < partyCost) {
                Valuables valuable = treasureRoom.retrieve("King");
                if (valuable == null) {
                    Log.getInstance().logAction("King", "Not enough valuables; party cancelled.");
                    break;
                }
                collectedCount++;
            }

            if (collectedCount >= partyCost) {
                Log.getInstance().logAction("King", "Held a party with cost of: " + collectedCount + " valuables.");
            }

            door.releaseWriteAccess();

            try {
                Thread.sleep(random.nextInt(1500) + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
