/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.util;

/**
 *
 * @author marfu
 */
public class UtilClass {
    
    
     public String generate(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String pass = "";
        for (int x = 0; x < length; x++) {
            int i = (int) Math.floor(Math.random() * 36); // Si tu supprimes des lettres tu diminues ce nb
            pass += chars.charAt(i);
        }

        return pass;
    }
}
