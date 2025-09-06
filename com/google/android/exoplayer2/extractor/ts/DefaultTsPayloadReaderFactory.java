package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.cea.Cea708InitializationData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements Factory {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 0x86;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 0x40;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 0x20;
    private final List closedCaptionFormats;
    private final int flags;

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int v) {
        this(v, Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null)));
    }

    public DefaultTsPayloadReaderFactory(int v, List list0) {
        this.flags = v;
        this.closedCaptionFormats = list0;
    }

    private SeiReader buildSeiReader(EsInfo tsPayloadReader$EsInfo0) {
        return new SeiReader(this.getClosedCaptionFormats(tsPayloadReader$EsInfo0));
    }

    private UserDataReader buildUserDataReader(EsInfo tsPayloadReader$EsInfo0) {
        return new UserDataReader(this.getClosedCaptionFormats(tsPayloadReader$EsInfo0));
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader$Factory
    public SparseArray createInitialPayloadReaders() {
        return new SparseArray();
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader$Factory
    public TsPayloadReader createPayloadReader(int v, EsInfo tsPayloadReader$EsInfo0) {
        switch(v) {
            case 2: {
                return new PesReader(new H262Reader(this.buildUserDataReader(tsPayloadReader$EsInfo0)));
            }
            case 3: 
            case 4: {
                return new PesReader(new MpegAudioReader(tsPayloadReader$EsInfo0.language));
            }
            case 15: {
                return this.isSet(2) ? null : new PesReader(new AdtsReader(false, tsPayloadReader$EsInfo0.language));
            }
            case 17: {
                return this.isSet(2) ? null : new PesReader(new LatmReader(tsPayloadReader$EsInfo0.language));
            }
            case 21: {
                return new PesReader(new Id3Reader());
            }
            case 27: {
                return this.isSet(4) ? null : new PesReader(new H264Reader(this.buildSeiReader(tsPayloadReader$EsInfo0), this.isSet(1), this.isSet(8)));
            }
            case 36: {
                return new PesReader(new H265Reader(this.buildSeiReader(tsPayloadReader$EsInfo0)));
            }
            case 89: {
                return new PesReader(new DvbSubtitleReader(tsPayloadReader$EsInfo0.dvbSubtitleInfos));
            }
            case 130: {
                if(!this.isSet(0x40)) {
                    return null;
                }
                break;
            }
            case 0x86: {
                return this.isSet(16) ? null : new SectionReader(new SpliceInfoSectionReader());
            }
            case 0x81: 
            case 0x87: {
                return new PesReader(new Ac3Reader(tsPayloadReader$EsInfo0.language));
            }
            case 0x8A: {
                break;
            }
            case 0xAC: {
                return new PesReader(new Ac4Reader(tsPayloadReader$EsInfo0.language));
            }
            default: {
                return null;
            }
        }
        return new PesReader(new DtsReader(tsPayloadReader$EsInfo0.language));
    }

    private List getClosedCaptionFormats(EsInfo tsPayloadReader$EsInfo0) {
        List list1;
        int v6;
        String s1;
        if(this.isSet(0x20)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(tsPayloadReader$EsInfo0.descriptorBytes);
        List list0 = this.closedCaptionFormats;
        while(parsableByteArray0.bytesLeft() > 0) {
            int v = parsableByteArray0.readUnsignedByte();
            int v1 = parsableByteArray0.readUnsignedByte();
            int v2 = parsableByteArray0.getPosition();
            if(v == 0x86) {
                list0 = new ArrayList();
                int v3 = parsableByteArray0.readUnsignedByte();
                for(int v4 = 0; v4 < (v3 & 0x1F); ++v4) {
                    String s = parsableByteArray0.readString(3);
                    int v5 = parsableByteArray0.readUnsignedByte();
                    boolean z = true;
                    boolean z1 = (v5 & 0x80) != 0;
                    if(z1) {
                        s1 = "application/cea-708";
                        v6 = v5 & 0x3F;
                    }
                    else {
                        s1 = "application/cea-608";
                        v6 = 1;
                    }
                    int v7 = (byte)parsableByteArray0.readUnsignedByte();
                    parsableByteArray0.skipBytes(1);
                    if(z1) {
                        if((v7 & 0x40) == 0) {
                            z = false;
                        }
                        list1 = Cea708InitializationData.buildData(z);
                    }
                    else {
                        list1 = null;
                    }
                    ((ArrayList)list0).add(Format.createTextSampleFormat(null, s1, null, -1, 0, s, v6, null, 0x7FFFFFFFFFFFFFFFL, list1));
                }
            }
            parsableByteArray0.setPosition(v2 + v1);
        }
        return list0;
    }

    private boolean isSet(int v) {
        return (v & this.flags) != 0;
    }
}

