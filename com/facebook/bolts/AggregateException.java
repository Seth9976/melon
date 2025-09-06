package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0012B#\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\r\u0010\u0010R\u001C\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "detailMessage", "", "", "innerThrowables", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Ljava/io/PrintStream;", "err", "Lie/H;", "printStackTrace", "(Ljava/io/PrintStream;)V", "Ljava/io/PrintWriter;", "(Ljava/io/PrintWriter;)V", "Ljava/util/List;", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AggregateException extends Exception {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/bolts/AggregateException$Companion;", "", "()V", "serialVersionUID", "", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final List innerThrowables;
    private static final long serialVersionUID = 1L;

    static {
        AggregateException.Companion = new Companion(null);
    }

    public AggregateException(@Nullable String s, @Nullable List list0) {
        super(s, (list0 == null || list0.isEmpty() ? null : ((Throwable)list0.get(0))));
        if(list0 == null) {
            list0 = w.a;
        }
        List list1 = Collections.unmodifiableList(list0);
        q.f(list1, "unmodifiableList(innerThrowables ?: emptyList())");
        this.innerThrowables = list1;
    }

    @Override
    public void printStackTrace(@NotNull PrintStream printStream0) {
        q.g(printStream0, "err");
        super.printStackTrace(printStream0);
        int v = -1;
        for(Object object0: this.innerThrowables) {
            Throwable throwable0 = (Throwable)object0;
            printStream0.append("\n");
            printStream0.append("  Inner throwable #");
            ++v;
            printStream0.append(String.valueOf(v));
            printStream0.append(": ");
            if(throwable0 != null) {
                throwable0.printStackTrace(printStream0);
            }
            printStream0.append("\n");
        }
    }

    @Override
    public void printStackTrace(@NotNull PrintWriter printWriter0) {
        q.g(printWriter0, "err");
        super.printStackTrace(printWriter0);
        int v = -1;
        for(Object object0: this.innerThrowables) {
            Throwable throwable0 = (Throwable)object0;
            printWriter0.append("\n");
            printWriter0.append("  Inner throwable #");
            ++v;
            printWriter0.append(String.valueOf(v));
            printWriter0.append(": ");
            if(throwable0 != null) {
                throwable0.printStackTrace(printWriter0);
            }
            printWriter0.append("\n");
        }
    }
}

