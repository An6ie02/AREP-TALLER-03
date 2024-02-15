package edu.escuelaing.arep.distributed;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

    HttpServer server;

    @Before
    public void setUp() {
        server = HttpServer.getInstance();
        server.setFile("target/classes/public");
    }

    @Test
    public void testGetHtml() {
        byte[] response = null;
        try {
            response = server.responseBody("text/html", server.uriFile + "/index.html");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        assertNotNull(response);
    }

    @Test
    public void testNotGetHtml() {
        byte[] response = null;
        try {
            response = server.responseBody("text/html", server.uriFile + "/index2.html");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        assertTrue(response == null);
    }

    @Test
    public void testGetCss() {
        byte[] response = null;
        try {
            response = server.responseBody("text/css", server.uriFile + "/css/stile.css");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        assertNotNull(response);
    }

   
}
