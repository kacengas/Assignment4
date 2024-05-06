package Assigment4.miningOperation;

import Assigment4.log.Log;
import Assigment4.model.ValuableMultiton;
import Assigment4.model.Valuables;

import java.util.Random;

public class Miner implements Runnable {
    private Deposit<Valuables> deposit;
    private Random random = new Random();

    public Miner(Deposit<Valuables> deposit) {
        this.deposit = deposit;
    }


    @Override
    public void run() {
        while (true) {
            String[] valuableTypes = {"Diamond", "Gold", "Emerald", "Ruby"};
            String valuableType = valuableTypes[random.nextInt(valuableTypes.length)];

            Valuables valuable = ValuableMultiton.getInstance(valuableType);

            if (valuable != null) {
                deposit.enqueue(valuable);
                Log.getInstance().logAction("Miner", "Deposited a " + valuable.getType());
            }

            try {
                Thread.sleep(random.nextInt(100) + 50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
