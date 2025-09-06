package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Ad.s;
import J8.X1;
import J8.j0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.TICKET;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.FamilyAppHelper;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import v9.f;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0017\u0018\u0000 \u001B2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001BB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001A\u00020\u00112\u0012\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$TICKET;", "LJ8/j0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/j0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "LJ8/X1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$TICKET;)LJ8/X1;", "", "linkUrl", "Lie/H;", "itemClickLog", "(Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "holderBind", "LJ8/j0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class TicketHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TicketHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new TicketHolder(j0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "TicketHolder";
    @NotNull
    private j0 holderBind;

    static {
        TicketHolder.Companion = new Companion(null);
        TicketHolder.$stable = 8;
    }

    public TicketHolder(@NotNull j0 j00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(j00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(j00, onViewHolderActionBaseListener0);
        this.holderBind = j00;
        this.setTitleView(j00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final X1 bindItem(TICKET detailBaseRes$TICKET0) {
        String s10;
        String s4;
        X1 x10 = X1.a(LayoutInflater.from(this.getContext()));
        FrameLayout frameLayout0 = x10.a;
        MelonTextView melonTextView0 = x10.e;
        MelonTextView melonTextView1 = x10.c;
        String s = null;
        Glide.with(x10.d.b).load((detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.posterImg)).into(x10.d.b);
        x10.f.setText((detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.title));
        String s1 = detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.text;
        if(s1 == null || s1.length() == 0) {
            melonTextView1.setVisibility(8);
        }
        else {
            melonTextView1.setVisibility(0);
            melonTextView1.setText((detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.text));
        }
        String s2 = detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.placeName;
        if(s2 == null || s2.length() == 0) {
            melonTextView0.setVisibility(8);
        }
        else {
            melonTextView0.setVisibility(0);
            melonTextView0.setText((detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.placeName));
        }
        MelonTextView melonTextView2 = x10.b;
        if(detailBaseRes$TICKET0 == null) {
            s4 = null;
        }
        else {
            String s3 = detailBaseRes$TICKET0.startDt;
            s4 = s3 == null ? null : s3 + " ~ ";
        }
        melonTextView2.setText(s4 + (detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.endDt));
        frameLayout0.setOnClickListener(new s(24, this, detailBaseRes$TICKET0));
        String s5 = detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.title;
        String s6 = this.getString(0x7F130BB2);  // string:talkback_performance_place "공연장소"
        String s7 = detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.placeName;
        String s8 = this.getString(0x7F130BB1);  // string:talkback_performance_date "공연일시"
        if(detailBaseRes$TICKET0 == null) {
            s10 = null;
        }
        else {
            String s9 = detailBaseRes$TICKET0.startDt;
            s10 = s9 == null ? null : s9 + " ~ ";
        }
        if(detailBaseRes$TICKET0 != null) {
            s = detailBaseRes$TICKET0.endDt;
        }
        StringBuilder stringBuilder0 = a.o(s5, " ", s6, " ", s7);
        d.u(stringBuilder0, " ", s8, " ", s10);
        stringBuilder0.append(s);
        ViewUtils.setContentDescriptionWithButtonClassName(frameLayout0, stringBuilder0.toString());
        return x10;
    }

    private static final void bindItem$lambda$3(TicketHolder ticketHolder0, TICKET detailBaseRes$TICKET0, View view0) {
        String s1;
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        String s = null;
        melonLinkInfo0.c = detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.appSchemaUrl;
        melonLinkInfo0.b = detailBaseRes$TICKET0 == null ? null : detailBaseRes$TICKET0.linkurl;
        if(detailBaseRes$TICKET0 != null) {
            s = detailBaseRes$TICKET0.linktype;
        }
        melonLinkInfo0.a = s;
        FamilyAppHelper.getFamilyApp(f.a).openApp(melonLinkInfo0);
        if(detailBaseRes$TICKET0 == null) {
            s1 = "";
        }
        else {
            s1 = detailBaseRes$TICKET0.linkurl;
            if(s1 == null) {
                s1 = "";
            }
        }
        ticketHolder0.itemClickLog(s1);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302FC);  // string:detail_common_title_ticket "티켓"
    }

    private final void itemClickLog(String s) {
        p8.f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = this.getString(0x7F130E1E);  // string:tiara_common_layer1_ticket "티켓"
            f0.B = s;
            f0.a().track();
        }
    }

    @NotNull
    public static final TicketHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return TicketHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        if(this.holderBind.b.getChildCount() <= 0 && list0 != null) {
            for(Object object0: list0) {
                X1 x10 = this.bindItem(((TICKET)object0));
                this.holderBind.b.addView(x10.a);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

