package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.database.DataSetObservable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class p extends DataSetObservable {
    public final Object a;
    public final ArrayList b;
    public final ArrayList c;
    public final Context d;
    public final String e;
    public final int f;
    public boolean g;
    public boolean h;
    public static final Object i;
    public static final HashMap j;

    static {
        p.i = new Object();
        p.j = new HashMap();
    }

    public p(Context context0, String s) {
        this.a = new Object();
        this.b = new ArrayList();
        this.c = new ArrayList();
        new HashMap();
        this.f = 50;
        this.g = true;
        this.h = true;
        this.d = context0.getApplicationContext();
        if(!TextUtils.isEmpty(s) && !s.endsWith(".xml")) {
            this.e = s + ".xml";
            return;
        }
        this.e = s;
    }

    public final void a() {
        boolean z;
        XmlPullParser xmlPullParser0;
        FileInputStream fileInputStream0;
        ArrayList arrayList0 = this.c;
        if(!this.g || !this.h) {
            z = false;
        }
        else {
            String s = this.e;
            if(TextUtils.isEmpty(s)) {
                z = false;
            }
            else {
                try {
                    this.g = false;
                    fileInputStream0 = this.d.openFileInput(s);
                }
                catch(FileNotFoundException unused_ex) {
                    z = true;
                    goto label_48;
                }
                try {
                    xmlPullParser0 = Xml.newPullParser();
                    xmlPullParser0.setInput(fileInputStream0, "UTF-8");
                    for(int v = 0; v != 1 && v != 2; v = xmlPullParser0.next()) {
                    }
                    if(!"historical-records".equals(xmlPullParser0.getName())) {
                        throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                    }
                    arrayList0.clear();
                    while(true) {
                    label_15:
                        int v1 = xmlPullParser0.next();
                        if(v1 == 1) {
                            break;
                        }
                        goto label_20;
                    }
                }
                catch(XmlPullParserException xmlPullParserException0) {
                    goto label_33;
                }
                catch(IOException iOException0) {
                    goto label_37;
                }
                catch(Throwable throwable0) {
                    goto label_42;
                }
                if(fileInputStream0 != null) {
                    try {
                        fileInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    z = true;
                    goto label_48;
                label_20:
                    if(v1 == 3 || v1 == 4) {
                        goto label_15;
                    }
                    try {
                        try {
                            if(!"historical-record".equals(xmlPullParser0.getName())) {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                            String s1 = xmlPullParser0.getAttributeValue(null, "activity");
                            long v2 = Long.parseLong(xmlPullParser0.getAttributeValue(null, "time"));
                            float f = Float.parseFloat(xmlPullParser0.getAttributeValue(null, "weight"));
                            arrayList0.add(new o(ComponentName.unflattenFromString(s1), v2, f));
                            goto label_15;
                        }
                        catch(XmlPullParserException xmlPullParserException0) {
                        }
                        catch(IOException iOException0) {
                            goto label_37;
                        }
                    label_33:
                        Log.e("p", "Error reading historical recrod file: " + s, xmlPullParserException0);
                        if(fileInputStream0 != null) {
                            goto label_35;
                        }
                        z = true;
                        goto label_48;
                    }
                    catch(Throwable throwable0) {
                        goto label_42;
                    }
                    try {
                    label_35:
                        fileInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    z = true;
                    goto label_48;
                    try {
                    label_37:
                        Log.e("p", "Error reading historical recrod file: " + s, iOException0);
                        if(fileInputStream0 != null) {
                            goto label_39;
                        }
                        z = true;
                        goto label_48;
                    }
                    catch(Throwable throwable0) {
                        goto label_42;
                    }
                    try {
                    label_39:
                        fileInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                z = true;
                goto label_48;
            label_42:
                if(fileInputStream0 != null) {
                    try {
                        fileInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw throwable0;
            }
        }
    label_48:
        int v3 = arrayList0.size() - this.f;
        if(v3 > 0) {
            this.h = true;
            for(int v4 = 0; v4 < v3; ++v4) {
                o o0 = (o)arrayList0.remove(0);
            }
        }
        if(z) {
            this.notifyChanged();
        }
    }

    public static p b(Context context0, String s) {
        synchronized(p.i) {
            HashMap hashMap0 = p.j;
            p p0 = (p)hashMap0.get(s);
            if(p0 == null) {
                p0 = new p(context0, s);
                hashMap0.put(s, p0);
            }
            return p0;
        }
    }

    public final void c(int v) {
        synchronized(this.a) {
            this.a();
            if(this.b.get(v) == null) {
                throw null;
            }
            throw new ClassCastException();
        }
    }

    public final int d() {
        synchronized(this.a) {
            this.a();
        }
        return this.b.size();
    }

    public final void e() {
        synchronized(this.a) {
            this.a();
            if(this.b.isEmpty()) {
                return;
            }
            if(this.b.get(0) == null) {
                throw null;
            }
        }
        throw new ClassCastException();
    }
}

