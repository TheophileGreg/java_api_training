package fr.lernejo.navy_battle;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.http.HttpClient;
import java.util.concurrent.Executors;

public class Server {
    static HttpServer server;

    public void startServer(int port) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(port), 0);
        Server.server = server;
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.createContext("/ping", Server::pingHandler);
        server.start();
    }

//    public void startGame(){
//        Server.server.createContext("/api/game/start", Server::startGameHandler);
//    }

//    private static void startGameHandler(HttpExchange httpExchange) {
//
//    }

    public void stopServer() {
        Server.server.stop(0);
    }

    static void pingHandler(HttpExchange exchange) throws IOException {
        String body = "Hello";
        exchange.sendResponseHeaders(200, body.length());
        try (OutputStream os = exchange.getResponseBody()) { // (1)
            os.write(body.getBytes());
        }
    }
}
