package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class SubtitlePainter {
    private static final float INNER_PADDING_RATIO = 0.125f;
    private static final String TAG = "SubtitlePainter";
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private int backgroundColor;
    private final Paint bitmapPaint;
    private Rect bitmapRect;
    private float bottomPaddingFraction;
    private Bitmap cueBitmap;
    private float cueBitmapHeight;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private Layout.Alignment cueTextAlignment;
    private float cueTextSizePx;
    private float defaultTextSizePx;
    private int edgeColor;
    private StaticLayout edgeLayout;
    private int edgeType;
    private int foregroundColor;
    private final float outlineWidth;
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint;
    private int textTop;
    private int windowColor;
    private final Paint windowPaint;

    public SubtitlePainter(Context context0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(null, new int[]{0x1010217, 0x1010218}, 0, 0);
        this.spacingAdd = (float)typedArray0.getDimensionPixelSize(0, 0);
        this.spacingMult = typedArray0.getFloat(1, 1.0f);
        typedArray0.recycle();
        float f = (float)Math.round(((float)context0.getResources().getDisplayMetrics().densityDpi) * 2.0f / 160.0f);
        this.outlineWidth = f;
        this.shadowRadius = f;
        this.shadowOffset = f;
        TextPaint textPaint0 = new TextPaint();
        this.textPaint = textPaint0;
        textPaint0.setAntiAlias(true);
        textPaint0.setSubpixelText(true);
        Paint paint0 = new Paint();
        this.windowPaint = paint0;
        paint0.setAntiAlias(true);
        paint0.setStyle(Paint.Style.FILL);
        Paint paint1 = new Paint();
        this.bitmapPaint = paint1;
        paint1.setAntiAlias(true);
        paint1.setFilterBitmap(true);
    }

    // 去混淆评级： 低(20)
    private static boolean areCharSequencesEqual(CharSequence charSequence0, CharSequence charSequence1) {
        return charSequence0 == charSequence1 || charSequence0 != null && charSequence0.equals(charSequence1);
    }

    public void draw(Cue cue0, boolean z, boolean z1, CaptionStyleCompat captionStyleCompat0, float f, float f1, float f2, Canvas canvas0, int v, int v1, int v2, int v3) {
        int v4;
        boolean z2 = cue0.bitmap == null;
        if(z2) {
            if(TextUtils.isEmpty(cue0.text)) {
                return;
            }
            v4 = !cue0.windowColorSet || !z ? captionStyleCompat0.windowColor : cue0.windowColor;
        }
        else {
            v4 = 0xFF000000;
        }
        if(SubtitlePainter.areCharSequencesEqual(this.cueText, cue0.text) && Util.areEqual(this.cueTextAlignment, cue0.textAlignment) && this.cueBitmap == cue0.bitmap && this.cueLine == cue0.line && this.cueLineType == cue0.lineType && Util.areEqual(this.cueLineAnchor, cue0.lineAnchor) && this.cuePosition == cue0.position && Util.areEqual(this.cuePositionAnchor, cue0.positionAnchor) && this.cueSize == cue0.size && this.cueBitmapHeight == cue0.bitmapHeight && this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z1 && this.foregroundColor == captionStyleCompat0.foregroundColor && this.backgroundColor == captionStyleCompat0.backgroundColor && this.windowColor == v4 && this.edgeType == captionStyleCompat0.edgeType && this.edgeColor == captionStyleCompat0.edgeColor && Util.areEqual(this.textPaint.getTypeface(), captionStyleCompat0.typeface) && this.defaultTextSizePx == f && this.cueTextSizePx == f1 && this.bottomPaddingFraction == f2 && this.parentLeft == v && this.parentTop == v1 && this.parentRight == v2 && this.parentBottom == v3) {
            this.drawLayout(canvas0, z2);
            return;
        }
        this.cueText = cue0.text;
        this.cueTextAlignment = cue0.textAlignment;
        this.cueBitmap = cue0.bitmap;
        this.cueLine = cue0.line;
        this.cueLineType = cue0.lineType;
        this.cueLineAnchor = cue0.lineAnchor;
        this.cuePosition = cue0.position;
        this.cuePositionAnchor = cue0.positionAnchor;
        this.cueSize = cue0.size;
        this.cueBitmapHeight = cue0.bitmapHeight;
        this.applyEmbeddedStyles = z;
        this.applyEmbeddedFontSizes = z1;
        this.foregroundColor = captionStyleCompat0.foregroundColor;
        this.backgroundColor = captionStyleCompat0.backgroundColor;
        this.windowColor = v4;
        this.edgeType = captionStyleCompat0.edgeType;
        this.edgeColor = captionStyleCompat0.edgeColor;
        this.textPaint.setTypeface(captionStyleCompat0.typeface);
        this.defaultTextSizePx = f;
        this.cueTextSizePx = f1;
        this.bottomPaddingFraction = f2;
        this.parentLeft = v;
        this.parentTop = v1;
        this.parentRight = v2;
        this.parentBottom = v3;
        if(z2) {
            Assertions.checkNotNull(this.cueText);
            this.setupTextLayout();
        }
        else {
            Assertions.checkNotNull(this.cueBitmap);
            this.setupBitmapLayout();
        }
        this.drawLayout(canvas0, z2);
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void drawBitmapLayout(Canvas canvas0) {
        canvas0.drawBitmap(this.cueBitmap, null, this.bitmapRect, this.bitmapPaint);
    }

    private void drawLayout(Canvas canvas0, boolean z) {
        if(z) {
            this.drawTextLayout(canvas0);
            return;
        }
        Assertions.checkNotNull(this.bitmapRect);
        Assertions.checkNotNull(this.cueBitmap);
        this.drawBitmapLayout(canvas0);
    }

    private void drawTextLayout(Canvas canvas0) {
        StaticLayout staticLayout0 = this.textLayout;
        StaticLayout staticLayout1 = this.edgeLayout;
        if(staticLayout0 != null && staticLayout1 != null) {
            int v = canvas0.save();
            canvas0.translate(((float)this.textLeft), ((float)this.textTop));
            if(Color.alpha(this.windowColor) > 0) {
                this.windowPaint.setColor(this.windowColor);
                canvas0.drawRect(((float)(-this.textPaddingX)), 0.0f, ((float)(staticLayout0.getWidth() + this.textPaddingX)), ((float)staticLayout0.getHeight()), this.windowPaint);
            }
            int v1 = this.edgeType;
            boolean z = true;
            if(v1 == 1) {
                this.textPaint.setStrokeJoin(Paint.Join.ROUND);
                this.textPaint.setStrokeWidth(this.outlineWidth);
                this.textPaint.setColor(this.edgeColor);
                this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout1.draw(canvas0);
            }
            else {
                switch(v1) {
                    case 2: {
                        this.textPaint.setShadowLayer(this.shadowRadius, this.shadowOffset, this.shadowOffset, this.edgeColor);
                        break;
                    }
                    case 3: 
                    case 4: {
                        if(v1 != 3) {
                            z = false;
                        }
                        int v2 = -1;
                        int v3 = z ? -1 : this.edgeColor;
                        if(z) {
                            v2 = this.edgeColor;
                        }
                        float f = this.shadowRadius / 2.0f;
                        this.textPaint.setColor(this.foregroundColor);
                        this.textPaint.setStyle(Paint.Style.FILL);
                        this.textPaint.setShadowLayer(this.shadowRadius, -f, -f, v3);
                        staticLayout1.draw(canvas0);
                        this.textPaint.setShadowLayer(this.shadowRadius, f, f, v2);
                    }
                }
            }
            this.textPaint.setColor(this.foregroundColor);
            this.textPaint.setStyle(Paint.Style.FILL);
            staticLayout0.draw(canvas0);
            this.textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas0.restoreToCount(v);
        }
    }

    @RequiresNonNull({"cueBitmap"})
    private void setupBitmapLayout() {
        Bitmap bitmap0 = this.cueBitmap;
        float f = (float)(this.parentRight - this.parentLeft);
        float f1 = this.cuePosition * f + ((float)this.parentLeft);
        float f2 = (float)(this.parentBottom - this.parentTop);
        float f3 = this.cueLine * f2 + ((float)this.parentTop);
        int v = Math.round(f * this.cueSize);
        float f4 = this.cueBitmapHeight;
        int v1 = f4 == -3.402823E+38f ? Math.round(((float)bitmap0.getHeight()) / ((float)bitmap0.getWidth()) * ((float)v)) : Math.round(f2 * f4);
        int v2 = this.cuePositionAnchor;
        if(v2 == 2) {
            f1 -= (float)v;
        }
        else if(v2 == 1) {
            f1 -= (float)(v / 2);
        }
        int v3 = Math.round(f1);
        int v4 = this.cueLineAnchor;
        if(v4 == 2) {
            f3 -= (float)v1;
        }
        else if(v4 == 1) {
            f3 -= (float)(v1 / 2);
        }
        int v5 = Math.round(f3);
        this.bitmapRect = new Rect(v3, v5, v + v3, v1 + v5);
    }

    @RequiresNonNull({"cueText"})
    private void setupTextLayout() {
        int v22;
        int v20;
        int v19;
        int v17;
        int v16;
        CharSequence charSequence1;
        SpannableStringBuilder spannableStringBuilder0;
        CharSequence charSequence0 = this.cueText;
        int v = this.parentRight - this.parentLeft;
        int v1 = this.parentBottom - this.parentTop;
        this.textPaint.setTextSize(this.defaultTextSizePx);
        int v2 = (int)(this.defaultTextSizePx * 0.125f + 0.5f);
        int v3 = v - v2 * 2;
        float f = this.cueSize;
        if(f != -3.402823E+38f) {
            v3 = (int)(((float)v3) * f);
        }
        int v4 = v3;
        if(v4 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if(!this.applyEmbeddedStyles) {
            charSequence0 = charSequence0.toString();
        }
        else if(!this.applyEmbeddedFontSizes) {
            spannableStringBuilder0 = new SpannableStringBuilder(charSequence0);
            int v5 = spannableStringBuilder0.length();
            AbsoluteSizeSpan[] arr_absoluteSizeSpan = (AbsoluteSizeSpan[])spannableStringBuilder0.getSpans(0, v5, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] arr_relativeSizeSpan = (RelativeSizeSpan[])spannableStringBuilder0.getSpans(0, v5, RelativeSizeSpan.class);
            for(int v6 = 0; v6 < arr_absoluteSizeSpan.length; ++v6) {
                spannableStringBuilder0.removeSpan(arr_absoluteSizeSpan[v6]);
            }
            for(int v7 = 0; v7 < arr_relativeSizeSpan.length; ++v7) {
                spannableStringBuilder0.removeSpan(arr_relativeSizeSpan[v7]);
            }
            charSequence0 = spannableStringBuilder0;
        }
        else if(this.cueTextSizePx > 0.0f) {
            spannableStringBuilder0 = new SpannableStringBuilder(charSequence0);
            spannableStringBuilder0.setSpan(new AbsoluteSizeSpan(((int)this.cueTextSizePx)), 0, spannableStringBuilder0.length(), 0xFF0000);
            charSequence0 = spannableStringBuilder0;
        }
        SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(charSequence0);
        if(this.edgeType == 1) {
            ForegroundColorSpan[] arr_foregroundColorSpan = (ForegroundColorSpan[])spannableStringBuilder1.getSpans(0, spannableStringBuilder1.length(), ForegroundColorSpan.class);
            for(int v8 = 0; v8 < arr_foregroundColorSpan.length; ++v8) {
                spannableStringBuilder1.removeSpan(arr_foregroundColorSpan[v8]);
            }
        }
        if(Color.alpha(this.backgroundColor) <= 0) {
            charSequence1 = charSequence0;
        }
        else if(this.edgeType != 0 && this.edgeType != 2) {
            spannableStringBuilder1.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder1.length(), 0xFF0000);
            charSequence1 = charSequence0;
        }
        else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence0);
            spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.backgroundColor), 0, spannableStringBuilder2.length(), 0xFF0000);
            charSequence1 = spannableStringBuilder2;
        }
        Layout.Alignment layout$Alignment0 = this.cueTextAlignment == null ? Layout.Alignment.ALIGN_CENTER : this.cueTextAlignment;
        StaticLayout staticLayout0 = new StaticLayout(charSequence1, this.textPaint, v4, layout$Alignment0, this.spacingMult, this.spacingAdd, true);
        this.textLayout = staticLayout0;
        int v9 = staticLayout0.getHeight();
        int v10 = this.textLayout.getLineCount();
        int v12 = 0;
        for(int v11 = 0; v11 < v10; ++v11) {
            v12 = Math.max(((int)Math.ceil(this.textLayout.getLineWidth(v11))), v12);
        }
        if(this.cueSize == -3.402823E+38f || v12 >= v4) {
            v4 = v12;
        }
        int v13 = v4 + v2 * 2;
        float f1 = this.cuePosition;
        if(f1 == -3.402823E+38f) {
            v16 = (v - v13) / 2 + this.parentLeft;
            v17 = v16 + v13;
        }
        else {
            int v14 = this.parentLeft;
            int v15 = Math.round(((float)v) * f1) + v14;
            switch(this.cuePositionAnchor) {
                case 1: {
                    v15 = (v15 * 2 - v13) / 2;
                    break;
                }
                case 2: {
                    v15 -= v13;
                }
            }
            v16 = Math.max(v15, v14);
            v17 = Math.min(v13 + v16, this.parentRight);
        }
        int v18 = v17 - v16;
        if(v18 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f2 = this.cueLine;
        if(f2 == -3.402823E+38f) {
            v22 = this.parentBottom - v9 - ((int)(((float)v1) * this.bottomPaddingFraction));
        }
        else {
            if(this.cueLineType == 0) {
                v19 = Math.round(((float)v1) * f2);
                v20 = this.parentTop;
            }
            else {
                int v21 = this.textLayout.getLineBottom(0) - this.textLayout.getLineTop(0);
                float f3 = this.cueLine;
                if(f3 >= 0.0f) {
                    v19 = Math.round(f3 * ((float)v21));
                    v20 = this.parentTop;
                }
                else {
                    v19 = Math.round((f3 + 1.0f) * ((float)v21));
                    v20 = this.parentBottom;
                }
            }
            v22 = v19 + v20;
            int v23 = this.cueLineAnchor;
            if(v23 == 2) {
                v22 -= v9;
            }
            else if(v23 == 1) {
                v22 = (v22 * 2 - v9) / 2;
            }
            int v24 = this.parentBottom;
            if(v22 + v9 > v24) {
                v22 = v24 - v9;
            }
            else {
                int v25 = this.parentTop;
                if(v22 < v25) {
                    v22 = v25;
                }
            }
        }
        this.textLayout = new StaticLayout(charSequence1, this.textPaint, v18, layout$Alignment0, this.spacingMult, this.spacingAdd, true);
        this.edgeLayout = new StaticLayout(spannableStringBuilder1, this.textPaint, v18, layout$Alignment0, this.spacingMult, this.spacingAdd, true);
        this.textLeft = v16;
        this.textTop = v22;
        this.textPaddingX = v2;
    }
}

