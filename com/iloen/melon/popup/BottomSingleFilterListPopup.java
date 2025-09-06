package com.iloen.melon.popup;

import De.I;
import J8.Z2;
import a9.d;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.shortform.m;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000489:;B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001A\u00020\t2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0017\u001A\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u001D\u0010!\u001A\u0006\u0012\u0002\b\u00030 2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0014¢\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\fH\u0014¢\u0006\u0004\b#\u0010\u000EJ\u0015\u0010%\u001A\u00020\t2\u0006\u0010$\u001A\u00020\f¢\u0006\u0004\b%\u0010&J\u0015\u0010\'\u001A\u00020\t2\u0006\u0010$\u001A\u00020\f¢\u0006\u0004\b\'\u0010&J\u000F\u0010(\u001A\u00020\fH\u0014¢\u0006\u0004\b(\u0010\u000ER$\u0010/\u001A\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001A\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b1\u00102\u001A\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/iloen/melon/popup/BottomSingleFilterListPopup;", "Lcom/iloen/melon/popup/AbsListPopup;", "Lcom/iloen/melon/popup/ForegroundPopup;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "", "getLayoutView", "()I", "", "hasHeader", "()Z", "makeHeaderView", "()V", "", "", "filters", "checkedIndex", "setFilterItem", "(Ljava/util/List;I)V", "Landroid/view/WindowManager$LayoutParams;", "wlp", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getItemHeight", "maxHeight", "setMaxPortraitHeight", "(I)V", "setMaxLandscapeHeight", "getMaxPopupHeight", "a", "Ljava/lang/String;", "getBackTitle", "()Ljava/lang/String;", "setBackTitle", "(Ljava/lang/String;)V", "backTitle", "La9/d;", "b", "La9/d;", "getFilterListener", "()La9/d;", "setFilterListener", "(La9/d;)V", "filterListener", "Companion", "FilterData", "FilterAdapter", "FilterViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BottomSingleFilterListPopup extends AbsListPopup implements ForegroundPopup {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/BottomSingleFilterListPopup$Companion;", "", "", "NO_CHECKED_INDEX", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterData;", "Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/popup/BottomSingleFilterListPopup;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FilterAdapter extends y {
        public final BottomSingleFilterListPopup a;

        public FilterAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            this.a = bottomSingleFilterListPopup0;
            super(context0, list0);
        }

        public FilterAdapter(Context context0, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                list0 = null;
            }
            this(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((FilterViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull FilterViewHolder bottomSingleFilterListPopup$FilterViewHolder0, int v, int v1) {
            q.g(bottomSingleFilterListPopup$FilterViewHolder0, "viewHolder");
            bottomSingleFilterListPopup$FilterViewHolder0.bind(((FilterData)this.getItem(v1)));
            m m0 = new m(this.a, v1, 1);
            bottomSingleFilterListPopup$FilterViewHolder0.itemView.setOnClickListener(m0);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public FilterViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return FilterViewHolder.Companion.newInstance(viewGroup0);
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000B\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0013\u001A\u00020\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0005\u0010\u000B¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterData;", "", "", "string", "", "isChecked", "<init>", "(Ljava/lang/String;Z)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "copy", "(Ljava/lang/String;Z)Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getString", "b", "Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class FilterData {
        public static final int $stable;
        public final String a;
        public final boolean b;

        public FilterData(@NotNull String s, boolean z) {
            q.g(s, "string");
            super();
            this.a = s;
            this.b = z;
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final FilterData copy(@NotNull String s, boolean z) {
            q.g(s, "string");
            return new FilterData(s, z);
        }

        public static FilterData copy$default(FilterData bottomSingleFilterListPopup$FilterData0, String s, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                s = bottomSingleFilterListPopup$FilterData0.a;
            }
            if((v & 2) != 0) {
                z = bottomSingleFilterListPopup$FilterData0.b;
            }
            return bottomSingleFilterListPopup$FilterData0.copy(s, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof FilterData)) {
                return false;
            }
            return q.b(this.a, ((FilterData)object0).a) ? this.b == ((FilterData)object0).b : false;
        }

        @NotNull
        public final String getString() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
        }

        public final boolean isChecked() {
            return this.b;
        }

        @Override
        @NotNull
        public String toString() {
            return "FilterData(string=" + this.a + ", isChecked=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/Z2;", "binding", "<init>", "(LJ8/Z2;)V", "Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterData;", "data", "Lie/H;", "bind", "(Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterData;)V", "a", "LJ8/Z2;", "getBinding", "()LJ8/Z2;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class FilterViewHolder extends O0 {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "parent", "Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder;", "newInstance", "(Landroid/view/ViewGroup;)Lcom/iloen/melon/popup/BottomSingleFilterListPopup$FilterViewHolder;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.popup.BottomSingleFilterListPopup.FilterViewHolder.Companion {
            public com.iloen.melon.popup.BottomSingleFilterListPopup.FilterViewHolder.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final FilterViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0844, viewGroup0, false);  // layout:single_filter_list_item
                int v = 0x7F0A0610;  // id:iv_check
                ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0610);  // id:iv_check
                if(imageView0 != null) {
                    v = 0x7F0A0D34;  // id:tv_title
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D34);  // id:tv_title
                    if(melonTextView0 != null) {
                        return new FilterViewHolder(new Z2(((RelativeLayout)view0), imageView0, melonTextView0));
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
            }
        }

        @NotNull
        public static final com.iloen.melon.popup.BottomSingleFilterListPopup.FilterViewHolder.Companion Companion;
        public final Z2 a;

        static {
            FilterViewHolder.Companion = new com.iloen.melon.popup.BottomSingleFilterListPopup.FilterViewHolder.Companion(null);
        }

        public FilterViewHolder(@NotNull Z2 z20) {
            q.g(z20, "binding");
            super(z20.a);
            this.a = z20;
        }

        public final void bind(@Nullable FilterData bottomSingleFilterListPopup$FilterData0) {
            Z2 z20 = this.a;
            String s = null;
            z20.c.setText((bottomSingleFilterListPopup$FilterData0 == null ? null : bottomSingleFilterListPopup$FilterData0.getString()));
            if(bottomSingleFilterListPopup$FilterData0 != null && bottomSingleFilterListPopup$FilterData0.isChecked()) {
                int v = ColorUtils.getColor(this.itemView.getContext(), 0x7F06017C);  // color:green500s_support_high_contrast
                z20.c.setTextColor(v);
                z20.b.setVisibility(0);
                MelonTextView melonTextView0 = z20.c;
                Context context0 = this.itemView.getContext();
                if(context0 != null && context0.getResources() != null) {
                    s = "선택됨";
                }
                ViewUtils.setContentDescriptionWithButtonClassName(melonTextView0, s + ", " + z20.c.getText());
                return;
            }
            int v1 = ColorUtils.getColor(this.itemView.getContext(), 0x7F060169);  // color:gray850s
            z20.c.setTextColor(v1);
            z20.b.setVisibility(4);
            CharSequence charSequence0 = z20.c.getText();
            ViewUtils.setContentDescriptionWithButtonClassName(z20.c, charSequence0);
        }

        @NotNull
        public final Z2 getBinding() {
            return this.a;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int NO_CHECKED_INDEX = -1;
    public String a;
    public d b;
    public final FilterAdapter c;
    public int d;
    public int e;

    static {
        BottomSingleFilterListPopup.Companion = new Companion(null);
        BottomSingleFilterListPopup.$stable = 8;
    }

    public BottomSingleFilterListPopup(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0);
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        this.c = new FilterAdapter(this, context0, null, 2, null);
        this.d = -1;
        this.e = -1;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    @NotNull
    public j0 createAdapter(@Nullable Context context0) {
        return this.c;
    }

    @Nullable
    public final String getBackTitle() {
        return this.a;
    }

    @Nullable
    public final d getFilterListener() {
        return this.b;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public int getItemHeight() {
        return this.getContext().getResources().getDimensionPixelSize(0x7F070309);  // dimen:melon_popup_text_list_row_height
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public int getLayoutView() {
        return 0x7F0D005B;  // layout:bottom_single_filter_list_popup
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public int getMaxPopupHeight() {
        if(ScreenUtils.isOrientationPortrait(this.getContext())) {
            int v = this.d;
            return v <= 0 ? super.getMaxPopupHeight() : v;
        }
        int v1 = this.e;
        return v1 <= 0 ? super.getMaxPopupHeight() : v1;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public boolean hasHeader() {
        return true;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public void makeHeaderView() {
        View view0 = this.findViewById(0x7F0A0954);  // id:popup_header_for_no_title
        String s = this.getTitle();
        if(s != null && s.length() != 0) {
            View view1 = this.getHeaderView();
            if(view1 != null) {
                view1.setVisibility(0);
            }
            if(view0 != null) {
                view0.setVisibility(8);
            }
            View view2 = this.getHeaderView();
            if(view2 != null) {
                view2.setBackgroundResource(0x7F08091C);  // drawable:shape_white001s_top_round8
            }
            this.setHeaderHeight(this.getContext().getResources().getDimensionPixelSize(0x7F070300));  // dimen:melon_popup_header_height
            View view3 = this.getHeaderView();
            TextView textView0 = null;
            TextView textView1 = view3 == null ? null : ((TextView)view3.findViewById(0x7F0A0B9A));  // id:title_front_item
            if(textView1 != null) {
                textView1.setText(this.getTitle());
            }
            if(this.a != null && this.a.length() != 0) {
                View view4 = this.getHeaderView();
                if(view4 != null) {
                    textView0 = (TextView)view4.findViewById(0x7F0A0B92);  // id:title_back_item
                }
                if(textView0 != null) {
                    textView0.setText(this.a);
                }
                if(textView0 != null) {
                    textView0.setVisibility(0);
                }
            }
            return;
        }
        if(view0 != null) {
            view0.setVisibility(0);
        }
        View view5 = this.getHeaderView();
        if(view5 != null) {
            view5.setVisibility(8);
        }
        if(view0 != null) {
            view0.setBackgroundResource(0x7F08091C);  // drawable:shape_white001s_top_round8
        }
        this.setHeaderHeight(this.getContext().getResources().getDimensionPixelSize(0x7F070056));  // dimen:bottom_single_list_popup_header_for_no_title_height
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.getAttributes().windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
        }
    }

    public final void setBackTitle(@Nullable String s) {
        this.a = s;
    }

    public final void setFilterItem(@NotNull List list0, int v) {
        q.g(list0, "filters");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        int v1 = 0;
        for(Object object0: list0) {
            if(v1 >= 0) {
                arrayList0.add(new FilterData(((String)object0), v1 == v));
                ++v1;
                continue;
            }
            k.O();
            throw null;
        }
        this.c.clear();
        this.c.addAll(arrayList0);
    }

    public static void setFilterItem$default(BottomSingleFilterListPopup bottomSingleFilterListPopup0, List list0, int v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = -1;
        }
        bottomSingleFilterListPopup0.setFilterItem(list0, v);
    }

    public final void setFilterListener(@Nullable d d0) {
        this.b = d0;
    }

    public final void setMaxLandscapeHeight(int v) {
        this.e = v;
    }

    public final void setMaxPortraitHeight(int v) {
        this.d = v;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(@NotNull WindowManager.LayoutParams windowManager$LayoutParams0) {
        q.g(windowManager$LayoutParams0, "wlp");
        windowManager$LayoutParams0.gravity = 80;
        windowManager$LayoutParams0.width = -1;
        return windowManager$LayoutParams0;
    }
}

