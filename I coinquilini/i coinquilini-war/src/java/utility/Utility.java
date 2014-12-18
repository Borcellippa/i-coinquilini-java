/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.google.gson.Gson;

/**
 *
 * @author Mattia
 */
public class Utility {
    public static String buildGson(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        if (json == null) {
            System.out.println("servlet buildGson: NULL");
        } else {
            System.out.println("servlet buildGson: " + json);
        }
        return json;
    }
}
