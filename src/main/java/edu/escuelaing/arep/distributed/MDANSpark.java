package edu.escuelaing.arep.distributed;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.distributed.service.Function;

public class MDANSpark {

    private static final Map<String, Function> GET_SOURCE = new HashMap<>();
    private static final Map<String, Function> POST_SOURCE = new HashMap<>();
    private static MDANSpark _instance;

    private MDANSpark() {
    }

    public static MDANSpark getInstance() {
        if (_instance == null) {
            _instance = new MDANSpark();
        }
        return _instance;
    }

    public static void fileStatic(String path) {
        HttpServer.getInstance().setFile(path);
    }

    /**
     * Save the resource and the service to be called when the resource is requested
     * 
     * @param path    the resource to be saved
     * @param service the service to be called when the resource is requested
     */
    public static void get(String path, Function service) {
        getInstance().GET_SOURCE.put(path, service);
    }

    /**
     * Method that save a post service to be called when the resource is requested
     * 
     * @param path    the resource to be saved
     * @param service the service to be called when the resource is requested
     */
    public static void post(String path, Function service) {
        POST_SOURCE.put(path, service);
    }

    /*
     * Method that searchs for the resource in the GET_SOURCE and POST_SOURCE and
     * returns the response of the service
     * @param path the resource to be searched
     * @param method the method of the request
     * @return the response of the service 
     */
    public static Function search(String path, String method) {
        if (method.equals("GET")) {
            return GET_SOURCE.get(path);
        } else if(method.equals("POST")){
            return POST_SOURCE.get(path);
        } else {
            return null;
        }
    }

}
