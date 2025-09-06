package com.iloen.melon.fragments.artistchannel;

import B9.e;
import B9.v;
import P4.a;
import Tf.o;
import android.content.Context;
import android.content.res.Configuration;
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
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder.AlbumActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.ArtistContentsAlbumListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsAlbumListReq;
import com.iloen.melon.net.v6x.request.ArtistMusicAlbumFilterListReq;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsAlbumRes;
import com.iloen.melon.net.v6x.response.ArtistMusicAlbumFilterListRes.RESPONSE.FILTERLIST;
import com.iloen.melon.net.v6x.response.ArtistMusicAlbumFilterListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.AlbumInfoBase;
import e.k;
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

@Metadata(d1 = {"\u0000\u00B2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0002\\]B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J\'\u0010-\u001A\u00020\u00042\u0006\u0010)\u001A\u00020(2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b/\u0010\u0003J\u000F\u00101\u001A\u000200H\u0014\u00A2\u0006\u0004\b1\u00102J\u001F\u00107\u001A\u00020\f2\u0006\u00104\u001A\u0002032\u0006\u00106\u001A\u000205H\u0014\u00A2\u0006\u0004\b7\u00108J\u000F\u00109\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b9\u0010\u0003J\u0017\u0010;\u001A\u00020\f2\u0006\u0010:\u001A\u00020(H\u0002\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010>\u001A\u00020=2\u0006\u0010:\u001A\u00020(H\u0002\u00A2\u0006\u0004\b>\u0010?J\u0017\u0010A\u001A\u00020\u00072\u0006\u0010@\u001A\u000205H\u0002\u00A2\u0006\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010DR$\u0010I\u001A\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`H8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010JR)\u0010Q\u001A\u0010\u0012\f\u0012\n L*\u0004\u0018\u00010\u00070\u00070K8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bM\u0010N\u001A\u0004\bO\u0010PR\u0016\u0010R\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010DR\u0016\u0010S\u001A\u0002058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001A\u0002058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010TR\u0018\u0010W\u001A\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001A\u00020Y8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bZ\u0010[\u00A8\u0006^"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsAlbumFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onPause", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "fetchFilterLevel1DataArray", "fetchType", "fetchAlbumList", "(Lv9/i;)V", "Lcom/iloen/melon/net/v6x/request/ArtistContentsAlbumListReq;", "getRequestProtocol", "(Lv9/i;)Lcom/iloen/melon/net/v6x/request/ArtistContentsAlbumListReq;", "position", "getOrderType", "(I)Ljava/lang/String;", "artistId", "Ljava/lang/String;", "artistName", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "filterLevel1List", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "filterLevel2List$delegate", "Lie/j;", "getFilterLevel2List", "()Ljava/util/List;", "filterLevel2List", "mFilterLevel1Type", "mFilterLevel2Type", "I", "currentFilterLevel1Index", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "alyacFilter", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "listener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "Companion", "AlbumAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsAlbumFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010\u001ER\u0014\u0010 \u001A\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010\u001E¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsAlbumFragment$AlbumAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ALBUM;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsAlbumFragment;Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "VIEW_TYPE_SCROLlABLE_ALYAC", "I", "VIEW_TYPE_FILTER", "VIEW_TYPE_ALBUM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AlbumAdapter extends p {
        private final int VIEW_TYPE_ALBUM;
        private final int VIEW_TYPE_FILTER;
        private final int VIEW_TYPE_SCROLlABLE_ALYAC;
        @NotNull
        private final AlbumActionListener actionListener;

        public AlbumAdapter(@NotNull Context context0, @Nullable List list0, @NotNull AlbumActionListener detailContentsAlbumItemHolder$AlbumActionListener0) {
            q.g(context0, "context");
            q.g(detailContentsAlbumItemHolder$AlbumActionListener0, "actionListener");
            ArtistDetailContentsAlbumFragment.this = artistDetailContentsAlbumFragment0;
            super(context0, list0);
            this.actionListener = detailContentsAlbumItemHolder$AlbumActionListener0;
            this.VIEW_TYPE_SCROLlABLE_ALYAC = 1;
            this.VIEW_TYPE_FILTER = 2;
            this.VIEW_TYPE_ALBUM = 3;
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
            return this.getHeaderViewItemCount() <= 1 || v != this.getAvailableHeaderPosition() + 1 ? this.VIEW_TYPE_ALBUM : this.VIEW_TYPE_FILTER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof v) {
                ArrayList arrayList0 = new ArrayList(ArtistDetailContentsAlbumFragment.this.filterLevel1List);
                ((v)o00).a.a(arrayList0);
                ((v)o00).a.setSelectedIndex(ArtistDetailContentsAlbumFragment.this.currentFilterLevel1Index);
                c c0 = new c(0, ArtistDetailContentsAlbumFragment.this, this);
                E8.c c1 = new E8.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((v)o00).a.e(c0, c1);
                ArtistDetailContentsAlbumFragment.this.alyacFilter = ((v)o00).a;
                return;
            }
            if(o00 instanceof e) {
                List list0 = ArtistDetailContentsAlbumFragment.this.getFilterLevel2List();
                String s = (String)je.p.n0(ArtistDetailContentsAlbumFragment.this.mFilterLevel2Type, list0);
                ((e)o00).b.setText(s);
                Object[] arr_object = {((e)o00).b.getText()};
                String s1 = ArtistDetailContentsAlbumFragment.this.getString(0x7F130BAF, arr_object);  // string:talkback_order_change "%1$s, 정렬기준 변경"
                ViewUtils.setContentDescriptionWithButtonClassName(((e)o00).b, s1);
                d d0 = new d(ArtistDetailContentsAlbumFragment.this, ((e)o00).b, this, 0);
                ((e)o00).b.setOnClickListener(d0);
                return;
            }
            if(o00 instanceof DetailContentsAlbumItemHolder) {
                ((DetailContentsAlbumItemHolder)o00).setTotal(this.getList().size());
                ((DetailContentsAlbumItemHolder)o00).bind(((AlbumInfoBase)this.getItem(v1)), v1);
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, AlbumAdapter artistDetailContentsAlbumFragment$AlbumAdapter0, int v) {
            if(artistDetailContentsAlbumFragment0.currentFilterLevel1Index == v) {
                return;
            }
            artistDetailContentsAlbumFragment0.currentFilterLevel1Index = v;
            String s = ((j)artistDetailContentsAlbumFragment0.filterLevel1List.get(artistDetailContentsAlbumFragment0.currentFilterLevel1Index)).d;
            q.f(s, "type");
            artistDetailContentsAlbumFragment0.mFilterLevel1Type = s;
            artistDetailContentsAlbumFragment0.startFetch("alyac change");
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = artistDetailContentsAlbumFragment$AlbumAdapter0.getMenuId();
            g0.a = artistDetailContentsAlbumFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            s s1 = artistDetailContentsAlbumFragment0.mMelonTiaraProperty;
            String s2 = null;
            g0.b = s1 == null ? null : s1.a;
            s s3 = artistDetailContentsAlbumFragment0.mMelonTiaraProperty;
            g0.c = s3 == null ? null : s3.b;
            g0.d = ActionKind.ClickContent;
            g0.y = artistDetailContentsAlbumFragment0.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
            j j0 = (j)je.p.n0(v, artistDetailContentsAlbumFragment0.filterLevel1List);
            if(j0 != null) {
                s2 = j0.b;
            }
            g0.F = s2;
            g0.o = artistDetailContentsAlbumFragment0.artistId;
            g0.p = artistDetailContentsAlbumFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            g0.q = artistDetailContentsAlbumFragment0.artistName;
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$3(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, TextView textView0, AlbumAdapter artistDetailContentsAlbumFragment$AlbumAdapter0, View view0) {
            if(artistDetailContentsAlbumFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = artistDetailContentsAlbumFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(artistDetailContentsAlbumFragment0.getFilterLevel2List(), artistDetailContentsAlbumFragment0.mFilterLevel2Type);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.artistchannel.e(artistDetailContentsAlbumFragment0, textView0, artistDetailContentsAlbumFragment$AlbumAdapter0, 0));
                    bottomSingleFilterListPopup0.setOnDismissListener(artistDetailContentsAlbumFragment0.mDialogDismissListener);
                    artistDetailContentsAlbumFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$3$lambda$2(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, TextView textView0, AlbumAdapter artistDetailContentsAlbumFragment$AlbumAdapter0, int v) {
            artistDetailContentsAlbumFragment0.mFilterLevel2Type = v;
            String s = (String)je.p.n0(artistDetailContentsAlbumFragment0.mFilterLevel2Type, artistDetailContentsAlbumFragment0.getFilterLevel2List());
            textView0.setText(s);
            ViewUtils.setContentDescriptionWithButtonClassName(textView0, artistDetailContentsAlbumFragment0.getString(0x7F130BAF, new Object[]{textView0.getText()}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
            artistDetailContentsAlbumFragment0.startFetch("filter change");
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = artistDetailContentsAlbumFragment$AlbumAdapter0.getMenuId();
            g0.a = artistDetailContentsAlbumFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            s s1 = artistDetailContentsAlbumFragment0.mMelonTiaraProperty;
            String s2 = null;
            g0.b = s1 == null ? null : s1.a;
            s s3 = artistDetailContentsAlbumFragment0.mMelonTiaraProperty;
            if(s3 != null) {
                s2 = s3.b;
            }
            g0.c = s2;
            g0.d = ActionKind.ClickContent;
            g0.y = artistDetailContentsAlbumFragment0.getString(0x7F130DD9);  // string:tiara_common_layer1_album_list "앨범리스트"
            g0.F = s;
            g0.o = artistDetailContentsAlbumFragment0.artistId;
            g0.p = artistDetailContentsAlbumFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            g0.q = artistDetailContentsAlbumFragment0.artistName;
            g0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_SCROLlABLE_ALYAC) {
                return a.w(viewGroup0);
            }
            return v == this.VIEW_TYPE_FILTER ? f.p(viewGroup0, 0.0f, 6) : DetailContentsAlbumItemHolder.Companion.newInstance(viewGroup0, this.actionListener);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsAlbumFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_FILTER_LEVEL1_TYPE", "ARG_FILTER_LEVEL2_TYPE", "UNKNOWN_INDEX", "", "FIlTER_LEVEL2_TYPE_NEW", "FIlTER_LEVEL2_TYPE_POP", "FIlTER_LEVEL2_TYPE_ALPHABET", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsAlbumFragment;", "artistId", "artistName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsAlbumFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "artistId");
            q.g(s1, "artistName");
            ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0 = new ArtistDetailContentsAlbumFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            bundle0.putString("argArtistName", s1);
            artistDetailContentsAlbumFragment0.setArguments(bundle0);
            return artistDetailContentsAlbumFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_LEVEL1_TYPE = "argFilterLevel1Type";
    @NotNull
    private static final String ARG_FILTER_LEVEL2_TYPE = "argFilterLevel2Type";
    @NotNull
    public static final Companion Companion = null;
    private static final int FIlTER_LEVEL2_TYPE_ALPHABET = 2;
    private static final int FIlTER_LEVEL2_TYPE_NEW = 0;
    private static final int FIlTER_LEVEL2_TYPE_POP = 1;
    @NotNull
    private static final String TAG = "ArtistInfoAlbumFragment";
    private static final int UNKNOWN_INDEX = -1;
    @Nullable
    private ScrollableAlyacFilter alyacFilter;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    private int currentFilterLevel1Index;
    @NotNull
    private final ArrayList filterLevel1List;
    @NotNull
    private final ie.j filterLevel2List$delegate;
    @NotNull
    private final AlbumActionListener listener;
    @NotNull
    private String mFilterLevel1Type;
    private int mFilterLevel2Type;

    static {
        ArtistDetailContentsAlbumFragment.Companion = new Companion(null);
        ArtistDetailContentsAlbumFragment.$stable = 8;
    }

    public ArtistDetailContentsAlbumFragment() {
        this.artistId = "";
        this.artistName = "";
        this.filterLevel1List = new ArrayList();
        this.filterLevel2List$delegate = d3.g.Q(new com.iloen.melon.fragments.artistchannel.a(this, 0));
        this.mFilterLevel1Type = "";
        this.currentFilterLevel1Index = -1;
        this.listener = new AlbumActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onClickAlbum(AlbumInfoBase albumInfoBase0, int v) {
                if(albumInfoBase0 != null) {
                    String s = albumInfoBase0.albumId;
                    if(s != null && s.length() != 0) {
                        ArtistDetailContentsAlbumFragment.this.showAlbumInfoPage(s);
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        g0.I = ArtistDetailContentsAlbumFragment.this.getMenuId();
                        g0.a = ArtistDetailContentsAlbumFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        s s1 = ArtistDetailContentsAlbumFragment.this.mMelonTiaraProperty;
                        String s2 = null;
                        g0.b = s1 == null ? null : s1.a;
                        s s3 = ArtistDetailContentsAlbumFragment.this.mMelonTiaraProperty;
                        if(s3 != null) {
                            s2 = s3.b;
                        }
                        g0.c = s2;
                        g0.d = ActionKind.ClickContent;
                        g0.y = ArtistDetailContentsAlbumFragment.this.getString(0x7F130DD9);  // string:tiara_common_layer1_album_list "앨범리스트"
                        g0.C = String.valueOf(v + 1);
                        g0.e = s;
                        g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                        g0.g = albumInfoBase0.albumName;
                        g0.h = ProtocolUtils.getArtistNames(albumInfoBase0.artistList);
                        g0.o = ArtistDetailContentsAlbumFragment.this.artistId;
                        g0.p = ArtistDetailContentsAlbumFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                        g0.q = ArtistDetailContentsAlbumFragment.this.artistName;
                        g0.a().track();
                    }
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onLongClickAlbum(AlbumInfoBase albumInfoBase0, int v) {
                if(albumInfoBase0 != null) {
                    Playable playable0 = Playable.from(albumInfoBase0, ArtistDetailContentsAlbumFragment.this.getMenuId(), null);
                    ArtistDetailContentsAlbumFragment.access$showContextPopupAlbum(ArtistDetailContentsAlbumFragment.this, playable0);
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder$AlbumActionListener
            public void onPlayAlbum(AlbumInfoBase albumInfoBase0, int v) {
                String s = null;
                if(albumInfoBase0 != null) {
                    if(albumInfoBase0.canService) {
                        String s1 = albumInfoBase0.albumId;
                        if(s1 != null && s1.length() != 0) {
                            String s2 = ArtistDetailContentsAlbumFragment.this.getMenuId();
                            ArtistDetailContentsAlbumFragment.this.playAlbum(s1, s2);
                            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                            g0.I = ArtistDetailContentsAlbumFragment.this.getMenuId();
                            g0.a = ArtistDetailContentsAlbumFragment.this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                            s s3 = ArtistDetailContentsAlbumFragment.this.mMelonTiaraProperty;
                            g0.b = s3 == null ? null : s3.a;
                            s s4 = ArtistDetailContentsAlbumFragment.this.mMelonTiaraProperty;
                            if(s4 != null) {
                                s = s4.b;
                            }
                            g0.c = s;
                            g0.d = ActionKind.PlayMusic;
                            g0.y = ArtistDetailContentsAlbumFragment.this.getString(0x7F130DD9);  // string:tiara_common_layer1_album_list "앨범리스트"
                            g0.C = String.valueOf(v + 1);
                            g0.e = s1;
                            g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                            g0.g = albumInfoBase0.albumName;
                            g0.h = ProtocolUtils.getArtistNames(albumInfoBase0.artistList);
                            g0.o = ArtistDetailContentsAlbumFragment.this.artistId;
                            g0.p = ArtistDetailContentsAlbumFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                            g0.q = ArtistDetailContentsAlbumFragment.this.artistName;
                            g0.a().track();
                        }
                    }
                    else {
                        Playable playable0 = Playable.from(albumInfoBase0, ArtistDetailContentsAlbumFragment.this.getMenuId(), null);
                        ArtistDetailContentsAlbumFragment.access$showContextPopupAlbum(ArtistDetailContentsAlbumFragment.this, playable0);
                    }
                }
            }
        };
    }

    public static final void access$showContextPopupAlbum(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, Playable playable0) {
        artistDetailContentsAlbumFragment0.showContextPopupAlbum(playable0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 1000);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new AlbumAdapter(this, context0, null, this.listener);
        ((com.iloen.melon.adapters.common.j)j00).setMarkedMode(false);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(2);
        return j00;
    }

    private final void fetchAlbumList(i i0) {
        RequestBuilder.newInstance(this.getRequestProtocol(i0)).tag(this.getRequestTag()).listener(new c(4, this, i0)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void fetchAlbumList$lambda$10(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, i i0, ArtistDetailContentsAlbumRes artistDetailContentsAlbumRes0) {
        if(!artistDetailContentsAlbumFragment0.prepareFetchComplete(artistDetailContentsAlbumRes0)) {
            return;
        }
        artistDetailContentsAlbumFragment0.mMelonTiaraProperty = new s(artistDetailContentsAlbumRes0.response.section, artistDetailContentsAlbumRes0.response.page, artistDetailContentsAlbumRes0.response.menuId, null);
        artistDetailContentsAlbumFragment0.performFetchComplete(i0, artistDetailContentsAlbumRes0);
    }

    private final void fetchFilterLevel1DataArray() {
        this.filterLevel1List.clear();
        RequestBuilder.newInstance(new ArtistMusicAlbumFilterListReq(this.getContext(), this.artistId)).tag(this.getRequestTag()).listener(new b(this)).errorListener(new b(this)).request();
    }

    private static final void fetchFilterLevel1DataArray$lambda$8(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, ArtistMusicAlbumFilterListRes artistMusicAlbumFilterListRes0) {
        q.g(artistMusicAlbumFilterListRes0, "response");
        boolean z = artistDetailContentsAlbumFragment0.isFragmentValid();
        i i0 = i.b;
        if(z) {
            Cb.j.b(artistMusicAlbumFilterListRes0.notification, false, 3);
            if(Cb.j.d(artistMusicAlbumFilterListRes0)) {
                ArrayList arrayList0 = artistMusicAlbumFilterListRes0.response == null ? null : artistMusicAlbumFilterListRes0.response.filterList;
                if(arrayList0 != null && !arrayList0.isEmpty() == 1) {
                    for(Object object0: arrayList0) {
                        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j0.b = ((FILTERLIST)object0).filterName;
                        j0.d = ((FILTERLIST)object0).filterCode;
                        artistDetailContentsAlbumFragment0.filterLevel1List.add(j0);
                    }
                    if(o.H0(artistDetailContentsAlbumFragment0.mFilterLevel1Type)) {
                        artistDetailContentsAlbumFragment0.currentFilterLevel1Index = 0;
                        String s = ((j)artistDetailContentsAlbumFragment0.filterLevel1List.get(0)).d;
                        q.f(s, "type");
                        artistDetailContentsAlbumFragment0.mFilterLevel1Type = s;
                    }
                    else {
                        int v = 0;
                        for(Object object1: artistDetailContentsAlbumFragment0.filterLevel1List) {
                            if(v >= 0) {
                                if(q.b(((j)object1).c, artistDetailContentsAlbumFragment0.mFilterLevel1Type)) {
                                    artistDetailContentsAlbumFragment0.currentFilterLevel1Index = v;
                                }
                                ++v;
                                continue;
                            }
                            k.O();
                            throw null;
                        }
                    }
                    if(artistDetailContentsAlbumFragment0.currentFilterLevel1Index <= -1) {
                        artistDetailContentsAlbumFragment0.currentFilterLevel1Index = 0;
                        String s1 = ((j)artistDetailContentsAlbumFragment0.filterLevel1List.get(0)).d;
                        q.f(s1, "type");
                        artistDetailContentsAlbumFragment0.mFilterLevel1Type = s1;
                    }
                }
                artistDetailContentsAlbumFragment0.fetchAlbumList(i0);
                return;
            }
        }
        artistDetailContentsAlbumFragment0.fetchAlbumList(i0);
    }

    private static final void fetchFilterLevel1DataArray$lambda$9(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0, VolleyError volleyError0) {
        LogU.Companion.w("ArtistInfoAlbumFragment", "fetchFilterLevel1DataArray() >> onErrorResponse() " + volleyError0);
        artistDetailContentsAlbumFragment0.fetchAlbumList(i.b);
    }

    private static final List filterLevel2List_delegate$lambda$0(ArtistDetailContentsAlbumFragment artistDetailContentsAlbumFragment0) {
        String[] arr_s;
        Context context0 = artistDetailContentsAlbumFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030002);  // array:artist_channel_album_tab_filter_level2
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : w.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b.buildUpon().appendPath("ALBUM").appendPath(this.artistId).appendQueryParameter("filterLevel1Type", this.mFilterLevel1Type).appendQueryParameter("filterLevel2Type", String.valueOf(this.mFilterLevel2Type)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterLevel2List() {
        return (List)this.filterLevel2List$delegate.getValue();
    }

    private final String getOrderType(int v) {
        switch(v) {
            case 1: {
                return "POP";
            }
            case 2: {
                return "ALPHABET";
            }
            default: {
                return "NEW";
            }
        }
    }

    private final ArtistContentsAlbumListReq getRequestProtocol(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsAlbumFragment.AlbumAdapter");
        Params artistContentsAlbumListReq$Params0 = new Params();
        artistContentsAlbumListReq$Params0.startIndex = i.b.equals(i0) ? 1 : ((AlbumAdapter)j00).getCount() + 1;
        artistContentsAlbumListReq$Params0.filterBy = this.mFilterLevel1Type;
        artistContentsAlbumListReq$Params0.orderBy = this.getOrderType(this.mFilterLevel2Type);
        artistContentsAlbumListReq$Params0.pageSize = 100;
        artistContentsAlbumListReq$Params0.artistId = this.artistId;
        return new ArtistContentsAlbumListReq(this.getContext(), artistContentsAlbumListReq$Params0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailContentsAlbumFragment newInstance(@NotNull String s, @NotNull String s1) {
        return ArtistDetailContentsAlbumFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ScrollableAlyacFilter scrollableAlyacFilter0 = this.alyacFilter;
        if(scrollableAlyacFilter0 != null) {
            scrollableAlyacFilter0.c(this.currentFilterLevel1Index);
        }
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
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsAlbumFragment.AlbumAdapter");
        if(i.b.equals(i0)) {
            ((AlbumAdapter)j00).clear();
            if(this.filterLevel1List.isEmpty()) {
                this.fetchFilterLevel1DataArray();
                return true;
            }
            this.fetchAlbumList(i0);
            return true;
        }
        this.fetchAlbumList(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
        if(bundle0.containsKey("argFilterLevel1Type")) {
            String s = bundle0.getString("argFilterLevel1Type", "");
            q.f(s, "getString(...)");
            this.mFilterLevel1Type = s;
        }
        if(bundle0.containsKey("argFilterLevel2Type")) {
            this.mFilterLevel2Type = bundle0.getInt("argFilterLevel2Type", 0);
        }
        if(bundle0.containsKey("argArtistName")) {
            String s1 = bundle0.getString("argArtistName", "");
            q.f(s1, "getString(...)");
            this.artistName = s1;
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
        bundle0.putString("argFilterLevel1Type", this.mFilterLevel1Type);
        bundle0.putInt("argFilterLevel2Type", this.mFilterLevel2Type);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        super.onToolBarClick(toolBar$ToolBarItem0, v);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = true;
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F130126));  // string:artist_detail_contents_album_title "앨범"
        }
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        if(this.getItemCount() != 0) {
            z = false;
        }
        ViewUtils.showWhen(view1, z);
    }
}

