package org.gagravarr.flac;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.gagravarr.ogg.IOUtils;

public abstract class FlacMetadataBlock extends FlacFrame {
    public static final byte APPLICATION = 2;
    public static final byte CUESHEET = 5;
    public static final byte PADDING = 1;
    public static final byte PICTURE = 6;
    public static final byte SEEKTABLE = 3;
    public static final byte STREAMINFO = 0;
    public static final byte VORBIS_COMMENT = 4;
    private byte type;

    public FlacMetadataBlock(byte b) {
        this.type = b;
    }

    public static FlacMetadataBlock create(InputStream inputStream0) {
        int v = inputStream0.read();
        if(v != -1) {
            int v1 = IOUtils.fromInt(v);
            byte[] arr_b = new byte[3];
            IOUtils.readFully(inputStream0, arr_b);
            byte[] arr_b1 = new byte[((int)IOUtils.getInt3BE(arr_b))];
            IOUtils.readFully(inputStream0, arr_b1);
            switch(v1) {
                case 0: {
                    return new FlacInfo(arr_b1, 0);
                }
                case 4: {
                    return new FlacTagsAsMetadata(arr_b1);
                }
                default: {
                    return new FlacUnhandledMetadataBlock(((byte)v1), arr_b1);
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override  // org.gagravarr.flac.FlacFrame
    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream0.write(((int)this.type));
            byteArrayOutputStream0.write(new byte[3]);
            this.write(byteArrayOutputStream0);
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
        byte[] arr_b = byteArrayOutputStream0.toByteArray();
        IOUtils.putInt3BE(arr_b, 1, ((long)arr_b.length));
        return arr_b;
    }

    public int getType() {
        return this.type & 0x7F;
    }

    public boolean isLastMetadataBlock() {
        return this.type < 0;
    }

    public abstract void write(OutputStream arg1);
}

