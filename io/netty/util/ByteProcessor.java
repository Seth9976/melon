package io.netty.util;

public interface ByteProcessor {
    public static class IndexNotOfProcessor implements ByteProcessor {
        private final byte byteToNotFind;

        public IndexNotOfProcessor(byte b) {
            this.byteToNotFind = b;
        }

        @Override  // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            return b == this.byteToNotFind;
        }
    }

    public static class IndexOfProcessor implements ByteProcessor {
        private final byte byteToFind;

        public IndexOfProcessor(byte b) {
            this.byteToFind = b;
        }

        @Override  // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            return b != this.byteToFind;
        }
    }

    public static final ByteProcessor FIND_ASCII_SPACE;
    public static final ByteProcessor FIND_COMMA;
    public static final ByteProcessor FIND_CR;
    public static final ByteProcessor FIND_CRLF;
    public static final ByteProcessor FIND_LF;
    public static final ByteProcessor FIND_LINEAR_WHITESPACE;
    public static final ByteProcessor FIND_NON_CR;
    public static final ByteProcessor FIND_NON_CRLF;
    public static final ByteProcessor FIND_NON_LF;
    public static final ByteProcessor FIND_NON_LINEAR_WHITESPACE;
    public static final ByteProcessor FIND_NON_NUL;
    public static final ByteProcessor FIND_NUL;
    public static final ByteProcessor FIND_SEMI_COLON;

    static {
        ByteProcessor.FIND_NUL = new IndexOfProcessor(0);
        ByteProcessor.FIND_NON_NUL = new IndexNotOfProcessor(0);
        ByteProcessor.FIND_CR = new IndexOfProcessor(13);
        ByteProcessor.FIND_NON_CR = new IndexNotOfProcessor(13);
        ByteProcessor.FIND_LF = new IndexOfProcessor(10);
        ByteProcessor.FIND_NON_LF = new IndexNotOfProcessor(10);
        ByteProcessor.FIND_SEMI_COLON = new IndexOfProcessor(59);
        ByteProcessor.FIND_COMMA = new IndexOfProcessor(44);
        ByteProcessor.FIND_ASCII_SPACE = new IndexOfProcessor(0x20);
        ByteProcessor.FIND_CRLF = new ByteProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 10 && b != 13;
            }
        };
        ByteProcessor.FIND_NON_CRLF = new ByteProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 10 || b == 13;
            }
        };
        ByteProcessor.FIND_LINEAR_WHITESPACE = new ByteProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b != 9 && b != 0x20;
            }
        };
        ByteProcessor.FIND_NON_LINEAR_WHITESPACE = new ByteProcessor() {
            @Override  // io.netty.util.ByteProcessor
            public boolean process(byte b) {
                return b == 9 || b == 0x20;
            }
        };
    }

    boolean process(byte arg1);
}

