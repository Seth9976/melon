package com.iloen.melon.slook;

import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import com.melon.playlist.interfaces.PlayableData;
import ie.H;
import java.util.ArrayList;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oc.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\n\u0010\u000BJ%\u0010\u0010\u001A\u00020\u000F2\u0016\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\r¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/slook/CocktailPlayerKt;", "", "<init>", "()V", "Lkc/s2;", "playlistManager", "Lcom/melon/playlist/interfaces/PlayableData;", "getCurrentPlayableDataOfRecentAudioPlaylist", "(Lkc/s2;)Lcom/melon/playlist/interfaces/PlayableData;", "Lcom/iloen/melon/playback/Playable;", "getCurrentPlayableOfRecentAudioPlaylist", "(Lkc/s2;)Lcom/iloen/melon/playback/Playable;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "songs", "Lie/H;", "playSongs", "(Ljava/util/ArrayList;)V", "Lcom/iloen/melon/custom/L0;", "progressUpdatable", "", "playlistId", "menuId", "playPlaylist", "(Lcom/iloen/melon/custom/L0;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CocktailPlayerKt {
    public static final int $stable;

    @Nullable
    public final PlayableData getCurrentPlayableDataOfRecentAudioPlaylist(@NotNull s2 s20) {
        q.g(s20, "playlistManager");
        ((b)((d3)s20).a).Y("getRecentAudioPlaylistIdOrNull");
        PlaylistId playlistId0 = (PlaylistId)((b)((d3)s20).a).q.getValue();
        if(playlistId0 == null) {
            LogU.Companion.d("Cocktail", "getCurrentPlayableDataOfRecentAudioPlaylist - recentAudioPlaylistId is null");
            return null;
        }
        w w0 = ((d3)s20).q(playlistId0);
        if(w0 == null) {
            LogU.Companion.d("Cocktail", "getCurrentPlayableDataOfRecentAudioPlaylist - recentAudioPlaylist is null");
            return null;
        }
        return e1.b.z(w0.getState());
    }

    @Nullable
    public final Playable getCurrentPlayableOfRecentAudioPlaylist(@NotNull s2 s20) {
        q.g(s20, "playlistManager");
        PlayableData playableData0 = this.getCurrentPlayableDataOfRecentAudioPlaylist(s20);
        return playableData0 == null ? null : playableData0.a;
    }

    public final void playPlaylist(@NotNull L0 l00, @NotNull String s, @NotNull String s1) {
        q.g(l00, "progressUpdatable");
        q.g(s, "playlistId");
        q.g(s1, "menuId");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(s1, l00, null) {
            public final String B;
            public final String D;
            public final L0 E;
            public AddPlay r;
            public int w;

            {
                this.B = s;
                this.D = s1;
                this.E = l00;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.slook.CocktailPlayerKt.playPlaylist.1(this.B, this.D, this.E, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.slook.CocktailPlayerKt.playPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                AddPlay addAction$AddPlay1;
                a a0 = a.a;
                switch(this.w) {
                    case 0: {
                        d5.n.D(object0);
                        AddPlay addAction$AddPlay0 = new AddPlay(false);
                        Playlist playDataForSeverContent$Playlist0 = new Playlist(this.B, this.D, null);
                        AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlay0, false, false, this.E, playDataForSeverContent$Playlist0, 6, null);
                        this.r = addAction$AddPlay0;
                        this.w = 1;
                        object0 = addServerContent0.execute(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        addAction$AddPlay1 = addAction$AddPlay0;
                        break;
                    }
                    case 1: {
                        addAction$AddPlay1 = this.r;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ((AddResult)object0).handleToast(addAction$AddPlay1);
                return H.a;
            }
        }, 3, null);
    }

    public final void playSongs(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "songs");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(null) {
            public final ArrayList B;
            public AddPlay r;
            public int w;

            {
                this.B = arrayList0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.slook.CocktailPlayerKt.playSongs.1(this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.slook.CocktailPlayerKt.playSongs.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                AddPlay addAction$AddPlay1;
                a a0 = a.a;
                switch(this.w) {
                    case 0: {
                        d5.n.D(object0);
                        AddPlay addAction$AddPlay0 = new AddPlay(false);
                        AddPlayableList addPlayableList0 = new AddPlayableList(null, addAction$AddPlay0, false, true, false, null, this.B, 0x20, null);
                        this.r = addAction$AddPlay0;
                        this.w = 1;
                        object0 = addPlayableList0.execute(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        addAction$AddPlay1 = addAction$AddPlay0;
                        break;
                    }
                    case 1: {
                        addAction$AddPlay1 = this.r;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ((AddResult)object0).handleToast(addAction$AddPlay1);
                return H.a;
            }
        }, 3, null);
    }
}

