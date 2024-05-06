import Assigment4.actors.*;
import Assigment4.miningOperation.Deposit;
import Assigment4.miningOperation.Miner;
import Assigment4.miningOperation.ValuableTransporter;
import Assigment4.model.Valuables;

public class Main {
    public static void main(String[] args) {
        Deposit<Valuables> deposit = new Deposit<>();
        TreasureRoom treasureRoom = new TreasureRoom();
        Door door = new Door();

        TreasureRoomGuardsman guardsman = new TreasureRoomGuardsman(treasureRoom);

        Thread kingThread = new Thread(new King(guardsman, door));
        Thread accountantThread = new Thread(new Accountant(guardsman, door));

        kingThread.start();
        accountantThread.start();

        Thread miner1 = new Thread(new Miner(deposit));
        Thread miner2 = new Thread(new Miner(deposit));
        miner1.start();
        miner2.start();

        Thread transporter1 = new Thread(new ValuableTransporter(guardsman ,deposit, door));
        transporter1.start();

    }
}
