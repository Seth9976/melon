package com.google.android.exoplayer2.text.ttml;

final class TtmlRegion {
    public final float height;
    public final String id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final float width;

    public TtmlRegion(String s) {
        this(s, -3.402823E+38f, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, -3.402823E+38f, 0x80000000, -3.402823E+38f);
    }

    public TtmlRegion(String s, float f, float f1, int v, int v1, float f2, float f3, int v2, float f4) {
        this.id = s;
        this.position = f;
        this.line = f1;
        this.lineType = v;
        this.lineAnchor = v1;
        this.width = f2;
        this.height = f3;
        this.textSizeType = v2;
        this.textSize = f4;
    }
}

