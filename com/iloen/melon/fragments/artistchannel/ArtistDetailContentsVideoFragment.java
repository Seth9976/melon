package com.iloen.melon.fragments.artistchannel;

import B9.e;
import B9.v;
import P4.a;
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
import com.iloen.melon.fragments.detail.viewholder.DetailContentsMvItemHolder.MvActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsMvItemHolder;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.ArtistContentsVideoListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsVideoListReq;
import com.iloen.melon.net.v6x.response.DetailContentsMvRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.MvInfoBase;
import java.util.ArrayList;
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
import v9.j;
import z6.f;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002DEB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b\"\u0010#J\'\u0010)\u001A\u00020\u00042\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010,\u001A\u00020+2\u0006\u0010%\u001A\u00020$H\u0002\u00A2\u0006\u0004\b,\u0010-J\u0017\u00100\u001A\u00020\u00072\u0006\u0010/\u001A\u00020.H\u0002\u00A2\u0006\u0004\b0\u00101J\u0017\u00102\u001A\u00020\u00072\u0006\u0010/\u001A\u00020.H\u0002\u00A2\u0006\u0004\b2\u00101R\u0016\u00103\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00104R!\u0010<\u001A\b\u0012\u0004\u0012\u000207068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010;R)\u0010@\u001A\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010\u00070\u0007068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b>\u00109\u001A\u0004\b?\u0010;R\u0016\u0010A\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010B\u00A8\u0006F"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsVideoFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "fetchType", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/net/v6x/request/ArtistContentsVideoListReq;", "getRequestProtocol", "(Lv9/i;)Lcom/iloen/melon/net/v6x/request/ArtistContentsVideoListReq;", "", "position", "getFilterType", "(I)Ljava/lang/String;", "getOrderType", "artistId", "Ljava/lang/String;", "artistName", "", "Lv9/j;", "filterLevel1List$delegate", "Lie/j;", "getFilterLevel1List", "()Ljava/util/List;", "filterLevel1List", "kotlin.jvm.PlatformType", "filterLevel2List$delegate", "getFilterLevel2List", "filterLevel2List", "filterType", "I", "orderType", "Companion", "VideoAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsVideoFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001A\u00020\bH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsVideoFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_FILTER_TYPE", "FILTER_ALL", "", "FILTER_MV", "FILTER_BO", "ORDER_NEW", "ORDER_POP", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsVideoFragment;", "artistId", "artistName", "filterType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsVideoFragment newInstance(@Nullable String s, @Nullable String s1, int v) {
            ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0 = new ArtistDetailContentsVideoFragment();
            Bundle bundle0 = Y.c("argArtistId", s, "argArtistName", s1);
            bundle0.putInt("argFilterType", v);
            artistDetailContentsVideoFragment0.setArguments(bundle0);
            return artistDetailContentsVideoFragment0;
        }

        public static ArtistDetailContentsVideoFragment newInstance$default(Companion artistDetailContentsVideoFragment$Companion0, String s, String s1, int v, int v1, Object object0) {
            if((v1 & 4) != 0) {
                v = 0;
            }
            return artistDetailContentsVideoFragment$Companion0.newInstance(s, s1, v);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010\u001ER\u0014\u0010 \u001A\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010\u001E¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsVideoFragment$VideoAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$VIDEO;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsVideoFragment;Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "VIEW_TYPE_SCROLlABLE_ALYAC", "I", "VIEW_TYPE_FILTER", "VIEW_TYPE_VIDEO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class VideoAdapter extends p {
        private final int VIEW_TYPE_FILTER;
        private final int VIEW_TYPE_SCROLlABLE_ALYAC;
        private final int VIEW_TYPE_VIDEO;
        @NotNull
        private final MvActionListener actionListener;

        public VideoAdapter(@NotNull Context context0, @Nullable List list0, @NotNull MvActionListener detailContentsMvItemHolder$MvActionListener0) {
            q.g(context0, "context");
            q.g(detailContentsMvItemHolder$MvActionListener0, "actionListener");
            ArtistDetailContentsVideoFragment.this = artistDetailContentsVideoFragment0;
            super(context0, list0);
            this.actionListener = detailContentsMvItemHolder$MvActionListener0;
            this.VIEW_TYPE_SCROLlABLE_ALYAC = 1;
            this.VIEW_TYPE_FILTER = 2;
            this.VIEW_TYPE_VIDEO = 3;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 1 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getHeaderViewItemCount() > 0 && v == this.getAvailableHeaderPosition()) {
                return this.VIEW_TYPE_SCROLlABLE_ALYAC;
            }
            return this.getHeaderViewItemCount() <= 1 || v != this.getAvailableHeaderPosition() + 1 ? this.VIEW_TYPE_VIDEO : this.VIEW_TYPE_FILTER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof v) {
                ArrayList arrayList0 = new ArrayList(ArtistDetailContentsVideoFragment.this.getFilterLevel1List());
                ((v)o00).a.a(arrayList0);
                ((v)o00).a.setSelectedIndex(ArtistDetailContentsVideoFragment.this.filterType);
                c c0 = new c(2, ArtistDetailContentsVideoFragment.this, this);
                E8.c c1 = new E8.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((v)o00).a.e(c0, c1);
                return;
            }
            if(o00 instanceof e) {
                List list0 = ArtistDetailContentsVideoFragment.this.getFilterLevel2List();
                String s = (String)je.p.n0(ArtistDetailContentsVideoFragment.this.orderType, list0);
                ((e)o00).b.setText(s);
                Object[] arr_object = {((e)o00).b.getText()};
                String s1 = ArtistDetailContentsVideoFragment.this.getString(0x7F130BAF, arr_object);  // string:talkback_order_change "%1$s, 정렬기준 변경"
                ViewUtils.setContentDescriptionWithButtonClassName(((e)o00).b, s1);
                d d0 = new d(ArtistDetailContentsVideoFragment.this, ((e)o00).b, this, 3);
                ((e)o00).b.setOnClickListener(d0);
                return;
            }
            if(o00 instanceof DetailContentsMvItemHolder) {
                ((DetailContentsMvItemHolder)o00).setTotal(this.getList().size());
                Object object0 = this.getItem(v1);
                q.f(object0, "getItem(...)");
                ((DetailContentsMvItemHolder)o00).bind(((MvInfoBase)object0), v1);
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0, VideoAdapter artistDetailContentsVideoFragment$VideoAdapter0, int v) {
            if(artistDetailContentsVideoFragment0.filterType == v) {
                return;
            }
            artistDetailContentsVideoFragment0.filterType = v;
            artistDetailContentsVideoFragment0.startFetch("alyac change");
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = artistDetailContentsVideoFragment$VideoAdapter0.getMenuId();
            g0.a = artistDetailContentsVideoFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            s s0 = artistDetailContentsVideoFragment0.mMelonTiaraProperty;
            String s1 = null;
            g0.b = s0 == null ? null : s0.a;
            s s2 = artistDetailContentsVideoFragment0.mMelonTiaraProperty;
            g0.c = s2 == null ? null : s2.b;
            g0.d = ActionKind.ClickContent;
            g0.y = artistDetailContentsVideoFragment0.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
            j j0 = (j)je.p.n0(v, artistDetailContentsVideoFragment0.getFilterLevel1List());
            if(j0 != null) {
                s1 = j0.b;
            }
            g0.F = s1;
            g0.o = artistDetailContentsVideoFragment0.artistId;
            g0.p = artistDetailContentsVideoFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            g0.q = artistDetailContentsVideoFragment0.artistName;
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$3(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0, TextView textView0, VideoAdapter artistDetailContentsVideoFragment$VideoAdapter0, View view0) {
            if(artistDetailContentsVideoFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = artistDetailContentsVideoFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(artistDetailContentsVideoFragment0.getFilterLevel2List(), artistDetailContentsVideoFragment0.orderType);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.artistchannel.e(artistDetailContentsVideoFragment0, textView0, artistDetailContentsVideoFragment$VideoAdapter0, 3));
                    bottomSingleFilterListPopup0.setOnDismissListener(artistDetailContentsVideoFragment0.mDialogDismissListener);
                    artistDetailContentsVideoFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$3$lambda$2(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0, TextView textView0, VideoAdapter artistDetailContentsVideoFragment$VideoAdapter0, int v) {
            artistDetailContentsVideoFragment0.orderType = v;
            String s = (String)je.p.n0(artistDetailContentsVideoFragment0.orderType, artistDetailContentsVideoFragment0.getFilterLevel2List());
            textView0.setText(s);
            ViewUtils.setContentDescriptionWithButtonClassName(textView0, artistDetailContentsVideoFragment0.getString(0x7F130BAF, new Object[]{textView0.getText()}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
            artistDetailContentsVideoFragment0.startFetch("filter change");
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = artistDetailContentsVideoFragment$VideoAdapter0.getMenuId();
            g0.a = artistDetailContentsVideoFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            s s1 = artistDetailContentsVideoFragment0.mMelonTiaraProperty;
            String s2 = null;
            g0.b = s1 == null ? null : s1.a;
            s s3 = artistDetailContentsVideoFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s2 = s3.b;
            }
            g0.c = s2;
            g0.d = ActionKind.ClickContent;
            g0.y = artistDetailContentsVideoFragment0.getString(0x7F130E24);  // string:tiara_common_layer1_video_list "비디오리스트"
            g0.F = s;
            g0.o = artistDetailContentsVideoFragment0.artistId;
            g0.p = artistDetailContentsVideoFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            g0.q = artistDetailContentsVideoFragment0.artistName;
            g0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_SCROLlABLE_ALYAC) {
                return a.w(viewGroup0);
            }
            return v == this.VIEW_TYPE_FILTER ? f.p(viewGroup0, 0.0f, 6) : DetailContentsMvItemHolder.Companion.newInstance(viewGroup0, this.actionListener);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_TYPE = "argFilterType";
    @NotNull
    public static final Companion Companion = null;
    public static final int FILTER_ALL = 0;
    public static final int FILTER_BO = 2;
    public static final int FILTER_MV = 1;
    public static final int ORDER_NEW = 0;
    public static final int ORDER_POP = 1;
    @NotNull
    private static final String TAG = " ArtistDetailContentsVideoFragment";
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private final ie.j filterLevel1List$delegate;
    @NotNull
    private final ie.j filterLevel2List$delegate;
    private int filterType;
    private int orderType;

    static {
        ArtistDetailContentsVideoFragment.Companion = new Companion(null);
        ArtistDetailContentsVideoFragment.$stable = 8;
    }

    public ArtistDetailContentsVideoFragment() {
        this.artistId = "";
        this.artistName = "";
        this.filterLevel1List$delegate = d3.g.Q(new k(this, 0));
        this.filterLevel2List$delegate = d3.g.Q(new k(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new VideoAdapter(this, context0, null, new MvActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsMvItemHolder$MvActionListener
            public void onPlayMv(MvInfoBase mvInfoBase0, int v) {
                q.g(mvInfoBase0, "mv");
                String s = null;
                Playable playable0 = Playable.from(mvInfoBase0, ArtistDetailContentsVideoFragment.this.getMenuId(), null);
                ArtistDetailContentsVideoFragment.this.playMv(playable0);
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = ArtistDetailContentsVideoFragment.this.getMenuId();
                g0.a = ArtistDetailContentsVideoFragment.this.getString(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
                s s1 = ArtistDetailContentsVideoFragment.this.mMelonTiaraProperty;
                g0.b = s1 == null ? null : s1.a;
                s s2 = ArtistDetailContentsVideoFragment.this.mMelonTiaraProperty;
                if(s2 != null) {
                    s = s2.b;
                }
                g0.c = s;
                g0.d = ActionKind.PlayVideo;
                g0.y = ArtistDetailContentsVideoFragment.this.getString(0x7F130E24);  // string:tiara_common_layer1_video_list "비디오리스트"
                g0.C = String.valueOf(v + 1);
                g0.e = mvInfoBase0.mvId;
                g0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
                g0.g = mvInfoBase0.mvName;
                g0.h = ProtocolUtils.getArtistNames(mvInfoBase0.artistList);
                g0.o = ArtistDetailContentsVideoFragment.this.artistId;
                g0.p = ArtistDetailContentsVideoFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                g0.q = ArtistDetailContentsVideoFragment.this.artistName;
                g0.a().track();
            }
        });
    }

    private static final List filterLevel1List_delegate$lambda$2(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0) {
        String[] arr_s;
        Context context0 = artistDetailContentsVideoFragment0.getContext();
        if(context0 == null) {
            arr_s = new String[0];
        }
        else {
            Resources resources0 = context0.getResources();
            if(resources0 == null) {
                arr_s = new String[0];
            }
            else {
                arr_s = resources0.getStringArray(0x7F030004);  // array:artist_channel_video_tab_listen_filter
                if(arr_s == null) {
                    arr_s = new String[0];
                }
            }
        }
        List list0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.b = s;
            list0.add(j0);
        }
        return list0;
    }

    private static final List filterLevel2List_delegate$lambda$3(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0) {
        String[] arr_s;
        Context context0 = artistDetailContentsVideoFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F03004D);  // array:sortingbar_type4
        }
        return arr_s != null ? e.k.A(Arrays.copyOf(arr_s, arr_s.length)) : w.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b.buildUpon().appendPath("VIDEO").appendPath(this.artistId).appendQueryParameter("filterType", String.valueOf(this.filterType)).appendQueryParameter("orderType", String.valueOf(this.orderType)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterLevel1List() {
        return (List)this.filterLevel1List$delegate.getValue();
    }

    private final List getFilterLevel2List() {
        return (List)this.filterLevel2List$delegate.getValue();
    }

    private final String getFilterType(int v) {
        switch(v) {
            case 1: {
                return "M";
            }
            case 2: {
                return "BO";
            }
            default: {
                return "A";
            }
        }
    }

    private final String getOrderType(int v) {
        return v == 1 ? "POP" : "NEW";
    }

    private final ArtistContentsVideoListReq getRequestProtocol(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsVideoFragment.VideoAdapter");
        Params artistContentsVideoListReq$Params0 = new Params();
        artistContentsVideoListReq$Params0.startIndex = i.b.equals(i0) ? 1 : ((VideoAdapter)j00).getCount() + 1;
        artistContentsVideoListReq$Params0.pageSize = 100;
        artistContentsVideoListReq$Params0.filterBy = this.getFilterType(this.filterType);
        artistContentsVideoListReq$Params0.orderBy = this.getOrderType(this.orderType);
        artistContentsVideoListReq$Params0.artistId = this.artistId;
        return new ArtistContentsVideoListReq(this.getContext(), artistContentsVideoListReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailContentsVideoFragment newInstance(@Nullable String s, @Nullable String s1, int v) {
        return ArtistDetailContentsVideoFragment.Companion.newInstance(s, s1, v);
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
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsVideoFragment.VideoAdapter");
        if(i.b.equals(i0)) {
            ((VideoAdapter)j00).clear();
        }
        RequestBuilder.newInstance(this.getRequestProtocol(i0)).tag(" ArtistDetailContentsVideoFragment").listener(new c(12, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$6(ArtistDetailContentsVideoFragment artistDetailContentsVideoFragment0, i i0, DetailContentsMvRes detailContentsMvRes0) {
        if(!artistDetailContentsVideoFragment0.prepareFetchComplete(detailContentsMvRes0)) {
            return;
        }
        artistDetailContentsVideoFragment0.mMelonTiaraProperty = new s(detailContentsMvRes0.response.section, detailContentsMvRes0.response.page, detailContentsMvRes0.response.menuId, null);
        artistDetailContentsVideoFragment0.performFetchComplete(i0, detailContentsMvRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
        String s = bundle0.getString("argArtistName", "");
        q.f(s, "getString(...)");
        this.artistName = s;
        this.filterType = bundle0.getInt("argFilterType", 0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
        bundle0.putInt("argFilterType", this.filterType);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F13012A));  // string:artist_detail_contents_mv_title "비디오"
        }
    }
}

