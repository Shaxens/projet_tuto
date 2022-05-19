package fr.tradflex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestFooBarProcess {

    @Test
    void cas_1() {
        int i = 1;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("1");
    }
    @Test
    void cas_2() {
        int i = 2;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("2");
    }

    @Test
    void cas_3() {
        int i = 3;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("foo");
    }

    @Test
    void cas_4() {
        int i = 4;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("4");
    }

    @Test
    void cas_5() {
        int i = 5;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("bar");
    }

    @Test
    void cas_6() {
        int i = 6;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("foo");
    }

    @Test
    void cas_9() {
        int i = 9;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("foo");
    }
    @Test
    void cas_10() {
        int i = 10;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("bar");
    }

    @Test
    void cas_15() {
        int i = 15;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("foobar");
    }

    @Test
    void cas_30() {
        int i = 30;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("foobar");
    }

    @Test
    void cas_45() {
        int i = 45;

        String result = new FooBarProcess().get(i);

        assertThat(result).isEqualTo("foobar");
    }

}
