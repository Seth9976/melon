package com.kakaoent.trevi.ad.domain;

import S7.b;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/WithdrawNegativeFeedback;", "", "negativeFeecback", "", "(Ljava/lang/String;)V", "getNegativeFeecback", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WithdrawNegativeFeedback {
    @b("negative_feedback")
    @NotNull
    private final String negativeFeecback;

    public WithdrawNegativeFeedback(@NotNull String s) {
        q.g(s, "negativeFeecback");
        super();
        this.negativeFeecback = s;
    }

    @NotNull
    public final String component1() {
        return this.negativeFeecback;
    }

    @NotNull
    public final WithdrawNegativeFeedback copy(@NotNull String s) {
        q.g(s, "negativeFeecback");
        return new WithdrawNegativeFeedback(s);
    }

    public static WithdrawNegativeFeedback copy$default(WithdrawNegativeFeedback withdrawNegativeFeedback0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = withdrawNegativeFeedback0.negativeFeecback;
        }
        return withdrawNegativeFeedback0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof WithdrawNegativeFeedback ? q.b(this.negativeFeecback, ((WithdrawNegativeFeedback)object0).negativeFeecback) : false;
    }

    @NotNull
    public final String getNegativeFeecback() {
        return this.negativeFeecback;
    }

    @Override
    public int hashCode() {
        return this.negativeFeecback.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("WithdrawNegativeFeedback(negativeFeecback="), this.negativeFeecback, ')');
    }
}

