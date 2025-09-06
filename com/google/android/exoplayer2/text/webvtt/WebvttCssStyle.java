package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class WebvttCssStyle {
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
    private int italic;
    private int linethrough;
    private List targetClasses;
    private String targetId;
    private String targetTag;
    private String targetVoice;
    private Layout.Alignment textAlign;
    private int underline;

    public WebvttCssStyle() {
        this.reset();
    }

    public void cascadeFrom(WebvttCssStyle webvttCssStyle0) {
        if(webvttCssStyle0.hasFontColor) {
            this.setFontColor(webvttCssStyle0.fontColor);
        }
        int v = webvttCssStyle0.bold;
        if(v != -1) {
            this.bold = v;
        }
        int v1 = webvttCssStyle0.italic;
        if(v1 != -1) {
            this.italic = v1;
        }
        String s = webvttCssStyle0.fontFamily;
        if(s != null) {
            this.fontFamily = s;
        }
        if(this.linethrough == -1) {
            this.linethrough = webvttCssStyle0.linethrough;
        }
        if(this.underline == -1) {
            this.underline = webvttCssStyle0.underline;
        }
        if(this.textAlign == null) {
            this.textAlign = webvttCssStyle0.textAlign;
        }
        if(this.fontSizeUnit == -1) {
            this.fontSizeUnit = webvttCssStyle0.fontSizeUnit;
            this.fontSize = webvttCssStyle0.fontSize;
        }
        if(webvttCssStyle0.hasBackgroundColor) {
            this.setBackgroundColor(webvttCssStyle0.backgroundColor);
        }
    }

    public int getBackgroundColor() {
        if(!this.hasBackgroundColor) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public int getFontColor() {
        if(!this.hasFontColor) {
            throw new IllegalStateException("Font color not defined");
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

    public int getSpecificityScore(String s, String s1, String[] arr_s, String s2) {
        if(this.targetId.isEmpty() && this.targetTag.isEmpty() && this.targetClasses.isEmpty() && this.targetVoice.isEmpty()) {
            return TextUtils.isEmpty(s1);
        }
        int v = WebvttCssStyle.updateScoreForMatch(WebvttCssStyle.updateScoreForMatch(WebvttCssStyle.updateScoreForMatch(0, this.targetId, s, 0x40000000), this.targetTag, s1, 2), this.targetVoice, s2, 4);
        return v == -1 || !Arrays.asList(arr_s).containsAll(this.targetClasses) ? 0 : this.targetClasses.size() * 4 + v;
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

    public boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    @EnsuresNonNull({"targetId", "targetTag", "targetClasses", "targetVoice"})
    public void reset() {
        this.targetId = "";
        this.targetTag = "";
        this.targetClasses = Collections.EMPTY_LIST;
        this.targetVoice = "";
        this.fontFamily = null;
        this.hasFontColor = false;
        this.hasBackgroundColor = false;
        this.linethrough = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.fontSizeUnit = -1;
        this.textAlign = null;
    }

    public WebvttCssStyle setBackgroundColor(int v) {
        this.backgroundColor = v;
        this.hasBackgroundColor = true;
        return this;
    }

    public WebvttCssStyle setBold(boolean z) {
        this.bold = z;
        return this;
    }

    public WebvttCssStyle setFontColor(int v) {
        this.fontColor = v;
        this.hasFontColor = true;
        return this;
    }

    public WebvttCssStyle setFontFamily(String s) {
        this.fontFamily = Util.toLowerInvariant(s);
        return this;
    }

    public WebvttCssStyle setFontSize(float f) {
        this.fontSize = f;
        return this;
    }

    public WebvttCssStyle setFontSizeUnit(short v) {
        this.fontSizeUnit = v;
        return this;
    }

    public WebvttCssStyle setItalic(boolean z) {
        this.italic = z;
        return this;
    }

    public WebvttCssStyle setLinethrough(boolean z) {
        this.linethrough = z;
        return this;
    }

    public void setTargetClasses(String[] arr_s) {
        this.targetClasses = Arrays.asList(arr_s);
    }

    public void setTargetId(String s) {
        this.targetId = s;
    }

    public void setTargetTagName(String s) {
        this.targetTag = s;
    }

    public void setTargetVoice(String s) {
        this.targetVoice = s;
    }

    public WebvttCssStyle setTextAlign(Layout.Alignment layout$Alignment0) {
        this.textAlign = layout$Alignment0;
        return this;
    }

    public WebvttCssStyle setUnderline(boolean z) {
        this.underline = z;
        return this;
    }

    private static int updateScoreForMatch(int v, String s, String s1, int v1) {
        if(!s.isEmpty() && v != -1) {
            return s.equals(s1) ? v + v1 : -1;
        }
        return v;
    }
}

