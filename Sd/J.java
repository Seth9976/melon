package sd;

import G4.a;
import U4.F;
import X0.u;
import X0.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import androidx.fragment.app.I;
import com.google.android.exoplayer2.ui.PlayerView;
import com.iloen.melon.net.v6x.common.LiveInfoBase.Artist;
import com.iloen.melon.userstore.entity.TagEntity;
import com.iloen.melon.utils.Navigator;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.ui.J4;
import com.melon.ui.K4;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import q8.c;
import vd.T;
import vd.e;
import vd.z;
import we.k;
import xd.g;
import xd.h;
import y8.b;
import y8.f;

public final class j implements k {
    public final int a;

    public j(int v) {
        this.a = v;
        super();
    }

    public j(Object object0, int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
            case 1: {
                q.g(((Context)object0), "it");
                View view0 = LayoutInflater.from(((Context)object0)).inflate(0x7F0D02BD, null, false);  // layout:fragment_player_bg_player_view
                q.e(view0, "null cannot be cast to non-null type com.google.android.exoplayer2.ui.PlayerView");
                ((PlayerView)view0).setUseController(false);
                ((PlayerView)view0).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                ((PlayerView)view0).setResizeMode(4);
                return (PlayerView)view0;
            }
            case 2: {
                q.g(((x)object0), "$this$semantics");
                u.m(((x)object0));
                return h0;
            }
            case 3: {
                if(((h)object0) instanceof g) {
                    Navigator.openArtistInfo(((g)(((h)object0))).b);
                }
                return h0;
            }
            case 4: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a.put("menuid", "1000002908");
                return h0;
            }
            case 5: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a.put("menuid", "1000000543");
                return h0;
            }
            case 6: {
                q.g(((Context)object0), "context");
                ImageView imageView0 = new ImageView(((Context)object0));
                imageView0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView0;
            }
            case 7: {
                q.g(((I)object0), "it");
                return Boolean.valueOf(((I)object0) instanceof e);
            }
            case 8: {
                q.g(((I)object0), "it");
                return Boolean.valueOf(((I)object0) instanceof z);
            }
            case 9: {
                q.g(object0, "it");
                return h0;
            }
            case 10: {
                q.g(((I)object0), "it");
                return Boolean.valueOf(((I)object0) instanceof T);
            }
            case 11: {
                q.g(((I)object0), "it");
                return Boolean.valueOf(((I)object0) instanceof xd.c);
            }
            case 12: {
                q.g(object0, "isChecked");
                return h0;
            }
            case 13: {
                q.g(object0, "it");
                return h0;
            }
            case 14: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 15: {
                q.g(((Pc.e)object0), "userEvent");
                return h0;
            }
            case 16: {
                try(G4.c c0 = ((a)object0).l0("delete from restore_data where _id not in (select _id from restore_data order by _id desc limit ?)")) {
                    c0.a(1, 50L);
                    c0.j0();
                    return null;
                }
            }
            case 17: {
                try(G4.c c1 = ((a)object0).l0("select count(*) from restore_data")) {
                    return c1.j0() ? ((int)c1.getLong(0)) : 0;
                }
            }
            case 18: {
                try(G4.c c2 = ((a)object0).l0("delete from tag where timestamp = (select min(timestamp) from tag)")) {
                    c2.j0();
                    return Q1.c.F(((a)object0));
                }
            }
            case 19: {
                try(G4.c c3 = ((a)object0).l0("select count(*) from tag")) {
                    return c3.j0() ? ((int)c3.getLong(0)) : 0;
                }
            }
            case 20: {
                try(G4.c c4 = ((a)object0).l0("select * from tag order by timestamp desc limit ?")) {
                    c4.a(1, 5L);
                    int v = F.v(c4, "_id");
                    int v1 = F.v(c4, "tag_seq");
                    int v2 = F.v(c4, "tag_name");
                    int v3 = F.v(c4, "timestamp");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c4.j0()) {
                            break;
                        }
                        TagEntity tagEntity0 = new TagEntity();
                        tagEntity0.setUid(c4.getLong(v));
                        tagEntity0.setTagSeq(c4.S(v1));
                        tagEntity0.setTagName(c4.S(v2));
                        tagEntity0.setTimestamp(c4.getLong(v3));
                        arrayList0.add(tagEntity0);
                    }
                    return arrayList0;
                }
            }
            case 21: {
                q.g(((Pc.e)object0), "it");
                return h0;
            }
            case 22: {
                ((Integer)object0).getClass();
                y8.a.b("onAudioEffectUpdate() ");
                if(((Number)f.b().h.getValue()).intValue() == 1) {
                    y8.g g0 = f.b();
                    String s1 = "LoudNorm :On, target:" + g0.c.targetLoudness + "\n type: " + g0.c.loudnessType + "\nFeatures: " + g0.c.preferenceFeatures + "\nDolby : " + y8.a.a();
                    q.g(s1, "params");
                    g0.l.setValue(s1);
                }
                return h0;
            }
            case 23: {
                q.g(((q8.a)object0), "$this$click");
                ((q8.a)object0).b(new b(5));
                ((q8.a)object0).a(new b(6));
                return h0;
            }
            case 24: {
                K4 k40 = (K4)object0;
                return J4.a;
            }
            case 25: {
                ((Integer)object0).intValue();
                return (Integer)object0;
            }
            case 26: {
                String s2 = ((ArtistInfoBase)object0).getArtistName();
                return s2 == null ? "" : s2;
            }
            case 27: {
                String s3 = ((Artist)object0).getArtistName();
                return s3 == null ? "" : s3;
            }
            default: {
                String s = ((Artist)object0).getArtistName();
                return s == null ? "" : s;
            }
        }
    }
}

