package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import java.util.ArrayList;

public final class t {
    public final int a;
    public final ArrayList b;
    public final int c;

    public t(Context context0, XmlResourceParser xmlResourceParser0) {
        this.b = new ArrayList();
        this.c = -1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser0), q.B);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            if(v2 == 0) {
                this.a = typedArray0.getResourceId(0, this.a);
            }
            else if(v2 == 1) {
                int v3 = typedArray0.getResourceId(1, this.c);
                this.c = v3;
                String s = context0.getResources().getResourceTypeName(v3);
                context0.getResources().getResourceName(v3);
                "layout".equals(s);
            }
        }
        typedArray0.recycle();
    }
}

