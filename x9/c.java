package x9;

import Eb.f;
import N1.b;
import Na.e;
import Y3.l;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.media.MediaCodec.CryptoInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowInsetsAnimation.Bounds;
import androidx.fragment.app.FragmentActivity;
import b3.I;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.iloen.melon.custom.S0;
import com.iloen.melon.net.v4x.response.DjApplyInsertRes;
import com.iloen.melon.net.v4x.response.DjApplyMainRes;
import com.iloen.melon.permission.PermissionListener;
import com.iloen.melon.userstore.VolatileDatabase_Impl;
import d5.n;
import d5.v;
import e1.u;
import e3.p;
import g4.a;
import g4.h;
import g4.i;
import h7.u0;
import hb.s;
import i.n.i.b.a.s.e.C5;
import i.n.i.b.a.s.e.De;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.Gd;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.Md;
import i.n.i.b.a.s.e.P;
import i.n.i.b.a.s.e.sa;
import id.g;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import va.e0;
import vc.d;

public final class c implements l, SuccessContinuation, PermissionListener, Md {
    public final int a;
    public Object b;
    public Object c;

    public c(int v) {
        this.a = v;
        switch(v) {
            case 5: {
                super();
                return;
            }
            case 8: {
                super();
                this.b = new p();
                this.c = new a();
                return;
            }
            case 12: {
                super();
                this.c = new Object();
                return;
            }
            case 14: {
                super();
                MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(d.e);
                this.b = mutableStateFlow0;
                this.c = FlowKt.asStateFlow(mutableStateFlow0);
                return;
            }
            default: {
                super();
                this.b = new Gd();
                new HashMap();
            }
        }
    }

    public c(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public c(MediaCodec.CryptoInfo mediaCodec$CryptoInfo0) {
        this.a = 10;
        super();
        this.b = mediaCodec$CryptoInfo0;
        this.c = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    public c(WindowInsetsAnimation.Bounds windowInsetsAnimation$Bounds0) {
        this.a = 6;
        super();
        this.b = S1.d.d(windowInsetsAnimation$Bounds0.getLowerBound());
        this.c = S1.d.d(windowInsetsAnimation$Bounds0.getUpperBound());
    }

    public c(VolatileDatabase_Impl volatileDatabase_Impl0) {
        this.a = 0;
        super();
        this.b = volatileDatabase_Impl0;
        this.c = new f(19);
    }

    public c(v v0, k k0) {
        this.a = 9;
        q.g(k0, "loginUseCase");
        super();
        this.b = v0;
        this.c = k0;
    }

    public c(e7.k k0, Task task0) {
        this.a = 7;
        super();
        this.c = k0;
        this.b = task0;
    }

    public c(t t0, B3.d d0) {
        this.a = 4;
        super();
        this.b = t0;
        this.c = d0;
        if(d0.b != 1 || d0.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d0 + " was passed").toString());
        }
    }

    @Override  // com.iloen.melon.permission.PermissionListener
    public void a() {
        id.k k0 = (id.k)this.b;
        if(b.b(((FragmentActivity)this.c), "android.permission.RECORD_AUDIO")) {
            com.melon.ui.popup.b.x(k0.getChildFragmentManager(), k0.getString(0x7F1307EC), k0.getString(0x7F1307E8), false, false, k0.getString(0x7F130199), k0.getString(0x7F1307EB), new g(k0, 1), new g(k0, 2), null, null, 0xC38);  // string:permission_alert_popup_title "안내"
            return;
        }
        com.melon.ui.popup.b.x(k0.getChildFragmentManager(), k0.getString(0x7F1307EC), k0.getString(0x7F1307E9), false, false, k0.getString(0x7F130199), k0.getString(0x7F130227), new g(k0, 3), null, null, null, 3640);  // string:permission_alert_popup_title "안내"
    }

    @Override  // com.iloen.melon.permission.PermissionListener
    public void b() {
        ((id.k)this.b).n();
    }

    public void c(int v, UUID uUID0, sa sa0) {
        C5 c50 = new C5();
        try {
            B7.b b0 = new P(5).a(c50, ((Uri)sa0.b).toString(), ((byte[])sa0.c), ((HashMap)sa0.d));
            Map map0 = (Map)b0.c;
            byte[] arr_b = (byte[])b0.b;
            HashMap hashMap0 = M7.D(M7.D(map0));
            De de0 = (De)((Ga)this.c).b;
            synchronized(de0) {
                de0.f = arr_b;
                de0.g = hashMap0;
                de0.notifyAll();
            }
        }
        catch(IOException iOException0) {
            HashMap hashMap1 = M7.D(Collections.EMPTY_MAP);
            De de1 = (De)((Ga)this.c).b;
            de1.h = -1004;
            de1.i = iOException0.toString();
            de1.j = null;
            de1.k = hashMap1;
            synchronized(de1) {
                de1.notifyAll();
            }
        }
    }

