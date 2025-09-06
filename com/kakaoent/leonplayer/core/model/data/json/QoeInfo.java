package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000B\u0010\u0006\u001A\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0007\u001A\u00020\u00002\n\b\u0003\u0010\u0002\u001A\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\fHÖ\u0001J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;", "", "temp", "(Ljava/lang/Object;)V", "getTemp", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class QoeInfo {
    @Nullable
    private final Object temp;

    public QoeInfo(@i(name = "temp") @Nullable Object object0) {
        this.temp = object0;
    }

    @Nullable
    public final Object component1() {
        return this.temp;
    }

    @NotNull
    public final QoeInfo copy(@i(name = "temp") @Nullable Object object0) {
        return new QoeInfo(object0);
    }

    public static QoeInfo copy$default(QoeInfo qoeInfo0, Object object0, int v, Object object1) {
        if((v & 1) != 0) {
            object0 = qoeInfo0.temp;
        }
        return qoeInfo0.copy(object0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof QoeInfo ? q.b(this.temp, ((QoeInfo)object0).temp) : false;
    }

    @Nullable
    public final Object getTemp() {
        return this.temp;
    }

    @Override
    public int hashCode() {
        return this.temp == null ? 0 : this.temp.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "QoeInfo(temp=" + this.temp + ')';
    }
}

