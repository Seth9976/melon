package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class ScriptTagPayloadReader extends TagPayloadReader {
    private static final int AMF_TYPE_BOOLEAN = 1;
    private static final int AMF_TYPE_DATE = 11;
    private static final int AMF_TYPE_ECMA_ARRAY = 8;
    private static final int AMF_TYPE_END_MARKER = 9;
    private static final int AMF_TYPE_NUMBER = 0;
    private static final int AMF_TYPE_OBJECT = 3;
    private static final int AMF_TYPE_STRICT_ARRAY = 10;
    private static final int AMF_TYPE_STRING = 2;
    private static final String KEY_DURATION = "duration";
    private static final String NAME_METADATA = "onMetaData";
    private long durationUs;

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
        this.durationUs = 0x8000000000000001L;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(ParsableByteArray parsableByteArray0) {
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parsePayload(ParsableByteArray parsableByteArray0, long v) {
        if(ScriptTagPayloadReader.readAmfType(parsableByteArray0) != 2) {
            throw new ParserException();
        }
        if(!"onMetaData".equals(ScriptTagPayloadReader.readAmfString(parsableByteArray0))) {
            return false;
        }
        if(ScriptTagPayloadReader.readAmfType(parsableByteArray0) != 8) {
            return false;
        }
        HashMap hashMap0 = ScriptTagPayloadReader.readAmfEcmaArray(parsableByteArray0);
        if(hashMap0.containsKey("duration")) {
            double f = (double)(((Double)hashMap0.get("duration")));
            if(f > 0.0) {
                this.durationUs = (long)(f * 1000000.0);
            }
        }
        return false;
    }

    private static Boolean readAmfBoolean(ParsableByteArray parsableByteArray0) {
        return Boolean.valueOf(parsableByteArray0.readUnsignedByte() == 1);
    }

    private static Object readAmfData(ParsableByteArray parsableByteArray0, int v) {
        switch(v) {
            case 0: {
                return ScriptTagPayloadReader.readAmfDouble(parsableByteArray0);
            }
            case 1: {
                return ScriptTagPayloadReader.readAmfBoolean(parsableByteArray0);
            }
            case 2: {
                return ScriptTagPayloadReader.readAmfString(parsableByteArray0);
            }
            case 3: {
                return ScriptTagPayloadReader.readAmfObject(parsableByteArray0);
            }
            case 8: {
                return ScriptTagPayloadReader.readAmfEcmaArray(parsableByteArray0);
            }
            case 10: {
                return ScriptTagPayloadReader.readAmfStrictArray(parsableByteArray0);
            }
            case 11: {
                return ScriptTagPayloadReader.readAmfDate(parsableByteArray0);
            }
            default: {
                return null;
            }
        }
    }

    private static Date readAmfDate(ParsableByteArray parsableByteArray0) {
        Date date0 = new Date(((long)(((double)ScriptTagPayloadReader.readAmfDouble(parsableByteArray0)))));
        parsableByteArray0.skipBytes(2);
        return date0;
    }

    private static Double readAmfDouble(ParsableByteArray parsableByteArray0) {
        return Double.longBitsToDouble(parsableByteArray0.readLong());
    }

    private static HashMap readAmfEcmaArray(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedIntToInt();
        HashMap hashMap0 = new HashMap(v);
        for(int v1 = 0; v1 < v; ++v1) {
            String s = ScriptTagPayloadReader.readAmfString(parsableByteArray0);
            Object object0 = ScriptTagPayloadReader.readAmfData(parsableByteArray0, ScriptTagPayloadReader.readAmfType(parsableByteArray0));
            if(object0 != null) {
                hashMap0.put(s, object0);
            }
        }
        return hashMap0;
    }

    private static HashMap readAmfObject(ParsableByteArray parsableByteArray0) {
        HashMap hashMap0 = new HashMap();
        while(true) {
            String s = ScriptTagPayloadReader.readAmfString(parsableByteArray0);
            int v = ScriptTagPayloadReader.readAmfType(parsableByteArray0);
            if(v == 9) {
                break;
            }
            Object object0 = ScriptTagPayloadReader.readAmfData(parsableByteArray0, v);
            if(object0 != null) {
                hashMap0.put(s, object0);
            }
        }
        return hashMap0;
    }

    private static ArrayList readAmfStrictArray(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedIntToInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = ScriptTagPayloadReader.readAmfData(parsableByteArray0, ScriptTagPayloadReader.readAmfType(parsableByteArray0));
            if(object0 != null) {
                arrayList0.add(object0);
            }
        }
        return arrayList0;
    }

    private static String readAmfString(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedShort();
        parsableByteArray0.skipBytes(v);
        return new String(parsableByteArray0.data, parsableByteArray0.getPosition(), v);
    }

    private static int readAmfType(ParsableByteArray parsableByteArray0) {
        return parsableByteArray0.readUnsignedByte();
    }

    @Override  // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }
}

