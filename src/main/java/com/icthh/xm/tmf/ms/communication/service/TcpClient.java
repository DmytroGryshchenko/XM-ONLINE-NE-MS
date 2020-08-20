package com.icthh.xm.tmf.ms.communication.service;

import com.icthh.xm.tmf.ms.communication.domain.VodData;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

@Slf4j
public class TcpClient {

    private Socket socket;
    private DataOutputStream oos;
    private DataInputStream ois;

    public TcpClient() {
        try {
            socket = new Socket("tcp-emulator-app", 5015);
            oos = new DataOutputStream(socket.getOutputStream());
            ois = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


    public String connect(String login, String password) {
        try {
            String connectCommand = "connect(" + login + " ," + password + ")";
            System.out.println("COMMAND: " + connectCommand);
            oos.writeUTF(connectCommand);
            oos.flush();
            Thread.sleep(100);
            String response = ois.readUTF();
            System.out.println(response);
            return response;
        } catch (Exception e) {
            System.err.println(e);
        }
        return "not connected";
    }

    public VodData read(int uid) {
        try {
            String readCommand = "read( " + uid + " )";
            System.out.println("COMMAND: " + readCommand);
            oos.writeUTF(readCommand);
            oos.flush();
            Thread.sleep(100);
            String response = ois.readUTF();
            System.out.println(response);
            if (response != null && !response.isEmpty()) {
                return new VodData(response.split(",")[0].substring(5), response.split(",")[1].substring(1, response.split(",")[1].indexOf(")")));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return new VodData("OFF", "std");
    }

    public String disconnect() {
        try {
            String disconnectCommand = "disconnect()";
            System.out.println("COMMAND: " + disconnectCommand);
            oos.writeUTF(disconnectCommand);
            oos.flush();
            Thread.sleep(100);
            String response = ois.readUTF();
            System.out.println(response);
            return response;

        } catch (Exception e) {
        } finally {
            try {
                ois.close();
                oos.close();
                socket.close();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        return "disconnected()";
    }

}
