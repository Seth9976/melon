package org.gagravarr.ogg;

public class OggPacket extends OggPacketData {
    private boolean bos;
    private boolean eos;
    private OggPage parent;

    public OggPacket(OggPage oggPage0, byte[] arr_b, boolean z, boolean z1) {
        super(arr_b);
        this.parent = oggPage0;
        this.bos = z;
        this.eos = z1;
    }

    public OggPacket(byte[] arr_b) {
        super(arr_b);
    }

    public OggPage _getParent() {
        return this.parent;
    }

    public long getGranulePosition() {
        return this.parent.getGranulePosition();
    }

    public int getSequenceNumber() {
        return this.parent.getSequenceNumber();
    }

    public int getSid() {
        return this.parent.getSid();
    }

    public boolean isBeginningOfStream() {
        return this.bos;
    }

    public boolean isEndOfStream() {
        return this.eos;
    }

    public void setIsBOS() {
        this.bos = true;
    }

    public void setIsEOS() {
        this.eos = true;
    }

    public void setParent(OggPage oggPage0) {
        this.parent = oggPage0;
    }
}

