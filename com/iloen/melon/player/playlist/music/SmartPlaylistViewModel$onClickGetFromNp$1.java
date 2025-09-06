package com.iloen.melon.player.playlist.music;

import M6.B;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddFailType.SmartPlaylistAlert;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.PopupData;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.q4;
import e1.b;
import ie.H;
import java.util.ArrayList;
import kc.G2;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.e;
import oe.i;
import qc.n0;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.music.SmartPlaylistViewModel$onClickGetFromNp$1", f = "SmartPlaylistViewModel.kt", l = {0x86, 150}, m = "invokeSuspend")
final class SmartPlaylistViewModel.onClickGetFromNp.1 extends i implements n {
    public final SmartPlaylistViewModel B;
    public Add r;
    public int w;

    public SmartPlaylistViewModel.onClickGetFromNp.1(SmartPlaylistViewModel smartPlaylistViewModel0, Continuation continuation0) {
        this.B = smartPlaylistViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new SmartPlaylistViewModel.onClickGetFromNp.1(this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((SmartPlaylistViewModel.onClickGetFromNp.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Add addAction$Add1;
        Object object2;
        Object object1;
        a a0 = a.a;
        H h0 = H.a;
        SmartPlaylistViewModel smartPlaylistViewModel0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                d3 d30 = (d3)smartPlaylistViewModel0.getPlaylistManager();
                G2 g20 = new G2(d30, null);
                B b0 = ListenableFutureKt.future$default(d30.b, null, null, g20, 3, null);
                this.w = 1;
                object1 = ListenableFutureKt.await(b0, this);
                if(object1 == a0) {
                    return a0;
                }
                goto label_15;
            }
            case 1: {
                d5.n.D(object0);
                object1 = object0;
            label_15:
                ArrayList arrayList0 = b.B(((n0)(((qc.a)object1))).H());
                if(arrayList0.isEmpty()) {
                    ToastManager.show(0x7F130A1D);  // string:smart_playlist_empty_take_playlist_error "가져올 곡이 없어요."
                    return h0;
                }
                Add addAction$Add0 = Add.INSTANCE;
                AddPlayableList addPlayableList0 = new AddPlayableList(null, addAction$Add0, false, false, false, null, arrayList0, 0x20, null);
                this.r = addAction$Add0;
                this.w = 2;
                object2 = addPlayableList0.execute(this);
                if(object2 == a0) {
                    return a0;
                }
                addAction$Add1 = addAction$Add0;
                break;
            }
            case 2: {
                addAction$Add1 = this.r;
                d5.n.D(object0);
                object2 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object2).handleToast(addAction$Add1);
        if(((AddResult)object2) instanceof Failure) {
            LogU.error$default(smartPlaylistViewModel0.getLog(), "addResult is AddResult.Failure " + ((AddResult)object2), null, false, 6, null);
            if(((Failure)(((AddResult)object2))).getType() instanceof SmartPlaylistAlert) {
                PopupData popupData0 = ((SmartPlaylistAlert)((Failure)(((AddResult)object2))).getType()).getPopupData();
                SmartPlaylistViewModel.access$sendUiEvent(smartPlaylistViewModel0, new q4(28, ((StringProviderImpl)smartPlaylistViewModel0.getStringProvider()).a(popupData0.getTitle()), ((StringProviderImpl)smartPlaylistViewModel0.getStringProvider()).a(popupData0.getMsg()), null, null));
            }
        }
        return h0;
    }
}

