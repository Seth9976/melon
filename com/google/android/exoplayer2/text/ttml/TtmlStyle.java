package com.google.android.exoplayer2.text.ttml;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class TtmlStyle {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    private int backgroundColor;
    private int bold;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private String id;
    private TtmlStyle inheritableStyle;
    private int italic;
    private int linethrough;
    private Layout.Alignment textAlign;
    private int underline;

    public TtmlStyle() {
        this.linethrough = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.fontSizeUnit = -1;
    }

    public TtmlStyle chain(TtmlStyle ttmlStyle0) {
        return this.inherit(ttmlStyle0, true);
    }

    public int getBackgroundColor() {
        if(!this.hasBackgroundColor) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public int getFontColor() {
        if(!this.hasFontColor) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.fontColor;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public String getId() {
        return this.id;
    }

    public int getStyle() {
        int v = 0;
        int v1 = this.bold;
        if(v1 == -1 && this.italic == -1) {
            return -1;
        }
        if(this.italic == 1) {
            v = 2;
        }
        return (v1 == 1 ? 1 : 0) | v;
    }

    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle0, boolean z) {
        if(ttmlStyle0 != null) {
            if(!this.hasFontColor && ttmlStyle0.hasFontColor) {
                this.setFontColor(ttmlStyle0.fontColor);
            }
            if(this.bold == -1) {
                this.bold = ttmlStyle0.bold;
            }
            if(this.italic == -1) {
                this.italic = ttmlStyle0.italic;
            }
            if(this.fontFamily == null) {
                this.fontFamily = ttmlStyle0.fontFamily;
            }
            if(this.linethrough == -1) {
                this.linethrough = ttmlStyle0.linethrough;
            }
            if(this.underline == -1) {
                this.underline = ttmlStyle0.underline;
            }
            if(this.textAlign == null) {
                this.textAlign = ttmlStyle0.textAlign;
            }
            if(this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle0.fontSizeUnit;
                this.fontSize = ttmlStyle0.fontSize;
            }
            if(z && !this.hasBackgroundColor && ttmlStyle0.hasBackgroundColor) {
                this.setBackgroundColor(ttmlStyle0.backgroundColor);
            }
        }
        return this;
    }

    public TtmlStyle inherit(TtmlStyle ttmlStyle0) {
        return this.inherit(ttmlStyle0, false);
    }

    public boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    public TtmlStyle setBackgroundColor(int v) {
        this.backgroundColor = v;
        this.hasBackgroundColor = true;
        return this;
    }

    public TtmlStyle setBold(boolean z) {
        Assertions.checkState(this.inheritableStyle == null);
        this.bold = z;
        return this;
    }

    public TtmlStyle setFontColor(int v) {
        Assertions.checkState(this.inheritableStyle == null);
        this.fontColor = v;
        this.hasFontColor = true;
        return this;
    }

    public TtmlStyle setFontFamily(String s) {
        Assertions.checkState(this.inheritableStyle == null);
        this.fontFamily = s;
        return this;
    }

    public TtmlStyle setFontSize(float f) {
        this.fontSize = f;
        return this;
    }

    public TtmlStyle setFontSizeUnit(int v) {
        this.fontSizeUnit = v;
        return this;
    }

    public TtmlStyle setId(String s) {
        this.id = s;
        return this;
    }

    public TtmlStyle setItalic(boolean z) {
        Assertions.checkState(this.inheritableStyle == null);
        this.italic = z;
        return this;
    }

    public TtmlStyle setLinethrough(boolean z) {
        Assertions.checkState(this.inheritableStyle == null);
        this.linethrough = z;
        return this;
    }

    public TtmlStyle setTextAlign(Layout.Alignment layout$Alignment0) {
        this.textAlign = layout$Alignment0;
        return this;
    }

    public TtmlStyle setUnderline(boolean z) {
        Assertions.checkState(this.inheritableStyle == null);
        this.underline = z;
        return this;
    }
}

