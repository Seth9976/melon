package com.iloen.melon.playback.playlist.add;

import M6.B;
import Ub.s;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.utils.Navigator;
import d5.n;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import ob.z;
import oc.b0;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0018\u0019\u001A\u001B\u001C\u001D\u001EB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH¦@¢\u0006\u0004\b\r\u0010\u000EJ0\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH¦@¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u0014H¦@¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0001\u0007\u001F !\"#$%¨\u0006&"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction;", "", "<init>", "()V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Add", "AddPlay", "AddPlaySetAvailable", "AddPlayOpenPlayer", "AddPlayOpenPlaylist", "MusicWaveOpen", "VideoPlayAndOpen", "Lcom/iloen/melon/playback/playlist/add/AddAction$Add;", "Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlay;", "Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlayOpenPlayer;", "Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlayOpenPlaylist;", "Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlaySetAvailable;", "Lcom/iloen/melon/playback/playlist/add/AddAction$MusicWaveOpen;", "Lcom/iloen/melon/playback/playlist/add/AddAction$VideoPlayAndOpen;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class AddAction {
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000EJ0\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u0014H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001A\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\u001BHÖ\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u001A\u0010!\u001A\u00020 2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001A\u0010#\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010\u001A¨\u0006&"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$Add;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "<init>", "()V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "tag", "Ljava/lang/String;", "getTag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Add extends AddAction {
        public static final int $stable;
        @NotNull
        public static final Add INSTANCE;
        @NotNull
        private static final String tag;

        static {
            Add.INSTANCE = new Add();
            Add.tag = "Add";
        }

        private Add() {
            super(null);
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.Add.checkCanAdded.1 addAction$Add$checkCanAdded$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.Add.checkCanAdded.1) {
                addAction$Add$checkCanAdded$10 = (com.iloen.melon.playback.playlist.add.AddAction.Add.checkCanAdded.1)continuation0;
                int v = addAction$Add$checkCanAdded$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$Add$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.checkCanAdded(null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$Add$checkCanAdded$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$Add$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkCanAdded(null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$Add$checkCanAdded$10.result;
            a a0 = a.a;
            switch(addAction$Add$checkCanAdded$10.label) {
                case 0: {
                    n.D(object0);
                    B b0 = ((d3)s20).h();
                    addAction$Add$checkCanAdded$10.L$0 = null;
                    addAction$Add$checkCanAdded$10.L$1 = z0;
                    addAction$Add$checkCanAdded$10.L$2 = playlistId0;
                    addAction$Add$checkCanAdded$10.L$3 = null;
                    addAction$Add$checkCanAdded$10.label = 1;
                    object0 = ListenableFutureKt.await(b0, addAction$Add$checkCanAdded$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_28;
                }
                case 1: {
                    s s1 = (s)addAction$Add$checkCanAdded$10.L$3;
                    playlistId0 = (PlaylistId)addAction$Add$checkCanAdded$10.L$2;
                    z0 = (z)addAction$Add$checkCanAdded$10.L$1;
                    s2 s21 = (s2)addAction$Add$checkCanAdded$10.L$0;
                    n.D(object0);
                label_28:
                    if(object0 == playlistId0) {
                        addAction$Add$checkCanAdded$10.L$0 = null;
                        addAction$Add$checkCanAdded$10.L$1 = null;
                        addAction$Add$checkCanAdded$10.L$2 = null;
                        addAction$Add$checkCanAdded$10.L$3 = null;
                        addAction$Add$checkCanAdded$10.label = 2;
                        object0 = z0.o(addAction$Add$checkCanAdded$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_42;
                    }
                    break;
                }
                case 2: {
                    s s2 = (s)addAction$Add$checkCanAdded$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$Add$checkCanAdded$10.L$2;
                    z z1 = (z)addAction$Add$checkCanAdded$10.L$1;
                    s2 s22 = (s2)addAction$Add$checkCanAdded$10.L$0;
                    n.D(object0);
                label_42:
                    if(((Boolean)object0).booleanValue()) {
                        return SectionRepeatInterrupt.INSTANCE;
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return null;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Add;
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTag() {
            return "Add";
        }

        @Override
        public int hashCode() {
            return 0x81D156B3;
        }

        @Override
        @NotNull
        public String toString() {
            return "Add";
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0015\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0019\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0017H\u0096@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001B\u0010\u001CJ\u001A\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001A\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001A\u0010\'\u001A\u00020\u00032\b\u0010&\u001A\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b\'\u0010(R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010)\u001A\u0004\b\u0004\u0010\u001CR\u001A\u0010*\u001A\u00020\u001F8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001A\u0004\b,\u0010!¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlay;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "Lcom/iloen/melon/playback/playlist/add/ShufflePlay;", "", "isShufflePlay", "<init>", "(Z)V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Z", "copy", "(Z)Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlay;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "tag", "Ljava/lang/String;", "getTag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AddPlay extends AddAction implements ShufflePlay {
        public static final int $stable;
        private final boolean isShufflePlay;
        @NotNull
        private final String tag;

        public AddPlay(boolean z) {
            super(null);
            this.isShufflePlay = z;
            this.tag = "AddAndPlay";
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlay.afterTask.1 addAction$AddPlay$afterTask$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlay.afterTask.1) {
                addAction$AddPlay$afterTask$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlay.afterTask.1)continuation0;
                int v = addAction$AddPlay$afterTask$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlay$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.afterTask(null, null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlay$afterTask$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlay$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.afterTask(null, null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlay$afterTask$10.result;
            a a0 = a.a;
            switch(addAction$AddPlay$afterTask$10.label) {
                case 0: {
                    n.D(object0);
                    B b0 = ((d3)s20).a(playlistId0);
                    addAction$AddPlay$afterTask$10.L$0 = null;
                    addAction$AddPlay$afterTask$10.L$1 = z0;
                    addAction$AddPlay$afterTask$10.L$2 = null;
                    addAction$AddPlay$afterTask$10.L$3 = null;
                    addAction$AddPlay$afterTask$10.L$4 = null;
                    addAction$AddPlay$afterTask$10.label = 1;
                    if(ListenableFutureKt.await(b0, addAction$AddPlay$afterTask$10) == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    b0 b01 = (b0)addAction$AddPlay$afterTask$10.L$4;
                    AddRequestPlayableListInfo addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addAction$AddPlay$afterTask$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlay$afterTask$10.L$2;
                    z0 = (z)addAction$AddPlay$afterTask$10.L$1;
                    s2 s21 = (s2)addAction$AddPlay$afterTask$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            z0.u();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            z0.s();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlay.checkCanAdded.1 addAction$AddPlay$checkCanAdded$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlay.checkCanAdded.1) {
                addAction$AddPlay$checkCanAdded$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlay.checkCanAdded.1)continuation0;
                int v = addAction$AddPlay$checkCanAdded$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlay$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.checkCanAdded(null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlay$checkCanAdded$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlay$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkCanAdded(null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlay$checkCanAdded$10.result;
            a a0 = a.a;
            switch(addAction$AddPlay$checkCanAdded$10.label) {
                case 0: {
                    n.D(object0);
                    addAction$AddPlay$checkCanAdded$10.L$0 = null;
                    addAction$AddPlay$checkCanAdded$10.L$1 = null;
                    addAction$AddPlay$checkCanAdded$10.L$2 = null;
                    addAction$AddPlay$checkCanAdded$10.L$3 = null;
                    addAction$AddPlay$checkCanAdded$10.label = 1;
                    object0 = z0.o(addAction$AddPlay$checkCanAdded$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    s s1 = (s)addAction$AddPlay$checkCanAdded$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlay$checkCanAdded$10.L$2;
                    z z1 = (z)addAction$AddPlay$checkCanAdded$10.L$1;
                    s2 s21 = (s2)addAction$AddPlay$checkCanAdded$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return ((Boolean)object0).booleanValue() ? SectionRepeatInterrupt.INSTANCE : null;
        }

        public final boolean component1() {
            return this.isShufflePlay;
        }

        @NotNull
        public final AddPlay copy(boolean z) {
            return new AddPlay(z);
        }

        public static AddPlay copy$default(AddPlay addAction$AddPlay0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = addAction$AddPlay0.isShufflePlay;
            }
            return addAction$AddPlay0.copy(z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AddPlay ? this.isShufflePlay == ((AddPlay)object0).isShufflePlay : false;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isShufflePlay);
        }

        @Override  // com.iloen.melon.playback.playlist.add.ShufflePlay
        public boolean isShufflePlay() {
            return this.isShufflePlay;
        }

        @Override
        @NotNull
        public String toString() {
            return "AddPlay(isShufflePlay=" + this.isShufflePlay + ")";
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0015\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0019\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0017H\u0096@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001B\u0010\u001CJ\u001A\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001A\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001A\u0010\'\u001A\u00020\u00032\b\u0010&\u001A\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b\'\u0010(R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010)\u001A\u0004\b\u0004\u0010\u001CR\u001A\u0010*\u001A\u00020\u001F8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001A\u0004\b,\u0010!¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlayOpenPlayer;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "Lcom/iloen/melon/playback/playlist/add/ShufflePlay;", "", "isShufflePlay", "<init>", "(Z)V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Z", "copy", "(Z)Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlayOpenPlayer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "tag", "Ljava/lang/String;", "getTag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AddPlayOpenPlayer extends AddAction implements ShufflePlay {
        public static final int $stable;
        private final boolean isShufflePlay;
        @NotNull
        private final String tag;

        public AddPlayOpenPlayer(boolean z) {
            super(null);
            this.isShufflePlay = z;
            this.tag = "AddPlayOpenPlayer";
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer.afterTask.1 addAction$AddPlayOpenPlayer$afterTask$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer.afterTask.1) {
                addAction$AddPlayOpenPlayer$afterTask$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer.afterTask.1)continuation0;
                int v = addAction$AddPlayOpenPlayer$afterTask$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlayOpenPlayer$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.afterTask(null, null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlayOpenPlayer$afterTask$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlayOpenPlayer$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.afterTask(null, null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlayOpenPlayer$afterTask$10.result;
            a a0 = a.a;
            switch(addAction$AddPlayOpenPlayer$afterTask$10.label) {
                case 0: {
                    n.D(object0);
                    B b0 = ((d3)s20).a(playlistId0);
                    addAction$AddPlayOpenPlayer$afterTask$10.L$0 = null;
                    addAction$AddPlayOpenPlayer$afterTask$10.L$1 = z0;
                    addAction$AddPlayOpenPlayer$afterTask$10.L$2 = null;
                    addAction$AddPlayOpenPlayer$afterTask$10.L$3 = null;
                    addAction$AddPlayOpenPlayer$afterTask$10.L$4 = null;
                    addAction$AddPlayOpenPlayer$afterTask$10.label = 1;
                    if(ListenableFutureKt.await(b0, addAction$AddPlayOpenPlayer$afterTask$10) == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    b0 b01 = (b0)addAction$AddPlayOpenPlayer$afterTask$10.L$4;
                    AddRequestPlayableListInfo addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addAction$AddPlayOpenPlayer$afterTask$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlayOpenPlayer$afterTask$10.L$2;
                    z0 = (z)addAction$AddPlayOpenPlayer$afterTask$10.L$1;
                    s2 s21 = (s2)addAction$AddPlayOpenPlayer$afterTask$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            z0.u();
            Navigator.openNowPlayer$default(Navigator.INSTANCE, 0, 1, null);
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            z0.s();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer.checkCanAdded.1 addAction$AddPlayOpenPlayer$checkCanAdded$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer.checkCanAdded.1) {
                addAction$AddPlayOpenPlayer$checkCanAdded$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer.checkCanAdded.1)continuation0;
                int v = addAction$AddPlayOpenPlayer$checkCanAdded$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlayOpenPlayer$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.checkCanAdded(null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlayOpenPlayer$checkCanAdded$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlayOpenPlayer$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkCanAdded(null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlayOpenPlayer$checkCanAdded$10.result;
            a a0 = a.a;
            switch(addAction$AddPlayOpenPlayer$checkCanAdded$10.label) {
                case 0: {
                    n.D(object0);
                    addAction$AddPlayOpenPlayer$checkCanAdded$10.L$0 = null;
                    addAction$AddPlayOpenPlayer$checkCanAdded$10.L$1 = null;
                    addAction$AddPlayOpenPlayer$checkCanAdded$10.L$2 = null;
                    addAction$AddPlayOpenPlayer$checkCanAdded$10.L$3 = null;
                    addAction$AddPlayOpenPlayer$checkCanAdded$10.label = 1;
                    object0 = z0.o(addAction$AddPlayOpenPlayer$checkCanAdded$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    s s1 = (s)addAction$AddPlayOpenPlayer$checkCanAdded$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlayOpenPlayer$checkCanAdded$10.L$2;
                    z z1 = (z)addAction$AddPlayOpenPlayer$checkCanAdded$10.L$1;
                    s2 s21 = (s2)addAction$AddPlayOpenPlayer$checkCanAdded$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return ((Boolean)object0).booleanValue() ? SectionRepeatInterrupt.INSTANCE : null;
        }

        public final boolean component1() {
            return this.isShufflePlay;
        }

        @NotNull
        public final AddPlayOpenPlayer copy(boolean z) {
            return new AddPlayOpenPlayer(z);
        }

        public static AddPlayOpenPlayer copy$default(AddPlayOpenPlayer addAction$AddPlayOpenPlayer0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = addAction$AddPlayOpenPlayer0.isShufflePlay;
            }
            return addAction$AddPlayOpenPlayer0.copy(z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AddPlayOpenPlayer ? this.isShufflePlay == ((AddPlayOpenPlayer)object0).isShufflePlay : false;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isShufflePlay);
        }

        @Override  // com.iloen.melon.playback.playlist.add.ShufflePlay
        public boolean isShufflePlay() {
            return this.isShufflePlay;
        }

        @Override
        @NotNull
        public String toString() {
            return "AddPlayOpenPlayer(isShufflePlay=" + this.isShufflePlay + ")";
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0015\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0019\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0017H\u0096@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001B\u0010\u001CJ\u001A\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001A\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001A\u0010\'\u001A\u00020\u00032\b\u0010&\u001A\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b\'\u0010(R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010)\u001A\u0004\b\u0004\u0010\u001CR\u001A\u0010*\u001A\u00020\u001F8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001A\u0004\b,\u0010!¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlayOpenPlaylist;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "Lcom/iloen/melon/playback/playlist/add/ShufflePlay;", "", "isShufflePlay", "<init>", "(Z)V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Z", "copy", "(Z)Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlayOpenPlaylist;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "tag", "Ljava/lang/String;", "getTag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AddPlayOpenPlaylist extends AddAction implements ShufflePlay {
        public static final int $stable;
        private final boolean isShufflePlay;
        @NotNull
        private final String tag;

        public AddPlayOpenPlaylist(boolean z) {
            super(null);
            this.isShufflePlay = z;
            this.tag = "AddPlayOpenPlaylist";
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlaylist.afterTask.1 addAction$AddPlayOpenPlaylist$afterTask$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlaylist.afterTask.1) {
                addAction$AddPlayOpenPlaylist$afterTask$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlaylist.afterTask.1)continuation0;
                int v = addAction$AddPlayOpenPlaylist$afterTask$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlayOpenPlaylist$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.afterTask(null, null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlayOpenPlaylist$afterTask$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlayOpenPlaylist$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.afterTask(null, null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlayOpenPlaylist$afterTask$10.result;
            a a0 = a.a;
            switch(addAction$AddPlayOpenPlaylist$afterTask$10.label) {
                case 0: {
                    n.D(object0);
                    B b0 = ((d3)s20).a(playlistId0);
                    addAction$AddPlayOpenPlaylist$afterTask$10.L$0 = null;
                    addAction$AddPlayOpenPlaylist$afterTask$10.L$1 = z0;
                    addAction$AddPlayOpenPlaylist$afterTask$10.L$2 = null;
                    addAction$AddPlayOpenPlaylist$afterTask$10.L$3 = null;
                    addAction$AddPlayOpenPlaylist$afterTask$10.L$4 = null;
                    addAction$AddPlayOpenPlaylist$afterTask$10.label = 1;
                    if(ListenableFutureKt.await(b0, addAction$AddPlayOpenPlaylist$afterTask$10) == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    b0 b01 = (b0)addAction$AddPlayOpenPlaylist$afterTask$10.L$4;
                    AddRequestPlayableListInfo addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addAction$AddPlayOpenPlaylist$afterTask$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlayOpenPlaylist$afterTask$10.L$2;
                    z0 = (z)addAction$AddPlayOpenPlaylist$afterTask$10.L$1;
                    s2 s21 = (s2)addAction$AddPlayOpenPlaylist$afterTask$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            z0.u();
            Navigator.INSTANCE.openNowPlayList();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            z0.s();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlaylist.checkCanAdded.1 addAction$AddPlayOpenPlaylist$checkCanAdded$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlaylist.checkCanAdded.1) {
                addAction$AddPlayOpenPlaylist$checkCanAdded$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlaylist.checkCanAdded.1)continuation0;
                int v = addAction$AddPlayOpenPlaylist$checkCanAdded$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.checkCanAdded(null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlayOpenPlaylist$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkCanAdded(null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlayOpenPlaylist$checkCanAdded$10.result;
            a a0 = a.a;
            switch(addAction$AddPlayOpenPlaylist$checkCanAdded$10.label) {
                case 0: {
                    n.D(object0);
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$0 = null;
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$1 = null;
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$2 = null;
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$3 = null;
                    addAction$AddPlayOpenPlaylist$checkCanAdded$10.label = 1;
                    object0 = z0.o(addAction$AddPlayOpenPlaylist$checkCanAdded$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    s s1 = (s)addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$2;
                    z z1 = (z)addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$1;
                    s2 s21 = (s2)addAction$AddPlayOpenPlaylist$checkCanAdded$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return ((Boolean)object0).booleanValue() ? SectionRepeatInterrupt.INSTANCE : null;
        }

        public final boolean component1() {
            return this.isShufflePlay;
        }

        @NotNull
        public final AddPlayOpenPlaylist copy(boolean z) {
            return new AddPlayOpenPlaylist(z);
        }

        public static AddPlayOpenPlaylist copy$default(AddPlayOpenPlaylist addAction$AddPlayOpenPlaylist0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = addAction$AddPlayOpenPlaylist0.isShufflePlay;
            }
            return addAction$AddPlayOpenPlaylist0.copy(z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AddPlayOpenPlaylist ? this.isShufflePlay == ((AddPlayOpenPlaylist)object0).isShufflePlay : false;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isShufflePlay);
        }

        @Override  // com.iloen.melon.playback.playlist.add.ShufflePlay
        public boolean isShufflePlay() {
            return this.isShufflePlay;
        }

        @Override
        @NotNull
        public String toString() {
            return "AddPlayOpenPlaylist(isShufflePlay=" + this.isShufflePlay + ")";
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0015\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0019\u001A\u00020\u00142\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u0017H\u0096@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001B\u0010\u001CJ\u001A\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001A\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001A\u0010\'\u001A\u00020\u00032\b\u0010&\u001A\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b\'\u0010(R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010)\u001A\u0004\b\u0004\u0010\u001CR\u001A\u0010*\u001A\u00020\u001F8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001A\u0004\b,\u0010!¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlaySetAvailable;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "Lcom/iloen/melon/playback/playlist/add/ShufflePlay;", "", "isShufflePlay", "<init>", "(Z)V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Z", "copy", "(Z)Lcom/iloen/melon/playback/playlist/add/AddAction$AddPlaySetAvailable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "tag", "Ljava/lang/String;", "getTag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AddPlaySetAvailable extends AddAction implements ShufflePlay {
        public static final int $stable;
        private final boolean isShufflePlay;
        @NotNull
        private final String tag;

        public AddPlaySetAvailable(boolean z) {
            super(null);
            this.isShufflePlay = z;
            this.tag = "AddAndPlayWithSetAvailable";
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable.afterTask.1 addAction$AddPlaySetAvailable$afterTask$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable.afterTask.1) {
                addAction$AddPlaySetAvailable$afterTask$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable.afterTask.1)continuation0;
                int v = addAction$AddPlaySetAvailable$afterTask$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlaySetAvailable$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.afterTask(null, null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlaySetAvailable$afterTask$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlaySetAvailable$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.afterTask(null, null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlaySetAvailable$afterTask$10.result;
            a a0 = a.a;
            switch(addAction$AddPlaySetAvailable$afterTask$10.label) {
                case 0: {
                    n.D(object0);
                    B b0 = ((d3)s20).a(playlistId0);
                    addAction$AddPlaySetAvailable$afterTask$10.L$0 = null;
                    addAction$AddPlaySetAvailable$afterTask$10.L$1 = z0;
                    addAction$AddPlaySetAvailable$afterTask$10.L$2 = null;
                    addAction$AddPlaySetAvailable$afterTask$10.L$3 = null;
                    addAction$AddPlaySetAvailable$afterTask$10.L$4 = null;
                    addAction$AddPlaySetAvailable$afterTask$10.label = 1;
                    if(ListenableFutureKt.await(b0, addAction$AddPlaySetAvailable$afterTask$10) == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    b0 b01 = (b0)addAction$AddPlaySetAvailable$afterTask$10.L$4;
                    AddRequestPlayableListInfo addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addAction$AddPlaySetAvailable$afterTask$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlaySetAvailable$afterTask$10.L$2;
                    z0 = (z)addAction$AddPlaySetAvailable$afterTask$10.L$1;
                    s2 s21 = (s2)addAction$AddPlaySetAvailable$afterTask$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            z0.u();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            z0.s();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable.checkCanAdded.1 addAction$AddPlaySetAvailable$checkCanAdded$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable.checkCanAdded.1) {
                addAction$AddPlaySetAvailable$checkCanAdded$10 = (com.iloen.melon.playback.playlist.add.AddAction.AddPlaySetAvailable.checkCanAdded.1)continuation0;
                int v = addAction$AddPlaySetAvailable$checkCanAdded$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$AddPlaySetAvailable$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.checkCanAdded(null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$AddPlaySetAvailable$checkCanAdded$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$AddPlaySetAvailable$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkCanAdded(null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$AddPlaySetAvailable$checkCanAdded$10.result;
            a a0 = a.a;
            switch(addAction$AddPlaySetAvailable$checkCanAdded$10.label) {
                case 0: {
                    n.D(object0);
                    addAction$AddPlaySetAvailable$checkCanAdded$10.L$0 = null;
                    addAction$AddPlaySetAvailable$checkCanAdded$10.L$1 = null;
                    addAction$AddPlaySetAvailable$checkCanAdded$10.L$2 = null;
                    addAction$AddPlaySetAvailable$checkCanAdded$10.L$3 = null;
                    addAction$AddPlaySetAvailable$checkCanAdded$10.label = 1;
                    object0 = z0.o(addAction$AddPlaySetAvailable$checkCanAdded$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    s s1 = (s)addAction$AddPlaySetAvailable$checkCanAdded$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$AddPlaySetAvailable$checkCanAdded$10.L$2;
                    z z1 = (z)addAction$AddPlaySetAvailable$checkCanAdded$10.L$1;
                    s2 s21 = (s2)addAction$AddPlaySetAvailable$checkCanAdded$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return ((Boolean)object0).booleanValue() ? SectionRepeatInterrupt.INSTANCE : null;
        }

        public final boolean component1() {
            return this.isShufflePlay;
        }

        @NotNull
        public final AddPlaySetAvailable copy(boolean z) {
            return new AddPlaySetAvailable(z);
        }

        public static AddPlaySetAvailable copy$default(AddPlaySetAvailable addAction$AddPlaySetAvailable0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = addAction$AddPlaySetAvailable0.isShufflePlay;
            }
            return addAction$AddPlaySetAvailable0.copy(z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AddPlaySetAvailable ? this.isShufflePlay == ((AddPlaySetAvailable)object0).isShufflePlay : false;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isShufflePlay);
        }

        @Override  // com.iloen.melon.playback.playlist.add.ShufflePlay
        public boolean isShufflePlay() {
            return this.isShufflePlay;
        }

        @Override
        @NotNull
        public String toString() {
            return "AddPlaySetAvailable(isShufflePlay=" + this.isShufflePlay + ")";
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0011\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0016\u001A\u00020\u00152\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\u0013H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u001A\u001A\u00020\u00152\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u0018H\u0096@¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001E\u0010\u001FJ$\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\"\u0010\u001FJ\u0010\u0010$\u001A\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001A\u0010)\u001A\u00020(2\b\u0010\'\u001A\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001A\u0004\b,\u0010\u001DR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001A\u0004\b.\u0010\u001F¨\u0006/"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$MusicWaveOpen;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "musicWaveChannelInfo", "", "menuId", "<init>", "(Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;Ljava/lang/String;)V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "component2", "()Ljava/lang/String;", "copy", "(Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;Ljava/lang/String;)Lcom/iloen/melon/playback/playlist/add/AddAction$MusicWaveOpen;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "getMusicWaveChannelInfo", "Ljava/lang/String;", "getMenuId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MusicWaveOpen extends AddAction {
        public static final int $stable;
        @NotNull
        private final String menuId;
        @NotNull
        private final MusicWaveChannelInfo musicWaveChannelInfo;

        public MusicWaveOpen(@NotNull MusicWaveChannelInfo musicWaveChannelInfo0, @NotNull String s) {
            q.g(musicWaveChannelInfo0, "musicWaveChannelInfo");
            q.g(s, "menuId");
            super(null);
            this.musicWaveChannelInfo = musicWaveChannelInfo0;
            this.menuId = s;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            return new com.iloen.melon.playback.playlist.add.AddFailType.MusicWaveOpen(this.musicWaveChannelInfo, this.menuId);
        }

        @NotNull
        public final MusicWaveChannelInfo component1() {
            return this.musicWaveChannelInfo;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @NotNull
        public final MusicWaveOpen copy(@NotNull MusicWaveChannelInfo musicWaveChannelInfo0, @NotNull String s) {
            q.g(musicWaveChannelInfo0, "musicWaveChannelInfo");
            q.g(s, "menuId");
            return new MusicWaveOpen(musicWaveChannelInfo0, s);
        }

        public static MusicWaveOpen copy$default(MusicWaveOpen addAction$MusicWaveOpen0, MusicWaveChannelInfo musicWaveChannelInfo0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                musicWaveChannelInfo0 = addAction$MusicWaveOpen0.musicWaveChannelInfo;
            }
            if((v & 2) != 0) {
                s = addAction$MusicWaveOpen0.menuId;
            }
            return addAction$MusicWaveOpen0.copy(musicWaveChannelInfo0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MusicWaveOpen)) {
                return false;
            }
            return q.b(this.musicWaveChannelInfo, ((MusicWaveOpen)object0).musicWaveChannelInfo) ? q.b(this.menuId, ((MusicWaveOpen)object0).menuId) : false;
        }

        @NotNull
        public final String getMenuId() {
            return this.menuId;
        }

        @NotNull
        public final MusicWaveChannelInfo getMusicWaveChannelInfo() {
            return this.musicWaveChannelInfo;
        }

        @Override
        public int hashCode() {
            return this.menuId.hashCode() + this.musicWaveChannelInfo.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "MusicWaveOpen(musicWaveChannelInfo=" + this.musicWaveChannelInfo + ", menuId=" + this.menuId + ")";
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0096@¢\u0006\u0004\b\u000F\u0010\u0010J0\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J8\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0016H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001EHÖ\u0001¢\u0006\u0004\b\u001F\u0010 J\u0010\u0010\"\u001A\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001A\u0010&\u001A\u00020\u00022\b\u0010%\u001A\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010\'R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001A\u0004\b)\u0010\u001BR\u001A\u0010*\u001A\u00020\u001E8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010+\u001A\u0004\b,\u0010 ¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddAction$VideoPlayAndOpen;", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "", "fullScreen", "<init>", "(Z)V", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "LUb/s;", "remotePlayerManager", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkCanAdded", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;LUb/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addRequestInfo", "Lie/H;", "beforeAddTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Loc/b0;", "requestAddResult", "afterTask", "(Lkc/s2;Lob/z;Lcom/iloen/melon/playback/playlist/PlaylistId;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Loc/b0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Z", "copy", "(Z)Lcom/iloen/melon/playback/playlist/add/AddAction$VideoPlayAndOpen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getFullScreen", "tag", "Ljava/lang/String;", "getTag", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class VideoPlayAndOpen extends AddAction {
        public static final int $stable;
        private final boolean fullScreen;
        @NotNull
        private final String tag;

        public VideoPlayAndOpen(boolean z) {
            super(null);
            this.fullScreen = z;
            this.tag = "VideoOpen";
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object afterTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull b0 b00, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen.afterTask.1 addAction$VideoPlayAndOpen$afterTask$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen.afterTask.1) {
                addAction$VideoPlayAndOpen$afterTask$10 = (com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen.afterTask.1)continuation0;
                int v = addAction$VideoPlayAndOpen$afterTask$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$VideoPlayAndOpen$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.afterTask(null, null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$VideoPlayAndOpen$afterTask$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$VideoPlayAndOpen$afterTask$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.afterTask(null, null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$VideoPlayAndOpen$afterTask$10.result;
            a a0 = a.a;
            switch(addAction$VideoPlayAndOpen$afterTask$10.label) {
                case 0: {
                    n.D(object0);
                    B b0 = ((d3)s20).a(playlistId0);
                    addAction$VideoPlayAndOpen$afterTask$10.L$0 = null;
                    addAction$VideoPlayAndOpen$afterTask$10.L$1 = z0;
                    addAction$VideoPlayAndOpen$afterTask$10.L$2 = null;
                    addAction$VideoPlayAndOpen$afterTask$10.L$3 = null;
                    addAction$VideoPlayAndOpen$afterTask$10.L$4 = null;
                    addAction$VideoPlayAndOpen$afterTask$10.label = 1;
                    if(ListenableFutureKt.await(b0, addAction$VideoPlayAndOpen$afterTask$10) == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    b0 b01 = (b0)addAction$VideoPlayAndOpen$afterTask$10.L$4;
                    AddRequestPlayableListInfo addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addAction$VideoPlayAndOpen$afterTask$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$VideoPlayAndOpen$afterTask$10.L$2;
                    z0 = (z)addAction$VideoPlayAndOpen$afterTask$10.L$1;
                    s2 s21 = (s2)addAction$VideoPlayAndOpen$afterTask$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            z0.u();
            Navigator.INSTANCE.openVideoPlayer(this.fullScreen);
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object beforeAddTask(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull Continuation continuation0) {
            z0.s();
            return H.a;
        }

        @Override  // com.iloen.melon.playback.playlist.add.AddAction
        @Nullable
        public Object checkCanAdded(@NotNull s2 s20, @NotNull z z0, @NotNull PlaylistId playlistId0, @NotNull s s0, @NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen.checkCanAdded.1 addAction$VideoPlayAndOpen$checkCanAdded$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen.checkCanAdded.1) {
                addAction$VideoPlayAndOpen$checkCanAdded$10 = (com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen.checkCanAdded.1)continuation0;
                int v = addAction$VideoPlayAndOpen$checkCanAdded$10.label;
                if((v & 0x80000000) == 0) {
                    addAction$VideoPlayAndOpen$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.checkCanAdded(null, null, null, null, this);
                        }
                    };
                }
                else {
                    addAction$VideoPlayAndOpen$checkCanAdded$10.label = v ^ 0x80000000;
                }
            }
            else {
                addAction$VideoPlayAndOpen$checkCanAdded$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkCanAdded(null, null, null, null, this);
                    }
                };
            }
            Object object0 = addAction$VideoPlayAndOpen$checkCanAdded$10.result;
            a a0 = a.a;
            switch(addAction$VideoPlayAndOpen$checkCanAdded$10.label) {
                case 0: {
                    n.D(object0);
                    addAction$VideoPlayAndOpen$checkCanAdded$10.L$0 = null;
                    addAction$VideoPlayAndOpen$checkCanAdded$10.L$1 = null;
                    addAction$VideoPlayAndOpen$checkCanAdded$10.L$2 = null;
                    addAction$VideoPlayAndOpen$checkCanAdded$10.L$3 = null;
                    addAction$VideoPlayAndOpen$checkCanAdded$10.label = 1;
                    object0 = z0.o(addAction$VideoPlayAndOpen$checkCanAdded$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    s s1 = (s)addAction$VideoPlayAndOpen$checkCanAdded$10.L$3;
                    PlaylistId playlistId1 = (PlaylistId)addAction$VideoPlayAndOpen$checkCanAdded$10.L$2;
                    z z1 = (z)addAction$VideoPlayAndOpen$checkCanAdded$10.L$1;
                    s2 s21 = (s2)addAction$VideoPlayAndOpen$checkCanAdded$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            return ((Boolean)object0).booleanValue() ? SectionRepeatInterrupt.INSTANCE : null;
        }

        public final boolean component1() {
            return this.fullScreen;
        }

        @NotNull
        public final VideoPlayAndOpen copy(boolean z) {
            return new VideoPlayAndOpen(z);
        }

        public static VideoPlayAndOpen copy$default(VideoPlayAndOpen addAction$VideoPlayAndOpen0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = addAction$VideoPlayAndOpen0.fullScreen;
            }
            return addAction$VideoPlayAndOpen0.copy(z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof VideoPlayAndOpen ? this.fullScreen == ((VideoPlayAndOpen)object0).fullScreen : false;
        }

        public final boolean getFullScreen() {
            return this.fullScreen;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.fullScreen);
        }

        @Override
        @NotNull
        public String toString() {
            return "VideoPlayAndOpen(fullScreen=" + this.fullScreen + ")";
        }
    }

    public static final int $stable;

    private AddAction() {
    }

    public AddAction(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @Nullable
    public abstract Object afterTask(@NotNull s2 arg1, @NotNull z arg2, @NotNull PlaylistId arg3, @NotNull AddRequestPlayableListInfo arg4, @NotNull b0 arg5, @NotNull Continuation arg6);

    @Nullable
    public abstract Object beforeAddTask(@NotNull s2 arg1, @NotNull z arg2, @NotNull PlaylistId arg3, @NotNull AddRequestPlayableListInfo arg4, @NotNull Continuation arg5);

    @Nullable
    public abstract Object checkCanAdded(@NotNull s2 arg1, @NotNull z arg2, @NotNull PlaylistId arg3, @NotNull s arg4, @NotNull Continuation arg5);
}

