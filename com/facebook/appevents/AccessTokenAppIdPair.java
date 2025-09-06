package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u000FH\u0002R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair;", "Ljava/io/Serializable;", "accessToken", "Lcom/facebook/AccessToken;", "(Lcom/facebook/AccessToken;)V", "accessTokenString", "", "applicationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessTokenString", "()Ljava/lang/String;", "getApplicationId", "equals", "", "o", "", "hashCode", "", "writeReplace", "Companion", "SerializationProxyV1", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AccessTokenAppIdPair implements Serializable {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0002R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair$SerializationProxyV1;", "Ljava/io/Serializable;", "accessTokenString", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class SerializationProxyV1 implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair$SerializationProxyV1$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1.Companion {
            private com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1.Companion() {
            }

            public com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1.Companion Companion = null;
        @Nullable
        private final String accessTokenString;
        @NotNull
        private final String appId;
        private static final long serialVersionUID = -2488473066578201069L;

        static {
            SerializationProxyV1.Companion = new com.facebook.appevents.AccessTokenAppIdPair.SerializationProxyV1.Companion(null);
        }

        public SerializationProxyV1(@Nullable String s, @NotNull String s1) {
            q.g(s1, "appId");
            super();
            this.accessTokenString = s;
            this.appId = s1;
        }

        private final Object readResolve() {
            return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @Nullable
    private final String accessTokenString;
    @NotNull
    private final String applicationId;
    private static final long serialVersionUID = 1L;

    static {
        AccessTokenAppIdPair.Companion = new Companion(null);
    }

    public AccessTokenAppIdPair(@NotNull AccessToken accessToken0) {
        q.g(accessToken0, "accessToken");
        this(accessToken0.getToken(), FacebookSdk.getApplicationId());
    }

    public AccessTokenAppIdPair(@Nullable String s, @NotNull String s1) {
        q.g(s1, "applicationId");
        super();
        this.applicationId = s1;
        if(Utility.isNullOrEmpty(s)) {
            s = null;
        }
        this.accessTokenString = s;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof AccessTokenAppIdPair ? Utility.areObjectsEqual(((AccessTokenAppIdPair)object0).accessTokenString, this.accessTokenString) && Utility.areObjectsEqual(((AccessTokenAppIdPair)object0).applicationId, this.applicationId) : false;
    }

    @Nullable
    public final String getAccessTokenString() {
        return this.accessTokenString;
    }

    @NotNull
    public final String getApplicationId() {
        return this.applicationId;
    }

    @Override
    public int hashCode() {
        return this.accessTokenString == null ? this.applicationId.hashCode() : this.accessTokenString.hashCode() ^ this.applicationId.hashCode();
    }

    private final Object writeReplace() {
        return new SerializationProxyV1(this.accessTokenString, this.applicationId);
    }
}

