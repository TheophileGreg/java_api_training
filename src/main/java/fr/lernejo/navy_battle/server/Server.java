package fr.lernejo.navy_battle.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.Executors;

public class Server extends AbstractServer {
    private final Option<ServerInfo> localServer = new Option<>();
    private final Option<ServerInfo> remoteServer = new Option<>();

    public void startServer(int port, String connectURL) throws IOException {
        localServer.set(new ServerInfo(
            UUID.randomUUID().toString(),
            "http://localhost:" + port,
            "OK"
        ));
        if (connectURL != null)
            new Thread(() -> this.requestStart(connectURL)).start();
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.createContext("/api/game/start", s -> startGame(new RequestHandler(s)));
        server.createContext("/ping", this::handlePing);
        server.createContext("/api/game/fire", s -> handleFire(new RequestHandler(s)));
        server.start();
    }
    private void handlePing(HttpExchange exchange) throws IOException {
        String body = "OK";
        exchange.sendResponseHeaders(200, body.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }
    public void handleFire(RequestHandler handler) throws IOException {
        try {
            var response = new JSONObject();
            response.put("consequence", "Renvoyer ici BoatStatus");
            response.put("shipLeft", true);
            handler.sendJSON(200, response);
        } catch (Exception e) {
            e.printStackTrace();handler.sendString(400, e.getMessage());
        }
    }

    public void startGame(RequestHandler handler) throws IOException {
        try {
            remoteServer.set(ServerInfo.fromJSON(handler.getJSONObject()));
            System.out.println("Connect to " + remoteServer.get().getUrl());
            handler.sendJSON(202, localServer.get().toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            handler.sendString(400, e.getMessage());
        }
    }
    public void requestStart(String server) {
        try {
            var response = sendPOSTRequest(server + "/api/game/start", this.localServer.get().toJSON());
            this.remoteServer.set(ServerInfo.fromJSON(response).withURL(server));
            System.out.println("Connect to " + remoteServer.get().getUrl());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed");
        }
    }
}
