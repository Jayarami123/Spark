package com.github.sbaudoin.sonar.plugins.shellcheck.lexer;

import junit.framework.TestCase;

public class TokenTest extends TestCase {
    public void test() {
        Token token1 = new Token(TokenType.SHEBANG, 4, 12, 2, 2);
        Token token2 = new Token(TokenType.SHEBANG, 4, 12, 2, 2);
        Token token3 = new Token(TokenType.COMMENT, 4, 9, 2, 2);
        Token token4 = new Token(TokenType.SHEBANG, 2, 3, 5, 3);
        Token token5 = new Token(TokenType.LINE_FEED, 2, 3, 5, 3);

        assertFalse(token1.equals(""));
        assertTrue(token1.equals(token2));
        assertFalse(token1.equals(token4));
        assertFalse(token4.equals(token5));

        assertEquals(Integer.hashCode(4), token1.hashCode());

        assertEquals("SHEBANG (4, 12, 2:2)", token1.toString());

        assertTrue(token1.compareTo(token4) > 0);
        assertTrue(token1.compareTo(token3) > 0);
        assertTrue(token4.compareTo(token5) == TokenType.SHEBANG.compareTo(TokenType.LINE_FEED));

        assertEquals(16, token1.end());
    }
}
