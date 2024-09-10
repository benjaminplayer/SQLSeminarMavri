/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author miranda
 */
public class StaticVars {
    public static String g_strUserID;
    public static String g_strUser;
    public static String g_strPassword;
    public static String g_strRole;
    public static String g_strIme;
    public static String g_strPriimek;        
    
    public static String getMd5(String strInput) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(strInput.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

public static void purge(){
    g_strUserID = "";
    g_strUser = "";
    g_strPassword = "";
    g_strRole = "";
    g_strIme = "";
    g_strPriimek = "";
}   

    
}
