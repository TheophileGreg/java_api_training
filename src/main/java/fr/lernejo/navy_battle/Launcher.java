package fr.lernejo.navy_battle;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.exit(-1);
//        }
//        int port = Integer.parseInt(args[0]);
//        Server mainServer;
//        mainServer = new Server();
//        try {
//            mainServer.startServer(port);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Game mainBoard = new Game();
        while (mainBoard.getStatus() == GameStatus.onGoing)
        {
            Scanner keyboard = new Scanner(System.in);
            String in = keyboard.next();
            System.out.print("\n Fire return : " + mainBoard.fire(in));
            System.out.print("\n Game status : " + mainBoard.getStatus());
            System.out.print("\n" + mainBoard);

        }


    }
}
