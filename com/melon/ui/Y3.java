package com.melon.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.I;
import com.iloen.melon.activity.FriendSelectActivity;
import com.iloen.melon.constants.CType;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.StringUtils;
import e.b;
import ie.H;
import kotlin.jvm.internal.q;
import pc.t;
import t9.F;
import we.k;
import zd.x0;

public final class y3 implements k {
    public final boolean a;
    public final I b;
    public final x0 c;
    public final x3 d;
    public final Activity e;
    public final k f;
    public final b g;

    public y3(boolean z, I i0, x0 x00, x3 x30, Activity activity0, k k0, b b0) {
        this.a = z;
        this.b = i0;
        this.c = x00;
        this.d = x30;
        this.e = activity0;
        this.f = k0;
        this.g = b0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((k2)object0), "onEvent");
        if(((k2)object0) instanceof K1) {
            Intent intent0 = null;
            int v = ((K1)(((k2)object0))).b.a.ordinal();
            x3 x30 = this.d;
            Activity activity0 = this.e;
            if(v != 36) {
                k k0 = this.f;
                if(v != 52) {
                    switch(v) {
                        case 39: {
                            Sharable sharable0 = ((w3)x30).a;
                            SnsManager.SnsType snsManager$SnsType0 = SnsManager.SnsType.e;
                            if(sharable0 instanceof Playable && ((Playable)sharable0).hasSongId() && ((Playable)sharable0).isOriginLocal()) {
                                k0.invoke(new A3(((Playable)sharable0), snsManager$SnsType0));
                                return H.a;
                            }
                            x0.v(sharable0, activity0, snsManager$SnsType0);
                            return H.a;
                        }
                        case 40: 
                        case 41: {
                            x0.s(((w3)x30).a, activity0);
                            return H.a;
                        }
                        case 42: {
                            Sharable sharable1 = ((w3)x30).a;
                            SnsManager.SnsType snsManager$SnsType1 = SnsManager.SnsType.b;
                            if(sharable1 instanceof Playable && ((Playable)sharable1).hasSongId() && ((Playable)sharable1).isOriginLocal()) {
                                k0.invoke(new A3(((Playable)sharable1), snsManager$SnsType1));
                                return H.a;
                            }
                            x0.v(sharable1, activity0, snsManager$SnsType1);
                            return H.a;
                        }
                        case 43: {
                            x0.v(((w3)x30).a, activity0, SnsManager.SnsType.g);
                            t.E(F.a.B(SnsManager.SnsType.g), ((w3)x30).a);
                            return H.a;
                        }
                        case 44: {
                            x0.w(((w3)x30).a, activity0);
                            return H.a;
                        }
                        case 45: {
                            x0.t(((w3)x30).a, activity0);
                            return H.a;
                        }
                        default: {
                            return H.a;
                        }
                    }
                }
                String s = this.c.u();
                SnsTarget snsTarget0 = F.a.B(SnsManager.SnsType.h);
                q.f(snsTarget0, "getSnsTarget(...)");
                k0.invoke(new z3(s, ((w3)x30).a, snsTarget0));
                return H.a;
            }
            if(!this.a) {
                com.melon.ui.popup.b.l(this.b.getContext(), this.b.getChildFragmentManager(), null, 12);
                return H.a;
            }
            Sharable sharable2 = ((w3)x30).a;
            q.g(sharable2, "sharable");
            if(sharable2 instanceof SharableSong) {
                sharable2 = Playable.newBuilder().songIdTitle(((SharableSong)sharable2).a, ((SharableSong)sharable2).b).isAdult(false).cType(CType.SONG).albumId(((SharableSong)sharable2).d).artists(StringUtils.makeArtistMap("", ((SharableSong)sharable2).g)).build();
            }
            else if(sharable2 instanceof Playable) {
                ((Playable)sharable2).isTypeOfSong();
            }
            if(activity0 != null) {
                q.f("친구 선택하기", "getString(...)");
                Intent intent1 = new Intent(activity0, FriendSelectActivity.class);
                intent1.putExtra("argTabTitleName", "친구 선택하기");
                intent1.putExtra("argMaxResultCount", 10);
                intent1.putExtra("argAttachedSharable", ((Parcelable)sharable2));
                intent1.putExtra("argWhereRUFrom", 0);
                intent0 = intent1;
            }
            if(intent0 != null) {
                b b0 = this.g;
                if(b0 != null) {
                    b0.b(intent0);
                }
            }
            t.E(F.a.B(SnsManager.SnsType.f), sharable2);
        }
        return H.a;
    }
}

