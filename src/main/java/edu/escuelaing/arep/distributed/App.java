package edu.escuelaing.arep.distributed;

import static edu.escuelaing.arep.distributed.MDANSpark.*;

import com.google.gson.JsonObject;

public class App {

    public static void main(String[] args) {

        MDANSpark.getInstance().fileStatic("target/classes/public");

        get("/movie", (req) -> {
            HttpClient client = new HttpClient();
            JsonObject data = client.get(req);
            return data.toString();
        });

        try {
            if (!HttpServer.getInstance().isRunning()) {
                HttpServer.getInstance().runServer();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}
