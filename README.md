Hello, I just wanted to briefly clarify a few aspects of our program.

• Running the program:

I just wanted to clarify a few things in regard to running our program, just to cover our basses. First of all to build the jar, first run,

    mvn package
    
from the mavenBuild directory, then simply run,

	java -jar target/group7project-1.0.0.jar
	
on terminal or command prompt to execute the program. If you wish to run the program by clicking on the jar directly, the src folder must be in the same directory as the jar file, or else java will throw an IIOException, as it will be unable to locate the resources.

• A few problems with the project:

There are a few problems I noticed when running the project on Linux as opposed to Windows. First, the window scaling is a bit different, although it’s pretty trivial, the timer was lined up slightly better on the screen. Also, originally when I designed the victory and death screen on Windows they worked fine, but when I ran them on my laptop (running Ubuntu 19.4) they didn’t function correctly and simply just displayed the start screen again. I just wanted to clarify this, in case you are running our program on Linux and were puzzled as to why this happens.

That’s all, sorry if I over explained this, I just wanted to be thorough and wanted to make sure that our program would run easily. The code in the maven build is exactly the same as the original, expect for the filepaths of everything being updated, and the Image.java is a little more specific about the file path when it throws an exception.

Thanks for reading! 
