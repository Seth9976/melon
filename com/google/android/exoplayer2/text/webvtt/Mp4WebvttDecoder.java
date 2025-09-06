package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    private static final int BOX_HEADER_SIZE = 8;
    private static final int TYPE_payl = 0x7061796C;
    private static final int TYPE_sttg = 1937011815;
    private static final int TYPE_vttc = 0x76747463;
    private final Builder builder;
    private final ParsableByteArray sampleData;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.sampleData = new ParsableByteArray();
        this.builder = new Builder();
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        this.sampleData.reset(arr_b, v);
        ArrayList arrayList0 = new ArrayList();
        while(this.sampleData.bytesLeft() > 0) {
            if(this.sampleData.bytesLeft() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int v1 = this.sampleData.readInt();
            if(this.sampleData.readInt() == 0x76747463) {
                arrayList0.add(Mp4WebvttDecoder.parseVttCueBox(this.sampleData, this.builder, v1 - 8));
            }
            else {
                this.sampleData.skipBytes(v1 - 8);
            }
        }
        return new Mp4WebvttSubtitle(arrayList0);
    }

    private static Cue parseVttCueBox(ParsableByteArray parsableByteArray0, Builder webvttCue$Builder0, int v) {
        webvttCue$Builder0.reset();
        while(v > 0) {
            if(v < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int v1 = parsableByteArray0.readInt();
            int v2 = parsableByteArray0.readInt();
            String s = Util.fromUtf8Bytes(parsableByteArray0.data, parsableByteArray0.getPosition(), v1 - 8);
            parsableByteArray0.skipBytes(v1 - 8);
            v = v - 8 - (v1 - 8);
            if(v2 == 1937011815) {
                WebvttCueParser.parseCueSettingsList(s, webvttCue$Builder0);
            }
            else if(v2 == 0x7061796C) {
                WebvttCueParser.parseCueText(null, s.trim(), webvttCue$Builder0, Collections.EMPTY_LIST);
            }
        }
        return webvttCue$Builder0.build();
    }
}

