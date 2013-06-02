// Create an object containing all the packages from where the classes
// we are going to use in the program are defined.
var java = new JavaImporter(java.lang, java.util);

// All the code included in this block doesn't need to indicate the packages explicitly
// if defined in JavaImporter of course.
with(java) {
	var task = new TimerTask() {
		run: function() {
			print('Hello!');
		}
	}

	new Timer().schedule(task, 0, 1000);
	Thread.sleep(10000);
	task.cancel();
}