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
McChatRelay2 is a java application that relays messages from a server to discord. Minecraft will be 
required to run a instance first to hook up to chat. A optional thing you can also do is parse things
sent in chat. For example, specific things that got sent in chat can trigger code to send something in
a discord channel. Because of MC server restarts and other stuff, it is recommended to run fabric and
a mod called auto-reconnect.

<h2>Pros and Cons</h2>

- Can run on about any MC version
- Can run on about any MC server (as long as the server allows it)
- Can't be on a server for more than about 3 days because of invalid sessions

<h3>Dependencies Used</h3>
<p>
JDA (java discord api)
</p>

<h2>Setup</h2>
<p>
1, Clone the repository and open it in Intellij IDEA
<br>
2, Open the "Variables" class and change the strings into your config
<br>
3, Execute run Gradle task
<br>
4, (optional) Execute shadowJar gradle task to create a easy runnable uber-jar
<br>
</p>
<h2>After Setup</h2>
After you set up McChatRelay2, you will need to do the session command in a channel or in the bot's DMs. 