/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.mycompany.charcount;

public class Main {
    public static void main(String[] args) {
        String input = Validator.checkString("Enter your content:");
        CharCount cc = new CharCount(input);
        cc.showResult();
    }
}



