package com.iloen.melon.playback.playlist.add;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.google.firebase.b;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.d;
import k8.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import ob.z;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\'\u0010\u0006\u001A\u00020\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0015\u0010\t\u001A\u0004\u0018\u00010\b*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Landroid/app/Activity;", "Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "addToPlaylist", "", "showNetworkPopup", "Lie/H;", "addPlaylistAndReturnAction", "(Landroid/app/Activity;Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;Z)V", "Landroidx/fragment/app/l0;", "getSupportFragmentManger", "(Landroid/app/Activity;)Landroidx/fragment/app/l0;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class AddToPlaylistUIHelperKt {
    @d
    public static final void addPlaylistAndReturnAction(@Nullable Activity activity0, @NotNull AddToPlaylist addToPlaylist0, boolean z) {
        q.g(addToPlaylist0, "addToPlaylist");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(activity0, addToPlaylist0, z, null) {
            final AddToPlaylist $addToPlaylist;
            final boolean $showNetworkPopup;
            final Activity $this_addPlaylistAndReturnAction;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                this.$this_addPlaylistAndReturnAction = activity0;
                this.$addToPlaylist = addToPlaylist0;
                this.$showNetworkPopup = z;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1(this.$this_addPlaylistAndReturnAction, this.$addToPlaylist, this.$showNetworkPopup, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                z z2;
                Activity activity2;
                Object object1;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Activity activity1 = this.$this_addPlaylistAndReturnAction;
                        if(activity1 != null) {
                            Context context0 = activity1.getApplicationContext();
                            q.d(context0);
                            z z1 = ((o)(((Ma.o)b.B(context0, Ma.o.class)))).k();
                            this.L$0 = activity1;
                            this.L$1 = z1;
                            this.label = 1;
                            object1 = this.$addToPlaylist.execute(this);
                            if(object1 == a0) {
                                return a0;
                            }
                            activity2 = activity1;
                            z2 = z1;
                            goto label_29;
                        }
                        break;
                    }
                    case 1: {
                        z2 = (z)this.L$1;
                        Activity activity3 = (Activity)this.L$0;
                        d5.n.D(object0);
                        activity2 = activity3;
                        object1 = object0;
                    label_29:
                        ((AddResult)object1).handleToast(this.$addToPlaylist.getAddAction());
                        if(((AddResult)object1) instanceof Failure) {
                            l0 l00 = null;
                            AddFailType addFailType1 = ((Failure)(((AddResult)object1))).getType();
                            if(q.b(addFailType1, SectionRepeatInterrupt.INSTANCE)) {
                                activity2.runOnUiThread(new c(activity2, z2, this.$this_addPlaylistAndReturnAction, this.$addToPlaylist));
                                return h0;
                            }
                            if(q.b(addFailType1, SmartPlaylistAlert.INSTANCE)) {
                                activity2.runOnUiThread(new com.iloen.melon.playback.playlist.add.d(activity2));
                                return h0;
                            }
                            if(addFailType1 instanceof AddAllBan) {
                                activity2.runOnUiThread(new c(activity2, ((AddAllBan)addFailType1), this.$addToPlaylist, this.$this_addPlaylistAndReturnAction));
                                return h0;
                            }
                            if(!q.b(addFailType1, Normal.INSTANCE)) {
                                if(addFailType1 instanceof MusicWaveOpen) {
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.label = 2;
                                    if(((MusicWaveOpen)addFailType1).navigate(this) == a0) {
                                        return a0;
                                    }
                                }
                                else if(addFailType1 instanceof ShowNetworkPopup && this.$showNetworkPopup) {
                                    AppCompatActivity appCompatActivity0 = activity2 instanceof AppCompatActivity ? ((AppCompatActivity)activity2) : null;
                                    if(appCompatActivity0 != null) {
                                        l00 = appCompatActivity0.getSupportFragmentManager();
                                    }
                                    String s = ((ShowNetworkPopup)addFailType1).getMsg();
                                    com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, "안내", s, false, false, false, null, null, null, null, null, 2040);
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        AddFailType addFailType0 = (AddFailType)this.L$3;
                        AddResult addResult0 = (AddResult)this.L$2;
                        z z0 = (z)this.L$1;
                        Activity activity0 = (Activity)this.L$0;
                        d5.n.D(object0);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h0;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                @e(c = "com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt$addPlaylistAndReturnAction$1$1$1$1", f = "AddToPlaylistUIHelper.kt", l = {38}, m = "invokeSuspend")
                final class com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.1.1.1 extends i implements n {
                    final AddToPlaylist $addToPlaylist;
                    final z $playerUseCase;
                    final Activity $this_addPlaylistAndReturnAction;
                    int label;

                    public com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.1.1.1(z z0, Activity activity0, AddToPlaylist addToPlaylist0, Continuation continuation0) {
                        this.$playerUseCase = z0;
                        this.$this_addPlaylistAndReturnAction = activity0;
                        this.$addToPlaylist = addToPlaylist0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.1.1.1(this.$playerUseCase, this.$this_addPlaylistAndReturnAction, this.$addToPlaylist, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                this.label = 1;
                                if(this.$playerUseCase.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this.$this_addPlaylistAndReturnAction, this.$addToPlaylist, false, 2, null);
                        return H.a;
                    }
                }

            }

            private static final void invokeSuspend$lambda$1(Activity activity0, z z0, Activity activity1, AddToPlaylist addToPlaylist0) {
                com.melon.ui.popup.b.s(activity0, AddToPlaylistUIHelperKt.getSupportFragmentManger(activity0), new com.iloen.melon.playback.playlist.add.b(z0, activity1, addToPlaylist0), null);
            }

            private static final H invokeSuspend$lambda$1$lambda$0(z z0, Activity activity0, AddToPlaylist addToPlaylist0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt.addPlaylistAndReturnAction.1.1.1.1(z0, activity0, addToPlaylist0, null), 3, null);
                return H.a;
            }

            private static final void invokeSuspend$lambda$2(Activity activity0) {
                l0 l00 = AddToPlaylistUIHelperKt.getSupportFragmentManger(activity0);
                com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, "안내", "스마트 재생목록에는 멜론에서 다운로드 받은 곡만 재생 및 담기 가능합니다.", false, false, false, null, null, null, null, null, 2040);
            }

            private static final void invokeSuspend$lambda$4(Activity activity0, AddFailType addFailType0, AddToPlaylist addToPlaylist0, Activity activity1) {
                l0 l00 = null;
                AppCompatActivity appCompatActivity0 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
                if(appCompatActivity0 != null) {
                    l00 = appCompatActivity0.getSupportFragmentManager();
                }
                com.melon.ui.popup.b.x(l00, activity0.getString(((AddAllBan)addFailType0).getPopupData().getTitle()), activity0.getString(((AddAllBan)addFailType0).getPopupData().getMsg()), false, false, null, null, new com.iloen.melon.playback.playlist.add.a(addToPlaylist0, activity1), null, null, null, 0xEF8);
            }

            private static final H invokeSuspend$lambda$4$lambda$3(AddToPlaylist addToPlaylist0, Activity activity0) {
                addToPlaylist0.setAllowedBannedContents(true);
                AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(activity0, addToPlaylist0, false, 2, null);
                return H.a;
            }
        }, 3, null);
    }

    public static void addPlaylistAndReturnAction$default(Activity activity0, AddToPlaylist addToPlaylist0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = true;
        }
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(activity0, addToPlaylist0, z);
    }

    private static final l0 getSupportFragmentManger(Activity activity0) {
        FragmentActivity fragmentActivity0 = activity0 instanceof FragmentActivity ? ((FragmentActivity)activity0) : null;
        if(fragmentActivity0 != null) {
            return fragmentActivity0.getSupportFragmentManager();
        }
        LogU.Companion.d("addPlaylistAndReturnAction", "failed to get fragmentActivity");
        return null;
    }
}

