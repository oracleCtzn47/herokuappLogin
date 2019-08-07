package newLife;

public class Demographic {
/*MAVEN DEPENDENCY
 * 
 * <!-- junit testing -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.11</version>
</dependency>
<!-- selenium -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>2.44.0</version>
</dependency>
<!-- screen recorder -->
<dependency>
    <groupId>com.pojosontheweb</groupId>
    <artifactId>monte-repack</artifactId>
    <version>1.0</version>
</dependency>
 * 
 */
	
	
/*SCREEN RECORDER
 * 
 * package com.memorynotfound.test;

import org.junit.*;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScreenRecorderTest {

    private static WebDriver driver;
    private static ScreenRecorder screenRecorder;

    @BeforeClass
    public static void setUp() throws IOException, AWTException {

        //Create a instance of GraphicsConfiguration to get the Graphics configuration
        //of the Screen. This is needed for ScreenRecorder class.
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        //Create a instance of ScreenRecorder with the required configurations
        screenRecorder = new ScreenRecorder(gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, (int) (15 * 60)),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black",
                        FrameRateKey, Rational.valueOf(30)),
                null);

        // create driver
        driver = new FirefoxDriver();

        // maximize screen
        driver.manage().window().maximize();
    }

    @Before
    public void beforeTest() throws IOException {
        screenRecorder.start();
    }

    @Test
    public void testScreenRecorder() {
        driver.get("https://memorynotfound.com/");
    }

    @After
    public void afterTest() throws IOException {
        screenRecorder.stop();
        List<File> createdMovieFiles = screenRecorder.getCreatedMovieFiles();
        for(File movie : createdMovieFiles){
            System.out.println("New movie created: " + movie.getAbsolutePath());
        }
    }

    @AfterClass
    public static void cleanUp(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
 * 
 * 
 * 
 * 
 * 
 * EXAMPLE OUTPUT
 * New movie created: /var/folders/ts/tv2s4k357c79jmw4_rkbt7b40000gn/T/screenrecorder/ScreenRecording 2015-02-07 at 16.55.53.avi
 * 	
 * 
 * 
 * 
 * 
 * URL
 * https://memorynotfound.com/selenium-record-video-junit-java/
 * 
 * java docs:
 * http://www.randelshofer.ch/monte/javadoc/
 * http://www.randelshofer.ch/monte/javadoc/org/monte/screenrecorder/ScreenRecorder.html
 */
	
	
	
