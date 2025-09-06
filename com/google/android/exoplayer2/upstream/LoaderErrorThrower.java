package com.google.android.exoplayer2.upstream;

public interface LoaderErrorThrower {
    public static final class Dummy implements LoaderErrorThrower {
        @Override  // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() {
        }

        @Override  // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int v) {
        }
    }

    void maybeThrowError();

    void maybeThrowError(int arg1);
}

