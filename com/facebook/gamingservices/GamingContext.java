package com.facebook.gamingservices;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001A\u00020\rHÖ\u0001J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/facebook/gamingservices/GamingContext;", "", "contextID", "", "(Ljava/lang/String;)V", "getContextID", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GamingContext {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000E\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/facebook/gamingservices/GamingContext$Companion;", "", "<init>", "()V", "Lcom/facebook/gamingservices/GamingContext;", "getCurrentGamingContext", "()Lcom/facebook/gamingservices/GamingContext;", "ctx", "Lie/H;", "setCurrentGamingContext", "(Lcom/facebook/gamingservices/GamingContext;)V", "", "DEFAULT_TIMEOUT", "I", "currentContext", "Lcom/facebook/gamingservices/GamingContext;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(30)
        @Nullable
        public final GamingContext getCurrentGamingContext() {
            return GamingContext.currentContext;
        }

        public final void setCurrentGamingContext(@NotNull GamingContext gamingContext0) {
            q.g(gamingContext0, "ctx");
            GamingContext.currentContext = gamingContext0;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_TIMEOUT = 5;
    @NotNull
    private final String contextID;
    @Nullable
    private static GamingContext currentContext;

    static {
        GamingContext.Companion = new Companion(null);
    }

    public GamingContext(@NotNull String s) {
        q.g(s, "contextID");
        super();
        this.contextID = s;
    }

    @NotNull
    public final String component1() {
        return this.contextID;
    }

    @NotNull
    public final GamingContext copy(@NotNull String s) {
        q.g(s, "contextID");
        return new GamingContext(s);
    }

    public static GamingContext copy$default(GamingContext gamingContext0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = gamingContext0.contextID;
        }
        return gamingContext0.copy(s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof GamingContext ? q.b(this.contextID, ((GamingContext)object0).contextID) : false;
    }

    @NotNull
    public final String getContextID() {
        return this.contextID;
    }

    @Nullable
    public static final GamingContext getCurrentGamingContext() {
        return GamingContext.Companion.getCurrentGamingContext();
    }

    @Override
    public int hashCode() {
        return this.contextID.hashCode();
    }

    public static final void setCurrentGamingContext(@NotNull GamingContext gamingContext0) {
        GamingContext.Companion.setCurrentGamingContext(gamingContext0);
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("GamingContext(contextID="), this.contextID, ')');
    }
}

