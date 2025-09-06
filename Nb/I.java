package Nb;

import G4.c;
import U4.F;
import androidx.fragment.app.I;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.melon.data.database.entity.BannerPopupEntity;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import k8.Y;
import kotlin.jvm.internal.q;
import q8.a;
import q8.f;
import we.k;

public final class i implements k {
    public final int a;
    public final String b;
    public final String c;

    public i(String s, String s1, int v) {
        this.a = v;
        this.b = s;
        this.c = s1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = false;
        H h0 = H.a;
        String s = this.c;
        String s1 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((f)object0), "$this$pageMeta");
                ((f)object0).a = s1;
                ((f)object0).b = Y.i(ContsTypeCode.SONG, "code(...)");
                ((f)object0).c = s;
                return h0;
            }
            case 1: {
                q.g(((a)object0), "$this$click");
                ((a)object0).g = s;
                if(s1 != null && s1.length() != 0) {
                    ((a)object0).f = s1;
                }
                return h0;
            }
            case 2: {
                try(c c1 = ((G4.a)object0).l0("select * from banner_popup where member_key = ? AND popup_type = ?")) {
                    c1.e(1, s1);
                    c1.e(2, s);
                    int v = F.v(c1, "_id");
                    int v1 = F.v(c1, "member_key");
                    int v2 = F.v(c1, "id");
                    int v3 = F.v(c1, "ban_on");
                    int v4 = F.v(c1, "popup_type");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c1.j0()) {
                            break;
                        }
                        BannerPopupEntity bannerPopupEntity0 = new BannerPopupEntity();
                        bannerPopupEntity0.setUid(((int)c1.getLong(v)));
                        bannerPopupEntity0.setMemberKey(c1.S(v1));
                        bannerPopupEntity0.setId(c1.S(v2));
                        bannerPopupEntity0.setBanOn(c1.S(v3));
                        bannerPopupEntity0.setPopupType(c1.S(v4));
                        arrayList0.add(bannerPopupEntity0);
                    }
                    return arrayList0;
                }
            }
            case 3: {
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((q8.c)object0).a;
                if(s1 != null) {
                    linkedHashMap0.put("recmd_key", s1);
                }
                if(s != null) {
                    linkedHashMap0.put("recmd_offer_timestamp", s);
                }
                return h0;
            }
            case 4: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = s1;
                ((f)object0).b = Y.i(ContsTypeCode.ARTIST, "code(...)");
                ((f)object0).c = s;
                return h0;
            }
            case 5: {
                try(c c2 = ((G4.a)object0).l0("delete from premium_contents where cid = ? AND ctype = ?")) {
                    c2.e(1, s1);
                    c2.e(2, s);
                    c2.j0();
                    return Q1.c.F(((G4.a)object0));
                }
            }
            case 6: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = s1;
                ((f)object0).b = Y.i(ContsTypeCode.ARTIST, "code(...)");
                ((f)object0).c = s;
                return h0;
            }
            case 7: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = s1;
                ((f)object0).b = Y.i(ContsTypeCode.ARTIST, "code(...)");
                ((f)object0).c = s;
                return h0;
            }
            case 8: {
                q.g(((I)object0), "fragment");
                if(((I)object0) instanceof vd.i && q.b(((vd.i)(((I)object0))).e, s1) && q.b(((vd.i)(((I)object0))).f, s)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 9: {
                q.g(((I)object0), "fragment");
                if(((I)object0) instanceof vd.i && q.b(((vd.i)(((I)object0))).e, s1) && q.b(((vd.i)(((I)object0))).f, s)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 10: {
                q.g(((I)object0), "fragment");
                if(((I)object0) instanceof vd.i && q.b(((vd.i)(((I)object0))).e, s1) && q.b(((vd.i)(((I)object0))).f, s)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 11: {
                try(c c3 = ((G4.a)object0).l0("delete from excluded_artist where member_key = ? and artist_id = ?")) {
                    c3.e(1, s1);
                    c3.e(2, s);
                    c3.j0();
                    return h0;
                }
            }
            case 12: {
                try(c c4 = ((G4.a)object0).l0("select exc_artist_seq from excluded_artist where member_key = ? and artist_id = ?")) {
                    c4.e(1, s1);
                    c4.e(2, s);
                    return c4.j0() ? c4.S(0) : null;
                }
            }
            case 13: {
                try(c c5 = ((G4.a)object0).l0("delete from excluded_artist where member_key = ? and sync_time = ?")) {
                    c5.e(1, s1);
                    c5.e(2, s);
                    c5.j0();
                    return h0;
                }
            }
            default: {
                try(c c0 = ((G4.a)object0).l0("delete from tab_menu_shortcut where menu_seq = ? and member_key = ?")) {
                    c0.e(1, s1);
                    c0.e(2, s);
                    c0.j0();
                    return Q1.c.F(((G4.a)object0));
                }
            }
        }
    }
}

