package o9;

import Eb.f;
import H8.h;
import com.iloen.melon.premium.PremiumContentsEntity;
import we.k;

public final class a implements k {
    public final int a;
    public final b b;
    public final PremiumContentsEntity c;

    public a(b b0, PremiumContentsEntity premiumContentsEntity0, int v) {
        this.a = v;
        this.b = b0;
        this.c = premiumContentsEntity0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            return ((h)this.b.d).handle(((G4.a)object0), this.c);
        }
        ((f)this.b.b).insert(((G4.a)object0), this.c);
        return null;
    }
}

