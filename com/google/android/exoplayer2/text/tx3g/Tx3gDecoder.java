package com.google.android.exoplayer2.text.tx3g;

import U4.x;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '﻿';
    private static final char BOM_UTF16_LE = '\uFFFE';
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 0xFF0000;
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = 1937013100;
    private static final int TYPE_TBOX = 1952608120;
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray;

    public Tx3gDecoder(List list0) {
        super("Tx3gDecoder");
        this.parsableByteArray = new ParsableByteArray();
        String s = "sans-serif";
        boolean z = false;
        if(list0 != null && list0.size() == 1) {
            switch(((byte[])list0.get(0)).length) {
                case 0x30: 
                case 53: {
                    byte[] arr_b = (byte[])list0.get(0);
                    this.defaultFontFace = arr_b[24];
                    this.defaultColorRgba = (arr_b[26] & 0xFF) << 24 | (arr_b[27] & 0xFF) << 16 | (arr_b[28] & 0xFF) << 8 | arr_b[29] & 0xFF;
                    if("Serif".equals(Util.fromUtf8Bytes(arr_b, 43, arr_b.length - 43))) {
                        s = "serif";
                    }
                    this.defaultFontFamily = s;
                    int v = arr_b[25] * 20;
                    this.calculatedVideoTrackHeight = v;
                    if((arr_b[0] & 0x20) != 0) {
                        z = true;
                    }
                    this.customVerticalPlacement = z;
                    if(z) {
                        this.defaultVerticalPlacement = Util.constrainValue(((float)(arr_b[11] & 0xFF | (arr_b[10] & 0xFF) << 8)) / ((float)v), 0.0f, 0.95f);
                        return;
                    }
                    this.defaultVerticalPlacement = 0.85f;
                    return;
                }
            }
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = "sans-serif";
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = 0.85f;
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray0, SpannableStringBuilder spannableStringBuilder0) {
        Tx3gDecoder.assertTrue(parsableByteArray0.bytesLeft() >= 12);
        int v = parsableByteArray0.readUnsignedShort();
        int v1 = parsableByteArray0.readUnsignedShort();
        parsableByteArray0.skipBytes(2);
        int v2 = parsableByteArray0.readUnsignedByte();
        parsableByteArray0.skipBytes(1);
        int v3 = parsableByteArray0.readInt();
        Tx3gDecoder.attachFontFace(spannableStringBuilder0, v2, this.defaultFontFace, v, v1, 0);
        Tx3gDecoder.attachColor(spannableStringBuilder0, v3, this.defaultColorRgba, v, v1, 0);
    }

    private static void assertTrue(boolean z) {
        if(!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder0, int v, int v1, int v2, int v3, int v4) {
        if(v != v1) {
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(v >>> 8 | (v & 0xFF) << 24), v2, v3, v4 | 33);
        }
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder0, int v, int v1, int v2, int v3, int v4) {
        boolean z = true;
        if(v != v1) {
            boolean z1 = (v & 1) != 0;
            boolean z2 = (v & 2) != 0;
            if(!z1) {
                if(z2) {
                    x.t(2, spannableStringBuilder0, v2, v3, v4 | 33);
                }
            }
            else if(z2) {
                x.t(3, spannableStringBuilder0, v2, v3, v4 | 33);
            }
            else {
                x.t(1, spannableStringBuilder0, v2, v3, v4 | 33);
            }
            if((v & 4) == 0) {
                z = false;
            }
            else {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v2, v3, v4 | 33);
            }
            if(!z && !z1 && !z2) {
                x.t(0, spannableStringBuilder0, v2, v3, v4 | 33);
            }
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder0, String s, String s1, int v, int v1, int v2) {
        if(s != s1) {
            spannableStringBuilder0.setSpan(new TypefaceSpan(s), v, v1, v2 | 33);
        }
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        this.parsableByteArray.reset(arr_b, v);
        String s = Tx3gDecoder.readSubtitleText(this.parsableByteArray);
        if(s.isEmpty()) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(s);
        Tx3gDecoder.attachFontFace(spannableStringBuilder0, this.defaultFontFace, 0, 0, spannableStringBuilder0.length(), 0xFF0000);
        Tx3gDecoder.attachColor(spannableStringBuilder0, this.defaultColorRgba, -1, 0, spannableStringBuilder0.length(), 0xFF0000);
        Tx3gDecoder.attachFontFamily(spannableStringBuilder0, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder0.length(), 0xFF0000);
        float f = this.defaultVerticalPlacement;
        while(this.parsableByteArray.bytesLeft() >= 8) {
            int v1 = this.parsableByteArray.getPosition();
            int v2 = this.parsableByteArray.readInt();
            int v3 = this.parsableByteArray.readInt();
            int v4 = 0;
            boolean z1 = true;
            if(v3 == 1937013100) {
                if(this.parsableByteArray.bytesLeft() < 2) {
                    z1 = false;
                }
                Tx3gDecoder.assertTrue(z1);
                int v5 = this.parsableByteArray.readUnsignedShort();
                while(v4 < v5) {
                    this.applyStyleRecord(this.parsableByteArray, spannableStringBuilder0);
                    ++v4;
                }
            }
            else if(v3 == 1952608120 && this.customVerticalPlacement) {
                if(this.parsableByteArray.bytesLeft() >= 2) {
                    v4 = 1;
                }
                Tx3gDecoder.assertTrue(((boolean)v4));
                f = Util.constrainValue(((float)this.parsableByteArray.readUnsignedShort()) / ((float)this.calculatedVideoTrackHeight), 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(v1 + v2);
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder0, null, f, 0, 0, -3.402823E+38f, 0x80000000, -3.402823E+38f));
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray0) {
        Tx3gDecoder.assertTrue(parsableByteArray0.bytesLeft() >= 2);
        int v = parsableByteArray0.readUnsignedShort();
        if(v == 0) {
            return "";
        }
        if(parsableByteArray0.bytesLeft() >= 2) {
            switch(parsableByteArray0.peekChar()) {
                case 0xFEFF: 
                case 0xFFFE: {
                    return parsableByteArray0.readString(v, Charset.forName("UTF-16"));
                }
                default: {
                    return parsableByteArray0.readString(v, Charset.forName("UTF-8"));
                }
            }
        }
        return parsableByteArray0.readString(v, Charset.forName("UTF-8"));
    }
}

