package fr.tradflex;

import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class FooBarProcess {

    public String get(int i) {
        return Multiple.get(i).orElseGet(() -> Integer.toString(i));
    }


    private enum Multiple {

        MULTIPLE_3_ET_5(Multiple::de3EtDe5, "foobar"),
        MULTIPLE_3     (Multiple::de3, "foo"),
        MULTIPLE_5     (Multiple::de5, "bar");

        private final String nom;
        private final IntPredicate predicate;

        Multiple(IntPredicate predicate, String nom) {
            this.nom = nom;
            this.predicate = predicate;
        }

        private static boolean de4(int i) {
            return i % 4 == 0;
        }

        private static boolean de3EtDe5(int i) {
            return i % 3 == 0 && i % 5 == 0;
        }

        private static boolean de5(int i) {
            return i % 5 == 0;
        }

        private static boolean de3(int i) {
            return i % 3 == 0;
        }

        public static Optional<String> get(int i) {
            return Stream.of(values())
                    .filter(multiple -> multiple.predicate.test(i))
                    .map(multiple -> multiple.nom)
                    .findFirst();
        }
    }
}