	/*JAVA SOUND BYTES
	 * 
	 * URL
	 * https://www.codejava.net/coding/capture-and-record-sound-into-wav-file-with-java-sound-api
	 * 
	 * This article shows you how easy it is to capture sound/audio coming into your computer’s microphone (or line in) and record the captured sound in to a WAV file, with help of Java Sound API. A small example program is provided to illustrate how to record sound for a specified duration. Let’s look at the Java Sound API first.

The package javax.sound.sampled.* is a part of Java Sound API which contains interfaces and classes that are dedicated for processing sampled audio by Java programming language.

Here are the typical steps to capture and record sound into a WAV file:

              Define an audio format of the sound source to be captured, using the class AudioFormat.
              Create a DataLine.Info object to hold information of a data line.
              Obtain a TargetDataLine object which represents an input data line from which audio data can be captured, using the method getLineInfo(DataLine.Info) of the AudioSystem class.
              Open and start the target data line to begin capturing audio data.
              Create an AudioInputStream object to read data from the target data line.
              Record the captured sound into a WAV file using the following method of the class AudioSystem:

write(AudioInputStream, AudioFileFormat.Type, File)

 

Note that this method blocks the current thread until the target data line is closed.

              Stop and close the target data line to end capturing and recording.

Here is the source code of a sample program which follows the steps above:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
101
	
import javax.sound.sampled.*;
import java.io.*;
 
/**
 * A sample program is to demonstrate how to record sound in Java
 * author: www.codejava.net
 */
	/*
public class JavaSoundRecorder {
    // record duration, in milliseconds
    static final long RECORD_TIME = 60000;  // 1 minute
 
    // path of the wav file
    File wavFile = new File("E:/Test/RecordAudio.wav");
 
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;
 
    /**
     * Defines an audio format
     */
	/*
    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
 
    /**
     * Captures the sound and record into a WAV file
     */
	/*
    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
 
    /**
     * Closes the target data line to finish capturing and recording
     */
	/*
    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }
 
    /**
     * Entry to run the program
     */
	/*
    public static void main(String[] args) {
        final JavaSoundRecorder recorder = new JavaSoundRecorder();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
 
        stopper.start();
 
        // start recording
        recorder.start();
    }
}
 

This console-based program will record sound from the microphone for 60 seconds then saves the recorded sound about generic cialis online in to a file in .wav format under E:/Test/RecordAudio.wav (so make sure you created the parent directory first). You may want to save as .mp3 format, but unfortunately the Java Sound API only supports the .wav format.

You can change the record duration by modifying value of the constant RECORD_TIME at the beginning of the class.

Notice that there are two threads spawn in this program:

        First thread (main thread): captures and records sound.
        Second thread (the stopperthread): waits for a specified duration before closing the target data line. And because the main method is blocked by method call AudioSystem.write(), closing the target data line will continues the main method which exits the program.

Compile the program:

javac JavaSoundRecorder.java
	 * 
	 * 
	 * Run it:

java JavaSoundRecorder
Output:

Start capturing...

Start recording...

Finished
And check if the file RecordAudio.wav created under E:/Test directory and play it back.
	 * 
	 * 
	 */
	
	
	
	
	/*
	 * This example explains how to use a ServletRequestAttributeListener in a web application. This interface is used for receiving notification events about ServletRequest attribute changes. Notifications will be generated while the request is within the scope of the web application in which the listener is registered. A ServletRequest has a very short lifespan. It only lives when it enters the first servlet or filter and is destroyed when it reaches the last servlet or filter. The ServletRequestAttributeListener can be registerd by @WebListener annotation, adding the listener to the servlet descriptor or programmatically adding a listener with .addListener() to the servlet context. In this example we use the @WebListener annotation.
ServletRequestAttributeListener receives notifications for ServletRequest attribute changes

In order to listen to a attribute change in the ServletContext we need to implement the javax.servlet.ServletRequestAttributeListener interface. This interface lets us listen to the following events, the names speak for themselves.

    attributeAdded()
    attributeRemoved()
    attributeReplaced()

To register a listener we can add the @WebListener, define the listener in the servlet descriptor (web.xml) or programatigally add it to the servlet context. In this example we choose to add the listener through the @WebListener annotation.

package com.memorynotfound;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestAttributeLogger implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("attribute: " + event.getName() + " was added with value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("attribute: " + event.getName() + " was added with value: " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("attribute: " + event.getName() + " was added with value: " + event.getValue());
    }
}

Note: If you prefer the web.xml servlet descriptor over the @WebListener annotation you can add the context listener as follows:

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" version="3.1">

    <listener>
        <listener-class>com.memorynotfound.ServletRequestAttributeLogger</listener-class>
    </listener>
    
</web-app>

How does it work

Every time an ServletRequest attribute is added, replaced or removed the corresponding method is invoked. This allows us to track changes to certain attributes in our ServletRequest.
References

    ServletRequestAttributeListener JavaDoc
    https://docs.oracle.com/javaee/7/api/javax/servlet/ServletRequestAttributeListener.html
    
    
    
    Servlet 3 API specification
	 * 
	 * https://download.oracle.com/otndocs/jcp/servlet-3.0-fr-oth-JSpec/
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * HttpSessionActivationListener notifies if a session is migrated to another VM

In order for an Object to be notified when it will be migrated to another VM the Object needs to implement the HttpSessionActivationListener interface. This interface lets us listen to the following events.

    sessionWillPassivate(): This event is raised when the object is about to be migrated to another VM.
    sessionDidActivate(): This event is raised

package com.memorynotfound;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class Dog implements HttpSessionActivationListener, Serializable {

    private String name;
    private String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent event) {
        System.out.println("Dog: " + this.getName() + " is activated on a new JVM");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent event) {
        System.out.println("Dog: " + this.getName() + " will be migrated to a new JVM");
    }


    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }
}

How does it work

When the container decides to migrate the session to another VM, it must call the sessionWillPassivate() method. This indicates that the object will be serialized and transported to another JVM. When the process of migration is complete, the sessionDidActivate() method is invoked. Telling the Object that it has migrated from one VM to another.
	 */
	
	
	
	
	/*
	 * 
	 * This example explains how to use a HttpSessionListener in a web application. The purpose of this interface is to track active sessions in a web application. The HttpSessionListener can be registerd by @WebListener annotation, adding the listener to the servlet descriptor or programmatically adding a listener with .addListener() to the servlet context. In this example we use the @WebListener annotation.
HttpSessionListener receives notifications for active sessions

In order to listen to session changes we need to implement the javax.servlet.HttpSessionListener interface. this interface lets us listen to the following events, the names speak for themselves.

    sessionCreated()
    sessionDestroyed()

To register a listener we can add the @WebListener, define the listener in the servlet descriptor (web.xml) or programatigally add it to the servlet context. In this example we choose to add the listener through the @WebListener annotation.

package com.memorynotfound;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static int activeSessions;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        System.out.println("session created - total active sessions: " + activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        System.out.println("session destroyed - total active sessions: " + activeSessions);
    }
}

Warning: counting sessions will only count sessions of the current Web Application.

Note: If you prefer the web.xml servlet descriptor over the @WebListener annotation you can add the context listener as follows:

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" version="3.1">

    <listener>
        <listener-class>com.memorynotfound.SessionListener</listener-class>
    </listener>
    
</web-app>

How does it work

When a session is created the sessionCreated() event is raised. When a session is destroyed the sessionDestroyed() event is raised.
References

    HttpSessionListener JavaDoc
    Servlet 3 API specification
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	/*loGGER stuff
	 * 
	 * 
	 * 
	 * Create and Configure Log4j2 Async Logger

by MemoryNotFound · Published January 31, 2015 · Updated February 10, 2015
Discover more articles
Configure Hibernate Logging with SLF4j + Logback
Logback with logback.xml Configuration Example
Log4j2 with log4j2.xml Configuration Example
Spring MVC slf4j + Logback Logging Example
Configure Hibernate Logging with slf4j + log4j2
Project structure

In this example we will configure a Log4j2 Async Logger. Asynchronous logging can improve your application’s performance by executing the I/O operations in a separate thread. Asynchronous Loggers internally use the Disruptor, a lock-free inter-thread communication library, instead of queues. Some drawback of using Log4j2 Async Logger is Error Handling. If a problem arrises during the logging process and an exception is thrown, the asynchronous logger has more difficulty to signal this problem to the application. You can however configure a custom ExceptionHandler, but this may still not cover all cases. If logging is a part of your business logic, for example when you use log4j as an audit logging framework you should use a synchronously logger.
Note: you can combine synchronous and asynchronous loggers together.

+--src
|   +--main
|       +--java
|           +--com
|               +--memorynotfound
|                   +--logging
|                       |--Log4j2Example.java
|       +--resources
|           |--log4j2.xml
pom.xml

Maven dependencies

In order to use the Log4j2 Async Logger we need to add the disruptor. This dependency will make sure that the latency is kept to a minimum.

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.memorynotfound.logging.log4j</groupId>
    <artifactId>async-logger</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <name>LOG4J2 - ${project.artifactId}</name>

    <properties>
        <log4j.version>2.1</log4j.version>
        <disruptor.version>3.3.0</disruptor.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>com.lmax</groupId>
            <artifactId>disruptor</artifactId>
            <version>${disruptor.version}</version>
        </dependency>
    </dependencies>

</project>

Log4j2 Async Logger Log4j2.xml Configuration

Create a log4j2.xml file and put it into the resources folder.

<?xml version="1.0" encoding="UTF-8"?>
<Configuration xmlns="http://logging.apache.org/log4j/2.0/config">

    <Appenders>
        <File name="FILE" fileName="logfile.log" append="true">
            <PatternLayout pattern="%-5p | %d{yyyy-MM-dd HH:mm:ss} | [%t] %C{2} (%F:%L) - %m%n"/>
        </File>
        <Console name="STDOUT" target="SYSTEM_OUT">
            <PatternLayout pattern="%-5p | %d{yyyy-MM-dd HH:mm:ss} | [%t] %C{2} (%F:%L) - %m%n"/>
        </Console>
    </Appenders>

    <Loggers>
        <Logger name="com.memorynotfound" level="debug"/>

        <Root level="info">
            <AppenderRef ref="STDOUT"/>
            <AppenderRef ref="FILE"/>
        </Root>
    </Loggers>

</Configuration>

Testing Log4j2 Async Logger Configuration

package com.memorynotfound.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {

    private static final Logger LOG = LogManager.getLogger(Log4j2Example.class);

    public static void main(String... args){
        LOG.debug("This will be printed on debug");
        LOG.info("This will be printed on info");
        LOG.warn("This will be printed on warn");
        LOG.error("This will be printed on error");
        LOG.fatal("This will be printed on fatal");

        LOG.info("Appending string: {}.", "Hello, World");
    }
}

Output

As said in the note we override the root logger with a package logger equal to DEBUG as such, all levels greater or equal than debug will be printed.

DEBUG | 2015-01-31 11:01:11 | [main] logging.Log4j2Example (Log4j2Example.java:11) - This will be printed on debug
INFO  | 2015-01-31 11:01:11 | [main] logging.Log4j2Example (Log4j2Example.java:12) - This will be printed on info
WARN  | 2015-01-31 11:01:11 | [main] logging.Log4j2Example (Log4j2Example.java:13) - This will be printed on warn
ERROR | 2015-01-31 11:01:11 | [main] logging.Log4j2Example (Log4j2Example.java:14) - This will be printed on error
FATAL | 2015-01-31 11:01:11 | [main] logging.Log4j2Example (Log4j2Example.java:15) - This will be printed on fatal
INFO  | 2015-01-31 11:01:11 | [main] logging.Log4j2Example (Log4j2Example.java:17) - Appending string: Hello, World.

References

    Log4j2 Async Logger Doc
    Log4j2 JavaDoc
	 * 
	 * 
	 * 
	 * 
	 * -------------------------------------------------------------
	 * Project structure

In the following tutorial we will show you how to configure log4j2 with log4j2.xml file. We will show you how to print the logging to the console and configure log4j2 to print the logging to a file.

+--src
|   +--main
|       +--java
|           +--com
|               +--memorynotfound
|                   +--logging
|                       |--Log4j2Example.java
|       +--resources
|           |--log4j2.xml
pom.xml

Maven Dependency

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.memorynotfound.logging.log4j</groupId>
    <artifactId>xml</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <name>LOG4J2 - example xml file</name>

    <properties>
        <log4j2.version>2.1</log4j2.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>${log4j2.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>${log4j2.version}</version>
        </dependency>
    </dependencies>

</project>

Example log4j2.xml file

Create a log4j2.xml file and put it into the resources folder.

<?xml version="1.0" encoding="UTF-8"?>
<Configuration xmlns="http://logging.apache.org/log4j/2.0/config">

    <Appenders>
        <File name="FILE" fileName="logfile.log" append="true">
            <PatternLayout pattern="%-5p | %d{yyyy-MM-dd HH:mm:ss} | [%t] %C{2} (%F:%L) - %m%n"/>
        </File>
        <Console name="STDOUT" target="SYSTEM_OUT">
            <PatternLayout pattern="%-5p | %d{yyyy-MM-dd HH:mm:ss} | [%t] %C{2} (%F:%L) - %m%n"/>
        </Console>
    </Appenders>

    <Loggers>
        <Logger name="com.memorynotfound" level="debug"/>

        <Root level="info">
            <AppenderRef ref="STDOUT"/>
            <AppenderRef ref="FILE"/>
        </Root>
    </Loggers>

</Configuration>

We will not explain the pattern used here. To learn more read the Log4j2 pattern layout guide.
Note: In the above configuration the default log level is INFO. This means that every log level greater or equal than INFO will be printed to log output. But we defined a log level package logger for our project which defines level DEBUG which will override the root logger.
Testing log4j2 configuration

package com.memorynotfound.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {

    private static final Logger LOG = LogManager.getLogger(Log4j2Example.class);

    public static void main(String... args){
        LOG.debug("This will be printed on debug");
        LOG.info("This will be printed on info");
        LOG.warn("This will be printed on warn");
        LOG.error("This will be printed on error");
        LOG.fatal("This will be printed on fatal");

        LOG.info("Appending string: {}.", "Hello, World");
    }
}

Output

As said in the note we override the root logger with a package logger equal to DEBUG as such, all levels greater or equal than debug will be printed.

DEBUG | 2015-01-03 15:30:32 | [main] logging.Log4j2Example (Log4j2Example.java:11) - This will be printed on debug
INFO  | 2015-01-03 15:30:32 | [main] logging.Log4j2Example (Log4j2Example.java:12) - This will be printed on info
WARN  | 2015-01-03 15:30:32 | [main] logging.Log4j2Example (Log4j2Example.java:13) - This will be printed on warn
ERROR | 2015-01-03 15:30:32 | [main] logging.Log4j2Example (Log4j2Example.java:14) - This will be printed on error
FATAL | 2015-01-03 15:30:32 | [main] logging.Log4j2Example (Log4j2Example.java:15) - This will be printed on fatal
INFO  | 2015-01-03 15:30:32 | [main] logging.Log4j2Example (Log4j2Example.java:17) - Appending string: Hello, World.

References

    Log4j2 Manual
    Log4j2 JavaDoc

Download it! – log4j2-xml-configuration-example.zip

Share

	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	/*
	 * Exception testing
	 * 
	 * 
	 * 
	 * JUnit Exception Testing

by MemoryNotFound · Published March 15, 2016 · Updated October 19, 2017
Discover more articles
Java SE: Unit Testing CDI with JUnit and JBoss Weld SE
Spring Boot + Spring LDAP Integration Testing Example
Spying on real objects using Mockito Spy
JUnit Timeout for Test Method Execution
Executing JUnit tests in Order

Testing code that throws exceptions is as important than testing only the happy path. It may be even more important. Luckily JUnit provides us with a basic toolkit to verify if an exception is thrown. There are some differences in how we can check these exceptions. Below I will list the possible default options provided by JUnit and at the end we’ll be creating our own custom runner.
Expected Exception

The code float temp = 5 / 0; will throw an ArithmeticException because we are not allowed to divide by zero. We can verify if this code throws an exception by adding the expected exception to the expected parameter of the @Test annotation. This parameter takes a subclass of Throwable.

@Test(expected = ArithmeticException.class)
public void exceptionFailTest(){
    float temp = 5 / 0;
}

    Note: the above test will pass if any code in the method throws the expected exception. This is ok for small tests, but for longer tests, it is recommend to use the ExpectedException rule, which is described below.

Inspecting Exception Messages

The first approach is only useful for simple use cases, but it lacks the possibility to inspect the expected exception messages or the state of the domain objects after the exception has been thrown. The next section we are addressing these issues for more complex and longer tests.
Try/Catch Idiom

First up is the try/catch idiom. This was introduced in JUnit 3.x. When the exception was thrown we could still make some asserts to check the type of the exception and also the message of the exception and any other asserts after the exception was thrown.

package com.memorynotfound.test;

import org.junit.Test;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class TryCatch {

    @Test
    public void throwsArithmeticException(){
        try {
            float temp = 5 / 0;

            fail("should throw an exception");
        } catch (ArithmeticException e){
            assertThat(e.getMessage(), containsString("/ by zero"));
            assertThat(e, instanceOf(ArithmeticException.class));
        }
    }

}

ExpectedException Rule

Alternatively, there is the ExpectedException rule. This rule not only lets you inspect the message and the exception, but also let you use Matchers, which gives you a bit more flexibility in your tests.

package com.memorynotfound.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.containsString;

public class TestExpectedExceptionRule {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_runtime_exception_with_message(){
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("zero"));
        thrown.expectMessage("/ by zero");

        float temp = 5 / 0;
    }
}

Custom Exception Runner

Finally when you want total control, you can always implement your custom exception runner. Here is an example how you can create your own runner, which lets you inspect the exceptions in much finer detail.

First we create an annotation, which we register the expected exception and message.

package com.memorynotfound.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ExpectsException {

    Class type();

    String message() default "";
}

Next we create the ExpectsExceptionrunner which will inspect the exception thrown by the method and if things don’t add up, we make sure the test fails accordingly.

package com.memorynotfound.test;

import org.junit.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class ExpectsExceptionRunner extends BlockJUnit4ClassRunner {

    public ExpectsExceptionRunner(Class klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Statement possiblyExpectingExceptions(FrameworkMethod method, Object test, Statement next) {
        ExpectsException annotation = method.getAnnotation(ExpectsException.class);
        if (annotation == null) {
            return next;
        }
        return new ExpectExceptionWithMessage(next, annotation.type(), annotation.message());
    }

    class ExpectExceptionWithMessage extends Statement {

        private final Statement next;
        private final Class expected;
        private final String expectedMessage;

        public ExpectExceptionWithMessage(Statement next, Class expected, String expectedMessage) {
            this.next = next;
            this.expected = expected;
            this.expectedMessage = expectedMessage;
        }

        @Override
        public void evaluate() throws Exception {
            boolean complete = false;
            try {
                next.evaluate();
                complete = true;
            } catch (AssumptionViolatedException e) {
                throw e;
            } catch (Throwable e) {
                if (!expected.isAssignableFrom(e.getClass())) {
                    String message = "Unexpected exception, expected<"
                            + expected.getName() + "> but was <"
                            + e.getClass().getName() + ">";
                    throw new Exception(message, e);
                }

                if (isNotNull(expectedMessage) && !expectedMessage.equals(e.getMessage())) {
                    String message = "Unexpected exception message, expected<"
                            + expectedMessage + "> but was<"
                            + e.getMessage() + ">";
                    throw new Exception(message, e);
                }
            }
            if (complete) {
                throw new AssertionError("Expected exception: "
                        + expected.getName());
            }
        }

        private boolean isNotNull(String s) {
            return s != null && !s.isEmpty();
        }
    }
}

Finally we register the custom runner with our test and add the appropriate exceptions. As we cannot divide by zero, the code below will throw an ArithmeticException.

package com.memorynotfound.test;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ExpectsExceptionRunner.class)
public class TestExceptions {

    @Test
    @ExpectsException(type = ArithmeticException.class, message = "/ by zero")
    public void throwsArrayIndexOutOfBoundsException(){
        float temp = 5 / 0;
    }

}

Conclusion

When working with simple tests the expected parameter in the @Test annotation is very clean and easy to read. When you need more control over the exception, say that you want to inspect the message or the domain models, I recommend you to use the ExpectedException rule, which gives you much finer control over the exception and let’s you use Matchers. When this is not enough, you can still create your own implementation which we showed in the last example.
	 * 
	 * 
	 */
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * PARAMETERIZED 
	 * 
	 * The Parameterized test runner allows you to run a test many times with different sets of parameters. To run a test class with the Parameterized test runner, you must meet the following requirements.

