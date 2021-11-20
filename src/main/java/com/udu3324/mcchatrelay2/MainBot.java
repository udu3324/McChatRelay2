package com.udu3324.mcchatrelay2;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class MainBot extends ListenerAdapter {
    // Remember to change the Variables in Variables.java or else it won't start
    public static void main(String[] args) throws LoginException {
        //credits
        System.out.println("+------------------------------------------+\n" +
                           "|        mcChatRelay2 is by udu3324        |\n" +
                           "+------------------------------------------+\n" +
                           "| Hey! Thank you for looking at my code.   |\n" +
                           "| Check out more of my projects on Github! |\n" +
                           "| -----> https://github.com/udu3324 <----- |\n" +
                           "|                                          |\n" +
                           "| McChatRelay2 is a java application that  |\n" +
                           "| relays messages from a server to disco-  |\n" +
                           "| rd. These messages could then be parsed  |\n" +
                           "| to different channels and alert people.  |\n" +
                           "+------------------------------------------+");

        if (Data.botStatusOn) {
            JDABuilder
                    .createLight(Data.botToken, GatewayIntent.GUILD_MESSAGES)
                    .addEventListeners(new ReadyListener())
                    .setActivity(Activity.playing(Data.botStatus))
                    .build();
        } else {
            JDABuilder
                    .createLight(Data.botToken, GatewayIntent.GUILD_MESSAGES)
                    .addEventListeners(new ReadyListener())
                    .build();
        }

    }
}
