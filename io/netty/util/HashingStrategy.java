package io.netty.util;

public interface HashingStrategy {
    public static final HashingStrategy JAVA_HASHER;

    static {
        HashingStrategy.JAVA_HASHER = new HashingStrategy() {
            // 去混淆评级： 低(20)
            @Override  // io.netty.util.HashingStrategy
            public boolean equals(Object object0, Object object1) {
                return object0 == object1 || object0 != null && object0.equals(object1);
            }

            @Override  // io.netty.util.HashingStrategy
            public int hashCode(Object object0) {
                return object0 == null ? 0 : object0.hashCode();
            }
        };
    }

    boolean equals(Object arg1, Object arg2);

    int hashCode(Object arg1);
}

