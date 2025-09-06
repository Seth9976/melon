package co.ab180.airbridge.internal.e0;

import Tf.o;
import Tf.v;
import co.ab180.airbridge.BuildConfig;
import ie.m;
import java.util.List;
import java.util.Map;
import je.C;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0006\u001A\u00020\u00052\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\nJ\r\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u000BJ\u0019\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u0011"}, d2 = {"Lco/ab180/airbridge/internal/e0/m0;", "", "", "version1", "version2", "", "a", "(Ljava/lang/String;Ljava/lang/String;)I", "version", "", "(Ljava/lang/String;)Z", "()Ljava/lang/String;", "", "b", "()Ljava/util/Map;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class m0 {
    @NotNull
    public static final m0 a;

    static {
        m0.a = new m0();
    }

    public final int a(@Nullable String s, @Nullable String s1) {
        int v3;
        int v2;
        List list0 = w.a;
        List list1 = s == null ? list0 : o.R0(s, new String[]{"."}, 0, 6);
        if(s1 != null) {
            list0 = o.R0(s1, new String[]{"."}, 0, 6);
        }
        int v = Math.max(list1.size(), list0.size());
        for(int v1 = 0; v1 < v; ++v1) {
            if(list1.size() > v1) {
                Integer integer0 = v.t0(((String)list1.get(v1)));
                if(integer0 != null) {
                    v2 = (int)integer0;
                }
            }
            else {
                v2 = 0;
            }
            if(list0.size() > v1) {
                Integer integer1 = v.t0(((String)list0.get(v1)));
                if(integer1 != null) {
                    v3 = (int)integer1;
                }
            }
            else {
                v3 = 0;
            }
            if(v2 < v3) {
                return -1;
            }
            if(v2 > v3) {
                return 1;
            }
        }
        return 0;
    }

    @NotNull
    public final String a() [...] // Inlined contents

    public final boolean a(@Nullable String s) {
        if(s != null && s.length() != 0) {
            List list0 = o.R0(s, new String[]{"."}, 0, 6);
            if(list0.size() == 3) {
                for(Object object0: list0) {
                    if(v.t0(((String)object0)) == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final Map b() {
        return BuildConfig.RESTRICTED.booleanValue() ? C.S(new m[]{new m("name", "airbridge-android-sdk-restricted"), new m("version", "4.7.0")}) : C.S(new m[]{new m("name", "airbridge-android-sdk"), new m("version", "4.7.0")});
    }
}

