package com.iloen.melon.popup;

import android.app.Activity;
import android.view.View;
import com.iloen.melon.adapters.RecyclerItemClickListener.OnItemClickListener;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.utils.MelonSettingInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/popup/DjPlaylistAddPopup;", "Lcom/iloen/melon/popup/TextListPopup;", "activity", "Landroid/app/Activity;", "icon", "", "text", "", "", "listener", "Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;", "<init>", "(Landroid/app/Activity;[I[Ljava/lang/String;Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjPlaylistAddPopup extends TextListPopup {
    public static final int $stable = 8;

    public DjPlaylistAddPopup(@NotNull Activity activity0, @Nullable int[] arr_v, @NotNull String[] arr_s, @Nullable RecyclerItemClickListener.OnItemClickListener recyclerItemClickListener$OnItemClickListener0) {
        q.g(activity0, "activity");
        q.g(arr_s, "text");
        super(activity0, arr_v, arr_s, recyclerItemClickListener$OnItemClickListener0);
        this.setOnItemClickListener(new RecyclerItemClickListener.OnItemClickListener() {
            public final DjPlaylistAddPopup a;

            {
                this.a = djPlaylistAddPopup0;
            }

            @Override  // com.iloen.melon.adapters.RecyclerItemClickListener$OnItemClickListener
            public void onItemClick(View view0, int v) {
                q.g(view0, "childView");
                switch(v) {
                    case 0: {
                        MelonSettingInfo.setDjPlayListAddPosition(AddPosition.b);
                        break;
                    }
                    case 1: {
                        MelonSettingInfo.setDjPlayListAddPosition(AddPosition.c);
                    }
                }
                this.a.dismiss();
            }

            public void onItemLongPress(View view0, int v) {
                q.g(view0, "childView");
            }
        });
        this.setTitle(0x7F130232);  // string:ctx_menu_add_to_dj_collection "DJ플레이리스트에 담기"
    }
}

