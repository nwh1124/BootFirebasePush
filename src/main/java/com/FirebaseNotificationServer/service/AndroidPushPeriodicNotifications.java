package com.FirebaseNotificationServer.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"fuvRi09NSSulzzMM0IFv1O:APA91bGM1lRpaoBrQA2ONjCQMdKoqqGuoQYLaMBnqTMjIkQg59T73yjTVT7rizsxQg6QK1tx_Bps3VccZxGKB2zm0LnSzu1IcWwgCSKDgTct6_oTMDfi5e9TCoTe4I_aIpcf6nGFU4uc","device token value 2","device token value 3"};

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title","hello!");
        notification.put("body","Today is "+localDate.getDayOfWeek().name()+"!");

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}