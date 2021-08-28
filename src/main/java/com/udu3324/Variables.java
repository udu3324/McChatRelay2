package com.udu3324;

import java.io.File;

public class Variables {
    // mcLogLocation should be the system file location where latest.log is stored on your machine.
    // For example, "C:\Users\(enter-pc-username-here)\AppData\Roaming\.minecraft\logs\latest.log"
    static public File mcLogLocation = new File("C:\\Users\\build\\AppData\\Roaming\\.minecraft\\logs\\latest.log");

    // subString should be the integer where it cuts off the logging part in latest.log
    // Examples are below.

    // substring = 31 - 1.16.5 - "[##:##:##] [main/INFO]: [CHAT] "
    // Input for this would be "[21:32:59] [main/INFO]: [CHAT] ExampleIGN: Hey guys, welcome to my MC server!"
    // Output for this would be "ExampleIGN: Hey guys, welcome to my MC server!"

    // substring = 40 - 1.17.1 - "[##:##:##] [Render thread/INFO]: [CHAT] "
    // Input for this would be "[21:32:59] [Render thread/INFO]: [CHAT] ExampleIGN: Hey guys, welcome to my MC server!"
    // Output for this would be "ExampleIGN: Hey guys, welcome to my MC server!"
    static public Integer subString = 0;

    // botToken is your bot botToken set in your discord developer applications.
    // For example, "ODQ3MjM1MDY2OTMzMjgwNzk5.YK7HJA.KAstmxm9MjkaauPnaJ_Ku2dyOpU"
    static public String botToken = "";

    // botStatus is the botStatus shown on the bot's bio.
    // For example, "Hello, World!"
    static public String botStatus = "";

    // commandPrefix is the commandPrefix used before the session command.
    // For example, ">"
    static public String commandPrefix = "";

    // staffRoleID is the role id that is whitelisted to use the session command.
    // For example, "836821240504254485"
    static public String staffRoleID = "";

    // minecraftChatChannelID is the channel that will be relayed with messages sent in the server.
    // for example, "838473566500421693"
    static public String minecraftChatChannelID = "";

    // ignore this stuff below as it's checks for if you filled the stuff above
    static {
        if (botToken.isEmpty()) {
            System.out.println("You have to provide a botToken!");
            System.exit(-1);
        }
        if (botStatus.isEmpty()) {
            System.out.println("You have to provide a botStatus!");
            System.exit(-1);
        }
        if (commandPrefix.isEmpty()) {
            System.out.println("You have to provide a commandPrefix!");
            System.exit(-1);
        }
        if (staffRoleID.isEmpty()) {
            System.out.println("You have to provide a staffRoleID!");
            System.exit(-1);
        }
        if (minecraftChatChannelID.isEmpty()) {
            System.out.println("You have to provide a minecraftChatChannel!");
            System.exit(-1);
        }
    }
}
