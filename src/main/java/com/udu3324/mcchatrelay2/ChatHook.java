package com.udu3324.mcchatrelay2;

import com.udu3324.mcchatrelay2.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatHook extends TimerTask {
    public static String line;

    public synchronized void run() {
        try {
            Runtime run = Runtime.getRuntime();
            //sadly does not support linux :(
            Process process = run.exec("powershell.exe Get-Content \"" + Data.mcLogLocation + "\" -Wait -Tail 1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            Runnable chatHook = () -> {
                try {
                    if (reader.ready()) {
                        line = reader.readLine();

                        //Stops discord syntax injection and some other stuff
                        line = line.replace("`", "");

                        System.out.println(line);
                        Data.mcChatRelayChannel.sendMessage("```" + line + "```").queue();

                        //Insert more stuff here to parse stuff in chat
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(chatHook, 0, 1, TimeUnit.NANOSECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
