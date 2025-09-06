package com.iloen.melon.playback.playlist.add;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\rJ\u001E\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001E\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0010JT\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u00C6\u0001\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001A\u00020\u0014H\u00D6\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0017\u0010\rJ\u001A\u0010\u001A\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BR\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001C\u001A\u0004\b\u001D\u0010\rR\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010\u001C\u001A\u0004\b\u001E\u0010\rR%\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\u001F\u001A\u0004\b \u0010\u0010R%\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00078\u0006\u00A2\u0006\f\n\u0004\b\t\u0010\u001F\u001A\u0004\b!\u0010\u0010\u00A8\u0006\""}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PopupData;", "", "", "title", "msg", "Lkotlin/Function0;", "Lie/H;", "Lcom/melon/ui/Action;", "agreeAction", "cancelAction", "<init>", "(IILwe/a;Lwe/a;)V", "component1", "()I", "component2", "component3", "()Lwe/a;", "component4", "copy", "(IILwe/a;Lwe/a;)Lcom/iloen/melon/playback/playlist/add/PopupData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTitle", "getMsg", "Lwe/a;", "getAgreeAction", "getCancelAction", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PopupData {
    public static final int $stable;
    @Nullable
    private final a agreeAction;
    @Nullable
    private final a cancelAction;
    private final int msg;
    private final int title;

    public PopupData(int v, int v1, @Nullable a a0, @Nullable a a1) {
        this.title = v;
        this.msg = v1;
        this.agreeAction = a0;
        this.cancelAction = a1;
    }

    public PopupData(int v, int v1, a a0, a a1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 4) != 0) {
            a0 = null;
        }
        if((v2 & 8) != 0) {
            a1 = null;
        }
        this(v, v1, a0, a1);
    }

    public final int component1() {
        return this.title;
    }

    public final int component2() {
        return this.msg;
    }

    @Nullable
    public final a component3() {
        return this.agreeAction;
    }

    @Nullable
    public final a component4() {
        return this.cancelAction;
    }

    @NotNull
    public final PopupData copy(int v, int v1, @Nullable a a0, @Nullable a a1) {
        return new PopupData(v, v1, a0, a1);
    }

    public static PopupData copy$default(PopupData popupData0, int v, int v1, a a0, a a1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = popupData0.title;
        }
        if((v2 & 2) != 0) {
            v1 = popupData0.msg;
        }
        if((v2 & 4) != 0) {
            a0 = popupData0.agreeAction;
        }
        if((v2 & 8) != 0) {
            a1 = popupData0.cancelAction;
        }
        return popupData0.copy(v, v1, a0, a1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PopupData)) {
            return false;
        }
        if(this.title != ((PopupData)object0).title) {
            return false;
        }
        if(this.msg != ((PopupData)object0).msg) {
            return false;
        }
        return q.b(this.agreeAction, ((PopupData)object0).agreeAction) ? q.b(this.cancelAction, ((PopupData)object0).cancelAction) : false;
    }

    @Nullable
    public final a getAgreeAction() {
        return this.agreeAction;
    }

    @Nullable
    public final a getCancelAction() {
        return this.cancelAction;
    }

    public final int getMsg() {
        return this.msg;
    }

    public final int getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        int v = d.b(this.msg, this.title * 0x1F, 0x1F);
        int v1 = 0;
        int v2 = this.agreeAction == null ? 0 : this.agreeAction.hashCode();
        a a0 = this.cancelAction;
        if(a0 != null) {
            v1 = a0.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = o.t(this.title, this.msg, "PopupData(title=", ", msg=", ", agreeAction=");
        stringBuilder0.append(this.agreeAction);
        stringBuilder0.append(", cancelAction=");
        stringBuilder0.append(this.cancelAction);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

