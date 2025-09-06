package com.facebook.internal;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000B"}, d2 = {"Lcom/facebook/internal/SmartLoginOption;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "None", "Enabled", "RequireConfirm", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum SmartLoginOption {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0007R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/SmartLoginOption$Companion;", "", "()V", "ALL", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "parseOptions", "bitmask", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final EnumSet parseOptions(long v) {
            EnumSet enumSet0 = EnumSet.noneOf(SmartLoginOption.class);
            for(Object object0: SmartLoginOption.ALL) {
                SmartLoginOption smartLoginOption0 = (SmartLoginOption)object0;
                if((smartLoginOption0.getValue() & v) != 0L) {
                    enumSet0.add(smartLoginOption0);
                }
            }
            q.f(enumSet0, "result");
            return enumSet0;
        }
    }

    None(0L),
    Enabled(1L),
    RequireConfirm(2L);

    @NotNull
    private static final EnumSet ALL;
    @NotNull
    public static final Companion Companion;
    private final long value;

    private static final SmartLoginOption[] $values() [...] // Inlined contents

    static {
        SmartLoginOption.Companion = new Companion(null);
        EnumSet enumSet0 = EnumSet.allOf(SmartLoginOption.class);
        if(enumSet0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException("allOf(SmartLoginOption::class.java) must not be null");
            q.l(nullPointerException0, "kotlin.jvm.internal.q");
            throw nullPointerException0;
        }
        SmartLoginOption.ALL = enumSet0;
    }

    private SmartLoginOption(long v1) {
        this.value = v1;
    }

    public final long getValue() {
        return this.value;
    }

    @NotNull
    public static final EnumSet parseOptions(long v) {
        return SmartLoginOption.Companion.parseOptions(v);
    }
}

