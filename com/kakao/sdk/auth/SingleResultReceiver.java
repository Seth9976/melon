package com.kakao.sdk.auth;

import android.net.Uri;
import com.kakao.sdk.common.util.BaseResultReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\b&\u0018\u0000 \u0011*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00028\u0000\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/kakao/sdk/auth/SingleResultReceiver;", "", "T", "Lcom/kakao/sdk/common/util/BaseResultReceiver;", "Lkotlin/Function2;", "", "Lie/H;", "", "identifier", "<init>", "(Ljava/lang/String;)V", "response", "onSuccess", "(Ljava/lang/Object;)V", "error", "onError", "(Ljava/lang/Throwable;)V", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class SingleResultReceiver extends BaseResultReceiver {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0081\u0001\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011\"\b\b\u0001\u0010\u0004*\u00020\u00012\u001C\u0010\b\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\n\u001A\u00020\t2\u0014\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000B2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000B2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000F0\u000B¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/kakao/sdk/auth/SingleResultReceiver$Companion;", "", "<init>", "()V", "T", "Lkotlin/Function2;", "", "Lie/H;", "emitter", "", "identifier", "Lkotlin/Function1;", "Landroid/net/Uri;", "parseResponse", "parseError", "", "isError", "Lcom/kakao/sdk/auth/SingleResultReceiver;", "create", "(Lwe/n;Ljava/lang/String;Lwe/k;Lwe/k;Lwe/k;)Lcom/kakao/sdk/auth/SingleResultReceiver;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SingleResultReceiver create(@NotNull n n0, @NotNull String s, @NotNull k k0, @NotNull k k1, @NotNull k k2) {
            q.g(n0, "emitter");
            q.g(s, "identifier");
            q.g(k0, "parseResponse");
            q.g(k1, "parseError");
            q.g(k2, "isError");
            SingleResultReceiver singleResultReceiver0 = new SingleResultReceiver(k0, k1, k2) {
                final k $isError;
                final k $parseError;
                final k $parseResponse;

                {
                    this.$parseResponse = k0;
                    this.$parseError = k1;
                    this.$isError = k2;
                    super(s, null);
                }

                public static final void access$setEmitter(com.kakao.sdk.auth.SingleResultReceiver.Companion.create.1 singleResultReceiver$Companion$create$10, n n0) {
                    singleResultReceiver$Companion$create$10.setEmitter(n0);
                }

                @Override  // com.kakao.sdk.common.util.BaseResultReceiver
                public boolean isError(@NotNull Uri uri0) {
                    q.g(uri0, "url");
                    return ((Boolean)this.$isError.invoke(uri0)).booleanValue();
                }

                @Override  // com.kakao.sdk.common.util.BaseResultReceiver
                @NotNull
                public Throwable parseError(@NotNull Uri uri0) {
                    q.g(uri0, "url");
                    return (Throwable)this.$parseError.invoke(uri0);
                }

                @Override  // com.kakao.sdk.common.util.BaseResultReceiver
                @Nullable
                public Object parseResponse(@NotNull Uri uri0) {
                    q.g(uri0, "url");
                    return this.$parseResponse.invoke(uri0);
                }
            };
            com.kakao.sdk.auth.SingleResultReceiver.Companion.create.1.access$setEmitter(((com.kakao.sdk.auth.SingleResultReceiver.Companion.create.1)singleResultReceiver0), n0);
            return singleResultReceiver0;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        SingleResultReceiver.Companion = new Companion(null);
    }

    private SingleResultReceiver(String s) {
        super(s);
    }

    public SingleResultReceiver(String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s);
    }

    @Override  // com.kakao.sdk.common.util.BaseResultReceiver
    public void onError(@NotNull Throwable throwable0) {
        q.g(throwable0, "error");
        n n0 = (n)this.getEmitter();
        if(n0 != null) {
            n0.invoke(null, throwable0);
        }
    }

    @Override  // com.kakao.sdk.common.util.BaseResultReceiver
    public void onSuccess(@NotNull Object object0) {
        q.g(object0, "response");
        n n0 = (n)this.getEmitter();
        if(n0 != null) {
            n0.invoke(object0, null);
        }
    }
}

