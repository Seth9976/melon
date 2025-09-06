package S6;

import V6.a;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzls;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import y7.b;

public final class c {
    public final b a;
    public Integer b;

    public c(b b0) {
        this.a = b0;
        this.b = null;
    }

    public static boolean a(ArrayList arrayList0, S6.b b0) {
        String s = b0.a;
        String s1 = b0.b;
        for(Object object0: arrayList0) {
            if(((S6.b)object0).a.equals(s) && ((S6.b)object0).b.equals(s1)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final ArrayList b() {
        V6.c c0 = (V6.c)(((V6.b)this.a.get()));
        c0.getClass();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: c0.a.getConditionalUserProperties("frc", "")) {
            Preconditions.checkNotNull(((Bundle)object0));
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.a = (String)Preconditions.checkNotNull(((String)zzjg.zzb(((Bundle)object0), "origin", String.class, null)));
            a0.b = (String)Preconditions.checkNotNull(((String)zzjg.zzb(((Bundle)object0), "name", String.class, null)));
            a0.c = zzjg.zzb(((Bundle)object0), "value", Object.class, null);
            a0.d = (String)zzjg.zzb(((Bundle)object0), "trigger_event_name", String.class, null);
            a0.e = (long)(((Long)zzjg.zzb(((Bundle)object0), "trigger_timeout", Long.class, 0L)));
            a0.f = (String)zzjg.zzb(((Bundle)object0), "timed_out_event_name", String.class, null);
            a0.g = (Bundle)zzjg.zzb(((Bundle)object0), "timed_out_event_params", Bundle.class, null);
            a0.h = (String)zzjg.zzb(((Bundle)object0), "triggered_event_name", String.class, null);
            a0.i = (Bundle)zzjg.zzb(((Bundle)object0), "triggered_event_params", Bundle.class, null);
            a0.j = (long)(((Long)zzjg.zzb(((Bundle)object0), "time_to_live", Long.class, 0L)));
            a0.k = (String)zzjg.zzb(((Bundle)object0), "expired_event_name", String.class, null);
            a0.l = (Bundle)zzjg.zzb(((Bundle)object0), "expired_event_params", Bundle.class, null);
            a0.n = ((Boolean)zzjg.zzb(((Bundle)object0), "active", Boolean.class, Boolean.FALSE)).booleanValue();
            a0.m = (long)(((Long)zzjg.zzb(((Bundle)object0), "creation_timestamp", Long.class, 0L)));
            a0.o = (long)(((Long)zzjg.zzb(((Bundle)object0), "triggered_timestamp", Long.class, 0L)));
            arrayList0.add(a0);
        }
        return arrayList0;
    }

    public final void c(ArrayList arrayList0) {
        S6.b b1;
        b b0 = this.a;
        if(b0.get() == null) {
            throw new S6.a("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
        ArrayList arrayList1 = new ArrayList();
        Iterator iterator0 = arrayList0.iterator();
        while(true) {
            String s = "";
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            Map map0 = (Map)object0;
            ArrayList arrayList2 = new ArrayList();
            String[] arr_s = S6.b.g;
            for(int v = 0; v < 5; ++v) {
                String s1 = arr_s[v];
                if(!map0.containsKey(s1)) {
                    arrayList2.add(s1);
                }
            }
            if(!arrayList2.isEmpty()) {
                throw new S6.a(String.format("The following keys are missing from the experiment info map: %s", arrayList2));  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
            try {
                String s2 = (String)map0.get("experimentStartTime");
                Date date0 = S6.b.h.parse(s2);
                long v1 = Long.parseLong(((String)map0.get("triggerTimeoutMillis")));
                long v2 = Long.parseLong(((String)map0.get("timeToLiveMillis")));
                Object object1 = map0.get("experimentId");
                Object object2 = map0.get("variantId");
                if(map0.containsKey("triggerEvent")) {
                    s = (String)map0.get("triggerEvent");
                }
                b1 = new S6.b(((String)object1), ((String)object2), s, date0, v1, v2);
                goto label_33;
            }
            catch(ParseException parseException0) {
            }
            catch(NumberFormatException numberFormatException0) {
                throw new S6.a("Could not process experiment: one of the durations could not be converted into a long.", numberFormatException0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
            }
            throw new S6.a("Could not process experiment: parsing experiment start time failed.", parseException0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        label_33:
            arrayList1.add(b1);
        }
        if(arrayList1.isEmpty()) {
            if(b0.get() == null) {
                throw new S6.a("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
            for(Object object3: this.b()) {
                String s3 = ((a)object3).b;
                ((V6.c)(((V6.b)b0.get()))).a.clearConditionalUserProperty(s3, null, null);
            }
            return;
        }
        if(b0.get() == null) {
            throw new S6.a("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
        ArrayList arrayList3 = this.b();
        ArrayList arrayList4 = new ArrayList();
        for(Object object4: arrayList3) {
            String s4 = ((a)object4).d;
            arrayList4.add(new S6.b(((a)object4).b, String.valueOf(((a)object4).c), (s4 == null ? "" : s4), new Date(((a)object4).m), ((a)object4).e, ((a)object4).j));
        }
        ArrayList arrayList5 = new ArrayList();
        for(Object object5: arrayList4) {
            S6.b b2 = (S6.b)object5;
            if(!c.a(arrayList1, b2)) {
                arrayList5.add(b2.a());
            }
        }
        for(Object object6: arrayList5) {
            String s5 = ((a)object6).b;
            ((V6.c)(((V6.b)b0.get()))).a.clearConditionalUserProperty(s5, null, null);
        }
        ArrayList arrayList6 = new ArrayList();
        for(Object object7: arrayList1) {
            S6.b b3 = (S6.b)object7;
            if(!c.a(arrayList4, b3)) {
                arrayList6.add(b3);
            }
        }
        ArrayDeque arrayDeque0 = new ArrayDeque(this.b());
        if(this.b == null) {
            this.b = ((V6.c)(((V6.b)b0.get()))).a.getMaxUserProperties("frc");
        }
        int v3 = (int)this.b;
        for(Object object8: arrayList6) {
            while(arrayDeque0.size() >= v3) {
                String s6 = ((a)arrayDeque0.pollFirst()).b;
                ((V6.c)(((V6.b)b0.get()))).a.clearConditionalUserProperty(s6, null, null);
            }
            a a0 = ((S6.b)object8).a();
            V6.c c0 = (V6.c)(((V6.b)b0.get()));
            c0.getClass();
            String s7 = a0.a;
            if(s7 != null && !s7.isEmpty() && ((a0.c == null || zzls.zzb(a0.c) != null) && W6.a.a(s7) && W6.a.c(s7, a0.b)) && (a0.k == null || W6.a.b(a0.l, a0.k) && W6.a.d(s7, a0.k, a0.l)) && (a0.h == null || W6.a.b(a0.i, a0.h) && W6.a.d(s7, a0.h, a0.i)) && (a0.f == null || W6.a.b(a0.g, a0.f) && W6.a.d(s7, a0.f, a0.g))) {
                AppMeasurementSdk appMeasurementSdk0 = c0.a;
                Bundle bundle0 = new Bundle();
                String s8 = a0.a;
                if(s8 != null) {
                    bundle0.putString("origin", s8);
                }
                String s9 = a0.b;
                if(s9 != null) {
                    bundle0.putString("name", s9);
                }
                Object object9 = a0.c;
                if(object9 != null) {
                    zzjg.zza(bundle0, object9);
                }
                String s10 = a0.d;
                if(s10 != null) {
                    bundle0.putString("trigger_event_name", s10);
                }
                bundle0.putLong("trigger_timeout", a0.e);
                String s11 = a0.f;
                if(s11 != null) {
                    bundle0.putString("timed_out_event_name", s11);
                }
                Bundle bundle1 = a0.g;
                if(bundle1 != null) {
                    bundle0.putBundle("timed_out_event_params", bundle1);
                }
                String s12 = a0.h;
                if(s12 != null) {
                    bundle0.putString("triggered_event_name", s12);
                }
                Bundle bundle2 = a0.i;
                if(bundle2 != null) {
                    bundle0.putBundle("triggered_event_params", bundle2);
                }
                bundle0.putLong("time_to_live", a0.j);
                String s13 = a0.k;
                if(s13 != null) {
                    bundle0.putString("expired_event_name", s13);
                }
                Bundle bundle3 = a0.l;
                if(bundle3 != null) {
                    bundle0.putBundle("expired_event_params", bundle3);
                }
                bundle0.putLong("creation_timestamp", a0.m);
                bundle0.putBoolean("active", a0.n);
                bundle0.putLong("triggered_timestamp", a0.o);
                appMeasurementSdk0.setConditionalUserProperty(bundle0);
            }
            arrayDeque0.offer(a0);
        }
    }
}

