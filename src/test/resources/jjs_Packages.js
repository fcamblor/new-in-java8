// Create a variable java to simulate the utilization of package before each class.
// Classes from java.lang need this prefix too.
// Packages.javax et Packages.javafx is available too.
var java = Packages.java;

var task = new java.util.TimerTask() {
	run: function() {
		print('Hello!');
	}
}

new java.util.Timer().schedule(task, 0, 1000);
java.lang.Thread.sleep(10000);
task.cancel();