package com.hirumi.visualnovelstrider.network;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.hirumi.visualnovelstrider.constant.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketService extends AsyncTask<Void, String, Boolean> {

    private Socket socket;
    private final String stringa = "unych";
    private BufferedReader input;
    private PrintWriter output;

    public interface Callback {
        void onComplete(String s);
    }

    public void sendMessage(String m, Callback r) {
        if (socket.isConnected()) {
            Log.i("AsyncTask", "SendDataToNetwork: Writing received message to socket");
            new Thread(() -> {
                try {
                    output.write(m);
                    output.write(0x04);
                    output.flush();
                    r.onComplete(asy(input));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    public String asy(BufferedReader inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int ch; (ch = inputStream.read()) != -1; ) {
            sb.append((char) ch);
            if (sb.toString().endsWith("}\u0004") || sb.toString().equals("ok")) {
                Log.d("sb", sb.toString());
//                Gson gson = new Gson();
//                Dbstats data = gson.fromJson(sb.substring(9), Dbstats.class);
//                Log.d("woy", String.valueOf(data.getVn()));
                break;
            }
        }
        return sb.toString().replace("\u0004", "");
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("preexcecut", "");
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        boolean result = false;
        try {
            Log.i("AsyncTask", "doInBackground: Creating socket");
            SocketAddress socketAddress = new InetSocketAddress(Constant.VNDB_URL, Constant.VNDB_PORT);
            socket = new Socket();
            socket.connect(socketAddress, 5000); //10 second
            if (socket.isConnected()) {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream());
                Log.i("AsyncTask", "doInBackground: Socket created, streams assigned");
                Log.i("AsyncTask", "doInBackground: Waiting for inital data...");
                Log.d("login",  "loged");
                output.write("login{\"protocol\":1,\"client\":\"test\",\"clientver\":0.1}");
                output.write(0x04);
                output.flush();
                asy(input);
                while (true) {
//                    if (message.endsWith("}")) {
//                        publishProgress(message);
//                    }
//                    message = asy(input);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = true;
        } finally {
            try {
                input.close();
                output.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        if (values.length > 0) {
            Log.i("AsyncTask", "onProgressUpdate: " + values[0] + " bytes received.");
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean) {
            Log.i("AsyncTask", "onPostExecute: Completed with an Error.");
        } else {
            Log.i("AsyncTask", "onPostExecute: Completed.");
        }
    }
}
