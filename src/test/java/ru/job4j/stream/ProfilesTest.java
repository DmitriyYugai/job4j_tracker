package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollect() {
        List<Profile> in = List.of(
                new Profile(new Address("Petersburg")),
                new Profile(new Address("Novosibirsk")),
                new Profile(new Address("Novosibirsk")),
                new Profile(new Address("Novosibirsk")),
                new Profile(new Address("Moscow"))
        );
        List<Address> expected = List.of(
                new Address("Moscow"),
                new Address("Novosibirsk"),
                new Address("Petersburg")
        );
        List<Address> rsl = Profiles.collect(in);
        assertThat(rsl, is(expected));
    }
}