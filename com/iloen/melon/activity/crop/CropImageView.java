package com.iloen.melon.activity.crop;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;

public class CropImageView extends ImageViewTouchBase {
    public int B;
    public final ArrayList k;
    public h l;
    public float m;
    public float n;
    public int o;
    public final Context r;
    public int w;

    public CropImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.k = new ArrayList();
        this.l = null;
        this.w = 0;
        this.B = 0;
        LogU.d("CropImageView", "CropImageView() context = " + context0);
        this.r = context0;
        this.i();
    }

    @Override  // com.iloen.melon.activity.crop.ImageViewTouchBase
    public final void c(float f, float f1) {
        super.c(f, f1);
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.k;
            if(v >= arrayList0.size()) {
                break;
            }
            h h0 = (h)arrayList0.get(v);
            h0.i.postTranslate(f, f1);
            h0.f = h0.a();
        }
    }

    @Override  // com.iloen.melon.activity.crop.ImageViewTouchBase
    public final void f(float f, float f1, float f2) {
        super.f(1.0f, f1, f2);
        for(Object object0: this.k) {
            ((h)object0).i.set(this.getImageMatrix());
            ((h)object0).f = ((h)object0).a();
        }
    }

    public final void g(h h0) {
        Rect rect0 = h0.f;
        float f = (float)rect0.width();
        float f1 = (float)rect0.height();
        float f2 = Math.max(1.0f, Math.min(((float)this.getWidth()) / f * 0.6f, ((float)this.getHeight()) / f1 * 0.6f) * this.getScale());
        if(((double)(Math.abs(f2 - this.getScale()) / f2)) > 0.1) {
            float[] arr_f = {h0.h.centerX(), h0.h.centerY()};
            this.getImageMatrix().mapPoints(arr_f);
            float f3 = arr_f[0];
            float f4 = arr_f[1];
            float f5 = this.getScale();
            k k0 = new k(this, System.currentTimeMillis(), this.getScale(), (f2 - f5) / 300.0f, f3, f4);
            this.i.post(k0);
        }
        this.h(h0);
    }

    public final void h(h h0) {
        LogU.d("CropImageView", "ensureVisible");
        Rect rect0 = h0.f;
        LogU.d("CropImageView", "r.left = " + rect0.left);
        LogU.d("CropImageView", "r.right = " + rect0.right);
        LogU.d("CropImageView", "r.top = " + rect0.top);
        StringBuilder stringBuilder0 = new StringBuilder("r.bottom = ");
        Z.s(rect0.bottom, "CropImageView", stringBuilder0);
        int v = Math.max(0, -rect0.left);
        int v1 = Math.min(0, this.w - rect0.right);
        int v2 = Math.max(0, -rect0.top);
        int v3 = Math.min(0, this.B - rect0.bottom);
        LogU.d("CropImageView", "panDeltaX1 = " + v);
        LogU.d("CropImageView", "panDeltaX2 = " + v1);
        LogU.d("CropImageView", "panDeltaY1 = " + v2);
        Z.r(v3, "panDeltaY2 = ", "CropImageView");
        if(v == 0) {
            v = v1;
        }
        if(v2 == 0) {
            v2 = v3;
        }
        LogU.d("CropImageView", "panDeltaX = " + v);
        LogU.d("CropImageView", "panDeltaY = " + v2);
        if(v == 0 && v2 == 0) {
            return;
        }
        this.c(((float)v), ((float)v2));
        this.setImageMatrix(this.getImageViewMatrix());
    }

    public final void i() {
        Point point0 = ScreenUtils.getScreenSize(this.r);
        int v = point0.y;
        this.w = point0.x;
        this.B = v;
        LogU.d("CropImageView", "deviceWidth = " + point0.x);
        LogU.d("CropImageView", "deviceHeight = " + v);
    }

    public final void j(MotionEvent motionEvent0) {
        ArrayList arrayList0;
        for(int v1 = 0; true; ++v1) {
            arrayList0 = this.k;
            if(v1 >= arrayList0.size()) {
                break;
            }
            h h0 = (h)arrayList0.get(v1);
            h0.b = false;
            h0.f = h0.a();
        }
        for(int v = 0; v < arrayList0.size(); ++v) {
            h h1 = (h)arrayList0.get(v);
            if(h1.c(motionEvent0.getX(), motionEvent0.getY()) != 1) {
                if(h1.b) {
                    break;
                }
                h1.b = true;
                h1.f = h1.a();
                break;
            }
        }
        this.invalidate();
    }

    public final void k(Bitmap bitmap0) {
        this.e(new b(bitmap0));
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.i();
    }

    @Override  // android.widget.ImageView
    public final void onDraw(Canvas canvas0) {
        int v18;
        super.onDraw(canvas0);
        for(int v = 0; true; v = v18 + 1) {
            ArrayList arrayList0 = this.k;
            if(v >= arrayList0.size()) {
                break;
            }
            h h0 = (h)arrayList0.get(v);
            Paint paint0 = h0.r;
            if(!h0.c) {
                canvas0.save();
                Path path0 = new Path();
                if(h0.b) {
                    Rect rect0 = new Rect();
                    h0.a.getDrawingRect(rect0);
                    if(h0.l) {
                        float f = (float)h0.f.width();
                        float f1 = (float)h0.f.height();
                        path0.addCircle(((float)h0.f.left) + f / 2.0f, f1 / 2.0f + ((float)h0.f.top), f / 2.0f, Path.Direction.CW);
                        paint0.setColor(0xFFEF04D6);
                    }
                    else {
                        path0.addRect(new RectF(h0.f), Path.Direction.CW);
                        paint0.setColor(0xFFFF8A00);
                    }
                    canvas0.clipPath(path0, Region.Op.DIFFERENCE);
                    canvas0.drawRect(rect0, (h0.b ? h0.p : h0.q));
                    canvas0.restore();
                    canvas0.drawPath(path0, paint0);
                    if(h0.e == 3) {
                        if(h0.l) {
                            int v1 = h0.o.getIntrinsicWidth();
                            int v2 = h0.o.getIntrinsicHeight();
                            int v3 = (int)Math.round(((double)h0.f.width()) / 2.0 * 0.707107);
                            int v4 = h0.f.left;
                            int v5 = h0.f.width() / 2 + v4 + v3 - v1 / 2;
                            int v6 = h0.f.top;
                            int v7 = h0.f.height() / 2 + v6 - v3 - v2 / 2;
                            h0.o.setBounds(v5, v7, h0.o.getIntrinsicWidth() + v5, h0.o.getIntrinsicHeight() + v7);
                            h0.o.draw(canvas0);
                        }
                        else {
                            int v8 = h0.f.left + 1;
                            int v9 = h0.f.right + 1;
                            int v10 = h0.f.top + 4;
                            int v11 = h0.f.bottom + 3;
                            int v12 = h0.m.getIntrinsicWidth();
                            int v13 = h0.m.getIntrinsicHeight();
                            int v14 = h0.n.getIntrinsicHeight();
                            int v15 = h0.n.getIntrinsicWidth();
                            int v16 = (h0.f.right - h0.f.left) / 2 + h0.f.left;
                            int v17 = (h0.f.bottom - h0.f.top) / 2 + h0.f.top;
                            v18 = v;
                            int v19 = v17 - v13 / 2;
                            int v20 = v17 + v13 / 2;
                            h0.m.setBounds(v8 - v12 / 2, v19, v8 + v12 / 2, v20);
                            h0.m.draw(canvas0);
                            h0.m.setBounds(v9 - v12 / 2, v19, v9 + v12 / 2, v20);
                            h0.m.draw(canvas0);
                            int v21 = v16 - v15 / 2;
                            int v22 = v16 + v15 / 2;
                            h0.n.setBounds(v21, v10 - v14 / 2, v22, v10 + v14 / 2);
                            h0.n.draw(canvas0);
                            h0.n.setBounds(v21, v11 - v14 / 2, v22, v11 + v14 / 2);
                            h0.n.draw(canvas0);
                            continue;
                        }
                    }
                }
                else {
                    paint0.setColor(0xFF000000);
                    canvas0.drawRect(h0.f, paint0);
                }
            }
            v18 = v;
        }
    }

    @Override  // com.iloen.melon.activity.crop.ImageViewTouchBase
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        if(((Bitmap)this.e.a) != null) {
            for(Object object0: this.k) {
                h h0 = (h)object0;
                h0.i.set(this.getImageMatrix());
                h0.f = h0.a();
                if(h0.b) {
                    this.g(h0);
                }
            }
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        CropImage cropImage0 = (CropImage)this.r;
        LogU.d("CropImageView", "cropImage : " + cropImage0);
        if(cropImage0.mSaving) {
            return false;
        }
        int v1 = motionEvent0.getAction();
        ArrayList arrayList0 = this.k;
        switch(v1) {
            case 0: {
                if(cropImage0.mWaitingToPick) {
                    this.j(motionEvent0);
                }
                else {
                    for(int v = 0; v < arrayList0.size(); ++v) {
                        h h0 = (h)arrayList0.get(v);
                        int v2 = h0.c(motionEvent0.getX(), motionEvent0.getY());
                        if(v2 != 1) {
                            this.o = v2;
                            this.l = h0;
                            this.m = motionEvent0.getX();
                            this.n = motionEvent0.getY();
                            h h1 = this.l;
                            int v3 = v2 == 0x20 ? 2 : 3;
                            if(v3 == h1.e) {
                                break;
                            }
                            h1.e = v3;
                            h1.a.invalidate();
                            break;
                        }
                    }
                }
                break;
            }
            case 1: {
                if(cropImage0.mWaitingToPick) {
                    for(int v4 = 0; v4 < arrayList0.size(); ++v4) {
                        h h2 = (h)arrayList0.get(v4);
                        if(h2.b) {
                            cropImage0.mCrop = h2;
                            for(int v5 = 0; v5 < arrayList0.size(); ++v5) {
                                if(v5 != v4) {
                                    ((h)arrayList0.get(v5)).c = true;
                                }
                            }
                            this.g(h2);
                            cropImage0.mWaitingToPick = false;
                            return true;
                        }
                    }
                }
                else {
                    h h3 = this.l;
                    if(h3 != null) {
                        this.g(h3);
                        h h4 = this.l;
                        if(1 != h4.e) {
                            h4.e = 1;
                            h4.a.invalidate();
                        }
                    }
                }
                this.l = null;
                break;
            }
            case 2: {
                if(cropImage0.mWaitingToPick) {
                    this.j(motionEvent0);
                }
                else {
                    h h5 = this.l;
                    if(h5 != null) {
                        int v6 = this.o;
                        float f = motionEvent0.getX() - this.m;
                        float f1 = motionEvent0.getY() - this.n;
                        View view0 = h5.a;
                        Rect rect0 = h5.a();
                        if(v6 != 1) {
                            if(v6 == 0x20) {
                                float f2 = h5.h.width() / ((float)rect0.width()) * f;
                                float f3 = h5.h.height() / ((float)rect0.height()) * f1;
                                Rect rect1 = new Rect(h5.f);
                                h5.h.offset(f2, f3);
                                h5.h.offset(Math.max(0.0f, h5.g.left - h5.h.left), Math.max(0.0f, h5.g.top - h5.h.top));
                                h5.h.offset(Math.min(0.0f, h5.g.right - h5.h.right), Math.min(0.0f, h5.g.bottom - h5.h.bottom));
                                Rect rect2 = h5.a();
                                h5.f = rect2;
                                rect1.union(rect2);
                                rect1.inset(-10, -10);
                                view0.invalidate(rect1);
                            }
                            else {
                                if((v6 & 6) == 0) {
                                    f = 0.0f;
                                }
                                if((v6 & 24) == 0) {
                                    f1 = 0.0f;
                                }
                                float f4 = h5.h.width() / ((float)rect0.width()) * f;
                                float f5 = h5.h.height() / ((float)rect0.height()) * f1;
                                int v7 = -1;
                                float f6 = ((float)((v6 & 2) == 0 ? 1 : -1)) * f4;
                                if((v6 & 8) == 0) {
                                    v7 = 1;
                                }
                                float f7 = ((float)v7) * f5;
                                if(h5.j) {
                                    if(f6 != 0.0f) {
                                        f7 = f6 / h5.k;
                                    }
                                    else if(f7 != 0.0f) {
                                        f6 = f7 * h5.k;
                                    }
                                }
                                RectF rectF0 = new RectF(h5.h);
                                if(Float.compare(f6, 0.0f) > 0 && f6 * 2.0f + rectF0.width() > h5.g.width()) {
                                    f6 = (h5.g.width() - rectF0.width()) / 2.0f;
                                    if(h5.j) {
                                        f7 = f6 / h5.k;
                                    }
                                }
                                if(f7 > 0.0f && f7 * 2.0f + rectF0.height() > h5.g.height()) {
                                    f7 = (h5.g.height() - rectF0.height()) / 2.0f;
                                    if(h5.j) {
                                        f6 = f7 * h5.k;
                                    }
                                }
                                rectF0.inset(-f6, -f7);
                                float f8 = 25.0f;
                                if(rectF0.width() < 25.0f) {
                                    rectF0.inset(-(25.0f - rectF0.width()) / 2.0f, 0.0f);
                                }
                                if(h5.j) {
                                    f8 = 25.0f / h5.k;
                                }
                                if(rectF0.height() < f8) {
                                    rectF0.inset(0.0f, -(f8 - rectF0.height()) / 2.0f);
                                }
                                float f9 = rectF0.left;
                                RectF rectF1 = h5.g;
                                float f10 = rectF1.left;
                                if(f9 < f10) {
                                    rectF0.offset(f10 - f9, 0.0f);
                                }
                                else {
                                    float f11 = rectF0.right;
                                    float f12 = rectF1.right;
                                    if(f11 > f12) {
                                        rectF0.offset(-(f11 - f12), 0.0f);
                                    }
                                }
                                float f13 = rectF0.top;
                                RectF rectF2 = h5.g;
                                float f14 = rectF2.top;
                                if(f13 < f14) {
                                    rectF0.offset(0.0f, f14 - f13);
                                }
                                else {
                                    float f15 = rectF0.bottom;
                                    float f16 = rectF2.bottom;
                                    if(f15 > f16) {
                                        rectF0.offset(0.0f, -(f15 - f16));
                                    }
                                }
                                h5.h.set(rectF0);
                                h5.f = h5.a();
                                view0.invalidate();
                            }
                        }
                        this.m = motionEvent0.getX();
                        this.n = motionEvent0.getY();
                        this.h(this.l);
                    }
                }
            }
        }
        switch(motionEvent0.getAction()) {
            case 1: {
                this.a();
                return true;
            }
            case 2: {
                if(this.getScale() == 1.0f) {
                    this.a();
                }
                return true;
            }
            default: {
                return true;
            }
        }
    }

    @Override  // com.iloen.melon.activity.crop.ImageViewTouchBase
    public void setImageBitmap(Bitmap bitmap0) {
        this.d(bitmap0);
    }

    public void setRecycler(l l0) {
    }
}

