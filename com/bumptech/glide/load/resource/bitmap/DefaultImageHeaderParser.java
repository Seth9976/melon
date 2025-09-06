package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.appcompat.app.o;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import va.e;

public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer0) {
            this.byteBuffer = byteBuffer0;
            byteBuffer0.order(ByteOrder.BIG_ENDIAN);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int getUInt16() {
            return this.getUInt8() << 8 | this.getUInt8();
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public short getUInt8() {
            if(this.byteBuffer.remaining() < 1) {
                throw new EndOfFileException();
            }
            return (short)(this.byteBuffer.get() & 0xFF);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int read(byte[] arr_b, int v) {
            int v1 = Math.min(v, this.byteBuffer.remaining());
            if(v1 == 0) {
                return -1;
            }
            this.byteBuffer.get(arr_b, 0, v1);
            return v1;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public long skip(long v) {
            int v1 = (int)Math.min(this.byteBuffer.remaining(), v);
            this.byteBuffer.position(this.byteBuffer.position() + v1);
            return (long)v1;
        }
    }

    static final class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] arr_b, int v) {
            this.data = (ByteBuffer)ByteBuffer.wrap(arr_b).order(ByteOrder.BIG_ENDIAN).limit(v);
        }

        public short getInt16(int v) {
            return this.isAvailable(v, 2) ? this.data.getShort(v) : -1;
        }

        // 去混淆评级： 低(20)
        public int getInt32(int v) {
            return this.isAvailable(v, 4) ? this.data.getInt(v) : -1;
        }

        private boolean isAvailable(int v, int v1) {
            return this.data.remaining() - v >= v1;
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder0) {
            this.data.order(byteOrder0);
        }
    }

    interface Reader {
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1L;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16();

        short getUInt8();

        int read(byte[] arg1, int arg2);

        long skip(long arg1);
    }

    static final class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream inputStream0) {
            this.is = inputStream0;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int getUInt16() {
            return this.getUInt8() << 8 | this.getUInt8();
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public short getUInt8() {
            int v = this.is.read();
            if(v == -1) {
                throw new EndOfFileException();
            }
            return (short)v;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int read(byte[] arr_b, int v) {
            int v1 = 0;
            int v2 = 0;
            while(v1 < v) {
                v2 = this.is.read(arr_b, v1, v - v1);
                if(v2 == -1) {
                    break;
                }
                v1 += v2;
            }
            if(v1 == 0 && v2 == -1) {
                throw new EndOfFileException();
            }
            return v1;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public long skip(long v) {
            if(v < 0L) {
                return 0L;
            }
            long v1;
            for(v1 = v; v1 > 0L; v1 -= v2) {
                long v2 = this.is.skip(v1);
                if(v2 <= 0L) {
                    if(this.is.read() == -1) {
                        break;
                    }
                    v2 = 1L;
                }
            }
            return v - v1;
        }
    }

    private static final int AVIF_BRAND = 1635150182;
    private static final int AVIS_BRAND = 1635150195;
    private static final int[] BYTES_PER_FORMAT = null;
    static final int EXIF_MAGIC_NUMBER = 0xFFD8;
    static final int EXIF_SEGMENT_TYPE = 0xE1;
    private static final int FTYP_HEADER = 0x66747970;
    private static final int GIF_HEADER = 0x474946;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 0x4949;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = null;
    private static final int MARKER_EOI = 0xD9;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 0x4D4D;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = 0x89504E47;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 0xDA;
    static final int SEGMENT_START_ID = 0xFF;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 0x56503800;
    private static final int VP8_HEADER_MASK = 0xFFFFFF00;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 0xFF;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIMATION_FLAG = 2;
    private static final int WEBP_HEADER = 0x57454250;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;

    static {
        DefaultImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = new byte[]{69, 120, 105, 102, 0, 0};
        DefaultImageHeaderParser.BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    private static int calcTagOffset(int v, int v1) [...] // Inlined contents

    private int getOrientation(Reader defaultImageHeaderParser$Reader0, ArrayPool arrayPool0) {
        try {
            int v = defaultImageHeaderParser$Reader0.getUInt16();
            if(!DefaultImageHeaderParser.handles(v)) {
                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn\'t handle magic number: " + v);
                }
                return -1;
            }
            int v1 = this.moveToExifSegmentAndGetLength(defaultImageHeaderParser$Reader0);
            if(v1 == -1) {
                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] arr_b = (byte[])arrayPool0.get(v1, byte[].class);
            try {
                return this.parseExifSegment(defaultImageHeaderParser$Reader0, arr_b, v1);
            }
            finally {
                arrayPool0.put(arr_b);
            }
        }
        catch(EndOfFileException unused_ex) {
            return -1;
        }
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream0, ArrayPool arrayPool0) {
        return this.getOrientation(new StreamReader(((InputStream)Preconditions.checkNotNull(inputStream0))), ((ArrayPool)Preconditions.checkNotNull(arrayPool0)));
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer0, ArrayPool arrayPool0) {
        return this.getOrientation(new ByteBufferReader(((ByteBuffer)Preconditions.checkNotNull(byteBuffer0))), ((ArrayPool)Preconditions.checkNotNull(arrayPool0)));
    }

    private ImageType getType(Reader defaultImageHeaderParser$Reader0) {
        try {
            int v = defaultImageHeaderParser$Reader0.getUInt16();
            if(v == 0xFFD8) {
                return ImageType.JPEG;
            }
            int v1 = v << 8 | defaultImageHeaderParser$Reader0.getUInt8();
            if(v1 == 0x474946) {
                return ImageType.GIF;
            }
            int v2 = v1 << 8 | defaultImageHeaderParser$Reader0.getUInt8();
            switch(v2) {
                case 0x89504E47: {
                    defaultImageHeaderParser$Reader0.skip(21L);
                    try {
                        return defaultImageHeaderParser$Reader0.getUInt8() < 3 ? ImageType.PNG : ImageType.PNG_A;
                    }
                    catch(EndOfFileException unused_ex) {
                        return ImageType.PNG;
                    }
                }
                case 1380533830: {
                    defaultImageHeaderParser$Reader0.skip(4L);
                    if((defaultImageHeaderParser$Reader0.getUInt16() << 16 | defaultImageHeaderParser$Reader0.getUInt16()) != 0x57454250) {
                        return ImageType.UNKNOWN;
                    }
                    int v3 = defaultImageHeaderParser$Reader0.getUInt16() << 16 | defaultImageHeaderParser$Reader0.getUInt16();
                    if((v3 & 0xFFFFFF00) != 0x56503800) {
                        return ImageType.UNKNOWN;
                    }
                    switch(v3 & 0xFF) {
                        case 76: {
                            defaultImageHeaderParser$Reader0.skip(4L);
                            return (defaultImageHeaderParser$Reader0.getUInt8() & 8) == 0 ? ImageType.WEBP : ImageType.WEBP_A;
                        }
                        case 88: {
                            defaultImageHeaderParser$Reader0.skip(4L);
                            int v4 = defaultImageHeaderParser$Reader0.getUInt8();
                            if((v4 & 2) != 0) {
                                return ImageType.ANIMATED_WEBP;
                            }
                            return (v4 & 16) == 0 ? ImageType.WEBP : ImageType.WEBP_A;
                        }
                        default: {
                            return ImageType.WEBP;
                        }
                    }
                }
                default: {
                    return this.sniffAvif(defaultImageHeaderParser$Reader0, v2);
                }
            }
        }
        catch(EndOfFileException unused_ex) {
            return ImageType.UNKNOWN;
        }
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public ImageType getType(InputStream inputStream0) {
        return this.getType(new StreamReader(((InputStream)Preconditions.checkNotNull(inputStream0))));
    }

    @Override  // com.bumptech.glide.load.ImageHeaderParser
    public ImageType getType(ByteBuffer byteBuffer0) {
        return this.getType(new ByteBufferReader(((ByteBuffer)Preconditions.checkNotNull(byteBuffer0))));
    }

    private static boolean handles(int v) {
        return (v & 0xFFD8) == 0xFFD8 || (v == 0x4949 || v == 0x4D4D);
    }

    private boolean hasJpegExifPreamble(byte[] arr_b, int v) {
        boolean z = arr_b != null && v > DefaultImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if(z) {
            for(int v1 = 0; true; ++v1) {
                byte[] arr_b1 = DefaultImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if(v1 >= arr_b1.length) {
                    break;
                }
                if(arr_b[v1] != arr_b1[v1]) {
                    return false;
                }
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength(Reader defaultImageHeaderParser$Reader0) {
        int v2;
        while(true) {
            int v = defaultImageHeaderParser$Reader0.getUInt8();
            if(v != 0xFF) {
                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    e.f(v, "Unknown segmentId=", "DfltImageHeaderParser");
                }
                return -1;
            }
            int v1 = defaultImageHeaderParser$Reader0.getUInt8();
            if(v1 == 0xDA) {
                return -1;
            }
            if(v1 == 0xD9) {
                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            v2 = defaultImageHeaderParser$Reader0.getUInt16() - 2;
            if(v1 == 0xE1) {
                break;
            }
            long v3 = defaultImageHeaderParser$Reader0.skip(((long)v2));
            if(v3 != ((long)v2)) {
                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder stringBuilder0 = o.t(v1, v2, "Unable to skip enough data, type: ", ", wanted to skip: ", ", but actually skipped: ");
                    stringBuilder0.append(v3);
                    Log.d("DfltImageHeaderParser", stringBuilder0.toString());
                }
                return -1;
            }
        }
        return v2;
    }

    private static int parseExifSegment(RandomAccessReader defaultImageHeaderParser$RandomAccessReader0) {
        ByteOrder byteOrder0;
        int v = defaultImageHeaderParser$RandomAccessReader0.getInt16(6);
        switch(v) {
            case 0x4949: {
                byteOrder0 = ByteOrder.LITTLE_ENDIAN;
                break;
            }
            case 0x4D4D: {
                byteOrder0 = ByteOrder.BIG_ENDIAN;
                break;
            }
            default: {
                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    e.f(v, "Unknown endianness = ", "DfltImageHeaderParser");
                }
                byteOrder0 = ByteOrder.BIG_ENDIAN;
            }
        }
        defaultImageHeaderParser$RandomAccessReader0.order(byteOrder0);
        int v1 = defaultImageHeaderParser$RandomAccessReader0.getInt32(10);
        int v2 = defaultImageHeaderParser$RandomAccessReader0.getInt16(v1 + 6);
        for(int v3 = 0; v3 < v2; ++v3) {
            int v4 = v3 * 12 + (v1 + 8);
            if(defaultImageHeaderParser$RandomAccessReader0.getInt16(v4) == 274) {
                int v5 = defaultImageHeaderParser$RandomAccessReader0.getInt16(v4 + 2);
                if(v5 >= 1 && v5 <= 12) {
                    int v6 = defaultImageHeaderParser$RandomAccessReader0.getInt32(v4 + 4);
                    if(v6 >= 0) {
                        if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder stringBuilder0 = o.t(v3, 274, "Got tagIndex=", " tagType=", " formatCode=");
                            stringBuilder0.append(v5);
                            stringBuilder0.append(" componentCount=");
                            stringBuilder0.append(v6);
                            Log.d("DfltImageHeaderParser", stringBuilder0.toString());
                        }
                        int v7 = v6 + DefaultImageHeaderParser.BYTES_PER_FORMAT[v5];
                        if(v7 <= 4) {
                            if(v4 + 8 >= 0 && v4 + 8 <= defaultImageHeaderParser$RandomAccessReader0.length()) {
                                if(v7 >= 0 && v7 + (v4 + 8) <= defaultImageHeaderParser$RandomAccessReader0.length()) {
                                    return defaultImageHeaderParser$RandomAccessReader0.getInt16(v4 + 8);
                                }
                                if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    e.f(274, "Illegal number of bytes for TI tag data tagType=", "DfltImageHeaderParser");
                                }
                            }
                            else if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + (v4 + 8) + " tagType=" + 274);
                            }
                        }
                        else if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                            e.f(v5, "Got byte count > 4, not orientation, continuing, formatCode=", "DfltImageHeaderParser");
                        }
                    }
                    else if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                }
                else if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                    e.f(v5, "Got invalid format code = ", "DfltImageHeaderParser");
                }
            }
        }
        return -1;
    }

    private int parseExifSegment(Reader defaultImageHeaderParser$Reader0, byte[] arr_b, int v) {
        int v1 = defaultImageHeaderParser$Reader0.read(arr_b, v);
        if(v1 != v) {
            if(Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + v + ", actually read: " + v1);
            }
            return -1;
        }
        if(this.hasJpegExifPreamble(arr_b, v)) {
            return DefaultImageHeaderParser.parseExifSegment(new RandomAccessReader(arr_b, v));
        }
        if(Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    private ImageType sniffAvif(Reader defaultImageHeaderParser$Reader0, int v) {
        if((defaultImageHeaderParser$Reader0.getUInt16() << 16 | defaultImageHeaderParser$Reader0.getUInt16()) != 0x66747970) {
            return ImageType.UNKNOWN;
        }
        int v1 = 0;
        int v2 = defaultImageHeaderParser$Reader0.getUInt16() << 16 | defaultImageHeaderParser$Reader0.getUInt16();
        if(v2 == 1635150195) {
            return ImageType.ANIMATED_AVIF;
        }
        boolean z = v2 == 1635150182;
        defaultImageHeaderParser$Reader0.skip(4L);
        int v3 = v - 16;
        if(v3 % 4 == 0) {
            while(v1 < 5 && v3 > 0) {
                int v4 = defaultImageHeaderParser$Reader0.getUInt16() << 16 | defaultImageHeaderParser$Reader0.getUInt16();
                if(v4 == 1635150195) {
                    return ImageType.ANIMATED_AVIF;
                }
                if(v4 == 1635150182) {
                    z = true;
                }
                ++v1;
                v3 -= 4;
            }
        }
        return z ? ImageType.AVIF : ImageType.UNKNOWN;
    }
}

