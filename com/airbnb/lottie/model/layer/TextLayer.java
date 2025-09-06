package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.s;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTextRangeSelector;
import com.airbnb.lottie.model.animatable.AnimatableTextStyle;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLayer extends BaseLayer {
    static class TextSubLine {
        private String text;
        private float width;

        private TextSubLine() {
            this.text = "";
            this.width = 0.0f;
        }

        public TextSubLine(com.airbnb.lottie.model.layer.TextLayer.1 textLayer$10) {
        }

        public static float access$000(TextSubLine textLayer$TextSubLine0) {
            return textLayer$TextSubLine0.width;
        }

        public static String access$100(TextSubLine textLayer$TextSubLine0) {
            return textLayer$TextSubLine0.text;
        }

        public void set(String s, float f) {
            this.text = s;
            this.width = f;
        }
    }

    private final s codePointCache;
    private BaseKeyframeAnimation colorAnimation;
    private BaseKeyframeAnimation colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private BaseKeyframeAnimation opacityAnimation;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    private BaseKeyframeAnimation strokeColorAnimation;
    private BaseKeyframeAnimation strokeColorCallbackAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation strokeWidthAnimation;
    private BaseKeyframeAnimation strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation textRangeEndAnimation;
    private BaseKeyframeAnimation textRangeOffsetAnimation;
    private BaseKeyframeAnimation textRangeStartAnimation;
    private TextRangeUnits textRangeUnits;
    private BaseKeyframeAnimation textSizeCallbackAnimation;
    private final List textSubLines;
    private BaseKeyframeAnimation trackingAnimation;
    private BaseKeyframeAnimation trackingCallbackAnimation;
    private BaseKeyframeAnimation typefaceCallbackAnimation;

    public TextLayer(LottieDrawable lottieDrawable0, Layer layer0) {
        super(lottieDrawable0, layer0);
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.fillPaint = new Paint(1) {
            {
                int v = 1;  // 捕获的参数
                this.setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(1) {
            {
                int v = 1;  // 捕获的参数
                this.setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new s(null);
        this.textSubLines = new ArrayList();
        this.textRangeUnits = TextRangeUnits.INDEX;
        this.lottieDrawable = lottieDrawable0;
        this.composition = layer0.getComposition();
        TextKeyframeAnimation textKeyframeAnimation0 = layer0.getText().createAnimation();
        this.textAnimation = textKeyframeAnimation0;
        textKeyframeAnimation0.addUpdateListener(this);
        this.addAnimation(textKeyframeAnimation0);
        AnimatableTextProperties animatableTextProperties0 = layer0.getTextProperties();
        if(animatableTextProperties0 != null) {
            AnimatableTextStyle animatableTextStyle0 = animatableTextProperties0.textStyle;
            if(animatableTextStyle0 != null) {
                AnimatableColorValue animatableColorValue0 = animatableTextStyle0.color;
                if(animatableColorValue0 != null) {
                    BaseKeyframeAnimation baseKeyframeAnimation0 = animatableColorValue0.createAnimation();
                    this.colorAnimation = baseKeyframeAnimation0;
                    baseKeyframeAnimation0.addUpdateListener(this);
                    this.addAnimation(this.colorAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextStyle animatableTextStyle1 = animatableTextProperties0.textStyle;
            if(animatableTextStyle1 != null) {
                AnimatableColorValue animatableColorValue1 = animatableTextStyle1.stroke;
                if(animatableColorValue1 != null) {
                    BaseKeyframeAnimation baseKeyframeAnimation1 = animatableColorValue1.createAnimation();
                    this.strokeColorAnimation = baseKeyframeAnimation1;
                    baseKeyframeAnimation1.addUpdateListener(this);
                    this.addAnimation(this.strokeColorAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextStyle animatableTextStyle2 = animatableTextProperties0.textStyle;
            if(animatableTextStyle2 != null) {
                AnimatableFloatValue animatableFloatValue0 = animatableTextStyle2.strokeWidth;
                if(animatableFloatValue0 != null) {
                    FloatKeyframeAnimation floatKeyframeAnimation0 = animatableFloatValue0.createAnimation();
                    this.strokeWidthAnimation = floatKeyframeAnimation0;
                    floatKeyframeAnimation0.addUpdateListener(this);
                    this.addAnimation(this.strokeWidthAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextStyle animatableTextStyle3 = animatableTextProperties0.textStyle;
            if(animatableTextStyle3 != null) {
                AnimatableFloatValue animatableFloatValue1 = animatableTextStyle3.tracking;
                if(animatableFloatValue1 != null) {
                    FloatKeyframeAnimation floatKeyframeAnimation1 = animatableFloatValue1.createAnimation();
                    this.trackingAnimation = floatKeyframeAnimation1;
                    floatKeyframeAnimation1.addUpdateListener(this);
                    this.addAnimation(this.trackingAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextStyle animatableTextStyle4 = animatableTextProperties0.textStyle;
            if(animatableTextStyle4 != null) {
                AnimatableIntegerValue animatableIntegerValue0 = animatableTextStyle4.opacity;
                if(animatableIntegerValue0 != null) {
                    BaseKeyframeAnimation baseKeyframeAnimation2 = animatableIntegerValue0.createAnimation();
                    this.opacityAnimation = baseKeyframeAnimation2;
                    baseKeyframeAnimation2.addUpdateListener(this);
                    this.addAnimation(this.opacityAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextRangeSelector animatableTextRangeSelector0 = animatableTextProperties0.rangeSelector;
            if(animatableTextRangeSelector0 != null) {
                AnimatableIntegerValue animatableIntegerValue1 = animatableTextRangeSelector0.start;
                if(animatableIntegerValue1 != null) {
                    BaseKeyframeAnimation baseKeyframeAnimation3 = animatableIntegerValue1.createAnimation();
                    this.textRangeStartAnimation = baseKeyframeAnimation3;
                    baseKeyframeAnimation3.addUpdateListener(this);
                    this.addAnimation(this.textRangeStartAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextRangeSelector animatableTextRangeSelector1 = animatableTextProperties0.rangeSelector;
            if(animatableTextRangeSelector1 != null) {
                AnimatableIntegerValue animatableIntegerValue2 = animatableTextRangeSelector1.end;
                if(animatableIntegerValue2 != null) {
                    BaseKeyframeAnimation baseKeyframeAnimation4 = animatableIntegerValue2.createAnimation();
                    this.textRangeEndAnimation = baseKeyframeAnimation4;
                    baseKeyframeAnimation4.addUpdateListener(this);
                    this.addAnimation(this.textRangeEndAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextRangeSelector animatableTextRangeSelector2 = animatableTextProperties0.rangeSelector;
            if(animatableTextRangeSelector2 != null) {
                AnimatableIntegerValue animatableIntegerValue3 = animatableTextRangeSelector2.offset;
                if(animatableIntegerValue3 != null) {
                    BaseKeyframeAnimation baseKeyframeAnimation5 = animatableIntegerValue3.createAnimation();
                    this.textRangeOffsetAnimation = baseKeyframeAnimation5;
                    baseKeyframeAnimation5.addUpdateListener(this);
                    this.addAnimation(this.textRangeOffsetAnimation);
                }
            }
        }
        if(animatableTextProperties0 != null) {
            AnimatableTextRangeSelector animatableTextRangeSelector3 = animatableTextProperties0.rangeSelector;
            if(animatableTextRangeSelector3 != null) {
                this.textRangeUnits = animatableTextRangeSelector3.units;
            }
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void addValueCallback(Object object0, LottieValueCallback lottieValueCallback0) {
        super.addValueCallback(object0, lottieValueCallback0);
        if(object0 == LottieProperty.COLOR) {
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.colorCallbackAnimation;
            if(baseKeyframeAnimation0 != null) {
                this.removeAnimation(baseKeyframeAnimation0);
            }
            if(lottieValueCallback0 == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation0 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation0;
            valueCallbackKeyframeAnimation0.addUpdateListener(this);
            this.addAnimation(this.colorCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.strokeColorCallbackAnimation;
            if(baseKeyframeAnimation1 != null) {
                this.removeAnimation(baseKeyframeAnimation1);
            }
            if(lottieValueCallback0 == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation1 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation1;
            valueCallbackKeyframeAnimation1.addUpdateListener(this);
            this.addAnimation(this.strokeColorCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.strokeWidthCallbackAnimation;
            if(baseKeyframeAnimation2 != null) {
                this.removeAnimation(baseKeyframeAnimation2);
            }
            if(lottieValueCallback0 == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.addAnimation(this.strokeWidthCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.trackingCallbackAnimation;
            if(baseKeyframeAnimation3 != null) {
                this.removeAnimation(baseKeyframeAnimation3);
            }
            if(lottieValueCallback0 == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            this.addAnimation(this.trackingCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.textSizeCallbackAnimation;
            if(baseKeyframeAnimation4 != null) {
                this.removeAnimation(baseKeyframeAnimation4);
            }
            if(lottieValueCallback0 == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            this.addAnimation(this.textSizeCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.TYPEFACE) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.typefaceCallbackAnimation;
            if(baseKeyframeAnimation5 != null) {
                this.removeAnimation(baseKeyframeAnimation5);
            }
            if(lottieValueCallback0 == null) {
                this.typefaceCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback0);
            this.typefaceCallbackAnimation = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            this.addAnimation(this.typefaceCallbackAnimation);
            return;
        }
        if(object0 == LottieProperty.TEXT) {
            this.textAnimation.setStringValueCallback(lottieValueCallback0);
        }
    }

    private String codePointToString(String s, int v) {
        int v1 = s.codePointAt(v);
        int v2 = Character.charCount(v1) + v;
        while(v2 < s.length()) {
            int v3 = s.codePointAt(v2);
            if(!this.isModifier(v3)) {
                break;
            }
            v2 += Character.charCount(v3);
            v1 = v1 * 0x1F + v3;
        }
        if(this.codePointCache.c(((long)v1)) >= 0) {
            return (String)this.codePointCache.b(((long)v1));
        }
        this.stringBuilder.setLength(0);
        while(v < v2) {
            int v4 = s.codePointAt(v);
            this.stringBuilder.appendCodePoint(v4);
            v += Character.charCount(v4);
        }
        String s1 = this.stringBuilder.toString();
        this.codePointCache.f(((long)v1), s1);
        return s1;
    }

    private void configurePaint(DocumentData documentData0, int v, int v1) {
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.colorCallbackAnimation;
        if(baseKeyframeAnimation0 != null) {
            int v2 = (int)(((Integer)baseKeyframeAnimation0.getValue()));
            this.fillPaint.setColor(v2);
        }
        else if(this.colorAnimation == null || !this.isIndexInRangeSelection(v1)) {
            this.fillPaint.setColor(documentData0.color);
        }
        else {
            int v3 = (int)(((Integer)this.colorAnimation.getValue()));
            this.fillPaint.setColor(v3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation1 = this.strokeColorCallbackAnimation;
        if(baseKeyframeAnimation1 != null) {
            int v4 = (int)(((Integer)baseKeyframeAnimation1.getValue()));
            this.strokePaint.setColor(v4);
        }
        else if(this.strokeColorAnimation == null || !this.isIndexInRangeSelection(v1)) {
            this.strokePaint.setColor(documentData0.strokeColor);
        }
        else {
            int v5 = (int)(((Integer)this.strokeColorAnimation.getValue()));
            this.strokePaint.setColor(v5);
        }
        int v6 = 100;
        int v7 = this.transform.getOpacity() == null ? 100 : ((int)(((Integer)this.transform.getOpacity().getValue())));
        if(this.opacityAnimation != null && this.isIndexInRangeSelection(v1)) {
            v6 = (int)(((Integer)this.opacityAnimation.getValue()));
        }
        int v8 = Math.round(((float)v6) / 100.0f * (((float)v7) * 255.0f / 100.0f) * ((float)v) / 255.0f);
        this.fillPaint.setAlpha(v8);
        this.strokePaint.setAlpha(v8);
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.strokeWidthCallbackAnimation;
        if(baseKeyframeAnimation2 != null) {
            float f = (float)(((Float)baseKeyframeAnimation2.getValue()));
            this.strokePaint.setStrokeWidth(f);
            return;
        }
        if(this.strokeWidthAnimation != null && this.isIndexInRangeSelection(v1)) {
            float f1 = (float)(((Float)this.strokeWidthAnimation.getValue()));
            this.strokePaint.setStrokeWidth(f1);
            return;
        }
        float f2 = documentData0.strokeWidth;
        float f3 = Utils.dpScale();
        this.strokePaint.setStrokeWidth(f3 * f2);
    }

    private void drawCharacter(String s, Paint paint0, Canvas canvas0) {
        if(paint0.getColor() == 0 || paint0.getStyle() == Paint.Style.STROKE && paint0.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas0.drawText(s, 0, s.length(), 0.0f, 0.0f, paint0);
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter0, float f, DocumentData documentData0, Canvas canvas0, int v, int v1) {
        this.configurePaint(documentData0, v1, v);
        List list0 = this.getContentsForCharacter(fontCharacter0);
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            Path path0 = ((ContentGroup)list0.get(v2)).getPath();
            path0.computeBounds(this.rectF, false);
            this.matrix.reset();
            float f1 = -documentData0.baselineShift;
            float f2 = Utils.dpScale();
            this.matrix.preTranslate(0.0f, f2 * f1);
            this.matrix.preScale(f, f);
            path0.transform(this.matrix);
            if(documentData0.strokeOverFill) {
                this.drawGlyph(path0, this.fillPaint, canvas0);
                this.drawGlyph(path0, this.strokePaint, canvas0);
            }
            else {
                this.drawGlyph(path0, this.strokePaint, canvas0);
                this.drawGlyph(path0, this.fillPaint, canvas0);
            }
        }
    }

    private void drawCharacterFromFont(String s, DocumentData documentData0, Canvas canvas0, int v, int v1) {
        this.configurePaint(documentData0, v1, v);
        if(documentData0.strokeOverFill) {
            this.drawCharacter(s, this.fillPaint, canvas0);
            this.drawCharacter(s, this.strokePaint, canvas0);
            return;
        }
        this.drawCharacter(s, this.strokePaint, canvas0);
        this.drawCharacter(s, this.fillPaint, canvas0);
    }

    private void drawFontTextLine(String s, DocumentData documentData0, Canvas canvas0, float f, int v, int v1) {
        for(int v2 = 0; v2 < s.length(); v2 += s1.length()) {
            String s1 = this.codePointToString(s, v2);
            this.drawCharacterFromFont(s1, documentData0, canvas0, v + v2, v1);
            canvas0.translate(this.fillPaint.measureText(s1) + f, 0.0f);
        }
    }

    private void drawGlyph(Path path0, Paint paint0, Canvas canvas0) {
        if(paint0.getColor() == 0 || paint0.getStyle() == Paint.Style.STROKE && paint0.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas0.drawPath(path0, paint0);
    }

    private void drawGlyphTextLine(String s, DocumentData documentData0, Font font0, Canvas canvas0, float f, float f1, float f2, int v) {
        for(int v1 = 0; v1 < s.length(); ++v1) {
            FontCharacter fontCharacter0 = (FontCharacter)this.composition.getCharacters().c(FontCharacter.hashFor(s.charAt(v1), font0.getFamily(), font0.getStyle()));
            if(fontCharacter0 != null) {
                this.drawCharacterAsGlyph(fontCharacter0, f1, documentData0, canvas0, v1, v);
                canvas0.translate(Utils.dpScale() * (((float)fontCharacter0.getWidth()) * f1) + f2, 0.0f);
            }
        }
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas0, Matrix matrix0, int v, DropShadow dropShadow0) {
        Object object0 = this.textAnimation.getValue();
        Object object1 = this.composition.getFonts().get(((DocumentData)object0).fontName);
        if(((Font)object1) == null) {
            return;
        }
        canvas0.save();
        canvas0.concat(matrix0);
        this.configurePaint(((DocumentData)object0), v, 0);
        if(this.lottieDrawable.useTextGlyphs()) {
            this.drawTextWithGlyphs(((DocumentData)object0), matrix0, ((Font)object1), canvas0, v);
        }
        else {
            this.drawTextWithFont(((DocumentData)object0), ((Font)object1), canvas0, v);
        }
        canvas0.restore();
    }

    private void drawTextWithFont(DocumentData documentData0, Font font0, Canvas canvas0, int v) {
        int v6;
        float f6;
        Typeface typeface0 = this.getTypeface(font0);
        if(typeface0 != null) {
            String s = documentData0.text;
            TextDelegate textDelegate0 = this.lottieDrawable.getTextDelegate();
            if(textDelegate0 != null) {
                s = textDelegate0.getTextInternal(this.getName(), s);
            }
            this.fillPaint.setTypeface(typeface0);
            float f = this.textSizeCallbackAnimation == null ? documentData0.size : ((float)(((Float)this.textSizeCallbackAnimation.getValue())));
            float f1 = Utils.dpScale();
            this.fillPaint.setTextSize(f1 * f);
            Typeface typeface1 = this.fillPaint.getTypeface();
            this.strokePaint.setTypeface(typeface1);
            float f2 = this.fillPaint.getTextSize();
            this.strokePaint.setTextSize(f2);
            float f3 = ((float)documentData0.tracking) / 10.0f;
            BaseKeyframeAnimation baseKeyframeAnimation0 = this.trackingCallbackAnimation;
            if(baseKeyframeAnimation0 == null) {
                BaseKeyframeAnimation baseKeyframeAnimation1 = this.trackingAnimation;
                if(baseKeyframeAnimation1 != null) {
                    f3 += (float)(((Float)baseKeyframeAnimation1.getValue()));
                }
            }
            else {
                f3 += (float)(((Float)baseKeyframeAnimation0.getValue()));
            }
            float f4 = Utils.dpScale() * f3 * f / 100.0f;
            List list0 = this.getTextLines(s);
            int v1 = list0.size();
            int v2 = -1;
            int v4 = 0;
            for(int v3 = 0; v3 < v1; ++v3) {
                float f5 = f4;
                List list1 = this.splitGlyphTextIntoLines(((String)list0.get(v3)), (documentData0.boxSize == null ? 0.0f : documentData0.boxSize.x), font0, 0.0f, f5, false);
                int v5 = 0;
                while(v5 < list1.size()) {
                    TextSubLine textLayer$TextSubLine0 = (TextSubLine)list1.get(v5);
                    ++v2;
                    canvas0.save();
                    if(this.offsetCanvas(canvas0, documentData0, v2, (this.textAnimation != null || this.textSizeCallbackAnimation != null || this.trackingCallbackAnimation != null ? this.fillPaint.measureText(TextSubLine.access$100(textLayer$TextSubLine0)) : TextSubLine.access$000(textLayer$TextSubLine0)))) {
                        f6 = f5;
                        v6 = v4;
                        this.drawFontTextLine(TextSubLine.access$100(textLayer$TextSubLine0), documentData0, canvas0, f6, v6, v);
                    }
                    else {
                        f6 = f5;
                        v6 = v4;
                    }
                    v4 = TextSubLine.access$100(textLayer$TextSubLine0).length() + v6;
                    canvas0.restore();
                    ++v5;
                    f5 = f6;
                }
                f4 = f5;
            }
        }
    }

    private void drawTextWithGlyphs(DocumentData documentData0, Matrix matrix0, Font font0, Canvas canvas0, int v) {
        float f4;
        float f = this.textSizeCallbackAnimation == null ? documentData0.size : ((float)(((Float)this.textSizeCallbackAnimation.getValue())));
        float f1 = Utils.getScale(matrix0);
        List list0 = this.getTextLines(documentData0.text);
        int v1 = list0.size();
        float f2 = ((float)documentData0.tracking) / 10.0f;
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.trackingCallbackAnimation;
        if(baseKeyframeAnimation0 == null) {
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.trackingAnimation;
            if(baseKeyframeAnimation1 != null) {
                f2 += (float)(((Float)baseKeyframeAnimation1.getValue()));
            }
        }
        else {
            f2 += (float)(((Float)baseKeyframeAnimation0.getValue()));
        }
        float f3 = f2;
        int v2 = -1;
        for(int v3 = 0; v3 < v1; ++v3) {
            List list1 = this.splitGlyphTextIntoLines(((String)list0.get(v3)), (documentData0.boxSize == null ? 0.0f : documentData0.boxSize.x), font0, f / 100.0f, f3, true);
            int v4 = 0;
            while(v4 < list1.size()) {
                TextSubLine textLayer$TextSubLine0 = (TextSubLine)list1.get(v4);
                ++v2;
                canvas0.save();
                if(this.offsetCanvas(canvas0, documentData0, v2, TextSubLine.access$000(textLayer$TextSubLine0))) {
                    f4 = f3;
                    this.drawGlyphTextLine(TextSubLine.access$100(textLayer$TextSubLine0), documentData0, font0, canvas0, f1, f / 100.0f, f4, v);
                }
                else {
                    f4 = f3;
                }
                canvas0.restore();
                ++v4;
                f3 = f4;
            }
        }
    }

    private TextSubLine ensureEnoughSubLines(int v) {
        for(int v1 = this.textSubLines.size(); v1 < v; ++v1) {
            TextSubLine textLayer$TextSubLine0 = new TextSubLine(null);
            this.textSubLines.add(textLayer$TextSubLine0);
        }
        return (TextSubLine)this.textSubLines.get(v - 1);
    }

    @Override  // com.airbnb.lottie.model.layer.BaseLayer
    public void getBounds(RectF rectF0, Matrix matrix0, boolean z) {
        super.getBounds(rectF0, matrix0, z);
        rectF0.set(0.0f, 0.0f, ((float)this.composition.getBounds().width()), ((float)this.composition.getBounds().height()));
    }

    private List getContentsForCharacter(FontCharacter fontCharacter0) {
        if(this.contentsForCharacter.containsKey(fontCharacter0)) {
            return (List)this.contentsForCharacter.get(fontCharacter0);
        }
        List list0 = fontCharacter0.getShapes();
        int v = list0.size();
        List list1 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            ShapeGroup shapeGroup0 = (ShapeGroup)list0.get(v1);
            ((ArrayList)list1).add(new ContentGroup(this.lottieDrawable, this, shapeGroup0, this.composition));
        }
        this.contentsForCharacter.put(fontCharacter0, list1);
        return list1;
    }

    private List getTextLines(String s) {
        return Arrays.asList(s.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface getTypeface(Font font0) {
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.typefaceCallbackAnimation;
        if(baseKeyframeAnimation0 != null) {
            Typeface typeface0 = (Typeface)baseKeyframeAnimation0.getValue();
            if(typeface0 != null) {
                return typeface0;
            }
        }
        Typeface typeface1 = this.lottieDrawable.getTypeface(font0);
        return typeface1 == null ? font0.getTypeface() : typeface1;
    }

    private boolean isIndexInRangeSelection(int v) {
        int v1 = ((DocumentData)this.textAnimation.getValue()).text.length();
        BaseKeyframeAnimation baseKeyframeAnimation0 = this.textRangeStartAnimation;
        if(baseKeyframeAnimation0 != null && this.textRangeEndAnimation != null) {
            int v2 = Math.min(((int)(((Integer)baseKeyframeAnimation0.getValue()))), ((int)(((Integer)this.textRangeEndAnimation.getValue()))));
            int v3 = Math.max(((int)(((Integer)this.textRangeStartAnimation.getValue()))), ((int)(((Integer)this.textRangeEndAnimation.getValue()))));
            BaseKeyframeAnimation baseKeyframeAnimation1 = this.textRangeOffsetAnimation;
            if(baseKeyframeAnimation1 != null) {
                int v4 = (int)(((Integer)baseKeyframeAnimation1.getValue()));
                v2 += v4;
                v3 += v4;
            }
            if(this.textRangeUnits == TextRangeUnits.INDEX) {
                return v >= v2 && v < v3;
            }
            float f = ((float)v) / ((float)v1) * 100.0f;
            return f >= ((float)v2) && f < ((float)v3);
        }
        return true;
    }

    private boolean isModifier(int v) {
        switch(Character.getType(v)) {
            case 6: 
            case 8: 
            case 16: 
            case 19: 
            case 27: 
            case 28: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private boolean offsetCanvas(Canvas canvas0, DocumentData documentData0, int v, float f) {
        PointF pointF0 = documentData0.boxPosition;
        PointF pointF1 = documentData0.boxSize;
        float f1 = Utils.dpScale();
        float f2 = 0.0f;
        float f3 = ((float)v) * documentData0.lineHeight * f1 + (pointF0 == null ? 0.0f : documentData0.lineHeight * f1 + pointF0.y);
        if(this.lottieDrawable.getClipTextToBoundingBox() && pointF1 != null && pointF0 != null && f3 >= pointF0.y + pointF1.y + documentData0.size) {
            return false;
        }
        float f4 = pointF0 == null ? 0.0f : pointF0.x;
        if(pointF1 != null) {
            f2 = pointF1.x;
        }
        switch(com.airbnb.lottie.model.layer.TextLayer.3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[documentData0.justification.ordinal()]) {
            case 1: {
                canvas0.translate(f4, f3);
                return true;
            }
            case 2: {
                canvas0.translate(f4 + f2 - f, f3);
                return true;
            }
            case 3: {
                canvas0.translate(f2 / 2.0f + f4 - f / 2.0f, f3);
                return true;
            }
            default: {
                return true;
            }
        }
    }

    private List splitGlyphTextIntoLines(String s, float f, Font font0, float f1, float f2, boolean z) {
        float f6;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        boolean z1 = false;
        int v3 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        while(v < s.length()) {
            int v4 = s.charAt(v);
            if(z) {
                FontCharacter fontCharacter0 = (FontCharacter)this.composition.getCharacters().c(FontCharacter.hashFor(((char)v4), font0.getFamily(), font0.getStyle()));
                if(fontCharacter0 != null) {
                    f6 = Utils.dpScale() * (((float)fontCharacter0.getWidth()) * f1) + f2;
                    goto label_16;
                }
            }
            else {
                f6 = this.fillPaint.measureText(s.substring(v, v + 1)) + f2;
            label_16:
                if(v4 == 0x20) {
                    z1 = true;
                    f5 = f6;
                }
                else if(z1) {
                    z1 = false;
                    v3 = v;
                    f4 = f6;
                }
                else {
                    f4 += f6;
                }
                f3 += f6;
                if(f > 0.0f && f3 >= f && v4 != 0x20) {
                    ++v1;
                    TextSubLine textLayer$TextSubLine0 = this.ensureEnoughSubLines(v1);
                    if(v3 == v2) {
                        String s1 = s.substring(v2, v);
                        String s2 = s1.trim();
                        textLayer$TextSubLine0.set(s2, f3 - f6 - ((float)(s2.length() - s1.length())) * f5);
                        v2 = v;
                        v3 = v2;
                        f3 = f6;
                        f4 = f3;
                    }
                    else {
                        String s3 = s.substring(v2, v3 - 1);
                        String s4 = s3.trim();
                        textLayer$TextSubLine0.set(s4, f3 - f4 - ((float)(s3.length() - s4.length())) * f5 - f5);
                        f3 = f4;
                        v2 = v3;
                    }
                }
            }
            ++v;
        }
        if(f3 > 0.0f) {
            ++v1;
            this.ensureEnoughSubLines(v1).set(s.substring(v2), f3);
        }
        return this.textSubLines.subList(0, v1);
    }
}

