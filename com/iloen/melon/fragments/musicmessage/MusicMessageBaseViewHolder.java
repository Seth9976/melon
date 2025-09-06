package com.iloen.melon.fragments.musicmessage;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u0000 **\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001*B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001B\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nJ\'\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001A\u00020\u00132\b\u0010\t\u001A\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001A\u00020\u00132\b\u0010\u000B\u001A\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001A\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001A\u0010\u001BR$\u0010\u001D\u001A\u0004\u0018\u00010\u001C8\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u001E\u0010$\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010#8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010&\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010\u001B\"\u0004\b)\u0010\u0007¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "", "T", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "fragment", "(Landroid/view/View;Lcom/iloen/melon/fragments/MetaContentBaseFragment;)V", "info", "", "adapterposition", "dataposition", "Lie/H;", "bindView", "(Ljava/lang/Object;II)V", "Landroidx/fragment/app/I;", "", "isFragmentValid", "(Landroidx/fragment/app/I;)Z", "isContentListValid", "(Ljava/lang/Object;)Z", "getFragment", "()Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "getMainContainer", "()Landroid/view/View;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "Ljava/lang/ref/WeakReference;", "mFragmentRef", "Ljava/lang/ref/WeakReference;", "container", "Landroid/view/View;", "getContainer", "setContainer", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicMessageBaseViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    public static final String TAG = "MusicMessageBaseViewHolder";
    @Nullable
    private View container;
    @Nullable
    private Context mContext;
    @Nullable
    private WeakReference mFragmentRef;

    static {
        MusicMessageBaseViewHolder.Companion = new Companion(null);
        MusicMessageBaseViewHolder.$stable = 8;
    }

    public MusicMessageBaseViewHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
    }

    public MusicMessageBaseViewHolder(@NotNull View view0, @Nullable MetaContentBaseFragment metaContentBaseFragment0) {
        q.g(view0, "itemView");
        this(view0);
        this.mContext = metaContentBaseFragment0 == null ? null : metaContentBaseFragment0.getContext();
        this.container = view0;
        this.mFragmentRef = metaContentBaseFragment0 == null ? null : new WeakReference(metaContentBaseFragment0);
        ViewUtils.showWhen(this.container, false);
    }

    public abstract void bindView(@NotNull Object arg1, int arg2, int arg3);

    @Nullable
    public final View getContainer() {
        return this.container;
    }

    @Nullable
    public MetaContentBaseFragment getFragment() {
        WeakReference weakReference0 = this.mFragmentRef;
        if(weakReference0 == null) {
            throw new NullPointerException();
        }
        MetaContentBaseFragment metaContentBaseFragment0 = (MetaContentBaseFragment)weakReference0.get();
        q.e(metaContentBaseFragment0, "null cannot be cast to non-null type com.iloen.melon.fragments.MetaContentBaseFragment");
        return metaContentBaseFragment0 == null || !metaContentBaseFragment0.isAdded() ? null : metaContentBaseFragment0;
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final View getMainContainer() {
        return this.container;
    }

    public boolean isContentListValid(@Nullable Object object0) {
        if(object0 == null) {
            LogU.Companion.w("MusicMessageBaseViewHolder", "Invalid ContentList dataset!");
            return false;
        }
        return true;
    }

    public boolean isFragmentValid(@Nullable I i0) {
        if(i0 == null) {
            return false;
        }
        FragmentActivity fragmentActivity0 = i0.getActivity();
        return fragmentActivity0 != null && !fragmentActivity0.isFinishing() && i0.isAdded() && i0 instanceof MetaContentBaseFragment;
    }

    public final void setContainer(@Nullable View view0) {
        this.container = view0;
    }

    public final void setMContext(@Nullable Context context0) {
        this.mContext = context0;
    }
}

