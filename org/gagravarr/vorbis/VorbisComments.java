package org.gagravarr.vorbis;

import java.io.IOException;
import java.io.OutputStream;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;

public class VorbisComments extends VorbisStyleComments implements OggAudioTagsHeader, VorbisPacket {
    public VorbisComments() {
    }

    public VorbisComments(OggPacket oggPacket0) {
        super(oggPacket0, 7);
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments, org.gagravarr.vorbis.VorbisPacket
    public int getHeaderSize() {
        return 7;
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataFooter(OutputStream outputStream0) {
        try {
            outputStream0.write(1);
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments, org.gagravarr.vorbis.VorbisPacket
    public void populateMetadataHeader(byte[] arr_b, int v) {
        VorbisPacketFactory.populateMetadataHeader(arr_b, 3, v);
    }
}

