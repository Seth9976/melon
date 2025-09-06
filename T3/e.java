package T3;

import B3.m;
import E9.w;
import Ma.d;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import androidx.constraintlayout.widget.q;
import androidx.constraintlayout.widget.t;
import androidx.constraintlayout.widget.u;
import androidx.media3.session.MediaSessionService;
import androidx.media3.session.f0;
import androidx.media3.session.y0;
import androidx.recyclerview.widget.p0;
import coil.memory.MemoryCache.Key;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.MelonDatabase;
import com.melon.data.database.MelonDatabase_Impl;
import d2.n;
import dc.c;
import e3.p;
import i.n.i.b.a.s.e.i5;
import i.n.i.b.a.s.e.wb;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.o;
import org.xmlpull.v1.XmlPullParserException;
import r5.a;
import r5.g;

public final class e implements n, g {
    public int a;
    public Object b;
    public static boolean c = false;

    public e(int v) {
        switch(v) {
            case 4: {
                super();
                this.b = new ArrayList();
                this.a = 0x80;
                return;
            }
            case 6: {
                super();
                this.b = new wb(8);
                return;
            }
            case 10: {
                super();
                this.b = new LinkedHashMap();
                return;
            }
            default: {
                super();
                this.b = new p(8);
            }
        }
    }

    public e(int v, Notification notification0) {
        this.a = v;
        notification0.getClass();
        this.b = notification0;
    }

    public e(int v, p0[] arr_p0) {
        this.a = v;
        this.b = arr_p0;
    }

