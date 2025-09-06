package Zc;

import Na.f;
import com.iloen.melon.LoginUser;
import com.iloen.melon.custom.L0;
import com.melon.net.res.InfoCommerceAndBtnVer6Res;
import com.melon.net.res.MainMenuTabBannerRes;
import com.melon.net.res.NavigationMenuBenefitRes;
import java.util.List;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class b0 extends c {
    public Deferred B;
    public Object D;
    public Object E;
    public Deferred G;
    public List I;
    public f M;
    public InfoCommerceAndBtnVer6Res N;
    public NavigationMenuBenefitRes S;
    public MainMenuTabBannerRes T;
    public LoginUser V;
    public int W;
    public int X;
    public Object Y;
    public final t0 Z;
    public int b0;
    public L0 r;
    public String w;

    public b0(t0 t00, c c0) {
        this.Z = t00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.Y = object0;
        this.b0 |= 0x80000000;
        return this.Z.onFetchStart(null, this);
    }
}

