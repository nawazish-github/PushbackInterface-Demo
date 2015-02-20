/*
    First let us determine after reading byes from vanilla InputStream does it
    exhaust out of bytes. Then 'unreading' bytes read from underlying IS
    would make more sense. 
 */
package pushbackinterfacedemo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NawazishMohammad
 */
public class PushBackInterfaceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String str = "if (a == b) ? true : d = e"; // if a eq b ? true : d <- e
        byte [] strByte = str.getBytes();
        ByteArrayInputStream byteArrInStream = new ByteArrayInputStream(strByte);
        PushbackInputStream pushBkInStream = new PushbackInputStream(byteArrInStream);
        int data;
        while ((data = pushBkInStream.read()) != -1){
            switch (data) {
                case '=' : 
                    if ((data = pushBkInStream.read()) == '=')
                        System.out.print(" eq ");
                    else {
                        System.out.print(" <- ");
                        pushBkInStream.unread(data);
                    }
                    break;
                default :
                    System.out.print((char) data);
                    //break;
                
            }
        }

    }
    
}
