package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;

public final class NettyRuntime {
    static class AvailableProcessorsHolder {
        private int availableProcessors;

        @SuppressForbidden(reason = "to obtain default number of available processors")
        public int availableProcessors() {
            synchronized(this) {
                if(this.availableProcessors == 0) {
                    this.setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
                }
                return this.availableProcessors;
            }
        }

        public void setAvailableProcessors(int v) {
            int v2;
            synchronized(this) {
                ObjectUtil.checkPositive(v, "availableProcessors");
                v2 = this.availableProcessors;
                if(v2 == 0) {
                    this.availableProcessors = v;
                    return;
                }
            }
            throw new IllegalStateException("availableProcessors is already set to [" + v2 + "], rejecting [" + v + "]");
        }
    }

    private static final AvailableProcessorsHolder holder;

    static {
        NettyRuntime.holder = new AvailableProcessorsHolder();
    }

    public static int availableProcessors() {
        return NettyRuntime.holder.availableProcessors();
    }

    public static void setAvailableProcessors(int v) {
        NettyRuntime.holder.setAvailableProcessors(v);
    }
}

