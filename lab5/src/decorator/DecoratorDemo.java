package decorator;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DecoratorDemo {

    interface TextTransformer {
        String transform(String text);
    }

    static class IdentityTransformer implements TextTransformer {
        public String transform(String text) { return text; }
    }

    static class TrimDecorator implements TextTransformer {
        private final TextTransformer inner;
        TrimDecorator(TextTransformer inner) { this.inner = inner; }
        public String transform(String text) { return inner.transform(text).trim(); }
    }

    static class UpperCaseDecorator implements TextTransformer {
        private final TextTransformer inner;
        UpperCaseDecorator(TextTransformer inner) { this.inner = inner; }
        public String transform(String text) { return inner.transform(text).toUpperCase(); }
    }

    static class LowerCaseDecorator implements TextTransformer {
        private final TextTransformer inner;
        LowerCaseDecorator(TextTransformer inner) { this.inner = inner; }
        public String transform(String text) { return inner.transform(text).toLowerCase(); }
    }

    static class AddPrefixDecorator implements TextTransformer {
        private final TextTransformer inner;
        private final String prefix;
        AddPrefixDecorator(TextTransformer inner, String prefix) {
            this.inner = inner;
            this.prefix = prefix;
        }
        public String transform(String text) { return prefix + inner.transform(text); }
    }

    static class ReplaceSpacesDecorator implements TextTransformer {
        private final TextTransformer inner;
        private final char replacement;
        ReplaceSpacesDecorator(TextTransformer inner, char replacement) {
            this.inner = inner;
            this.replacement = replacement;
        }
        public String transform(String text) {
            return inner.transform(text).replace(' ', replacement);
        }
    }

    static final UnaryOperator<String> trim = String::trim;
    static final UnaryOperator<String> upperCase = String::toUpperCase;
    static final UnaryOperator<String> lowerCase = String::toLowerCase;
    static final UnaryOperator<String> addBrackets = s -> "[" + s + "]";

    static UnaryOperator<String> addPrefix(String prefix) {
        return s -> prefix + s;
    }

    static UnaryOperator<String> replaceSpaces(char replacement) {
        return s -> s.replace(' ', replacement);
    }

    @SafeVarargs
    static UnaryOperator<String> pipeline(UnaryOperator<String>... steps) {
        return Arrays.stream(steps).reduce(
            s -> s,
            (a, b) -> { UnaryOperator<String> c = s -> b.apply(a.apply(s)); return c; }
        );
    }

    public static void demo() {
        String input = "  Hello World from Java  ";

        System.out.println("=== Decorator Pattern ===");
        System.out.println("Input: \"" + input + "\"\n");

        System.out.println("-- OOP --");
        TextTransformer oopPipeline1 = new AddPrefixDecorator(
            new UpperCaseDecorator(
                new TrimDecorator(new IdentityTransformer())
            ), ">>> "
        );
        System.out.println("trim -> upper -> prefix:  \"" + oopPipeline1.transform(input) + "\"");

        TextTransformer oopPipeline2 = new ReplaceSpacesDecorator(
            new UpperCaseDecorator(
                new TrimDecorator(new IdentityTransformer())
            ), '_'
        );
        System.out.println("trim -> upper -> replace: \"" + oopPipeline2.transform(input) + "\"");

        System.out.println();

        System.out.println("-- Functional --");
        Function<String, String> fn1 = trim.andThen(upperCase).andThen(addPrefix(">>> "));
        System.out.println("trim -> upper -> prefix:  \"" + fn1.apply(input) + "\"");

        Function<String, String> fn2 = trim.andThen(upperCase).andThen(replaceSpaces('_'));
        System.out.println("trim -> upper -> replace: \"" + fn2.apply(input) + "\"");

        UnaryOperator<String> dynamic = pipeline(trim, lowerCase, addBrackets, addPrefix("NOTE: "));
        System.out.println("Dynamic pipeline:         \"" + dynamic.apply(input) + "\"");

        System.out.println();
    }
}
