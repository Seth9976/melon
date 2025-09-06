package com.iloen.melon.fragments.comments;

import Ad.s;
import De.I;
import E8.c;
import F8.O;
import F8.x;
import J8.K1;
import J8.a2;
import J8.u1;
import J8.u;
import J8.w;
import Tf.v;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.TranslationParallaxContainer;
import com.iloen.melon.custom.TranslationParallaxView;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.CmtTypes.SortType;
import com.iloen.melon.net.v3x.comments.InsertCmtReq.Params.AtachList;
import com.iloen.melon.net.v3x.comments.InsertCmtReq.Params;
import com.iloen.melon.net.v3x.comments.InsertCmtReq;
import com.iloen.melon.net.v3x.comments.InsertCmtRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO.LinkInfo;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.popup.b;
import e.k;
import ie.H;
import ie.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import v9.i;
import v9.j;
import va.e0;
import x1.a;

@d
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 P2\u00020\u0001:\u0003PQRB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u000F\u0010\u0015\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u0003J\u0017\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b$\u0010\u0003J\u000F\u0010%\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b%\u0010\u0003J\u000F\u0010&\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b&\u0010\u0003J\u0019\u0010)\u001A\u00020\u00112\b\u0010(\u001A\u0004\u0018\u00010\'H\u0002\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010,\u001A\u00020+H\u0002\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b.\u0010\u0003J\u000F\u0010/\u001A\u00020+H\u0002\u00A2\u0006\u0004\b/\u0010-J\u000F\u00100\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b0\u0010\u0003J\u000F\u00101\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b1\u0010\u0003J\u0017\u00104\u001A\u00020\u00112\u0006\u00103\u001A\u000202H\u0002\u00A2\u0006\u0004\b4\u00105J\u001B\u00107\u001A\u0002022\n\b\u0002\u00106\u001A\u0004\u0018\u00010\'H\u0002\u00A2\u0006\u0004\b7\u00108J\u0017\u0010:\u001A\u00020\u00112\u0006\u00109\u001A\u00020+H\u0002\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010<\u001A\u00020\u00112\u0006\u00109\u001A\u00020+H\u0002\u00A2\u0006\u0004\b<\u0010;J\u0017\u0010=\u001A\u00020\u00112\u0006\u00109\u001A\u00020+H\u0002\u00A2\u0006\u0004\b=\u0010;R\u0018\u0010?\u001A\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001A\u00020A8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bB\u0010CR&\u0010G\u001A\u0012\u0012\u0004\u0012\u00020E0Dj\b\u0012\u0004\u0012\u00020E`F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001A\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010O\u001A\u00020>8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bM\u0010N\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentListRenewalFragment;", "Lcom/iloen/melon/fragments/comments/CmtListFragment;", "<init>", "()V", "", "shouldShowMiniPlayer", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "performFetchCompleteOnlyViews", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "updateSortBarView", "count", "updateCmtAllCount", "(I)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "onPause", "initTitleBarType", "initInputType", "Landroid/text/Editable;", "inputText", "showInputPopup", "(Landroid/text/Editable;)V", "", "getTitle", "()Ljava/lang/String;", "initAlyacFilter", "getCurrentFilterText", "updateSortInfo", "showContextPopupSort", "Lcom/iloen/melon/fragments/comments/CommentInputPopup;", "popup", "setInputPopupMinMaxLength", "(Lcom/iloen/melon/fragments/comments/CommentInputPopup;)V", "initText", "initInputPopup", "(Landroid/text/Editable;)Lcom/iloen/melon/fragments/comments/CommentInputPopup;", "message", "performRegister", "(Ljava/lang/String;)V", "sendComment", "setInputMessage", "LJ8/w;", "_binding", "LJ8/w;", "LJ8/u1;", "bindingHeaderView", "LJ8/u1;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "alaycFilterData", "Ljava/util/ArrayList;", "sortType", "I", "inputPopupWindow", "Lcom/iloen/melon/fragments/comments/CommentInputPopup;", "getBinding", "()LJ8/w;", "binding", "Companion", "CommentListRenewalAdapter", "ViewHolderHeader", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class CommentListRenewalFragment extends CmtListFragment {
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B#\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0011\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\"\u001A\u00020\u00032\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\"\u0010#J)\u0010&\u001A\u00020%2\b\u0010$\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u0018H\u0016¢\u0006\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentListRenewalFragment$CommentListRenewalAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/comments/CommentListRenewalFragment;Landroid/content/Context;Ljava/util/List;)V", "", "hasParentLink", "()Z", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes$result$CHNLINFO$LinkInfo;", "getParentLinkInfo", "()Lcom/iloen/melon/net/v3x/comments/LoadPgnRes$result$CHNLINFO$LinkInfo;", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER_LINK", "I", "VIEW_TYPE_LIST_ITEM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class CommentListRenewalAdapter extends p {
        private final int VIEW_TYPE_HEADER_LINK;
        private final int VIEW_TYPE_LIST_ITEM;

        public CommentListRenewalAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.VIEW_TYPE_HEADER_LINK = 1;
            this.VIEW_TYPE_LIST_ITEM = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.hasParentLink();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_LIST_ITEM : this.VIEW_TYPE_HEADER_LINK;
        }

        private final LinkInfo getParentLinkInfo() {
            LoadPgnRes loadPgnRes0 = CommentListRenewalFragment.this.mLoadPgnRes;
            if(loadPgnRes0 != null) {
                result loadPgnRes$result0 = loadPgnRes0.result;
                if(loadPgnRes$result0 != null) {
                    return loadPgnRes$result0.chnlinfo == null ? null : loadPgnRes$result0.chnlinfo.contsRefLinkInfo;
                }
            }
            return null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(!(httpResponse0 instanceof ListCmtRes)) {
                return false;
            }
            boolean z = true;
            com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result0 = ((ListCmtRes)httpResponse0).result;
            if(listCmtRes$result0 != null) {
                if(listCmtRes$result0.cmtlist == null || !listCmtRes$result0.cmtlist.isEmpty()) {
                label_11:
                    CmtResViewModel cmtResViewModel0 = new CmtResViewModel();
                    cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.toplist, CommentListRenewalFragment.this.mParam.chnlSeq, CommentListRenewalFragment.this.mParam.contsRefValue, CommentListRenewalFragment.this.mParam.isReadOnly, CommentListRenewalFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
                    cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.cmtlist, CommentListRenewalFragment.this.mParam.chnlSeq, CommentListRenewalFragment.this.mParam.contsRefValue, CommentListRenewalFragment.this.mParam.isReadOnly, CommentListRenewalFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
                    this.addAll(cmtResViewModel0.result.cmtlist);
                    if(((ListCmtRes)httpResponse0).result.pageinfo.pageno >= ((ListCmtRes)httpResponse0).result.paginginfo.nextpageno) {
                        z = false;
                    }
                    this.setHasMore(z);
                    this.setMenuId(httpResponse0.getMenuId());
                    this.updateModifiedTime(s);
                    if(CommentListRenewalFragment.this.mFilterType == 0 && i.b.equals(i0)) {
                        int v = CommentListRenewalFragment.this.mParam.chnlSeq;
                        String s1 = CommentListRenewalFragment.this.mParam.contsRefValue;
                        PAGEINFO listCmtRes$result$PAGEINFO0 = ((ListCmtRes)httpResponse0).result.pageinfo;
                        CmtHelper.setLatestComment(v, s1, (listCmtRes$result$PAGEINFO0 == null ? -1 : listCmtRes$result$PAGEINFO0.startseq));
                    }
                }
                else {
                    ArrayList arrayList0 = ((ListCmtRes)httpResponse0).result.toplist;
                    if(arrayList0 == null || !arrayList0.isEmpty()) {
                        goto label_11;
                    }
                }
            }
            return false;
        }

        private final boolean hasParentLink() {
            Param cmtBaseFragment$Param0 = CommentListRenewalFragment.this.mParam;
            com.iloen.melon.fragments.comments.CmtListFragment.Param cmtListFragment$Param0 = cmtBaseFragment$Param0 instanceof com.iloen.melon.fragments.comments.CmtListFragment.Param ? ((com.iloen.melon.fragments.comments.CmtListFragment.Param)cmtBaseFragment$Param0) : null;
            return cmtListFragment$Param0 != null && cmtListFragment$Param0.hasParentLink && this.getParentLinkInfo() != null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            cmtList cmtResViewModel$result$cmtList0 = (cmtList)this.getItem(v1);
            if(o00 instanceof CommentListRenewalViewHolder && cmtResViewModel$result$cmtList0 != null) {
                ((CommentListRenewalViewHolder)o00).bindView(cmtResViewModel$result$cmtList0, v, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(this.VIEW_TYPE_HEADER_LINK == v) {
                View view0 = o.e(viewGroup0, 0x7F0D0493, viewGroup0, false);  // layout:listitem_header_contents_link
                int v1 = 0x7F0A00AF;  // id:arrow_icon
                if(((ImageView)I.C(view0, 0x7F0A00AF)) != null) {  // id:arrow_icon
                    v1 = 0x7F0A033C;  // id:content_title
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A033C);  // id:content_title
                    if(melonTextView0 != null) {
                        v1 = 0x7F0A0D66;  // id:type_title
                        MelonTextView melonTextView1 = (MelonTextView)I.C(view0, 0x7F0A0D66);  // id:type_title
                        if(melonTextView1 != null) {
                            O0 o00 = new ViewHolderHeader(new a2(((ConstraintLayout)view0), melonTextView0, melonTextView1));
                            CommentListRenewalFragment commentListRenewalFragment0 = CommentListRenewalFragment.this;
                            LinkInfo loadPgnRes$result$CHNLINFO$LinkInfo0 = this.getParentLinkInfo();
                            if(loadPgnRes$result$CHNLINFO$LinkInfo0 != null) {
                                ((ViewHolderHeader)o00).getBind().b.setText(loadPgnRes$result$CHNLINFO$LinkInfo0.contsRefName);
                                ((ViewHolderHeader)o00).getBind().c.setText(" " + loadPgnRes$result$CHNLINFO$LinkInfo0.text1);
                                s s0 = new s(21, loadPgnRes$result$CHNLINFO$LinkInfo0, commentListRenewalFragment0);
                                a.N(o00.itemView, s0);
                            }
                            return o00;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
            }
            return new CommentListRenewalViewHolder(K1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), CommentListRenewalFragment.this);
        }

        private static final void onCreateViewHolderImpl$lambda$2$lambda$1$lambda$0(LinkInfo loadPgnRes$result$CHNLINFO$LinkInfo0, CommentListRenewalFragment commentListRenewalFragment0, View view0) {
            MelonLinkExecutor.open(loadPgnRes$result$CHNLINFO$LinkInfo0.link);
            commentListRenewalFragment0.performBackPress();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentListRenewalFragment$Companion;", "", "<init>", "()V", "TAG", "", "ORDER_BY_NEW", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentListRenewalFragment$ViewHolderHeader;", "Landroidx/recyclerview/widget/O0;", "LJ8/a2;", "binding", "<init>", "(LJ8/a2;)V", "bind", "LJ8/a2;", "getBind", "()LJ8/a2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolderHeader extends O0 {
        @NotNull
        private final a2 bind;

        public ViewHolderHeader(@NotNull a2 a20) {
            q.g(a20, "binding");
            super(a20.a);
            this.bind = a20;
        }

        @NotNull
        public final a2 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int ORDER_BY_NEW = 0;
    @NotNull
    public static final String TAG = "CommentListRenewalFragment";
    @Nullable
    private w _binding;
    private ArrayList alaycFilterData;
    private u1 bindingHeaderView;
    @Nullable
    private CommentInputPopup inputPopupWindow;
    private int sortType;

    static {
        CommentListRenewalFragment.Companion = new Companion(null);
        CommentListRenewalFragment.$stable = 8;
    }

    public static void B0(CommentListRenewalFragment commentListRenewalFragment0, String[] arr_s, int v) {
        CommentListRenewalFragment.showContextPopupSort$lambda$13(commentListRenewalFragment0, arr_s, v);
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = this.getLayoutInflater().inflate(0x7F0D044E, null, false);  // layout:list_header_filer_sort_complex
        int v = 0x7F0A0A31;  // id:scrollable_alyac_filter
        View view1 = I.C(view0, 0x7F0A0A31);  // id:scrollable_alyac_filter
        if(((ScrollableAlyacFilter)view1) != null) {
            v = 0x7F0A0C98;  // id:tv_left_desc
            View view2 = I.C(view0, 0x7F0A0C98);  // id:tv_left_desc
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A0CD5;  // id:tv_order_by
                View view3 = I.C(view0, 0x7F0A0CD5);  // id:tv_order_by
                if(((MelonTextView)view3) != null) {
                    v = 0x7F0A0D6B;  // id:underline
                    View view4 = I.C(view0, 0x7F0A0D6B);  // id:underline
                    if(view4 != null) {
                        this.bindingHeaderView = new u1(((LinearLayout)view0), ((ScrollableAlyacFilter)view1), ((MelonTextView)view2), ((MelonTextView)view3), view4);
                        q.f(((LinearLayout)view0), "getRoot(...)");
                        this.initAlyacFilter();
                        this.updateCmtAllCount(this.mCmtAllCount);
                        u1 u10 = this.bindingHeaderView;
                        if(u10 != null) {
                            n n0 = new n(this, 0);
                            a.N(u10.d, n0);
                            this.updateSortInfo();
                            return (LinearLayout)view0;
                        }
                        q.m("bindingHeaderView");
                        throw null;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    private static final void buildParallaxHeaderView$lambda$7(CommentListRenewalFragment commentListRenewalFragment0, View view0) {
        commentListRenewalFragment0.showContextPopupSort();
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new CommentListRenewalAdapter(this, context0, null);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1301E0);  // string:cmt_empty_text "등록된 댓글이 없습니다."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private final w getBinding() {
        w w0 = this._binding;
        q.d(w0);
        return w0;
    }

    private final String getCurrentFilterText() {
        ArrayList arrayList0 = this.alaycFilterData;
        if(arrayList0 != null) {
            j j0 = (j)je.p.n0(this.mCurrentFilterIndex, arrayList0);
            if(j0 != null) {
                return j0.b == null ? "" : j0.b;
            }
            return "";
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 38.0f);
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public int getParallaxHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 94.0f);
    }

    private final String getTitle() {
        switch(this.mParam.chnlSeq) {
            case 101: {
                q.f("팬톡", "getString(...)");
                return "팬톡";
            }
            case 102: {
                return "앨범 댓글";
            }
            case 103: {
                return "곡 댓글";
            }
            default: {
                q.f("댓글", "getString(...)");
                return "댓글";
            }
        }
    }

    private final void initAlyacFilter() {
        boolean z;
        if(this.mLoadPgnRes != null) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            Context context0 = this.getContext();
            j0.b = context0 == null || context0.getResources() == null ? null : "전체";
            j0.c = "0";
            j j1 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            Context context1 = this.getContext();
            j1.b = context1 == null || context1.getResources() == null ? null : "내 댓글";
            j1.c = "1";
            ArrayList arrayList0 = k.e(new j[]{j0, j1});
            this.alaycFilterData = arrayList0;
            LoadPgnRes loadPgnRes0 = this.mLoadPgnRes;
            if(loadPgnRes0 == null) {
                z = false;
            }
            else {
                result loadPgnRes$result0 = loadPgnRes0.result;
                if(loadPgnRes$result0 == null) {
                    z = false;
                }
                else {
                    CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                    z = loadPgnRes$result$CHNLINFO0 == null ? false : loadPgnRes$result$CHNLINFO0.playFilterUseFlag;
                }
            }
            if(z) {
                j j2 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                Context context2 = this.getContext();
                j2.b = context2 == null || context2.getResources() == null ? null : "감상자";
                j2.c = "2";
                arrayList0.add(1, j2);
            }
            u1 u10 = this.bindingHeaderView;
            if(u10 == null) {
                q.m("bindingHeaderView");
                throw null;
            }
            u10.b.setSelectedIndex(this.mCurrentFilterIndex);
            u1 u11 = this.bindingHeaderView;
            if(u11 == null) {
                q.m("bindingHeaderView");
                throw null;
            }
            ScrollableAlyacFilter scrollableAlyacFilter0 = u11.b;
            ArrayList arrayList1 = this.alaycFilterData;
            if(arrayList1 == null) {
                q.m("alaycFilterData");
                throw null;
            }
            else if(scrollableAlyacFilter0.d(arrayList1)) {
                u1 u12 = this.bindingHeaderView;
                if(u12 != null) {
                    g g0 = new g(this);
                    c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
                    u12.b.e(g0, c0);
                    return;
                }
                q.m("bindingHeaderView");
                throw null;
            }
        }
    }

    private static final void initAlyacFilter$lambda$11(CommentListRenewalFragment commentListRenewalFragment0, int v) {
        int v1;
        if(v == commentListRenewalFragment0.mCurrentFilterIndex) {
            return;
        }
        ArrayList arrayList0 = commentListRenewalFragment0.alaycFilterData;
        if(arrayList0 != null) {
            j j0 = (j)je.p.n0(v, arrayList0);
            if(j0 == null) {
                v1 = 0;
            }
            else {
                String s = j0.c;
                v1 = s == null ? 0 : Integer.parseInt(s);
            }
            if(v1 == 1 && !((e0)va.o.a()).m()) {
                u1 u10 = commentListRenewalFragment0.bindingHeaderView;
                if(u10 != null) {
                    u10.b.a(null);
                    commentListRenewalFragment0.initAlyacFilter();
                    commentListRenewalFragment0.showLoginPopup();
                    return;
                }
                q.m("bindingHeaderView");
                throw null;
            }
            commentListRenewalFragment0.mCurrentFilterIndex = v;
            commentListRenewalFragment0.mFilterType = v1;
            u1 u11 = commentListRenewalFragment0.bindingHeaderView;
            if(u11 != null) {
                u11.c.setText("");
                if(commentListRenewalFragment0.mFilterType == 0) {
                    u1 u12 = commentListRenewalFragment0.bindingHeaderView;
                    if(u12 != null) {
                        u12.c.setVisibility(0);
                        goto label_37;
                    }
                    q.m("bindingHeaderView");
                    throw null;
                }
                u1 u13 = commentListRenewalFragment0.bindingHeaderView;
                if(u13 != null) {
                    u13.c.setVisibility(8);
                label_37:
                    String s1 = commentListRenewalFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    String s2 = commentListRenewalFragment0.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                    String s3 = v.p0(commentListRenewalFragment0.getCurrentFilterText(), " ", "");
                    commentListRenewalFragment0.itemClickLog(s1, ActionKind.ClickContent, s2, s3, false, null, null, null);
                    commentListRenewalFragment0.clearListItems();
                    commentListRenewalFragment0.startFetch("onFilterSelected");
                    return;
                }
                q.m("bindingHeaderView");
                throw null;
            }
            q.m("bindingHeaderView");
            throw null;
        }
        q.m("alaycFilterData");
        throw null;
    }

    private final CommentInputPopup initInputPopup(Editable editable0) {
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        CommentInputPopup commentInputPopup0 = new CommentInputPopup(context0, editable0, new OnEventListener() {
            @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
            public void onDismissEvent(Editable editable0) {
                q.g(editable0, "message");
                ((MelonEditText)CommentListRenewalFragment.this.getBinding().c.d).setText(editable0);
                ((MelonTextView)CommentListRenewalFragment.this.getBinding().c.b).setEnabled(editable0.length() > 0);
            }

            @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
            public void onSendEvent(String s) {
                q.g(s, "message");
                CommentListRenewalFragment.this.performRegister(s);
            }
        }, false, 8, null);
        commentInputPopup0.setOnShowListener(new com.iloen.melon.fragments.comments.d(this, 1));
        commentInputPopup0.setOnDismissListener(new com.iloen.melon.fragments.comments.e(this, 1));
        return commentInputPopup0;
    }

    public static CommentInputPopup initInputPopup$default(CommentListRenewalFragment commentListRenewalFragment0, Editable editable0, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initInputPopup");
        }
        if((v & 1) != 0) {
            editable0 = null;
        }
        return commentListRenewalFragment0.initInputPopup(editable0);
    }

    private static final void initInputPopup$lambda$19$lambda$17(CommentListRenewalFragment commentListRenewalFragment0, DialogInterface dialogInterface0) {
        w w0 = commentListRenewalFragment0.getBinding();
        q.f(((LinearLayout)w0.c.c), "getRoot(...)");
        ((LinearLayout)w0.c.c).setVisibility(8);
    }

    private static final void initInputPopup$lambda$19$lambda$18(CommentListRenewalFragment commentListRenewalFragment0, DialogInterface dialogInterface0) {
        w w0 = commentListRenewalFragment0.getBinding();
        q.f(((LinearLayout)w0.c.c), "getRoot(...)");
        ((LinearLayout)w0.c.c).setVisibility(0);
    }

    private final void initInputType() {
        if(this.isFragmentAddable()) {
            ((LinearLayout)this.getBinding().c.c).setVisibility(0);
            this.inputPopupWindow = CommentListRenewalFragment.initInputPopup$default(this, null, 1, null);
            w w0 = this.getBinding();
            n n0 = new n(this, 2);
            a.N(((MelonEditText)w0.c.d), n0);
            w w1 = this.getBinding();
            n n1 = new n(this, 3);
            a.N(((MelonTextView)w1.c.b), n1);
        }
    }

    private static final void initInputType$lambda$4(CommentListRenewalFragment commentListRenewalFragment0, View view0) {
        commentListRenewalFragment0.showInputPopup(((MelonEditText)commentListRenewalFragment0.getBinding().c.d).getText());
    }

    private static final void initInputType$lambda$5(CommentListRenewalFragment commentListRenewalFragment0, View view0) {
        commentListRenewalFragment0.performRegister(String.valueOf(((MelonEditText)commentListRenewalFragment0.getBinding().c.d).getText()));
    }

    private final void initTitleBarType() {
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setBackgroundColor(ColorUtils.getColor(titleBar0.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            x x0 = new x(1);
            O o0 = new O((this.isFragmentAddable() ? 16.0f : 20.0f));
            F8.o o1 = B.a.s(1);
            x0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(CommentListRenewalFragment.this.isFragmentAddable()) {
                        CommentInputPopup commentInputPopup0 = CommentListRenewalFragment.this.inputPopupWindow;
                        if(commentInputPopup0 != null) {
                            commentInputPopup0.show();
                        }
                        return;
                    }
                    if(!NetUtils.isConnected()) {
                        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                        return;
                    }
                    if(!((e0)va.o.a()).m()) {
                        CommentListRenewalFragment.this.showLoginPopup();
                        return;
                    }
                    CommentListRenewalFragment commentListRenewalFragment0 = CommentListRenewalFragment.this;
                    if(commentListRenewalFragment0.mLoadPgnRes != null && (commentListRenewalFragment0.mLoadPgnRes.result != null && (commentListRenewalFragment0.mLoadPgnRes.result.chnlinfo != null && commentListRenewalFragment0.mLoadPgnRes.result.chnlinfo.checkArtistFanFlag) && (commentListRenewalFragment0.mLoadPgnRes.result.myMemberInfo == null || !commentListRenewalFragment0.mLoadPgnRes.result.myMemberInfo.artistFanFlag))) {
                        FragmentActivity fragmentActivity0 = commentListRenewalFragment0.getActivity();
                        String s = null;
                        l0 l00 = fragmentActivity0 == null ? null : fragmentActivity0.getSupportFragmentManager();
                        String s1 = CommentListRenewalFragment.this.getActivity() == null ? null : "안내";
                        if(CommentListRenewalFragment.this.getActivity() != null) {
                            s = "글쓰기는 팬맺기 후에 가능합니다.";
                        }
                        b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                        return;
                    }
                    String s2 = commentListRenewalFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    String s3 = CommentListRenewalFragment.this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                    String s4 = CommentListRenewalFragment.this.getString(0x7F130DB4);  // string:tiara_click_copy_write "글쓰기"
                    commentListRenewalFragment0.itemClickLog(s2, ActionKind.ClickContent, s3, s4, false, null, null, null);
                    CommentListRenewalFragment.this.openCmtWriteView();
                }
            };
            o0.c = new n(this, 1);
            String s = null;
            com.iloen.melon.fragments.comments.CmtListFragment.Param cmtListFragment$Param0 = this.mParam instanceof com.iloen.melon.fragments.comments.CmtListFragment.Param ? ((com.iloen.melon.fragments.comments.CmtListFragment.Param)this.mParam) : null;
            if(cmtListFragment$Param0 != null) {
                s = cmtListFragment$Param0.headerTitle;
            }
            if(this.isFragmentAddable()) {
                titleBar0.setPadding(0, ScreenUtils.dipToPixel(titleBar0.getContext(), 6.0f), 0, 0);
                titleBar0.c(60.0f);
                if(s == null || s.length() == 0) {
                    s = this.getTitle();
                }
                F8.q q0 = new F8.q(s);
                q0.g(o0);
                titleBar0.a(q0);
            }
            else {
                o1.g(x0);
                o1.g(o0);
                titleBar0.a(o1);
                if(s == null || s.length() == 0) {
                    s = this.getTitle();
                }
                titleBar0.setTitle(s);
            }
            titleBar0.f(false);
        }
    }

    private static final void initTitleBarType$lambda$3$lambda$2(CommentListRenewalFragment commentListRenewalFragment0, View view0) {
        commentListRenewalFragment0.refreshList();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D0190, viewGroup0, false);  // layout:comment_list_main_layout
        int v = 0x7F0A00E6;  // id:background
        View view1 = I.C(view0, 0x7F0A00E6);  // id:background
        if(view1 != null && ((FrameLayout)I.C(view0, 0x7F0A00E7)) != null) {  // id:background_container
            v = 0x7F0A02F8;  // id:comment_input_layout
            View view2 = I.C(view0, 0x7F0A02F8);  // id:comment_input_layout
            if(view2 != null) {
                u u0 = u.a(view2);
                View view3 = I.C(view0, 0x7F0A03C8);  // id:dimmed
                if(view3 != null && ((FrameLayout)I.C(view0, 0x7F0A04B6)) != null && (((TranslationParallaxView)I.C(view0, 0x7F0A08FD)) != null && ((RecyclerView)I.C(view0, 0x7F0A09D1)) != null) && ((TranslationParallaxContainer)I.C(view0, 0x7F0A0BE7)) != null) {  // id:fixed_container
                    this._binding = new w(((RelativeLayout)view0), view1, u0, view3);
                    return this.getBinding().a;
                }
                v = 0x7F0A03C8;  // id:dimmed
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        CommentInputPopup commentInputPopup0 = this.inputPopupWindow;
        if(commentInputPopup0 != null) {
            commentInputPopup0.dismiss();
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initInputType();
        this.initTitleBarType();
        Q1.c.R(this, "comment_request_key", new m(this, 1));
    }

    private static final H onViewCreated$lambda$1(CommentListRenewalFragment commentListRenewalFragment0, String s, Bundle bundle0) {
        q.g(s, "<unused var>");
        q.g(bundle0, "bundle");
        EventComment eventComment0 = (EventComment)com.google.firebase.b.G(bundle0, "data", EventComment.class);
        if(eventComment0 != null) {
            commentListRenewalFragment0.updateCmt(eventComment0);
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseFragment
    public void performFetchCompleteOnlyViews() {
        super.performFetchCompleteOnlyViews();
        if(this.isFragmentAddable() && this.isLoginUser() && this.getMelonArrayAdapter().getCount() == 0) {
            this.showInputPopup(((MelonEditText)this.getBinding().c.d).getText());
        }
    }

    private final void performRegister(String s) {
        String s1;
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        int v = s.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        int v2 = s.subSequence(v1, v + 1).toString().length();
        int v3 = this.mLoadPgnRes.result.chnlinfo.cmtregminlength > 0 ? this.mLoadPgnRes.result.chnlinfo.cmtregminlength : 3;
        if(v2 < v3) {
            if(v2 == 0) {
                s1 = "내용을 입력해주세요.";
            }
            else {
                String s2 = this.getString(0x7F13084C);  // string:popup_cmt_write_min_limit "%d자 이상의 글을 작성해주세요."
                q.f(s2, "getString(...)");
                s1 = String.format(s2, Arrays.copyOf(new Object[]{v3}, 1));
            }
            q.d(s1);
            ToastManager.show(s1);
            return;
        }
        this.sendComment(s);
    }

    private final void sendComment(String s) {
        Params insertCmtReq$Params0 = new Params();
        insertCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        insertCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        insertCmtReq$Params0.secrtFlag = false;
        insertCmtReq$Params0.stickerSeq = "-1";
        insertCmtReq$Params0.atachList = new ArrayList();
        AtachList insertCmtReq$Params$AtachList0 = new AtachList();
        insertCmtReq$Params$AtachList0.atachType = "text";
        insertCmtReq$Params$AtachList0.atachValue = s;
        insertCmtReq$Params0.atachList.add(insertCmtReq$Params$AtachList0);
        RequestBuilder.newInstance(new InsertCmtReq(this.getContext(), insertCmtReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.comments.o(this, s)).errorListener(new com.iloen.melon.fragments.comments.o(this, s)).request();
    }

    private static final void sendComment$lambda$21(CommentListRenewalFragment commentListRenewalFragment0, String s, InsertCmtRes insertCmtRes0) {
        if(insertCmtRes0.isSuccessful() && commentListRenewalFragment0.isLoadPgnResValid(insertCmtRes0.getClass().getName())) {
            if(!commentListRenewalFragment0.isFragmentValid()) {
                return;
            }
            com.iloen.melon.net.v3x.comments.InsertCmtRes.result insertCmtRes$result0 = insertCmtRes0.result;
            if(insertCmtRes$result0 != null && !TextUtils.isEmpty(insertCmtRes$result0.message) && commentListRenewalFragment0.isFragmentValid()) {
                l0 l00 = commentListRenewalFragment0.getChildFragmentManager();
                String s1 = commentListRenewalFragment0.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                b.d(b.a, l00, s1, insertCmtRes$result0.message, false, false, false, null, null, null, null, null, 2040);
            }
            ((MelonEditText)commentListRenewalFragment0.getBinding().c.d).setText(null);
            ((MelonTextView)commentListRenewalFragment0.getBinding().c.b).setEnabled(false);
            commentListRenewalFragment0.refreshList();
            return;
        }
        commentListRenewalFragment0.setInputMessage(s);
        commentListRenewalFragment0.performCmtFetchErrorPopup(insertCmtRes0.errormessage, insertCmtRes0.status);
    }

    private static final void sendComment$lambda$22(CommentListRenewalFragment commentListRenewalFragment0, String s, VolleyError volleyError0) {
        commentListRenewalFragment0.setInputMessage(s);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void setInputMessage(String s) {
        if(this.isFragmentValid()) {
            ((MelonEditText)this.getBinding().c.d).setText(s);
            ((MelonTextView)this.getBinding().c.b).setEnabled(s.length() > 0);
        }
    }

    private final void setInputPopupMinMaxLength(CommentInputPopup commentInputPopup0) {
        LoadPgnRes loadPgnRes0 = this.mLoadPgnRes;
        if(loadPgnRes0 != null) {
            result loadPgnRes$result0 = loadPgnRes0.result;
            if(loadPgnRes$result0 != null) {
                CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                if(loadPgnRes$result$CHNLINFO0 != null) {
                    int v = loadPgnRes$result$CHNLINFO0.adcmtregmaxlength;
                    if(v > 0) {
                        commentInputPopup0.setMaxLength(v);
                    }
                    int v1 = loadPgnRes$result$CHNLINFO0.adcmtregminlength;
                    if(v1 > 0) {
                        commentInputPopup0.setMinLength(v1);
                    }
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public boolean shouldShowMiniPlayer() {
        return this.isFragmentAddable() ? false : super.shouldShowMiniPlayer();
    }

    private final void showContextPopupSort() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            return;
        }
        String[] arr_s = this.isRecomAvailable() ? this.getResources().getStringArray(0x7F030049) : this.getResources().getStringArray(0x7F03004A);  // array:sortingbar_review
        q.d(arr_s);
        BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
        bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
        bottomSingleFilterListPopup0.setFilterItem(je.n.z0(arr_s), this.sortType);
        bottomSingleFilterListPopup0.setFilterListener(new H0(9, this, arr_s));
        bottomSingleFilterListPopup0.setOnDismissListener(this.mDialogDismissListener);
        this.mRetainDialog = bottomSingleFilterListPopup0;
        bottomSingleFilterListPopup0.show();
    }

    private static final void showContextPopupSort$lambda$13(CommentListRenewalFragment commentListRenewalFragment0, String[] arr_s, int v) {
        commentListRenewalFragment0.sortType = v;
        commentListRenewalFragment0.mOrderBy = commentListRenewalFragment0.isRecomAvailable() ? SortType.Normal[v] : SortType.WithoutRecom[v];
        u1 u10 = commentListRenewalFragment0.bindingHeaderView;
        if(u10 != null) {
            q.f(u10.d, "tvOrderBy");
            CharSequence charSequence0 = (CharSequence)je.n.n0(v, arr_s);
            u10.d.setText(charSequence0);
            String s = commentListRenewalFragment0.getString(0x7F130BAF, new Object[]{u10.d.getText()});  // string:talkback_order_change "%1$s, 정렬기준 변경"
            ViewUtils.setContentDescriptionWithButtonClassName(u10.d, s);
            String s1 = commentListRenewalFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s2 = commentListRenewalFragment0.getString(0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
            Object object0 = je.n.n0(v, arr_s);
            commentListRenewalFragment0.itemClickLog(s1, ActionKind.ClickContent, s2, ((String)object0), false, null, null, null);
            commentListRenewalFragment0.startFetch("sorting");
            return;
        }
        q.m("bindingHeaderView");
        throw null;
    }

    private final void showInputPopup(Editable editable0) {
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        CommentInputPopup commentInputPopup0 = this.initInputPopup(editable0);
        this.inputPopupWindow = commentInputPopup0;
        if(commentInputPopup0 != null) {
            this.setInputPopupMinMaxLength(commentInputPopup0);
            commentInputPopup0.show();
        }
        String s = this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
        String s1 = this.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
        String s2 = this.getString(0x7F130DB4);  // string:tiara_click_copy_write "글쓰기"
        this.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, null, null, null);
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public void updateCmtAllCount(int v) {
        this.mCmtAllCount = v;
        String s = va.e.c(this.getString(0x7F1301D6), " ", StringUtils.getCountFormattedString(this.mCmtAllCount));  // string:cmt_all "전체"
        u1 u10 = this.bindingHeaderView;
        if(u10 != null) {
            u10.c.setText(s);
            u1 u11 = this.bindingHeaderView;
            if(u11 != null) {
                String s1 = this.getString(0x7F1301CD);  // string:certain "개의"
                String s2 = this.getTitle();
                u11.c.setContentDescription(s + s1 + " " + s2);
                return;
            }
            q.m("bindingHeaderView");
            throw null;
        }
        q.m("bindingHeaderView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public void updateSortBarView() {
        this.initAlyacFilter();
    }

    private final void updateSortInfo() {
        u1 u10 = this.bindingHeaderView;
        if(u10 != null) {
            q.f(u10.d, "tvOrderBy");
            String[] arr_s = this.getResources().getStringArray(0x7F030049);  // array:sortingbar_review
            q.f(arr_s, "getStringArray(...)");
            CharSequence charSequence0 = (CharSequence)je.n.n0(this.mOrderBy, arr_s);
            u10.d.setText(charSequence0);
            String s = this.getString(0x7F130BAF, new Object[]{u10.d.getText()});  // string:talkback_order_change "%1$s, 정렬기준 변경"
            ViewUtils.setContentDescriptionWithButtonClassName(u10.d, s);
            return;
        }
        q.m("bindingHeaderView");
        throw null;
    }
}

