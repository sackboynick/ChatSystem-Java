package mediator;

import com.google.gson.Gson;
import model.User;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpLogInValidator implements IUserValidator{
    @Override
    public void registerUser(User user) throws Exception{
        URL url = new URL("http://localhost:5003/LogInServer");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        httpCon.setConnectTimeout(5000);
        httpCon.setReadTimeout(5000);
        httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        System.out.println("\nSending 'POST' request to URL : " + url);
        OutputStream os = httpCon.getOutputStream();
        os.write(new Gson().toJson(user).getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close();  //don't forget to close the OutputStream
        httpCon.connect();

        System.out.println(httpCon.getResponseCode());
        System.out.println(httpCon.getResponseMessage());
    }

    @Override
    public User logIn(String username, String password) throws Exception {
        HttpURLConnection con;
        String url = "http://localhost:5003/LogInServer/sackboynick/Password";
        URL obj;
        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response);
        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println(myResponse.getString("username"));


        return new Gson().fromJson(myResponse.toString(),User.class);
    }
}
