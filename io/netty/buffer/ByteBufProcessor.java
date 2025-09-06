package io.netty.buffer;

import io.netty.util.ByteProcessor;

@Deprecated
public interface ByteBufProcessor extends ByteProcessor {
    @Deprecated
    public static final ByteBufProcessor FIND_CR;
    @Deprecated
    public static final ByteBufProcessor FIND_CRLF;
    @Deprecated
    public static final ByteBufProcessor FIND_LF;
    @Deprecated
    public static final ByteBufProcessor FIND_LINEAR_WHITESPACE;
    @Deprecated
    public static final ByteBufProcessor FIND_NON_CR;
    @Deprecated
    public static final ByteBufProcessor FIND_NON_CRLF;
    @Deprecated
    public static final ByteBufProcessor FIND_NON_LF;
    @Deprecated
    public static final ByteBufProcessor FIND_NON_LINEAR_WHITESPACE;
    @Deprecated
    public static final ByteBufProcessor FIND_NON_NUL;
    @Deprecated
    public static final ByteBufProcessor FIND_NUL;

    static {
        ByteBufProcessor.FIND_NUL = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 0;
            }
        };
        ByteBufProcessor.FIND_NON_NUL = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 0;
            }
        };
        ByteBufProcessor.FIND_CR = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 13;
            }
        };
        ByteBufProcessor.FIND_NON_CR = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 13;
            }
        };
        ByteBufProcessor.FIND_LF = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 10;
            }
        };
        ByteBufProcessor.FIND_NON_LF = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 10;
            }
        };
        ByteBufProcessor.FIND_CRLF = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 10 && b != 13;
            }
        };
        ByteBufProcessor.FIND_NON_CRLF = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 10 || b == 13;
            }
        };
        ByteBufProcessor.FIND_LINEAR_WHITESPACE = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 9 && b != 0x20;
            }
        };
        ByteBufProcessor.FIND_NON_LINEAR_WHITESPACE = new ByteBufProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 9 || b == 0x20;
            }
        };
    }
}

