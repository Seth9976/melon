package com.airbnb.lottie.model;

import U4.x;
import android.graphics.PointF;

public class DocumentData {
    public static enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER;

        private static Justification[] $values() [...] // Inlined contents
    }

    public float baselineShift;
    public PointF boxPosition;
    public PointF boxSize;
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    public DocumentData() {
    }

    public DocumentData(String s, String s1, float f, Justification documentData$Justification0, int v, float f1, float f2, int v1, int v2, float f3, boolean z, PointF pointF0, PointF pointF1) {
        this.set(s, s1, f, documentData$Justification0, v, f1, f2, v1, v2, f3, z, pointF0, pointF1);
    }

    @Override
    public int hashCode() {
        long v = (long)Float.floatToRawIntBits(this.lineHeight);
        return (((this.justification.ordinal() + ((int)(((float)x.b(this.text.hashCode() * 0x1F, 0x1F, this.fontName)) + this.size)) * 0x1F) * 0x1F + this.tracking) * 0x1F + ((int)(v ^ v >>> 0x20))) * 0x1F + this.color;
    }

    public void set(String s, String s1, float f, Justification documentData$Justification0, int v, float f1, float f2, int v1, int v2, float f3, boolean z, PointF pointF0, PointF pointF1) {
        this.text = s;
        this.fontName = s1;
        this.size = f;
        this.justification = documentData$Justification0;
        this.tracking = v;
        this.lineHeight = f1;
        this.baselineShift = f2;
        this.color = v1;
        this.strokeColor = v2;
        this.strokeWidth = f3;
        this.strokeOverFill = z;
        this.boxPosition = pointF0;
        this.boxSize = pointF1;
    }
}

