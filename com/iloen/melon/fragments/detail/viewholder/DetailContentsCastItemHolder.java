package com.iloen.melon.fragments.detail.viewholder;

import J8.V1;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.STATION;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0014\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/V1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder$StationActionListener;", "actionListener", "<init>", "(LJ8/V1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder$StationActionListener;)V", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;", "cast", "", "position", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;I)V", "size", "setTotal", "(I)V", "LJ8/V1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder$StationActionListener;", "total", "I", "Companion", "StationActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsCastItemHolder extends O0 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder$Companion;", "", "<init>", "()V", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_NAVIGATE_STATION_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder$StationActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsCastItemHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull StationActionListener detailContentsCastItemHolder$StationActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsCastItemHolder$StationActionListener0, "actionListener");
            return new DetailContentsCastItemHolder(V1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), detailContentsCastItemHolder$StationActionListener0, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsCastItemHolder$StationActionListener;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;", "cast", "", "position", "Lie/H;", "onClickCast", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;I)V", "onClickPlay", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface StationActionListener {
        void onClickCast(@Nullable STATION arg1, int arg2);

        void onClickPlay(@Nullable STATION arg1, int arg2);
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_NAVIGATE_STATION_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    @NotNull
    private final StationActionListener actionListener;
    @NotNull
    private final V1 binding;
    private int total;

    static {
        DetailContentsCastItemHolder.Companion = new Companion(null);
        DetailContentsCastItemHolder.$stable = 8;
    }

    private DetailContentsCastItemHolder(V1 v10, StationActionListener detailContentsCastItemHolder$StationActionListener0) {
        super(v10.a);
        this.binding = v10;
        this.actionListener = detailContentsCastItemHolder$StationActionListener0;
        Context context0 = this.itemView.getContext();
        int v = context0.getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        int v1 = ScreenUtils.dipToPixel(context0, 11.0f);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = v10.d.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, v1);
        }
    }

    public DetailContentsCastItemHolder(V1 v10, StationActionListener detailContentsCastItemHolder$StationActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v10, detailContentsCastItemHolder$StationActionListener0);
    }

    public final void bind(@Nullable STATION detailBaseRes$STATION0, int v) {
        ArrayList arrayList0 = null;
        Glide.with(this.binding.c.b).load((detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.castImg)).into(this.binding.c.b);
        String s = detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.progTitle;
        ViewUtils.hideWhen(this.binding.g, s == null || s.length() == 0);
        this.binding.g.setText(s);
        this.binding.f.setText((detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.castTitle));
        MelonTextView melonTextView0 = this.binding.b;
        if(detailBaseRes$STATION0 != null) {
            arrayList0 = detailBaseRes$STATION0.artistList;
        }
        melonTextView0.setText(ProtocolUtils.getArtistNames(arrayList0));
        j j0 = new j(this, detailBaseRes$STATION0, v, 0);
        this.binding.e.setOnClickListener(j0);
        j j1 = new j(this, detailBaseRes$STATION0, v, 1);
        this.binding.a.setOnClickListener(j1);
        this.binding.e.setImportantForAccessibility(2);
        com.iloen.melon.fragments.detail.viewholder.DetailContentsCastItemHolder.bind.4 detailContentsCastItemHolder$bind$40 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                Context context0 = s.itemView.getContext();
                if(context0 == null) {
                    return;
                }
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, "스테이션 상세보기"));
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, "재생"));
                CharSequence charSequence0 = s.binding.f.getText();
                CharSequence charSequence1 = s.binding.b.getText();
                StringBuilder stringBuilder0 = a.o("스테이션", ", ", "카테고리", ": ", v);
                stringBuilder0.append(", ");
                stringBuilder0.append("제목");
                stringBuilder0.append(": ");
                stringBuilder0.append(charSequence0);
                stringBuilder0.append(", ");
                stringBuilder0.append("아티스트");
                stringBuilder0.append(": ");
                stringBuilder0.append(charSequence1);
                stringBuilder0.append(", ");
                stringBuilder0.append("상세보기");
                accessibilityNodeInfo0.setContentDescription(stringBuilder0.toString());
                accessibilityNodeInfo0.setClassName("android.widget.Button");
                accessibilityNodeInfo0.setHintText(context0.getString(0x7F130BA8, new Object[]{s.total, ((int)(this.$position + 1))}));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        s.binding.a.performClick();
                        return true;
                    }
                    case 100000002: {
                        s.binding.e.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        this.binding.a.setAccessibilityDelegate(detailContentsCastItemHolder$bind$40);
    }

    private static final void bind$lambda$2(DetailContentsCastItemHolder detailContentsCastItemHolder0, STATION detailBaseRes$STATION0, int v, View view0) {
        detailContentsCastItemHolder0.actionListener.onClickPlay(detailBaseRes$STATION0, v);
    }

    private static final void bind$lambda$3(DetailContentsCastItemHolder detailContentsCastItemHolder0, STATION detailBaseRes$STATION0, int v, View view0) {
        detailContentsCastItemHolder0.actionListener.onClickCast(detailBaseRes$STATION0, v);
    }

    public final void setTotal(int v) {
        this.total = v;
    }
}

