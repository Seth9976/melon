package com.iloen.melon.fragments.mymusic.playlist;

import Pc.d;
import com.melon.ui.t3;
import com.melon.utils.image.ImageUtils;
import eb.n;
import eb.u;
import ge.b;

public final class ImageToPlaylistViewModel_Factory implements b {
    private final b imageUtilsProvider;
    private final b putPopupUserEventHelperProvider;
    private final b pvUseCaseProvider;
    private final b screenCaptureUseCaseProvider;
    private final b stringProvider;
    private final b uploadImageUseCaseProvider;

    public ImageToPlaylistViewModel_Factory(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.uploadImageUseCaseProvider = b0;
        this.putPopupUserEventHelperProvider = b1;
        this.stringProvider = b2;
        this.pvUseCaseProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.imageUtilsProvider = b5;
    }

    public static ImageToPlaylistViewModel_Factory create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new ImageToPlaylistViewModel_Factory(b0, b1, b2, b3, b4, b5);
    }

    public ImageToPlaylistViewModel get() {
        ImageToPlaylistViewModel imageToPlaylistViewModel0 = ImageToPlaylistViewModel_Factory.newInstance(((zb.b)this.uploadImageUseCaseProvider.get()), ((t3)this.putPopupUserEventHelperProvider.get()), ((d)this.stringProvider.get()));
        imageToPlaylistViewModel0.pvUseCase = (n)this.pvUseCaseProvider.get();
        imageToPlaylistViewModel0.screenCaptureUseCase = (u)this.screenCaptureUseCaseProvider.get();
        ImageToPlaylistViewModel_MembersInjector.injectImageUtils(imageToPlaylistViewModel0, ((ImageUtils)this.imageUtilsProvider.get()));
        return imageToPlaylistViewModel0;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static ImageToPlaylistViewModel newInstance(zb.b b0, t3 t30, d d0) {
        return new ImageToPlaylistViewModel(b0, t30, d0);
    }
}

