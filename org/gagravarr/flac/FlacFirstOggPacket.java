package org.gagravarr.flac;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class FlacFirstOggPacket extends HighLevelOggStreamPacket {
    private FlacOggInfo info;
    private int majorVersion;
    private int minorVersion;
    private int numberOfHeaderBlocks;

    public FlacFirstOggPacket() {
        this(new FlacOggInfo());
    }

    public FlacFirstOggPacket(FlacOggInfo flacOggInfo0) {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.numberOfHeaderBlocks = 0;
        this.info = flacOggInfo0;
        flacOggInfo0.setFlacFirstOggPacket(this);
    }

    public FlacFirstOggPacket(OggPacket oggPacket0) {
        super(oggPacket0);
        byte[] arr_b = this.getData();
        this.majorVersion = IOUtils.toInt(arr_b[5]);
        this.minorVersion = IOUtils.toInt(arr_b[6]);
        this.numberOfHeaderBlocks = IOUtils.getInt2BE(arr_b, 7);
        this.info = new FlacOggInfo(arr_b, 17, this);
    }

    public FlacOggInfo getInfo() {
        return this.info;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getNumberOfHeaderBlocks() {
        return this.numberOfHeaderBlocks;
    }

    private static boolean isFlacSpecial(OggPacket oggPacket0) {
        byte[] arr_b = oggPacket0.getData();
        return arr_b[0] == 0x7F && arr_b[1] == 70 && arr_b[2] == 76 && arr_b[3] == 65 && arr_b[4] == 67;
    }

    public static boolean isFlacStream(OggPacket oggPacket0) {
        return oggPacket0.isBeginningOfStream() ? FlacFirstOggPacket.isFlacSpecial(oggPacket0) : false;
    }

    public void setMajorVersion(int v) {
        if(v > 0xFF) {
            throw new IllegalArgumentException("Version numbers must be in the range 0-255");
        }
        this.majorVersion = v;
    }

    public void setMinorVersion(int v) {
        if(v > 0xFF) {
            throw new IllegalArgumentException("Version numbers must be in the range 0-255");
        }
        this.minorVersion = v;
    }

    public void setNumberOfHeaderBlocks(int v) {
        this.numberOfHeaderBlocks = v;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket
    public OggPacket write() {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream0.write("FLAC".getBytes("ASCII"));
            byteArrayOutputStream0.write(this.majorVersion);
            byteArrayOutputStream0.write(this.minorVersion);
            IOUtils.writeInt2BE(byteArrayOutputStream0, this.numberOfHeaderBlocks);
            byteArrayOutputStream0.write("fLaC".getBytes("ASCII"));
            byteArrayOutputStream0.write(this.info.getData());
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
        this.setData(byteArrayOutputStream0.toByteArray());
        return super.write();
    }
}

