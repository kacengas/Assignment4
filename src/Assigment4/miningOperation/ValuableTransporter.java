package Assigment4.miningOperation;

import Assigment4.actors.Door;
import Assigment4.actors.TreasureRoomGuardsman;
import Assigment4.log.Log;
import Assigment4.model.Valuables;

import java.util.ArrayList;
import java.util.Random;

public class ValuableTransporter implements Runnable {
    private Deposit<Valuables> deposit;
    private Random random = new Random();
    private TreasureRoomGuardsman treasureRoom;
    private Door door;

    public ValuableTransporter(TreasureRoomGuardsman treasureRoom, Deposit<Valuables> deposit, Door door) {
        this.deposit = deposit;
        this.treasureRoom = treasureRoom;
        this.door = door;
    }

    @Override
    public void run()
    {
        while (true)
        {

            int target = random.nextInt(51 + 150);
            ArrayList<Valuables> collectedGems = new ArrayList<>();

            Log.getInstance().logAction("ValuableTransporter",
                    "Picked a random number " + target);

            while (collectedGems.size() < target){
                try {
                    collectedGems.add(deposit.dequeue());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Log.getInstance().logAction("ValuableTransporter", "Valuable added into cart, number of valuables in the cart " + collectedGems.size());
            }

            Log.getInstance().logAction("ValuableTransporter",
                    "Moving " + collectedGems.size() + " gems to treasure room");

            door.acquireWriteAccess();

            for (Valuables gem : collectedGems){
                treasureRoom.add("ValuableTransporter", gem);
            }

            door.releaseWriteAccess();

            try {
                Thread.sleep(random.nextInt(200) + 50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}