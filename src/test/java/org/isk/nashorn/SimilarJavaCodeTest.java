package org.isk.nashorn;

import java.util.Timer;
import java.util.TimerTask;
import org.junit.Test;

/**
 * Java equivalent of JavaScript examples :
 * <ul>
 *  <li>jjs_JavaImporter.js</li>
 *  <li>jjs_Packages.js</li>
 *  <li>jjs_ShortPackages.js</li>
 *  <li>jjs_ShortPackagesAndClosures.js</li>
 * </ul>
 * @author Yohan Beschi
 */
public class SimilarJavaCodeTest {
    /**
     * During 10 seconds, prints "Hello!" every second.
     * @throws InterruptedException 
     */
    @Test
    public void timerTask() throws InterruptedException {
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };
        
        new Timer().schedule(task, 0, 1000);
				Thread.sleep(10000);
				task.cancel();
    }
}
