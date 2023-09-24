package es.upm.miw.iwvg_devops.code;

import java.util.Collections;
import java.util.stream.Stream;

public class Search {
    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(User::getFractions)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(null);
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream().allMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .flatMap(user -> user.getFractions().stream()
                        .filter(fraction -> fraction.decimal() != 0)
                        .findFirst()
                        .map(Fraction::decimal))
                .orElse(null);
    }
}
