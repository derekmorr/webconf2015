/**
 * Java reflection example.
 *
 * Compare to whatIsIt() in patterns.scala
 */
public class WhatIsIt {

    public static String whatIsIt(final Object x) {
        if (x instanceof Integer) {
            final Integer i = (Integer) x;
            return "It's an integer: " + i;
        } else if (x instanceof String) {
            final String s = (String) x;
            return "It's a string: " + s;
        } else if (x instanceof Boolean) {
            final Boolean b = (Boolean) x;
            return "It's a boolean: " + b;
        } else {
            return "unknown";
        }
    }
}
