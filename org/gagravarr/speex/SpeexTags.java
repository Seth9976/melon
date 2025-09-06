package org.gagravarr.speex;

import java.io.OutputStream;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;
import org.gagravarr.vorbis.VorbisStyleComments;

public class SpeexTags extends VorbisStyleComments implements OggAudioTagsHeader, SpeexPacket {
    public SpeexTags() {
    }

    public SpeexTags(OggPacket oggPacket0) {
        super(oggPacket0, 0);
        if(oggPacket0.getSequenceNumber() != 1 && oggPacket0.getGranulePosition() != 0L) {
            throw new IllegalArgumentException("Invalid packet details, not Speex Tags");
        }
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public int getHeaderSize() {
        return 0;
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataFooter(OutputStream outputStream0) {
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataHeader(byte[] arr_b, int v) {
    }
}

