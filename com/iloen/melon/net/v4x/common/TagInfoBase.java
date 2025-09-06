package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "tagSeq", "", "tagName", "repntTagYn", "equals", "", "obj", "", "hashCode", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class TagInfoBase implements Serializable {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v4x/common/TagInfoBase$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("REPNTTAGYN")
    @Nullable
    public String repntTagYn;
    private static final long serialVersionUID = 0x1463D14550EDBC53L;
    @b("TAGNAME")
    @Nullable
    public String tagName;
    @b("TAGSEQ")
    @Nullable
    public String tagSeq;

    static {
        TagInfoBase.Companion = new Companion(null);
        TagInfoBase.$stable = 8;
    }

    public TagInfoBase() {
        this.tagSeq = "";
        this.tagName = "";
        this.repntTagYn = "";
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(object0 != null && object0 instanceof TagInfoBase) {
            String s = ((TagInfoBase)object0).tagName;
            return s != null && q.b(s, this.tagName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.tagName == null ? 0 : this.tagName.hashCode()) + 0x1F;
    }
}

