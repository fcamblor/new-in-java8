package org.isk.nashorn;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Executes JavaScript from Java.
 * @author Yohan Beschi
 */
public class NashornTest {
    private ScriptEngine ENGINE;
    
    @Before
    public void setUp() {
        final ScriptEngineManager factory = new ScriptEngineManager();
        // "nashorn", "JavaScript", "ECMAScript", etc.
        ENGINE = factory.getEngineByName("nashorn");
    }
    
    @Test
    public void nashornString() throws ScriptException {
        ENGINE.eval("print(15 + 10)"); // prints 25
    }
    
    @Test
    public void nashornFile() throws ScriptException, NoSuchMethodException {
        // Build a Reader
        final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("simple.js");
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        ENGINE.eval("var mySecondeVariable = 10");
        ENGINE.eval(inputStreamReader);
        
        // Get a variable from a JavaScript file
        Assert.assertEquals("jsVariable", ENGINE.get("myVariable"));
        
        // Invoke a function from a JavaScript file
        final Invocable invocable = (Invocable)ENGINE;
        final int sum = (Integer)invocable.invokeFunction("sum", 30, 20);
        Assert.assertEquals(50, sum);
        
        // Get a variable
        Assert.assertEquals(new Integer(10), ENGINE.get("mySecondeVariable"));
    }
    
    @Test
    public void scriptEngineFactories() {
        ScriptEngineManager manager = new ScriptEngineManager(); 
        List<ScriptEngineFactory> factories = manager.getEngineFactories(); 

        for (ScriptEngineFactory factory : factories) { 
          System.out.println("Name : " + factory.getEngineName()); 
          System.out.println("Version : " + factory.getEngineVersion()); 
          System.out.println("Language name : " + factory.getLanguageName()); 
          System.out.println("Language version : " + factory.getLanguageVersion()); 
          System.out.println("Extensions : " + factory.getExtensions()); 
          System.out.println("Mime types : " + factory.getMimeTypes()); 
          System.out.println("Names : " + factory.getNames()); 
        }
    }
}