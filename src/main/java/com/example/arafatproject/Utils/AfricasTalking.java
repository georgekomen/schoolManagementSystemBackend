package com.example.arafatproject.Utils;


import org.json.*;
public class AfricasTalking {

    public JSONArray send(String message, String recipients) {
        String username = "georgekomen";
        String apiKey   = "e36225a6e5630d73cfd37d66cdbf042a171161d5415d811e43ed96321f9cb556";
        AfricasTalkingGateway gateway  = new AfricasTalkingGateway(username, apiKey);
        try {
            JSONArray results = gateway.sendMessage(recipients, message);
//            for( int i = 0; i < results.length(); ++i ) {
//                JSONObject result = results.getJSONObject(i);
//                System.out.print(result.getString("status") + ","); // status is either "Success" or "error message"
//                System.out.print(result.getString("statusCode") + ",");
//                System.out.print(result.getString("number") + ",");
//                System.out.print(result.getString("messageId") + ",");
//                System.out.println(result.getString("cost"));
//            }
            return results;
        } catch (Exception e) {
            System.out.println("Encountered an error while sending " + e.getMessage());
            return null;
        }
    }
}
