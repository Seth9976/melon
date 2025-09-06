package com.kakao.sdk.auth;

import android.net.Uri;
import com.kakao.sdk.common.util.BaseResultReceiver;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b&\u0018\u0000 \u000F2\u001C\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001\u000FB\u0011\b\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/kakao/sdk/auth/UnitResultReceiver;", "Lcom/kakao/sdk/common/util/BaseResultReceiver;", "Lie/H;", "Lkotlin/Function1;", "", "", "identifier", "<init>", "(Ljava/lang/String;)V", "response", "onSuccess", "(Lie/H;)V", "error", "onError", "(Ljava/lang/Throwable;)V", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class UnitResultReceiver extends BaseResultReceiver {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u000F\u001A\u00020\u000E2\u0014\u0010\u0007\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001A\u00020\b2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/kakao/sdk/auth/UnitResultReceiver$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "", "Lie/H;", "emitter", "", "identifier", "Landroid/net/Uri;", "parseError", "", "isError", "Lcom/kakao/sdk/auth/UnitResultReceiver;", "create", "(Lwe/k;Ljava/lang/String;Lwe/k;Lwe/k;)Lcom/kakao/sdk/auth/UnitResultReceiver;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final UnitResultReceiver create(@NotNull k k0, @NotNull String s, @NotNull k k1, @NotNull k k2) {
            q.g(k0, "emitter");
            q.g(s, "identifier");
            q.g(k1, "parseError");
            q.g(k2, "isError");
            UnitResultReceiver unitResultReceiver0 = new UnitResultReceiver(k1, k2) {
                final k $isError;
                final k $parseError;

                {
                    this.$parseError = k0;
                    this.$isError = k1;
                    super(s, null);
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
                public Object parseResponse(Uri uri0) {
                    this.parseResponse(uri0);
                    return H.a;
                }

                public void parseResponse(@NotNull Uri uri0) {
                    q.g(uri0, "url");
                }
            };
            ((com.kakao.sdk.auth.UnitResultReceiver.Companion.create.1)unitResultReceiver0).setEmitter(k0);
            return unitResultReceiver0;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        UnitResultReceiver.Companion = new Companion(null);
    }

    private UnitResultReceiver(String s) {
        super(s);
    }

    public UnitResultReceiver(String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s);
    }

    @Override  // com.kakao.sdk.common.util.BaseResultReceiver
    public void onError(@NotNull Throwable throwable0) {
        q.g(throwable0, "error");
        k k0 = (k)this.getEmitter();
        if(k0 != null) {
            k0.invoke(throwable0);
        }
    }

    public void onSuccess(@NotNull H h0) {
        q.g(h0, "response");
        k k0 = (k)this.getEmitter();
        if(k0 != null) {
            k0.invoke(null);
        }
    }

    @Override  // com.kakao.sdk.common.util.BaseResultReceiver
    public void onSuccess(Object object0) {
        this.onSuccess(((H)object0));
    }
}

