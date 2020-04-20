package com.ktar.duckyrgb;

import java.util.concurrent.ThreadLocalRandom;

public class Keys {
    public static String F1 = "F1";
    public static String F2 = "F2";
    public static String F3 = "F3";
    public static String F4 = "F4";
    public static String F5 = "F5";
    public static String F6 = "F6";
    public static String F7 = "F7";
    public static String F8 = "F8";
    public static String F9 = "F9";
    public static String F10 = "F10";
    public static String F11 = "F11";
    public static String F12 = "F12";
    public static String A = "A";
    public static String B = "B";
    public static String C = "C";
    public static String D = "D";
    public static String E = "E";
    public static String F = "F";
    public static String G = "G";
    public static String H = "H";
    public static String I = "I";
    public static String J = "J";
    public static String K = "K";
    public static String L = "L";
    public static String M = "M";
    public static String N = "N";
    public static String O = "O";
    public static String P = "P";
    public static String Q = "Q";
    public static String R = "R";
    public static String S = "S";
    public static String T = "T";
    public static String U = "U";
    public static String V = "V";
    public static String W = "W";
    public static String X = "X";
    public static String Y = "Y";
    public static String Z = "Z";
    public static String One = "D1";
    public static String Two = "D2";
    public static String Three = "D3";
    public static String Four = "D4";
    public static String Five = "D5";
    public static String Six = "D6";
    public static String Seven = "D7";
    public static String Eight = "D8";
    public static String Nine = "D9";
    public static String Zero = "D0";
    public static String Lalt = "LMenu";
    public static String Ralt = "RMenu";
    public static String Lctrl = "LControlKey";
    public static String Rctrl = "RControlKey";
    public static String Lshift = "LShiftKey";
    public static String Rshift = "RShiftKey";
    public static String Lwindow = "LWin";
    public static String Rwindow = "RWin";
    public static String Lbracket = "OemOpenBrackets";
    public static String Rbracket = "Oem6";
    public static String Fn = "Fn";
    public static String Esc = "Escape";
    public static String Tab = "Tab";
    public static String Caps = "Capital";
    public static String Space = "Space";
    public static String Enter = "Return";
    public static String Comma = "Oemcomma";
    public static String Quote = "Oem7";
    public static String Period = "OemPeriod";
    public static String Question = "OemQuestion";
    public static String Hyphen = "OemMinus";
    public static String Equal = "Oemplus";
    public static String Pipe = "Oem5";
    public static String Backtick = "Oemtilde";
    public static String Semicolon = "Oem1";
    public static String Backspace = "Back";
    public static String Print = "PrintScreen";
    public static String Insert = "Insert";
    public static String Delete = "Delete";
    public static String Home = "Home";
    public static String End = "End";
    public static String Pause = "Pause";
    public static String Scroll = "Scroll";
    public static String Pageup = "PageUp";
    public static String Pagedown = "Next";
    public static String Larrow = "Left";
    public static String Rarrow = "Right";
    public static String Uarrow = "Up";
    public static String Darrow = "Down";

    public static String[] AllKeys = new String[]{
            F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12,
            A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
            One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero,
            Lalt, Ralt, Lctrl, Rctrl, Lshift, Rshift, Lwindow, Rwindow, Lbracket, Rbracket,
            Fn, Esc, Tab, Caps, Pipe, Backtick, Semicolon, Backspace,
            Space, Enter, Comma, Quote, Period, Question, Hyphen, Equal,
            Print, Insert, Delete, Home, End, Pause, Scroll, Pageup, Pagedown,
            Larrow, Rarrow, Uarrow, Darrow
    };

    public static String randomKey() {
        return AllKeys[ThreadLocalRandom.current().nextInt(AllKeys.length)];
    }
}
