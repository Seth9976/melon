package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class PgsDecoder extends SimpleSubtitleDecoder {
    static final class CueBuilder {
        private final ParsableByteArray bitmapData;
        private int bitmapHeight;
        private int bitmapWidth;
        private int bitmapX;
        private int bitmapY;
        private final int[] colors;
        private boolean colorsSet;
        private int planeHeight;
        private int planeWidth;

        public CueBuilder() {
            this.bitmapData = new ParsableByteArray();
            this.colors = new int[0x100];
        }

        public static void access$100(CueBuilder pgsDecoder$CueBuilder0, ParsableByteArray parsableByteArray0, int v) {
            pgsDecoder$CueBuilder0.parseBitmapSection(parsableByteArray0, v);
        }

        public static void access$200(CueBuilder pgsDecoder$CueBuilder0, ParsableByteArray parsableByteArray0, int v) {
            pgsDecoder$CueBuilder0.parseIdentifierSection(parsableByteArray0, v);
        }

        public Cue build() {
            int v3;
            if(this.planeWidth != 0 && this.planeHeight != 0 && this.bitmapWidth != 0 && this.bitmapHeight != 0 && this.bitmapData.limit() != 0 && this.bitmapData.getPosition() == this.bitmapData.limit() && this.colorsSet) {
                this.bitmapData.setPosition(0);
                int v = this.bitmapWidth * this.bitmapHeight;
                int[] arr_v = new int[v];
                int v1 = 0;
                while(v1 < v) {
                    int v2 = this.bitmapData.readUnsignedByte();
                    if(v2 == 0) {
                        int v4 = this.bitmapData.readUnsignedByte();
                        if(v4 == 0) {
                            continue;
                        }
                        v3 = ((v4 & 0x40) == 0 ? v4 & 0x3F : (v4 & 0x3F) << 8 | this.bitmapData.readUnsignedByte()) + v1;
                        Arrays.fill(arr_v, v1, v3, ((v4 & 0x80) == 0 ? 0 : this.colors[this.bitmapData.readUnsignedByte()]));
                    }
                    else {
                        v3 = v1 + 1;
                        arr_v[v1] = this.colors[v2];
                    }
                    v1 = v3;
                }
                return new Cue(Bitmap.createBitmap(arr_v, this.bitmapWidth, this.bitmapHeight, Bitmap.Config.ARGB_8888), ((float)this.bitmapX) / ((float)this.planeWidth), 0, ((float)this.bitmapY) / ((float)this.planeHeight), 0, ((float)this.bitmapWidth) / ((float)this.planeWidth), ((float)this.bitmapHeight) / ((float)this.planeHeight));
            }
            return null;
        }

        private void parseBitmapSection(ParsableByteArray parsableByteArray0, int v) {
            if(v >= 4) {
                parsableByteArray0.skipBytes(3);
                int v1 = v - 4;
                if((parsableByteArray0.readUnsignedByte() & 0x80) == 0) {
                label_11:
                    int v3 = this.bitmapData.getPosition();
                    int v4 = this.bitmapData.limit();
                    if(v3 < v4 && v1 > 0) {
                        int v5 = Math.min(v1, v4 - v3);
                        parsableByteArray0.readBytes(this.bitmapData.data, v3, v5);
                        this.bitmapData.setPosition(v3 + v5);
                    }
                }
                else if(v1 >= 7) {
                    int v2 = parsableByteArray0.readUnsignedInt24();
                    if(v2 >= 4) {
                        this.bitmapWidth = parsableByteArray0.readUnsignedShort();
                        this.bitmapHeight = parsableByteArray0.readUnsignedShort();
                        this.bitmapData.reset(v2 - 4);
                        v1 = v - 11;
                        goto label_11;
                    }
                }
            }
        }

        private void parseIdentifierSection(ParsableByteArray parsableByteArray0, int v) {
            if(v < 19) {
                return;
            }
            this.planeWidth = parsableByteArray0.readUnsignedShort();
            this.planeHeight = parsableByteArray0.readUnsignedShort();
            parsableByteArray0.skipBytes(11);
            this.bitmapX = parsableByteArray0.readUnsignedShort();
            this.bitmapY = parsableByteArray0.readUnsignedShort();
        }

        private void parsePaletteSection(ParsableByteArray parsableByteArray0, int v) {
            if(v % 5 != 2) {
                return;
            }
            parsableByteArray0.skipBytes(2);
            Arrays.fill(this.colors, 0);
            for(int v1 = 0; v1 < v / 5; ++v1) {
                int v2 = parsableByteArray0.readUnsignedByte();
                int v3 = parsableByteArray0.readUnsignedByte();
                int v4 = parsableByteArray0.readUnsignedByte();
                int v5 = parsableByteArray0.readUnsignedByte();
                this.colors[v2] = Util.constrainValue(((int)(((double)v3) - 0.34414 * ((double)(v5 - 0x80)) - ((double)(v4 - 0x80)) * 0.71414)), 0, 0xFF) << 8 | (parsableByteArray0.readUnsignedByte() << 24 | Util.constrainValue(((int)(1.402 * ((double)(v4 - 0x80)) + ((double)v3))), 0, 0xFF) << 16) | Util.constrainValue(((int)(((double)(v5 - 0x80)) * 1.772 + ((double)v3))), 0, 0xFF);
            }
            this.colorsSet = true;
        }

        public void reset() {
            this.planeWidth = 0;
            this.planeHeight = 0;
            this.bitmapX = 0;
            this.bitmapY = 0;
            this.bitmapWidth = 0;
            this.bitmapHeight = 0;
            this.bitmapData.reset(0);
            this.colorsSet = false;
        }
    }

    private static final byte INFLATE_HEADER = 120;
    private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
    private static final int SECTION_TYPE_END = 0x80;
    private static final int SECTION_TYPE_IDENTIFIER = 22;
    private static final int SECTION_TYPE_PALETTE = 20;
    private final ParsableByteArray buffer;
    private final CueBuilder cueBuilder;
    private final ParsableByteArray inflatedBuffer;
    private Inflater inflater;

    public PgsDecoder() {
        super("PgsDecoder");
        this.buffer = new ParsableByteArray();
        this.inflatedBuffer = new ParsableByteArray();
        this.cueBuilder = new CueBuilder();
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        this.buffer.reset(arr_b, v);
        this.maybeInflateData(this.buffer);
        this.cueBuilder.reset();
        ArrayList arrayList0 = new ArrayList();
        while(this.buffer.bytesLeft() >= 3) {
            Cue cue0 = PgsDecoder.readNextSection(this.buffer, this.cueBuilder);
            if(cue0 != null) {
                arrayList0.add(cue0);
            }
        }
        return new PgsSubtitle(Collections.unmodifiableList(arrayList0));
    }

    private void maybeInflateData(ParsableByteArray parsableByteArray0) {
        if(parsableByteArray0.bytesLeft() > 0 && parsableByteArray0.peekUnsignedByte() == 120) {
            if(this.inflater == null) {
                this.inflater = new Inflater();
            }
            if(Util.inflate(parsableByteArray0, this.inflatedBuffer, this.inflater)) {
                parsableByteArray0.reset(this.inflatedBuffer.data, this.inflatedBuffer.limit());
            }
        }
    }

    private static Cue readNextSection(ParsableByteArray parsableByteArray0, CueBuilder pgsDecoder$CueBuilder0) {
        int v = parsableByteArray0.limit();
        int v1 = parsableByteArray0.readUnsignedByte();
        int v2 = parsableByteArray0.readUnsignedShort();
        int v3 = parsableByteArray0.getPosition() + v2;
        Cue cue0 = null;
        if(v3 > v) {
            parsableByteArray0.setPosition(v);
            return null;
        }
        if(v1 == 0x80) {
            cue0 = pgsDecoder$CueBuilder0.build();
            pgsDecoder$CueBuilder0.reset();
        }
        else {
            switch(v1) {
                case 20: {
                    pgsDecoder$CueBuilder0.parsePaletteSection(parsableByteArray0, v2);
                    break;
                }
                case 21: {
                    CueBuilder.access$100(pgsDecoder$CueBuilder0, parsableByteArray0, v2);
                    break;
                }
                case 22: {
                    CueBuilder.access$200(pgsDecoder$CueBuilder0, parsableByteArray0, v2);
                }
            }
        }
        parsableByteArray0.setPosition(v3);
        return cue0;
    }
}

