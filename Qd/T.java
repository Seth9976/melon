package qd;

import Bc.e;
import Bc.h;
import android.content.Context;
import com.iloen.melon.custom.SeekBarWithRange;
import kotlin.jvm.internal.q;
import we.k;

public final class t implements k {
    public final h a;
    public final k b;
    public final k c;
    public final k d;
    public final k e;

    public t(h h0, k k0, k k1, k k2, k k3) {
        this.a = h0;
        this.b = k0;
        this.c = k1;
        this.d = k2;
        this.e = k3;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Context)object0), "context");
        SeekBarWithRange seekBarWithRange0 = new SeekBarWithRange(((Context)object0), null, 6, 0);
        seekBarWithRange0.setProgressDrawable(((Context)object0).getResources().getDrawable(0x7F080378, null));  // drawable:fullplayer_progress
        seekBarWithRange0.setThumb(((Context)object0).getResources().getDrawable(0x7F08093C, null));  // drawable:transparent
        seekBarWithRange0.setThumbOffset(0);
        seekBarWithRange0.setImportantForAccessibility(2);
        seekBarWithRange0.setOnSeekBarChangeListener(new s(this.b, this.c, this.d));
        if(this.a != null) {
            seekBarWithRange0.setOnKeyListener(new e(new Hf.t(2, this.e), seekBarWithRange0));
        }
        return seekBarWithRange0;
    }
}

