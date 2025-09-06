package sd;

import Ad.J;
import Ad.l;
import K2.a;
import K2.c;
import U4.F;
import X0.u;
import X0.x;
import android.content.Context;
import android.widget.ImageView;
import androidx.fragment.app.I;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.userstore.entity.ExcludedArtistEntity;
import com.iloen.melon.userstore.entity.RestoreDataEntity;
import com.iloen.melon.utils.image.MelonBlurTransformation;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import q8.h;
import vd.v;
import w7.d;
import we.k;
import y9.b;

public final class g implements k {
    public final int a;
    public final String b;

    public g(String s, int v) {
        this.a = v;
        this.b = s;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s8;
        boolean z;
        d d0 = c.a;
        String s = "";
        H h0 = H.a;
        String s1 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s1);
                return h0;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s1);
                return h0;
            }
            case 2: {
                q.g(((x)object0), "$this$semantics");
                if(s1 != null) {
                    s = s1;
                }
                u.h(((x)object0), s);
                return h0;
            }
            case 3: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                u.h(((x)object0), s1);
                return h0;
            }
            case 4: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s1);
                return h0;
            }
            case 5: {
                q.g(((ImageView)object0), "imageView");
                if(s1 != null) {
                    Context context0 = ((ImageView)object0).getContext();
                    MelonBlurTransformation melonBlurTransformation0 = new MelonBlurTransformation(context0, 25, 0x20);
                    Glide.with(context0).load(s1).apply(new RequestOptions().transform(melonBlurTransformation0)).into(((ImageView)object0));
                    LogU.Companion.d("StationPlayerBackground", "update with thumbUri: " + s1);
                }
                return h0;
            }
            case 6: {
                q.g(((I)object0), "it");
                return !(((I)object0) instanceof l) || !q.b(((J)((l)(((I)object0))).getViewModel()).c, s1) ? false : true;
            }
            case 7: {
                q.g(((I)object0), "it");
                return !(((I)object0) instanceof v) || !q.b(((v)(((I)object0))).f, s1) ? false : true;
            }
            case 8: {
                q.g(((a)object0), "$this$semantics");
                List list0 = e.k.z(s1);
                ((a)object0).a.put(d0, list0);
                return h0;
            }
            case 9: {
                q.g(((a)object0), "$this$semantics");
                List list1 = e.k.z(s1);
                ((a)object0).a.put(d0, list1);
                return h0;
            }
            case 10: {
                try(G4.c c0 = ((G4.a)object0).l0("delete from excluded_genre where member_key = ?")) {
                    c0.e(1, s1);
                    c0.j0();
                }
                return h0;
            }
            case 11: {
                try(G4.c c1 = ((G4.a)object0).l0("select * from excluded_artist where member_key = ? and del_yn = 0 order by updt_date desc")) {
                    c1.e(1, s1);
                    int v = F.v(c1, "_id");
                    int v1 = F.v(c1, "artist_id");
                    int v2 = F.v(c1, "artist_name");
                    int v3 = F.v(c1, "artist_img");
                    int v4 = F.v(c1, "exc_artist_seq");
                    int v5 = F.v(c1, "del_yn");
                    int v6 = F.v(c1, "act_genre");
                    int v7 = F.v(c1, "updt_date");
                    int v8 = F.v(c1, "sync_time");
                    int v9 = F.v(c1, "member_key");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c1.j0()) {
                            break;
                        }
                        ExcludedArtistEntity excludedArtistEntity0 = new ExcludedArtistEntity();
                        excludedArtistEntity0.a = c1.getLong(v);
                        String s2 = c1.S(v1);
                        q.g(s2, "<set-?>");
                        excludedArtistEntity0.b = s2;
                        String s3 = c1.S(v2);
                        q.g(s3, "<set-?>");
                        excludedArtistEntity0.c = s3;
                        String s4 = c1.S(v3);
                        q.g(s4, "<set-?>");
                        excludedArtistEntity0.d = s4;
                        String s5 = c1.S(v4);
                        q.g(s5, "<set-?>");
                        excludedArtistEntity0.e = s5;
                        z = ((int)c1.getLong(v5)) == 0 ? false : true;
                        excludedArtistEntity0.f = z;
                        String s6 = c1.S(v6);
                        q.g(s6, "<set-?>");
                        excludedArtistEntity0.g = s6;
                        String s7 = c1.S(v7);
                        q.g(s7, "<set-?>");
                        excludedArtistEntity0.h = s7;
                        s8 = c1.isNull(v8) ? null : c1.S(v8);
                        excludedArtistEntity0.i = s8;
                        String s9 = c1.S(v9);
                        q.g(s9, "<set-?>");
                        excludedArtistEntity0.j = s9;
                        arrayList0.add(excludedArtistEntity0);
                    }
                }
                return arrayList0;
            }
            case 12: {
                try(G4.c c2 = ((G4.a)object0).l0("select * from excluded_genre where member_key = ?")) {
                    c2.e(1, s1);
                    int v10 = F.v(c2, "_id");
                    int v11 = F.v(c2, "gnr_menu_seq");
                    int v12 = F.v(c2, "gnr_code");
                    int v13 = F.v(c2, "gnr_name");
                    int v14 = F.v(c2, "gnr_name_full");
                    int v15 = F.v(c2, "gnr_name_simple");
                    int v16 = F.v(c2, "bg_img_url");
                    int v17 = F.v(c2, "bg_color");
                    int v18 = F.v(c2, "font_color");
                    int v19 = F.v(c2, "member_key");
                    ArrayList arrayList1 = new ArrayList();
                    while(true) {
                        if(!c2.j0()) {
                            break;
                        }
                        b b0 = new b();
                        b0.a = c2.getLong(v10);
                        String s10 = c2.S(v11);
                        q.g(s10, "<set-?>");
                        b0.b = s10;
                        String s11 = c2.S(v12);
                        q.g(s11, "<set-?>");
                        b0.c = s11;
                        String s12 = c2.S(v13);
                        q.g(s12, "<set-?>");
                        b0.d = s12;
                        String s13 = c2.S(v14);
                        q.g(s13, "<set-?>");
                        b0.e = s13;
                        String s14 = c2.S(v15);
                        q.g(s14, "<set-?>");
                        b0.f = s14;
                        String s15 = c2.S(v16);
                        q.g(s15, "<set-?>");
                        b0.g = s15;
                        String s16 = c2.S(v17);
                        q.g(s16, "<set-?>");
                        b0.h = s16;
                        String s17 = c2.S(v18);
                        q.g(s17, "<set-?>");
                        b0.i = s17;
                        String s18 = c2.S(v19);
                        q.g(s18, "<set-?>");
                        b0.j = s18;
                        arrayList1.add(b0);
                    }
                }
                return arrayList1;
            }
            case 13: {
                try(G4.c c3 = ((G4.a)object0).l0("select count(*) from dcf_extension_logs where member_key = ?")) {
                    c3.e(1, s1);
                    return c3.j0() ? ((int)c3.getLong(0)) : 0;
                }
            }
            case 14: {
                try(G4.c c4 = ((G4.a)object0).l0("select * from dcf_extension_logs where member_key = ? order by extend_time limit ?")) {
                    c4.e(1, s1);
                    c4.a(2, 50L);
                    int v20 = F.v(c4, "_id");
                    int v21 = F.v(c4, "ctype");
                    int v22 = F.v(c4, "cid");
                    int v23 = F.v(c4, "mcode");
                    int v24 = F.v(c4, "lcode");
                    int v25 = F.v(c4, "extend_time");
                    int v26 = F.v(c4, "member_key");
                    ArrayList arrayList2 = new ArrayList();
                    while(true) {
                        if(!c4.j0()) {
                            break;
                        }
                        y9.a a0 = new y9.a();
                        a0.a = (int)c4.getLong(v20);
                        String s19 = c4.S(v21);
                        q.g(s19, "<set-?>");
                        a0.b = s19;
                        String s20 = c4.S(v22);
                        q.g(s20, "<set-?>");
                        a0.c = s20;
                        String s21 = c4.S(v23);
                        q.g(s21, "<set-?>");
                        a0.d = s21;
                        String s22 = c4.S(v24);
                        q.g(s22, "<set-?>");
                        a0.e = s22;
                        a0.f = c4.getLong(v25);
                        String s23 = c4.S(v26);
                        q.g(s23, "<set-?>");
                        a0.g = s23;
                        arrayList2.add(a0);
                    }
                }
                return arrayList2;
            }
            case 15: {
                try(G4.c c5 = ((G4.a)object0).l0("delete from restore_data where restore_id = ?")) {
                    c5.e(1, s1);
                    c5.j0();
                }
                return null;
            }
            case 16: {
                try(G4.c c6 = ((G4.a)object0).l0("select * from restore_data where restore_id = ?")) {
                    c6.e(1, s1);
                    int v27 = F.v(c6, "_id");
                    int v28 = F.v(c6, "restore_id");
                    int v29 = F.v(c6, "data");
                    int v30 = F.v(c6, "timestamp");
                    if(c6.j0()) {
                        RestoreDataEntity restoreDataEntity0 = new RestoreDataEntity();
                        restoreDataEntity0.setUid(c6.getLong(v27));
                        restoreDataEntity0.setRestore_id(c6.S(v28));
                        restoreDataEntity0.setData(c6.S(v29));
                        restoreDataEntity0.setTimestamp(c6.getLong(v30));
                        return restoreDataEntity0;
                    }
                }
                return null;
            }
            case 17: {
                try(G4.c c7 = ((G4.a)object0).l0("select count(*) from tab_menu_shortcut where member_key = ?")) {
                    c7.e(1, s1);
                    return c7.j0() ? ((int)c7.getLong(0)) : 0;
                }
            }
            case 18: {
                try(G4.c c8 = ((G4.a)object0).l0("delete from tab_menu_shortcut where member_key = ? and timestamp = (select min(timestamp) from tab_menu_shortcut where member_key = ?)")) {
                    c8.e(1, s1);
                    c8.e(2, s1);
                    c8.j0();
                    return Q1.c.F(((G4.a)object0));
                }
            }
            case 19: {
                try(G4.c c9 = ((G4.a)object0).l0("delete from tag where tag_name = ?")) {
                    c9.e(1, s1);
                    c9.j0();
                    return Q1.c.F(((G4.a)object0));
                }
            }
            case 20: {
                q.g(((q8.c)object0), "$this$customProps");
                ((q8.c)object0).a.put("menuid", s1);
                return h0;
            }
            case 21: {
                q.g(((q8.b)object0), "$this$common");
                ((q8.b)object0).a = "";
                ((q8.b)object0).b = s1;
                return h0;
            }
            case 22: {
                q.g(((q8.a)object0), "$this$click");
                ((q8.a)object0).a = "";
                ((q8.a)object0).g = s1;
                return h0;
            }
            default: {
                q.g(((h)object0), "$this$track");
                if(s1 != null) {
                    s = s1;
                }
                ((h)object0).a = s;
                return h0;
            }
        }
    }
}

