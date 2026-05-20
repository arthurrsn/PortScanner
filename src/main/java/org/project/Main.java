package org.project;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        final String host = InetAddress.getLocalHost().getHostAddress();
        final int totalPorts = 65535;

        System.out.println("Start scanning on: " + host);

        for (int port = 0; port <= totalPorts; port++) {
            printProgress(port, totalPorts);

            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 200);

                System.out.print("\r\033[K");
                System.out.println("[+] Port " + port + " is OPEN");
                socket.close();
                socket = null;
            } catch (Exception ignored){}
        }
    }
    private static void printProgress(int current, int totalPorts) {
        int progressPercent = (int) (((double) current / totalPorts) * 100);
        int barLength = 30;
        int completedBars = (int) (((double) current / totalPorts) * barLength);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < completedBars) {
                bar.append("=");
            } else {
                bar.append(" ");
            }
        }
        bar.append("]");

        System.out.print("\r" + bar + " " + progressPercent + "% (Porta: " + current + "/" + totalPorts+ ")");
    }
}