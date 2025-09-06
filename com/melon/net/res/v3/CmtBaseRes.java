package com.melon.net.res.v3;

import S7.b;
import com.iloen.melon.net.v3x.ResponseV3Res;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/CmtBaseRes;", "Lcom/iloen/melon/net/v3x/ResponseV3Res;", "<init>", "()V", "errormessage", "", "getErrormessage", "()Ljava/lang/String;", "setErrormessage", "(Ljava/lang/String;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class CmtBaseRes extends ResponseV3Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/CmtBaseRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("ERRORMESSAGE")
    @Nullable
    private String errormessage;
    private static final long serialVersionUID = -3072413083746362806L;

    static {
        CmtBaseRes.Companion = new Companion(null);
        CmtBaseRes.$stable = 8;
    }

    @Nullable
    public final String getErrormessage() {
        return this.errormessage;
    }

    public final void setErrormessage(@Nullable String s) {
        this.errormessage = s;
    }
}

