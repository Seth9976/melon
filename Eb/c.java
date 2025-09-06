package eb;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import java.util.regex.Pattern;
import k8.t;
import kotlin.jvm.internal.q;
import va.e0;

public final class c {
    public final a a;
    public final d b;
    public final b c;

    public c(a a0, d d0, b b0) {
        q.g(a0, "appVersionProvider");
        q.g(d0, "memberKeyProvider");
        q.g(b0, "cpIdProvider");
        super();
        this.a = a0;
        this.b = d0;
        this.c = b0;
    }

    public final String a(String s, String s1) {
        q.g(s, "logging");
        Pattern pattern0 = Pattern.compile("\\@CR1\\@");
        q.f(pattern0, "compile(...)");
        String s2 = pattern0.matcher(s).replaceFirst(s1);
        q.f(s2, "replaceFirst(...)");
        Pattern pattern1 = Pattern.compile("\\@CR2\\@");
        q.f(pattern1, "compile(...)");
        String s3 = u.w(((e0)this.b.a).j());
        if(s3 == null) {
            s3 = "";
        }
        String s4 = pattern1.matcher(s2).replaceFirst(s3);
        q.f(s4, "replaceFirst(...)");
        Pattern pattern2 = Pattern.compile("\\@CR3\\@");
        q.f(pattern2, "compile(...)");
        this.c.getClass();
        MelonAppBase.Companion.getClass();
        String s5 = t.a().getMelonCpId();
        q.g(s5, "replacement");
        String s6 = pattern2.matcher(s4).replaceFirst(s5);
        q.f(s6, "replaceFirst(...)");
        Pattern pattern3 = Pattern.compile("\\@CR4\\@");
        q.f(pattern3, "compile(...)");
        this.a.getClass();
        String s7 = AppUtils.getVersionName(t.a());
        q.g(s7, "replacement");
        String s8 = pattern3.matcher(s6).replaceFirst(s7);
        q.f(s8, "replaceFirst(...)");
        Pattern pattern4 = Pattern.compile("\\@CR5\\@");
        q.f(pattern4, "compile(...)");
        String s9 = pattern4.matcher(s8).replaceFirst("");
        q.f(s9, "replaceFirst(...)");
        return s9;
    }
}

