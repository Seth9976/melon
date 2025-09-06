package com.bumptech.glide.integration.webp;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WebpHeaderParser {
    static final class ByteArrayReader implements Reader {
        private final byte[] data;
        private final int offset;
        private int pos;
        private final int size;

        public ByteArrayReader(byte[] arr_b, int v, int v1) {
            this.data = arr_b;
            this.offset = v;
            this.size = v1;
            this.pos = v;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int getByte() {
            int v = this.pos;
            if(v >= this.offset + this.size) {
                return -1;
            }
            this.pos = v + 1;
            return this.data[v];
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int getUInt16() {
            return this.getByte() << 8 & 0xFF00 | this.getByte() & 0xFF;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public short getUInt8() {
            return (short)(this.getByte() & 0xFF);
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int read(byte[] arr_b, int v) {
            int v1 = Math.min(this.offset + this.size - this.pos, v);
            if(v1 == 0) {
                return -1;
            }
            System.arraycopy(this.data, this.pos, arr_b, 0, v1);
            return v1;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public long skip(long v) {
            int v1 = (int)Math.min(this.offset + this.size - this.pos, v);
            this.pos += v1;
            return (long)v1;
        }
    }

    static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer0) {
            this.byteBuffer = byteBuffer0;
            byteBuffer0.order(ByteOrder.BIG_ENDIAN);
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int getByte() {
            return this.byteBuffer.remaining() >= 1 ? this.byteBuffer.get() : -1;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int getUInt16() {
            return this.getByte() << 8 & 0xFF00 | this.getByte() & 0xFF;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public short getUInt8() {
            return (short)(this.getByte() & 0xFF);
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int read(byte[] arr_b, int v) {
            int v1 = Math.min(v, this.byteBuffer.remaining());
            if(v1 == 0) {
                return -1;
            }
            this.byteBuffer.get(arr_b, 0, v1);
            return v1;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public long skip(long v) {
            int v1 = (int)Math.min(this.byteBuffer.remaining(), v);
            this.byteBuffer.position(this.byteBuffer.position() + v1);
            return (long)v1;
        }
    }

    interface Reader {
        int getByte();

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

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int getByte() {
            return this.is.read();
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int getUInt16() {
            return this.is.read() << 8 & 0xFF00 | this.is.read() & 0xFF;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public short getUInt8() {
            return (short)(this.is.read() & 0xFF);
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
        public int read(byte[] arr_b, int v) {
            int v1;
            for(v1 = v; v1 > 0; v1 -= v2) {
                int v2 = this.is.read(arr_b, v - v1, v1);
                if(v2 == -1) {
                    break;
                }
            }
            return v - v1;
        }

        @Override  // com.bumptech.glide.integration.webp.WebpHeaderParser$Reader
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

    public static enum WebpImageType {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);

        private final boolean hasAlpha;
        private final boolean hasAnimation;

        private WebpImageType(boolean z, boolean z1) {
            this.hasAlpha = z;
            this.hasAnimation = z1;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean hasAnimation() {
            return this.hasAnimation;
        }
    }

    public static final int MAX_WEBP_HEADER_SIZE = 21;
    private static final int RIFF_HEADER = 1380533830;
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIM_FLAG = 2;
    private static final int WEBP_HEADER = 0x57454250;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final int WEBP_VP8L_HEADER = 0x5650384C;
    private static final int WEBP_VP8X_HEADER = 1448097880;
    private static final int WEBP_VP8_HEADER = 0x56503820;
    public static final boolean sIsExtendedWebpSupported;

    static {
        WebpHeaderParser.sIsExtendedWebpSupported = true;
    }

    private static WebpImageType getType(Reader webpHeaderParser$Reader0) {
        if((webpHeaderParser$Reader0.getUInt16() << 16 & 0xFFFF0000 | webpHeaderParser$Reader0.getUInt16() & 0xFFFF) != 1380533830) {
            return WebpImageType.NONE_WEBP;
        }
        webpHeaderParser$Reader0.skip(4L);
        if((webpHeaderParser$Reader0.getUInt16() << 16 & 0xFFFF0000 | webpHeaderParser$Reader0.getUInt16() & 0xFFFF) != 0x57454250) {
            return WebpImageType.NONE_WEBP;
        }
        int v = webpHeaderParser$Reader0.getUInt16() << 16 & 0xFFFF0000 | webpHeaderParser$Reader0.getUInt16() & 0xFFFF;
        if(v == 0x56503820) {
            return WebpImageType.WEBP_SIMPLE;
        }
        switch(v) {
            case 0x5650384C: {
                webpHeaderParser$Reader0.skip(4L);
                return (webpHeaderParser$Reader0.getByte() & 8) == 0 ? WebpImageType.WEBP_LOSSLESS : WebpImageType.WEBP_LOSSLESS_WITH_ALPHA;
            }
            case 1448097880: {
                webpHeaderParser$Reader0.skip(4L);
                int v1 = webpHeaderParser$Reader0.getByte();
                if((v1 & 2) != 0) {
                    return WebpImageType.WEBP_EXTENDED_ANIMATED;
                }
                return (v1 & 16) == 0 ? WebpImageType.WEBP_EXTENDED : WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
            }
            default: {
                return WebpImageType.NONE_WEBP;
            }
        }
    }

    public static WebpImageType getType(InputStream inputStream0, ArrayPool arrayPool0) {
        if(inputStream0 == null) {
            return WebpImageType.NONE_WEBP;
        }
        if(!inputStream0.markSupported()) {
            inputStream0 = new RecyclableBufferedInputStream(inputStream0, arrayPool0);
        }
        inputStream0.mark(21);
        try {
            return WebpHeaderParser.getType(new StreamReader(((InputStream)Preconditions.checkNotNull(inputStream0))));
        }
        finally {
            inputStream0.reset();
        }
    }

    public static WebpImageType getType(ByteBuffer byteBuffer0) {
        return byteBuffer0 == null ? WebpImageType.NONE_WEBP : WebpHeaderParser.getType(new ByteBufferReader(((ByteBuffer)Preconditions.checkNotNull(byteBuffer0))));
    }

    public static WebpImageType getType(byte[] arr_b) {
        return WebpHeaderParser.getType(arr_b, 0, arr_b.length);
    }

    public static WebpImageType getType(byte[] arr_b, int v, int v1) {
        return WebpHeaderParser.getType(new ByteArrayReader(arr_b, v, v1));
    }

    public static boolean isAnimatedWebpType(WebpImageType webpHeaderParser$WebpImageType0) {
        return webpHeaderParser$WebpImageType0 == WebpImageType.WEBP_EXTENDED_ANIMATED;
    }

    public static boolean isExtendedWebpSupported() [...] // Inlined contents

    public static boolean isNonSimpleWebpType(WebpImageType webpHeaderParser$WebpImageType0) {
        return webpHeaderParser$WebpImageType0 != WebpImageType.NONE_WEBP && webpHeaderParser$WebpImageType0 != WebpImageType.WEBP_SIMPLE;
    }

    public static boolean isStaticWebpType(WebpImageType webpHeaderParser$WebpImageType0) [...] // 潜在的解密器
}

