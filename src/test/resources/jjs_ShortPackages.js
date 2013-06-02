// Simulates java imports at the top of a class.
var javaPackage = Packages.java;
var TimerTask = java.util.TimerTask;
var Timer = java.util.Timer;
var Thread = java.lang.Thread;

var task = new TimerTask() {
	run: function() {
		print('Hello!');
	}
}

new Timer().schedule(task, 0, 1000);
Thread.sleep(10000);
task.cancel();