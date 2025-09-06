package com.iloen.melon.fragments.local;

import E9.w;
import G8.g;
import android.os.Bundle;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import z6.f;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003R\u001A\u0010\n\u001A\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAlbumSongFragment;", "Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment;", "<init>", "()V", "", "getLocalTrackType", "()I", "Lie/H;", "startQuery", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentAlbumSongFragment extends LocalContentBaseUIFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAlbumSongFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentAlbumSongFragment;", "info", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo;", "playbackMenuId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentAlbumSongFragment newInstance(@NotNull ParamInfo localContentNewDbBaseFragment$ParamInfo0, @Nullable String s) {
            q.g(localContentNewDbBaseFragment$ParamInfo0, "info");
            LocalContentAlbumSongFragment localContentAlbumSongFragment0 = new LocalContentAlbumSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argFragmentTitle", "");
            bundle0.putString("album", "");
            bundle0.putString("album_key", "");
            bundle0.putLong("albumid1", localContentNewDbBaseFragment$ParamInfo0.getAlbumId1());
            bundle0.putBoolean("argIsFlac", localContentNewDbBaseFragment$ParamInfo0.isFlac());
            bundle0.putString("argPlaybackMenuId", s);
            localContentAlbumSongFragment0.setArguments(bundle0);
            return localContentAlbumSongFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String TAG;

    static {
        LocalContentAlbumSongFragment.Companion = new Companion(null);
        LocalContentAlbumSongFragment.$stable = 8;
    }

    public LocalContentAlbumSongFragment() {
        this.TAG = "LocalContentAlbumSongFragment";
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public int getLocalTrackType() {
        return 2;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    @NotNull
    public String getTAG() {
        return this.TAG;
    }

    @NotNull
    public static final LocalContentAlbumSongFragment newInstance(@NotNull ParamInfo localContentNewDbBaseFragment$ParamInfo0, @Nullable String s) {
        return LocalContentAlbumSongFragment.Companion.newInstance(localContentNewDbBaseFragment$ParamInfo0, s);
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void startQuery() {
        f0.f(this).a(new n(null) {
            int label;

            {
                LocalContentAlbumSongFragment.this = localContentAlbumSongFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumSongFragment.startQuery.1(LocalContentAlbumSongFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumSongFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalContentAlbumSongFragment.startQuery.1.playableList.1 localContentAlbumSongFragment$startQuery$1$playableList$10 = new n(null) {
                            int label;

                            {
                                LocalContentAlbumSongFragment.this = localContentAlbumSongFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentAlbumSongFragment.startQuery.1.playableList.1(LocalContentAlbumSongFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentAlbumSongFragment.startQuery.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                f f0 = g.a;
                                if(LocalContentAlbumSongFragment.this.mIsFlac) {
                                    f0.m();
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(LocalContentAlbumSongFragment.this.getAlbumKey(), 13));
                                }
                                else {
                                    f0.m();
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(LocalContentAlbumSongFragment.this.getAlbumKey(), 16));
                                }
                                f0.m();
                                String s = LocalContentAlbumSongFragment.this.mPlaybackMenuId;
                                q.f(s, "access$getMPlaybackMenuId$p$s-395507322(...)");
                                return g.i(s, list0);
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(LocalContentAlbumSongFragment.this.getIoDispatcher(), localContentAlbumSongFragment$startQuery$1$playableList$10, this);
                        if(object0 == a0) {
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
                j0 j00 = LocalContentAlbumSongFragment.this.mAdapter;
                if(j00 != null) {
                    LocalContentAlbumSongFragment localContentAlbumSongFragment0 = LocalContentAlbumSongFragment.this;
                    if(j00 instanceof LocalSongAdapter) {
                        localContentAlbumSongFragment0.dismissProgressDialog();
                        ((LocalSongAdapter)j00).clear();
                        ((LocalSongAdapter)j00).addAll(((List)object0));
                        localContentAlbumSongFragment0.performFetchCompleteOnlyViews();
                        int v = 0;
                        if(localContentAlbumSongFragment0.getEditMode()) {
                            boolean z = localContentAlbumSongFragment0.getEditMode();
                            if(((List)object0) == null || ((List)object0).isEmpty()) {
                                v = 1;
                            }
                            localContentAlbumSongFragment0.setEditModeVisibility(z, ((boolean)(v ^ 1)));
                            return H.a;
                        }
                        if(((List)object0) == null || ((List)object0).isEmpty()) {
                            v = 1;
                        }
                        localContentAlbumSongFragment0.setAllCheckButtonVisibility(((boolean)(v ^ 1)));
                    }
                }
                return H.a;
            }
        });
    }
}