    The test class must carry the @RunWith annotation with the Parameterized class as its argument.
    The test class must declare instance variables used in the tests.
    Provide a method annotated with @Parameters. The signature of this method must be @Parameters public static java.util.Collection, without parameters. The Collection elements must be arrays of identical length. This array length must match the number of arguments of the only public constructor.
    The test class must have a constructor matching the elements in the array.

package com.memorynotfound.test;

import com.memorynotfound.Math;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)      // => #1
public class ParametrizedTest {

    private final int input;       // => #2
    private final int expected;

    public ParametrizedTest(int input, int expected) {      // => #4
        this.input = input;
        this.expected = expected;
    }

    @Parameters                    // => #3
    public static Collection data(){
        return Arrays.asList(new Integer[][] {
                {0,1},{1,1},{2,2},{3,6},{4,24},{5,120}});
    }

    @Test
    public void calculatorAddTest(){
        System.out.println("factorial of: " + input + " should be: " + expected);
        assertEquals(expected, Math.fact(input));
    }
}

package com.memorynotfound;

public class Math {

    public static int fact(int n) {
        int result;
        if (n==0 || n==1)
            return 1;

        result = fact(n-1) * n;
        return result;
    }
}

Generated output

factorial of: 0 should be: 1
factorial of: 1 should be: 1
factorial of: 2 should be: 2
factorial of: 3 should be: 6
factorial of: 4 should be: 24
factorial of: 5 should be: 120
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * method ordering
	 * 
	 * By default JUnit does not support to run JUnit tests in method order. JUnit only provides to run ordered method execution by name ascending NAME_ASCENDING or descending JVM.
