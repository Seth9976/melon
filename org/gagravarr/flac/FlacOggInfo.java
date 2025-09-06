package org.gagravarr.flac;

import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioInfoHeader;

public class FlacOggInfo extends FlacInfo implements OggAudioInfoHeader {
    private FlacFirstOggPacket parent;

    public FlacOggInfo() {
    }

    public FlacOggInfo(byte[] arr_b, int v, FlacFirstOggPacket flacFirstOggPacket0) {
        super(arr_b, v);
        this.parent = flacFirstOggPacket0;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioInfoHeader
    public String getVersionString() {
        return this.parent.getMajorVersion() + "." + this.parent.getMinorVersion();
    }

    @Override  // org.gagravarr.ogg.OggStreamPacket
    public void setData(byte[] arr_b) {
        throw new IllegalStateException("Not supported for FLAC");
    }

    public void setFlacFirstOggPacket(FlacFirstOggPacket flacFirstOggPacket0) {
        this.parent = flacFirstOggPacket0;
    }

    @Override  // org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        return this.parent.write();
    }
}

