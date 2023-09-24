package es.upm.miw.iwvg_devops.code;

import java.util.Collections;

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
}