It is a bad practice to depend on the order of execution of your unit tests. But sometimes you have hit a brick wall and you need the specific order of execution.
Creating JUnit tests in Method Order

We can use the @RunWith annotation to map our custom OrderedRunner class that will sort the method executions via our custom @Order annotation.

package com.memorynotfound.test;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderedRunner.class)
public class OrderedJUnitTest {

    @Test
    @Order(order = 2)
    public void second(){
        System.out.println("second");
    }

    @Test
    @Order(order = 3)
    public void third(){
        System.out.println("third");
    }

    @Test
    @Order(order = 1)
    public void first(){
        System.out.println("first");
    }
}

Creating custom order annotation

The @Order annotation takes an int that will be used to determine the order.

package com.memorynotfound.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface Order {
    public int order();
}

Creating custom orderedRunner

This class does the actual ordering of our JUnit methods.

package com.memorynotfound.test;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderedRunner extends BlockJUnit4ClassRunner {

    public OrderedRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        List<FrameworkMethod> copy = new ArrayList<FrameworkMethod>(list);
        Collections.sort(copy, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod f1, FrameworkMethod f2) {
                Order o1 = f1.getAnnotation(Order.class);
                Order o2 = f2.getAnnotation(Order.class);

                if (o1 == null || o2 == null)
                    return -1;

                return o1.order() - o2.order();
            }
        });
        return copy;
    }
}

