package A8;

import kotlin.jvm.internal.q;
import pe.b;
import z6.f;

public enum r {
    UNKNOWN("0"),
    ID_PWD_AUTO("1"),
    ID_PWD_SIMPLE("2"),
    ID_TOKEN_AUTO("3"),  // 此枚举字段已被移除
    ID_TOKEN_SIMPLE("4"),
    KAKAO("7"),
    KAKAO_BY_SCHEME("8"),
    KAKAO_BY_KAKAO_FAMILY("12"),
    OTP("15"),
    OTP_BACKGROUND("26");

    public final String a;
    public static final f b;
    public static final r[] l;

    static {
        r.l = arr_r;
        q.g(arr_r, "entries");
        new b(arr_r);
        r.b = new f(3);
    }

    public r(String s1) {
        this.a = s1;
    }
}

