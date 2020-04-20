package com.ktar.duckyrgb;

import org.hid4java.HidDevice;

import java.util.ArrayList;
import java.util.List;

public class DuckyDevice {

    private HidDevice device;

    private byte[][] currentReport;

    public DuckyDevice(HidDevice device){
        this.device = device;

        List<byte[]> list = new ArrayList<>();
        byte[] openRequest = new byte[65];
        openRequest[1] = 0x56;
        openRequest[2] = (byte) 0x81;
        openRequest[5] = 0x01;
        openRequest[9] = 0x07;
        openRequest[13] = (byte) 0xAA;
        openRequest[14] = (byte) 0xAA;
        openRequest[15] = (byte) 0xAA;
        openRequest[16] = (byte) 0xAA;
        list.add(openRequest);


        List<byte[]> colorRequests = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            byte[] request = new byte[65];
            request[1] = 0x56;
            request[2] = (byte) 0x83;
            request[3] = (byte) (((byte) i) & 0xFF);
            colorRequests.add(request);
        }

        colorRequests.get(0)[5] = 0x01;
        colorRequests.get(0)[9] = (byte) 0x80;
        colorRequests.get(0)[10] = 0x01;
        colorRequests.get(0)[12] = (byte) 0xC1;
        colorRequests.get(0)[17] = (byte) 0xFF;
        colorRequests.get(0)[18] = (byte) 0xFF;
        colorRequests.get(0)[19] = (byte) 0xFF;
        colorRequests.get(0)[20] = (byte) 0xFF;

        list.addAll(colorRequests);

        byte[] closeRequest = new byte[65];
        closeRequest[1] = 0x51;
        closeRequest[2] = 0x28;
        closeRequest[5] = (byte) 0xFF;
        list.add(closeRequest);

        currentReport = list.toArray(new byte[][]{});

        setColor(Keys.A, (byte) 253, (byte) 0, (byte) 0);
        ApplyColors();
    }

    public boolean setColor(String key, byte red, byte green, byte blue){
        BytePosition[] bytePositions = KeyMapping.getBytePositions(key);
        if(bytePositions == null){
            System.out.println("null");
        }
        if(isEmpty(bytePositions)){
            return false;
        }

        setRGB(bytePositions[0], red);
        setRGB(bytePositions[1], green);
        setRGB(bytePositions[2], blue);

        return true;
    }

    public void setRGB(BytePosition position, byte value){
        currentReport[position.row + 1][position.index] = value;
    }

    public boolean isEmpty(BytePosition[] positions){
        for (BytePosition bytePosition : positions) {
            if(bytePosition != null){
                return false;
            }
        }
        return true;
    }

    public void ApplyColors() {
        for (byte[] bytes : currentReport) {
            device.write(bytes, bytes.length, (byte) 12);
        }
    }

}
