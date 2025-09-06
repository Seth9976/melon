package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.h0;
import androidx.core.view.ActionProvider;
import d5.m;
import g.a;
import j.g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
    public final Object[] a;
    public final Object[] b;
    public final Context c;
    public Object d;
    public static final Class[] e;
    public static final Class[] f;

    static {
        Class[] arr_class = {Context.class};
        SupportMenuInflater.e = arr_class;
        SupportMenuInflater.f = arr_class;
    }

    public SupportMenuInflater(Context context0) {
        super(context0);
        this.c = context0;
        Object[] arr_object = {context0};
        this.a = arr_object;
        this.b = arr_object;
    }

    public static Object a(Object object0) {
        if(object0 instanceof Activity) {
            return object0;
        }
        return object0 instanceof ContextWrapper ? SupportMenuInflater.a(((ContextWrapper)object0).getBaseContext()) : object0;
    }

    public final void b(XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Menu menu0) {
        g g0 = new g(this, menu0);
        int v = xmlPullParser0.getEventType();
        do {
            if(v == 2) {
                String s = xmlPullParser0.getName();
                if(!s.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + s);
                }
                v = xmlPullParser0.next();
                break;
            }
            v = xmlPullParser0.next();
        }
        while(v != 1);
        boolean z = false;
        String s1 = null;
        boolean z1 = false;
        while(!z1) {
            if(v == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            switch(v) {
                case 2: {
                    if(!z) {
                        String s2 = xmlPullParser0.getName();
                        if(s2.equals("group")) {
                            TypedArray typedArray0 = this.c.obtainStyledAttributes(attributeSet0, a.r);
                            g0.b = typedArray0.getResourceId(1, 0);
                            g0.c = typedArray0.getInt(3, 0);
                            g0.d = typedArray0.getInt(4, 0);
                            g0.e = typedArray0.getInt(5, 0);
                            g0.f = typedArray0.getBoolean(2, true);
                            g0.g = typedArray0.getBoolean(0, true);
                            typedArray0.recycle();
                        }
                        else if(s2.equals("item")) {
                            m m0 = m.q(this.c, attributeSet0, a.s);
                            TypedArray typedArray1 = (TypedArray)m0.c;
                            g0.i = typedArray1.getResourceId(2, 0);
                            int v1 = typedArray1.getInt(5, g0.c);
                            g0.j = typedArray1.getInt(6, g0.d) & 0xFFFF | v1 & 0xFFFF0000;
                            g0.k = typedArray1.getText(7);
                            g0.l = typedArray1.getText(8);
                            g0.m = typedArray1.getResourceId(0, 0);
                            String s3 = typedArray1.getString(9);
                            g0.n = s3 == null ? '\u0000' : s3.charAt(0);
                            g0.o = typedArray1.getInt(16, 0x1000);
                            String s4 = typedArray1.getString(10);
                            g0.p = s4 == null ? '\u0000' : s4.charAt(0);
                            g0.q = typedArray1.getInt(20, 0x1000);
                            g0.r = typedArray1.hasValue(11) ? typedArray1.getBoolean(11, false) : g0.e;
                            g0.s = typedArray1.getBoolean(3, false);
                            g0.t = typedArray1.getBoolean(4, g0.f);
                            g0.u = typedArray1.getBoolean(1, g0.g);
                            g0.v = typedArray1.getInt(21, -1);
                            g0.y = typedArray1.getString(12);
                            g0.w = typedArray1.getResourceId(13, 0);
                            g0.x = typedArray1.getString(15);
                            String s5 = typedArray1.getString(14);
                            boolean z2 = s5 != null;
                            if(!z2 || g0.w != 0 || g0.x != null) {
                                if(z2) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute \'actionProviderClass\'. Action view already specified.");
                                }
                                g0.z = null;
                            }
                            else {
                                g0.z = (ActionProvider)g0.a(s5, SupportMenuInflater.f, this.b);
                            }
                            g0.A = typedArray1.getText(17);
                            g0.B = typedArray1.getText(22);
                            g0.D = typedArray1.hasValue(19) ? h0.c(typedArray1.getInt(19, -1), g0.D) : null;
                            g0.C = typedArray1.hasValue(18) ? m0.j(18) : null;
                            m0.t();
                            g0.h = false;
                        }
                        else if(s2.equals("menu")) {
                            g0.h = true;
                            SubMenu subMenu0 = g0.a.addSubMenu(g0.b, g0.i, g0.j, g0.k);
                            g0.b(subMenu0.getItem());
                            this.b(xmlPullParser0, attributeSet0, subMenu0);
                        }
                        else {
                            s1 = s2;
                            z = true;
                        }
                    }
                    break;
                }
                case 3: {
                    String s6 = xmlPullParser0.getName();
                    if(z && s6.equals(s1)) {
                        z = false;
                        s1 = null;
                    }
                    else if(s6.equals("group")) {
                        g0.b = 0;
                        g0.c = 0;
                        g0.d = 0;
                        g0.e = 0;
                        g0.f = true;
                        g0.g = true;
                    }
                    else if(!s6.equals("item")) {
                        if(s6.equals("menu")) {
                            z1 = true;
                        }
                    }
                    else if(!g0.h) {
                        if(g0.z == null || !g0.z.a()) {
                            g0.h = true;
                            g0.b(g0.a.add(g0.b, g0.i, g0.j, g0.k));
                        }
                        else {
                            g0.h = true;
                            g0.b(g0.a.addSubMenu(g0.b, g0.i, g0.j, g0.k).getItem());
                        }
                    }
                }
            }
            v = xmlPullParser0.next();
        }
    }

    @Override  // android.view.MenuInflater
    public final void inflate(int v, Menu menu0) {
        XmlResourceParser xmlResourceParser0;
        if(!(menu0 instanceof MenuBuilder)) {
            super.inflate(v, menu0);
            return;
        }
        try {
            try {
                xmlResourceParser0 = null;
                boolean z = false;
                xmlResourceParser0 = this.c.getResources().getLayout(v);
                AttributeSet attributeSet0 = Xml.asAttributeSet(xmlResourceParser0);
                if(menu0 instanceof MenuBuilder && !((MenuBuilder)menu0).p) {
                    ((MenuBuilder)menu0).y();
                    z = true;
                }
                this.b(xmlResourceParser0, attributeSet0, menu0);
                goto label_24;
            }
            catch(XmlPullParserException xmlPullParserException0) {
            }
            catch(IOException iOException0) {
                throw new InflateException("Error inflating menu XML", iOException0);
            }
            throw new InflateException("Error inflating menu XML", xmlPullParserException0);
        }
        catch(Throwable throwable0) {
        }
        if(z) {
            ((MenuBuilder)menu0).x();
        }
        if(xmlResourceParser0 != null) {
            xmlResourceParser0.close();
        }
        throw throwable0;
    label_24:
        if(z) {
            ((MenuBuilder)menu0).x();
        }
        xmlResourceParser0.close();
    }
}

