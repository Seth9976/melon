package com.google.android.exoplayer2.drm;

public interface DefaultDrmSessionEventListener {
    default void onDrmKeysLoaded() {
    }

    default void onDrmKeysRemoved() {
    }

    default void onDrmKeysRestored() {
    }

    default void onDrmSessionAcquired() {
    }

    default void onDrmSessionManagerError(Exception exception0) {
    }

    default void onDrmSessionReleased() {
    }
}

