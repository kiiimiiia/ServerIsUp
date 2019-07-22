package com.company;

import com.company.ResponseClasses.TelegramServerUserIDsResponse;
import com.company.ResponseClasses.UserInfos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    private final String USER_AGENT = "Mozilla/5.0";

    /************* you should put your given secret Token HERE *******************/
    private final String Secret_Token = "HERE";

    public void Run() throws IOException {
        while(true){

        delay(4);
        getuserIDs();
        }
    }

    private void getuserIDs() throws IOException {
        String url = "https://api.telegram.org/bot"+Secret_Token+"/getUpdates";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Gson gson = new GsonBuilder().create();
        TelegramServerUserIDsResponse telegramServerUserIDsResponse = gson.fromJson(response.toString(),TelegramServerUserIDsResponse.class);
        List<UserInfos> userInfos = telegramServerUserIDsResponse.getItems();
        for (UserInfos ui : userInfos){

            sendTelegramNotif(ui.getMessageBody().getChat().getId());
        }
        //print result
        System.out.println(response.toString());
    }
    private void sendRequestToServer(){

    }
    private void sendTelegramNotif(long chatID) throws IOException {
        String url = "https://api.telegram.org/bot"+Secret_Token+"/sendMessage";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String urlParameters = "chat_id=117638218&text=hi";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
    }

    private void delay(int delay){
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
