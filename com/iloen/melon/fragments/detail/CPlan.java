package com.iloen.melon.fragments.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/detail/CPlan;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Normal", "ErrorMaria", "ErrorBigdata", "Unknown", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
enum CPlan {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/CPlan$Companion;", "", "<init>", "()V", "isNormal", "", "code", "", "from", "Lcom/iloen/melon/fragments/detail/CPlan;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final CPlan from(String s) {
            for(Object object0: CPlan.getEntries()) {
                if(q.b(((CPlan)object0).getCode(), s)) {
                    return ((CPlan)object0) == null ? CPlan.Unknown : ((CPlan)object0);
                }
                if(false) {
                    break;
                }
            }
            return CPlan.Unknown;
        }

        public final boolean isNormal(@NotNull String s) {
            q.g(s, "code");
            return this.from(s) == CPlan.Normal;
        }
    }

    Normal("0"),
    ErrorMaria("1"),
    ErrorBigdata("2"),
    Unknown("-1");

    private static final a $ENTRIES;
    private static final CPlan[] $VALUES;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String code;

    private static final CPlan[] $values() [...] // Inlined contents

    static {
        CPlan.$VALUES = arr_cPlan;
        q.g(arr_cPlan, "entries");
        CPlan.$ENTRIES = new b(arr_cPlan);
        CPlan.Companion = new Companion(null);
    }

    private CPlan(String s1) {
        this.code = s1;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public static a getEntries() {
        return CPlan.$ENTRIES;
    }
}

