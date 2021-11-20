<p align="center">
<img src="https://raw.githubusercontent.com/udu3324/McChatRelay2/master/src/main/resources/icon.png" width="150" alt="icon">
</p>
<p align="center">
	  McChatRelay2
</p>
<p align="center">
      <img src="https://img.shields.io/github/license/udu3324/McChatRelay2">
	  <img src="https://img.shields.io/github/issues/udu3324/McChatRelay2">
</p>
<h2>McChatRelay2</h2>
McChatRelay2 is a java application that relays messages from a server to discord. Minecraft Console Client 
will be required to run to hook up to its chat. A optional thing you can also do is parse things
sent in chat. For example, specific things that got sent in chat can trigger code to send something in
a discord channel.

<h2>Pros and Cons</h2>

- Can run on pretty much any MC version that MCC supports
- Can run on pretty much any MC server (as long as the server allows it)
- 24/7 Uptime (not including network issues)
- Only supported on Windows sadly (because of tailer command and MCC built on .net, this could be fixed in the future)

<h3>Things Used</h3>
<p>

[Minecraft Console Client](https://github.com/MCCTeam/Minecraft-Console-Client)

[JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA)

</p>

<h2>Setup</h2>
<p>

1, Download [Minecraft Console Client](https://ci.appveyor.com/project/ORelio/minecraft-console-client/build/artifacts)

2, Setup MCC with the following config down below
```
[Logging]
# Only affect the messages on console.
debugmessages=false                # Please enable this before submitting bug reports. Thanks!
chatmessages=true                  # Show server chat messages
warningmessages=true               # Show warning messages
errormessages=true                 # Show error messages
infomessages=true                  # Informative messages (i.e Most of the message from MCC)
filtermode=blacklist               # blacklist OR whitelist. Blacklist hide message match regex. Whitelist show message match regex
logtofile=true                     # Write log messages to file
logfile=latest.log                 # Log file name

[AutoRelog]
enabled=true
delay=10                           # use 10 for 10 seconds, 10-60 for a random delay between 10 and 60 seconds
retries=-1                          # retries when failing to relog to the server. use -1 for unlimited retries
kickmessagesfile=kickmessages.txt  # file with list of matches in kick messages that will trigger autorelog
ignorekickmessage=true            # when set to true, autorelog will reconnect regardless of kick messages
```

3, Clone the repo and open it in your IDE (I recommend Intellij)

4, Open the "Variables" class and edit the config to your liking

5, Run the shadowJar gradle task

6, Run the jar created

</p>