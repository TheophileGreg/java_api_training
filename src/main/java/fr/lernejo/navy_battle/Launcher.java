package fr.lernejo.navy_battle;

import java.io.IOException;

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
        GameBoard mainBoard = new GameBoard();
        mainBoard.hitACell(new Coordinates(3,3));
        System.out.print(args);
        System.out.print(mainBoard);
    }
}
