package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements TextOutput {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List cues;
    private final List painters;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;

    public SubtitleView(Context context0) {
        this(context0, null);
    }

    public SubtitleView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.painters = new ArrayList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
    }

    @Override  // android.view.View
    public void dispatchDraw(Canvas canvas0) {
        List list0 = this.cues;
        if(list0 != null && !list0.isEmpty()) {
            int v = this.getHeight();
            int v1 = this.getPaddingLeft();
            int v2 = this.getPaddingTop();
            int v3 = this.getWidth() - this.getPaddingRight();
            int v4 = v - this.getPaddingBottom();
            if(v4 > v2 && v3 > v1) {
                int v5 = v4 - v2;
                float f = this.resolveTextSize(this.textSizeType, this.textSize, v, v5);
                if(f > 0.0f) {
                    int v6 = list0.size();
                    for(int v7 = 0; v7 < v6; ++v7) {
                        Cue cue0 = (Cue)list0.get(v7);
                        float f1 = this.resolveCueTextSize(cue0, v, v5);
                        ((SubtitlePainter)this.painters.get(v7)).draw(cue0, this.applyEmbeddedStyles, this.applyEmbeddedFontSizes, this.style, f, f1, this.bottomPaddingFraction, canvas0, v1, v2, v3, v4);
                    }
                }
            }
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager)this.getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private CaptionStyleCompat getUserCaptionStyleV19() {
        return CaptionStyleCompat.createFromCaptionStyle(((CaptioningManager)this.getContext().getSystemService("captioning")).getUserStyle());
    }

    @TargetApi(19)
    private boolean isCaptionManagerEnabled() {
        return ((CaptioningManager)this.getContext().getSystemService("captioning")).isEnabled();
    }

    @Override  // com.google.android.exoplayer2.text.TextOutput
    public void onCues(List list0) {
        this.setCues(list0);
    }

    private float resolveCueTextSize(Cue cue0, int v, int v1) {
        int v2 = cue0.textSizeType;
        if(v2 != 0x80000000) {
            return cue0.textSize == -3.402823E+38f ? 0.0f : Math.max(this.resolveTextSize(v2, cue0.textSize, v, v1), 0.0f);
        }
        return 0.0f;
    }

    private float resolveTextSize(int v, float f, int v1, int v2) {
        switch(v) {
            case 0: {
                return f * ((float)v2);
            }
            case 1: {
                return f * ((float)v1);
            }
            case 2: {
                return f;
            }
            default: {
                return -3.402823E+38f;
            }
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if(this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedFontSizes = z;
        this.invalidate();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if(this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedStyles = z;
        this.applyEmbeddedFontSizes = z;
        this.invalidate();
    }

    public void setBottomPaddingFraction(float f) {
        if(this.bottomPaddingFraction == f) {
            return;
        }
        this.bottomPaddingFraction = f;
        this.invalidate();
    }

    public void setCues(List list0) {
        if(this.cues == list0) {
            return;
        }
        this.cues = list0;
        int v = list0 == null ? 0 : list0.size();
        while(this.painters.size() < v) {
            SubtitlePainter subtitlePainter0 = new SubtitlePainter(this.getContext());
            this.painters.add(subtitlePainter0);
        }
        this.invalidate();
    }

    public void setFixedTextSize(int v, float f) {
        Context context0 = this.getContext();
        this.setTextSize(2, TypedValue.applyDimension(v, f, (context0 == null ? Resources.getSystem() : context0.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f) {
        this.setFractionalTextSize(f, false);
    }

    public void setFractionalTextSize(float f, boolean z) {
        this.setTextSize(((int)z), f);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat0) {
        if(this.style == captionStyleCompat0) {
            return;
        }
        this.style = captionStyleCompat0;
        this.invalidate();
    }

    private void setTextSize(int v, float f) {
        if(this.textSizeType == v && this.textSize == f) {
            return;
        }
        this.textSizeType = v;
        this.textSize = f;
        this.invalidate();
    }

    public void setUserDefaultStyle() {
        this.setStyle((Util.SDK_INT < 19 || !this.isCaptionManagerEnabled() || this.isInEditMode() ? CaptionStyleCompat.DEFAULT : this.getUserCaptionStyleV19()));
    }

    public void setUserDefaultTextSize() {
        this.setFractionalTextSize((Util.SDK_INT < 19 || this.isInEditMode() ? 1.0f : this.getUserCaptionFontScaleV19()) * 0.0533f);
    }
}

