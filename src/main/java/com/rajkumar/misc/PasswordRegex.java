package com.rajkumar.misc;

import java.util.regex.Pattern;

public class PasswordRegex {

    /**
     *
     * Minimum 8 charaters. 1 number. no repeat.
     *
     * @param input
     * @return
     */
    public boolean isValid(final String input) {
        //Pattern p = new Pattern("");
        return input.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public static void main(String[] args) {
        PasswordRegex pr = new PasswordRegex();
        System.out.println(pr.isValid("1rajkumar"));
        System.out.println(pr.isValid("1rajkuma"));
        System.out.println(pr.isValid("1rajmar"));
        System.out.println(pr.isValid("rajkumar"));
        System.out.println(pr.isValid("abc"));
        System.out.println(pr.isValid("12345678"));
    }

}
