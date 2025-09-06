package com.bumptech.glide.util.pool;

public abstract class StateVerifier {
    static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        public DebugStateVerifier() {
            super(null);
        }

        @Override  // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            if(z) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
                return;
            }
            this.recycledAtStackTraceException = null;
        }

        @Override  // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if(this.recycledAtStackTraceException != null) {
                throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
            }
        }
    }

    static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        public DefaultStateVerifier() {
            super(null);
        }

        @Override  // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }

        @Override  // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if(this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private static final boolean DEBUG = false;

    private StateVerifier() {
    }

    public StateVerifier(com.bumptech.glide.util.pool.StateVerifier.1 stateVerifier$10) {
    }

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    public abstract void setRecycled(boolean arg1);

    public abstract void throwIfRecycled();

    class com.bumptech.glide.util.pool.StateVerifier.1 {
    }

}

