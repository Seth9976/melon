package com.iloen.melon.fragments.mymusic.playlist;

import Xd.a;
import com.melon.utils.image.ImageUtils;
import eb.n;
import eb.u;
import ge.b;

public final class ImageToPlaylistViewModel_MembersInjector implements a {
    private final b imageUtilsProvider;
    private final b pvUseCaseProvider;
    private final b screenCaptureUseCaseProvider;

    public ImageToPlaylistViewModel_MembersInjector(b b0, b b1, b b2) {
        this.pvUseCaseProvider = b0;
        this.screenCaptureUseCaseProvider = b1;
        this.imageUtilsProvider = b2;
    }

    public static a create(b b0, b b1, b b2) {
        return new ImageToPlaylistViewModel_MembersInjector(b0, b1, b2);
    }

    public static void injectImageUtils(ImageToPlaylistViewModel imageToPlaylistViewModel0, ImageUtils imageUtils0) {
        imageToPlaylistViewModel0.imageUtils = imageUtils0;
    }

    public void injectMembers(ImageToPlaylistViewModel imageToPlaylistViewModel0) {
        imageToPlaylistViewModel0.pvUseCase = (n)this.pvUseCaseProvider.get();
        imageToPlaylistViewModel0.screenCaptureUseCase = (u)this.screenCaptureUseCaseProvider.get();
        ImageToPlaylistViewModel_MembersInjector.injectImageUtils(imageToPlaylistViewModel0, ((ImageUtils)this.imageUtilsProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((ImageToPlaylistViewModel)object0));
    }
}

