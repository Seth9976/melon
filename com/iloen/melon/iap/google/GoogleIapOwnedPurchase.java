package com.iloen.melon.iap.google;

import androidx.annotation.Keep;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000F\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/iap/google/GoogleIapOwnedPurchase;", "", "subs", "", "", "inapp", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSubs", "()Ljava/util/List;", "getInapp", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GoogleIapOwnedPurchase {
    public static final int $stable = 8;
    @NotNull
    private final List inapp;
    @NotNull
    private final List subs;

    public GoogleIapOwnedPurchase() {
        this(null, null, 3, null);
    }

    public GoogleIapOwnedPurchase(@NotNull List list0, @NotNull List list1) {
        q.g(list0, "subs");
        q.g(list1, "inapp");
        super();
        this.subs = list0;
        this.inapp = list1;
    }

    public GoogleIapOwnedPurchase(List list0, List list1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        w w0 = w.a;
        if((v & 1) != 0) {
            list0 = w0;
        }
        if((v & 2) != 0) {
            list1 = w0;
        }
        this(list0, list1);
    }

    @NotNull
    public final List component1() {
        return this.subs;
    }

    @NotNull
    public final List component2() {
        return this.inapp;
    }

    @NotNull
    public final GoogleIapOwnedPurchase copy(@NotNull List list0, @NotNull List list1) {
        q.g(list0, "subs");
        q.g(list1, "inapp");
        return new GoogleIapOwnedPurchase(list0, list1);
    }

    public static GoogleIapOwnedPurchase copy$default(GoogleIapOwnedPurchase googleIapOwnedPurchase0, List list0, List list1, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = googleIapOwnedPurchase0.subs;
        }
        if((v & 2) != 0) {
            list1 = googleIapOwnedPurchase0.inapp;
        }
        return googleIapOwnedPurchase0.copy(list0, list1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof GoogleIapOwnedPurchase)) {
            return false;
        }
        return q.b(this.subs, ((GoogleIapOwnedPurchase)object0).subs) ? q.b(this.inapp, ((GoogleIapOwnedPurchase)object0).inapp) : false;
    }

    @NotNull
    public final List getInapp() {
        return this.inapp;
    }

    @NotNull
    public final List getSubs() {
        return this.subs;
    }

    @Override
    public int hashCode() {
        return this.inapp.hashCode() + this.subs.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "GoogleIapOwnedPurchase(subs=" + this.subs + ", inapp=" + this.inapp + ")";
    }
}

