package org.gagravarr.vorbis;

import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggStreamAudioData;

public class VorbisAudioData extends OggStreamAudioData implements VorbisPacket {
    public VorbisAudioData(OggPacket oggPacket0) {
        super(oggPacket0);
    }

    public VorbisAudioData(byte[] arr_b) {
        super(arr_b);
    }

    @Override  // org.gagravarr.vorbis.VorbisPacket
    public int getHeaderSize() {
        return 0;
    }

    @Override  // org.gagravarr.vorbis.VorbisPacket
    public void populateMetadataHeader(byte[] arr_b, int v) {
        throw new IllegalStateException("Audio Data packets don\'t have Metadata Headers");
    }
}

