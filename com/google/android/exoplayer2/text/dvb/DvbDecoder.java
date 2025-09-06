package com.google.android.exoplayer2.text.dvb;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class DvbDecoder extends SimpleSubtitleDecoder {
    private final DvbParser parser;

    public DvbDecoder(List list0) {
        super("DvbDecoder");
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(((byte[])list0.get(0)));
        this.parser = new DvbParser(parsableByteArray0.readUnsignedShort(), parsableByteArray0.readUnsignedShort());
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        if(z) {
            this.parser.reset();
        }
        return new DvbSubtitle(this.parser.decode(arr_b, v));
    }
}

