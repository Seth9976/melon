package zd;

import com.melon.ui.Z1;
import com.melon.ui.k2;
import com.melon.ui.musicwave.ChannelInfoData;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import jd.F2;
import kotlin.jvm.internal.q;
import vb.f;

public final class q0 extends m {
    public final ChannelInfoData a;
    public final String b;
    public final String c;

    public q0(ChannelInfoData channelInfoData0, String s, String s1) {
        q.g(s, "menuId");
        super();
        this.a = channelInfoData0;
        this.b = s;
        this.c = s1;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.a;
        return s == null ? "" : s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10096", "code(...)");
        return "N10096";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        F2 f20;
        ArrayList arrayList0 = new ArrayList();
        ChannelInfoData channelInfoData0 = this.a;
        String s = channelInfoData0.f;
        if(s == null) {
            f20 = F2.a;
        }
        else {
            switch(s) {
                case "artist": 
                case "artistrep": {
                    f20 = F2.d;
                    break;
                }
                case "chart": {
                    f20 = F2.b;
                    break;
                }
                case "djplylst": {
                    f20 = F2.e;
                    break;
                }
                case "offer": {
                    f20 = F2.a;
                    break;
                }
                case "station": {
                    f20 = F2.f;
                    break;
                }
                case "userplylst": {
                    f20 = F2.g;
                    break;
                }
                default: {
                    f20 = F2.a;
                }
            }
        }
        if(channelInfoData0.a()) {
            arrayList0.add(x.j0);
            arrayList0.add(x.B0);
            arrayList0.add(x.i0);
            return arrayList0;
        }
        arrayList0.add(x.c);
        if(f20 != F2.d && f20 != F2.c) {
            if(f20 == F2.g) {
                arrayList0.add(x.l);
                return arrayList0;
            }
            if(f20 == F2.e) {
                arrayList0.add(MelonBottomSheetItem.a(x.k, false, null, 61));
                return arrayList0;
            }
            if(f20 == F2.f) {
                arrayList0.add(x.g0);
            }
            return arrayList0;
        }
        arrayList0.add(x.h);
        return arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override  // zd.Q
    public final int d(boolean z) {
        return z ? 0x7F0800FF : 0x7F0800FE;  // drawable:btn_bookmark_22_on
    }

    @Override  // zd.Q
    public final int e() {
        return 0x7F13023B;  // string:ctx_menu_bookmark "북마크"
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q0)) {
            return false;
        }
        if(!q.b(this.a, ((q0)object0).a)) {
            return false;
        }
        return q.b(this.b, ((q0)object0).b) ? q.b(this.c, ((q0)object0).c) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 24;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + U4.x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override  // zd.m
    public final boolean i() {
        return false;
    }

    @Override  // zd.m
    public final boolean j() {
        return true;
    }

    @Override  // zd.m
    public final boolean l() {
        return true;
    }

    @Override  // zd.m
    public final boolean m() {
        return !this.a.a();
    }

    @Override  // zd.m
    public final boolean n() {
        return true;
    }

    @Override  // zd.m
    public final boolean o() {
        return true;
    }

    @Override  // zd.m
    public final String p() {
        return this.b;
    }

    @Override  // zd.m
    public final String q() {
        String s = this.a.h;
        return s == null ? "" : s;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.b;
        return s == null ? "" : s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.a.i;
    }

    @Override  // zd.m
    public final l t() {
        return l.d;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MusicWavePopupType(channel=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", menuId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", userCount=");
        return U4.x.m(stringBuilder0, this.c, ")");
    }

    @Override  // zd.m
    public final k2 u() {
        String s = this.a();
        String s1 = this.a.f;
        String s2 = s1 == null ? "" : s1;
        String s3 = this.r();
        String s4 = this.a();
        if(s1 == null) {
            s1 = "";
        }
        return new Z1(new f(s, s2, s3, s4 + "_" + s1));
    }

    @Override  // zd.m
    public final boolean v() {
        return true;
    }

    @Override  // zd.m
    public final boolean x() {
        return true;
    }
}

