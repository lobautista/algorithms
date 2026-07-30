package chapter9;

import java.util.Map;
import java.util.Set;

public class Linter {
    public static Set<Character> OPENING_BRACES =  Set.of('[', '{', '(');
    public static Set<Character> CLOSING_BRACES =  Set.of(']', '}', ')');
    public static Map<Character, Character> BRACES_MAP = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
    );

    private boolean isOpeningBrace(char c) {
        return OPENING_BRACES.contains(c);
    }

    private boolean isClosingBrace(char c) {
        return CLOSING_BRACES.contains(c);
    }

    private boolean isNotAMatch(char openingBrace, char closingBrace) {
        return BRACES_MAP.get(openingBrace) != closingBrace;
    }

    private boolean lint(String text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i ++) {
            char c = text.charAt(i);
            if (isOpeningBrace(c)) {
                stack.push(c);
            } else if (isClosingBrace(c)) {
                if (!stack.isEmpty()) {
                    return false;
                }
                char poppedChar = stack.pop();
                if (isNotAMatch(poppedChar, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Linter linter = new Linter();
        String text = "(var x = {y: [1, 2, 3]}";
        System.out.println("Is valid text?: " + linter.lint(text));
    }
}
