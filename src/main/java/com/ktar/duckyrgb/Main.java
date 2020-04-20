package com.ktar.duckyrgb;

import org.hid4java.HidDevice;
import org.hid4java.HidManager;
import org.hid4java.HidServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        HidDevice duckyDevice = null;
        HidServices hidServices = HidManager.getHidServices();

        for (HidDevice device : hidServices.getAttachedHidDevices()) {
            if (device.getPath().contains("vid_04d9&pid_0356&mi_01")) {
                System.out.println(device.getManufacturer());
                duckyDevice = device;
                break;
            }
        }

        if (duckyDevice == null) {
            System.out.println("Ducky Device was null, closing program");
            return;
        }

        duckyDevice.open();
        sendCommandFromFile(duckyDevice, "open.txt");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Is it open? " + duckyDevice.isOpen());

        DuckyDevice duckyDevice1 = new DuckyDevice(duckyDevice);
        System.out.println("Setting backspace to white");
        duckyDevice1.setColor(Keys.Backspace, (byte) 255, (byte) 255, (byte) 255);
        duckyDevice1.ApplyColors();

        sendCommandFromFile(duckyDevice, "close.txt");
    }

    private static void sendCommandFromFile(HidDevice device, String filename) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/" + filename)));
            String line = reader.readLine();
            while (line != null) {
                //Convert the file string to a byte array
                byte[] s = hexStringToByteArray(line.trim().replace(" ", ""));
                //Get rid of first 00 byte, because that's just the way it is in the program
                for (int i = 0; i < s.length - 1; i++) {
                    s[i] = s[i + 1];
                }
                device.write(s, s.length, (byte) -1);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

}
