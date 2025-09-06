package com.iloen.melon.custom.player;

import J8.P3;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fR\u0017\u0010\u0012\u001A\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/custom/player/TextureTypePlayerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/google/android/exoplayer2/ui/PlayerView;", "getPlayer", "()Lcom/google/android/exoplayer2/ui/PlayerView;", "LJ8/P3;", "a", "LJ8/P3;", "getBinding", "()LJ8/P3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TextureTypePlayerView extends FrameLayout {
    public final P3 a;

    public TextureTypePlayerView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public TextureTypePlayerView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public TextureTypePlayerView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D0904, this, false);  // layout:view_texture_type_player_view
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        this.a = new P3(((PlayerView)view0), ((PlayerView)view0));
    }

    public TextureTypePlayerView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @NotNull
    public final P3 getBinding() {
        return this.a;
    }

    @NotNull
    public final PlayerView getPlayer() {
        q.f(this.a.b, "playerView");
        return this.a.b;
    }
}