    public e(Context context0, XmlResourceParser xmlResourceParser0) {
        this.a = -1;
        this.b = new SparseArray();
        TypedArray typedArray0 = context0.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser0), q.C);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(typedArray0.getIndex(v1) == 0) {
                this.a = typedArray0.getResourceId(0, this.a);
            }
        }
        typedArray0.recycle();
        try {
            int v2 = xmlResourceParser0.getEventType();
            t t0 = null;
            while(true) {
                if(v2 == 1) {
                    return;
                }
            alab1:
                switch(v2) {
                    case 2: {
                        switch(xmlResourceParser0.getName()) {
                            case "LayoutDescription": {
                                break alab1;
                            }
                            case "State": {
                                t0 = new t(context0, xmlResourceParser0);
                                ((SparseArray)this.b).put(t0.a, t0);
                                break alab1;
                            }
                            case "StateSet": {
                                break alab1;
                            }
                            case "Variant": {
                                u u0 = new u(context0, xmlResourceParser0);
                                if(t0 != null) {
                                    t0.b.add(u0);
                                }
                                break alab1;
                            }
                            default: {
                                break alab1;
                            }
                        }
                    }
                    case 3: {
                        if("StateSet".equals(xmlResourceParser0.getName())) {
                            return;
                        }
                    }
                }
                v2 = xmlResourceParser0.next();
            }
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            Log.e("ConstraintLayoutStates", "Error parsing XML resource", iOException0);
            return;
        }
        Log.e("ConstraintLayoutStates", "Error parsing XML resource", xmlPullParserException0);
    }

    public e(Object object0, int v) {
        this.b = object0;
        this.a = v;
        super();
    }

    @Override  // r5.g
    public a a(MemoryCache.Key memoryCache$Key0) {
        synchronized(this) {
            a a0 = null;
            ArrayList arrayList0 = (ArrayList)((LinkedHashMap)this.b).get(memoryCache$Key0);
            if(arrayList0 == null) {
                return null;
            }
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                r5.e e0 = (r5.e)arrayList0.get(v2);
                Bitmap bitmap0 = (Bitmap)e0.b.get();
                a a1 = bitmap0 == null ? null : new a(bitmap0, e0.c);
                if(a1 != null) {
                    a0 = a1;
                    break;
                }
            }
            int v3 = this.a;
            this.a = v3 + 1;
            if(v3 >= 10) {
                this.c();
            }
            return a0;
        }
    }

    public long b(i5 i50) {
        wb wb0 = (wb)this.b;
        int v = 0;
        i50.s(wb0.a, 0, 1);
        int v1 = wb0.a[0] & 0xFF;
        if(v1 == 0) {
            return 0x8000000000000000L;
        }
        int v2 = 0x80;
        int v3;
        for(v3 = 0; (v1 & v2) == 0; ++v3) {
            v2 >>= 1;
        }
        int v4 = v1 & ~v2;
        i50.s(wb0.a, 1, v3);
        while(v < v3) {
            ++v;
            v4 = (wb0.a[v] & 0xFF) + (v4 << 8);
        }
        this.a = v3 + 1 + this.a;
        return (long)v4;
    }

    public void c() {
        Bitmap bitmap0;
        this.a = 0;
        Iterator iterator0 = ((LinkedHashMap)this.b).values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            ArrayList arrayList0 = (ArrayList)object0;
            if(arrayList0.size() <= 1) {
                r5.e e0 = (r5.e)je.p.m0(arrayList0);
                if(e0 == null) {
                    bitmap0 = null;
                }
                else {
                    WeakReference weakReference0 = e0.b;
                    if(weakReference0 != null) {
                        bitmap0 = (Bitmap)weakReference0.get();
                    }
                }
                if(bitmap0 != null) {
                    continue;
                }
                iterator0.remove();
            }
            else {
                int v = arrayList0.size();
                int v2 = 0;
                for(int v1 = 0; v1 < v; ++v1) {
                    int v3 = v1 - v2;
                    if(((r5.e)arrayList0.get(v3)).b.get() == null) {
                        arrayList0.remove(v3);
                        ++v2;
                    }
                }
                if(arrayList0.isEmpty()) {
                    iterator0.remove();
                }
            }
        }
    }

    @Override  // r5.g
    public void clearMemory() {
        synchronized(this) {
            this.a = 0;
            ((LinkedHashMap)this.b).clear();
        }
    }

    public void d() {
        synchronized(this) {
            int v1 = this.a;
            if(v1 <= 0) {
                LogU.w("MelonDbHelper", "close() already closed");
                return;
            }
            this.a = v1 - 1;
            LogU.v("MelonDbHelper", "close() refCount:" + this.a);
            if(this.a == 0) {
                MelonDb melonDb0 = (MelonDb)this.b;
                if(melonDb0 != null) {
                    try {
                        try {
                            melonDb0.close();
                        }
                        catch(Exception exception0) {
                            LogU.w("MelonDbHelper", "close() - " + exception0.getMessage());
                        }
                    }
                    catch(Throwable throwable0) {
                        this.b = null;
                        LogU.v("MelonDbHelper", "close() database closed");
                        throw throwable0;
                    }
                    this.b = null;
                    LogU.v("MelonDbHelper", "close() database closed");
                }
            }
        }
    }

    public PendingIntent e(y0 y00, long v) {
        int v1;
        MediaSessionService mediaSessionService0 = (MediaSessionService)this.b;
        if(Long.compare(v, 8L) == 0 || v == 9L) {
            v1 = 87;
        }
        else if(v == 6L || v == 7L) {
            v1 = 88;
        }
        else if(v == 3L) {
            v1 = 86;
        }
        else if(v == 12L) {
            v1 = 90;
        }
        else if(v == 11L) {
            v1 = 89;
        }
        else if(v == 1L) {
            v1 = 85;
        }
        else {
            v1 = 0;
        }
        Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent0.setData(((f0)y00).a.b);
        intent0.setComponent(new ComponentName(mediaSessionService0, mediaSessionService0.getClass()));
        intent0.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, v1));
        return v != 1L || y00.a().getPlayWhenReady() ? PendingIntent.getService(mediaSessionService0, v1, intent0, 0x4000000) : PendingIntent.getForegroundService(mediaSessionService0, v1, intent0, 0x4000000);
    }

    public List f() {
        synchronized(this) {
            return Collections.unmodifiableList(new ArrayList(((ArrayList)this.b)));
        }
    }

    @Override  // r5.g
    public void g(MemoryCache.Key memoryCache$Key0, Bitmap bitmap0, Map map0, int v) {
        synchronized(this) {
            LinkedHashMap linkedHashMap0 = (LinkedHashMap)this.b;
            ArrayList arrayList0 = linkedHashMap0.get(memoryCache$Key0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                linkedHashMap0.put(memoryCache$Key0, arrayList0);
            }
            int v2 = System.identityHashCode(bitmap0);
            r5.e e0 = new r5.e(v2, new WeakReference(bitmap0), map0, v);
            int v3 = arrayList0.size();
            for(int v4 = 0; true; ++v4) {
                if(v4 >= v3) {
                    arrayList0.add(e0);
                    break;
                }
                r5.e e1 = (r5.e)arrayList0.get(v4);
                if(v >= e1.d) {
                    if(e1.a == v2 && e1.b.get() == bitmap0) {
                        arrayList0.set(v4, e0);
                        break;
                    }
                    arrayList0.add(v4, e0);
                    break;
                }
            }
            int v5 = this.a;
            this.a = v5 + 1;
            if(v5 >= 10) {
                this.c();
            }
        }
    }

    public MelonDb h() {
        synchronized(this) {
            if(((MelonDb)this.b) == null) {
                try {
                    if(!e.c) {
                        e.c = true;
                        ea.a a0 = ((MelonDatabase)((o)(((d)w.s(MelonAppBase.instance.getContext(), d.class)))).B.get()).b();
                        c c0 = new c(19);
                        ((Integer)w.N(((MelonDatabase_Impl)a0.a), true, false, c0)).intValue();
                    }
                }
                catch(Throwable throwable0) {
                    LogU.w("MelonDbHelper", "migration() - " + throwable0.getMessage());
                    a7.c.a().b("MelonDbHelper.open() migration - " + throwable0.getMessage());
                }
                try {
                    try {
                        this.b = new MelonDb(MelonAppBase.instance.getContext());
                        goto label_23;
                    }
                    catch(Exception exception0) {
                    }
                    LogU.w("MelonDbHelper", "open() - " + exception0.getMessage());
                }
                catch(Throwable throwable1) {
                    goto label_19;
                }
                if(((MelonDb)this.b) != null) {
                    goto label_23;
                label_19:
                    if(((MelonDb)this.b) != null) {
                        LogU.v("MelonDbHelper", "open() - database created");
                    }
                    throw throwable1;
                label_23:
                    LogU.v("MelonDbHelper", "open() - database created");
                }
            }
            ++this.a;
            LogU.v("MelonDbHelper", "open() refCount:" + this.a);
            return (MelonDb)this.b;
        }
    }

    public long i(m m0) {
        p p0 = (p)this.b;
        int v = 0;
        m0.peekFully(p0.a, 0, 1, false);
        int v1 = p0.a[0] & 0xFF;
        if(v1 == 0) {
            return 0x8000000000000000L;
        }
        int v2 = 0x80;
        int v3;
        for(v3 = 0; (v1 & v2) == 0; ++v3) {
            v2 >>= 1;
        }
        int v4 = v1 & ~v2;
        m0.peekFully(p0.a, 1, v3, false);
        while(v < v3) {
            ++v;
            v4 = (p0.a[v] & 0xFF) + (v4 << 8);
        }
        this.a = v3 + 1 + this.a;
        return (long)v4;
    }

    public int j(int v) {
        SparseArray sparseArray0 = (SparseArray)this.b;
        int v1 = 0;
        if(-1 == v) {
            t t0 = (t)sparseArray0.valueAt(0);
            if(t0 == null) {
                return -1;
            }
            ArrayList arrayList0 = t0.b;
            while(true) {
                if(v1 >= arrayList0.size()) {
                    v1 = -1;
                    break;
                }
                if(((u)arrayList0.get(v1)).a(-1.0f, -1.0f)) {
                    break;
                }
                ++v1;
            }
            if(-1 == v1) {
                return -1;
            }
            return v1 == -1 ? t0.c : ((u)t0.b.get(v1)).e;
        }
        t t1 = (t)sparseArray0.get(v);
        if(t1 == null) {
            return -1;
        }
        ArrayList arrayList1 = t1.b;
        while(true) {
            if(v1 >= arrayList1.size()) {
                v1 = -1;
                break;
            }
            if(((u)arrayList1.get(v1)).a(-1.0f, -1.0f)) {
                break;
            }
            ++v1;
        }
        return v1 == -1 ? t1.c : ((u)t1.b.get(v1)).e;
    }

    public boolean k(List list0) {
        synchronized(this) {
            ((ArrayList)this.b).clear();
            if(list0.size() > this.a) {
                Log.w("FirebaseCrashlytics", "Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.a, null);
                List list1 = list0.subList(0, this.a);
                return ((ArrayList)this.b).addAll(list1);
            }
            return ((ArrayList)this.b).addAll(list0);
        }
    }

    @Override  // d2.n
    public boolean t(View view0) {
        ((BottomSheetBehavior)this.b).M(this.a);
        return true;
    }

    @Override  // r5.g
    public void trimMemory(int v) {
        synchronized(this) {
            if(v >= 10 && v != 20) {
                this.c();
            }
        }
    }
}

