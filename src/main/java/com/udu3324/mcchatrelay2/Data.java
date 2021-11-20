package com.udu3324.mcchatrelay2;

import net.dv8tion.jda.api.entities.TextChannel;

import java.io.File;

public class Data {
    // mcLogLocation should be the system file location where latest.log is stored on your machine.
    // For example, "C:\Users\(username)\Desktop\MCC\latest.log"
    public static final File mcLogLocation = new File(""); // <!> Required <!>

    // botToken is your bot botToken set in your discord developer applications.
    // For example, "ODQ3MjM1MDY2OTMzMjgwNzk5.YK7HJA.KAstmxm9MjkaauPnaJ_Ku2dyOpU"
    public static final String botToken = ""; // <!> Required <!>

    // channelID is the channel that will be relayed with messages sent in the server.
    // For example, "838473566500421693"
    public static final String channelID = ""; // <!> Required <!>

    // guildID is the server that the bot will be in.
    // For example, "432984375984439769"
    public static final String guildID = ""; // <!> Required <!>

    // botStatus is the botStatus shown on the bot's bio.
    // For example, "Hello, World!"
    public static final String botStatus = ""; // this is optional

    // also ignore this too lol
    public static TextChannel mcChatRelayChannel;
    public static Boolean botStatusOn = false;

    static { //checks for required variables
        if (!mcLogLocation.exists()) {
            System.out.println("mcLogLocation is invalid or is blank");
            System.exit(-1);
        } else if (botToken.isEmpty()) {
            System.out.println("botToken is blank and needs to be filled");
            System.exit(-1);
        } else if (channelID.isEmpty()) {
            System.out.println("channelID is blank and needs to be filled");
            System.exit(-1);
        } else if (guildID.isEmpty()) {
            System.out.println("guildID is blank and needs to be filled");
            System.exit(-1);
        }
        //optional
        if (!botStatus.isEmpty()) {
            botStatusOn = true;
        }
    }
}
