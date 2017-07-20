/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author scarletspeedster
 */
public class Configuration 
{
   private static final String  Username="YourEmail@gmail.com";
   private static final String  Password ="YourPassword";
   
   public static String getUsername()
   {
       return Configuration.Username;
   }
   public static String getPassword()
   {
       return Configuration.Password;
   }
   
}
