package nc;

import Na.d;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo.DsPlyOrderData;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.log.LogU;
import e1.b;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ne.a;
import oc.Q;
import oe.i;
import we.n;

public final class w extends i implements n {
    public final int B;
    public final int D;
    public int r;
    public final u0 w;

    public w(u0 u00, int v, int v1, Continuation continuation0) {
        this.w = u00;
        this.B = v;
        this.D = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d d0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                u0 u00 = this.w;
                MutableStateFlow mutableStateFlow0 = u00.h;
                DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)mutableStateFlow0.getValue()).g;
                String s = null;
                String s1 = q.b((drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getContsTypeCode()), "N10009") ? "M20002" : "M20001";
                DrawerPlaylistInfo drawerPlaylistInfo1 = ((C0)mutableStateFlow0.getValue()).g;
                if(drawerPlaylistInfo1 != null) {
                    s = drawerPlaylistInfo1.getContsId();
                }
                if(s == null) {
                    s = "";
                }
                b.B(((Q)mutableStateFlow0.getValue()));
                int v = this.B;
                DrawerPlaylistInfo drawerPlaylistInfo2 = ((C0)mutableStateFlow0.getValue()).g;
                if(drawerPlaylistInfo2 == null) {
                    d0 = new d(new Exception("dsPlyOrderList not support"));
                }
                else {
                    List list0 = drawerPlaylistInfo2.getDsPlyOrderDataList();
                    if(list0 == null) {
                        d0 = new d(new Exception("dsPlyOrderList not support"));
                    }
                    else {
                        String s2 = String.valueOf(ProtocolUtils.parseInt(((DsPlyOrderData)list0.get(v)).getDsPlyOrder(), -1));
                        String s3 = String.valueOf(ProtocolUtils.parseInt(((DsPlyOrderData)list0.get(this.D)).getDsPlyOrder(), -1));
                        StringBuilder stringBuilder0 = A7.d.o("request param: plylstTypeCode: ", s1, ", plylstSeq: ", s, ", moveDsplyOrder: ");
                        A7.d.u(stringBuilder0, s2, ", endDsplyOrder: ", s3, ", moveSongId: ");
                        stringBuilder0.append("");
                        LogU.debug$default(u00.f, stringBuilder0.toString(), null, false, 6, null);
                        q.d("");
                        d0 = u00.d.e(s1, s, s2, s3, "", this);
                    }
                }
                return d0 == a0 ? a0 : d0;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

