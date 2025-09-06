package com.melon.ui.popup.context.more;

import A7.d;
import androidx.appcompat.app.o;
import com.iloen.melon.utils.MelonSettingInfo;
import java.util.ArrayList;
import k8.Y;
import zd.D0;
import zd.x;

public final class k extends D0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public k(boolean z, boolean z1, boolean z2) {
        this.a = z;
        this.b = z1;
        this.c = z2;
    }

    @Override  // zd.D0
    public final String a() {
        return "";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        if(!this.a) {
            AddPositionInfo extraProperties$AddPositionInfo0 = new AddPositionInfo(MelonSettingInfo.getPlayListAddPosition());
            arrayList0.add(MelonBottomSheetItem.a(x.t, false, extraProperties$AddPositionInfo0, 0x1F));
        }
        if(this.b) {
            arrayList0.add(x.v);
            return arrayList0;
        }
        AddPositionInfo extraProperties$AddPositionInfo1 = new AddPositionInfo(MelonSettingInfo.getNormalPlayListAddPosition());
        arrayList0.add(MelonBottomSheetItem.a(x.u, false, extraProperties$AddPositionInfo1, 0x1F));
        if(this.c) {
            AddPositionInfo extraProperties$AddPositionInfo2 = new AddPositionInfo(MelonSettingInfo.getDjPlayListAddPosition());
            arrayList0.add(MelonBottomSheetItem.a(x.w, false, extraProperties$AddPositionInfo2, 0x1F));
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && this.a == ((k)object0).a && this.b == ((k)object0).b && this.c == ((k)object0).c;
    }

    @Override  // zd.Q
    public final int g() {
        return 33;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b);
    }

    // 去混淆评级： 低(20)
    @Override  // zd.Q
    public final String r() {
        return "";
    }

    @Override
    public final String toString() {
        return o.s(Y.q("PutPopupType(isNowPlayingList=", ", isLocalPlaylist=", this.a, ", isDj=", this.b), this.c, ")");
    }
}

