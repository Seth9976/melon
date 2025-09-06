package org.gagravarr.flac;

import java.io.OutputStream;

public class FlacUnhandledMetadataBlock extends FlacMetadataBlock {
    private byte[] data;

    public FlacUnhandledMetadataBlock(byte b, byte[] arr_b) {
        super(b);
        this.data = arr_b;
    }

    @Override  // org.gagravarr.flac.FlacMetadataBlock
    public void write(OutputStream outputStream0) {
        outputStream0.write(this.data);
    }
}

