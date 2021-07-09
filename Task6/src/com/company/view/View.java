package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class View {
    /**
     *  Resource Bundle Installation's
     */
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"));  // Ukrainian
    //new Locale("en"));        // English

    public void printMessage(String message){
        System.out.println(message);
    }

    public String concatenationStrings(String... strings){
        StringBuilder concatString = new StringBuilder();
        for (String v : strings){
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }
}
