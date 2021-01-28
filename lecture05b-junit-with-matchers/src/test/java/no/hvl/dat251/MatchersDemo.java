package no.hvl.dat251;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MatchersDemo {

    @Test
    public void matcherDemo() {

        int price = 198;
        assertThat(price, is(198));

        int x = 0;
        assertThat(x, either(is(-1)).or(is(0)));

        List<String> myList = new ArrayList<>(Arrays.asList("apples", "bananas"));
        assertThat(myList, hasItem("bananas"));

        String s = "yellowbananasfrompanama!";
        assertThat(s, containsString("bananas"));
    }

}


