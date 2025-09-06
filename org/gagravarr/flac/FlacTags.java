package org.gagravarr.flac;

import java.io.OutputStream;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;
import org.gagravarr.vorbis.VorbisStyleComments;

public class FlacTags extends VorbisStyleComments implements OggAudioTagsHeader {
    public static class FlacTagsAsMetadata extends FlacMetadataBlock {
        private FlacTags tags;

        public FlacTagsAsMetadata(byte[] arr_b) {
            super(4);
            byte[] arr_b1 = new byte[arr_b.length + 4];
            arr_b1[0] = 4;
            System.arraycopy(arr_b, 0, arr_b1, 4, arr_b.length);
            this.tags = new FlacTags(new OggPacket(arr_b1));
        }

        @Override  // org.gagravarr.flac.FlacMetadataBlock
        public byte[] getData() {
            return this.tags.getData();
        }

        public FlacTags getTags() {
            return this.tags;
        }

        @Override  // org.gagravarr.flac.FlacMetadataBlock
        public void write(OutputStream outputStream0) {
            throw new IllegalStateException("Must not call directly");
        }
    }

    public FlacTags() {
    }

    public FlacTags(OggPacket oggPacket0) {
        super(oggPacket0, 4);
        int v = this.getData()[0];
        if(v != 4) {
            throw new IllegalArgumentException("Invalid type " + v);
        }
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public int getHeaderSize() {
        return 4;
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataFooter(OutputStream outputStream0) {
    }

    @Override  // org.gagravarr.vorbis.VorbisStyleComments
    public void populateMetadataHeader(byte[] arr_b, int v) {
        arr_b[0] = 4;
        IOUtils.putInt3BE(arr_b, 1, ((long)v));
    }
}

