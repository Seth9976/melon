package org.gagravarr.ogg;

public class OggStreamAudioVisualData extends HighLevelOggStreamPacket {
    protected long granulePosition;

    public OggStreamAudioVisualData(OggPacket oggPacket0) {
        super(oggPacket0);
        this.granulePosition = oggPacket0.getGranulePosition();
    }

    public OggStreamAudioVisualData(byte[] arr_b) {
        this.setData(arr_b);
        this.granulePosition = -1L;
    }

    public long getGranulePosition() {
        return this.granulePosition;
    }

    public void setGranulePosition(long v) {
        this.granulePosition = v;
    }
}

