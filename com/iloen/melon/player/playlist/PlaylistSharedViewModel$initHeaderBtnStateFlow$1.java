package com.iloen.melon.player.playlist;

import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/iloen/melon/player/playlist/PlaylistMainHeaderBtnState;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.PlaylistSharedViewModel$initHeaderBtnStateFlow$1", f = "PlaylistSharedViewModel.kt", l = {0x10D}, m = "invokeSuspend")
final class PlaylistSharedViewModel.initHeaderBtnStateFlow.1 extends i implements n {
    public final PlaylistSharedViewModel B;
    public int r;
    public Object w;

    public PlaylistSharedViewModel.initHeaderBtnStateFlow.1(PlaylistSharedViewModel playlistSharedViewModel0, Continuation continuation0) {
        this.B = playlistSharedViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new PlaylistSharedViewModel.initHeaderBtnStateFlow.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((PlaylistSharedViewModel.initHeaderBtnStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1 playlistSharedViewModel$initHeaderBtnStateFlow$1$10 = new n(producerScope0, null) {
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                    public static final class WhenMappings {
                        public static final int[] $EnumSwitchMapping$0;

                        static {
                            int[] arr_v = new int[PlaylistTab.values().length];
                            try {
                                arr_v[PlaylistTab.MUSIC.ordinal()] = 1;
                            }
                            catch(NoSuchFieldError unused_ex) {
                            }
                            try {
                                arr_v[PlaylistTab.DRAWER.ordinal()] = 2;
                            }
                            catch(NoSuchFieldError unused_ex) {
                            }
                            try {
                                arr_v[PlaylistTab.MIX_UP.ordinal()] = 3;
                            }
                            catch(NoSuchFieldError unused_ex) {
                            }
                            WhenMappings.$EnumSwitchMapping$0 = arr_v;
                        }
                    }

                    public final PlaylistSharedViewModel B;
                    public final ProducerScope D;
                    public int r;
                    public Object w;

                    {
                        this.B = playlistSharedViewModel0;
                        this.D = producerScope0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1(this.B, this.D, continuation0);
                        continuation1.w = object0;
                        return continuation1;
                    }

                    public final Object invoke(PlaylistTab playlistTab0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1)this.create(playlistTab0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((PlaylistTab)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        PlaylistTab playlistTab0 = (PlaylistTab)this.w;
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                ProducerScope producerScope0 = this.D;
                                PlaylistSharedViewModel playlistSharedViewModel0 = this.B;
                                switch(WhenMappings.$EnumSwitchMapping$0[playlistTab0.ordinal()]) {
                                    case 1: {
                                        com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.1 playlistSharedViewModel$initHeaderBtnStateFlow$1$1$10 = new n(null) {
                                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                                            public static final class com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.1.WhenMappings {
                                                public static final int[] $EnumSwitchMapping$0;

                                                static {
                                                    int[] arr_v = new int[MusicPlaylistTabContent.values().length];
                                                    try {
                                                        arr_v[MusicPlaylistTabContent.SONG_LIST_MUSIC.ordinal()] = 1;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    try {
                                                        arr_v[MusicPlaylistTabContent.SONG_LIST_SMART.ordinal()] = 2;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    try {
                                                        arr_v[MusicPlaylistTabContent.SEARCH_MUSIC.ordinal()] = 3;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    try {
                                                        arr_v[MusicPlaylistTabContent.SEARCH_SMART.ordinal()] = 4;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.1.WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                                }
                                            }

                                            public Object r;
                                            public final ProducerScope w;

                                            {
                                                this.w = producerScope0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.1(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(MusicPlaylistTabContent musicPlaylistTabContent0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.1)this.create(musicPlaylistTabContent0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((MusicPlaylistTabContent)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                MusicPlaylistTabContent musicPlaylistTabContent0 = (MusicPlaylistTabContent)this.r;
                                                d5.n.D(object0);
                                                ProducerScope producerScope0 = this.w;
                                                switch(com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.1.WhenMappings.$EnumSwitchMapping$0[musicPlaylistTabContent0.ordinal()]) {
                                                    case 1: 
                                                    case 2: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.SEARCH);
                                                        return H.a;
                                                    }
                                                    case 3: 
                                                    case 4: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.NONE);
                                                        return H.a;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                            }
                                        };
                                        this.w = null;
                                        this.r = 1;
                                        if(FlowKt.collectLatest(playlistSharedViewModel0.getMusicTabContent(), playlistSharedViewModel$initHeaderBtnStateFlow$1$1$10, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.2 playlistSharedViewModel$initHeaderBtnStateFlow$1$1$20 = new n(null) {
                                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                                            public static final class com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.2.WhenMappings {
                                                public static final int[] $EnumSwitchMapping$0;

                                                static {
                                                    int[] arr_v = new int[DrawerPlaylistTabContent.values().length];
                                                    try {
                                                        arr_v[DrawerPlaylistTabContent.PLAYLIST_LIST.ordinal()] = 1;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    try {
                                                        arr_v[DrawerPlaylistTabContent.SONG_LIST.ordinal()] = 2;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    try {
                                                        arr_v[DrawerPlaylistTabContent.SEARCH.ordinal()] = 3;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.2.WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                                }
                                            }

                                            public Object r;
                                            public final ProducerScope w;

                                            {
                                                this.w = producerScope0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.2(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(DrawerPlaylistTabContent drawerPlaylistTabContent0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.2)this.create(drawerPlaylistTabContent0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((DrawerPlaylistTabContent)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                DrawerPlaylistTabContent drawerPlaylistTabContent0 = (DrawerPlaylistTabContent)this.r;
                                                d5.n.D(object0);
                                                ProducerScope producerScope0 = this.w;
                                                switch(com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.2.WhenMappings.$EnumSwitchMapping$0[drawerPlaylistTabContent0.ordinal()]) {
                                                    case 1: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.PLAYLIST_ADD);
                                                        return H.a;
                                                    }
                                                    case 2: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.SEARCH);
                                                        return H.a;
                                                    }
                                                    case 3: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.NONE);
                                                        return H.a;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                            }
                                        };
                                        this.w = null;
                                        this.r = 2;
                                        if(FlowKt.collectLatest(playlistSharedViewModel0.getDrawerTabContent(), playlistSharedViewModel$initHeaderBtnStateFlow$1$1$20, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.3 playlistSharedViewModel$initHeaderBtnStateFlow$1$1$30 = new n(null) {
                                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                                            public static final class com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.3.WhenMappings {
                                                public static final int[] $EnumSwitchMapping$0;

                                                static {
                                                    int[] arr_v = new int[MixUpPlaylistTabContent.values().length];
                                                    try {
                                                        arr_v[MixUpPlaylistTabContent.SONG_LIST.ordinal()] = 1;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    try {
                                                        arr_v[MixUpPlaylistTabContent.SEARCH.ordinal()] = 2;
                                                    }
                                                    catch(NoSuchFieldError unused_ex) {
                                                    }
                                                    com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.3.WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                                }
                                            }

                                            public Object r;
                                            public final ProducerScope w;

                                            {
                                                this.w = producerScope0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.3(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(MixUpPlaylistTabContent mixUpPlaylistTabContent0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.3)this.create(mixUpPlaylistTabContent0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((MixUpPlaylistTabContent)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                MixUpPlaylistTabContent mixUpPlaylistTabContent0 = (MixUpPlaylistTabContent)this.r;
                                                d5.n.D(object0);
                                                ProducerScope producerScope0 = this.w;
                                                switch(com.iloen.melon.player.playlist.PlaylistSharedViewModel.initHeaderBtnStateFlow.1.1.3.WhenMappings.$EnumSwitchMapping$0[mixUpPlaylistTabContent0.ordinal()]) {
                                                    case 1: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.SEARCH);
                                                        return H.a;
                                                    }
                                                    case 2: {
                                                        producerScope0.trySend-JP2dKIU(PlaylistMainHeaderBtnState.NONE);
                                                        return H.a;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                            }
                                        };
                                        this.w = null;
                                        this.r = 3;
                                        if(FlowKt.collectLatest(playlistSharedViewModel0.getMixUpTabContent(), playlistSharedViewModel$initHeaderBtnStateFlow$1$1$30, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    default: {
                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                    }
                                }
                                return H.a;
                            }
                            case 1: 
                            case 2: 
                            case 3: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                this.w = null;
                this.r = 1;
                return FlowKt.collectLatest(this.B.getFocusingTabFlow(), playlistSharedViewModel$initHeaderBtnStateFlow$1$10, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

