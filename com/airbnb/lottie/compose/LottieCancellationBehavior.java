package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "", "(Ljava/lang/String;I)V", "Immediately", "OnIterationFinish", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public enum LottieCancellationBehavior {
    Immediately,
    OnIterationFinish;

    private static final a $ENTRIES;
    private static final LottieCancellationBehavior[] $VALUES;

    private static final LottieCancellationBehavior[] $values() [...] // Inlined contents

    static {
        LottieCancellationBehavior.$VALUES = arr_lottieCancellationBehavior;
        q.g(arr_lottieCancellationBehavior, "entries");
        LottieCancellationBehavior.$ENTRIES = new b(arr_lottieCancellationBehavior);
    }

    @NotNull
    public static a getEntries() {
        return LottieCancellationBehavior.$ENTRIES;
    }
}

