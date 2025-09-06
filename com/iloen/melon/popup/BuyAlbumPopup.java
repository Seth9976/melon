package com.iloen.melon.popup;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import e.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R6\u0010#\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/popup/BuyAlbumPopup;", "Lcom/iloen/melon/popup/MelonBaseListPopup;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/WindowManager$LayoutParams;", "wlp", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "", "getLayoutView", "()I", "Lcom/iloen/melon/popup/OnClickListener;", "a", "Lcom/iloen/melon/popup/OnClickListener;", "getClickListener", "()Lcom/iloen/melon/popup/OnClickListener;", "setClickListener", "(Lcom/iloen/melon/popup/OnClickListener;)V", "clickListener", "", "Lcom/iloen/melon/popup/AlbumDataSet;", "value", "c", "Ljava/util/List;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "dataList", "BuyAlbumChoiceAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BuyAlbumPopup extends MelonBaseListPopup {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/popup/BuyAlbumPopup$BuyAlbumChoiceAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/popup/BuyAlbumPopup;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "getItemCount", "()I", "holder", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "ItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class BuyAlbumChoiceAdapter extends j0 {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/popup/BuyAlbumPopup$BuyAlbumChoiceAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/popup/BuyAlbumPopup$BuyAlbumChoiceAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getRadioIv", "()Landroid/widget/ImageView;", "radioIv", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "titleTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemViewHolder extends O0 {
            public final ImageView a;
            public final TextView b;

            public ItemViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                super(view0);
                View view1 = view0.findViewById(0x7F0A099A);  // id:radio_iv
                q.f(view1, "findViewById(...)");
                this.a = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view2, "findViewById(...)");
                this.b = (TextView)view2;
            }

            @NotNull
            public final ImageView getRadioIv() {
                return this.a;
            }

            @NotNull
            public final TextView getTitleTv() {
                return this.b;
            }
        }

        public final BuyAlbumPopup a;

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return BuyAlbumPopup.this.getDataList().size();
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            q.g(o00, "holder");
            AlbumDataSet albumDataSet0 = (AlbumDataSet)BuyAlbumPopup.this.getDataList().get(v);
            ((ItemViewHolder)o00).getRadioIv().setImageTintList(null);
            ((ItemViewHolder)o00).getRadioIv().setImageResource((albumDataSet0.isChecked() ? 0x7F080167 : 0x7F080166));  // drawable:btn_common_radio_on
            ((ItemViewHolder)o00).getTitleTv().setText(albumDataSet0.getTitle());
            b b0 = new b(BuyAlbumPopup.this, this, v);
            ((ItemViewHolder)o00).itemView.setOnClickListener(b0);
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(BuyAlbumPopup.this.getContext()).inflate(0x7F0D05A1, viewGroup0, false);  // layout:popup_buy_album_layout_item
            q.f(view0, "inflate(...)");
            return new ItemViewHolder(this, view0);
        }
    }

    public static final int $stable = 8;
    public OnClickListener a;
    public BuyAlbumChoiceAdapter b;
    public List c;

    public BuyAlbumPopup(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0);
        this.c = new ArrayList();
    }

    @Nullable
    public final OnClickListener getClickListener() {
        return this.a;
    }

    @NotNull
    public final List getDataList() {
        return this.c;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public int getLayoutView() {
        return 0x7F0D05A0;  // layout:popup_buy_album_layout
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
        }
        this.b = new BuyAlbumChoiceAdapter(this);
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setAdapter(this.b);
        recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
        recyclerView0.setHasFixedSize(true);
        ((TextView)this.findViewById(0x7F0A01F6)).setOnClickListener(new a(this, 0));  // id:cancel_tv
        ((TextView)this.findViewById(0x7F0A01EA)).setOnClickListener(new a(this, 1));  // id:buy_tv
    }

    public final void setClickListener(@Nullable OnClickListener onClickListener0) {
        this.a = onClickListener0;
    }

    public final void setDataList(@NotNull List list0) {
        q.g(list0, "value");
        this.c = list0;
        int v = 0;
        for(Object object0: list0) {
            if(v >= 0) {
                ((AlbumDataSet)object0).setChecked(v == 0);
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        BuyAlbumChoiceAdapter buyAlbumPopup$BuyAlbumChoiceAdapter0 = this.b;
        if(buyAlbumPopup$BuyAlbumChoiceAdapter0 != null) {
            buyAlbumPopup$BuyAlbumChoiceAdapter0.notifyDataSetChanged();
        }
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(@NotNull WindowManager.LayoutParams windowManager$LayoutParams0) {
        q.g(windowManager$LayoutParams0, "wlp");
        return windowManager$LayoutParams0;
    }
}

