package edu.escuelaing.arep.distributed.service;

import java.io.IOException;

public interface Function {
    
    /**
     * This method is in charge of handling the request and returning the response
     * @param requestQuery the request to be handled
     * @return the response of the request
     */
    public String handle(String requestQuery) throws IOException;

}
