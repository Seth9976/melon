package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.utils.system.DeviceData;
import d5.f;
import java.util.ArrayList;
import k8.t1;

public abstract class MelonBaseChartView extends AppCompatImageView {
    public final Typeface a;
    public float b;
    public final int c;
    public final float d;
    public final float e;
    public final float f;
    public float g;
    public float h;
    public float i;
    public Paint j;
    public Paint k;
    public Paint l;
    public Paint m;
    public ArrayList n;
    public int o;

    public MelonBaseChartView(Context context0) {
        super(context0);
        this.a = f.G(this.getContext());
        this.b = 0.0f;
        this.c = 0;
        this.o = 0;
        this.c();
    }

    public MelonBaseChartView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = f.G(this.getContext());
        this.b = 0.0f;
        this.c = 0;
        this.o = 0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.r, 0, 0);
        this.c = typedArray0.getInt(1, 0);
        this.d = typedArray0.getDimension(3, 0.0f);
        typedArray0.getDimension(2, 0.0f);
        this.f = typedArray0.getDimension(4, 0.0f);
        this.e = typedArray0.getDimension(0, 0.0f);
        typedArray0.recycle();
        this.c();
    }

    public final void c() {
        DeviceData deviceData0 = MelonAppBase.instance.getDeviceData();
        this.b = deviceData0.d;
        this.h = deviceData0.d * 1.0f;
        this.i = deviceData0.d * 1.0f;
        Paint paint0 = new Paint(1);
        this.j = paint0;
        Paint.Style paint$Style0 = Paint.Style.STROKE;
        paint0.setStyle(paint$Style0);
        this.j.setStrokeWidth(this.h);
        this.j.setColor(ColorUtils.getColor(this.getContext(), 0x7F060033));  // color:black_05
        Paint paint1 = new Paint(1);
        this.k = paint1;
        paint1.setStyle(paint$Style0);
        this.k.setStrokeWidth(this.i);
        this.k.setColor(ColorUtils.getColor(this.getContext(), 0x7F060033));  // color:black_05
        Paint paint2 = new Paint(1);
        this.l = paint2;
        Paint.Align paint$Align0 = Paint.Align.CENTER;
        paint2.setTextAlign(paint$Align0);
        this.l.setTextSize(this.b * 7.0f);
        this.l.setColor(ColorUtils.getColor(this.getContext(), 0x7F06003A));  // color:black_30
        this.l.setTypeface(this.a);
        Paint paint3 = new Paint(1);
        this.m = paint3;
        paint3.setTextAlign(paint$Align0);
        this.m.setTextSize(this.b * 7.0f);
        this.m.setColor(ColorUtils.getColor(this.getContext(), 0x7F060041));  // color:black_70
        this.m.setTypeface(this.a);
    }

    public int getFiveChartTextBoldIndex() {
        return this.o;
    }

    public ArrayList getXcateList() {
        return this.n;
    }

    @Override  // android.widget.ImageView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        if(this.getXcateList() != null && !this.getXcateList().isEmpty()) {
            canvas0.getWidth();
            float f = (float)canvas0.getHeight();
            String s = (String)this.getXcateList().get(0);
            Rect rect0 = new Rect();
            this.l.getTextBounds(s, 0, s.length(), rect0);
            float f1 = (float)rect0.height();
            float f2 = ((float)canvas0.getHeight()) - f1 - this.e - this.h;
            this.g = f2;
            canvas0.drawLine(0.0f, f2, ((float)canvas0.getWidth()), this.g, this.j);
            int v1 = this.getXcateList().size();
            for(int v = 0; v < v1; ++v) {
                String s1 = (String)this.getXcateList().get(v);
                Paint paint0 = this.l;
                int v2 = this.c;
                if(v2 != 0) {
                    if(v == this.getFiveChartTextBoldIndex() - 1) {
                        paint0 = this.m;
                    }
                }
                else if(v == v1 - 1) {
                    paint0 = this.m;
                }
                float f3 = ((float)v) * 0.0f + this.d;
                canvas0.drawText(s1, f3, f, paint0);
                if(v2 != 0) {
                    canvas0.drawLine(f3, this.f, f3, this.g, this.k);
                }
                else if(v == v1 - 1 || "00".equals(s1)) {
                    canvas0.drawLine(f3, this.f, f3, this.g, this.k);
                }
            }
        }
    }

    public void setFiveChartTextBoldIndex(int v) {
        this.o = v;
    }

    public void setXcateList(ArrayList arrayList0) {
        this.n = arrayList0;
    }
}

