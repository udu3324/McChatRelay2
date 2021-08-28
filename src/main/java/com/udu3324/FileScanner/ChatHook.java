package com.udu3324.FileScanner;

import com.udu3324.DiscordBot.MainBot;
import com.udu3324.Variables;

import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatHook extends TimerTask {
    public static String line;

    public synchronized void run() {
        try {
            Runtime run = Runtime.getRuntime();
            Process process = run.exec("powershell.exe Get-Content \"" + Variables.mcLogLocation + "\" -Wait -Tail 1");
            Scanner scan = new Scanner(process.getInputStream());

            Runnable chatHook = () -> {
                if (scan.hasNextLine()) {
                    line = scan.nextLine();

                    // Stop NullPointerException in channel variables
                    if (MainBot.sessionToggle == 0) {

                        // Make sure line was sent in chat
                        if (line.contains("[CHAT]")) {

                            //Stops discord syntax injection and some other stuff
                            line = line.replace("`", "");

                            System.out.println(line);
                            MainBot.mcChatRelayChannel.sendMessage("`"+line.substring(Variables.subString)+"`").queue();
                            //If you see something like this: "[21:32:59] [Render thread/INFO]: [CHAT] ExampleIGN: Hey guys, welcome to my MC server!"
                            //You forgot to set your substring variable

                            //Insert more stuff here to parse stuff in chat
                        }
                    } else {
                        System.out.println(" <!> Create a session! Do \"" + Variables.commandPrefix + "session\" <!> " + line);
                    }
                }
            };

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(chatHook, 0, 1, TimeUnit.NANOSECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
