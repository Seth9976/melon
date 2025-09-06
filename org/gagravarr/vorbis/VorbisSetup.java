package org.gagravarr.vorbis;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioSetupHeader;

public class VorbisSetup extends HighLevelOggStreamPacket implements OggAudioSetupHeader, VorbisPacket {
    public VorbisSetup() {
    }

    public VorbisSetup(OggPacket oggPacket0) {
        super(oggPacket0);
    }

    @Override  // org.gagravarr.vorbis.VorbisPacket
    public int getHeaderSize() {
        return 7;
    }

    public int getNumberOfCodebooks() {
        byte[] arr_b = this.getData();
        return arr_b == null || arr_b.length < 10 ? 0 : IOUtils.toInt(arr_b[8]) + 1;
    }

    @Override  // org.gagravarr.vorbis.VorbisPacket
    public void populateMetadataHeader(byte[] arr_b, int v) {
        VorbisPacketFactory.populateMetadataHeader(arr_b, 5, v);
    }
}

