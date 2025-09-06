package com.facebook.appevents.iap;

import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchase;", "", "eventName", "", "amount", "", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;DLjava/util/Currency;)V", "getAmount", "()D", "getCurrency", "()Ljava/util/Currency;", "getEventName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchase {
    private final double amount;
    @NotNull
    private final Currency currency;
    @NotNull
    private final String eventName;

    public InAppPurchase(@NotNull String s, double f, @NotNull Currency currency0) {
        q.g(s, "eventName");
        q.g(currency0, "currency");
        super();
        this.eventName = s;
        this.amount = f;
        this.currency = currency0;
    }

    @NotNull
    public final String component1() {
        return this.eventName;
    }

    public final double component2() {
        return this.amount;
    }

    @NotNull
    public final Currency component3() {
        return this.currency;
    }

    @NotNull
    public final InAppPurchase copy(@NotNull String s, double f, @NotNull Currency currency0) {
        q.g(s, "eventName");
        q.g(currency0, "currency");
        return new InAppPurchase(s, f, currency0);
    }

    public static InAppPurchase copy$default(InAppPurchase inAppPurchase0, String s, double f, Currency currency0, int v, Object object0) {
        if((v & 1) != 0) {
            s = inAppPurchase0.eventName;
        }
        if((v & 2) != 0) {
            f = inAppPurchase0.amount;
        }
        if((v & 4) != 0) {
            currency0 = inAppPurchase0.currency;
        }
        return inAppPurchase0.copy(s, f, currency0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof InAppPurchase)) {
            return false;
        }
        if(!q.b(this.eventName, ((InAppPurchase)object0).eventName)) {
            return false;
        }
        return Double.compare(this.amount, ((InAppPurchase)object0).amount) == 0 ? q.b(this.currency, ((InAppPurchase)object0).currency) : false;
    }

    public final double getAmount() {
        return this.amount;
    }

    @NotNull
    public final Currency getCurrency() {
        return this.currency;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @Override
    public int hashCode() {
        return this.currency.hashCode() + (Double.hashCode(this.amount) + this.eventName.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "InAppPurchase(eventName=" + this.eventName + ", amount=" + this.amount + ", currency=" + this.currency + ')';
    }
}

