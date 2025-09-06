package Zc;

import com.melon.net.res.NavigationMenuBenefitRes;
import com.melon.net.res.NavigationMenuListRes;
import java.util.ArrayList;
import java.util.List;
import oe.c;

public final class n0 extends c {
    public NavigationMenuListRes B;
    public ArrayList D;
    public ArrayList E;
    public List G;
    public Object I;
    public final t0 M;
    public int N;
    public NavigationMenuBenefitRes r;
    public V w;

    public n0(t0 t00, c c0) {
        this.M = t00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.k(null, null, null, null, null, null, this);
    }
}

