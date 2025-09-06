package com.iloen.melon.fragments;

import com.iloen.melon.utils.NameValuePairList;
import java.io.Serializable;
import java.util.ArrayList;

public final class m implements Runnable {
    public final int a;
    public final Serializable b;
    public final Serializable c;
    public final ArrayList d;

    public m(Serializable serializable0, Serializable serializable1, ArrayList arrayList0, int v) {
        this.a = v;
        this.b = serializable0;
        this.c = serializable1;
        this.d = arrayList0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            MelonBaseFragment.lambda$openPresentSendPage$4(((ArrayList)this.b), ((ArrayList)this.c), this.d);
            return;
        }
        MelonBaseFragment.lambda$downloadUrl$6(((String)this.b), ((String)this.c), ((NameValuePairList)this.d));
    }
}

