// Simulates java imports at the top of a class.
var javaPackage = Packages.java;
var TimerTask = java.util.TimerTask;
var Timer = java.util.Timer;
var Thread = java.lang.Thread;

var timer = new Timer();

// JavaScript allows anonymous function the use of a Functional Interface.
// Therefore we can simply all the preceding examples as follow.
// TimeTask being an abstract class, the following code wouldn't we valid in Java.
timer.schedule(
	function() {
		print('Hello!');
	}, 0, 1000);

Thread.sleep(10000);
timer.cancel();