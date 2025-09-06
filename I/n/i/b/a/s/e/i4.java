package i.n.i.b.a.s.e;

import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import com.iloen.melon.utils.player.a;

public final class I4 {
    public AudioAttributes a;
    public static final I4 b;

    static {
        I4.b = new I4();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final AudioAttributes a() {
        if(this.a == null) {
            AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            if(L7.a >= 29) {
                a.m(audioAttributes$Builder0);
            }
            this.a = audioAttributes$Builder0.build();
        }
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(I4.class == class0) {
                I4 i40 = (I4)object0;
                return true;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return 0xEF8FB1;
    }
}

