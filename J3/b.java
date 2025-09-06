package j3;

import I6.G0;
import I6.Q;
import I6.V;
import I6.Y;
import I6.Z;
import I6.b0;
import I6.p0;
import I6.w;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.provider.Settings.Global;
import android.util.Pair;
import android.util.SparseArray;
import b3.H;
import b3.d;
import e3.x;
import i.n.i.b.a.s.e.Ga;
import i3.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b {
    public final SparseArray a;
    public final int b;
    public static final b c;
    public static final p0 d;
    public static final Y e;

    static {
        b.c = new b(V.t(a.d));
        Object[] arr_object = {2, 5, 6};
        w.a(3, arr_object);
        b.d = V.l(3, arr_object);
        B7.b b0 = new B7.b(4);
        b0.v(5, 6);
        b0.v(17, 6);
        b0.v(7, 6);
        b0.v(30, 10);
        b0.v(18, 6);
        b0.v(6, 8);
        b0.v(8, 8);
        b0.v(14, 8);
        b.e = b0.g();
    }

    public b(p0 p00) {
        this.a = new SparseArray();
        for(int v1 = 0; v1 < p00.d; ++v1) {
            a a0 = (a)p00.get(v1);
            this.a.put(a0.a, a0);
        }
        int v2 = 0;
        for(int v = 0; v < this.a.size(); ++v) {
            v2 = Math.max(v2, ((a)this.a.valueAt(v)).b);
        }
        this.b = v2;
    }

    public static p0 a(int v, int[] arr_v) {
        Q q0 = V.o();
        if(arr_v == null) {
            arr_v = new int[0];
        }
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            q0.a(new a(arr_v[v1], v));
        }
        return q0.g();
    }

    public static b b(Context context0, Intent intent0, d d0, Ga ga0) {
        List list0;
        Ga ga1 = null;
        Object object0 = context0.getSystemService("audio");
        object0.getClass();
        AudioManager audioManager0 = (AudioManager)object0;
        if(ga0 == null) {
            try {
                list0 = com.kakao.sdk.common.util.a.k(audioManager0, ((AudioAttributes)d0.b().a));
            }
            catch(RuntimeException unused_ex) {
                goto label_11;
            }
            if(!list0.isEmpty()) {
                ga1 = new Ga(((AudioDeviceInfo)list0.get(0)), 14);
            }
        }
        else {
            ga1 = ga0;
        }
    label_11:
        Y y0 = b.e;
        if(x.K(context0) || context0.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            List list1 = com.kakao.sdk.common.util.a.n(audioManager0, ((AudioAttributes)d0.b().a));
            HashMap hashMap0 = new HashMap();
            hashMap0.put(2, new HashSet(ye.a.r(new int[]{12})));
            for(int v = 0; v < list1.size(); ++v) {
                AudioProfile audioProfile0 = i.e(list1.get(v));
                if(audioProfile0.getEncapsulationType() != 1) {
                    int v1 = audioProfile0.getFormat();
                    if(x.H(v1) || y0.containsKey(v1)) {
                        if(hashMap0.containsKey(v1)) {
                            Set set0 = (Set)hashMap0.get(v1);
                            set0.getClass();
                            set0.addAll(ye.a.r(audioProfile0.getChannelMasks()));
                        }
                        else {
                            hashMap0.put(v1, new HashSet(ye.a.r(audioProfile0.getChannelMasks())));
                        }
                    }
                }
            }
            Q q0 = V.o();
            for(Object object1: hashMap0.entrySet()) {
                q0.a(new a(((int)(((Integer)((Map.Entry)object1).getKey()))), ((Set)((Map.Entry)object1).getValue())));
            }
            return new b(q0.g());
        }
        AudioDeviceInfo[] arr_audioDeviceInfo = ga1 == null ? audioManager0.getDevices(2) : new AudioDeviceInfo[]{((AudioDeviceInfo)ga1.b)};
        Z z0 = new Z(4);  // 初始化器: LI6/N;-><init>(I)V
        z0.b(new Integer[]{8, 7});
        z0.b(new Integer[]{26, 27});
        z0.a(30);
        b0 b00 = z0.g();
        for(int v2 = 0; v2 < arr_audioDeviceInfo.length; ++v2) {
            if(b00.contains(arr_audioDeviceInfo[v2].getType())) {
                return b.c;
            }
        }
        Z z1 = new Z(4);  // 初始化器: LI6/N;-><init>(I)V
        z1.a(2);
        if(x.K(context0) || context0.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            Q q1 = V.o();
            b0 b01 = y0.b;
            if(b01 == null) {
                b01 = y0.c();
                y0.b = b01;
            }
            G0 g00 = b01.k();
            while(g00.hasNext()) {
                Object object2 = g00.next();
                Integer integer0 = (Integer)object2;
                int v3 = (int)integer0;
                if(33 >= x.n(v3) && com.iloen.melon.utils.player.a.s(new AudioFormat.Builder().setChannelMask(12).setEncoding(v3).setSampleRate(48000).build(), ((AudioAttributes)d0.b().a))) {
                    q1.a(integer0);
                }
            }
            q1.a(2);
            p0 p00 = q1.g();
            p00.getClass();
            z1.d(p00);
            return new b(b.a(10, ye.a.Y(z1.g())));
        }
        ContentResolver contentResolver0 = context0.getContentResolver();
        boolean z2 = Settings.Global.getInt(contentResolver0, "use_external_surround_sound_flag", 0) == 1;
        if((z2 || ("Amazon".equals(x.c) || "Xiaomi".equals(x.c))) && Settings.Global.getInt(contentResolver0, "external_surround_sound_enabled", 0) == 1) {
            b.d.getClass();
            z1.d(b.d);
        }
        if(intent0 != null && !z2 && intent0.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 1) {
            int[] arr_v = intent0.getIntArrayExtra("android.media.extra.ENCODINGS");
            if(arr_v != null) {
                List list2 = ye.a.r(arr_v);
                list2.getClass();
                z1.d(list2);
            }
            int[] arr_v1 = ye.a.Y(z1.g());
            return new b(b.a(intent0.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10), arr_v1));
        }
        return new b(b.a(10, ye.a.Y(z1.g())));
    }

    public static b c(Context context0, d d0, Ga ga0) {
        return b.b(context0, context0.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), d0, ga0);
    }

    public final Pair d(androidx.media3.common.b b0, d d0) {
        b0.n.getClass();
        int v = H.b(b0.n, b0.k);
        if(b.e.containsKey(v)) {
            if(v == 18 && !this.e(18)) {
                v = 6;
            }
            else if(v == 8 && !this.e(8) || v == 30 && !this.e(30)) {
                v = 7;
            }
            if(this.e(v)) {
                a a0 = (a)this.a.get(v);
                a0.getClass();
                int v1 = a0.b;
                b0 b00 = a0.c;
                int v2 = b0.C;
                boolean z = false;
                if(v2 == -1 || v == 18) {
                    int v4 = b0.D == -1 ? 48000 : b0.D;
                    int v5 = a0.a;
                    if(b00 == null) {
                        for(v1 = 10; true; --v1) {
                            if(v1 <= 0) {
                                v1 = 0;
                                break;
                            }
                            int v6 = x.p(v1);
                            if(v6 != 0 && com.iloen.melon.utils.player.a.s(new AudioFormat.Builder().setEncoding(v5).setSampleRate(v4).setChannelMask(v6).build(), ((AudioAttributes)d0.b().a))) {
                                break;
                            }
                        }
                    }
                    v2 = v1;
                }
                else {
                    boolean z1 = !b0.n.equals("audio/vnd.dts.uhd;profile=p2");
                    if(b00 != null) {
                        int v3 = x.p(v2);
                        if(v3 != 0) {
                            z = b00.contains(v3);
                        }
                    }
                    else if(v2 <= v1) {
                        z = true;
                    }
                    if(!z) {
                        return null;
                    }
                }
                int v7 = x.p(v2);
                return v7 == 0 ? null : Pair.create(v, v7);
            }
        }
        return null;
    }

    public final boolean e(int v) {
        return this.a.indexOfKey(v) >= 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof b) {
                SparseArray sparseArray0 = ((b)object0).a;
                SparseArray sparseArray1 = this.a;
                if(sparseArray1 == null) {
                    return sparseArray0 == null ? this.b == ((b)object0).b : false;
                }
                return sparseArray0 == null ? false : sparseArray1.contentEquals(sparseArray0) && this.b == ((b)object0).b;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.a.contentHashCode() * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", audioProfiles=" + this.a + "]";
    }
}

