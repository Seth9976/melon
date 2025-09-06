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

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentGenreSongFragment;", "Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment;", "<init>", "()V", "", "getLocalTrackType", "()I", "Lie/H;", "startQuery", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentGenreSongFragment extends LocalContentBaseUIFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentGenreSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentGenreSongFragment;", "info", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo;", "playbackMenuId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentGenreSongFragment newInstance(@Nullable ParamInfo localContentNewDbBaseFragment$ParamInfo0, @Nullable String s) {
            LocalContentGenreSongFragment localContentGenreSongFragment0 = new LocalContentGenreSongFragment();
            Bundle bundle0 = new Bundle();
            if(localContentNewDbBaseFragment$ParamInfo0 == null) {
                return localContentGenreSongFragment0;
            }
            bundle0.putString("argFragmentTitle", "");
            bundle0.putString("genrename", "");
            bundle0.putBoolean("argIsFlac", localContentNewDbBaseFragment$ParamInfo0.isFlac());
            bundle0.putString("argPlaybackMenuId", s);
            localContentGenreSongFragment0.setArguments(bundle0);
            return localContentGenreSongFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "LocalContentGenreSongFragment";

    static {
        LocalContentGenreSongFragment.Companion = new Companion(null);
        LocalContentGenreSongFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public int getLocalTrackType() {
        return 3;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void startQuery() {
        f0.f(this).a(new n(null) {
            int label;

            {
                LocalContentGenreSongFragment.this = localContentGenreSongFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreSongFragment.startQuery.1(LocalContentGenreSongFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreSongFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalContentGenreSongFragment.startQuery.1.playableList.1 localContentGenreSongFragment$startQuery$1$playableList$10 = new n(null) {
                            int label;

                            {
                                LocalContentGenreSongFragment.this = localContentGenreSongFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentGenreSongFragment.startQuery.1.playableList.1(LocalContentGenreSongFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentGenreSongFragment.startQuery.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                String s = LocalContentGenreSongFragment.this.getGenre();
                                if(s != null) {
                                    LocalContentGenreSongFragment localContentGenreSongFragment0 = LocalContentGenreSongFragment.this;
                                    f f0 = g.a;
                                    if(localContentGenreSongFragment0.mIsFlac) {
                                        f0.m();
                                        list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 21));
                                    }
                                    else {
                                        f0.m();
                                        list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 17));
                                    }
                                    f0.m();
                                    String s1 = localContentGenreSongFragment0.mPlaybackMenuId;
                                    q.f(s1, "access$getMPlaybackMenuId$p$s-1107126630(...)");
                                    return g.i(s1, list0);
                                }
                                return null;
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(LocalContentGenreSongFragment.this.getIoDispatcher(), localContentGenreSongFragment$startQuery$1$playableList$10, this);
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
                j0 j00 = LocalContentGenreSongFragment.this.mAdapter;
                if(j00 != null) {
                    LocalContentGenreSongFragment localContentGenreSongFragment0 = LocalContentGenreSongFragment.this;
                    if(j00 instanceof LocalSongAdapter) {
                        localContentGenreSongFragment0.dismissProgressDialog();
                        ((LocalSongAdapter)j00).clear();
                        ((LocalSongAdapter)j00).addAll(((List)object0));
                        localContentGenreSongFragment0.performFetchCompleteOnlyViews();
                        int v = 0;
                        if(localContentGenreSongFragment0.getEditMode()) {
                            boolean z = localContentGenreSongFragment0.getEditMode();
                            if(((List)object0) == null || ((List)object0).isEmpty()) {
                                v = 1;
                            }
                            localContentGenreSongFragment0.setEditModeVisibility(z, ((boolean)(v ^ 1)));
                            return H.a;
                        }
                        if(((List)object0) == null || ((List)object0).isEmpty()) {
                            v = 1;
                        }
                        localContentGenreSongFragment0.setAllCheckButtonVisibility(((boolean)(v ^ 1)));
                    }
                }
                return H.a;
            }
        });
    }
}

