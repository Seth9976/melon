package z9;

import com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes;
import java.util.ArrayList;
import java.util.Iterator;
import oe.c;

public final class d extends c {
    public Iterator B;
    public Object D;
    public final f E;
    public int G;
    public SettingGnrListExcGnrRes r;
    public ArrayList w;

    public d(f f0, c c0) {
        this.E = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.g(null, this);
    }
}

