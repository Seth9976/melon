package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.PopupTextListAdapter;
import com.iloen.melon.adapters.RecyclerItemClickListener.OnItemClickListener;
import com.iloen.melon.utils.color.ColorUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import n8.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 62\u00020\u0001:\u00016B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B5\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u0004\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001A\u00020\u00142\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u0019¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0014¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0014H\u0014¢\u0006\u0004\b \u0010!J\u001F\u0010%\u001A\b\u0012\u0002\b\u0003\u0018\u00010$2\b\u0010#\u001A\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b%\u0010&R\"\u0010.\u001A\u00020\'8\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00102\u001A\u00020\'8\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b/\u0010)\u001A\u0004\b0\u0010+\"\u0004\b1\u0010-R\u0018\u00104\u001A\u0004\u0018\u0001038\u0004@\u0004X\u0085\u000E¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/iloen/melon/popup/TextListPopup;", "Lcom/iloen/melon/popup/AbsListPopup;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "icons", "", "", "texts", "Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;", "listener", "(Landroid/app/Activity;[I[Ljava/lang/String;Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;)V", "Landroid/view/WindowManager$LayoutParams;", "wlp", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "setOnItemClickListener", "(Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;)V", "", "heightPerScreen", "setHeight", "(F)V", "", "isOverSize", "()Z", "onViewCreated", "()V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "", "d", "I", "getItemBgColor", "()I", "setItemBgColor", "(I)V", "itemBgColor", "e", "getTextColor", "setTextColor", "textColor", "Lcom/iloen/melon/adapters/PopupTextListAdapter;", "mAdapter", "Lcom/iloen/melon/adapters/PopupTextListAdapter;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class TextListPopup extends AbsListPopup {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/popup/TextListPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "MAX_DP_COUNT", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final int[] a;
    public final String[] b;
    public ArrayList c;
    public int d;
    public int e;
    public int f;
    @Nullable
    protected PopupTextListAdapter mAdapter;

    static {
        TextListPopup.Companion = new Companion(null);
        TextListPopup.$stable = 8;
    }

    public TextListPopup(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0);
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }

    public TextListPopup(@NotNull Activity activity0, @Nullable int[] arr_v, @Nullable String[] arr_s, @Nullable RecyclerItemClickListener.OnItemClickListener recyclerItemClickListener$OnItemClickListener0) {
        q.g(activity0, "activity");
        super(activity0);
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.a = arr_v;
        this.b = arr_s;
        PopupTextListAdapter popupTextListAdapter0 = new PopupTextListAdapter(this.getContext());
        popupTextListAdapter0.c = 0x7F0D05AB;  // layout:popup_listitem
        popupTextListAdapter0.f = null;
        popupTextListAdapter0.e = 0;
        this.mAdapter = popupTextListAdapter0;
        this.setOnItemClickListener(recyclerItemClickListener$OnItemClickListener0);
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    @Nullable
    public j0 createAdapter(@Nullable Context context0) {
        String[] arr_s = this.b;
        if(arr_s != null && this.c == null) {
            this.c = new ArrayList();
            for(int v = 0; v < arr_s.length; ++v) {
                p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                p0.a = v;
                p0.c = arr_s[v];
                int[] arr_v = this.a;
                if(arr_v != null) {
                    p0.b = arr_v[v];
                }
                ArrayList arrayList0 = this.c;
                if(arrayList0 != null) {
                    arrayList0.add(p0);
                }
            }
        }
        PopupTextListAdapter popupTextListAdapter0 = this.mAdapter;
        if(popupTextListAdapter0 != null) {
            popupTextListAdapter0.f = this.c;
            popupTextListAdapter0.e = 0;
            popupTextListAdapter0.notifyDataSetChanged();
        }
        PopupTextListAdapter popupTextListAdapter1 = this.mAdapter;
        if(popupTextListAdapter1 != null) {
            popupTextListAdapter1.d = this.d;
            popupTextListAdapter1.h = this.e;
            popupTextListAdapter1.notifyDataSetChanged();
        }
        return this.mAdapter;
    }

    public final int getItemBgColor() {
        return this.d;
    }

    public final int getTextColor() {
        return this.e;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public boolean isOverSize() {
        return (this.mAdapter == null ? 0 : this.mAdapter.getItemCount()) > 5;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            if(windowManager$LayoutParams0 != null) {
                windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
            }
        }
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public void onViewCreated() {
        super.onViewCreated();
        PopupTextListAdapter popupTextListAdapter0 = this.mAdapter;
        if(popupTextListAdapter0 != null) {
            popupTextListAdapter0.j = this.getListener();
        }
        if(this.f > 0) {
            RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-1, -1);
            View view0 = this.getShowingView();
            if(view0 != null) {
                view0.setLayoutParams(relativeLayout$LayoutParams0);
            }
            View view1 = this.getShowingView();
            if(view1 != null) {
                view1.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0600C5));  // color:common_popup_bg
            }
        }
    }

    public final void setHeight(float f) {
        int v = this.getMaxPopupHeight(f);
        this.f = v;
        this.mPopupHeight = v;
    }

    public final void setItemBgColor(int v) {
        this.d = v;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public void setOnItemClickListener(@Nullable RecyclerItemClickListener.OnItemClickListener recyclerItemClickListener$OnItemClickListener0) {
        super.setOnItemClickListener(recyclerItemClickListener$OnItemClickListener0);
        PopupTextListAdapter popupTextListAdapter0 = this.mAdapter;
        if(popupTextListAdapter0 != null) {
            popupTextListAdapter0.j = recyclerItemClickListener$OnItemClickListener0;
        }
    }

    public final void setTextColor(int v) {
        this.e = v;
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

