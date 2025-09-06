package com.iloen.melon.fragments.local;

import E9.w;
import G8.g;
import android.os.Bundle;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import ie.H;
import java.util.List;
import k8.Y;
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

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001A\u0010\n\u001A\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentArtistSongFragment;", "Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment;", "<init>", "()V", "Lie/H;", "startQuery", "", "getLocalTrackType", "()I", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentArtistSongFragment extends LocalContentBaseUIFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentArtistSongFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentArtistSongFragment;", "info", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo;", "playbackMenuId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentArtistSongFragment newInstance(@NotNull ParamInfo localContentNewDbBaseFragment$ParamInfo0, @Nullable String s) {
            q.g(localContentNewDbBaseFragment$ParamInfo0, "info");
            MelonAppBase.Companion.getClass();
            q.f("알 수 없는 아티스트", "getString(...)");
            LocalContentArtistSongFragment localContentArtistSongFragment0 = new LocalContentArtistSongFragment();
            Bundle bundle0 = Y.c("argFragmentTitle", "알 수 없는 아티스트", "artist", "알 수 없는 아티스트");
            bundle0.putString("artistid1", "");
            bundle0.putString("artistid2", "");
            bundle0.putBoolean("argIsFlac", localContentNewDbBaseFragment$ParamInfo0.isFlac());
            bundle0.putString("argPlaybackMenuId", s);
            localContentArtistSongFragment0.setArguments(bundle0);
            return localContentArtistSongFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String TAG;

    static {
        LocalContentArtistSongFragment.Companion = new Companion(null);
        LocalContentArtistSongFragment.$stable = 8;
    }

    public LocalContentArtistSongFragment() {
        this.TAG = "LocalContentArtistSongFragment";
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public int getLocalTrackType() {
        return 1;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    @NotNull
    public String getTAG() {
        return this.TAG;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void startQuery() {
        f0.f(this).a(new n(null) {
            int I$0;
            Object L$0;
            Object L$1;
            int label;

            {
                LocalContentArtistSongFragment.this = localContentArtistSongFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1(LocalContentArtistSongFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1.playableList.1 localContentArtistSongFragment$startQuery$1$playableList$10 = new n(null) {
                            int label;

                            {
                                LocalContentArtistSongFragment.this = localContentArtistSongFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1.playableList.1(LocalContentArtistSongFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                f f0 = g.a;
                                if(LocalContentArtistSongFragment.this.mIsFlac) {
                                    f0.m();
                                    String s = LocalContentArtistSongFragment.this.getArtistId2();
                                    if(s == null) {
                                        return null;
                                    }
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 11));
                                }
                                else {
                                    f0.m();
                                    String s1 = LocalContentArtistSongFragment.this.getArtistId2();
                                    if(s1 == null) {
                                        return null;
                                    }
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s1, 14));
                                }
                                f0.m();
                                String s2 = LocalContentArtistSongFragment.this.mPlaybackMenuId;
                                q.f(s2, "access$getMPlaybackMenuId$p$s-544102726(...)");
                                return g.i(s2, list0);
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(LocalContentArtistSongFragment.this.getIoDispatcher(), localContentArtistSongFragment$startQuery$1$playableList$10, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        j0 j00 = (j0)this.L$1;
                        List list0 = (List)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                j0 j01 = LocalContentArtistSongFragment.this.mAdapter;
                if(j01 != null) {
                    com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1.1.1 localContentArtistSongFragment$startQuery$1$1$10 = new n(LocalContentArtistSongFragment.this, ((List)object0), null) {
                        final j0 $it;
                        final List $playableList;
                        int label;

                        {
                            this.$it = j00;
                            LocalContentArtistSongFragment.this = localContentArtistSongFragment0;
                            this.$playableList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1.1.1(this.$it, LocalContentArtistSongFragment.this, this.$playableList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.local.LocalContentArtistSongFragment.startQuery.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            if(this.$it instanceof LocalSongAdapter) {
                                LocalContentArtistSongFragment.this.dismissProgressDialog();
                                ((LocalSongAdapter)this.$it).clear();
                                ((LocalSongAdapter)this.$it).addAll(this.$playableList);
                                LocalContentArtistSongFragment.this.performFetchCompleteOnlyViews();
                                int v = 0;
                                if(LocalContentArtistSongFragment.this.getEditMode()) {
                                    LocalContentArtistSongFragment localContentArtistSongFragment0 = LocalContentArtistSongFragment.this;
                                    boolean z = localContentArtistSongFragment0.getEditMode();
                                    if(this.$playableList == null || this.$playableList.isEmpty()) {
                                        v = 1;
                                    }
                                    localContentArtistSongFragment0.setEditModeVisibility(z, ((boolean)(v ^ 1)));
                                    return H.a;
                                }
                                LocalContentArtistSongFragment localContentArtistSongFragment1 = LocalContentArtistSongFragment.this;
                                if(this.$playableList == null || this.$playableList.isEmpty()) {
                                    v = 1;
                                }
                                localContentArtistSongFragment1.setAllCheckButtonVisibility(((boolean)(v ^ 1)));
                            }
                            return H.a;
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 2;
                    if(BuildersKt.withContext(LocalContentArtistSongFragment.this.getMainDispatcher(), localContentArtistSongFragment$startQuery$1$1$10, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
        });
    }
}

