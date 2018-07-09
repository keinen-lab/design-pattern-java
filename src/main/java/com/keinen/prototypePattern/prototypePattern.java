package com.keinen.prototypePattern;

// prototype class
class Cookie implements Cloneable {
    public Object clone() {
        try {
            Cookie copy = (Cookie)super.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class CoconutCookie extends Cookie {
    String name;
    public CoconutCookie(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoconutCookie : " + name;
    }
}

class CookieMachine {
    private Cookie cookie;
    public CookieMachine(Cookie cookie) {
        this.cookie = cookie;
    }
    public Cookie makeCookie() {
        return (Cookie)cookie.clone();
    }
}

public class prototypePattern {
    public static void main(String args[]) {
        Cookie tempCookie = null;
        Cookie prot = new CoconutCookie("Coco");
        CookieMachine cm = new CookieMachine(prot);

        for(int i=0; i<10; i++) {
            tempCookie = cm.makeCookie();
            System.out.println(tempCookie.toString());
        }
    }
}