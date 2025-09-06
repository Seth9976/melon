package org.gagravarr.ogg;

public abstract class HighLevelOggStreamPacket implements OggStreamPacket {
    private byte[] data;
    private OggPacket oggPacket;

    public HighLevelOggStreamPacket() {
        this.oggPacket = null;
    }

    public HighLevelOggStreamPacket(OggPacket oggPacket0) {
        this.oggPacket = oggPacket0;
    }

    @Override  // org.gagravarr.ogg.OggStreamPacket
    public byte[] getData() {
        byte[] arr_b = this.data;
        if(arr_b != null) {
            return arr_b;
        }
        return this.oggPacket == null ? null : this.oggPacket.getData();
    }

    public OggPacket getOggPacket() {
        return this.oggPacket;
    }

    @Override  // org.gagravarr.ogg.OggStreamPacket
    public void setData(byte[] arr_b) {
        this.data = arr_b;
    }

    @Override  // org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        OggPacket oggPacket0 = new OggPacket(this.getData());
        this.oggPacket = oggPacket0;
        return oggPacket0;
    }
}

