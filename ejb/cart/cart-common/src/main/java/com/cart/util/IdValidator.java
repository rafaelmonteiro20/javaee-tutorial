package com.cart.util;

public class IdValidator {

    public boolean validate(String id) {
        for (int i = 0; i < id.length(); i++) {
            if (Character.isDigit(id.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    
}