package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public final class g {
    public final ConstraintLayout a;
    public int b;
    public int c;
    public final SparseArray d;
    public final SparseArray e;

    public g(Context context0, ConstraintLayout constraintLayout0, int v) {
        this.b = -1;
        this.c = -1;
        this.d = new SparseArray();
        this.e = new SparseArray();
        this.a = constraintLayout0;
        XmlResourceParser xmlResourceParser0 = context0.getResources().getXml(v);
        try {
            int v1 = xmlResourceParser0.getEventType();
            e e0 = null;
            while(true) {
                switch(v1) {
                    case 1: {
                        return;
                    }
                    case 2: {
                        switch(xmlResourceParser0.getName()) {
                            case "ConstraintSet": {
                                this.a(context0, xmlResourceParser0);
                                break;
                            }
                            case "State": {
                                e e1 = new e(context0, xmlResourceParser0);
                                this.d.put(e1.a, e1);
                                e0 = e1;
                                break;
                            }
                            case "StateSet": {
                                break;
                            }
                            case "Variant": {
                                f f0 = new f(context0, xmlResourceParser0);
                                if(e0 != null) {
                                    e0.b.add(f0);
                                }
                                break;
                            }
                            case "layoutDescription": {
                            }
                        }
                        v1 = xmlResourceParser0.next();
                        break;
                    }
                    default: {
                        v1 = xmlResourceParser0.next();
                        break;
                    }
                }
            }
            goto label_31;
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            goto label_31;
        }
        Log.e("ConstraintLayoutStates", "Error parsing resource: " + v, xmlPullParserException0);
        return;
    label_31:
        Log.e("ConstraintLayoutStates", "Error parsing resource: " + v, iOException0);
    }

    public final void a(Context context0, XmlResourceParser xmlResourceParser0) {
        n n0 = new n();
        int v = xmlResourceParser0.getAttributeCount();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = xmlResourceParser0.getAttributeName(v1);
            String s1 = xmlResourceParser0.getAttributeValue(v1);
            if(s != null && s1 != null && "id".equals(s)) {
                int v2 = s1.contains("/") ? context0.getResources().getIdentifier(s1.substring(s1.indexOf(0x2F) + 1), "id", "com.iloen.melon") : -1;
                if(v2 == -1) {
                    if(s1.length() > 1) {
                        v2 = Integer.parseInt(s1.substring(1));
                    }
                    else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                n0.o(context0, xmlResourceParser0);
                this.e.put(v2, n0);
                return;
            }
        }
    }

    public final void b(float f, float f1, int v) {
        int v1 = this.b;
        int v2 = 0;
        ConstraintLayout constraintLayout0 = this.a;
        SparseArray sparseArray0 = this.d;
        if(v1 == v) {
            e e0 = v == -1 ? ((e)sparseArray0.valueAt(0)) : ((e)sparseArray0.get(v1));
            if(this.c == -1 || !((f)e0.b.get(this.c)).a(f, f1)) {
                ArrayList arrayList0 = e0.b;
                while(true) {
                    if(v2 >= arrayList0.size()) {
                        v2 = -1;
                        break;
                    }
                    if(((f)arrayList0.get(v2)).a(f, f1)) {
                        break;
                    }
                    ++v2;
                }
                ArrayList arrayList1 = e0.b;
                if(this.c != v2) {
                    n n0 = v2 == -1 ? null : ((f)arrayList1.get(v2)).f;
                    if(v2 != -1) {
                        f f2 = (f)arrayList1.get(v2);
                    }
                    if(n0 != null) {
                        this.c = v2;
                        n0.b(constraintLayout0);
                        return;
                    }
                }
            }
            return;
        }
        this.b = v;
        e e1 = (e)sparseArray0.get(v);
        ArrayList arrayList2 = e1.b;
        while(true) {
            if(v2 >= arrayList2.size()) {
                v2 = -1;
                break;
            }
            if(((f)arrayList2.get(v2)).a(f, f1)) {
                break;
            }
            ++v2;
        }
        ArrayList arrayList3 = e1.b;
        n n1 = v2 == -1 ? e1.d : ((f)arrayList3.get(v2)).f;
        if(v2 != -1) {
            f f3 = (f)arrayList3.get(v2);
        }
        if(n1 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + v + ", dim =" + f + ", " + f1);
            return;
        }
        this.c = v2;
        n1.b(constraintLayout0);
    }
}

