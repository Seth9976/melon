package S6;

import V6.a;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final Date d;
    public final long e;
    public final long f;
    public static final String[] g;
    public static final SimpleDateFormat h;

    static {
        b.g = new String[]{"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};
        b.h = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss", Locale.US);
    }

    public b(String s, String s1, String s2, Date date0, long v, long v1) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = date0;
        this.e = v;
        this.f = v1;
    }

    public final a a() {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = "frc";
        a0.m = this.d.getTime();
        a0.b = this.a;
        a0.c = this.b;
        a0.d = TextUtils.isEmpty(this.c) ? null : this.c;
        a0.e = this.e;
        a0.j = this.f;
        return a0;
    }
}

