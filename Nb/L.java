package Nb;

import Qb.z;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.utils.log.DevLog;
import com.melon.playback.MelonIntentService;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import pc.l1;
import we.n;
import y8.s;

public final class l extends i implements n {
    public final MelonIntentService B;
    public final l1 D;
    public AddPlaySetAvailable r;
    public int w;

    public l(MelonIntentService melonIntentService0, l1 l10, Continuation continuation0) {
        this.B = melonIntentService0;
        this.D = l10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        AddPlaySetAvailable addAction$AddPlaySetAvailable1;
        Object object1;
        a a0 = a.a;
        MelonIntentService melonIntentService0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                DevLog.Companion.get("AutoPlay").put("MelonIntentService.play()");
                s s0 = melonIntentService0.i;
                if(s0 != null) {
                    this.w = 1;
                    if(s0.c(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                        return a0;
                    }
                    goto label_14;
                }
                q.m("playerUseCase");
                throw null;
            }
            case 1: {
                d5.n.D(object0);
            label_14:
                AddPlaySetAvailable addAction$AddPlaySetAvailable0 = new AddPlaySetAvailable(false);
                MixUp playDataForSeverContent$MixUp0 = new MixUp(this.D, "1000003089", null);
                k8.a a1 = melonIntentService0.e;
                if(a1 != null) {
                    AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlaySetAvailable0, false, false, a1, playDataForSeverContent$MixUp0, 6, null);
                    this.r = addAction$AddPlaySetAvailable0;
                    this.w = 2;
                    object1 = addServerContent0.execute(this);
                    if(object1 == a0) {
                        return a0;
                    }
                    addAction$AddPlaySetAvailable1 = addAction$AddPlaySetAvailable0;
                    break;
                }
                q.m("blockingProgressDialogManage");
                throw null;
            }
            case 2: {
                addAction$AddPlaySetAvailable1 = this.r;
                d5.n.D(object0);
                object1 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object1).handleToast(addAction$AddPlaySetAvailable1);
        if(((AddResult)object1) instanceof Failure) {
            s s1 = melonIntentService0.i;
            if(s1 != null) {
                ((z)s1.a).s();
                return H.a;
            }
            q.m("playerUseCase");
            throw null;
        }
        return H.a;
    }
}

