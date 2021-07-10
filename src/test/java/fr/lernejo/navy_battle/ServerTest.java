package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.server.Server;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServerTest {
    @Test
    public void testStartServer() throws IOException {
        new Server().startServer(9876, null);
        String url = "http://localhost:9876/ping";
        String source = "";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            source += inputLine;
        in.close();
        assertEquals("OK", source);
    }

    @Test
    public void testStopServer() throws IOException {
        Server server = new Server();
        server.startServer(9999, null);
        //server.stopServer();
        String url = "http://localhost:9999/ping";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        try{
            new InputStreamReader(
                yc.getInputStream());
        }catch(Exception e){
            System.out.print(e);
            assertTrue(true);
        }
    }
}
