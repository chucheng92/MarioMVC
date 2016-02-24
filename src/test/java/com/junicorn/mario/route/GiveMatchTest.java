package com.junicorn.mario.route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GiveMatchTest {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void giveMatch(final String uri, List<String> routes) {
        Collections.sort(routes, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o2.toString().equals(uri)) {
                    return o2.toString().indexOf(uri);
                }
                return -1;
            }
        });
    }

    public static void main(String[] args) {
        GiveMatchTest testGiveMatch = new GiveMatchTest();
        String uri = "/users/23";
        List<String> list = new ArrayList<>();
        list.add("/users/:uid");
        list.add("/users/23");

        System.out.println(list);

        testGiveMatch.giveMatch(uri, list);

        System.out.println(list);
    }
}