package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.server.*;
import java.io.IOException;


public class Launcher {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Need [port] argument ans maybe {server_url}");
                System.exit(-1);
            }
            int serverPort = Integer.parseInt(args[0]);
            System.out.println("Serve listen on port " + serverPort);
            new Server().startServer(serverPort, args.length > 1 ? args[1] : null);
        } catch (IOException e) {
            e.printStackTrace();
        } }
    //        Game mainBoard = new Game();
//        while (mainBoard.getStatus() == GameStatus.onGoing)
//        {
//            Scanner keyboard = new Scanner(System.in);
//            String in = keyboard.next();
//            System.out.print("\n Fire return : " + mainBoard.fire(in));
//            System.out.print("\n Game status : " + mainBoard.getStatus());
//            System.out.print("\n" + mainBoard);
//        }
}
