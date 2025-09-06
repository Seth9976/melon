package org.gagravarr.ogg;

public class OggPacketData {
    private byte[] data;

    public OggPacketData(byte[] arr_b) {
        this.data = arr_b;
    }

    public byte[] getData() {
        return this.data;
    }
}

