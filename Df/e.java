package df;

import Af.p;
import De.d;
import Ff.s;
import Hf.P;
import Hf.x;
import Je.o;
import Re.c;
import Tf.v;
import androidx.compose.runtime.b0;
import c2.Y;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.l0;
import com.melon.ui.n0;
import e.k;
import hd.O1;
import hd.s1;
import ie.H;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.I;
import sf.g;
import sf.j;
import we.a;

public final class e implements a {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                q q0 = ((f)object0).c;
                Iterable iterable0 = ((Map)P4.a.r(q0.i, q.m[0])).values();
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: iterable0) {
                    s s0 = ((cf.a)((f)object0).b.a).d.a(q0, ((c)object1));
                    if(s0 != null) {
                        arrayList0.add(s0);
                    }
                }
                return (p[])a.a.D(arrayList0).toArray(new p[0]);
            }
            case 1: {
                Navigator.INSTANCE.openMusicDna();
                n0 n00 = ((s1)object0).getViewModel();
                String s1 = ((s1)object0).getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                kotlin.jvm.internal.q.f(s1, "getString(...)");
                String s2 = ((s1)object0).getString(0x7F130E84);  // string:tiara_dna_layer1_move_music_dna "뮤직DNA 보러가기"
                kotlin.jvm.internal.q.f(s2, "getString(...)");
                String s3 = ((s1)object0).getString(0x7F130E72);  // string:tiara_dna_copy_move_music_dna "뮤직DNA이동"
                kotlin.jvm.internal.q.f(s3, "getString(...)");
                O1.f(((O1)n00), s1, ActionKind.ClickContent, s2, null, null, s3, null, null, null, null, null, null, 0xFD8);
                return h0;
            }
            case 2: {
                ((MusicBrowserActivity)object0).setVideoMiniPlayer();
                return h0;
            }
            case 3: {
                ((b0)object0).setValue(Boolean.valueOf(!((Boolean)((b0)object0).getValue()).booleanValue()));
                return h0;
            }
            case 4: {
                j j0 = ((g)object0).a;
                j j1 = new j();
                Class class0 = j.class;
                Y y0 = kotlin.jvm.internal.q.j(class0.getDeclaredFields());
                while(y0.hasNext()) {
                    Field field0 = (Field)y0.next();
                    if((field0.getModifiers() & 8) == 0) {
                        field0.setAccessible(true);
                        Object object2 = field0.get(j0);
                        ze.a a0 = object2 instanceof ze.a ? ((ze.a)object2) : null;
                        if(a0 != null) {
                            String s4 = field0.getName();
                            kotlin.jvm.internal.q.f(s4, "getName(...)");
                            v.r0(s4, "is", false);
                            d d0 = I.a.b(class0);
                            field0.getName();
                            String s5 = field0.getName();
                            kotlin.jvm.internal.q.f(s5, "getName(...)");
                            if(s5.length() > 0) {
                                kotlin.jvm.internal.q.f(s5.substring(1), "substring(...)");
                            }
                            ((kotlin.jvm.internal.g)d0).c();
                            field0.set(j1, new l0(a0.a, j1));
                        }
                    }
                }
                j1.k(je.I.K(j1.g(), k.A(new qf.c[]{o.p, o.q})));
                j1.a = true;
                return new g(j1);
            }
            default: {
                x x0 = ((P)object0).b();
                kotlin.jvm.internal.q.f(x0, "getType(...)");
                return x0;
            }
        }
    }
}

