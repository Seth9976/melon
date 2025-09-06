package org.gagravarr.flac;

public class FlacAudioFrame extends FlacFrame {
    private byte[] data;
    private long position;

    public FlacAudioFrame(byte[] arr_b) {
        this.data = arr_b;
    }

    @Override  // org.gagravarr.flac.FlacFrame
    public byte[] getData() {
        return this.data;
    }
}

