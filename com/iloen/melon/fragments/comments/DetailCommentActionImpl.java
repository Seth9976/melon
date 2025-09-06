package com.iloen.melon.fragments.comments;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailHomeFragment;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.melon.ui.popup.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/comments/DetailCommentActionImpl;", "Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "fragment", "<init>", "(Lcom/iloen/melon/fragments/MetaContentBaseFragment;)V", "", "adapterPos", "dataPos", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "getValidCommentInfoAdapterItem", "(II)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "Lie/H;", "onOpenCommentWriteView", "()V", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "getFragment", "()Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailCommentActionImpl extends CommentActionImpl {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/comments/DetailCommentActionImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "DetailCommentActionImpl";
    @NotNull
    private final MetaContentBaseFragment fragment;

    static {
        DetailCommentActionImpl.Companion = new Companion(null);
        DetailCommentActionImpl.$stable = 8;
    }

    public DetailCommentActionImpl(@NotNull MetaContentBaseFragment metaContentBaseFragment0) {
        q.g(metaContentBaseFragment0, "fragment");
        FragmentActivity fragmentActivity0 = metaContentBaseFragment0.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        super(fragmentActivity0, metaContentBaseFragment0);
        this.fragment = metaContentBaseFragment0;
    }

    @NotNull
    public final MetaContentBaseFragment getFragment() {
        return this.fragment;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentActionImpl
    @Nullable
    public cmtList getValidCommentInfoAdapterItem(int v, int v1) {
        j0 j00 = this.fragment.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MelonArrayAdapter<*, *>");
        Object object0 = ((p)j00).getItem(v);
        if(object0 instanceof AdapterInViewHolder.Row && ((AdapterInViewHolder.Row)object0).getItem() instanceof CmtResViewModel) {
            Object object1 = ((AdapterInViewHolder.Row)object0).getItem();
            q.e(object1, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.CmtResViewModel");
            ArrayList arrayList0 = ((CmtResViewModel)object1).result.cmtlist;
            q.e(arrayList0, "null cannot be cast to non-null type java.util.ArrayList<*>");
            Object object2 = je.p.n0(v1, arrayList0);
            return !(object2 instanceof cmtList) || ((cmtList)object2).cmtinfo == null || ((cmtList)object2).memberinfo == null ? null : ((cmtList)object2);
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentActionImpl
    public void onOpenCommentWriteView() {
        MetaContentBaseFragment metaContentBaseFragment0 = this.fragment;
        if(metaContentBaseFragment0 instanceof ArtistDetailHomeFragment) {
            if(!((ArtistDetailHomeFragment)metaContentBaseFragment0).isLoginUser()) {
                this.fragment.showLoginPopup();
                return;
            }
            if(!((ArtistDetailHomeFragment)this.fragment).isFan()) {
                l0 l00 = ((ArtistDetailHomeFragment)this.fragment).getChildFragmentManager();
                String s = null;
                String s1 = ((ArtistDetailHomeFragment)this.fragment).getContext() == null ? null : "안내";
                if(((ArtistDetailHomeFragment)this.fragment).getContext() != null) {
                    s = "글쓰기는 팬맺기 후에 가능합니다.";
                }
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                return;
            }
        }
        super.onOpenCommentWriteView();
    }
}

