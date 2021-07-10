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
        new Server().startServer(8888, null);
        String url = "http://localhost:8888/ping";
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
}