Output

As you can see the method execution is in the indicated order.

first
second
third

Be advised that normally you must implement your unit tests to run independently. But now you have a way you can run JUnit tests in Method Order.
References

    BlockJUnit4ClassRunner JavaDoc
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ASSUMPTIONS WITH ASSUME
	 * 
	 * Sometimes our test fails due to an external environment configuration or a date or time zone issue that we don’t have control over. We can defend our tests by using the org.junit.Assume class. This class offers many static methods, such as assumeTrue(condition) or assumeNotNull(condition) and etc. Before executing a test, we can check our assumption using the static methods of the Assume class. If our assumption fails, then the JUnit runner ignores the tests with failing assumptions.

Here are some examples how to use the JUnit Assumptions.

package com.memorynotfound.test;

import org.junit.Test;
import java.io.File;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.*;

public class TestExecutionOrder {

    @Test
    public void assumeThatFileSeparatorTest(){
        assumeThat(File.separatorChar, is('/'));
        System.out.println("execute test");
    }

    @Test
    public void assumeNotNullTest(){
        Object object = null;
        assumeNotNull(object);
        System.out.println("execute test");
    }

    @Test
    public void assumeServerIsRunningTest(){
        boolean isServerRunning = false;
        assumeTrue(isServerRunning);
        System.out.println("execute test");
    }
}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * This example explains how to use a ServletRequestListener in a web application. This interface is used for receiving notification events about requests coming into and going out of scope of a web application. Notifications will be generated when a request is first comming into scope and when it get out of scope. The ServletRequestListener can be registerd by @WebListener annotation, adding the listener to the servlet descriptor or programmatically adding a listener with .addListener() to the servlet context. In this example we use the @WebListener annotation.
ServletRequestListener receives notifications for ServletRequest init and destroy

In order to listen to the lifecyle event of initialization or destroying of a ServletRequest we need to implement the javax.servlet.ServletRequestListener interface. This interface lets us listen to the following events, the names speak for themselves.

    requestInitialized()
    requestDestroyed()

To register a listener we can add the @WebListener, define the listener in the servlet descriptor (web.xml) or programatigally add it to the servlet context. In this example we choose to add the listener through the @WebListener annotation.

package com.memorynotfound;

import javax.servlet.*;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestLogger implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("request initialized, request by: " + event.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("request destroyed");
    }

}

Note: If you prefer the web.xml servlet descriptor over the @WebListener annotation you can add the context listener as follows:

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" version="3.1">

    <listener>
        <listener-class>com.memorynotfound.ServletRequestLogger</listener-class>
    </listener>
    
