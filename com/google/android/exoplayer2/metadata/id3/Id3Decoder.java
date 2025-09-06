package com.google.android.exoplayer2.metadata.id3;

import b3.Z;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public final class Id3Decoder implements MetadataDecoder {
    public interface FramePredicate {
        boolean evaluate(int arg1, int arg2, int arg3, int arg4, int arg5);
    }

    static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int v, boolean z, int v1) {
            this.majorVersion = v;
            this.isUnsynchronized = z;
            this.framesSize = v1;
        }

        public static int access$000(Id3Header id3Decoder$Id3Header0) {
            return id3Decoder$Id3Header0.majorVersion;
        }

        public static int access$100(Id3Header id3Decoder$Id3Header0) {
            return id3Decoder$Id3Header0.framesSize;
        }

        public static boolean access$200(Id3Header id3Decoder$Id3Header0) {
            return id3Decoder$Id3Header0.isUnsynchronized;
        }
    }

    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 0x20;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 0x80;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 0x40;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 0x40;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 4801587;
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final FramePredicate NO_FRAMES_PREDICATE = null;
    private static final String TAG = "Id3Decoder";
    private final FramePredicate framePredicate;

    static {
        Id3Decoder.NO_FRAMES_PREDICATE = new b(27);
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(FramePredicate id3Decoder$FramePredicate0) {
        this.framePredicate = id3Decoder$FramePredicate0;
    }

    public static boolean a(int v, int v1, int v2, int v3, int v4) {
        return false;
    }

    private static byte[] copyOfRangeIfValid(byte[] arr_b, int v, int v1) {
        return v1 > v ? Arrays.copyOfRange(arr_b, v, v1) : Util.EMPTY_BYTE_ARRAY;
    }

    @Override  // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer0) {
        ByteBuffer byteBuffer0 = (ByteBuffer)Assertions.checkNotNull(metadataInputBuffer0.data);
        return this.decode(byteBuffer0.array(), byteBuffer0.limit());
    }

    public Metadata decode(byte[] arr_b, int v) {
        ArrayList arrayList0 = new ArrayList();
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b, v);
        Id3Header id3Decoder$Id3Header0 = Id3Decoder.decodeHeader(parsableByteArray0);
        if(id3Decoder$Id3Header0 == null) {
            return null;
        }
        int v1 = Id3Header.access$000(id3Decoder$Id3Header0) == 2 ? 6 : 10;
        parsableByteArray0.setLimit(parsableByteArray0.getPosition() + (Id3Header.access$200(id3Decoder$Id3Header0) ? Id3Decoder.removeUnsynchronization(parsableByteArray0, Id3Header.access$100(id3Decoder$Id3Header0)) : Id3Header.access$100(id3Decoder$Id3Header0)));
        boolean z = false;
        if(!Id3Decoder.validateFrames(parsableByteArray0, Id3Header.access$000(id3Decoder$Id3Header0), v1, false)) {
            if(Id3Header.access$000(id3Decoder$Id3Header0) == 4 && Id3Decoder.validateFrames(parsableByteArray0, 4, v1, true)) {
                z = true;
                goto label_14;
            }
            Z.q(56, Id3Header.access$000(id3Decoder$Id3Header0), "Failed to validate ID3 tag with majorVersion=", "Id3Decoder");
            return null;
        }
    label_14:
        while(parsableByteArray0.bytesLeft() >= v1) {
            Id3Frame id3Frame0 = Id3Decoder.decodeFrame(Id3Header.access$000(id3Decoder$Id3Header0), parsableByteArray0, z, v1, this.framePredicate);
            if(id3Frame0 != null) {
                arrayList0.add(id3Frame0);
            }
        }
        return new Metadata(arrayList0);
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray0, int v, int v1) {
        int v3;
        String s2;
        int v2 = parsableByteArray0.readUnsignedByte();
        String s = Id3Decoder.getCharsetName(v2);
        byte[] arr_b = new byte[v - 1];
        parsableByteArray0.readBytes(arr_b, 0, v - 1);
        if(v1 == 2) {
            String s1 = Util.toLowerInvariant(new String(arr_b, 0, 3, "ISO-8859-1"));
            s2 = s1.length() == 0 ? new String("image/") : "image/" + s1;
            if("image/jpg".equals(s2)) {
                s2 = "image/jpeg";
            }
            v3 = 2;
        }
        else {
            v3 = Id3Decoder.indexOfZeroByte(arr_b, 0);
            s2 = Util.toLowerInvariant(new String(arr_b, 0, v3, "ISO-8859-1"));
            if(s2.indexOf(0x2F) == -1) {
                s2 = s2.length() == 0 ? new String("image/") : "image/" + s2;
            }
        }
        int v4 = arr_b[v3 + 1] & 0xFF;
        int v5 = Id3Decoder.indexOfEos(arr_b, v3 + 2, v2);
        return new ApicFrame(s2, new String(arr_b, v3 + 2, v5 - (v3 + 2), s), v4, Id3Decoder.copyOfRangeIfValid(arr_b, v5 + Id3Decoder.delimiterLength(v2), v - 1));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray0, int v, String s) {
        byte[] arr_b = new byte[v];
        parsableByteArray0.readBytes(arr_b, 0, v);
        return new BinaryFrame(s, arr_b);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray0, int v, int v1, boolean z, int v2, FramePredicate id3Decoder$FramePredicate0) {
        int v3 = parsableByteArray0.getPosition();
        int v4 = Id3Decoder.indexOfZeroByte(parsableByteArray0.data, v3);
        String s = new String(parsableByteArray0.data, v3, v4 - v3, "ISO-8859-1");
        parsableByteArray0.setPosition(v4 + 1);
        int v5 = parsableByteArray0.readInt();
        int v6 = parsableByteArray0.readInt();
        long v7 = parsableByteArray0.readUnsignedInt();
        if(Long.compare(v7, 0xFFFFFFFFL) == 0) {
            v7 = -1L;
        }
        long v8 = parsableByteArray0.readUnsignedInt();
        ArrayList arrayList0 = new ArrayList();
        while(parsableByteArray0.getPosition() < v3 + v) {
            Id3Frame id3Frame0 = Id3Decoder.decodeFrame(v1, parsableByteArray0, z, v2, id3Decoder$FramePredicate0);
            if(id3Frame0 != null) {
                arrayList0.add(id3Frame0);
            }
        }
        Id3Frame[] arr_id3Frame = new Id3Frame[arrayList0.size()];
        arrayList0.toArray(arr_id3Frame);
        return new ChapterFrame(s, v5, v6, v7, (v8 == 0xFFFFFFFFL ? -1L : v8), arr_id3Frame);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray0, int v, int v1, boolean z, int v2, FramePredicate id3Decoder$FramePredicate0) {
        int v3 = parsableByteArray0.getPosition();
        int v4 = Id3Decoder.indexOfZeroByte(parsableByteArray0.data, v3);
        String s = new String(parsableByteArray0.data, v3, v4 - v3, "ISO-8859-1");
        parsableByteArray0.setPosition(v4 + 1);
        int v5 = parsableByteArray0.readUnsignedByte();
        int v7 = parsableByteArray0.readUnsignedByte();
        String[] arr_s = new String[v7];
        for(int v6 = 0; v6 < v7; ++v6) {
            int v8 = parsableByteArray0.getPosition();
            int v9 = Id3Decoder.indexOfZeroByte(parsableByteArray0.data, v8);
            arr_s[v6] = new String(parsableByteArray0.data, v8, v9 - v8, "ISO-8859-1");
            parsableByteArray0.setPosition(v9 + 1);
        }
        ArrayList arrayList0 = new ArrayList();
        while(parsableByteArray0.getPosition() < v3 + v) {
            Id3Frame id3Frame0 = Id3Decoder.decodeFrame(v1, parsableByteArray0, z, v2, id3Decoder$FramePredicate0);
            if(id3Frame0 != null) {
                arrayList0.add(id3Frame0);
            }
        }
        Id3Frame[] arr_id3Frame = new Id3Frame[arrayList0.size()];
        arrayList0.toArray(arr_id3Frame);
        return new ChapterTocFrame(s, (v5 & 2) != 0, (v5 & 1) != 0, arr_s, arr_id3Frame);
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray0, int v) {
        if(v < 4) {
            return null;
        }
        int v1 = parsableByteArray0.readUnsignedByte();
        String s = Id3Decoder.getCharsetName(v1);
        byte[] arr_b = new byte[3];
        parsableByteArray0.readBytes(arr_b, 0, 3);
        String s1 = new String(arr_b, 0, 3);
        byte[] arr_b1 = new byte[v - 4];
        parsableByteArray0.readBytes(arr_b1, 0, v - 4);
        int v2 = Id3Decoder.indexOfEos(arr_b1, 0, v1);
        int v3 = v2 + Id3Decoder.delimiterLength(v1);
        return new CommentFrame(s1, new String(arr_b1, 0, v2, s), Id3Decoder.decodeStringIfValid(arr_b1, v3, Id3Decoder.indexOfEos(arr_b1, v3, v1), s));
    }

    private static Id3Frame decodeFrame(int v, ParsableByteArray parsableByteArray0, boolean z, int v1, FramePredicate id3Decoder$FramePredicate0) {
        Id3Frame id3Frame0;
        int v15;
        int v14;
        boolean z1;
        int v13;
        int v12;
        int v11;
        int v7;
        int v2 = parsableByteArray0.readUnsignedByte();
        int v3 = parsableByteArray0.readUnsignedByte();
        int v4 = parsableByteArray0.readUnsignedByte();
        int v5 = 0;
        int v6 = v < 3 ? 0 : parsableByteArray0.readUnsignedByte();
        switch(v) {
            case 3: {
                v7 = parsableByteArray0.readUnsignedIntToInt();
                break;
            }
            case 4: {
                v7 = parsableByteArray0.readUnsignedIntToInt();
                if(!z) {
                    v7 = (v7 >> 24 & 0xFF) << 21 | (v7 & 0xFF | (v7 >> 8 & 0xFF) << 7 | (v7 >> 16 & 0xFF) << 14);
                }
                break;
            }
            default: {
                v7 = parsableByteArray0.readUnsignedInt24();
            }
        }
        int v8 = v7;
        int v9 = v < 3 ? 0 : parsableByteArray0.readUnsignedShort();
        if(v2 == 0 && v3 == 0 && v4 == 0 && v6 == 0 && v8 == 0 && v9 == 0) {
            parsableByteArray0.setPosition(parsableByteArray0.limit());
            return null;
        }
        int v10 = parsableByteArray0.getPosition() + v8;
        if(v10 > parsableByteArray0.limit()) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray0.setPosition(parsableByteArray0.limit());
            return null;
        }
        if(id3Decoder$FramePredicate0 != null && !id3Decoder$FramePredicate0.evaluate(v, v2, v3, v4, v6)) {
            parsableByteArray0.setPosition(v10);
            return null;
        }
        switch(v) {
            case 3: {
                v11 = (v9 & 0x80) == 0 ? 0 : 1;
                v13 = (v9 & 0x40) == 0 ? 0 : 1;
                v12 = (v9 & 0x20) == 0 ? 0 : 1;
                z1 = false;
                v5 = v11;
                break;
            }
            case 4: {
                z1 = (v9 & 2) != 0;
                if((v9 & 1) != 0) {
                    v5 = 1;
                }
                v12 = (v9 & 0x40) == 0 ? 0 : 1;
                v11 = v5;
                v5 = (v9 & 8) == 0 ? 0 : 1;
                v13 = (v9 & 4) == 0 ? 0 : 1;
                break;
            }
            default: {
                v11 = 0;
                v12 = 0;
                v13 = 0;
                z1 = false;
            }
        }
        if(v5 != 0 || v13 != 0) {
            Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            parsableByteArray0.setPosition(v10);
            return null;
        }
        if(v12 != 0) {
            --v8;
            parsableByteArray0.skipBytes(1);
        }
        if(v11 != 0) {
            v8 -= 4;
            parsableByteArray0.skipBytes(4);
        }
        if(z1) {
            v8 = Id3Decoder.removeUnsynchronization(parsableByteArray0, v8);
        }
        try {
            if(v2 == 84 && v3 == 88 && v4 == 88 && (v == 2 || v6 == 88)) {
                id3Frame0 = Id3Decoder.decodeTxxxFrame(parsableByteArray0, v8);
                v14 = v8;
                v15 = v6;
            }
            else if(v2 == 84) {
                id3Frame0 = Id3Decoder.decodeTextInformationFrame(parsableByteArray0, v8, Id3Decoder.getFrameId(v, 84, v3, v4, v6));
                v14 = v8;
                v15 = v6;
            }
            else if(v2 == 87 && v3 == 88 && v4 == 88 && (v == 2 || v6 == 88)) {
                id3Frame0 = Id3Decoder.decodeWxxxFrame(parsableByteArray0, v8);
                v14 = v8;
                v15 = v6;
            }
            else if(v2 == 87) {
                id3Frame0 = Id3Decoder.decodeUrlLinkFrame(parsableByteArray0, v8, Id3Decoder.getFrameId(v, 87, v3, v4, v6));
                v14 = v8;
                v15 = v6;
            }
            else if(v2 == 80 && v3 == 82 && v4 == 73 && v6 == 86) {
                id3Frame0 = Id3Decoder.decodePrivFrame(parsableByteArray0, v8);
                v14 = v8;
                v15 = v6;
            }
            else if(v2 == 71 && v3 == 69 && v4 == 0x4F && (v6 == 66 || v == 2)) {
                id3Frame0 = Id3Decoder.decodeGeobFrame(parsableByteArray0, v8);
                v14 = v8;
                v15 = v6;
            }
            else if(v != 2) {
                if(v2 == 65 && v3 == 80 && v4 == 73 && v6 == 67) {
                    id3Frame0 = Id3Decoder.decodeApicFrame(parsableByteArray0, v8, v);
                    v14 = v8;
                    v15 = v6;
                }
                else {
                label_68:
                    if(v2 == 67 && v3 == 0x4F && v4 == 77 && (v6 == 77 || v == 2)) {
                        id3Frame0 = Id3Decoder.decodeCommentFrame(parsableByteArray0, v8);
                        v14 = v8;
                        v15 = v6;
                    }
                    else if(v2 == 67 && v3 == 72 && v4 == 65 && v6 == 80) {
                        v14 = v8;
                        v15 = 80;
                        id3Frame0 = Id3Decoder.decodeChapterFrame(parsableByteArray0, v14, v, z, v1, id3Decoder$FramePredicate0);
                    }
                    else {
                        v14 = v8;
                        v15 = v6;
                        if(v2 == 67 && v3 == 84 && v4 == 0x4F && v15 == 67) {
                            id3Frame0 = Id3Decoder.decodeChapterTOCFrame(parsableByteArray0, v14, v, z, v1, id3Decoder$FramePredicate0);
                        }
                        else if(v2 == 77 && v3 == 76 && v4 == 76 && v15 == 84) {
                            id3Frame0 = Id3Decoder.decodeMlltFrame(parsableByteArray0, v14);
                        }
                        else {
                            id3Frame0 = Id3Decoder.decodeBinaryFrame(parsableByteArray0, v14, Id3Decoder.getFrameId(v, v2, v3, v4, v15));
                        }
                    }
                }
            }
            else if(v2 == 80 && v3 == 73 && v4 == 67) {
                id3Frame0 = Id3Decoder.decodeApicFrame(parsableByteArray0, v8, 2);
                v14 = v8;
                v15 = v6;
            }
            else {
                goto label_68;
            }
        }
        catch(UnsupportedEncodingException unused_ex) {
            goto label_106;
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v10);
            throw throwable0;
        }
        if(id3Frame0 == null) {
            try {
                try {
                    Log.w("Id3Decoder", "Failed to decode frame: id=" + Id3Decoder.getFrameId(v, v2, v3, v4, v15) + ", frameSize=" + v14);
                    goto label_111;
                }
                catch(UnsupportedEncodingException unused_ex) {
                }
            label_106:
                Log.w("Id3Decoder", "Unsupported character encoding");
            }
            catch(Throwable throwable0) {
                parsableByteArray0.setPosition(v10);
                throw throwable0;
            }
            parsableByteArray0.setPosition(v10);
            return null;
        }
    label_111:
        parsableByteArray0.setPosition(v10);
        return id3Frame0;
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray0, int v) {
        int v1 = parsableByteArray0.readUnsignedByte();
        String s = Id3Decoder.getCharsetName(v1);
        byte[] arr_b = new byte[v - 1];
        parsableByteArray0.readBytes(arr_b, 0, v - 1);
        int v2 = Id3Decoder.indexOfZeroByte(arr_b, 0);
        String s1 = new String(arr_b, 0, v2, "ISO-8859-1");
        int v3 = Id3Decoder.indexOfEos(arr_b, v2 + 1, v1);
        String s2 = Id3Decoder.decodeStringIfValid(arr_b, v2 + 1, v3, s);
        int v4 = v3 + Id3Decoder.delimiterLength(v1);
        int v5 = Id3Decoder.indexOfEos(arr_b, v4, v1);
        return new GeobFrame(s1, s2, Id3Decoder.decodeStringIfValid(arr_b, v4, v5, s), Id3Decoder.copyOfRangeIfValid(arr_b, v5 + Id3Decoder.delimiterLength(v1), v - 1));
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray0) {
        if(parsableByteArray0.bytesLeft() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int v = parsableByteArray0.readUnsignedInt24();
        if(v != 4801587) {
            String s = String.format("%06X", v);
            Log.w("Id3Decoder", (s.length() == 0 ? new String("Unexpected first three bytes of ID3 tag header: 0x") : "Unexpected first three bytes of ID3 tag header: 0x" + s));
            return null;
        }
        int v1 = parsableByteArray0.readUnsignedByte();
        boolean z = true;
        parsableByteArray0.skipBytes(1);
        int v2 = parsableByteArray0.readUnsignedByte();
        int v3 = parsableByteArray0.readSynchSafeInt();
        if(v1 != 2) {
            switch(v1) {
                case 3: {
                    if((v2 & 0x40) != 0) {
                        int v4 = parsableByteArray0.readInt();
                        parsableByteArray0.skipBytes(v4);
                        v3 -= v4 + 4;
                    }
                    break;
                }
                case 4: {
                    if((v2 & 0x40) != 0) {
                        int v5 = parsableByteArray0.readSynchSafeInt();
                        parsableByteArray0.skipBytes(v5 - 4);
                        v3 -= v5;
                    }
                    if((v2 & 16) != 0) {
                        v3 -= 10;
                    }
                    break;
                }
                default: {
                    Z.q(57, v1, "Skipped ID3 tag with unsupported majorVersion=", "Id3Decoder");
                    return null;
                }
            }
        }
        else if((v2 & 0x40) != 0) {
            Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
            return null;
        }
        if(v1 >= 4 || (v2 & 0x80) == 0) {
            z = false;
        }
        return new Id3Header(v1, z, v3);
    }

    private static MlltFrame decodeMlltFrame(ParsableByteArray parsableByteArray0, int v) {
        int v1 = parsableByteArray0.readUnsignedShort();
        int v2 = parsableByteArray0.readUnsignedInt24();
        int v3 = parsableByteArray0.readUnsignedInt24();
        int v4 = parsableByteArray0.readUnsignedByte();
        int v5 = parsableByteArray0.readUnsignedByte();
        ParsableBitArray parsableBitArray0 = new ParsableBitArray();
        parsableBitArray0.reset(parsableByteArray0);
        int v6 = (v - 10) * 8 / (v4 + v5);
        int[] arr_v = new int[v6];
        int[] arr_v1 = new int[v6];
        for(int v7 = 0; v7 < v6; ++v7) {
            int v8 = parsableBitArray0.readBits(v4);
            int v9 = parsableBitArray0.readBits(v5);
            arr_v[v7] = v8;
            arr_v1[v7] = v9;
        }
        return new MlltFrame(v1, v2, v3, arr_v, arr_v1);
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray0, int v) {
        byte[] arr_b = new byte[v];
        parsableByteArray0.readBytes(arr_b, 0, v);
        int v1 = Id3Decoder.indexOfZeroByte(arr_b, 0);
        return new PrivFrame(new String(arr_b, 0, v1, "ISO-8859-1"), Id3Decoder.copyOfRangeIfValid(arr_b, v1 + 1, v));
    }

    private static String decodeStringIfValid(byte[] arr_b, int v, int v1, String s) {
        return v1 <= v || v1 > arr_b.length ? "" : new String(arr_b, v, v1 - v, s);
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray0, int v, String s) {
        if(v < 1) {
            return null;
        }
        int v1 = parsableByteArray0.readUnsignedByte();
        byte[] arr_b = new byte[v - 1];
        parsableByteArray0.readBytes(arr_b, 0, v - 1);
        return new TextInformationFrame(s, null, new String(arr_b, 0, Id3Decoder.indexOfEos(arr_b, 0, v1), Id3Decoder.getCharsetName(v1)));
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray0, int v) {
        if(v < 1) {
            return null;
        }
        int v1 = parsableByteArray0.readUnsignedByte();
        String s = Id3Decoder.getCharsetName(v1);
        byte[] arr_b = new byte[v - 1];
        parsableByteArray0.readBytes(arr_b, 0, v - 1);
        int v2 = Id3Decoder.indexOfEos(arr_b, 0, v1);
        int v3 = v2 + Id3Decoder.delimiterLength(v1);
        return new TextInformationFrame("TXXX", new String(arr_b, 0, v2, s), Id3Decoder.decodeStringIfValid(arr_b, v3, Id3Decoder.indexOfEos(arr_b, v3, v1), s));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray0, int v, String s) {
        byte[] arr_b = new byte[v];
        parsableByteArray0.readBytes(arr_b, 0, v);
        return new UrlLinkFrame(s, null, new String(arr_b, 0, Id3Decoder.indexOfZeroByte(arr_b, 0), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray0, int v) {
        if(v < 1) {
            return null;
        }
        int v1 = parsableByteArray0.readUnsignedByte();
        byte[] arr_b = new byte[v - 1];
        parsableByteArray0.readBytes(arr_b, 0, v - 1);
        int v2 = Id3Decoder.indexOfEos(arr_b, 0, v1);
        int v3 = v2 + Id3Decoder.delimiterLength(v1);
        return new UrlLinkFrame("WXXX", new String(arr_b, 0, v2, Id3Decoder.getCharsetName(v1)), Id3Decoder.decodeStringIfValid(arr_b, v3, Id3Decoder.indexOfZeroByte(arr_b, v3), "ISO-8859-1"));
    }

    private static int delimiterLength(int v) {
        return v == 0 || v == 3 ? 1 : 2;
    }

    private static String getCharsetName(int v) {
        switch(v) {
            case 1: {
                return "UTF-16";
            }
            case 2: {
                return "UTF-16BE";
            }
            case 3: {
                return "UTF-8";
            }
            default: {
                return "ISO-8859-1";
            }
        }
    }

    private static String getFrameId(int v, int v1, int v2, int v3, int v4) {
        return v == 2 ? String.format(Locale.US, "%c%c%c", v1, v2, v3) : String.format(Locale.US, "%c%c%c%c", v1, v2, v3, v4);
    }

    private static int indexOfEos(byte[] arr_b, int v, int v1) {
        int v2 = Id3Decoder.indexOfZeroByte(arr_b, v);
        if(v1 != 0 && v1 != 3) {
            while(v2 < arr_b.length - 1) {
                if(v2 % 2 == 0 && arr_b[v2 + 1] == 0) {
                    return v2;
                }
                v2 = Id3Decoder.indexOfZeroByte(arr_b, v2 + 1);
            }
            return arr_b.length;
        }
        return v2;
    }

    private static int indexOfZeroByte(byte[] arr_b, int v) {
        while(v < arr_b.length) {
            if(arr_b[v] == 0) {
                return v;
            }
            ++v;
        }
        return arr_b.length;
    }

    private static boolean lambda$static$0(int v, int v1, int v2, int v3, int v4) [...] // Inlined contents

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray0, int v) {
        byte[] arr_b = parsableByteArray0.data;
        int v1 = parsableByteArray0.getPosition();
        for(int v2 = v1; v2 + 1 < v1 + v; ++v2) {
            if((arr_b[v2] & 0xFF) == 0xFF && arr_b[v2 + 1] == 0) {
                System.arraycopy(arr_b, v2 + 2, arr_b, v2 + 1, v - (v2 - v1) - 2);
                --v;
            }
        }
        return v;
    }

    // This method was un-flattened
    private static boolean validateFrames(ParsableByteArray parsableByteArray0, int v, int v1, boolean z) {
        int v6;
        int v5;
        long v4;
        int v3;
        int v2 = parsableByteArray0.getPosition();
        while(parsableByteArray0.bytesLeft() >= v1) {
            try {
                if(v >= 3) {
                    v3 = parsableByteArray0.readInt();
                    v4 = parsableByteArray0.readUnsignedInt();
                    v5 = parsableByteArray0.readUnsignedShort();
                }
                else {
                    v3 = parsableByteArray0.readUnsignedInt24();
                    v4 = (long)parsableByteArray0.readUnsignedInt24();
                    v5 = 0;
                }
            }
            catch(Throwable throwable0) {
                parsableByteArray0.setPosition(v2);
                throw throwable0;
            }
            if(v3 == 0 && v4 == 0L && v5 == 0) {
                parsableByteArray0.setPosition(v2);
                return true;
            }
            if(v == 4 && !z) {
                if((0x808080L & v4) != 0L) {
                    parsableByteArray0.setPosition(v2);
                    return false;
                }
                v4 = (v4 >> 24 & 0xFFL) << 21 | (v4 & 0xFFL | (v4 >> 8 & 0xFFL) << 7 | (v4 >> 16 & 0xFFL) << 14);
            }
            if(v == 4) {
                v6 = (v5 & 0x40) == 0 ? 0 : 1;
                if((v5 & 1) != 0) {
                    v6 += 4;
                }
            }
            else if(v == 3) {
                v6 = (v5 & 0x20) == 0 ? 0 : 1;
                if((v5 & 0x80) != 0) {
                    v6 += 4;
                }
            }
            else {
                v6 = 0;
            }
            if(v4 < ((long)v6)) {
                parsableByteArray0.setPosition(v2);
                return false;
            }
            if(((long)parsableByteArray0.bytesLeft()) < v4) {
                parsableByteArray0.setPosition(v2);
                return false;
            }
            try {
                parsableByteArray0.skipBytes(((int)v4));
                continue;
            }
            catch(Throwable throwable0) {
            }
            parsableByteArray0.setPosition(v2);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v2);
        return true;
    }
}

