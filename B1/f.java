package b1;

import Ce.g;
import Gd.e;
import Qc.l;
import Y4.b;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout.Builder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import c1.d;
import g1.a;
import java.text.Bidi;

public abstract class f {
    static {
    }

    public static StaticLayout a(CharSequence charSequence0, TextPaint textPaint0, int v, int v1, TextDirectionHeuristic textDirectionHeuristic0, Layout.Alignment layout$Alignment0, int v2, TextUtils.TruncateAt textUtils$TruncateAt0, int v3, int v4, boolean z, int v5, int v6, int v7, int v8) {
        if(v1 < 0) {
            a.a("invalid start value");
        }
        if(v1 < 0 || v1 > charSequence0.length()) {
            a.a("invalid end value");
        }
        if(v2 < 0) {
            a.a("invalid maxLines value");
        }
        if(v < 0) {
            a.a("invalid width value");
        }
        if(v3 < 0) {
            a.a("invalid ellipsizedWidth value");
        }
        StaticLayout.Builder staticLayout$Builder0 = StaticLayout.Builder.obtain(charSequence0, 0, v1, textPaint0, v);
        staticLayout$Builder0.setTextDirection(textDirectionHeuristic0);
        staticLayout$Builder0.setAlignment(layout$Alignment0);
        staticLayout$Builder0.setMaxLines(v2);
        staticLayout$Builder0.setEllipsize(textUtils$TruncateAt0);
        staticLayout$Builder0.setEllipsizedWidth(v3);
        staticLayout$Builder0.setLineSpacing(0.0f, 1.0f);
        staticLayout$Builder0.setIncludePad(z);
        staticLayout$Builder0.setBreakStrategy(v5);
        staticLayout$Builder0.setHyphenationFrequency(v8);
        staticLayout$Builder0.setIndents(null, null);
        int v9 = Build.VERSION.SDK_INT;
        staticLayout$Builder0.setJustificationMode(v4);
        if(v9 >= 28) {
            androidx.window.layout.util.a.p(staticLayout$Builder0);
        }
        if(v9 >= 33) {
            e.v(staticLayout$Builder0, e.e(e.C(e.d(e.c(), v6), v7)));
        }
        if(v9 >= 35) {
            b.j(staticLayout$Builder0);
        }
        return staticLayout$Builder0.build();
    }

    public static final Rect b(TextPaint textPaint0, CharSequence charSequence0, int v, int v1) {
        if(charSequence0 instanceof Spanned) {
            Class class0 = MetricAffectingSpan.class;
            if(((Spanned)charSequence0).nextSpanTransition(v - 1, v1, class0) != v1) {
                Rect rect0 = new Rect();
                Rect rect1 = new Rect();
                TextPaint textPaint1 = new TextPaint();
                while(v < v1) {
                    int v2 = ((Spanned)charSequence0).nextSpanTransition(v, v1, class0);
                    MetricAffectingSpan[] arr_metricAffectingSpan = (MetricAffectingSpan[])((Spanned)charSequence0).getSpans(v, v2, class0);
                    textPaint1.set(textPaint0);
                    for(int v3 = 0; v3 < arr_metricAffectingSpan.length; ++v3) {
                        MetricAffectingSpan metricAffectingSpan0 = arr_metricAffectingSpan[v3];
                        if(((Spanned)charSequence0).getSpanStart(metricAffectingSpan0) != ((Spanned)charSequence0).getSpanEnd(metricAffectingSpan0)) {
                            metricAffectingSpan0.updateMeasureState(textPaint1);
                        }
                    }
                    if(Build.VERSION.SDK_INT >= 29) {
                        l.s(textPaint1, charSequence0, v, v2, rect1);
                    }
                    else {
                        textPaint1.getTextBounds(charSequence0.toString(), v, v2, rect1);
                    }
                    int v4 = rect0.right;
                    rect0.right = rect1.width() + v4;
                    rect0.top = Math.min(rect0.top, rect1.top);
                    rect0.bottom = Math.max(rect0.bottom, rect1.bottom);
                    v = v2;
                }
                return rect0;
            }
        }
        Rect rect2 = new Rect();
        if(Build.VERSION.SDK_INT >= 29) {
            l.s(textPaint0, charSequence0, v, v1, rect2);
            return rect2;
        }
        textPaint0.getTextBounds(charSequence0.toString(), v, v1, rect2);
        return rect2;
    }

    public static final float c(int v, int v1, float[] arr_f) {
        return arr_f[(v - v1) * 2 + 1];
    }