</web-app>

How does it work

When a ServletRequest is created for the first time the requestInitialized() is called. When the ServletRequest is out of scope and therefore destroyed the requestDestroyed() will be invoked.
References

    ServletRequestListener JavaDoc
    Servlet 3 API specification
	 * 
	 * 
	 * 
	 * 
	 * -----------------
	 * n this tutorial we will show you how to handling servlet HTTP request parameters. The HTTP request parameters are sent along with the request. You can send request parameters as part of the URL or as part of the body of an HTTP request.
Project structure

+--src
|   +--main
|       +--java
|           +--com
|               +--memorynotfound
|                   |--ServletParameterExample.java
|       |--resources
|       |--webapp
pom.xml

Maven Dependency

<dependencies>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>

Servlet HTTP Request Parameters

The request.getParameter() is used to get the HTTP request parameters from the request and returns a string. We can also get an array of parameters with request.getParameterValues() which returns an array of strings.

package com.memorynotfound;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/parameters")
public class ServletParameterExample extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get parameters from request
        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");
        String[] paramArray = req.getParameterValues("paramArray");

        // print the response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><body>");
        out.write("<h2>Servlet HTTP Request Parameters example</h2>");
        out.write("<p>param1: " + param1 + "</p>");
        out.write("<p>param2: " + param2 + "</p>");
        out.write("<p>paramArray: " + Arrays.toString(paramArray) + "</p>");
    }

}

Servlet array of parameters

URL: …?paramArray=1&paramArray=2&paramArray=3

String[] paramArray = req.getParameterValues("paramArray");

Demo
Parameter page without setting parameters

URL: http://localhost:8080/servlet-parameter/parameters
	 * 
	 * 
	 * 
	 * 
	 * We will show how you can use the servlet 3 initialisation parameter annotation @WebInitParam to inject initialisation parameters in our servlet. We can configure our servlet entirely with annotations which means no more web.xml which is awesome.
Project structure

+--src
|   +--main
|       +--java
|           +--com
|               +--memorynotfound
|                   |--ExampleServlet.java
|       |--resources
|       |--webapp
pom.xml

Maven Dependency

<dependencies>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>

Servlet 3 initialisation parameter annotation

The @WebInitParam annotation is used to specify init parameters for a servlet or filter. The servlet 3 initialisation parameter takes a required name and value. You can add a description but this is rather informative. In the initialisation method init() we can get our init parameter using the servletConfig.getInitParameter() method.

package com.memorynotfound;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        value = "/example",
        initParams = {
                @WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
                @WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster")
        },
        description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")
public class ExampleServlet extends HttpServlet{

    private String email, phone;

