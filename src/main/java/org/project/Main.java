package org.project;


import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        final String host ="2775ARTHURNASCIMENTO";
        final int totalPorts = 10;
        final int timeoutMs = 200;

        System.out.println("Start scanning on: " + host)a;
        for (int port = 0; port <= totalPorts; port++) {
            printProgress(port, totalPorts);
            try {
                Socket socket = new Socket(host, port);
                socket.connect(new InetSocketAddress(host, port), timeoutMs);

                System.out.print("\r\033[K");
                System.out.println("[+] Port " + port + " is OPEN");
                socket.close();
            } catch (Exception ignored){}
        }
    }
    private static void printProgress(int current, int totalPorts) {
        int progressPercent = (int) (((double) current / 10) * 100);
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

        System.out.print("\r" + bar + " " + progressPercent + "% (Porta: " + current + "/" + 65535 + ")");
    }
}