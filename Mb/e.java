package mb;

import com.iloen.melon.utils.NameValuePairList;
import oe.c;
import we.a;

public final class e extends c {
    public a B;
    public Object D;
    public final f E;
    public int G;
    public String r;
    public NameValuePairList w;

    public e(f f0, c c0) {
        this.E = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.c(null, null, null, null, null, this);
    }
}