    @Override
    public void init(ServletConfig config) throws ServletException {
        email = config.getInitParameter("email");
        phone = config.getInitParameter("phone");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h2>Servlet 3 initialisation parameter annotation example: @WebInitParam</h2>");
        out.write("<p><strong>E-mail: </strong>" + email + "</p>");
        out.write("<p><strong>Phone: </strong>" + phone + "</p>");
    }

}
	 * 
	 * 
	 */
	
	
	
	
	
	
	/*
	 * COUNTING ELAPSED TIME
	 * 
	 * Calculating Elapsed Time

The main reason why you want to know the elapsed time of the method executions is to identify bottlenecks and long running methods, or simply if you want to let your management see how awesomely fast your methods are.
If you are measuring elapsed time, and you want it to be correct, you must use System.nanoTime(). You cannot use System.currentTimeMillis(), unless you don’t mind your result being wrong.
Difference between nanoTime and CurrentTimeMillis

The purpose of nanoTime is to measure elapsed time, and the purpose of currentTimeMillis is to measure wall-clock time. As these are designed for specific reasons, it is important to choose the right one for your needs. The reason is that no computer’s clock is perfect. It is sometimes off and periodically needs to be corrected. This correction might either happen manually, or in the case of most machines, there’s a process that runs and continually issues small corrections to the system clock or wall-clock. These shifts tend to happen often. Another such correction happens whenever there is a leap second.

Since nanoTime’s purpose is to measure elapsed time, it is unaffected by any of these small corrections. It is what you want to use for calculating elapsed time.

You may think, “So what? This will not matter that much”, to which I say, maybe not, but overall, isn’t correct code just better than incorrect code? Besides, nanoTime is shorter to type anyway.
Basic Elapsed Time Calculation

Calculating elapsed time basically comes down to start a timer just before the method execution and at the end of the method execution. You stop the timer and calculate the difference. Here is a basic example to calculate the elapsed time.

package com.memorynotfound.time;

import java.util.concurrent.TimeUnit;

public class ElapsedTime {

    public static void main(String... args) throws InterruptedException {
        long startTime = System.nanoTime();
        Thread.sleep(1000 * 10);
        long difference = System.nanoTime() - startTime;
        System.out.println("Total execution time: " +
                String.format("%d min, %d sec",
                        TimeUnit.NANOSECONDS.toHours(difference),
                        TimeUnit.NANOSECONDS.toSeconds(difference) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
    }
}

Calculating Elapsed time Between two Dates

Here is a method to calculate the elapsed time between two dates. It calculates the difference between two dates and puts the result in a HashMap containing all the TimeUnits.

package com.memorynotfound;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ElapsedTimeBetweenDates {

    public static void main(String []args) {
        Date startDateTime = new Date(System.currentTimeMillis() - 123456789);
        Date endDateTime = new Date();

        Map<TimeUnit,Long> result = computeDiff(startDateTime, endDateTime);
        System.out.println(result);

        System.out.println("Days: " + result.get(TimeUnit.DAYS));
        System.out.println("Hours: " + result.get(TimeUnit.HOURS));
        System.out.println("Minutes: " + result.get(TimeUnit.MINUTES));
        System.out.println("Seconds: " + result.get(TimeUnit.SECONDS));
        System.out.println("MilliSeconds: " + result.get(TimeUnit.MILLISECONDS));
    }

    public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {
        long diffInMilliSeconds = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliSecondsRest = diffInMilliSeconds;
        for (TimeUnit unit : units) {
            long diff = unit.convert(milliSecondsRest,TimeUnit.MILLISECONDS);
            long diffInMilliSecondsForUnit = unit.toMillis(diff);
            milliSecondsRest = milliSecondsRest - diffInMilliSecondsForUnit;
            result.put(unit,diff);
        }
        return result;
    }

}

Output

{DAYS=1, HOURS=10, MINUTES=17, SECONDS=36, MILLISECONDS=789, MICROSECONDS=0, NANOSECONDS=0}
Days: 1
Hours: 10
Minutes: 17
Seconds: 36
MilliSeconds: 789

Calculating Elapsed Time Revisited

The basic elapsed time calculation is ok. But we strive the DRY principle (Don’t Repeat Yourself). So I guess we can do better. Here is an example class that will manage calculating elapsed time.

package com.memorynotfound.time;

import java.util.concurrent.TimeUnit;

public class TimeWatch {

    long starts;

    private TimeWatch() {
        reset();
    }

    public static TimeWatch start() {
        return new TimeWatch();
    }

    public TimeWatch reset() {
        starts = System.nanoTime();
        return this;
    }

    public long time() {
        long ends = System.nanoTime();
        return ends - starts;
    }

    public long time(TimeUnit unit) {
        return unit.convert(time(), TimeUnit.NANOSECONDS);
    }

    public String toMinuteSeconds(){
        return String.format("%d min, %d sec", time(TimeUnit.MINUTES),
                time(TimeUnit.SECONDS) - time(TimeUnit.MINUTES));
    }
}

In the following code snippet we test our new TimeWatch class. We use a Thread.sleep() to mimic a method execution. After the method completes we print out some info of the method execution time.

package com.memorynotfound.time;

import java.util.concurrent.TimeUnit;

public class ElapsedTimeWatch {

    public static void main(String... args) throws InterruptedException {

        TimeWatch watch = TimeWatch.start();
        Thread.sleep(1000 * 10);
        System.out.println("Elapsed Time custom format: " + watch.toMinuteSeconds());
        System.out.println("Elapsed Time in seconds: " + watch.time(TimeUnit.SECONDS));
        System.out.println("Elapsed Time in nano seconds: " + watch.time());

    }
}

As you can see we can print out a custom format of “x min, x sec”. You can also convert the elapsed time to any format you want using the TimeUtil. And because we use the nanoTime we can also print the elapsed nano seconds.

Elapsed Time custom format: 0 min, 10 sec
Elapsed Time in seconds: 10
Elapsed Time in nano seconds: 10030802887

References

    TimeUnit JavaDoc
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ARRAYLIST   WORK
	 * This tutorials demonstrates how to initialize a list or arraylist in one line in different ways.
The traditional way to create and initialize an ArrayList is:

List<String> planets = new ArrayList<String>();
planets.add("Earth");
planets.add("Mars");
planets.add("Venus");

The following examples demonstrate how to create and initialize a List or ArrayList in a single line of code.
Method 1: Creating a singleton list

Creates an immutable list containing only the specified object. The returned list is serializable.

List<String> planets = Collections.singletonList("Earth");

Method 2a: Creating and initialize a list in one line

Creates a fixed-size list backed by the specified array. This method acts as bridge between array-based and collection-based APIs, in combination with Collection.toArray(). The returned list is serializable and implements RandomAccess. This method also provides a convenient way to create a fixed-size list initialized to contain several elements:

List<String> planets = Arrays.asList("Earth", "Mars", "Venus");

Method 2b: Creating and initialize a list in one line and static import

We can statically import the asList()

import static java.util.Arrays.asList;

List<String> planets = asList("Earth", "Mars", "Venus");

Method 3a: Create and initialize an arraylist in one line

Constructs a list containing the elements of the specified collection, in the order they are returned by the collection’s iterator.

List<String> planets = new ArrayList<String>(Arrays.asList("Earth", "Mars", "Venus"));

Method 3b: Create and initialize an arraylist in one line and static import

We can statically import the asList()

import static java.util.Arrays.asList;

List<String> planets = new ArrayList<String>(asList("Earth", "Mars", "Venus"));

Method 4: Create and initialize an arraylist using anonymous inner class

Using an anonymous inner class with an instance initializer (also known as an “double brace initialization”).

List<String> planets = new ArrayList<String>() {{
    add("Earth");
    add("Mars");
    add("Venus");
}};

Method 5a: Create and initialize a list using Java 8

Stream.of() returns a sequential ordered stream whose elements are the specified values. Collectors.toList() returns a Collector that accumulates the input elements into a new List. There are no guarantees on the type, mutability, serializability, or thread-safety of the List returned; if more control over the returned List is required, use toCollection(Supplier).

List<String> planets = Stream
        .of("Earth", "Mars", "Venus")
        .collect(Collectors.toList());

Method 5b: Create and initialize an arraylist using Java 8

Stream.of() returns a sequential ordered stream whose elements are the specified values. Collectors.toCollection() returns a Collector that accumulates the input elements into a new Collection, in encounter order. The Collection is created by the provided factory.

ArrayList<String> planets = Stream
        .of("Earth", "Mars", "Venus")
        .collect(Collectors.toCollection(ArrayList::new));

Method 6a: Create and initialize a list using Java 8 static import

We can statically import the of() and toList() methods.

import static java.util.stream.Stream.of;
import static java.util.stream.Collectors.toList;

List<String> planets = of("Earth", "Mars", "Venus").collect(toList());

Method 7b: Create and initialize an arraylist using Java 8 static import

We can statically import the of() and toCollection() methods.

import static java.util.stream.Stream.of;
import static java.util.stream.Collectors.toCollection;

ArrayList<String> planets = of("Earth", "Mars", "Venus").collect(toCollection(ArrayList::new));

References

    ArrayList JavaDoc
    Collections JavaDoc
    Arrays JavaDoc
    Stream JavaDoc
    Collectors JavaDoc
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * RUN THIS SHHH IN C#
	 * 
	 * 

If you need finer control than launching an external program, then consider IKVM - http://www.ikvm.net/ - which provides a way to run Java programs inside a .NET world.
shareimprove this answer
answered May 17 '09 at 9:12
Thorbjørn Ravn Andersen
58.1k2525 gold badges153153 silver badges294294 bronze badges

    This tool is extremely nice!! I'm sitting in project with a lot of data access from Java and front end app in .Net and solved all my problems! – StefanE Feb 18 '11 at 15:10
    anyone knows if this project is dead? 2012 seems to be the last update and only v7... not v8 – BerggreenDK Sep 21 '15 at 21:54
    See weblog.ikvm.net – Thorbjørn Ravn Andersen Sep 21 '15 at 21:59
    2
    The project is confirmed dead by the lead developer – Alexander Jan 25 '18 at 16:53
    @Alexander No, he just don't want to work on it anymore. If anybody else wants to, they can. Apparently none do. – Thorbjørn Ravn Andersen Jan 1 at 17:43

add a comment
22

var processInfo = new ProcessStartInfo("java.exe", "-jar app.jar")
                      {
                          CreateNoWindow = true,
                          UseShellExecute = false
                      };
Process proc;

if ((proc = Process.Start(processInfo)) == null)
{
    throw new InvalidOperationException("??");
}

proc.WaitForExit();
int exitCode = proc.ExitCode;
proc.Close();

shareimprove this answer
edited Jul 2 '10 at 19:54
Sky Sanders
28.8k55 gold badges6060 silver badges8585 bronze badges
answered May 17 '09 at 5:11
Jase Whatson
2,88033 gold badges2929 silver badges4141 bronze badges

    UseShellExecute = false did the trick for me – Pavol Hanzel Apr 6 '17 at 9:17

add a comment
11

It's the same as executing native .EXE files, only that the executable you will have to execute is the JVM itself (java.exe).

So, inside your C# code call:

    java.exe -jar nameofyourjavaprogram.jar

And you should be fine.

If you don't have your java program on a JAR library, just make the JVM launch with all the parameters you need.
shareimprove this answer
answered May 17 '09 at 2:54
Pablo Santa Cruz
140k2828 gold badges206206 silver badges257257 bronze badges

    Also note there is a DLL you can invoke in case you need something back from the JVM. – Thorbjørn Ravn Andersen Jul 2 '10 at 19:57

add a comment
5

I added a couple of lines to the above solution. I wanted to call a Web Service from a Silverlight app that process some files using java on the server. The above solution is helpful but I modified a little bit so that it works since calling via a web service is a little bit trickier. Now you have the right tool for the job, C# when appropriate, Java when C# cannot solve the problem. It's always good to know more than just one way of doing things. Now my Web Service created in .Net can talk to Java.

private void Merge(string strPath)
{
  var processInfo = new ProcessStartInfo("C:\\Program Files\\Java\\jdk1.6.0_24\\binjava.exe", "-jar app.jar")
  {
     CreateNoWindow = true,
     UseShellExecute = false
  };

  processInfo.WorkingDirectory = strPath; // this is where your jar file is.
  Process proc;

  if ((proc = Process.Start(processInfo)) == null)
  {
    throw new InvalidOperationException("??");
  }

  proc.WaitForExit();
  int exitCode = proc.ExitCode;
  proc.Close();
}

shareimprove this answer
edited Oct 26 '12 at 4:48
j.w.r
3,39111 gold badge2222 silver badges2828 bronze badges
answered Mar 13 '12 at 18:40
Chan Souvannarath
5111 silver badge33 bronze badges
add a comment
2

    Will it run synchronously or asynchronously

It will run asynchronously if you have enough cores, otherwise it run independently, but your thread will have to context switch so the other program will run. Either way its not something you should need to worry about.

	 * 
	 * 
	 * 
	 * 

Just for the completeness: When lauching a Swing jar from C# I found this detail: if you don't set the working directory in the ProcessStartInfo object, your shiny Swing app will launch... but with no icons and no images!!

This is the minimal working code copied from the answers here and elsewhere on SO (works for me: Java 1.8 on Win7, mi images and icons are in a subfolder of the workingDirectory):

ProcessStartInfo psi = new ProcessStartInfo("java.exe", " -jar \"C:\\Program Files\\Installed Shiny Swing jar app\\Myjar.jar\"");
psi.WorkingDirectory = "C:\\Program Files\\Installed Shiny Swing jar app\\"; // Do not miss this line so you awesome Swing app will show default java icon and no images
psi.CreateNoWindow = true;
psi.UseShellExecute = false;
Process p = new Process();
p.StartInfo = psi;
p.Start();


	 * 
	 * orrrrrr

Use this line :

System.Diagnostics.Process.Start("java -jar filename.jar");

If you want these java and c# to interact with each other use shared file or socket programming

Note you need to configure java in ur system.

	 * 
	 * orrrrr
	 * 
	 * 
	 * public void exe()
       {
           string path = "C:\\sen";
           Process process = new Process();
           process.EnableRaisingEvents = false;
           process.StartInfo.FileName = "java.exe";
           process.StartInfo.Arguments = "-jar " + '"' + path + "\\report.jar";
           process.Start();
       }
	 * 
	 * You can use the process class.  Change the example below to use the proper paths.

System.Diagnostics.Process.Start("java -jar myprog.jar");
	 * 
	 * 
	 * ALSO CHECK OUT
	 * http://jni4net.com/
	 */
	
}
