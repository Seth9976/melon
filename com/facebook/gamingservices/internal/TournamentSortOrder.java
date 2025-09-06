package com.facebook.gamingservices.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/gamingservices/internal/TournamentSortOrder;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "toString", "LowerIsBetter", "HigherIsBetter", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum TournamentSortOrder {
    LowerIsBetter("LOWER_IS_BETTER"),
    HigherIsBetter("HIGHER_IS_BETTER");

    @NotNull
    private final String rawValue;

    private static final TournamentSortOrder[] $values() [...] // Inlined contents

    private TournamentSortOrder(String s1) {
        this.rawValue = s1;
    }

    @NotNull
    public final String getRawValue() {
        return this.rawValue;
    }

    @Override
    @NotNull
    public String toString() {
        return this.rawValue;
    }
}

