package com.melon.net.res.v3;

import ba.s;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/melon/net/res/v3/InsertReplyUiModel;", "Lba/s;", "", "message", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/melon/net/res/v3/InsertReplyUiModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InsertReplyUiModel implements s {
    public static final int $stable;
    @NotNull
    private final String message;

    public InsertReplyUiModel(@NotNull String s) {
        q.g(s, "message");
        super();
        this.message = s;
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final InsertReplyUiModel copy(@NotNull String s) {
        q.g(s, "message");
        return new InsertReplyUiModel(s);
    }

    public static InsertReplyUiModel copy$default(InsertReplyUiModel insertReplyUiModel0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = insertReplyUiModel0.message;
        }
        return insertReplyUiModel0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof InsertReplyUiModel ? q.b(this.message, ((InsertReplyUiModel)object0).message) : false;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Override
    public int hashCode() {
        return this.message.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "InsertReplyUiModel(message=" + this.message + ")";
    }
}

