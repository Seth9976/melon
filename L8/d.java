package l8;

import com.iloen.melon.activity.BaseActivity;
import ie.H;
import we.a;

public final class d implements a {
    public final int a;
    public final BaseActivity b;

    public d(BaseActivity baseActivity0, int v) {
        this.a = v;
        this.b = baseActivity0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return BaseActivity.kakaoLoginHelper_delegate$lambda$0(this.b);
            }
            case 1: {
                this.b.onBackPressed();
                return H.a;
            }
            default: {
                this.b.onBackPressed();
                return H.a;
            }
        }
    }
}

