package p8;

import android.text.TextUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Click.Builder;
import com.kakao.tiara.data.Click;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.LogBuilder;
import com.kakao.tiara.data.Meta;
import com.kakao.tiara.data.Search;
import java.util.HashMap;

public abstract class f {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public ContentList Z;
    public String a;
    public Click a0;
    public String b;
    public Meta b0;
    public String c;
    public Meta c0;
    public ActionKind d;
    public Search d0;
    public String e;
    public final HashMap e0;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public f() {
        this.Z = new ContentList();
        this.e0 = q.b();
    }

    public abstract LogBuilder a();

    public final void b() {
        if(!TextUtils.isEmpty(this.y)) {
            this.a0 = new Builder().layer1(this.y).layer2(this.z).layer3(this.A).ordNum(this.C).setNum(this.D).clickUrl(this.B).image(this.E).copy(this.F).impressionId(this.G).impressionProvider(this.H).build();
        }
        if(!TextUtils.isEmpty(this.e) || !TextUtils.isEmpty(this.f) || !TextUtils.isEmpty(this.g) || !TextUtils.isEmpty(this.h) || !TextUtils.isEmpty(this.i) || !TextUtils.isEmpty(null) || !TextUtils.isEmpty(null) || !TextUtils.isEmpty(this.k) || !TextUtils.isEmpty(this.l) || !TextUtils.isEmpty(this.m) || !TextUtils.isEmpty(this.j) || !TextUtils.isEmpty(this.n)) {
            this.b0 = new com.kakao.tiara.data.Meta.Builder().id(this.e).type(this.f).name(this.g).author(this.h).tags(this.i).provider(this.j).providerId(null).category(null).series(this.k).seriesId(this.l).categoryId(null).image(this.m).providerType(this.n).build();
        }
        if(!TextUtils.isEmpty(this.o) || !TextUtils.isEmpty(this.p) || !TextUtils.isEmpty(this.q) || !TextUtils.isEmpty(this.r) || !TextUtils.isEmpty(this.s) || !TextUtils.isEmpty(this.t) || !TextUtils.isEmpty(this.u) || !TextUtils.isEmpty(this.v) || !TextUtils.isEmpty(this.w) || !TextUtils.isEmpty(this.x)) {
            this.c0 = new com.kakao.tiara.data.Meta.Builder().id(this.o).type(this.p).name(this.q).category(this.r).categoryId(this.s).authorId(this.t).author(this.u).providerType(this.v).series(this.w).seriesId(this.x).build();
        }
        if(!TextUtils.isEmpty(this.X) || !TextUtils.isEmpty(this.Y)) {
            this.d0 = new com.kakao.tiara.data.Search.Builder().searchTerm(this.X).searchType(this.Y).build();
        }
        boolean z = TextUtils.isEmpty(this.I);
        HashMap hashMap0 = this.e0;
        if(!z) {
            hashMap0.put("menuid", this.I);
        }
        if(!TextUtils.isEmpty(this.J)) {
            hashMap0.put("Rangecode", this.J);
        }
        if(!TextUtils.isEmpty(this.K)) {
            hashMap0.put("Targetid", this.K);
        }
        if(!TextUtils.isEmpty(this.L)) {
            hashMap0.put("toros_imp_id", this.L);
        }
        if(!TextUtils.isEmpty(this.M)) {
            hashMap0.put("toros_slot_imp_id", this.M);
        }
        if(!TextUtils.isEmpty(null)) {
            hashMap0.put("toros_banner_imp_id", null);
        }
        if(!TextUtils.isEmpty(this.N)) {
            hashMap0.put("toros_file_hash_key", this.N);
        }
        if(!TextUtils.isEmpty(this.O)) {
            hashMap0.put("toros_user_id_type", this.O);
        }
        if(!TextUtils.isEmpty(this.P)) {
            hashMap0.put("toros_click_ordnum", this.P);
        }
        if(!TextUtils.isEmpty(this.Q)) {
            hashMap0.put("toros_page_meta_id", this.Q);
        }
        if(!TextUtils.isEmpty(this.R)) {
            hashMap0.put("toros_event_meta_id", this.R);
        }
        else if(!TextUtils.isEmpty(this.e) && (!TextUtils.isEmpty(this.L) || !TextUtils.isEmpty(null) || !TextUtils.isEmpty(this.M))) {
            hashMap0.put("toros_event_meta_id", this.e);
        }
        if(!TextUtils.isEmpty(this.S)) {
            hashMap0.put("toros_conts_ids", this.S);
        }
        if(!TextUtils.isEmpty(this.T)) {
            hashMap0.put("toros_seed_conts_id", this.T);
        }
        if(!TextUtils.isEmpty(null)) {
            hashMap0.put("slot_ordnum", null);
        }
        if(!TextUtils.isEmpty(null)) {
            hashMap0.put("slot_type", null);
        }
        if(!TextUtils.isEmpty(this.U)) {
            hashMap0.put("liketype", this.U);
        }
        if(!TextUtils.isEmpty(this.V)) {
            hashMap0.put("onoff", this.V);
        }
        if(!TextUtils.isEmpty(null)) {
            hashMap0.put("Player Type", null);
        }
        if(!TextUtils.isEmpty(this.W)) {
            hashMap0.put("mixup", this.W);
        }
    }

    public final void c(int v) {
        this.C = String.valueOf(v);
    }
}

