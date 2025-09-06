package com.kakaoent.leonchat.data.messages;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/SpamGuide;", "", "", "duration", "I", "getDuration", "()I", "times", "getTimes", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SpamGuide {
    private final int duration;
    @NotNull
    private final String message;
    private final int times;

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SpamGuide)) {
            return false;
        }
        if(this.duration != ((SpamGuide)object0).duration) {
            return false;
        }
        return this.times == ((SpamGuide)object0).times ? q.b(this.message, ((SpamGuide)object0).message) : false;
    }

    @Override
    public final int hashCode() {
        return this.message.hashCode() + d.b(this.times, this.duration * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SpamGuide(duration=");
        stringBuilder0.append(this.duration);
        stringBuilder0.append(", times=");
        stringBuilder0.append(this.times);
        stringBuilder0.append(", message=");
        return o.r(stringBuilder0, this.message, ')');
    }
}

