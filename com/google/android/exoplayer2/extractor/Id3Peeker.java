package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;

public final class Id3Peeker {
    private final ParsableByteArray scratch;

    public Id3Peeker() {
        this.scratch = new ParsableByteArray(10);
    }

    public Metadata peekId3Data(ExtractorInput extractorInput0, FramePredicate id3Decoder$FramePredicate0) {
        Metadata metadata0 = null;
        int v;
        for(v = 0; true; v += v2) {
            try {
                extractorInput0.peekFully(this.scratch.data, 0, 10);
            }
            catch(EOFException unused_ex) {
                break;
            }
            this.scratch.setPosition(0);
            if(this.scratch.readUnsignedInt24() != 4801587) {
                break;
            }
            this.scratch.skipBytes(3);
            int v1 = this.scratch.readSynchSafeInt();
            int v2 = v1 + 10;
            if(metadata0 == null) {
                byte[] arr_b = new byte[v2];
                System.arraycopy(this.scratch.data, 0, arr_b, 0, 10);
                extractorInput0.peekFully(arr_b, 10, v1);
                metadata0 = new Id3Decoder(id3Decoder$FramePredicate0).decode(arr_b, v2);
            }
            else {
                extractorInput0.advancePeekPosition(v1);
            }
        }
        extractorInput0.resetPeekPosition();
        extractorInput0.advancePeekPosition(v);
        return metadata0;
    }
}

