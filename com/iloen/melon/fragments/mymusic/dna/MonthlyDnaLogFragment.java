package com.iloen.melon.fragments.mymusic.dna;

import De.d;
import F8.m;
import F8.o;
import F8.p;
import S2.c;
import Vb.i;
import Vc.B;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b9.a;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.SongInfoBase;
import d3.g;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.b;
import q8.f;
import v8.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ-\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001F\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001DH\u0014¢\u0006\u0004\b\u001F\u0010 J\u0015\u0010#\u001A\b\u0012\u0004\u0012\u00020\"0!H\u0014¢\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u001DH\u0016¢\u0006\u0004\b%\u0010&J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014¢\u0006\u0004\b*\u0010+J\u0011\u0010-\u001A\u0004\u0018\u00010,H\u0014¢\u0006\u0004\b-\u0010.R\u0016\u0010/\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b/\u00100R\u001B\u00105\u001A\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001A\u0004\b#\u00104¨\u00068"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hasScrolledLine", "()Z", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lv8/a;", "Lcom/iloen/melon/net/HttpResponse;", "getViewModel", "()Lv8/a;", "getCacheKey", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "includeShortcuts", "Z", "Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogViewModel;", "viewModel$delegate", "Lie/j;", "()Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogViewModel;", "viewModel", "Companion", "VerticalItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MonthlyDnaLogFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\fH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_MONTH", "ARG_INCLUDE_SHORTCUTS", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogFragment;", "monthCode", "includeShortcuts", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MonthlyDnaLogFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "monthCode");
            MonthlyDnaLogFragment monthlyDnaLogFragment0 = new MonthlyDnaLogFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMonth", s);
            bundle0.putBoolean("argIncludeShortcuts", z);
            monthlyDnaLogFragment0.setArguments(bundle0);
            return monthlyDnaLogFragment0;
        }

        public static MonthlyDnaLogFragment newInstance$default(Companion monthlyDnaLogFragment$Companion0, String s, boolean z, int v, Object object0) {
            if((v & 2) != 0) {
                z = false;
            }
            return monthlyDnaLogFragment$Companion0.newInstance(s, z);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogFragment$VerticalItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "(Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogFragment;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class VerticalItemDecoration extends r0 {
        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogAdapter");
            if(v == ((MonthlyDnaLogAdapter)j00).getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(MonthlyDnaLogFragment.this.getContext(), 40.0f);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[h.values().length];
            try {
                arr_v[3] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[0] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[2] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_INCLUDE_SHORTCUTS = "argIncludeShortcuts";
    @NotNull
    private static final String ARG_MONTH = "argMonth";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MonthlyDnaLogFragment";
    private boolean includeShortcuts;
    @NotNull
    private final j viewModel$delegate;

    static {
        MonthlyDnaLogFragment.Companion = new Companion(null);
        MonthlyDnaLogFragment.$stable = 8;
    }

    public MonthlyDnaLogFragment() {
        this.viewModel$delegate = g.Q(new a(this, 18));

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\'\u0010\u0006\u001A\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogFragment$viewModel$2$1", "Landroidx/lifecycle/o0;", "Landroidx/lifecycle/m0;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/m0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.viewModel.2.1 implements o0 {
            public com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.viewModel.2.1(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
            }

            @Override  // androidx.lifecycle.o0
            public m0 create(d d0, c c0) {
                return o0.super.create(d0, c0);
            }

            @Override  // androidx.lifecycle.o0
            public m0 create(Class class0) {
                q.g(class0, "modelClass");
                return new MonthlyDnaLogViewModel(MonthlyDnaLogFragment.this.includeShortcuts);
            }

            @Override  // androidx.lifecycle.o0
            public m0 create(Class class0, c c0) {
                return o0.super.create(class0, c0);
            }
        }

    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new MonthlyDnaLogAdapter(context0, null, new DnaMonthlyLogClickListener() {
            @Override  // com.iloen.melon.fragments.mymusic.dna.OnAlbumItemClickListener
            public void onAlbumItemClickListener(AlbumInfoBase albumInfoBase0, Bundle bundle0) {
                q.g(albumInfoBase0, "albumInfo");
                Navigator.openAlbumInfo(albumInfoBase0.albumId);
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47(MonthlyDnaLogFragment.this, bundle0, albumInfoBase0, d0);
                d0.p();
            }

            private static final H onAlbumItemClickListener$lambda$47(MonthlyDnaLogFragment monthlyDnaLogFragment0, Bundle bundle0, AlbumInfoBase albumInfoBase0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$33(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.v(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.v(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$40(bundle0, a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$40(bundle0, a0);
                }
                f f0 = (f)d0.e;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.y(albumInfoBase0, f1);
                    d0.e = f1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.y(albumInfoBase0, f0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$46(d0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onAlbumItemClickListener$lambda$47$lambda$33(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new com.iloen.melon.fragments.mymusic.dna.d(5));
                return H.a;
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$33$lambda$32() {
                MelonAppBase.Companion.getClass();
                return "페이지이동";
            }

            private static final H onAlbumItemClickListener$lambda$47$lambda$37(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$37$lambda$34(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$37$lambda$35(monthlyDnaLogFragment0);
                b0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$37$lambda$36();
                return H.a;
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$37$lambda$34(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$37$lambda$35(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final ActionKind onAlbumItemClickListener$lambda$47$lambda$37$lambda$36() {
                return ActionKind.ClickContent;
            }

            private static final H onAlbumItemClickListener$lambda$47$lambda$40(Bundle bundle0, q8.a a0) {
                q.g(a0, "$this$click");
                a0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$40$lambda$38(bundle0);
                a0.e = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$40$lambda$39(bundle0);
                return H.a;
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$40$lambda$38(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("Layer1");
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$40$lambda$39(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("ordnum");
            }

            private static final H onAlbumItemClickListener$lambda$47$lambda$44(AlbumInfoBase albumInfoBase0, f f0) {
                q.g(f0, "$this$eventMeta");
                f0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$44$lambda$41(albumInfoBase0);
                f0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$44$lambda$42();
                f0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$44$lambda$43(albumInfoBase0);
                return H.a;
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$44$lambda$41(AlbumInfoBase albumInfoBase0) {
                return albumInfoBase0.albumId;
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$44$lambda$42() {
                return Y.i(ContsTypeCode.ALBUM, "code(...)");
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$44$lambda$43(AlbumInfoBase albumInfoBase0) {
                return albumInfoBase0.albumName;
            }

            private static final H onAlbumItemClickListener$lambda$47$lambda$46(q8.d d0, q8.c c0) {
                q.g(c0, "$this$customProps");
                c0.a.put("menuid", com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$46$lambda$45(d0));
                return H.a;
            }

            private static final String onAlbumItemClickListener$lambda$47$lambda$46$lambda$45(q8.d d0) {
                return d0.a;
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.OnArtistItemClickListener
            public void onArtistItemClickListener(ArtistInfoBase artistInfoBase0, Bundle bundle0) {
                q.g(artistInfoBase0, "artistInfo");
                Navigator.openArtistInfo(artistInfoBase0.getArtistId());
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62(MonthlyDnaLogFragment.this, bundle0, artistInfoBase0, d0);
                d0.p();
            }

            private static final H onArtistItemClickListener$lambda$62(MonthlyDnaLogFragment monthlyDnaLogFragment0, Bundle bundle0, ArtistInfoBase artistInfoBase0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$49(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$53(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$53(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$55(bundle0, a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$55(bundle0, a0);
                }
                f f0 = (f)d0.e;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$59(artistInfoBase0, f1);
                    d0.e = f1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$59(artistInfoBase0, f0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$61(d0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onArtistItemClickListener$lambda$62$lambda$49(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new i(29));
                return H.a;
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$49$lambda$48() {
                MelonAppBase.Companion.getClass();
                return "페이지이동";
            }

            private static final H onArtistItemClickListener$lambda$62$lambda$53(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$53$lambda$50(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$53$lambda$51(monthlyDnaLogFragment0);
                b0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$53$lambda$52();
                return H.a;
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$53$lambda$50(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$53$lambda$51(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final ActionKind onArtistItemClickListener$lambda$62$lambda$53$lambda$52() {
                return ActionKind.ClickContent;
            }

            private static final H onArtistItemClickListener$lambda$62$lambda$55(Bundle bundle0, q8.a a0) {
                q.g(a0, "$this$click");
                a0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$55$lambda$54(bundle0);
                return H.a;
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$55$lambda$54(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("Layer1");
            }

            private static final H onArtistItemClickListener$lambda$62$lambda$59(ArtistInfoBase artistInfoBase0, f f0) {
                q.g(f0, "$this$eventMeta");
                f0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$59$lambda$56(artistInfoBase0);
                f0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$59$lambda$57();
                f0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$59$lambda$58(artistInfoBase0);
                return H.a;
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$59$lambda$56(ArtistInfoBase artistInfoBase0) {
                return artistInfoBase0.getArtistId();
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$59$lambda$57() {
                return Y.i(ContsTypeCode.ARTIST, "code(...)");
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$59$lambda$58(ArtistInfoBase artistInfoBase0) {
                return artistInfoBase0.getArtistName();
            }

            private static final H onArtistItemClickListener$lambda$62$lambda$61(q8.d d0, q8.c c0) {
                q.g(c0, "$this$customProps");
                c0.a.put("menuid", com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onArtistItemClickListener$lambda$62$lambda$61$lambda$60(d0));
                return H.a;
            }

            private static final String onArtistItemClickListener$lambda$62$lambda$61$lambda$60(q8.d d0) {
                return d0.a;
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.DnaMonthlyLogClickListener
            public void onLastMonthClickListener(List list0) {
                q.g(list0, "monthList");
                FragmentActivity fragmentActivity0 = MonthlyDnaLogFragment.this.getActivity();
                if(fragmentActivity0 != null) {
                    MonthlyDnaLogFragment monthlyDnaLogFragment0 = MonthlyDnaLogFragment.this;
                    String s = monthlyDnaLogFragment0.getViewModel().getMonth();
                    if(s == null) {
                        s = "";
                    }
                    hd.c.a(fragmentActivity0, list0, s, "MonthlyDnaLogFragment", false, new B(monthlyDnaLogFragment0, 19));
                }
            }

            private static final H onLastMonthClickListener$lambda$89$lambda$88(MonthlyDnaLogFragment monthlyDnaLogFragment0, String s) {
                q.g(s, "yearMonth");
                monthlyDnaLogFragment0.getViewModel().setMonth(s);
                monthlyDnaLogFragment0.getViewModel().clearCache();
                return H.a;
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.DnaMonthlyLogClickListener
            public void onMostGenreMoreClickListener(String s, Bundle bundle0) {
                q.g(s, "filterCode");
                Navigator.INSTANCE.openChartHottrackDetail("HOT_01", s);
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87(MonthlyDnaLogFragment.this, bundle0, d0);
                d0.p();
            }

            private static final H onMostGenreMoreClickListener$lambda$87(MonthlyDnaLogFragment monthlyDnaLogFragment0, Bundle bundle0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$78(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$81(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$81(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.q(bundle0, a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.q(bundle0, a0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$86(d0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onMostGenreMoreClickListener$lambda$87$lambda$78(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new com.iloen.melon.fragments.mymusic.dna.d(1));
                return H.a;
            }

            private static final String onMostGenreMoreClickListener$lambda$87$lambda$78$lambda$77() {
                MelonAppBase.Companion.getClass();
                return "페이지이동";
            }

            private static final H onMostGenreMoreClickListener$lambda$87$lambda$81(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$81$lambda$79(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$81$lambda$80(monthlyDnaLogFragment0);
                return H.a;
            }

            private static final String onMostGenreMoreClickListener$lambda$87$lambda$81$lambda$79(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onMostGenreMoreClickListener$lambda$87$lambda$81$lambda$80(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final H onMostGenreMoreClickListener$lambda$87$lambda$84(Bundle bundle0, q8.a a0) {
                q.g(a0, "$this$click");
                a0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$84$lambda$82(bundle0);
                a0.g = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$84$lambda$83();
                return H.a;
            }

            private static final String onMostGenreMoreClickListener$lambda$87$lambda$84$lambda$82(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("Layer1");
            }

            private static final String onMostGenreMoreClickListener$lambda$87$lambda$84$lambda$83() {
                MelonAppBase.Companion.getClass();
                return "더보기";
            }

            private static final H onMostGenreMoreClickListener$lambda$87$lambda$86(q8.d d0, q8.c c0) {
                q.g(c0, "$this$customProps");
                c0.a.put("menuid", com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$86$lambda$85(d0));
                return H.a;
            }

            private static final String onMostGenreMoreClickListener$lambda$87$lambda$86$lambda$85(q8.d d0) {
                return d0.a;
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.DnaMonthlyLogClickListener
            public void onShortcutClickListener() {
                LogU.Companion.d("MonthlyDnaLogFragment", "onShortcutClickListener() - ");
                Navigator.INSTANCE.openMusicDna();
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100(MonthlyDnaLogFragment.this, d0);
                d0.p();
            }

            private static final H onShortcutClickListener$lambda$100(MonthlyDnaLogFragment monthlyDnaLogFragment0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$91(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$94(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$94(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$97(a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$97(a0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$99(d0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onShortcutClickListener$lambda$100$lambda$91(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new com.iloen.melon.fragments.mymusic.dna.d(2));
                return H.a;
            }

            private static final String onShortcutClickListener$lambda$100$lambda$91$lambda$90() {
                MelonAppBase.Companion.getClass();
                return "페이지이동";
            }

            private static final H onShortcutClickListener$lambda$100$lambda$94(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$94$lambda$92(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$94$lambda$93(monthlyDnaLogFragment0);
                return H.a;
            }

            private static final String onShortcutClickListener$lambda$100$lambda$94$lambda$92(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onShortcutClickListener$lambda$100$lambda$94$lambda$93(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final H onShortcutClickListener$lambda$100$lambda$97(q8.a a0) {
                q.g(a0, "$this$click");
                a0.b(new com.iloen.melon.fragments.mymusic.dna.d(6));
                a0.a(new com.iloen.melon.fragments.mymusic.dna.d(7));
                return H.a;
            }

            private static final String onShortcutClickListener$lambda$100$lambda$97$lambda$95() {
                MelonAppBase.Companion.getClass();
                return "뮤직DNA보러가기";
            }

            private static final String onShortcutClickListener$lambda$100$lambda$97$lambda$96() {
                MelonAppBase.Companion.getClass();
                return "뮤직DNA보러가기";
            }

            private static final H onShortcutClickListener$lambda$100$lambda$99(q8.d d0, q8.c c0) {
                q.g(c0, "$this$customProps");
                c0.a.put("menuid", com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onShortcutClickListener$lambda$100$lambda$99$lambda$98(d0));
                return H.a;
            }

            private static final String onShortcutClickListener$lambda$100$lambda$99$lambda$98(q8.d d0) {
                return d0.a;
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.OnSongItemClickListener
            public void onSongItemClickListener(SongInfoBase songInfoBase0, Bundle bundle0) {
                q.g(songInfoBase0, "songInfo");
                Navigator.openAlbumInfo(songInfoBase0.albumId);
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31(MonthlyDnaLogFragment.this, bundle0, songInfoBase0, d0);
                d0.p();
            }

            private static final H onSongItemClickListener$lambda$31(MonthlyDnaLogFragment monthlyDnaLogFragment0, Bundle bundle0, SongInfoBase songInfoBase0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$17(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.w(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.w(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$24(bundle0, a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$24(bundle0, a0);
                }
                f f0 = (f)d0.e;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.u(songInfoBase0, f1);
                    d0.e = f1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.u(songInfoBase0, f0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$30(d0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onSongItemClickListener$lambda$31$lambda$17(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new com.iloen.melon.fragments.mymusic.dna.d(4));
                return H.a;
            }

            private static final String onSongItemClickListener$lambda$31$lambda$17$lambda$16() {
                MelonAppBase.Companion.getClass();
                return "페이지이동";
            }

            private static final H onSongItemClickListener$lambda$31$lambda$21(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$21$lambda$18(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$21$lambda$19(monthlyDnaLogFragment0);
                b0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$21$lambda$20();
                return H.a;
            }

            private static final String onSongItemClickListener$lambda$31$lambda$21$lambda$18(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onSongItemClickListener$lambda$31$lambda$21$lambda$19(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final ActionKind onSongItemClickListener$lambda$31$lambda$21$lambda$20() {
                return ActionKind.ClickContent;
            }

            private static final H onSongItemClickListener$lambda$31$lambda$24(Bundle bundle0, q8.a a0) {
                q.g(a0, "$this$click");
                a0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$24$lambda$22(bundle0);
                a0.e = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$24$lambda$23(bundle0);
                return H.a;
            }

            private static final String onSongItemClickListener$lambda$31$lambda$24$lambda$22(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("Layer1");
            }

            private static final String onSongItemClickListener$lambda$31$lambda$24$lambda$23(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("ordnum");
            }

            private static final H onSongItemClickListener$lambda$31$lambda$28(SongInfoBase songInfoBase0, f f0) {
                q.g(f0, "$this$eventMeta");
                f0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$28$lambda$25(songInfoBase0);
                f0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$28$lambda$26();
                f0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$28$lambda$27(songInfoBase0);
                return H.a;
            }

            private static final String onSongItemClickListener$lambda$31$lambda$28$lambda$25(SongInfoBase songInfoBase0) {
                return songInfoBase0.albumId;
            }

            private static final String onSongItemClickListener$lambda$31$lambda$28$lambda$26() {
                return Y.i(ContsTypeCode.ALBUM, "code(...)");
            }

            private static final String onSongItemClickListener$lambda$31$lambda$28$lambda$27(SongInfoBase songInfoBase0) {
                return songInfoBase0.albumName;
            }

            private static final H onSongItemClickListener$lambda$31$lambda$30(q8.d d0, q8.c c0) {
                q.g(c0, "$this$customProps");
                c0.a.put("menuid", com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$30$lambda$29(d0));
                return H.a;
            }

            private static final String onSongItemClickListener$lambda$31$lambda$30$lambda$29(q8.d d0) {
                return d0.a;
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.OnSongItemClickListener
            public void onSongPlayClickListener(SongInfoBase songInfoBase0, Bundle bundle0) {
                String s;
                q.g(songInfoBase0, "songInfo");
                v8.i i0 = (v8.i)MonthlyDnaLogFragment.this.getViewModel().getResponse().getValue();
                if(i0 == null) {
                    s = null;
                }
                else {
                    HttpResponse httpResponse0 = (HttpResponse)i0.c;
                    s = httpResponse0 == null ? null : httpResponse0.getMenuId();
                }
                MonthlyDnaLogFragment.this.playSong(songInfoBase0.songId, s);
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15(MonthlyDnaLogFragment.this, bundle0, songInfoBase0, d0);
                ((Event)d0.p()).track();
            }

            private static final H onSongPlayClickListener$lambda$15(MonthlyDnaLogFragment monthlyDnaLogFragment0, Bundle bundle0, SongInfoBase songInfoBase0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$1(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$5(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$5(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.z(bundle0, a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.z(bundle0, a0);
                }
                f f0 = (f)d0.e;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$12(songInfoBase0, f1);
                    d0.e = f1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$12(songInfoBase0, f0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$14(monthlyDnaLogFragment0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onSongPlayClickListener$lambda$15$lambda$1(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new com.iloen.melon.fragments.mymusic.dna.d(3));
                return H.a;
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$1$lambda$0() {
                MelonAppBase.Companion.getClass();
                return "음악재생";
            }

            private static final H onSongPlayClickListener$lambda$15$lambda$12(SongInfoBase songInfoBase0, f f0) {
                q.g(f0, "$this$eventMeta");
                f0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$12$lambda$9(songInfoBase0);
                f0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$12$lambda$10();
                f0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$12$lambda$11(songInfoBase0);
                return H.a;
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$12$lambda$10() {
                return Y.i(ContsTypeCode.SONG, "code(...)");
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$12$lambda$11(SongInfoBase songInfoBase0) {
                return songInfoBase0.songName;
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$12$lambda$9(SongInfoBase songInfoBase0) {
                return songInfoBase0.songId;
            }

            private static final H onSongPlayClickListener$lambda$15$lambda$14(MonthlyDnaLogFragment monthlyDnaLogFragment0, q8.c c0) {
                q.g(c0, "$this$customProps");
                String s = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$14$lambda$13(monthlyDnaLogFragment0);
                c0.a.put("menuid", s);
                return H.a;
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$14$lambda$13(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                String s = monthlyDnaLogFragment0.getMenuId();
                q.f(s, "getMenuId(...)");
                return s;
            }

            private static final H onSongPlayClickListener$lambda$15$lambda$5(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$5$lambda$2(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$5$lambda$3(monthlyDnaLogFragment0);
                b0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$5$lambda$4();
                return H.a;
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$5$lambda$2(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$5$lambda$3(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final ActionKind onSongPlayClickListener$lambda$15$lambda$5$lambda$4() {
                return ActionKind.PlayMusic;
            }

            private static final H onSongPlayClickListener$lambda$15$lambda$8(Bundle bundle0, q8.a a0) {
                q.g(a0, "$this$click");
                a0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$8$lambda$6(bundle0);
                a0.e = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$8$lambda$7(bundle0);
                return H.a;
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$8$lambda$6(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("Layer1");
            }

            private static final String onSongPlayClickListener$lambda$15$lambda$8$lambda$7(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("ordnum");
            }

            @Override  // com.iloen.melon.fragments.mymusic.dna.OnTagItemClickListener
            public void onTagItemClickListener(TagInfoBase tagInfoBase0, Bundle bundle0) {
                q.g(tagInfoBase0, "tagInfo");
                Navigator.openMelonDJTagHubDetail(tagInfoBase0.tagSeq);
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76(MonthlyDnaLogFragment.this, bundle0, tagInfoBase0, d0);
                d0.p();
            }

            private static final H onTagItemClickListener$lambda$76(MonthlyDnaLogFragment monthlyDnaLogFragment0, Bundle bundle0, TagInfoBase tagInfoBase0, q8.d d0) {
                q.g(d0, "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$64(((q8.h)d0.b));
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$68(monthlyDnaLogFragment0, b1);
                    d0.c = b1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$68(monthlyDnaLogFragment0, b0);
                }
                q8.a a0 = (q8.a)d0.d;
                if(a0 == null) {
                    q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.s(bundle0, a1);
                    d0.d = a1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.s(bundle0, a0);
                }
                f f0 = (f)d0.e;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$73(tagInfoBase0, f1);
                    d0.e = f1;
                }
                else {
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$73(tagInfoBase0, f0);
                }
                q8.c c0 = new q8.c();
                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$75(d0, c0);
                ((LinkedHashMap)d0.g).putAll(c0.a);
                return H.a;
            }

            private static final H onTagItemClickListener$lambda$76$lambda$64(q8.h h0) {
                q.g(h0, "$this$track");
                h0.a(new com.iloen.melon.fragments.mymusic.dna.d(0));
                return H.a;
            }

            private static final String onTagItemClickListener$lambda$76$lambda$64$lambda$63() {
                MelonAppBase.Companion.getClass();
                return "페이지이동";
            }

            private static final H onTagItemClickListener$lambda$76$lambda$68(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                q.g(b0, "$this$common");
                b0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$68$lambda$65(monthlyDnaLogFragment0);
                b0.b = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$68$lambda$66(monthlyDnaLogFragment0);
                b0.c = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$68$lambda$67();
                return H.a;
            }

            private static final String onTagItemClickListener$lambda$76$lambda$68$lambda$65(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getSection();
            }

            private static final String onTagItemClickListener$lambda$76$lambda$68$lambda$66(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
                return monthlyDnaLogFragment0.getViewModel().getPage();
            }

            private static final ActionKind onTagItemClickListener$lambda$76$lambda$68$lambda$67() {
                return ActionKind.ClickContent;
            }

            private static final H onTagItemClickListener$lambda$76$lambda$70(Bundle bundle0, q8.a a0) {
                q.g(a0, "$this$click");
                a0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$70$lambda$69(bundle0);
                return H.a;
            }

            private static final String onTagItemClickListener$lambda$76$lambda$70$lambda$69(Bundle bundle0) {
                return bundle0 == null ? null : bundle0.getString("Layer1");
            }

            private static final H onTagItemClickListener$lambda$76$lambda$73(TagInfoBase tagInfoBase0, f f0) {
                q.g(f0, "$this$eventMeta");
                f0.a = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$73$lambda$71(tagInfoBase0);
                f0.g = com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$73$lambda$72(tagInfoBase0);
                return H.a;
            }

            private static final String onTagItemClickListener$lambda$76$lambda$73$lambda$71(TagInfoBase tagInfoBase0) {
                return tagInfoBase0.tagSeq;
            }

            private static final String onTagItemClickListener$lambda$76$lambda$73$lambda$72(TagInfoBase tagInfoBase0) {
                return tagInfoBase0.tagName == null ? "" : tagInfoBase0.tagName;
            }

            private static final H onTagItemClickListener$lambda$76$lambda$75(q8.d d0, q8.c c0) {
                q.g(c0, "$this$customProps");
                c0.a.put("menuid", com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$75$lambda$74(d0));
                return H.a;
            }

            private static final String onTagItemClickListener$lambda$76$lambda$75$lambda$74(q8.d d0) {
                return d0.a;
            }

            public static H q(Bundle bundle0, q8.a a0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onMostGenreMoreClickListener$lambda$87$lambda$84(bundle0, a0);
            }

            public static H s(Bundle bundle0, q8.a a0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onTagItemClickListener$lambda$76$lambda$70(bundle0, a0);
            }

            public static H u(SongInfoBase songInfoBase0, f f0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$28(songInfoBase0, f0);
            }

            public static H v(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$37(monthlyDnaLogFragment0, b0);
            }

            public static H w(MonthlyDnaLogFragment monthlyDnaLogFragment0, b b0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongItemClickListener$lambda$31$lambda$21(monthlyDnaLogFragment0, b0);
            }

            public static H y(AlbumInfoBase albumInfoBase0, f f0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onAlbumItemClickListener$lambda$47$lambda$44(albumInfoBase0, f0);
            }

            public static H z(Bundle bundle0, q8.a a0) {
                return com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.createRecyclerViewAdapter.1.onSongPlayClickListener$lambda$15$lambda$8(bundle0, a0);
            }
        });
    }

    public static MonthlyDnaLogViewModel f0(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
        return MonthlyDnaLogFragment.viewModel_delegate$lambda$0(monthlyDnaLogFragment0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return this.getViewModel().getCacheKey();
    }

    private final MonthlyDnaLogViewModel getViewModel() {
        return (MonthlyDnaLogViewModel)this.viewModel$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public v8.a getViewModel() {
        return this.getViewModel();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final MonthlyDnaLogFragment newInstance(@NotNull String s, boolean z) {
        return MonthlyDnaLogFragment.Companion.newInstance(s, z);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).addItemDecoration(new VerticalItemDecoration(this));
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D051F, viewGroup0, false);  // layout:monthly_dna_log
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        this.getViewModel().request(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.getViewModel().setMonth(bundle0.getString("argMonth"));
        this.includeShortcuts = bundle0.getBoolean("argIncludeShortcuts");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMonth", this.getViewModel().getMonth());
        bundle0.putBoolean("argIncludeShortcuts", this.includeShortcuts);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = (TitleBar)view0.findViewById(0x7F0A0BAD);  // id:titlebar
        o[] arr_o = {new m(0, 0), new p(1)};
        o o0 = null;
        for(int v = 0; v < 2; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        if(o0 != null) {
            titleBar0.a(o0);
        }
        titleBar0.setTitle(this.getString(0x7F130764));  // string:musicdna_title_monthly_log "월간 Log"
        titleBar0.f(true);
        this.getViewModel().getResponse().observe(this.getViewLifecycleOwner(), new com.iloen.melon.fragments.mymusic.dna.c(this, 0));
        this.getViewModel().getList().observe(this.getViewLifecycleOwner(), new com.iloen.melon.fragments.mymusic.dna.c(this, 1));
    }

    private static final void onViewCreated$lambda$3(MonthlyDnaLogFragment monthlyDnaLogFragment0, v8.i i0) {
        LogU.Companion.d("MonthlyDnaLogFragment", "onViewCreated() - request.status : " + i0.a);
        switch(WhenMappings.$EnumSwitchMapping$0[i0.a.ordinal()]) {
            case 1: {
                monthlyDnaLogFragment0.showProgress(true);
                monthlyDnaLogFragment0.hideEmptyAndErrorView();
                return;
            }
            case 2: {
                monthlyDnaLogFragment0.onFetchSuccessUI(i0);
                return;
            }
            case 3: 
            case 4: {
                monthlyDnaLogFragment0.onFetchErrorUI(i0);
            }
        }
    }

    private static final void onViewCreated$lambda$4(MonthlyDnaLogFragment monthlyDnaLogFragment0, ArrayList arrayList0) {
        j0 j00 = monthlyDnaLogFragment0.getAdapter();
        MonthlyDnaLogAdapter monthlyDnaLogAdapter0 = j00 instanceof MonthlyDnaLogAdapter ? ((MonthlyDnaLogAdapter)j00) : null;
        if(monthlyDnaLogAdapter0 != null) {
            q.d(arrayList0);
            monthlyDnaLogAdapter0.updateItemModelList(arrayList0);
        }
        monthlyDnaLogFragment0.performFetchCompleteOnlyViews();
    }

    private static final MonthlyDnaLogViewModel viewModel_delegate$lambda$0(MonthlyDnaLogFragment monthlyDnaLogFragment0) {
        com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.viewModel.2.1 monthlyDnaLogFragment$viewModel$2$10 = new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment.viewModel.2.1(monthlyDnaLogFragment0);
        q.g(monthlyDnaLogFragment0, "owner");
        q0 q00 = monthlyDnaLogFragment0.getViewModelStore();
        c c0 = monthlyDnaLogFragment0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(c0, "defaultCreationExtras");
        o9.b b0 = new o9.b(q00, monthlyDnaLogFragment$viewModel$2$10, c0);
        d d0 = df.d.y(MonthlyDnaLogViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (MonthlyDnaLogViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }
}

