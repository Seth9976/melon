package org.gagravarr.opus;

import java.io.OutputStream;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;
import org.gagravarr.vorbis.VorbisStyleComments;

public class OpusTags extends VorbisStyleComments implements OggAudioTagsHeader, OpusPacket {
    public OpusTags() {
    }

    public OpusTags(OggPacket oggPacket0) {
        super(oggPacket0, OpusPacket.MAGIC_TAGS_BYTES.length);
        byte[] arr_b = this.getData();
        if(!IOUtils.byteRangeMatches(OpusPacket.MAGIC_TAGS_BYTES, arr_b, 0)) {
            throw new IllegalArgumentException("Invalid type, not a Opus Header");
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
        System.arraycopy(OpusPacket.MAGIC_TAGS_BYTES, 0, arr_b, 0, OpusPacket.MAGIC_TAGS_BYTES.length);
    }
}

