package k8;

import M6.B;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import ie.H;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import nc.u0;
import ne.a;
import ob.z;
import oe.i;
import we.n;

public final class e0 extends i implements n {
    public final MusicBrowserActivity B;
    public final String D;
    public DrawerPlaylistInfo r;
    public int w;

    public e0(MusicBrowserActivity musicBrowserActivity0, String s, Continuation continuation0) {
        this.B = musicBrowserActivity0;
        this.D = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e0(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        DrawerPlaylistInfo drawerPlaylistInfo0;
        Object object1;
        DrawerPlaylistInfo drawerPlaylistInfo1;
        Object object2;
        Object object3;
        String s;
        a a0 = a.a;
        H h0 = H.a;
        MusicBrowserActivity musicBrowserActivity0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)musicBrowserActivity0.getPlaylistManager()).h();
                this.w = 1;
                object3 = ListenableFutureKt.await(b0, this);
                if(object3 != a0) {
                label_23:
                    if(object3 != PlaylistId.DRAWER) {
                        return h0;
                    }
                    B b1 = ((d3)musicBrowserActivity0.getPlaylistManager()).l();
                    this.w = 2;
                    object2 = ListenableFutureKt.await(b1, this);
                    if(object2 != a0) {
                    label_28:
                        drawerPlaylistInfo1 = ((u0)(((nc.a)object2))).I().g;
                        if(drawerPlaylistInfo1 == null || !q.b(drawerPlaylistInfo1.getContsTypeCode(), "N10005") && !q.b(drawerPlaylistInfo1.getContsTypeCode(), "N10009") || !q.b(drawerPlaylistInfo1.getContsId(), this.D)) {
                            return h0;
                        }
                        z z0 = musicBrowserActivity0.getPlayerUseCase();
                        this.r = drawerPlaylistInfo1;
                        this.w = 3;
                        object1 = z0.o(this);
                        if(object1 != a0) {
                        label_35:
                            if(!((Boolean)object1).booleanValue()) {
                                goto label_42;
                            }
                            z z1 = musicBrowserActivity0.getPlayerUseCase();
                            this.r = drawerPlaylistInfo1;
                            this.w = 4;
                            if(z1.b(0x7F13090F, this) != a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                                drawerPlaylistInfo0 = drawerPlaylistInfo1;
                            label_41:
                                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                            label_42:
                                switch(drawerPlaylistInfo1.getLandingFrom()) {
                                    case "DJ": {
                                        s = "1000001776";
                                        break;
                                    }
                                    case "LIKE": {
                                        s = "1000003091";
                                        break;
                                    }
                                    case "RECENT": {
                                        s = "1000003090";
                                        break;
                                    }
                                    default: {
                                        s = "1000000559";
                                    }
                                }
                                DrawerPlaylist playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(drawerPlaylistInfo1, s, null);
                                k8.a a1 = musicBrowserActivity0.getBlockingProgressDialogManage();
                                AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(musicBrowserActivity0, new AddServerContent(Add.INSTANCE, false, false, a1, playDataForSeverContent$DrawerPlaylist0, 6, null), false, 2, null);
                                return h0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object3 = object0;
                goto label_23;
            }
            case 2: {
                d5.n.D(object0);
                object2 = object0;
                goto label_28;
            }
            case 3: {
                drawerPlaylistInfo1 = this.r;
                d5.n.D(object0);
                object1 = object0;
                goto label_35;
            }
            case 4: {
                drawerPlaylistInfo0 = this.r;
                d5.n.D(object0);
                goto label_41;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

