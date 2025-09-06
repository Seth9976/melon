package org.gagravarr.theora;

import java.io.OutputStream;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.vorbis.VorbisStyleComments;

public class TheoraComments extends VorbisStyleComments implements TheoraPacket {
    public TheoraComments() {
    }

    public TheoraComments(OggPacket oggPacket0) {
        super(oggPacket0, 7);
        if(this.getData()[0] != 0xFFFFFF81) {
            throw new IllegalArgumentException("Invalid type, not a Theora Commetns");
        }
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public int getHeaderSize() {
        return 8;
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataFooter(OutputStream outputStream0) {
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataHeader(byte[] arr_b, int v) {
        TheoraPacketFactory.populateMetadataHeader(arr_b, 0x81, v);
    }
}

