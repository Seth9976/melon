package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Cue {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = -3.402823E+38f;
    public static final Cue EMPTY = null;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = 0x80000000;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int windowColor;
    public final boolean windowColorSet;

    static {
        Cue.EMPTY = new Cue("");
    }

    public Cue(Bitmap bitmap0, float f, int v, float f1, int v1, float f2, float f3) {
        this(null, null, bitmap0, f1, 0, v1, f, v, 0x80000000, -3.402823E+38f, f2, f3, false, 0xFF000000);
    }

    public Cue(CharSequence charSequence0) {
        this(charSequence0, null, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, 0x80000000, -3.402823E+38f);
    }

    public Cue(CharSequence charSequence0, Layout.Alignment layout$Alignment0, float f, int v, int v1, float f1, int v2, float f2) {
        this(charSequence0, layout$Alignment0, f, v, v1, f1, v2, f2, false, 0xFF000000);
    }

    public Cue(CharSequence charSequence0, Layout.Alignment layout$Alignment0, float f, int v, int v1, float f1, int v2, float f2, int v3, float f3) {
        this(charSequence0, layout$Alignment0, null, f, v, v1, f1, v2, v3, f3, f2, -3.402823E+38f, false, 0xFF000000);
    }

    public Cue(CharSequence charSequence0, Layout.Alignment layout$Alignment0, float f, int v, int v1, float f1, int v2, float f2, boolean z, int v3) {
        this(charSequence0, layout$Alignment0, null, f, v, v1, f1, v2, 0x80000000, -3.402823E+38f, f2, -3.402823E+38f, z, v3);
    }

    private Cue(CharSequence charSequence0, Layout.Alignment layout$Alignment0, Bitmap bitmap0, float f, int v, int v1, float f1, int v2, int v3, float f2, float f3, float f4, boolean z, int v4) {
        this.text = charSequence0;
        this.textAlignment = layout$Alignment0;
        this.bitmap = bitmap0;
        this.line = f;
        this.lineType = v;
        this.lineAnchor = v1;
        this.position = f1;
        this.positionAnchor = v2;
        this.size = f3;
        this.bitmapHeight = f4;
        this.windowColorSet = z;
        this.windowColor = v4;
        this.textSizeType = v3;
        this.textSize = f2;
    }
}

