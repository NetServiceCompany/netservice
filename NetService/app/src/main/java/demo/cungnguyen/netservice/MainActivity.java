package demo.cungnguyen.netservice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> keys;
    private List<String> values;
    private List<Object> listObj;

    public List<Object> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    private String encodeUrl(String param) throws UnsupportedEncodingException {
        return URLEncoder.encode(param, "UTF-8");
    }

    private String setDataForUrl(List<KeyValuePair> pairList) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (KeyValuePair pair : pairList) {
            if (first)
                first = false;
            else
                result.append("&");
            result.append(pair.getKey());
            result.append("=");
            result.append(pair.getValue());
        }

        return result.toString();
    }

    public Object readMessage(JsonReader reader){
        try {
            Object json = new JSONTokener(reader.toString()).nextValue();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(reader instanceof JSONArray){

        }
        try {
          return readObjectMessage(reader);
        } catch (IOException e) {
            try {
               return readMessagesArray(reader);
            } catch (IOException e1) {
               return e1.getMessage();
            }
        }
    }

    public List<Object> readMessagesArray(JsonReader reader) throws IOException {
        List<Object> messages = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readObjectMessage(reader));
        }
        reader.endArray();
        return messages;
    }

    public Object readObjectMessage(JsonReader reader) throws IOException {
        List<String> strings = new LinkedList<>();
        reader.beginObject();
        while (reader.hasNext()) {
            String key = reader.nextName();
            String value = reader.nextString();
            strings.add(key + " " + value);
        }
        reader.endObject();
        return strings;
    }

    private Object sendPostOrPutMethod(String url, String pathVariable, List<KeyValuePair> pairList, String method) {
        // Create Url
        // If link have pathvariable in method get ex : {id} --> {id} have to encode before send url
        if (pathVariable != null) {
            try {
                pathVariable = encodeUrl(pathVariable);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            url += "/" + pathVariable;
        }
        // Make Connect
        try {
            URL endPoint = new URL(url);
            HttpURLConnection myConnection = (HttpURLConnection) endPoint.openConnection();
            myConnection.setRequestProperty("User-Agent", SmsManager.MMS_CONFIG_USER_AGENT);
            myConnection.setRequestMethod(method);
            myConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

//            Send post request
            myConnection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(myConnection.getOutputStream());
            wr.writeBytes(setDataForUrl(pairList));
            wr.flush();
            wr.close();

            if (myConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

            }

            myConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Object sendGetMethod(String url, String pathVariable, List<KeyValuePair> pairList) {
        // Create Url
        // If link have pathvariable in method get ex : {id} --> {id} have to encode before send url
        if (pathVariable != null) {
            try {
                pathVariable = encodeUrl(pathVariable);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            url += "/" + pathVariable ;
        }

        if (pairList!=null && !pairList.isEmpty()) {
            url += "?" + setDataForUrl(pairList);
        }
        // Make Connect
        try {
            URL endPoint = new URL(url);
            HttpURLConnection myConnection = (HttpURLConnection) endPoint.openConnection();
            myConnection.setRequestProperty("User-Agent", SmsManager.MMS_CONFIG_USER_AGENT);
            if (myConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                JsonReader reader = new JsonReader(new InputStreamReader(myConnection.getInputStream(), "UTF-8"));
                readMessage(reader);
            }

            myConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                String url = null;
                List<KeyValuePair> keyValuePairs = new ArrayList<>();
                keyValuePairs.add(new KeyValuePair("id", "2"));
                sendGetMethod("http://192.168.1.21:8080/type-product/findAll",null, null);
                try {
                    url = "http://192.168.1.21:8080/type-product/get/" + encodeUrl("{id}") + "?id=2";
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    URL githubEndpoint = new URL(url);
                    OutputStream out = null;
                    HashMap<String, String> posData = new HashMap<>();
                    posData.put("id", "2");

                    HttpURLConnection myConnection = (HttpURLConnection) githubEndpoint.openConnection();
//                    myConnection.setDoInput(true);
//                    myConnection.setDoOutput(true);
////
//                    out = new BufferedOutputStream(myConnection.getOutputStream());
//                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
//                    writer.write(getPostDataString(posData));
//                    writer.flush();
//                    writer.close();
//                    myConnection.setRequestMethod("GET");

//                    myConnection.setRequestMethod("POST");
                    myConnection.setRequestProperty("User-Agent", SmsManager.MMS_CONFIG_USER_AGENT);
//                    myConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

//                    String urlParameters = "nameType=Hang nhap&description=nhap khau";
                    String urlParameters = "id=2";

                    // Send post request
//                    myConnection.setDoOutput(true);
//                    DataOutputStream wr = new DataOutputStream(myConnection.getOutputStream());
//                    wr.writeBytes(urlParameters);
//                    wr.flush();
//                    wr.close();

//                    myConnection.connect();
//                    myConnection.setRequestMethod("GET");
                    myConnection.setRequestProperty("Accept",
                            "application/json");
                    myConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    myConnection.setRequestProperty("Content-Type", "text/plain");
//                    String ids = "id=2";
//                    myConnection.setDoOutput(true);
//                    myConnection.setRequestMethod();
//                    myConnection.getOutputStream().write(ids.getBytes());


                    if (myConnection.getResponseCode() == 200) {

                        InputStream responseBody = myConnection.getInputStream();

//                        InputStreamReader responseBodyReader =
//                                new InputStreamReader(responseBody, "UTF-8");

//                        JsonReader jsonReader = new JsonReader(responseBodyReader);

//                        jsonReader.beginArray();

                        keys = new LinkedList<>();
                        values = new LinkedList<>();


                        try {
                            JsonReader reader = new JsonReader(new InputStreamReader(responseBody, "UTF-8"));
                            readMessage(reader);
//                            listObj = readMessage(responseBody);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

//                        while (jsonReader.hasNext()) {
//
//                            String key = jsonReader.nextName();
//                            String value = jsonReader.nextString();
//                            keys.add(key);
//                            values.add(value);
//                        }
//
//                        jsonReader.close();
                        myConnection.disconnect();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
