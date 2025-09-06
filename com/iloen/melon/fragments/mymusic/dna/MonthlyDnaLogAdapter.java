package com.iloen.melon.fragments.mymusic.dna;

import Ae.f;
import Cb.k;
import J8.B0;
import J8.C0;
import J8.D0;
import J8.E0;
import J8.G0;
import J8.H0;
import J8.f2;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.u;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.ARTISTTOP;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.GNRTOP.LIKEGNRTOP3;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.GNRTOP;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.SONGTOP;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.TAGSTOP;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.SongInfoBase;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.i;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B3\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ%\u0010\u0012\u001A\u00020\u00112\u0016\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\rH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\rH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010 ¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogAdapter;", "Lr8/i;", "Lcom/iloen/melon/fragments/mymusic/dna/DnaLogItemModel;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "Lcom/iloen/melon/fragments/mymusic/dna/DnaMonthlyLogClickListener;", "onMonthlyLogClickListener", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/iloen/melon/fragments/mymusic/dna/DnaMonthlyLogClickListener;)V", "", "getRandomColor", "()I", "newItems", "Lie/H;", "updateItemModelList", "(Ljava/util/ArrayList;)V", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/mymusic/dna/DnaMonthlyLogClickListener;", "DiffDefault", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MonthlyDnaLogAdapter extends i {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002\u0012\u0016\u0010\u0007\u001A\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R$\u0010\u0007\u001A\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogAdapter$DiffDefault;", "Landroidx/recyclerview/widget/s;", "", "oldItems", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/mymusic/dna/DnaLogItemModel;", "Lkotlin/collections/ArrayList;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/ArrayList;)V", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "Ljava/util/List;", "Ljava/util/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class DiffDefault extends s {
        @NotNull
        private final ArrayList newItems;
        @NotNull
        private final List oldItems;

        public DiffDefault(@NotNull List list0, @NotNull ArrayList arrayList0) {
            q.g(list0, "oldItems");
            q.g(arrayList0, "newItems");
            super();
            this.oldItems = list0;
            this.newItems = arrayList0;
        }

        @Override  // androidx.recyclerview.widget.s
        public boolean areContentsTheSame(int v, int v1) {
            return q.b(this.oldItems.get(v), this.newItems.get(v1));
        }

        @Override  // androidx.recyclerview.widget.s
        public boolean areItemsTheSame(int v, int v1) {
            return q.b(this.oldItems.get(v), this.newItems.get(v1));
        }

        @Override  // androidx.recyclerview.widget.s
        public int getNewListSize() {
            return this.newItems.size();
        }

        @Override  // androidx.recyclerview.widget.s
        public int getOldListSize() {
            return this.oldItems.size();
        }
    }

    public static final int $stable = 8;
    @NotNull
    private final DnaMonthlyLogClickListener onMonthlyLogClickListener;

    public MonthlyDnaLogAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0, @NotNull DnaMonthlyLogClickListener dnaMonthlyLogClickListener0) {
        q.g(context0, "context");
        q.g(dnaMonthlyLogClickListener0, "onMonthlyLogClickListener");
        super(context0, arrayList0);
        this.onMonthlyLogClickListener = dnaMonthlyLogClickListener0;
    }

    public static void d(MonthlyDnaLogAdapter monthlyDnaLogAdapter0, View view0) {
        MonthlyDnaLogAdapter.onBindViewImpl$lambda$11(monthlyDnaLogAdapter0, view0);
    }

    @Override  // r8.i
    public int getItemViewTypeImpl(int v, int v1) {
        DnaLogItemModel dnaLogItemModel0 = (DnaLogItemModel)this.getItem(v1);
        return dnaLogItemModel0 == null ? -1 : dnaLogItemModel0.getViewType();
    }

    private final int getRandomColor() {
        int[] arr_v = this.getContext().getResources().getIntArray(0x7F03001A);  // array:music_dna_monthly_tag_background_colors
        q.f(arr_v, "getIntArray(...)");
        return arr_v[f.b.c(3)];
    }

    @Override  // r8.i
    public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
        q.g(o00, "viewHolder");
        DnaLogItemModel dnaLogItemModel0 = (DnaLogItemModel)this.getItem(v1);
        if(dnaLogItemModel0 != null) {
            int v2 = 0;
            Object object0 = dnaLogItemModel0.getData();
            if(object0 != null) {
                if(o00 instanceof DnaSummaryViewHolder) {
                    H0 h00 = ((DnaSummaryViewHolder)o00).getBinding();
                    Spanned spanned0 = Html.fromHtml(((SONGTOP)object0).songTitle, 0);
                    h00.d.setText(spanned0);
                    if(((SONGTOP)object0).songTop3.size() < 2) {
                        ((DnaSummaryViewHolder)o00).getBinding().c.setVisibility(8);
                        ((DnaSummaryViewHolder)o00).getBinding().b.setVisibility(8);
                        return;
                    }
                    ((DnaSummaryViewHolder)o00).getBinding().c.setVisibility(0);
                    ((DnaSummaryViewHolder)o00).getBinding().b.setVisibility(0);
                    ((DnaSummaryViewHolder)o00).getBinding().c.setText(((SONGTOP)object0).songSubTitle);
                    H0 h01 = ((DnaSummaryViewHolder)o00).getBinding();
                    h01.b.setHasFixedSize(true);
                    Context context0 = h01.b.getContext();
                    q.f(context0, "getContext(...)");
                    String s = ((SONGTOP)object0).songSubTitle;
                    q.f(s, "songSubTitle");
                    com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter dnaSummaryViewHolder$MonthlyDnaLogAdapter0 = new com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter(context0, s, ((SONGTOP)object0).songTop3);
                    dnaSummaryViewHolder$MonthlyDnaLogAdapter0.setOnSongItemClickListener(new OnSongItemClickListener() {
                        @Override  // com.iloen.melon.fragments.mymusic.dna.OnSongItemClickListener
                        public void onSongItemClickListener(SongInfoBase songInfoBase0, Bundle bundle0) {
                            q.g(songInfoBase0, "songInfo");
                            MonthlyDnaLogAdapter.this.onMonthlyLogClickListener.onSongItemClickListener(songInfoBase0, bundle0);
                        }

                        @Override  // com.iloen.melon.fragments.mymusic.dna.OnSongItemClickListener
                        public void onSongPlayClickListener(SongInfoBase songInfoBase0, Bundle bundle0) {
                            q.g(songInfoBase0, "songInfo");
                            MonthlyDnaLogAdapter.this.onMonthlyLogClickListener.onSongPlayClickListener(songInfoBase0, bundle0);
                        }
                    });
                    ItemDecoration dnaSummaryViewHolder$ItemDecoration0 = new ItemDecoration();
                    h01.b.addItemDecoration(dnaSummaryViewHolder$ItemDecoration0);
                    h01.b.setAdapter(dnaSummaryViewHolder$MonthlyDnaLogAdapter0);
                    return;
                }
                if(o00 instanceof MostListenedArtistViewHolder) {
                    q.f("을", "getString(...)");
                    q.f("를", "getString(...)");
                    String s1 = ((ARTISTTOP)object0).artistInfo.getArtistName();
                    if(s1 == null) {
                        s1 = "";
                    }
                    String s2 = k.d(s1, "을", "를");
                    ((MostListenedArtistViewHolder)o00).getBinding().g.setText(((ARTISTTOP)object0).artistTitle);
                    ((MostListenedArtistViewHolder)o00).getBinding().d.setText(((ARTISTTOP)object0).artistInfo.getArtistName());
                    ((MostListenedArtistViewHolder)o00).getBinding().f.setText(s2);
                    ((MostListenedArtistViewHolder)o00).getBinding().e.setText("좋아해요.");
                    Glide.with(this.getContext()).load(((ARTISTTOP)object0).artistInfo.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(((MostListenedArtistViewHolder)o00).getBinding().c);
                    C0 c00 = ((MostListenedArtistViewHolder)o00).getBinding();
                    Ad.s s3 = new Ad.s(27, ((ARTISTTOP)object0), this);
                    c00.c.setOnClickListener(s3);
                    C0 c01 = ((MostListenedArtistViewHolder)o00).getBinding();
                    com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogAdapter.onBindViewImpl.3 monthlyDnaLogAdapter$onBindViewImpl$30 = new View.AccessibilityDelegate() {
                        @Override  // android.view.View$AccessibilityDelegate
                        public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                            q.g(view0, "host");
                            q.g(accessibilityNodeInfo0, "info");
                            super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                            String s = s2.artistInfo.getArtistName();
                            CharSequence charSequence0 = ((MostListenedArtistViewHolder)this.$viewHolder).getBinding().e.getText();
                            accessibilityNodeInfo0.setContentDescription(s + o00 + charSequence0);
                        }
                    };
                    c01.b.setAccessibilityDelegate(monthlyDnaLogAdapter$onBindViewImpl$30);
                    return;
                }
                if(o00 instanceof RepresentTagViewHolder) {
                    Drawable drawable0 = ((RepresentTagViewHolder)o00).getBinding().b.getBackground();
                    q.e(drawable0, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable)drawable0).setColor(ColorStateList.valueOf(this.getRandomColor()));
                    ((RepresentTagViewHolder)o00).getBinding().e.setText(((TAGSTOP)object0).tagTitle);
                    E0 e00 = ((RepresentTagViewHolder)o00).getBinding();
                    FlexboxLayoutManager flexboxLayoutManager0 = new FlexboxLayoutManager(((RepresentTagViewHolder)o00).getBinding().a.getContext());
                    flexboxLayoutManager0.I(1);
                    flexboxLayoutManager0.H(0);
                    e00.d.setLayoutManager(flexboxLayoutManager0);
                    Context context1 = e00.d.getContext();
                    q.f(context1, "getContext(...)");
                    RepresentTagAdapter representTagViewHolder$RepresentTagAdapter0 = new RepresentTagAdapter(context1, ((TAGSTOP)object0).tags);
                    representTagViewHolder$RepresentTagAdapter0.setOnTagItemClickListener(new OnTagItemClickListener() {
                        @Override  // com.iloen.melon.fragments.mymusic.dna.OnTagItemClickListener
                        public void onTagItemClickListener(TagInfoBase tagInfoBase0, Bundle bundle0) {
                            q.g(tagInfoBase0, "tagInfo");
                            Bundle bundle1 = d5.f.j(new m[]{new m("Layer1", this.tagTitle)});
                            MonthlyDnaLogAdapter.this.onMonthlyLogClickListener.onTagItemClickListener(tagInfoBase0, bundle1);
                        }
                    });
                    com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.ItemDecoration representTagViewHolder$ItemDecoration0 = new com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.ItemDecoration();
                    e00.d.addItemDecoration(representTagViewHolder$ItemDecoration0);
                    e00.d.setAdapter(representTagViewHolder$RepresentTagAdapter0);
                    return;
                }
                if(o00 instanceof MostListenedGenreViewHolder) {
                    q.f("을", "getString(...)");
                    q.f("를", "getString(...)");
                    q.f("\n많이 들었어요.", "getString(...)");
                    String s4 = ((GNRTOP)object0).genreName;
                    q.f(s4, "genreName");
                    String s5 = s4 + k.d(s4, "을", "를");
                    ((MostListenedGenreViewHolder)o00).getBinding().g.setText(((GNRTOP)object0).gnrTitle);
                    ((MostListenedGenreViewHolder)o00).getBinding().h.setText(s5 + "\n많이 들었어요.");
                    ArrayList arrayList0 = ((GNRTOP)object0).likeGnrTop3;
                    if(arrayList0 != null && !arrayList0.isEmpty() && ((GNRTOP)object0).likeGnrTop3.size() >= 3) {
                        ((MostListenedGenreViewHolder)o00).getBinding().c.setVisibility(0);
                        ArrayList arrayList1 = new ArrayList();
                        arrayList1.add(((MostListenedGenreViewHolder)o00).getBinding().d);
                        arrayList1.add(((MostListenedGenreViewHolder)o00).getBinding().e);
                        arrayList1.add(((MostListenedGenreViewHolder)o00).getBinding().f);
                        for(Object object1: arrayList1) {
                            if(v2 >= 0) {
                                LIKEGNRTOP3 musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30 = (LIKEGNRTOP3)((GNRTOP)object0).likeGnrTop3.get(v2);
                                int v3 = ScreenUtils.dipToPixel(this.getContext(), 44.0f);
                                ViewUtils.setDefaultImage(((f2)object1).e.c, v3);
                                Glide.with(this.getContext()).load(musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30.albumImg).into(((f2)object1).e.b);
                                ((f2)object1).h.setText(musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30.songName);
                                String s6 = musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30.getArtistNames();
                                ((f2)object1).g.setText(s6);
                                ((f2)object1).b.setVisibility(8);
                                ViewUtils.showWhen(((f2)object1).f.findViewById(0x7F0A063B), musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30.isAdult);  // id:iv_list_19
                                Bundle bundle0 = d5.f.j(new m[]{new m("Layer1", ((GNRTOP)object0).gnrTitle), new m("ordnum", String.valueOf(v2 + 1))});
                                b b0 = new b(this, musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, bundle0, 0);
                                ((f2)object1).c.setOnClickListener(b0);
                                b b1 = new b(this, musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, bundle0, 1);
                                ((f2)object1).e.b.setOnClickListener(b1);
                                ++v2;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                        ViewUtils.showWhen(((MostListenedGenreViewHolder)o00).getBinding().b, ((GNRTOP)object0).genreBtn);
                        D0 d00 = ((MostListenedGenreViewHolder)o00).getBinding();
                        Ad.s s7 = new Ad.s(28, ((GNRTOP)object0), this);
                        d00.b.setOnClickListener(s7);
                        return;
                    }
                    ((MostListenedGenreViewHolder)o00).getBinding().c.setVisibility(8);
                    return;
                }
                if(o00 instanceof LastMonthLogViewHolder) {
                    B0 b00 = ((LastMonthLogViewHolder)o00).getBinding();
                    Ad.s s8 = new Ad.s(29, this, ((DnaMonthData)object0));
                    b00.b.setOnClickListener(s8);
                    B0 b01 = ((LastMonthLogViewHolder)o00).getBinding();
                    CharSequence charSequence0 = ((LastMonthLogViewHolder)o00).getBinding().b.getText();
                    ViewUtils.setContentDescriptionWithButtonClassName(b01.b, charSequence0);
                    return;
                }
                if(o00 instanceof ShortcutsViewHolder) {
                    G0 g00 = ((ShortcutsViewHolder)o00).getBinding();
                    p p0 = new p(this, 5);
                    g00.b.setOnClickListener(p0);
                }
            }
        }
    }

    private static final void onBindViewImpl$lambda$10(MonthlyDnaLogAdapter monthlyDnaLogAdapter0, DnaMonthData monthlyDnaLogViewModel$DnaMonthData0, View view0) {
        monthlyDnaLogAdapter0.onMonthlyLogClickListener.onLastMonthClickListener(monthlyDnaLogViewModel$DnaMonthData0.getMonthList());
    }

    private static final void onBindViewImpl$lambda$11(MonthlyDnaLogAdapter monthlyDnaLogAdapter0, View view0) {
        monthlyDnaLogAdapter0.onMonthlyLogClickListener.onShortcutClickListener();
    }

    private static final void onBindViewImpl$lambda$2(ARTISTTOP musicDnaMonthlyLogDetailRes$ARTISTTOP0, MonthlyDnaLogAdapter monthlyDnaLogAdapter0, View view0) {
        Bundle bundle0 = d5.f.j(new m[]{new m("Layer1", musicDnaMonthlyLogDetailRes$ARTISTTOP0.artistTitle)});
        ArtistInfoBase artistInfoBase0 = musicDnaMonthlyLogDetailRes$ARTISTTOP0.artistInfo;
        q.f(artistInfoBase0, "artistInfo");
        monthlyDnaLogAdapter0.onMonthlyLogClickListener.onArtistItemClickListener(artistInfoBase0, bundle0);
    }

    private static final void onBindViewImpl$lambda$8$lambda$6(MonthlyDnaLogAdapter monthlyDnaLogAdapter0, LIKEGNRTOP3 musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, Bundle bundle0, View view0) {
        q.d(musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30);
        monthlyDnaLogAdapter0.onMonthlyLogClickListener.onSongPlayClickListener(musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, bundle0);
    }

    private static final void onBindViewImpl$lambda$8$lambda$7(MonthlyDnaLogAdapter monthlyDnaLogAdapter0, LIKEGNRTOP3 musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, Bundle bundle0, View view0) {
        q.d(musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30);
        monthlyDnaLogAdapter0.onMonthlyLogClickListener.onAlbumItemClickListener(musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, bundle0);
    }

    private static final void onBindViewImpl$lambda$9(GNRTOP musicDnaMonthlyLogDetailRes$GNRTOP0, MonthlyDnaLogAdapter monthlyDnaLogAdapter0, View view0) {
        Bundle bundle0 = d5.f.j(new m[]{new m("Layer1", musicDnaMonthlyLogDetailRes$GNRTOP0.gnrTitle)});
        String s = musicDnaMonthlyLogDetailRes$GNRTOP0.genreCode;
        q.f(s, "genreCode");
        monthlyDnaLogAdapter0.onMonthlyLogClickListener.onMostGenreMoreClickListener(s, bundle0);
    }

    @Override  // r8.i
    @NotNull
    public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        switch(v) {
            case 1: {
                return DnaSummaryViewHolder.Companion.newInstance(viewGroup0);
            }
            case 2: {
                return MostListenedArtistViewHolder.Companion.newInstance(viewGroup0);
            }
            case 3: {
                return RepresentTagViewHolder.Companion.newInstance(viewGroup0);
            }
            case 4: {
                return MostListenedGenreViewHolder.Companion.newInstance(viewGroup0);
            }
            case 5: {
                return LastMonthLogViewHolder.Companion.newInstance(viewGroup0);
            }
            case 6: {
                return ShortcutsViewHolder.Companion.newInstance(viewGroup0);
            }
            default: {
                throw new IllegalStateException("MonthlyDnaLogAdapter::onCreateViewHolderImpl() - invalid viewType {value=" + v + "}");
            }
        }
    }

    public final void updateItemModelList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "newItems");
        List list0 = this.getList();
        q.f(list0, "getList(...)");
        u u0 = d.a(new DiffDefault(list0, arrayList0));
        this.clear();
        this.addAll(arrayList0);
        u0.a(new c(this));
    }
}

