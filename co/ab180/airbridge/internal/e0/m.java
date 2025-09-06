package co.ab180.airbridge.internal.e0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\'\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001A\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0004\u0010\u0006¨\u0006\u000E"}, d2 = {"Lco/ab180/airbridge/internal/e0/m;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "I", "()I", "responseCode", "", "message", "", "throwable", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class m extends Exception {
    private final int a;

    public m(int v, @Nullable String s, @Nullable Throwable throwable0) {
        super(s, throwable0);
        this.a = v;
    }

    public m(int v, String s, Throwable throwable0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            s = null;
        }
        if((v1 & 4) != 0) {
            throwable0 = null;
        }
        this(v, s, throwable0);
    }

    public final int a() {
        return this.a;
    }
}