    public static final int d(Layout layout0, int v, boolean z) {
        if(v <= 0) {
            return 0;
        }
        if(v >= layout0.getText().length()) {
            return layout0.getLineCount() - 1;
        }
        int v1 = layout0.getLineForOffset(v);
        int v2 = layout0.getLineStart(v1);
        if(v2 == v || layout0.getLineEnd(v1) == v) {
            if(v2 == v) {
                return z ? v1 - 1 : v1;
            }
            return z ? v1 : v1 + 1;
        }
        return v1;
    }

    public static final int e(i i0, Layout layout0, H8.i i1, int v, RectF rectF0, d d0, F.e e0, boolean z) {
        int v32;
        b1.d[] arr_d1;
        int v23;
        int v22;
        b1.d[] arr_d;
        float f2;
        int v10;
        float f1;
        float f;
        int v1 = layout0.getLineTop(v);
        int v2 = layout0.getLineBottom(v);
        int v3 = layout0.getLineStart(v);
        int v4 = layout0.getLineEnd(v);
        if(v3 != v4) {
            int v5 = (v4 - v3) * 2;
            float[] arr_f = new float[v5];
            Layout layout1 = i0.f;
            int v6 = layout1.getLineStart(v);
            int v7 = i0.f(v);
            if(v5 < (v7 - v6) * 2) {
                a.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
            }
            W0.i i2 = new W0.i(i0);
            int v8 = layout1.getParagraphDirection(v) == 1 ? 1 : 0;
            int v9 = 0;
            while(v6 < v7) {
                boolean z1 = layout1.isRtlCharAt(v6);
                if(v8 != 0 && !z1) {
                    f = i2.a(false, false, true, v6);
                    f1 = i2.a(true, true, true, v6 + 1);
                    v10 = v8;
                }
                else if(v8 == 0 || !z1) {
                    v10 = v8;
                    if(z1) {
                        f2 = i2.a(false, false, true, v6);
                        f = i2.a(true, true, true, v6 + 1);
                    }
                    else {
                        f = i2.a(false, false, false, v6);
                        f2 = i2.a(true, true, false, v6 + 1);
                    }
                    f1 = f2;
                }
                else {
                    v10 = v8;
                    f1 = i2.a(false, false, false, v6);
                    f = i2.a(true, true, false, v6 + 1);
                }
                arr_f[v9] = f;
                arr_f[v9 + 1] = f1;
                v9 += 2;
                ++v6;
                v8 = v10;
            }
            Layout layout2 = (Layout)i1.b;
            int v11 = layout2.getLineStart(v);
            int v12 = layout2.getLineEnd(v);
            int v13 = i1.r(v11, false);
            int v14 = i1.s(v13);
            Bidi bidi0 = i1.g(v13);
            if(bidi0 == null) {
                arr_d = new b1.d[]{new b1.d(v11, v12, layout2.isRtlCharAt(v11))};
            }
            else {
                Bidi bidi1 = bidi0.createLineBidi(v11 - v14, v12 - v14);
                if(bidi1 == null) {
                    arr_d = new b1.d[]{new b1.d(v11, v12, layout2.isRtlCharAt(v11))};
                }
                else {
                    int v15 = bidi1.getRunCount();
                    arr_d = new b1.d[v15];
                    for(int v16 = 0; v16 < v15; ++v16) {
                        arr_d[v16] = new b1.d(bidi1.getRunStart(v16) + v11, bidi1.getRunLimit(v16) + v11, bidi1.getRunLevel(v16) % 2 == 1);
                    }
                }
            }
            Ce.e e1 = z ? new g(0, arr_d.length - 1, 1) : new Ce.e(arr_d.length - 1, 0, -1);  // 初始化器: LCe/e;-><init>(III)V
            int v17 = e1.a;
            int v18 = e1.b;
            int v19 = e1.c;
            if(v19 > 0 && v17 <= v18 || v19 < 0 && v18 <= v17) {
                while(true) {
                    b1.d d1 = arr_d[v17];
                    boolean z2 = d1.c;
                    int v20 = d1.a;
                    int v21 = d1.b;
                    float f3 = z2 ? arr_f[(v21 - 1 - v3) * 2] : arr_f[(v20 - v3) * 2];
                    float f4 = z2 ? f.c(v20, v3, arr_f) : f.c(v21 - 1, v3, arr_f);
                    if(z) {
                        float f5 = rectF0.left;
                        if(f4 >= f5) {
                            v22 = v19;
                            float f6 = rectF0.right;
                            if(f3 <= f6) {
                                if((z2 || f5 > f3) && (!z2 || f6 < f4)) {
                                    int v24 = v21;
                                    int v25 = v20;
                                    while(v24 - v25 > 1) {
                                        int v26 = (v24 + v25) / 2;
                                        float f7 = arr_f[(v26 - v3) * 2];
                                        int v27 = v26;
                                        if(!z2 && f7 > rectF0.left || z2 && f7 < rectF0.right) {
                                            v24 = v27;
                                        }
                                        else {
                                            v25 = v27;
                                        }
                                    }
                                    v23 = z2 ? v24 : v25;
                                }
                                else {
                                    v23 = v20;
                                }
                                int v28 = d0.d(v23);
                                if(v28 != -1) {
                                    int v29 = d0.c(v28);
                                    if(v29 < v21) {
                                        if(v29 >= v20) {
                                            v20 = v29;
                                        }
                                        if(v28 > v21) {
                                            v28 = v21;
                                        }
                                        arr_d1 = arr_d;
                                        RectF rectF1 = new RectF(0.0f, ((float)v1), 0.0f, ((float)v2));
                                        int v30 = v28;
                                        while(true) {
                                            rectF1.left = z2 ? arr_f[(v30 - 1 - v3) * 2] : arr_f[(v20 - v3) * 2];
                                            rectF1.right = z2 ? f.c(v20, v3, arr_f) : f.c(v30 - 1, v3, arr_f);
                                            if(((Boolean)e0.invoke(rectF1, rectF0)).booleanValue()) {
                                                goto label_165;
                                            }
                                            v20 = d0.b(v20);
                                            if(v20 == -1 || v20 >= v21) {
                                                goto label_120;
                                            }
                                            int v31 = d0.d(v20);
                                            v30 = v31 <= v21 ? v31 : v21;
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            v22 = v19;
                        }
                        arr_d1 = arr_d;
                    label_120:
                        v20 = -1;
                    }
                    else {
                        v22 = v19;
                        arr_d1 = arr_d;
                        float f8 = rectF0.left;
                        if(f4 >= f8) {
                            float f9 = rectF0.right;
                            if(f3 <= f9) {
                                if((z2 || f9 < f4) && (!z2 || f8 > f3)) {
                                    int v33 = v21;
                                    int v34 = v20;
                                    while(v33 - v34 > 1) {
                                        int v35 = (v33 + v34) / 2;
                                        float f10 = arr_f[(v35 - v3) * 2];
                                        if(!z2 && f10 > rectF0.right || z2 && f10 < rectF0.left) {
                                            v33 = v35;
                                        }
                                        else {
                                            v34 = v35;
                                        }
                                    }
                                    v32 = z2 ? v33 : v34;
                                }
                                else {
                                    v32 = v21 - 1;
                                }
                                int v36 = d0.c(v32 + 1);
                                if(v36 != -1) {
                                    int v37 = d0.d(v36);
                                    if(v37 > v20) {
                                        if(v36 < v20) {
                                            v36 = v20;
                                        }
                                        if(v37 <= v21) {
                                            v21 = v37;
                                        }
                                        RectF rectF2 = new RectF(0.0f, ((float)v1), 0.0f, ((float)v2));
                                        int v38 = v36;
                                        while(true) {
                                            rectF2.left = z2 ? arr_f[(v21 - 1 - v3) * 2] : arr_f[(v38 - v3) * 2];
                                            rectF2.right = z2 ? f.c(v38, v3, arr_f) : f.c(v21 - 1, v3, arr_f);
                                            if(((Boolean)e0.invoke(rectF2, rectF0)).booleanValue()) {
                                                goto label_164;
                                            }
                                            v21 = d0.g(v21);
                                            if(v21 == -1 || v21 <= v20) {
                                                break;
                                            }
                                            int v39 = d0.c(v21);
                                            v38 = v39 >= v20 ? v39 : v20;
                                        }
                                    }
                                }
                            }
                        }
                        v21 = -1;
                    label_164:
                        v20 = v21;
                    }
                label_165:
                    if(v20 >= 0) {
                        return v20;
                    }
                    if(v17 == v18) {
                        break;
                    }
                    v17 += v22;
                    v19 = v22;
                    arr_d = arr_d1;
                }
            }
        }
        return -1;
    }

    public static final boolean f(Spanned spanned0, Class class0) {
        return spanned0.nextSpanTransition(-1, spanned0.length(), class0) != spanned0.length();
    }
}

