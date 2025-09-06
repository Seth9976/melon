package com.iloen.melon.custom;

import Tf.o;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b3.Z;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes.RESPONSE.MEMORIALCARDRELAYLIST;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import com.iloen.melon.utils.ui.MemorialCardUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;
import m4.h;
import m4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/custom/ArtistCardRelayItemView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "imageUrl", "Lie/H;", "setIvBgBackground", "(Ljava/lang/String;)V", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST;", "data", "setData", "(Lcom/iloen/melon/net/v6x/response/ArtistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST;)V", "getTalkbackText", "()Ljava/lang/String;", "talkbackText", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistCardRelayItemView extends RelativeLayout {
    public final ImageView a;
    public final ImageView b;
    public final View c;
    public final TextView d;
    public final View e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final View j;
    public final View k;
    public final ImageView l;
    public final ImageView m;
    public final TextView n;
    public final View o;
    public final View r;

    public ArtistCardRelayItemView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public ArtistCardRelayItemView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public ArtistCardRelayItemView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View.inflate(context0, 0x7F0D0211, this);  // layout:detail_item_artist_channel_card_relay_item
        View view0 = this.findViewById(0x7F0A05FE);  // id:iv_bg
        q.f(view0, "findViewById(...)");
        this.a = (ImageView)view0;
        View view1 = this.findViewById(0x7F0A0625);  // id:iv_dim
        q.f(view1, "findViewById(...)");
        this.b = (ImageView)view1;
        View view2 = this.findViewById(0x7F0A0493);  // id:few_title_layout
        q.f(view2, "findViewById(...)");
        this.c = view2;
        View view3 = this.findViewById(0x7F0A0C75);  // id:tv_few_title
        q.f(view3, "findViewById(...)");
        this.d = (TextView)view3;
        View view4 = this.findViewById(0x7F0A0B9E);  // id:title_layout
        q.f(view4, "findViewById(...)");
        this.e = view4;
        View view5 = this.findViewById(0x7F0A0D1C);  // id:tv_sort
        q.f(view5, "findViewById(...)");
        this.f = (TextView)view5;
        View view6 = this.findViewById(0x7F0A0C5E);  // id:tv_desc
        q.f(view6, "findViewById(...)");
        this.g = (TextView)view6;
        View view7 = this.findViewById(0x7F0A0D55);  // id:tv_writer
        q.f(view7, "findViewById(...)");
        this.h = (TextView)view7;
        View view8 = this.findViewById(0x7F0A0B81);  // id:thumb_user_layout
        q.f(view8, "findViewById(...)");
        this.i = view8;
        View view9 = this.findViewById(0x7F0A0B6A);  // id:thumb_album_layout
        q.f(view9, "findViewById(...)");
        this.j = view9;
        View view10 = this.findViewById(0x7F0A0B7F);  // id:thumb_number_layout
        q.f(view10, "findViewById(...)");
        this.k = view10;
        View view11 = this.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        q.f(view11, "findViewById(...)");
        this.l = (ImageView)view11;
        View view12 = this.findViewById(0x7F0A069A);  // id:iv_thumb
        q.f(view12, "findViewById(...)");
        this.m = (ImageView)view12;
        View view13 = this.findViewById(0x7F0A0CD3);  // id:tv_number
        q.f(view13, "findViewById(...)");
        this.n = (TextView)view13;
        View view14 = this.findViewById(0x7F0A0647);  // id:iv_listen
        q.f(view14, "findViewById(...)");
        this.o = view14;
        View view15 = this.findViewById(0x7F0A061C);  // id:iv_degree
        q.f(view15, "findViewById(...)");
        this.r = view15;
        ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(context0, 66.0f), true);  // id:iv_thumb_circle_default
        ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069E)), ScreenUtils.dipToPixel(context0, 66.0f));  // id:iv_thumb_default
    }

    public ArtistCardRelayItemView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    public static final GradientDrawable a(ArtistCardRelayItemView artistCardRelayItemView0, Bitmap bitmap0) {
        e e0 = new e(bitmap0);
        e0.a = 24;
        h h0 = e0.a();
        g g0 = h0.a(i.h);
        int v = -1;
        int v1 = g0 == null ? -1 : g0.d;
        g g1 = h0.a(i.e);
        int v2 = g1 == null ? -1 : g1.d;
        g g2 = h0.a(i.d);
        if(g2 != null) {
            v = g2.d;
        }
        int[] arr_v = LyricHighlightUtils.Companion.getPaletteColor(new int[]{v1, v2, v});
        return new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{arr_v[0], arr_v[1]});
    }

    public final boolean b() {
        Context context0 = ee.i.b(this.getContext());
        Activity activity0 = context0 instanceof Activity ? ((Activity)context0) : null;
        return activity0 != null && !activity0.isFinishing() && !activity0.isDestroyed();
    }

    public final void c(String s) {
        if(this.b()) {
            Glide.with(this.getContext()).asBitmap().load(s).apply(new RequestOptions().circleCrop()).into(new a(this, 0));
        }
    }

    @NotNull
    public final String getTalkbackText() {
        if(this.c.getVisibility() == 0) {
            return this.d.getText().toString();
        }
        return this.k.getVisibility() == 0 ? this.f.getText() + ", " + this.g.getText() + ", " + this.h.getText() + ", " + this.n.getText() : this.f.getText() + ", " + this.g.getText() + ", " + this.h.getText();
    }

    public final void setData(@Nullable MEMORIALCARDRELAYLIST artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0) {
        String s11;
        String s2;
        if(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0 != null) {
            boolean z = q.b(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.type, "FEW_CARD_RELAY");
            View view0 = this.e;
            View view1 = this.c;
            View view2 = this.j;
            View view3 = this.k;
            View view4 = this.i;
            if(z) {
                view1.setVisibility(0);
                view0.setVisibility(8);
                view4.setVisibility(0);
                view2.setVisibility(8);
                view3.setVisibility(8);
                if(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.artistName.length() > 7) {
                    String s = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.artistName;
                    q.f(s, "artistName");
                    String s1 = s.substring(0, 7);
                    q.f(s1, "substring(...)");
                    s2 = s1 + "…";
                }
                else {
                    s2 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.artistName;
                }
                q.f("나와 %1$s 사이의\n특별한 순간을 확인해 보세요.", "getString(...)");
                Z.y(new Object[]{s2}, 1, "나와 %1$s 사이의\n특별한 순간을 확인해 보세요.", this.d);
                String s3 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.artistImg;
                q.f(s3, "artistImg");
                this.c(s3);
                return;
            }
            view1.setVisibility(8);
            view0.setVisibility(0);
            Context context0 = this.getContext();
            String s4 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.type;
            q.f(s4, "type");
            String s5 = MemorialCardUtils.Companion.getMemorialTitle(context0, s4);
            TextView textView0 = this.f;
            textView0.setText(s5);
            String s6 = this.getContext().getString(0x7F130124, new Object[]{artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.memberName});  // string:artist_detail_card_writer "by %1$s"
            this.h.setText(s6);
            view4.setVisibility(8);
            view2.setVisibility(8);
            view3.setVisibility(8);
            TextView textView1 = this.g;
            textView1.setVisibility(8);
            String s7 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.type;
            if(s7 != null) {
                View view5 = this.r;
                View view6 = this.o;
                TextView textView2 = this.n;
                switch(s7) {
                    case "BIRTH_DAY": {
                        String s16 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date;
                        if(s16.length() >= 5) {
                            q.f("%1$s월 %2$s일", "getString(...)");
                            s16 = String.format("%1$s월 %2$s일", Arrays.copyOf(new Object[]{o.V0(s16, new Ce.g(0, 1, 1)), o.V0(s16, new Ce.g(3, 4, 1))}, 2));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                        }
                        textView0.setText("HAPPY BIRTHDAY");
                        textView1.setVisibility(0);
                        textView1.setText(s16);
                        view4.setVisibility(0);
                        String s17 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistImg;
                        q.f(s17, "artistImg");
                        this.c(s17);
                        return;
                    }
                    case "DEBUT_DAY": {
                        String s8 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date;
                        if(s8.length() >= 10) {
                            q.f("%1$s년 %2$s월 %3$s일", "getString(...)");
                            s8 = String.format("%1$s년 %2$s월 %3$s일", Arrays.copyOf(new Object[]{o.V0(s8, new Ce.g(0, 3, 1)), o.V0(s8, new Ce.g(5, 6, 1)), o.V0(s8, new Ce.g(8, 9, 1))}, 3));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                        }
                        q.f("%1$s ANNIVERSARY", "getString(...)");
                        Z.y(new Object[]{artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.years}, 1, "%1$s ANNIVERSARY", textView0);
                        textView1.setVisibility(0);
                        textView1.setText(s8);
                        view4.setVisibility(0);
                        String s9 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistImg;
                        q.f(s9, "artistImg");
                        this.c(s9);
                        return;
                    }
                    case "FAN_DAY": {
                        textView1.setVisibility(0);
                        q.f("만난지 %1$s일 째", "getString(...)");
                        Z.y(new Object[]{artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.days}, 1, "만난지 %1$s일 째", textView1);
                        view4.setVisibility(0);
                        view2.setVisibility(8);
                        String s15 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.artistImg;
                        q.f(s15, "artistImg");
                        this.c(s15);
                        return;
                    }
                    case "FIRST_LIKE_SONG": 
                    case "FIRST_SONG": 
                    case "LAST_SONG": {
                        textView1.setVisibility(0);
                        textView1.setText(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.songName);
                        view2.setVisibility(0);
                        if(this.b()) {
                            Glide.with(this.getContext()).asBitmap().load(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.albumImg).into(new b(this));
                            return;
                        }
                        break;
                    }
                    case "HOT_DAY": {
                        String s18 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date;
                        if(s18.length() >= 10) {
                            q.f("%1$s년 %2$s월 %3$s일", "getString(...)");
                            s18 = String.format("%1$s년 %2$s월 %3$s일", Arrays.copyOf(new Object[]{o.V0(s18, new Ce.g(0, 3, 1)), o.V0(s18, new Ce.g(5, 6, 1)), o.V0(s18, new Ce.g(8, 9, 1))}, 3));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                        }
                        textView1.setVisibility(0);
                        textView1.setText(s18);
                        view3.setVisibility(0);
                        textView2.setText(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.userMaxTemper);
                        textView2.setTextSize(1, 33.0f);
                        view6.setVisibility(8);
                        view5.setVisibility(0);
                        String s19 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.bgImg;
                        q.f(s19, "bgImg");
                        this.setIvBgBackground(s19);
                        return;
                    }
                    case "MAX_MONTH": {
                        String s13 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date;
                        if(s13.length() >= 7) {
                            q.f("%1$s년 %2$s월", "getString(...)");
                            s13 = String.format("%1$s년 %2$s월", Arrays.copyOf(new Object[]{o.V0(s13, new Ce.g(0, 3, 1)), o.V0(s13, new Ce.g(5, 6, 1))}, 2));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                        }
                        textView1.setVisibility(0);
                        textView1.setText(s13);
                        view3.setVisibility(0);
                        textView2.setText(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.streamCnt);
                        textView2.setTextSize(1, 30.0f);
                        view6.setVisibility(0);
                        view5.setVisibility(8);
                        String s14 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.bgImg;
                        q.f(s14, "bgImg");
                        this.setIvBgBackground(s14);
                        return;
                    }
                    case "TEMPERATURE_TOP": {
                        String s10 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.date;
                        if(s10.length() >= 10) {
                            q.f("%1$s년 %2$s월 %3$s일", "getString(...)");
                            s10 = String.format("%1$s년 %2$s월 %3$s일", Arrays.copyOf(new Object[]{o.V0(s10, new Ce.g(0, 3, 1)), o.V0(s10, new Ce.g(5, 6, 1)), o.V0(s10, new Ce.g(8, 9, 1))}, 3));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                        }
                        textView1.setVisibility(0);
                        textView1.setText(s10);
                        view3.setVisibility(0);
                        if(q.b(artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.days, "0")) {
                            s11 = "1% 달성!";
                        }
                        else {
                            q.f("D +%1$s", "getString(...)");
                            s11 = String.format("D +%1$s", Arrays.copyOf(new Object[]{artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.days}, 1));
                        }
                        textView2.setText(s11);
                        textView2.setTextSize(1, 30.0f);
                        view6.setVisibility(8);
                        view5.setVisibility(8);
                        String s12 = artistTemperatureSummaryRes$RESPONSE$MEMORIALCARDRELAYLIST0.info.bgImg;
                        q.f(s12, "bgImg");
                        this.setIvBgBackground(s12);
                    }
                }
            }
        }
    }

    private final void setIvBgBackground(String s) {
        if(this.b()) {
            Glide.with(this.getContext()).asDrawable().load(s).into(new a(this, 1));
        }
    }
}

