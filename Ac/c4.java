package Ac;

import android.net.Uri;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.image.ImageSelector.ImageSelectorListener;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import e.k;
import kotlin.jvm.internal.q;

public final class c4 implements ImageSelectorListener {
    public final h4 a;

    public c4(h4 h40) {
        this.a = h40;
    }

    @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
    public final void onFinishBackgroundLoading() {
    }

    @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
    public final void onImageSelectorCanceled(ImageSelector imageSelector0, Request imageSelector$Request0) {
    }

    @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
    public final void onImageSelectorComplete(ImageSelector imageSelector0, Request imageSelector$Request0, Uri uri0) {
        q.g(imageSelector$Request0, "reqInfo");
        if(uri0 != null) {
            String s = uri0.getPath();
            if(s != null) {
                r4 r40 = (r4)this.a.getViewModel();
                MediaAttachInfo mediaAttachInfo0 = new MediaAttachInfo();
                mediaAttachInfo0.a = MediaAttachType.g;
                mediaAttachInfo0.g = s;
                r40.l(k.z(mediaAttachInfo0));
            }
        }
    }

    @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
    public final void onStartBackgroundLoading() {
    }
}

