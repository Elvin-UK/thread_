/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MyRunnable implements Runnable{

    public int index;
    
    public MyRunnable(int index){
        this.index=index;
    }
    
    
    
    @Override
    public void run() {
        doIt();
      
     }
    private void doIt(){
        System.out.println(index+"runnable ishe dusdu ve 10 saniye gozleyecek");   
       try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
         }
        System.out.println("runnable ishini bitirdi");
    }
}
