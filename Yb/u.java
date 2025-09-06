package Yb;

import H0.b;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Error;
import kotlin.jvm.internal.q;

public final class u extends v {
    public final String c;
    public final Error d;
    public final String e;
    public final String f;

    public u(String s, Error leonPlayerState$Error0) {
        q.g(s, "message");
        q.g(leonPlayerState$Error0, "error");
        super(s, null);
        this.c = s;
        this.d = leonPlayerState$Error0;
        this.e = "PlayerException.Video";
        this.f = b.f(leonPlayerState$Error0.getCode(), "[", "] ", leonPlayerState$Error0.getMessage());
    }

    @Override  // Sb.a
    public final String a() {
        return this.f;
    }

    @Override  // Sb.a
    public final String b() {
        return this.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        return q.b(this.c, ((u)object0).c) ? q.b(this.d, ((u)object0).d) : false;
    }

    @Override
    public final String getMessage() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + this.c.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Video(message=" + this.c + ", error=" + this.d + ")";
    }
}

