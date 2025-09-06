package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class h {
    public HashMap a;
    public static final HashMap b;

    static {
        HashMap hashMap0 = new HashMap();
        h.b = hashMap0;
        try {
            hashMap0.put("KeyAttribute", e.class.getConstructor(null));
            hashMap0.put("KeyPosition", j.class.getConstructor(null));
            hashMap0.put("KeyCycle", g.class.getConstructor(null));
            hashMap0.put("KeyTimeCycle", l.class.getConstructor(null));
            hashMap0.put("KeyTrigger", n.class.getConstructor(null));
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            Log.e("KeyFrames", "unable to load", noSuchMethodException0);
        }
    }

    // This method was un-flattened
    public h(Context context0, XmlResourceParser xmlResourceParser0) {
        e e1;
        this.a = new HashMap();
        try {
            int v = xmlResourceParser0.getEventType();
            e e0 = null;
            while(true) {
                if(v == 1) {
                    return;
                }
                switch(v) {
                    case 2: {
                        String s = xmlResourceParser0.getName();
                        if(h.b.containsKey(s)) {
                            switch(s) {
                                case "KeyAttribute": {
                                    e1 = new e();
                                    break;
                                }
                                case "KeyCycle": {
                                    e1 = new g();
                                    break;
                                }
                                case "KeyPosition": {
                                    e1 = new j();
                                    break;
                                }
                                case "KeyTimeCycle": {
                                    e1 = new l();
                                    break;
                                }
                                case "KeyTrigger": {
                                    e1 = new n();
                                    break;
                                }
                                default: {
                                    throw new NullPointerException("Key " + s + " not found");
                                }
                            }
                            e1.e(context0, Xml.asAttributeSet(xmlResourceParser0));
                            this.b(e1);
                            e0 = e1;
                        }
                        else if(!s.equalsIgnoreCase("CustomAttribute")) {
                            if(s.equalsIgnoreCase("CustomMethod") && e0 != null) {
                                HashMap hashMap1 = e0.d;
                                if(hashMap1 != null) {
                                    a.d(context0, xmlResourceParser0, hashMap1);
                                }
                            }
                        }
                        else if(e0 != null) {
                            HashMap hashMap0 = e0.d;
                            if(hashMap0 != null) {
                                a.d(context0, xmlResourceParser0, hashMap0);
                            }
                        }
                        break;
                    }
                    case 3: {
                        if("KeyFrameSet".equals(xmlResourceParser0.getName())) {
                            return;
                        }
                    }
                }
                v = xmlResourceParser0.next();
            }
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            Log.e("KeyFrames", "Error parsing XML resource", iOException0);
            return;
        }
        Log.e("KeyFrames", "Error parsing XML resource", xmlPullParserException0);
    }

    public final void a(q q0) {
        HashMap hashMap0 = this.a;
        ArrayList arrayList0 = (ArrayList)hashMap0.get(q0.c);
        if(arrayList0 != null) {
            q0.w.addAll(arrayList0);
        }
        ArrayList arrayList1 = (ArrayList)hashMap0.get(-1);
        if(arrayList1 != null) {
            for(Object object0: arrayList1) {
                c c0 = (c)object0;
                String s = ((LayoutParams)q0.b.getLayoutParams()).Y;
                if((c0.c == null || s == null ? false : s.matches(c0.c))) {
                    q0.a(c0);
                }
            }
        }
    }

    public final void b(c c0) {
        HashMap hashMap0 = this.a;
        if(!hashMap0.containsKey(c0.b)) {
            hashMap0.put(c0.b, new ArrayList());
        }
        ArrayList arrayList0 = (ArrayList)hashMap0.get(c0.b);
        if(arrayList0 != null) {
            arrayList0.add(c0);
        }
    }
}

