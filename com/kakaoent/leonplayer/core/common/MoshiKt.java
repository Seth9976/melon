package com.kakaoent.leonplayer.core.common;

import Vd.D;
import d3.g;
import ie.j;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u001C\u0010\u0002\u001A\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00028\u0000H\u0080\b¢\u0006\u0004\b\u0002\u0010\u0003\u001A*\u0010\u0006\u001A\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\"\u001B\u0010\r\u001A\u00020\b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"T", "", "toJson", "(Ljava/lang/Object;)Ljava/lang/String;", "Ljava/lang/reflect/Type;", "parameterizedType", "parse", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "LVd/D;", "moshi$delegate", "Lie/j;", "getMoshi", "()LVd/D;", "moshi", "leonplayer_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class MoshiKt {
    @NotNull
    private static final j moshi$delegate;

    static {
        MoshiKt.moshi$delegate = g.Q(MoshiKt.moshi.2.INSTANCE);
    }

    @NotNull
    public static final D getMoshi() {
        Object object0 = MoshiKt.moshi$delegate.getValue();
        q.f(object0, "<get-moshi>(...)");
        return (D)object0;
    }

    public static final Object parse(String s, Type type0) {
        q.g(s, "<this>");
        try {
            D d0 = MoshiKt.getMoshi();
            if(type0 != null) {
                return d0.a(type0).fromJson(s);
            }
            q.k();
            throw null;
        }
        catch(Exception exception0) {
            String s1 = exception0.getMessage();
            if(s1 == null) {
                s1 = "Moshi parse exception";
            }
            throw new MoshiParseException(s1);
        }
    }

    public static Object parse$default(String s, Type type0, int v, Object object0) {
        if((v & 1) != 0) {
            type0 = null;
        }
        q.g(s, "<this>");
        try {
            D d0 = MoshiKt.getMoshi();
            if(type0 != null) {
                return d0.a(type0).fromJson(s);
            }
            q.k();
            throw null;
        }
        catch(Exception exception0) {
            String s1 = exception0.getMessage();
            if(s1 == null) {
                s1 = "Moshi parse exception";
            }
            throw new MoshiParseException(s1);
        }
    }

    public static final String toJson(Object object0) {
        MoshiKt.getMoshi();
        q.k();
        throw null;
    }
}

