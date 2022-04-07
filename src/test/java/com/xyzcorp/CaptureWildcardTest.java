package com.xyzcorp;

import java.util.List;

public class CaptureWildcardTest {

    /**
     * An attempt to do this will result in a failure.
     * Why? because list.add requires an E and get returns an E
     * But what is E? But this is a ? and list.get returns CAP1, and list.add
     * return CAP2, initially it looks as if they are separate types.
     *
     * @param list a list of ?
     * @return a list of ?
     */
//    public List<?> processAttemptA(List<?> list) {
//        list.add(list.get(0));
//        return list;
//    }

    /**
     * If I wanted to perform something on list of ? but require a generic
     * I can capture the generic using a helper method, in this case
     * <code>processHelper</code>.
     *
     * @param list a list of ?
     * @return list of ?
     */
    public List<?> processAttemptB(List<?> list) {
        return processHelper(list);
    }

    /**
     * Process helper will capture what ? and convert it into parameterized type
     * Now that we have this we can run what it was we were trying to perform
     *
     * @param list a list with generic E
     * @param <E> the parameterized type
     * @return a list of E, the parameterized type that was captured
     */
    private <E> List<E> processHelper(List<E> list) {
        E e = list.get(0);
        list.add(e);
        return list;
    }
}
