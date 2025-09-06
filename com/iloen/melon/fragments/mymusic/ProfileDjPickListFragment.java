package com.iloen.melon.fragments.mymusic;

import B.a;
import B9.e;
import B9.u;
import F8.C;
import J8.Q1;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.DjMembersDjPickPlaylistsReq;
import com.iloen.melon.net.v6x.request.MyMusicDjPickUpdatePlaylistReq;
import com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes.RESPONSE.DJPLAYLISTLIST;
import com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes.RESPONSE;
import com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes;
import com.iloen.melon.net.v6x.response.MyMusicDjPickUpdatePlaylistRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;
import v9.i;
import va.e0;
import va.o;
import z6.f;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0011J-\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ-\u0010$\u001A\u00020\t2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010#\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b$\u0010%J\u001B\u0010)\u001A\u0006\u0012\u0002\b\u00030(2\u0006\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b,\u0010-R\u0016\u0010/\u001A\u00020.8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R)\u0010<\u001A\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00040\u0004068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010;\u00A8\u0006?"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDjPickListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "plylstSeq", "Lie/H;", "requestDjPickUpdate", "(Ljava/lang/String;)V", "", "hasScrolledLine", "()Z", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "LF8/C;", "completeButton", "LF8/C;", "", "currentSortIndex", "I", "repPlaylistSeq", "Ljava/lang/String;", "", "kotlin.jvm.PlatformType", "sortingTexts$delegate", "Lie/j;", "getSortingTexts", "()Ljava/util/List;", "sortingTexts", "Companion", "DjPicklistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ProfileDjPickListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDjPickListFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SORT_TYPE", "SORT_LIKE", "", "SORT_UPDATE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/ProfileDjPickListFragment;", "sortIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ProfileDjPickListFragment newInstance(int v) {
            ProfileDjPickListFragment profileDjPickListFragment0 = new ProfileDjPickListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argSortIndex", v);
            profileDjPickListFragment0.setArguments(bundle0);
            return profileDjPickListFragment0;
        }

        public static ProfileDjPickListFragment newInstance$default(Companion profileDjPickListFragment$Companion0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = 0;
            }
            return profileDjPickListFragment$Companion0.newInstance(v);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0014\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001C\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDjPickListFragment$DjPicklistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/DjMembersDjPickPlaylistsRes$RESPONSE$DJPLAYLISTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/ProfileDjPickListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SORT", "I", "VIEW_TYPE_DJ_PLAYLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class DjPicklistAdapter extends p {
        private final int VIEW_TYPE_DJ_PLAYLIST;
        private final int VIEW_TYPE_SORT;

        public DjPicklistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            ProfileDjPickListFragment.this = profileDjPickListFragment0;
            super(context0, list0);
            this.VIEW_TYPE_SORT = 1;
            this.VIEW_TYPE_DJ_PLAYLIST = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_DJ_PLAYLIST : this.VIEW_TYPE_SORT;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_SORT) {
                List list0 = ProfileDjPickListFragment.this.getSortingTexts();
                String s = (String)je.p.n0(ProfileDjPickListFragment.this.currentSortIndex, list0);
                ((e)o00).b.setText(s);
                com.iloen.melon.fragments.mymusic.e e0 = new com.iloen.melon.fragments.mymusic.e(9, ProfileDjPickListFragment.this, ((e)o00));
                ((e)o00).b.setOnClickListener(e0);
                return;
            }
            if(v2 == this.VIEW_TYPE_DJ_PLAYLIST) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes.RESPONSE.DJPLAYLISTLIST");
                ((u)o00).c(((DJPLAYLISTLIST)object0), v1, null, true);
                Q1 q10 = (Q1)((u)o00).a.f;
                CheckableImageView checkableImageView0 = (CheckableImageView)((u)o00).a.d;
                ((ImageView)((u)o00).a.e).setVisibility(8);
                checkableImageView0.setVisibility(0);
                q10.k.setVisibility(0);
                String s1 = ((DJPLAYLISTLIST)object0).songcnt;
                String s2 = ProfileDjPickListFragment.this.getString(0x7F130A63);  // string:song "곡"
                q10.k.setText(s1 + s2);
                checkableImageView0.setChecked(q.b(((DJPLAYLISTLIST)object0).plylstseq, ProfileDjPickListFragment.this.repPlaylistSeq));
                t t0 = new t(((u)o00), ProfileDjPickListFragment.this, ((DJPLAYLISTLIST)object0), this, 1);
                ((u)o00).itemView.setOnClickListener(t0);
            }
        }

        private static final void onBindViewImpl$lambda$1(ProfileDjPickListFragment profileDjPickListFragment0, e e0, View view0) {
            if(profileDjPickListFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = profileDjPickListFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(profileDjPickListFragment0.getSortingTexts(), profileDjPickListFragment0.currentSortIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new g(profileDjPickListFragment0, e0, 8));
                    bottomSingleFilterListPopup0.setOnDismissListener(profileDjPickListFragment0.mDialogDismissListener);
                    profileDjPickListFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(ProfileDjPickListFragment profileDjPickListFragment0, e e0, int v) {
            profileDjPickListFragment0.currentSortIndex = v;
            String s = (String)je.p.n0(profileDjPickListFragment0.currentSortIndex, profileDjPickListFragment0.getSortingTexts());
            e0.b.setText(s);
            profileDjPickListFragment0.startFetch("filter change");
        }

        private static final void onBindViewImpl$lambda$2(u u0, ProfileDjPickListFragment profileDjPickListFragment0, DJPLAYLISTLIST djMembersDjPickPlaylistsRes$RESPONSE$DJPLAYLISTLIST0, DjPicklistAdapter profileDjPickListFragment$DjPicklistAdapter0, View view0) {
            if(((CheckableImageView)u0.a.d).a) {
                return;
            }
            profileDjPickListFragment0.repPlaylistSeq = djMembersDjPickPlaylistsRes$RESPONSE$DJPLAYLISTLIST0.plylstseq == null ? "" : djMembersDjPickPlaylistsRes$RESPONSE$DJPLAYLISTLIST0.plylstseq;
            profileDjPickListFragment$DjPicklistAdapter0.notifyDataSetChanged();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_SORT) {
                return f.p(viewGroup0, 0.0f, 6);
            }
            return v == this.VIEW_TYPE_DJ_PLAYLIST ? H0.e.P(viewGroup0, B9.q.d) : null;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_SORT_TYPE = "argSortIndex";
    @NotNull
    public static final Companion Companion = null;
    public static final int SORT_LIKE = 0;
    public static final int SORT_UPDATE = 1;
    @NotNull
    private static final String TAG = "ProfileDjPickListFragment";
    private C completeButton;
    private int currentSortIndex;
    @NotNull
    private String repPlaylistSeq;
    @NotNull
    private final j sortingTexts$delegate;

    static {
        ProfileDjPickListFragment.Companion = new Companion(null);
        ProfileDjPickListFragment.$stable = 8;
    }

    public ProfileDjPickListFragment() {
        this.repPlaylistSeq = "";
        this.sortingTexts$delegate = d3.g.Q(new k(this, 5));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new DjPicklistAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(true);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(4);
        return j00;
    }

    public static void g0(ProfileDjPickListFragment profileDjPickListFragment0, Object object0) {
        ProfileDjPickListFragment.requestDjPickUpdate$lambda$6(profileDjPickListFragment0, object0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.Z.buildUpon().appendQueryParameter("targetMemberKey", e1.u.v(((e0)o.a()).j())).appendQueryParameter("sortIndex", String.valueOf(this.currentSortIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getSortingTexts() {
        return (List)this.sortingTexts$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D05BF, viewGroup0, false);  // layout:profile_dj_picklist
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.ProfileDjPickListFragment.DjPicklistAdapter");
        if(i.b.equals(i0)) {
            ((DjPicklistAdapter)j00).clear();
        }
        String s1 = this.currentSortIndex == 1 ? "UDT" : "LIK";
        RequestBuilder.newInstance(new DjMembersDjPickPlaylistsReq(this.getContext(), s1)).tag(this.getRequestTag()).listener(new g(this, i0, 26)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$5(ProfileDjPickListFragment profileDjPickListFragment0, i i0, DjMembersDjPickPlaylistsRes djMembersDjPickPlaylistsRes0) {
        String s;
        if(!profileDjPickListFragment0.prepareFetchComplete(djMembersDjPickPlaylistsRes0)) {
            return;
        }
        RESPONSE djMembersDjPickPlaylistsRes$RESPONSE0 = djMembersDjPickPlaylistsRes0.response;
        if(djMembersDjPickPlaylistsRes$RESPONSE0 != null) {
            Object object0 = null;
            profileDjPickListFragment0.mMelonTiaraProperty = new s(djMembersDjPickPlaylistsRes$RESPONSE0.section, djMembersDjPickPlaylistsRes$RESPONSE0.page, profileDjPickListFragment0.getMenuId(), null);
            ArrayList arrayList0 = djMembersDjPickPlaylistsRes0.response.djPlaylistList;
            q.f(arrayList0, "djPlaylistList");
            for(Object object1: arrayList0) {
                if(((DJPLAYLISTLIST)object1).isRepPlylst) {
                    object0 = object1;
                    break;
                }
                if(false) {
                    break;
                }
            }
            if(((DJPLAYLISTLIST)object0) == null) {
                s = "";
            }
            else {
                s = ((DJPLAYLISTLIST)object0).plylstseq;
                if(s == null) {
                    s = "";
                }
            }
            profileDjPickListFragment0.repPlaylistSeq = s;
        }
        profileDjPickListFragment0.performFetchComplete(i0, djMembersDjPickPlaylistsRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.currentSortIndex = bundle0.getInt("argSortIndex");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSortIndex", this.currentSortIndex);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        String s = this.getString(0x7F130AF8);  // string:talkback_complete_btn "완료 버튼"
        q.f(s, "getString(...)");
        c0.d = s;
        c0.c = new w(this, 5);
        this.completeButton = c0;
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            F8.o o0 = a.s(1);
            C c1 = this.completeButton;
            if(c1 != null) {
                o0.g(c1);
                titleBar0.a(o0);
                titleBar0.setTitle(this.getString(0x7F13103D));  // string:title_dj_pick "DJ PICK"
                return;
            }
            q.m("completeButton");
            throw null;
        }
    }

    private static final void onViewCreated$lambda$2$lambda$1(ProfileDjPickListFragment profileDjPickListFragment0, View view0) {
        if(profileDjPickListFragment0.repPlaylistSeq.length() > 0) {
            profileDjPickListFragment0.requestDjPickUpdate(profileDjPickListFragment0.repPlaylistSeq);
        }
    }

    private final void requestDjPickUpdate(String s) {
        RequestBuilder.newInstance(new MyMusicDjPickUpdatePlaylistReq(this.getContext(), s)).tag("ProfileDjPickListFragment").listener(new B(this, 9)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestDjPickUpdate$lambda$6(ProfileDjPickListFragment profileDjPickListFragment0, Object object0) {
        if(object0 instanceof MyMusicDjPickUpdatePlaylistRes && profileDjPickListFragment0.isFragmentValid() && ((MyMusicDjPickUpdatePlaylistRes)object0).isSuccessful()) {
            profileDjPickListFragment0.performBackPress();
        }
    }

    private static final List sortingTexts_delegate$lambda$0(ProfileDjPickListFragment profileDjPickListFragment0) {
        Context context0 = profileDjPickListFragment0.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                String[] arr_s = resources0.getStringArray(0x7F030036);  // array:sortingbar_djpicklist
                if(arr_s != null) {
                    return n.N(arr_s);
                }
            }
        }
        return je.w.a;
    }
}

