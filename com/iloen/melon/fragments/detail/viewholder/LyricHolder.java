package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.s0;
import Tf.o;
import Tf.v;
import U4.x;
import Vb.i;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.session.a0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.UnderlineTextView;
import com.iloen.melon.custom.detail.ZoomButton;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.LyricHighLightShareFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import va.e0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 %2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0006%&\'()*B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\f\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ+\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0013\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001D\u0010\u0017\u001A\u00020\r2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\r¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u001A\u0010 \u001A\u00060\u001FR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001A\u00020\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LyricData;", "LJ8/s0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/s0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "tooltipPrefs", "tooltipMsg", "Lie/H;", "setTooltipUI", "(Ljava/lang/String;Ljava/lang/String;)V", "actionName", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "clickCopy", "itemClickLog", "(Ljava/lang/String;Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "showLoginPopup", "()V", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/s0;", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$InnerLyricAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$InnerLyricAdapter;", "", "zoomLevel", "I", "Companion", "LongClickListener", "InnerLyricAdapter", "LyricItemViewHolder", "MoreViewHolder", "LyricData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LyricHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$Companion;", "", "<init>", "()V", "TAG", "", "MORE_LIST_SIZE_15", "", "HIGHLIGHT_PADDING", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LyricHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D022E, viewGroup0, false);  // layout:detail_song_lyric
            int v = 0x7F0A0165;  // id:btn_highlight
            View view1 = I.C(view0, 0x7F0A0165);  // id:btn_highlight
            if(((ImageView)view1) != null) {
                v = 0x7F0A0166;  // id:btn_highlight_share
                View view2 = I.C(view0, 0x7F0A0166);  // id:btn_highlight_share
                if(((ImageView)view2) != null) {
                    v = 0x7F0A01C5;  // id:btn_zoom
                    View view3 = I.C(view0, 0x7F0A01C5);  // id:btn_zoom
                    if(((ZoomButton)view3) != null) {
                        v = 0x7F0A0430;  // id:empty_view
                        View view4 = I.C(view0, 0x7F0A0430);  // id:empty_view
                        if(((MelonTextView)view4) != null && ((RelativeLayout)I.C(view0, 0x7F0A0530)) != null && ((ImageView)I.C(view0, 0x7F0A0613)) != null) {  // id:highlight_container
                            v = 0x7F0A06AC;  // id:iv_tooltip_close
                            View view5 = I.C(view0, 0x7F0A06AC);  // id:iv_tooltip_close
                            if(((ImageView)view5) != null) {
                                v = 0x7F0A07CA;  // id:main_contents_title
                                View view6 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                                if(((MainTabTitleView)view6) != null) {
                                    v = 0x7F0A08D5;  // id:onboading_container
                                    View view7 = I.C(view0, 0x7F0A08D5);  // id:onboading_container
                                    if(((RelativeLayout)view7) != null) {
                                        v = 0x7F0A09D1;  // id:recycler_view
                                        View view8 = I.C(view0, 0x7F0A09D1);  // id:recycler_view
                                        if(((RecyclerView)view8) != null) {
                                            v = 0x7F0A09D4;  // id:recyclerview_container
                                            View view9 = I.C(view0, 0x7F0A09D4);  // id:recyclerview_container
                                            if(((RelativeLayout)view9) != null) {
                                                v = 0x7F0A0BC8;  // id:tooltip_container
                                                View view10 = I.C(view0, 0x7F0A0BC8);  // id:tooltip_container
                                                if(((LinearLayout)view10) != null && ((MelonTextView)I.C(view0, 0x7F0A0C8D)) != null) {  // id:tv_info
                                                    v = 0x7F0A0D44;  // id:tv_tooltip
                                                    View view11 = I.C(view0, 0x7F0A0D44);  // id:tv_tooltip
                                                    if(((MelonTextView)view11) != null) {
                                                        return new LyricHolder(new s0(((ConstraintLayout)view0), ((ImageView)view1), ((ImageView)view2), ((ZoomButton)view3), ((MelonTextView)view4), ((ImageView)view5), ((MainTabTitleView)view6), ((RelativeLayout)view7), ((RecyclerView)view8), ((RelativeLayout)view9), ((LinearLayout)view10), ((MelonTextView)view11)), onViewHolderActionBaseListener0);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0016\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00148\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00148\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001A\u00020\u000E8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u000E8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010\'\u001A\u00020&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010(R&\u0010+\u001A\u0012\u0012\u0004\u0012\u00020&0)j\b\u0012\u0004\u0012\u00020&`*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R&\u0010-\u001A\u0012\u0012\u0004\u0012\u00020&0)j\b\u0012\u0004\u0012\u00020&`*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010,R&\u0010/\u001A\u0012\u0012\u0004\u0012\u00020.0)j\b\u0012\u0004\u0012\u00020.`*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00100\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00101R\u0016\u0010\u000F\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000F\u0010$R\u0016\u00103\u001A\u00020\u00058\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b3\u00104\u00A8\u00065"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$InnerLyricAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;)V", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LongClickListener;", "listener", "Lie/H;", "setOnLongClickListener", "(Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LongClickListener;)V", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LyricData;", "data", "setLyricData", "(Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LyricData;)V", "", "textSize", "setLyricTextSize", "(F)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "position", "getItemViewType", "(I)I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "getItemCount", "()I", "VIEW_TYPE_ITEM", "I", "VIEW_TYPE_MORE", "TEXT_SIZE_ZOOM_LEVEL1", "F", "TEXT_SIZE_ZOOM_LEVEL2", "", "copyLyrics", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lyricList", "Ljava/util/ArrayList;", "lyricMoreList", "", "isHighlightLineList", "isMoreBtn", "Z", "isOpened", "onLongClickListener", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LongClickListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class InnerLyricAdapter extends j0 {
        private final float TEXT_SIZE_ZOOM_LEVEL1;
        private final float TEXT_SIZE_ZOOM_LEVEL2;
        private final int VIEW_TYPE_ITEM;
        private final int VIEW_TYPE_MORE;
        @NotNull
        private String copyLyrics;
        @NotNull
        private ArrayList isHighlightLineList;
        private boolean isMoreBtn;
        private boolean isOpened;
        @NotNull
        private ArrayList lyricList;
        @NotNull
        private ArrayList lyricMoreList;
        private LongClickListener onLongClickListener;
        private float textSize;

        public InnerLyricAdapter() {
            this.VIEW_TYPE_ITEM = 1;
            this.VIEW_TYPE_MORE = 2;
            this.TEXT_SIZE_ZOOM_LEVEL1 = 16.0f;
            this.TEXT_SIZE_ZOOM_LEVEL2 = 18.0f;
            this.copyLyrics = "";
            this.lyricList = new ArrayList();
            this.lyricMoreList = new ArrayList();
            this.isHighlightLineList = new ArrayList();
            this.textSize = 16.0f;
        }

        // 去混淆评级： 低(20)
        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return this.isMoreBtn ? this.lyricList.size() + 1 : this.lyricList.size();
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            return !this.isMoreBtn || v != this.getItemCount() - 1 ? this.VIEW_TYPE_ITEM : this.VIEW_TYPE_MORE;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            q.g(o00, "holder");
            if(o00 instanceof MoreViewHolder) {
                ViewUtils.setOnClickListener(((MoreViewHolder)o00).getTvMore(), new s(this, ((MoreViewHolder)o00), LyricHolder.this, 0));
                return;
            }
            if(o00 instanceof LyricItemViewHolder) {
                LyricHolder lyricHolder0 = LyricHolder.this;
                ((LyricItemViewHolder)o00).getTvLyric().setText(((CharSequence)this.lyricList.get(v)));
                if(((Boolean)this.isHighlightLineList.get(v)).booleanValue()) {
                    ((LyricItemViewHolder)o00).getTvLyric().setUnderlineColor(ColorUtils.getColor(lyricHolder0.getContext(), 0x7F0600A5));  // color:color_highlight
                    ((LyricItemViewHolder)o00).getTvLyric().setUnderlineWidth(ScreenUtils.dipToPixel(lyricHolder0.getContext(), 9.0f));
                }
                else {
                    ((LyricItemViewHolder)o00).getTvLyric().setUnderlineColor(ColorUtils.getColor(lyricHolder0.getContext(), 0x7F06048A));  // color:transparent
                    ((LyricItemViewHolder)o00).getTvLyric().setUnderlineWidth(ScreenUtils.dipToPixel(lyricHolder0.getContext(), 0.0f));
                }
                ((LyricItemViewHolder)o00).getTvLyric().h();
                Jc.s0 s00 = new Jc.s0(this, 1);
                ((LyricItemViewHolder)o00).itemView.setOnLongClickListener(s00);
                ((LyricItemViewHolder)o00).getTvLyric().setTextSize(1, this.textSize);
                Object object0 = this.lyricList.get(v);
                q.f(object0, "get(...)");
                int v1 = o.H0(((CharSequence)object0)) ? ScreenUtils.dipToPixel(lyricHolder0.getContext(), 2.0f) : ScreenUtils.dipToPixel(lyricHolder0.getContext(), 1.5f);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((LyricItemViewHolder)o00).getLyricContainer().getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = v1;
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = v1;
                ((LyricItemViewHolder)o00).getLyricContainer().setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
            }
        }

        private static final void onBindViewHolder$lambda$3$lambda$2(InnerLyricAdapter lyricHolder$InnerLyricAdapter0, MoreViewHolder lyricHolder$MoreViewHolder0, LyricHolder lyricHolder0, View view0) {
            if(lyricHolder$InnerLyricAdapter0.isOpened) {
                for(int v = lyricHolder$InnerLyricAdapter0.lyricList.size() - 1; 14 < v; --v) {
                    lyricHolder$InnerLyricAdapter0.lyricList.remove(v);
                }
                lyricHolder$MoreViewHolder0.getTvMore().setText(lyricHolder0.getString(0x7F1306AE));  // string:more_title "더보기"
                lyricHolder$InnerLyricAdapter0.isOpened = false;
                lyricHolder$InnerLyricAdapter0.notifyDataSetChanged();
                lyricHolder0.getOnViewHolderActionListener().onMoveToScoll(2);
            }
            else {
                for(Object object0: lyricHolder$InnerLyricAdapter0.lyricMoreList) {
                    lyricHolder$InnerLyricAdapter0.lyricList.add(((String)object0));
                }
                lyricHolder$MoreViewHolder0.getTvMore().setText(lyricHolder0.getString(0x7F13043E));  // string:fold_title "접기"
                lyricHolder$InnerLyricAdapter0.isOpened = true;
                lyricHolder$InnerLyricAdapter0.notifyDataSetChanged();
            }
            String s = lyricHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s1 = lyricHolder0.getString(0x7F130D54);  // string:tiara_click_copy_more "더보기"
            lyricHolder0.itemClickLog(s, ActionKind.ClickContent, s1);
        }

        private static final boolean onBindViewHolder$lambda$6$lambda$4(InnerLyricAdapter lyricHolder$InnerLyricAdapter0, View view0) {
            LongClickListener lyricHolder$LongClickListener0 = lyricHolder$InnerLyricAdapter0.onLongClickListener;
            if(lyricHolder$LongClickListener0 != null) {
                lyricHolder$LongClickListener0.onLongClick(lyricHolder$InnerLyricAdapter0.copyLyrics);
                return true;
            }
            q.m("onLongClickListener");
            throw null;
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_MORE) {
                View view0 = LayoutInflater.from(LyricHolder.this.getContext()).inflate(0x7F0D0231, viewGroup0, false);  // layout:detail_song_lyric_item_more
                q.f(view0, "inflate(...)");
                return new MoreViewHolder(LyricHolder.this, view0);
            }
            View view1 = LayoutInflater.from(LyricHolder.this.getContext()).inflate(0x7F0D0230, viewGroup0, false);  // layout:detail_song_lyric_item
            q.f(view1, "inflate(...)");
            return new LyricItemViewHolder(LyricHolder.this, view1);
        }

        public final void setLyricData(@NotNull LyricData lyricHolder$LyricData0) {
            String s;
            q.g(lyricHolder$LyricData0, "data");
            this.lyricList.clear();
            this.lyricMoreList.clear();
            this.isHighlightLineList.clear();
            RESPONSE songInfoRes$RESPONSE0 = lyricHolder$LyricData0.getSongInfoRes();
            if(songInfoRes$RESPONSE0 == null) {
                s = "";
            }
            else {
                s = songInfoRes$RESPONSE0.lyric;
                if(s == null) {
                    s = "";
                }
            }
            this.copyLyrics = s;
            List list0 = o.R0(s, new String[]{"\n"}, 0, 6);
            List list1 = o.R0("", new String[]{","}, 0, 6);
            int v1 = list0.size();
            if(!list1.isEmpty()) {
                Boolean[] arr_boolean = new Boolean[v1];
                for(int v2 = 0; v2 < v1; ++v2) {
                    arr_boolean[v2] = Boolean.FALSE;
                }
                for(Object object0: list1) {
                    String s1 = (String)object0;
                    Integer integer0 = v.t0(s1);
                    if(integer0 == null) {
                        LogU.Companion.d("SongListHeaderHolder", "LyricHolder.setLyricData() invalid number format - " + s1);
                    }
                    else if(((int)integer0) == 0) {
                        LogU.Companion.d("SongListHeaderHolder", "LyricHolder.setLyricData() number cannot be zero - " + s1);
                    }
                    else if(((int)integer0) > v1) {
                        LogU.Companion.d("SongListHeaderHolder", "LyricHolder.setLyricData() number cannot be exceed lyric size - " + s1);
                    }
                    else {
                        arr_boolean[((int)integer0) - 1] = Boolean.TRUE;
                    }
                }
                u.V(this.isHighlightLineList, arr_boolean);
            }
            if(v1 <= 15) {
                this.lyricList.addAll(list0);
                this.isMoreBtn = false;
                return;
            }
            for(int v = 0; v < 15; ++v) {
                this.lyricList.add(list0.get(v));
            }
            for(int v3 = 15; v3 < v1; ++v3) {
                this.lyricMoreList.add(list0.get(v3));
            }
            this.isMoreBtn = true;
            this.notifyDataSetChanged();
        }

        public final void setLyricTextSize(float f) {
            this.textSize = f;
            this.notifyDataSetChanged();
        }

        public final void setOnLongClickListener(@NotNull LongClickListener lyricHolder$LongClickListener0) {
            q.g(lyricHolder$LongClickListener0, "listener");
            this.onLongClickListener = lyricHolder$LongClickListener0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LongClickListener;", "", "", "lyric", "Lie/H;", "onLongClick", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface LongClickListener {
        void onLongClick(@NotNull String arg1);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001B\u001A\u00020\bHÆ\u0003J3\u0010\u001C\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001D\u001A\u00020\b2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\u0005HÖ\u0001R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0006\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LyricData;", "", "songInfoRes", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "highlightLine", "", "lyricUpdateMsg", "isLyricUpdate", "", "<init>", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;Ljava/lang/String;Ljava/lang/String;Z)V", "getSongInfoRes", "()Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "setSongInfoRes", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;)V", "getHighlightLine", "()Ljava/lang/String;", "setHighlightLine", "(Ljava/lang/String;)V", "getLyricUpdateMsg", "setLyricUpdateMsg", "()Z", "setLyricUpdate", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class LyricData {
        public static final int $stable = 8;
        @NotNull
        private String highlightLine;
        private boolean isLyricUpdate;
        @NotNull
        private String lyricUpdateMsg;
        @Nullable
        private RESPONSE songInfoRes;

        public LyricData() {
            this(null, null, null, false, 15, null);
        }

        public LyricData(@Nullable RESPONSE songInfoRes$RESPONSE0, @NotNull String s, @NotNull String s1, boolean z) {
            q.g(s, "highlightLine");
            q.g(s1, "lyricUpdateMsg");
            super();
            this.songInfoRes = songInfoRes$RESPONSE0;
            this.highlightLine = s;
            this.lyricUpdateMsg = s1;
            this.isLyricUpdate = z;
        }

        public LyricData(RESPONSE songInfoRes$RESPONSE0, String s, String s1, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                songInfoRes$RESPONSE0 = null;
            }
            if((v & 2) != 0) {
                s = "";
            }
            if((v & 4) != 0) {
                s1 = "";
            }
            if((v & 8) != 0) {
                z = false;
            }
            this(songInfoRes$RESPONSE0, s, s1, z);
        }

        @Nullable
        public final RESPONSE component1() {
            return this.songInfoRes;
        }

        @NotNull
        public final String component2() {
            return this.highlightLine;
        }

        @NotNull
        public final String component3() {
            return this.lyricUpdateMsg;
        }

        public final boolean component4() {
            return this.isLyricUpdate;
        }

        @NotNull
        public final LyricData copy(@Nullable RESPONSE songInfoRes$RESPONSE0, @NotNull String s, @NotNull String s1, boolean z) {
            q.g(s, "highlightLine");
            q.g(s1, "lyricUpdateMsg");
            return new LyricData(songInfoRes$RESPONSE0, s, s1, z);
        }

        public static LyricData copy$default(LyricData lyricHolder$LyricData0, RESPONSE songInfoRes$RESPONSE0, String s, String s1, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                songInfoRes$RESPONSE0 = lyricHolder$LyricData0.songInfoRes;
            }
            if((v & 2) != 0) {
                s = lyricHolder$LyricData0.highlightLine;
            }
            if((v & 4) != 0) {
                s1 = lyricHolder$LyricData0.lyricUpdateMsg;
            }
            if((v & 8) != 0) {
                z = lyricHolder$LyricData0.isLyricUpdate;
            }
            return lyricHolder$LyricData0.copy(songInfoRes$RESPONSE0, s, s1, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof LyricData)) {
                return false;
            }
            if(!q.b(this.songInfoRes, ((LyricData)object0).songInfoRes)) {
                return false;
            }
            if(!q.b(this.highlightLine, ((LyricData)object0).highlightLine)) {
                return false;
            }
            return q.b(this.lyricUpdateMsg, ((LyricData)object0).lyricUpdateMsg) ? this.isLyricUpdate == ((LyricData)object0).isLyricUpdate : false;
        }

        @NotNull
        public final String getHighlightLine() [...] // 潜在的解密器

        @NotNull
        public final String getLyricUpdateMsg() [...] // 潜在的解密器

        @Nullable
        public final RESPONSE getSongInfoRes() {
            return this.songInfoRes;
        }

        @Override
        public int hashCode() {
            return this.songInfoRes == null ? Boolean.hashCode(this.isLyricUpdate) + x.b(x.b(0, 0x1F, this.highlightLine), 0x1F, this.lyricUpdateMsg) : Boolean.hashCode(this.isLyricUpdate) + x.b(x.b(this.songInfoRes.hashCode() * 0x1F, 0x1F, this.highlightLine), 0x1F, this.lyricUpdateMsg);
        }

        public final boolean isLyricUpdate() {
            return this.isLyricUpdate;
        }

        public final void setHighlightLine(@NotNull String s) {
            q.g(s, "<set-?>");
            this.highlightLine = s;
        }

        public final void setLyricUpdate(boolean z) {
            this.isLyricUpdate = z;
        }

        public final void setLyricUpdateMsg(@NotNull String s) {
            q.g(s, "<set-?>");
            this.lyricUpdateMsg = s;
        }

        public final void setSongInfoRes(@Nullable RESPONSE songInfoRes$RESPONSE0) {
            this.songInfoRes = songInfoRes$RESPONSE0;
        }

        @Override
        @NotNull
        public String toString() {
            return "LyricData(songInfoRes=" + this.songInfoRes + ", highlightLine=" + this.highlightLine + ", lyricUpdateMsg=" + this.lyricUpdateMsg + ", isLyricUpdate=" + this.isLyricUpdate + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$LyricItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;Landroid/view/View;)V", "Landroid/widget/RelativeLayout;", "lyricContainer", "Landroid/widget/RelativeLayout;", "getLyricContainer", "()Landroid/widget/RelativeLayout;", "Lcom/iloen/melon/custom/UnderlineTextView;", "tvLyric", "Lcom/iloen/melon/custom/UnderlineTextView;", "getTvLyric", "()Lcom/iloen/melon/custom/UnderlineTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class LyricItemViewHolder extends O0 {
        @NotNull
        private final RelativeLayout lyricContainer;
        @NotNull
        private final UnderlineTextView tvLyric;

        public LyricItemViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            LyricHolder.this = lyricHolder0;
            super(view0);
            View view1 = view0.findViewById(0x7F0A07BB);  // id:lyric_container
            q.f(view1, "findViewById(...)");
            this.lyricContainer = (RelativeLayout)view1;
            View view2 = view0.findViewById(0x7F0A0CA9);  // id:tv_lyric
            q.f(view2, "findViewById(...)");
            this.tvLyric = (UnderlineTextView)view2;
            ((UnderlineTextView)view2).setShadowLayer(10.0f, 0.0f, 0.0f, 0);
            ((UnderlineTextView)view2).setPadding(10, 10, 10, 10);
        }

        @NotNull
        public final RelativeLayout getLyricContainer() {
            return this.lyricContainer;
        }

        @NotNull
        public final UnderlineTextView getTvLyric() {
            return this.tvLyric;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder$MoreViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "tvMore", "Lcom/iloen/melon/custom/MelonTextView;", "getTvMore", "()Lcom/iloen/melon/custom/MelonTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class MoreViewHolder extends O0 {
        @NotNull
        private final MelonTextView tvMore;

        public MoreViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            LyricHolder.this = lyricHolder0;
            super(view0);
            View view1 = view0.findViewById(0x7F0A0CBA);  // id:tv_more
            q.f(view1, "findViewById(...)");
            this.tvMore = (MelonTextView)view1;
        }

        @NotNull
        public final MelonTextView getTvMore() {
            return this.tvMore;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int HIGHLIGHT_PADDING = 10;
    private static final int MORE_LIST_SIZE_15 = 15;
    @NotNull
    public static final String TAG = "SongListHeaderHolder";
    @NotNull
    private s0 holderBind;
    @NotNull
    private InnerLyricAdapter innerAdapter;
    private int zoomLevel;

    static {
        LyricHolder.Companion = new Companion(null);
        LyricHolder.$stable = 8;
    }

    public LyricHolder(@NotNull s0 s00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(s00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(s00, onViewHolderActionBaseListener0);
        this.holderBind = s00;
        this.innerAdapter = new InnerLyricAdapter(this);
        this.setTitleView(this.holderBind.g);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
        this.innerAdapter.setOnLongClickListener(new LongClickListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.LyricHolder$LongClickListener
            public void onLongClick(String s) {
                q.g(s, "lyric");
                BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
                if(baseActivity0 != null) {
                    MelonTextPopup melonTextPopup0 = new MelonTextPopup(baseActivity0, 2);
                    melonTextPopup0.setTitle(LyricHolder.this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                    melonTextPopup0.setBodyMsg(LyricHolder.this.getString(0x7F1300AA));  // string:alert_dlg_body_lyric_copy "가사 전체 복사하시겠습니까?"
                    melonTextPopup0.setPopupOnClickListener(new r(baseActivity0, s, LyricHolder.this, 0));
                    melonTextPopup0.show();
                }
            }

            private static final void onLongClick$lambda$1$lambda$0(BaseActivity baseActivity0, String s, LyricHolder lyricHolder0, DialogInterface dialogInterface0, int v) {
                if(v == -1) {
                    Object object0 = baseActivity0.getSystemService("clipboard");
                    q.e(object0, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager)object0).setPrimaryClip(ClipData.newPlainText("Copied lyric", s));
                    ToastManager.show(lyricHolder0.getString(0x7F131067));  // string:toast_lyric_copy_success "가사 전체 복사 되었습니다."
                    dialogInterface0.dismiss();
                }
            }
        });
        this.holderBind.i.setLayoutManager(new LinearLayoutManager(1, false));
        this.holderBind.i.setNestedScrollingEnabled(false);
        this.holderBind.i.setHasFixedSize(false);
        this.holderBind.i.setAdapter(this.innerAdapter);
    }

    public static void b(LyricHolder lyricHolder0, String s, View view0) {
        LyricHolder.onBindView$lambda$0(s, lyricHolder0, view0);
    }

    public static void c(LyricHolder lyricHolder0, String s, View view0) {
        LyricHolder.setTooltipUI$lambda$5(s, lyricHolder0, view0);
    }

    public static void d(LyricHolder lyricHolder0, int v) {
        LyricHolder.onBindView$lambda$1(lyricHolder0, v);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130A7C);  // string:song_detail_title_lyric "가사"
    }

    private final void itemClickLog(String s, ActionKind actionKind0, String s1) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = s;
            if(actionKind0 != null) {
                f0.d = actionKind0;
            }
            f0.y = this.getString(0x7F130DF9);  // string:tiara_common_layer1_lyric "가사"
            if(s1 != null && s1.length() != 0) {
                f0.F = s1;
            }
            f0.a().track();
        }
    }

    @NotNull
    public static final LyricHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return LyricHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        String s;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(false);
        }
        LyricData lyricHolder$LyricData0 = (LyricData)adapterInViewHolder$Row0.getItem();
        RESPONSE songInfoRes$RESPONSE0 = lyricHolder$LyricData0.getSongInfoRes();
        if(songInfoRes$RESPONSE0 == null) {
            s = "";
        }
        else {
            SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
            if(songInfoBase0 == null) {
                s = "";
            }
            else {
                s = songInfoBase0.songId;
                if(s == null) {
                    s = "";
                }
            }
        }
        RESPONSE songInfoRes$RESPONSE1 = lyricHolder$LyricData0.getSongInfoRes();
        String s1 = null;
        String s2 = songInfoRes$RESPONSE1 == null ? null : songInfoRes$RESPONSE1.lyric;
        if(s2 != null && s2.length() != 0) {
            this.holderBind.e.setVisibility(8);
            this.holderBind.j.setVisibility(0);
            this.innerAdapter.setLyricData(lyricHolder$LyricData0);
            if(lyricHolder$LyricData0.isLyricUpdate() && MelonPrefs.getInstance().getBoolean("lyricUpdateMsgShown", false)) {
                MelonPrefs.getInstance().setBoolean("lyricUpdateMsgShown", false);
            }
            if(MelonPrefs.getInstance().getBoolean("lyricUpdateMsgShown", false) || true) {
                this.holderBind.h.setVisibility(8);
            }
            else {
                this.holderBind.h.setVisibility(0);
                ((TextView)this.holderBind.h.findViewById(0x7F0A0C8D)).setText("");  // id:tv_info
                ViewUtils.setOnClickListener(this.holderBind.h.findViewById(0x7F0A0613), new com.iloen.melon.fragments.detail.viewholder.q(s, this, 1));  // id:iv_close
            }
            this.holderBind.d.setZoomLevel(this.zoomLevel);
            this.holderBind.d.setOnZoomLevelChangedListener(new a0(this, 26));
            RESPONSE songInfoRes$RESPONSE2 = lyricHolder$LyricData0.getSongInfoRes();
            if((songInfoRes$RESPONSE2 == null ? false : songInfoRes$RESPONSE2.isHightlightAvail)) {
                RESPONSE songInfoRes$RESPONSE3 = lyricHolder$LyricData0.getSongInfoRes();
                if(songInfoRes$RESPONSE3 != null) {
                    s1 = songInfoRes$RESPONSE3.lyricToolTipMsg;
                }
                this.setTooltipUI((((e0)va.o.a()).m() ? "highlightingTooltipShownForLogin" : "highlightingTooltipShownForNotLogin"), s1);
                ViewUtils.setEnable(this.holderBind.b, true);
                ViewUtils.setOnClickListener(this.holderBind.b, new com.iloen.melon.fragments.detail.viewholder.q(this, s, 2));
            }
            else {
                ViewUtils.setEnable(this.holderBind.b, false);
                this.holderBind.k.setVisibility(8);
                this.holderBind.b.setOnClickListener(null);
            }
            this.holderBind.c.setVisibility(8);
            return;
        }
        this.holderBind.e.setVisibility(0);
        this.holderBind.j.setVisibility(8);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$0(String s, LyricHolder lyricHolder0, View view0) {
        if(s.length() > 0) {
            lyricHolder0.getOnViewHolderActionListener().onLyricUpdateMsgListener(s);
        }
        lyricHolder0.holderBind.h.setVisibility(8);
    }

    private static final void onBindView$lambda$1(LyricHolder lyricHolder0, int v) {
        lyricHolder0.zoomLevel = v;
        ZoomButton zoomButton0 = lyricHolder0.holderBind.d;
        lyricHolder0.innerAdapter.setLyricTextSize((v == 1 ? zoomButton0.j : zoomButton0.i));
        lyricHolder0.itemClickLog(lyricHolder0.getString(0x7F130DD0), null, lyricHolder0.getString(0x7F130DB5));  // string:tiara_common_action_name_select "선택"
    }

    private static final void onBindView$lambda$2(LyricHolder lyricHolder0, String s, View view0) {
        if(!((e0)va.o.a()).m()) {
            lyricHolder0.showLoginPopup();
            return;
        }
        Navigator.INSTANCE.openLyricHighlight(s, "song");
        lyricHolder0.itemClickLog(lyricHolder0.getString(0x7F130DC9), null, lyricHolder0.getString(0x7F130D49));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    private static final void onBindView$lambda$3(LyricHolder lyricHolder0, String s, View view0) {
        if(!((e0)va.o.a()).m()) {
            lyricHolder0.showLoginPopup();
            return;
        }
        Navigator.open(LyricHighLightShareFragment.Companion.newInstance(s));
        String s1 = lyricHolder0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
        String s2 = lyricHolder0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
        lyricHolder0.itemClickLog(s1, ActionKind.Share, s2);
    }

    private final void setTooltipUI(String s, String s1) {
        if(!MelonPrefs.getInstance().getBoolean(s, false) && s1 != null && s1.length() != 0) {
            this.holderBind.k.setVisibility(0);
            this.holderBind.l.setText(s1);
            this.holderBind.f.setOnClickListener(new com.iloen.melon.fragments.detail.viewholder.q(s, this, 0));
            return;
        }
        this.holderBind.k.setVisibility(8);
    }

    private static final void setTooltipUI$lambda$5(String s, LyricHolder lyricHolder0, View view0) {
        MelonPrefs.getInstance().setBoolean(s, true);
        lyricHolder0.holderBind.k.setVisibility(8);
    }

    public final void showLoginPopup() {
        b.x(MelonFragmentManager.getInstance().getCurrentActivity().getSupportFragmentManager(), "안내", "로그인이 필요한 서비스입니다.\n로그인하시겠습니까?", false, false, null, null, new i(25), null, null, null, 0xEF8);
    }

    private static final H showLoginPopup$lambda$4() {
        Navigator.openLoginView(r8.f.f);
        return H.a;
    }
}

