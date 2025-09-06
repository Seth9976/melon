package com.iloen.melon.fragments.mymusic;

import B.a;
import Tf.o;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailContentsLyricHighlightAdapter;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.MyMusicLyricListLyricHighlightReq.Params;
import com.iloen.melon.net.v6x.request.MyMusicLyricListLyricHighlightReq;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import java.util.Arrays;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J-\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ!\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014¢\u0006\u0004\b\'\u0010(J\'\u0010.\u001A\u00020\u00062\u0006\u0010*\u001A\u00020)2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020\nH\u0014¢\u0006\u0004\b.\u0010/R\u0016\u00101\u001A\u0002008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u000B\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000B\u00103¨\u00065"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyDetailContentsLyricHighlightFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "makeHeaderView", "", "isVisible", "setToggleButtonVisibility", "(Z)V", "", "totalCount", "setTextCountTv", "(Ljava/lang/String;)V", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "fetchType", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "", "filterType", "I", "Ljava/lang/String;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyDetailContentsLyricHighlightFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyDetailContentsLyricHighlightFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_FILTER_TYPE", "FILTER_NEW", "", "FILTER_ALPHABET", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyDetailContentsLyricHighlightFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyDetailContentsLyricHighlightFragment newInstance() {
            MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0 = new MyDetailContentsLyricHighlightFragment();
            myDetailContentsLyricHighlightFragment0.setArguments(new Bundle());
            return myDetailContentsLyricHighlightFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_TYPE = "argFilterType";
    @NotNull
    public static final Companion Companion = null;
    private static final int FILTER_ALPHABET = 1;
    private static final int FILTER_NEW = 0;
    @NotNull
    private static final String TAG = "MyDetailContentsLyricHighlightFragment";
    private int filterType;
    @NotNull
    private String totalCount;

    static {
        MyDetailContentsLyricHighlightFragment.Companion = new Companion(null);
        MyDetailContentsLyricHighlightFragment.$stable = 8;
    }

    public MyDetailContentsLyricHighlightFragment() {
        this.totalCount = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new DetailContentsLyricHighlightAdapter(context0, null);
    }

    public static void d0(MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0, TextView textView0, List list0, int v) {
        MyDetailContentsLyricHighlightFragment.makeHeaderView$lambda$1$lambda$0(myDetailContentsLyricHighlightFragment0, textView0, list0, v);
    }

    public static void e0(MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0, VolleyError volleyError0) {
        MyDetailContentsLyricHighlightFragment.onFetchStart$lambda$4(myDetailContentsLyricHighlightFragment0, volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.f0.buildUpon().appendQueryParameter("filterType", String.valueOf(this.filterType)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final void makeHeaderView() {
        this.setTextCountTv(this.totalCount);
        View view0 = this.findViewById(0x7F0A0498);  // id:filter
        TextView textView0 = view0 instanceof TextView ? ((TextView)view0) : null;
        if(textView0 == null) {
            return;
        }
        String[] arr_s = this.getResources().getStringArray(0x7F03001B);  // array:my_music_cast_like_filter_type
        q.f(arr_s, "getStringArray(...)");
        List list0 = k.A(Arrays.copyOf(arr_s, arr_s.length));
        textView0.setText(((String)p.n0(this.filterType, list0)));
        textView0.setOnClickListener(new z(this, list0, textView0, 2));
    }

    private static final void makeHeaderView$lambda$1(MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0, List list0, TextView textView0, View view0) {
        if(myDetailContentsLyricHighlightFragment0.isAdded() && myDetailContentsLyricHighlightFragment0.isPossiblePopupShow()) {
            FragmentActivity fragmentActivity0 = myDetailContentsLyricHighlightFragment0.getActivity();
            if(fragmentActivity0 != null) {
                BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                bottomSingleFilterListPopup0.setFilterItem(list0, myDetailContentsLyricHighlightFragment0.filterType);
                bottomSingleFilterListPopup0.setFilterListener(new E(myDetailContentsLyricHighlightFragment0, textView0, list0, 5));
                bottomSingleFilterListPopup0.setOnDismissListener(myDetailContentsLyricHighlightFragment0.mDialogDismissListener);
                myDetailContentsLyricHighlightFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                bottomSingleFilterListPopup0.show();
            }
        }
    }

    private static final void makeHeaderView$lambda$1$lambda$0(MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0, TextView textView0, List list0, int v) {
        myDetailContentsLyricHighlightFragment0.filterType = v;
        textView0.setText(((CharSequence)p.n0(v, list0)));
        myDetailContentsLyricHighlightFragment0.startFetch("filter change");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).addItemDecoration(new r0() {
            @Override  // androidx.recyclerview.widget.r0
            public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                q.g(rect0, "outRect");
                q.g(view0, "view");
                q.g(recyclerView0, "parent");
                q.g(k00, "state");
                int v = recyclerView0.getChildAdapterPosition(view0);
                j0 j00 = MyDetailContentsLyricHighlightFragment.this.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsLyricHighlightAdapter");
                int v1 = ((DetailContentsLyricHighlightAdapter)j00).getItemCount();
                if(v == 0) {
                    rect0.top = ScreenUtils.dipToPixel(MyDetailContentsLyricHighlightFragment.this.getContext(), 10.0f);
                    return;
                }
                if(v == v1 - 1) {
                    rect0.bottom = ScreenUtils.dipToPixel(MyDetailContentsLyricHighlightFragment.this.getContext(), 15.0f);
                }
            }
        });
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0563, null, false);  // layout:my_detail_lyric_highlight_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "fetchType");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsLyricHighlightAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            this.setToggleButtonVisibility(false);
            ((DetailContentsLyricHighlightAdapter)j00).clear();
        }
        Params myMusicLyricListLyricHighlightReq$Params0 = new Params();
        myMusicLyricListLyricHighlightReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsLyricHighlightAdapter)j00).getCount() + 1;
        myMusicLyricListLyricHighlightReq$Params0.pageSize = 20;
        myMusicLyricListLyricHighlightReq$Params0.orderBy = this.filterType == 1 ? "ALPHABET" : "NEW";
        RequestBuilder.newInstance(new MyMusicLyricListLyricHighlightReq(this.getContext(), myMusicLyricListLyricHighlightReq$Params0)).tag(this.getRequestTag()).listener(new g(this, i0, 11)).errorListener(new B(this, 7)).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0, i i0, MyMusicLyricListLyricHighlightRes myMusicLyricListLyricHighlightRes0) {
        if(!myDetailContentsLyricHighlightFragment0.prepareFetchComplete(myMusicLyricListLyricHighlightRes0)) {
            myDetailContentsLyricHighlightFragment0.setToggleButtonVisibility(false);
            return;
        }
        if(myMusicLyricListLyricHighlightRes0 != null) {
            RESPONSE myMusicLyricListLyricHighlightRes$RESPONSE0 = myMusicLyricListLyricHighlightRes0.response;
            if(myMusicLyricListLyricHighlightRes$RESPONSE0 != null && (myMusicLyricListLyricHighlightRes$RESPONSE0.lyricHighLightList != null && !myMusicLyricListLyricHighlightRes$RESPONSE0.lyricHighLightList.isEmpty() == 1)) {
                String s = myMusicLyricListLyricHighlightRes$RESPONSE0.totalCount == null ? "" : myMusicLyricListLyricHighlightRes$RESPONSE0.totalCount;
                myDetailContentsLyricHighlightFragment0.totalCount = s;
                myDetailContentsLyricHighlightFragment0.setTextCountTv(s);
                myDetailContentsLyricHighlightFragment0.setToggleButtonVisibility(true);
            }
        }
        myDetailContentsLyricHighlightFragment0.performFetchComplete(i0, myMusicLyricListLyricHighlightRes0);
    }

    private static final void onFetchStart$lambda$4(MyDetailContentsLyricHighlightFragment myDetailContentsLyricHighlightFragment0, VolleyError volleyError0) {
        myDetailContentsLyricHighlightFragment0.performFetchError(volleyError0);
        myDetailContentsLyricHighlightFragment0.setToggleButtonVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.filterType = bundle0.getInt("argFilterType", 0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argFilterType", this.filterType);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = true;
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F13076A));  // string:my_detail_contents_lyric_highlighting_title "가사 하이라이팅"
        }
        this.makeHeaderView();
        if(this.getItemCount() <= 0) {
            z = false;
        }
        this.setToggleButtonVisibility(z);
    }

    private final void setTextCountTv(String s) {
        if(!o.H0(s)) {
            View view0 = this.findViewById(0x7F0A034C);  // id:count_tv
            TextView textView0 = view0 instanceof TextView ? ((TextView)view0) : null;
            if(textView0 != null) {
                String s1 = this.getString(0x7F1304E3);  // string:library_all_count "전체 %1$s"
                q.f(s1, "getString(...)");
                Z.y(new Object[]{this.totalCount}, 1, s1, textView0);
            }
        }
    }

    private final void setToggleButtonVisibility(boolean z) {
        ViewUtils.showWhen(this.findViewById(0x7F0A049B), z);  // id:filter_container
    }
}