    public Object d(String s, oe.c c0) {
        s s1;
        if(c0 instanceof s) {
            s1 = (s)c0;
            int v = s1.B;
            if((v & 0x80000000) == 0) {
                s1 = new s(this, c0);
            }
            else {
                s1.B = v ^ 0x80000000;
            }
        }
        else {
            s1 = new s(this, c0);
        }
        Object object0 = s1.r;
        ne.a a0 = ne.a.a;
        switch(s1.B) {
            case 0: {
                n.D(object0);
                try {
                    v v1 = (v)this.b;
                    String s2 = u.v(((e0)(((k)this.c))).j());
                    s1.B = 1;
                    object0 = v1.n(s, s2, s1);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    return new e(((DjApplyMainRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public Object e(oe.c c0) {
        hb.t t0;
        if(c0 instanceof hb.t) {
            t0 = (hb.t)c0;
            int v = t0.B;
            if((v & 0x80000000) == 0) {
                t0 = new hb.t(this, c0);
            }
            else {
                t0.B = v ^ 0x80000000;
            }
        }
        else {
            t0 = new hb.t(this, c0);
        }
        Object object0 = t0.r;
        ne.a a0 = ne.a.a;
        switch(t0.B) {
            case 0: {
                n.D(object0);
                try {
                    v v1 = (v)this.b;
                    String s = u.w(((e0)(((k)this.c))).j());
                    t0.B = 1;
                    object0 = v1.P(s, t0);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    return new e(((DjApplyInsertRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public void f(int v, Bundle bundle0, Messenger messenger0) {
        Message message0 = Message.obtain();
        message0.what = v;
        message0.arg1 = 1;
        if(bundle0 != null) {
            message0.setData(bundle0);
        }
        message0.replyTo = messenger0;
        ((Messenger)this.b).send(message0);
    }

    // This method was un-flattened
    @Override  // Y3.l
    public void g(byte[] arr_b, int v, int v1, Y3.k k0, e3.e e0) {
        g4.c c1;
        String s9;
        String s3;
        p p0 = (p)this.b;
        p0.E(arr_b, v + v1);
        p0.G(v);
        ArrayList arrayList0 = new ArrayList();
        try {
            i.d(p0);
        }
        catch(I i0) {
            throw new IllegalArgumentException(i0);
        }
        while(!TextUtils.isEmpty(p0.h(StandardCharsets.UTF_8))) {
        }
        ArrayList arrayList1 = new ArrayList();
        while(true) {
            int v2 = p0.b;
            String s = p0.h(StandardCharsets.UTF_8);
            if(s == null) {
                p0.G(v2);
                y8.s s1 = new y8.s();  // 初始化器: Ljava/lang/Object;-><init>()V
                s1.a = Collections.unmodifiableList(new ArrayList(arrayList1));
                s1.b = new long[arrayList1.size() * 2];
                for(int v3 = 0; v3 < arrayList1.size(); ++v3) {
                    g4.c c0 = (g4.c)arrayList1.get(v3);
                    long[] arr_v = (long[])s1.b;
                    arr_v[v3 * 2] = c0.b;
                    arr_v[v3 * 2 + 1] = c0.c;
                }
                long[] arr_v1 = Arrays.copyOf(((long[])s1.b), ((long[])s1.b).length);
                s1.c = arr_v1;
                Arrays.sort(arr_v1);
                y5.a.T(s1, k0, e0);
                return;
            }
            if("STYLE".equals(s)) {
                p0.G(v2);
                if(!arrayList1.isEmpty()) {
                    throw new IllegalArgumentException("A style block was found after the first cue.");
                }
                p0.h(StandardCharsets.UTF_8);
                p p1 = ((a)this.c).a;
                StringBuilder stringBuilder0 = ((a)this.c).b;
                stringBuilder0.setLength(0);
                int v4 = p0.b;
                while(!TextUtils.isEmpty(p0.h(StandardCharsets.UTF_8))) {
                }
                p1.E(p0.a, p0.b);
                p1.G(v4);
                ArrayList arrayList2 = new ArrayList();
                while(true) {
                    a.c(p1);
                    if(p1.a() < 5 || !"::cue".equals(p1.s(5, StandardCharsets.UTF_8))) {
                        s3 = null;
                    }
                    else {
                        int v5 = p1.b;
                        String s2 = a.b(p1, stringBuilder0);
                        if(s2 == null) {
                            s3 = null;
                        }
                        else if("{".equals(s2)) {
                            p1.G(v5);
                            s3 = "";
                        }
                        else {
                            if("(".equals(s2)) {
                                int v6 = p1.b;
                                int v7 = p1.c;
                                int v8 = 0;
                                while(v6 < v7 && v8 == 0) {
                                    v8 = ((char)p1.a[v6]) == 41 ? 1 : 0;
                                    ++v6;
                                }
                                s3 = p1.s(v6 - 1 - p1.b, StandardCharsets.UTF_8).trim();
                            }
                            else {
                                s3 = null;
                            }
                            if(!")".equals(a.b(p1, stringBuilder0))) {
                                s3 = null;
                            }
                        }
                    }
                    if(s3 == null || !"{".equals(a.b(p1, stringBuilder0))) {
                        break;
                    }
                    g4.b b0 = new g4.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b0.a = "";
                    b0.b = "";
                    b0.c = Collections.EMPTY_SET;
                    b0.d = "";
                    b0.e = null;
                    b0.g = false;
                    b0.i = false;
                    b0.j = -1;
                    b0.k = -1;
                    b0.l = -1;
                    b0.m = -1;
                    b0.n = -1;
                    b0.p = -1;
                    b0.q = false;
                    if(!"".equals(s3)) {
                        int v9 = s3.indexOf(91);
                        if(v9 != -1) {
                            Matcher matcher0 = a.c.matcher(s3.substring(v9));
                            if(matcher0.matches()) {
                                String s4 = matcher0.group(1);
                                s4.getClass();
                                b0.d = s4;
                            }
                            s3 = s3.substring(0, v9);
                        }
                        String[] arr_s = s3.split("\\.", -1);
                        String s5 = arr_s[0];
                        int v10 = s5.indexOf(35);
                        if(v10 == -1) {
                            b0.b = s5;
                        }
                        else {
                            b0.b = s5.substring(0, v10);
                            b0.a = s5.substring(v10 + 1);
                        }
                        if(arr_s.length > 1) {
                            e3.b.c(arr_s.length <= arr_s.length);
                            b0.c = new HashSet(Arrays.asList(((String[])Arrays.copyOfRange(arr_s, 1, arr_s.length))));
                        }
                    }
                    String s6 = null;
                    int v11 = 0;
                    while(v11 == 0) {
                        int v12 = p1.b;
                        s6 = a.b(p1, stringBuilder0);
                        int v13 = s6 == null || "}".equals(s6) ? 1 : 0;
                        if(v13 == 0) {
                            p1.G(v12);
                            a.c(p1);
                            String s7 = a.a(p1, stringBuilder0);
                            if(!"".equals(s7) && ":".equals(a.b(p1, stringBuilder0))) {
                                a.c(p1);
                                StringBuilder stringBuilder1 = new StringBuilder();
                                boolean z = false;
                                while(true) {
                                    if(!z) {
                                        int v14 = p1.b;
                                        String s8 = a.b(p1, stringBuilder0);
                                        if(s8 == null) {
                                            s9 = null;
                                            break;
                                        }
                                        else {
                                            if("}".equals(s8) || ";".equals(s8)) {
                                                p1.G(v14);
                                                z = true;
                                            }
                                            else {
                                                stringBuilder1.append(s8);
                                            }
                                            continue;
                                        }
                                    }
                                    s9 = stringBuilder1.toString();
                                    break;
                                }
                                if(s9 != null && !"".equals(s9)) {
                                    int v15 = p1.b;
                                    String s10 = a.b(p1, stringBuilder0);
                                    if(";".equals(s10)) {
                                    label_138:
                                        if("color".equals(s7)) {
                                            b0.f = e3.d.a(s9, true);
                                            b0.g = true;
                                        }
                                        else if("background-color".equals(s7)) {
                                            b0.h = e3.d.a(s9, true);
                                            b0.i = true;
                                        }
                                        else if(!"ruby-position".equals(s7)) {
                                            if("text-combine-upright".equals(s7)) {
                                                b0.q = "all".equals(s9) || s9.startsWith("digits");
                                            }
                                            else if(!"text-decoration".equals(s7)) {
                                                if("font-family".equals(s7)) {
                                                    b0.e = u0.U(s9);
                                                }
                                                else if(!"font-weight".equals(s7)) {
                                                    if(!"font-style".equals(s7)) {
                                                        if("font-size".equals(s7)) {
                                                            String s11 = u0.U(s9);
                                                            Matcher matcher1 = a.d.matcher(s11);
                                                            if(matcher1.matches()) {
                                                                String s12 = matcher1.group(2);
                                                                s12.getClass();
                                                                switch(s12) {
                                                                    case "%": {
                                                                        b0.n = 3;
                                                                        break;
                                                                    }
                                                                    case "em": {
                                                                        b0.n = 2;
                                                                        break;
                                                                    }
                                                                    case "px": {
                                                                        b0.n = 1;
                                                                        break;
                                                                    }
                                                                    default: {
                                                                        throw new IllegalStateException();
                                                                    }
                                                                }
                                                                String s13 = matcher1.group(1);
                                                                s13.getClass();
                                                                b0.o = Float.parseFloat(s13);
                                                            }
                                                            else {
                                                                e3.b.D("WebvttCssParser", "Invalid font-size: \'" + s9 + "\'.");
                                                            }
                                                        }
                                                    }
                                                    else if("italic".equals(s9)) {
                                                        b0.m = 1;
                                                    }
                                                }
                                                else if("bold".equals(s9)) {
                                                    b0.l = 1;
                                                }
                                            }
                                            else if("underline".equals(s9)) {
                                                b0.k = 1;
                                            }
                                        }
                                        else if("over".equals(s9)) {
                                            b0.p = 1;
                                        }
                                        else if("under".equals(s9)) {
                                            b0.p = 2;
                                        }
                                    }
                                    else if("}".equals(s10)) {
                                        p1.G(v15);
                                        goto label_138;
                                    }
                                }
                            }
                        }
                        v11 = v13;
                    }
                    if("}".equals(s6)) {
                        arrayList2.add(b0);
                    }
                }
                arrayList0.addAll(arrayList2);
            }
            else if(s.startsWith("NOTE")) {
                p0.G(v2);
                while(!TextUtils.isEmpty(p0.h(StandardCharsets.UTF_8))) {
                }
            }
            else {
                p0.G(v2);
                Charset charset0 = StandardCharsets.UTF_8;
                String s14 = p0.h(charset0);
                if(s14 == null) {
                    c1 = null;
                }
                else {
                    Pattern pattern0 = h.a;
                    Matcher matcher2 = pattern0.matcher(s14);
                    if(matcher2.matches()) {
                        c1 = h.d(null, matcher2, p0, arrayList0);
                    }
                    else {
                        c1 = null;
                        String s15 = p0.h(charset0);
                        if(s15 != null) {
                            Matcher matcher3 = pattern0.matcher(s15);
                            if(matcher3.matches()) {
                                c1 = h.d(s14.trim(), matcher3, p0, arrayList0);
                            }
                        }
                    }
                }
                if(c1 != null) {
                    arrayList1.add(c1);
                }
            }
        }
    }

    @Override  // Y3.l
    public int j() {
        return 1;
    }

    @Override  // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object object0) {
        e7.k k0 = (e7.k)this.c;
        if(!((Boolean)object0).booleanValue()) {
            if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
            }
            for(Object object1: FileStore.e(k0.g.c.listFiles(e7.k.r))) {
                ((File)object1).delete();
            }
            FileStore fileStore0 = ((k7.a)k0.m.b).b;
            k7.a.a(FileStore.e(fileStore0.e.listFiles()));
            k7.a.a(FileStore.e(fileStore0.f.listFiles()));
            k7.a.a(FileStore.e(fileStore0.g.listFiles()));
            k0.q.trySetResult(null);
            return Tasks.forResult(null);
        }
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
        }
        G1.f f0 = k0.b;
        if(((Boolean)object0).booleanValue()) {
            ((TaskCompletionSource)f0.h).trySetResult(null);
            Task task0 = (Task)this.b;
            S0 s00 = new S0(this, 7);
            return task0.onSuccessTask(k0.e.a, s00);
        }
        f0.getClass();
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    @Override
    public String toString() {
        return this.a == 6 ? "Bounds{lower=" + ((S1.d)this.b) + " upper=" + ((S1.d)this.c) + "}" : super.toString();
    }
}

