package com.kakao.sdk.share.model;

import android.content.Intent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u0015\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J?\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0006HÖ\u0001R\u001D\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/kakao/sdk/share/model/SharingResult;", "", "intent", "Landroid/content/Intent;", "warningMsg", "", "", "argumentMsg", "(Landroid/content/Intent;Ljava/util/Map;Ljava/util/Map;)V", "getArgumentMsg", "()Ljava/util/Map;", "getIntent", "()Landroid/content/Intent;", "getWarningMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SharingResult {
    @NotNull
    private final Map argumentMsg;
    @NotNull
    private final Intent intent;
    @NotNull
    private final Map warningMsg;

    public SharingResult(@NotNull Intent intent0, @NotNull Map map0, @NotNull Map map1) {
        q.g(intent0, "intent");
        q.g(map0, "warningMsg");
        q.g(map1, "argumentMsg");
        super();
        this.intent = intent0;
        this.warningMsg = map0;
        this.argumentMsg = map1;
    }

    @NotNull
    public final Intent component1() {
        return this.intent;
    }

    @NotNull
    public final Map component2() {
        return this.warningMsg;
    }

    @NotNull
    public final Map component3() {
        return this.argumentMsg;
    }

    @NotNull
    public final SharingResult copy(@NotNull Intent intent0, @NotNull Map map0, @NotNull Map map1) {
        q.g(intent0, "intent");
        q.g(map0, "warningMsg");
        q.g(map1, "argumentMsg");
        return new SharingResult(intent0, map0, map1);
    }

    public static SharingResult copy$default(SharingResult sharingResult0, Intent intent0, Map map0, Map map1, int v, Object object0) {
        if((v & 1) != 0) {
            intent0 = sharingResult0.intent;
        }
        if((v & 2) != 0) {
            map0 = sharingResult0.warningMsg;
        }
        if((v & 4) != 0) {
            map1 = sharingResult0.argumentMsg;
        }
        return sharingResult0.copy(intent0, map0, map1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SharingResult)) {
            return false;
        }
        if(!q.b(this.intent, ((SharingResult)object0).intent)) {
            return false;
        }
        return q.b(this.warningMsg, ((SharingResult)object0).warningMsg) ? q.b(this.argumentMsg, ((SharingResult)object0).argumentMsg) : false;
    }

    @NotNull
    public final Map getArgumentMsg() {
        return this.argumentMsg;
    }

    @NotNull
    public final Intent getIntent() {
        return this.intent;
    }

    @NotNull
    public final Map getWarningMsg() {
        return this.warningMsg;
    }

    @Override
    public int hashCode() {
        return this.argumentMsg.hashCode() + (this.warningMsg.hashCode() + this.intent.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "SharingResult(intent=" + this.intent + ", warningMsg=" + this.warningMsg + ", argumentMsg=" + this.argumentMsg + ")";
    }
}

