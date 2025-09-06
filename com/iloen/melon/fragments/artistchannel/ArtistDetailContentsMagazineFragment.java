package com.iloen.melon.fragments.artistchannel;

import B9.e;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsMagazineItemHolder.MagazineActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsMagazineItemHolder;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.MAGAZINE;
import com.iloen.melon.net.v6x.request.ArtistContentsMagazineListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsMagazineListReq;
import com.iloen.melon.net.v6x.response.DetailContentsMagazineRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import ie.j;
import java.util.Arrays;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;
import z6.f;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0017J-\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0013H\u0016\u00A2\u0006\u0004\b \u0010!J!\u0010#\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u001F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0013H\u0016\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010+\u001A\u0006\u0012\u0002\b\u00030*2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010,J\'\u00100\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010.\u001A\u00020-2\u0006\u0010/\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b0\u00101R\u0016\u00102\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R)\u0010=\u001A\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010\u00060\u0006078BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsMagazineFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "position", "", "getOrderType", "(I)Ljava/lang/String;", "Lv9/i;", "fetchType", "Lcom/iloen/melon/net/v6x/request/ArtistContentsMagazineListReq;", "getRequestProtocol", "(Lv9/i;)Lcom/iloen/melon/net/v6x/request/ArtistContentsMagazineListReq;", "", "hasScrolledLine", "()Z", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "artistId", "Ljava/lang/String;", "artistName", "filterType", "I", "", "kotlin.jvm.PlatformType", "filterList$delegate", "Lie/j;", "getFilterList", "()Ljava/util/List;", "filterList", "Companion", "MagazineAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsMagazineFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsMagazineFragment$Companion;", "", "<init>", "()V", "TAG", "", "ORDER_TYPE_NEW", "", "ORDER_TYPE_POP", "ORDER_TYPE_DEFAULT", "VIEW_TYPE_HEADER", "VIEW_TYPE_MAGAZINE", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsMagazineFragment;", "artistId", "artistName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsMagazineFragment newInstance(@Nullable String s, @Nullable String s1) {
            ArtistDetailContentsMagazineFragment artistDetailContentsMagazineFragment0 = new ArtistDetailContentsMagazineFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            bundle0.putString("argArtistName", s1);
            artistDetailContentsMagazineFragment0.setArguments(bundle0);
            return artistDetailContentsMagazineFragment0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsMagazineFragment$MagazineAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsMagazineFragment;Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MagazineAdapter extends p {
        @NotNull
        private final MagazineActionListener actionListener;

        public MagazineAdapter(@NotNull Context context0, @Nullable List list0, @NotNull MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0) {
            q.g(context0, "context");
            q.g(detailContentsMagazineItemHolder$MagazineActionListener0, "actionListener");
            ArtistDetailContentsMagazineFragment.this = artistDetailContentsMagazineFragment0;
            super(context0, list0);
            this.actionListener = detailContentsMagazineItemHolder$MagazineActionListener0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 1 : 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof e) {
                List list0 = ArtistDetailContentsMagazineFragment.this.getFilterList();
                String s = (String)je.p.n0(ArtistDetailContentsMagazineFragment.this.filterType, list0);
                ((e)o00).b.setText(s);
                Object[] arr_object = {((e)o00).b.getText()};
                String s1 = ArtistDetailContentsMagazineFragment.this.getString(0x7F130BAF, arr_object);  // string:talkback_order_change "%1$s, 정렬기준 변경"
                ViewUtils.setContentDescriptionWithButtonClassName(((e)o00).b, s1);
                d d0 = new d(ArtistDetailContentsMagazineFragment.this, ((e)o00).b, this, 1);
                ((e)o00).b.setOnClickListener(d0);
                return;
            }
            if(o00 instanceof DetailContentsMagazineItemHolder) {
                ((DetailContentsMagazineItemHolder)o00).bind(((MAGAZINE)this.getItem(v1)), v1);
            }
        }

        private static final void onBindViewImpl$lambda$1(ArtistDetailContentsMagazineFragment artistDetailContentsMagazineFragment0, TextView textView0, MagazineAdapter artistDetailContentsMagazineFragment$MagazineAdapter0, View view0) {
            if(artistDetailContentsMagazineFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = artistDetailContentsMagazineFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(artistDetailContentsMagazineFragment0.getFilterList(), artistDetailContentsMagazineFragment0.filterType);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.artistchannel.e(artistDetailContentsMagazineFragment0, textView0, artistDetailContentsMagazineFragment$MagazineAdapter0, 1));
                    bottomSingleFilterListPopup0.setOnDismissListener(artistDetailContentsMagazineFragment0.mDialogDismissListener);
                    artistDetailContentsMagazineFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(ArtistDetailContentsMagazineFragment artistDetailContentsMagazineFragment0, TextView textView0, MagazineAdapter artistDetailContentsMagazineFragment$MagazineAdapter0, int v) {
            artistDetailContentsMagazineFragment0.filterType = v;
            String s = (String)je.p.n0(artistDetailContentsMagazineFragment0.filterType, artistDetailContentsMagazineFragment0.getFilterList());
            textView0.setText(s);
            ViewUtils.setContentDescriptionWithButtonClassName(textView0, artistDetailContentsMagazineFragment0.getString(0x7F130BAF, new Object[]{textView0.getText()}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
            artistDetailContentsMagazineFragment0.startFetch("filter change");
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = artistDetailContentsMagazineFragment$MagazineAdapter0.getMenuId();
            g0.a = artistDetailContentsMagazineFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            s s1 = artistDetailContentsMagazineFragment0.mMelonTiaraProperty;
            String s2 = null;
            g0.b = s1 == null ? null : s1.a;
            s s3 = artistDetailContentsMagazineFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s2 = s3.b;
            }
            g0.c = s2;
            g0.d = ActionKind.ClickContent;
            g0.y = artistDetailContentsMagazineFragment0.getString(0x7F130DFC);  // string:tiara_common_layer1_magazine_list "매거진리스트"
            g0.F = s;
            g0.o = artistDetailContentsMagazineFragment0.artistId;
            g0.p = artistDetailContentsMagazineFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            g0.q = artistDetailContentsMagazineFragment0.artistName;
            g0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == 0 ? f.p(viewGroup0, 0.0f, 6) : DetailContentsMagazineItemHolder.Companion.newInstance(viewGroup0, this.actionListener);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int ORDER_TYPE_DEFAULT = 0;
    private static final int ORDER_TYPE_NEW = 0;
    private static final int ORDER_TYPE_POP = 1;
    @NotNull
    private static final String TAG = "ArtistInfoMagazineFragment";
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_MAGAZINE = 1;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private final j filterList$delegate;
    private int filterType;

    static {
        ArtistDetailContentsMagazineFragment.Companion = new Companion(null);
        ArtistDetailContentsMagazineFragment.$stable = 8;
    }

    public ArtistDetailContentsMagazineFragment() {
        this.artistId = "";
        this.artistName = "";
        this.filterList$delegate = d3.g.Q(new a(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new MagazineAdapter(this, context0, null, new MagazineActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsMagazineItemHolder$MagazineActionListener
            public void onLandMagazine(MAGAZINE detailBaseRes$MAGAZINE0, int v) {
                if(detailBaseRes$MAGAZINE0 != null) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(detailBaseRes$MAGAZINE0.link));
                    g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                    g0.I = ArtistDetailContentsMagazineFragment.this.getMenuId();
                    g0.a = ArtistDetailContentsMagazineFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    s s0 = ArtistDetailContentsMagazineFragment.this.mMelonTiaraProperty;
                    String s1 = null;
                    g0.b = s0 == null ? null : s0.a;
                    s s2 = ArtistDetailContentsMagazineFragment.this.mMelonTiaraProperty;
                    g0.c = s2 == null ? null : s2.b;
                    g0.d = ActionKind.ClickContent;
                    g0.y = ArtistDetailContentsMagazineFragment.this.getString(0x7F130DFC);  // string:tiara_common_layer1_magazine_list "매거진리스트"
                    g0.C = String.valueOf(v + 1);
                    g0.e = detailBaseRes$MAGAZINE0.contsId;
                    g0.f = Y.i(ContsTypeCode.MELON_MAGAZINE, "code(...)");
                    g0.g = detailBaseRes$MAGAZINE0.contsName;
                    String s3 = detailBaseRes$MAGAZINE0.cateName;
                    if(s3 != null) {
                        s1 = s3.length() == 0 ? ProtocolUtils.getArtistNames(detailBaseRes$MAGAZINE0.artistList) : s3;
                    }
                    g0.h = s1;
                    g0.o = ArtistDetailContentsMagazineFragment.this.artistId;
                    g0.p = ArtistDetailContentsMagazineFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                    g0.q = ArtistDetailContentsMagazineFragment.this.artistName;
                    g0.a().track();
                }
            }
        });
    }

    private static final List filterList_delegate$lambda$0(ArtistDetailContentsMagazineFragment artistDetailContentsMagazineFragment0) {
        String[] arr_s;
        Context context0 = artistDetailContentsMagazineFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030003);  // array:artist_channel_basic_tab_order
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : w.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b.buildUpon().appendPath("MAGAZINE").appendPath(this.artistId).appendQueryParameter("orderType", String.valueOf(this.filterType)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterList() {
        return (List)this.filterList$delegate.getValue();
    }

    private final String getOrderType(int v) {
        return v == 1 ? "POP" : "NEW";
    }

    private final ArtistContentsMagazineListReq getRequestProtocol(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsMagazineFragment.MagazineAdapter");
        Params artistContentsMagazineListReq$Params0 = new Params();
        artistContentsMagazineListReq$Params0.startIndex = i.b.equals(i0) ? 1 : ((MagazineAdapter)j00).getCount() + 1;
        artistContentsMagazineListReq$Params0.pageSize = 100;
        artistContentsMagazineListReq$Params0.orderBy = this.getOrderType(this.filterType);
        artistContentsMagazineListReq$Params0.artistId = this.artistId;
        return new ArtistContentsMagazineListReq(this.getContext(), artistContentsMagazineListReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailContentsMagazineFragment newInstance(@Nullable String s, @Nullable String s1) {
        return ArtistDetailContentsMagazineFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0206, null, false);  // layout:detail_contents_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "fetchType");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsMagazineFragment.MagazineAdapter");
        if(i.b.equals(i0)) {
            ((MagazineAdapter)j00).clear();
        }
        RequestBuilder.newInstance(this.getRequestProtocol(i0)).tag(this.getRequestTag()).listener(new c(6, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(ArtistDetailContentsMagazineFragment artistDetailContentsMagazineFragment0, i i0, DetailContentsMagazineRes detailContentsMagazineRes0) {
        if(artistDetailContentsMagazineFragment0.prepareFetchComplete(detailContentsMagazineRes0) && artistDetailContentsMagazineFragment0.mRecyclerView != null) {
            artistDetailContentsMagazineFragment0.mMelonTiaraProperty = new s(detailContentsMagazineRes0.response.section, detailContentsMagazineRes0.response.page, detailContentsMagazineRes0.response.menuId, null);
            artistDetailContentsMagazineFragment0.performFetchComplete(i0, detailContentsMagazineRes0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
        String s = bundle0.getString("argArtistName", "");
        q.f(s, "getString(...)");
        this.artistName = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F130129));  // string:artist_detail_contents_magazine_title "매거진"
        }
    }
}

