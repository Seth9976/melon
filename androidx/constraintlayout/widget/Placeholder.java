package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class Placeholder extends View {
    public int a;
    public View b;
    public int c;

    public Placeholder(Context context0) {
        super(context0);
        this.a = -1;
        this.b = null;
        this.c = 4;
        this.a(null);
    }

    public Placeholder(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = -1;
        this.b = null;
        this.c = 4;
        this.a(attributeSet0);
    }

    public Placeholder(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = -1;
        this.b = null;
        this.c = 4;
        this.a(attributeSet0);
    }

    public final void a(AttributeSet attributeSet0) {
        super.setVisibility(this.c);
        this.a = -1;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.e);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 0) {
                    this.a = typedArray0.getResourceId(0, this.a);
                }
                else if(v2 == 1) {
                    this.c = typedArray0.getInt(1, this.c);
                }
            }
            typedArray0.recycle();
        }
    }

    public View getContent() {
        return this.b;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        if(this.isInEditMode()) {
            canvas0.drawRGB(0xDF, 0xDF, 0xDF);
            Paint paint0 = new Paint();
            paint0.setARGB(0xFF, 210, 210, 210);
            paint0.setTextAlign(Paint.Align.CENTER);
            paint0.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect0 = new Rect();
            canvas0.getClipBounds(rect0);
            paint0.setTextSize(((float)rect0.height()));
            int v = rect0.height();
            int v1 = rect0.width();
            paint0.setTextAlign(Paint.Align.LEFT);
            paint0.getTextBounds("?", 0, 1, rect0);
            canvas0.drawText("?", ((float)v1) / 2.0f - ((float)rect0.width()) / 2.0f - ((float)rect0.left), ((float)rect0.height()) / 2.0f + ((float)v) / 2.0f - ((float)rect0.bottom), paint0);
        }
    }

    public void setContentId(int v) {
        if(this.a != v) {
            View view0 = this.b;
            if(view0 != null) {
                view0.setVisibility(0);
                ((LayoutParams)this.b.getLayoutParams()).f0 = false;
                this.b = null;
            }
            this.a = v;
            if(v != -1) {
                View view1 = ((View)this.getParent()).findViewById(v);
                if(view1 != null) {
                    view1.setVisibility(8);
                }
            }
        }
    }

    public void setEmptyVisibility(int v) {
        this.c = v;
    }
}

