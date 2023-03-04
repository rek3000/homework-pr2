package chapter03;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import utils.TextIO;

/**
 * @overview 
 *  Enhanced version of {@link TextIO}.
 *  
 * @author dmle
 *
 * @version 
 */
public class TextIOPlus extends TextIO {
  
  /**
   * @requires 
   *  <tt>urlString</tt> is a well-formed URL to a text file resource 
   *  (e.g. http://www.mysite.com/myfile.txt) 
   *  
   * @effects 
   *  read text from the URL specified by <tt>urlString</tt> and return the content.
   *  
   *  <p>If failed to read text return null
   */
  public static String readTextFromURL(String urlString) {
    // create InputStream from url
    URL url;
    try {
      url = new URL(urlString);
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
    
    InputStream ins;
    try {
      ins = url.openStream();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    
    // read from input stream
    TextIO.readStream(ins);
    
    return readText();
  }
  
  /**
   * @requires 
   *  one of the <tt>readFile()</tt> methods has been invoked
   *  
   * @effects 
   *  uses TextIO to read content of file named <tt>fileName</tt> which is stored at the same directory as 
   *  this class and return it.
   *  
   *  <p>If failed to read file return null
   */
  private static String readText() {
    
    StringBuffer fileBuf = new StringBuffer();
    final char NL = '\n';
    
    while (!TextIO.eof()) {
      fileBuf.append(TextIO.getln()).append(NL);
    }
    
    if (fileBuf.length() > 0) 
      return fileBuf.toString();
    else
      return null;
  }

  /**
   * @effects 
   *  read content of file named <tt>fileName</tt> which is stored at the same directory as 
   *  class <tt>cls</tt> and return it.
   *  
   *  <p>If failed to read file return null
   */
  public static String readTextFileContent(Class cls, String fileName) {
    URL fileURL = cls.getResource(fileName);
    if (fileURL == null) 
      return null;
    
    String filePath = fileURL.getPath();
    
    TextIO.readFile(filePath);
    StringBuffer fileBuf = new StringBuffer();
    final char NL = '\n';
    
    while (!TextIO.eof()) {
      fileBuf.append(TextIO.getln()).append(NL);
    }
    
    if (fileBuf.length() > 0) 
      return fileBuf.toString();
    else
      return null;
  }

  /**
   * @effects 
   *  read content of file whose absolute path is <tt>filePath</tt> and return it.
   *  
   *  <p>If failed to read file return null
   */
  public static String readTextFileContent(String filePath) {
    
    TextIO.readFile(filePath);
    
    StringBuffer fileBuf = new StringBuffer();
    final char NL = '\n';
    
    while (!TextIO.eof()) {
      fileBuf.append(TextIO.getln()).append(NL);
    }
    
    if (fileBuf.length() > 0) 
      return fileBuf.toString();
    else
      return null;
  }
  
  
  /**
   * @effects 
   *  display prompt message <tt>prompt</tt> and   
   *  call {@link #getlnString()} to obtain a {@link String} input from the user.
   *  Return the input value 
   */
  public static String getString(String prompt) {
    prompt = prompt.trim();
    if (!prompt.endsWith(":"))
      System.out.println(prompt + ":");
    else
      System.out.println(prompt);
    
    return getlnString();
  }
}
