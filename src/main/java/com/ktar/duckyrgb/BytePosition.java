package com.ktar.duckyrgb;

public class BytePosition {
    public int row, index;

    public BytePosition(int row, int index) {
        this.row = row;
        this.index = index;
    }

    @Override
    public String toString() {
        return row + "-" + index;
    }
}
