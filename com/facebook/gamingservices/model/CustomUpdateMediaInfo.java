package com.facebook.gamingservices.model;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomUpdateMediaInfo {
    @NotNull
    private final String url;

    public CustomUpdateMediaInfo(@NotNull String s) {
        q.g(s, "url");
        super();
        this.url = s;
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final CustomUpdateMediaInfo copy(@NotNull String s) {
        q.g(s, "url");
        return new CustomUpdateMediaInfo(s);
    }

    public static CustomUpdateMediaInfo copy$default(CustomUpdateMediaInfo customUpdateMediaInfo0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = customUpdateMediaInfo0.url;
        }
        return customUpdateMediaInfo0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CustomUpdateMediaInfo ? q.b(this.url, ((CustomUpdateMediaInfo)object0).url) : false;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override
    public int hashCode() {
        return this.url.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("CustomUpdateMediaInfo(url="), this.url, ')');
    }
}

