package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CaptionStyleCompat {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    public static final CaptionStyleCompat DEFAULT = null;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int USE_TRACK_COLOR_SETTINGS = 1;
    public final int backgroundColor;
    public final int edgeColor;
    public final int edgeType;
    public final int foregroundColor;
    public final Typeface typeface;
    public final int windowColor;

    static {
        CaptionStyleCompat.DEFAULT = new CaptionStyleCompat(-1, 0xFF000000, 0, 0, -1, null);
    }

    public CaptionStyleCompat(int v, int v1, int v2, int v3, int v4, Typeface typeface0) {
        this.foregroundColor = v;
        this.backgroundColor = v1;
        this.windowColor = v2;
        this.edgeType = v3;
        this.edgeColor = v4;
        this.typeface = typeface0;
    }

    @TargetApi(19)
    public static CaptionStyleCompat createFromCaptionStyle(CaptioningManager.CaptionStyle captioningManager$CaptionStyle0) {
        return Util.SDK_INT < 21 ? CaptionStyleCompat.createFromCaptionStyleV19(captioningManager$CaptionStyle0) : CaptionStyleCompat.createFromCaptionStyleV21(captioningManager$CaptionStyle0);
    }

    @TargetApi(19)
    private static CaptionStyleCompat createFromCaptionStyleV19(CaptioningManager.CaptionStyle captioningManager$CaptionStyle0) {
        return new CaptionStyleCompat(captioningManager$CaptionStyle0.foregroundColor, captioningManager$CaptionStyle0.backgroundColor, 0, captioningManager$CaptionStyle0.edgeType, captioningManager$CaptionStyle0.edgeColor, captioningManager$CaptionStyle0.getTypeface());
    }

    // 去混淆评级： 低(20)
    @TargetApi(21)
    private static CaptionStyleCompat createFromCaptionStyleV21(CaptioningManager.CaptionStyle captioningManager$CaptionStyle0) {
        int v = captioningManager$CaptionStyle0.hasForegroundColor() ? captioningManager$CaptionStyle0.foregroundColor : CaptionStyleCompat.DEFAULT.foregroundColor;
        int v1 = captioningManager$CaptionStyle0.hasBackgroundColor() ? captioningManager$CaptionStyle0.backgroundColor : CaptionStyleCompat.DEFAULT.backgroundColor;
        int v2 = captioningManager$CaptionStyle0.hasWindowColor() ? captioningManager$CaptionStyle0.windowColor : CaptionStyleCompat.DEFAULT.windowColor;
        int v3 = captioningManager$CaptionStyle0.hasEdgeType() ? captioningManager$CaptionStyle0.edgeType : CaptionStyleCompat.DEFAULT.edgeType;
        return captioningManager$CaptionStyle0.hasEdgeColor() ? new CaptionStyleCompat(v, v1, v2, v3, captioningManager$CaptionStyle0.edgeColor, captioningManager$CaptionStyle0.getTypeface()) : new CaptionStyleCompat(v, v1, v2, v3, CaptionStyleCompat.DEFAULT.edgeColor, captioningManager$CaptionStyle0.getTypeface());
    }
}

