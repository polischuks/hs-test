package org.hyperskill.hstest.dev.mocks.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface ServerMockRequestProcessor {

    boolean processRequest(DataOutputStream output, DataInputStream input, String request) throws IOException;

    String processResponse(DataInputStream input) throws IOException;

    void setup(String[] setupCommands);
}
