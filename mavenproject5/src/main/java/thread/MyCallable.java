/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.concurrent.Callable;

/**
 *
 * @author User
 */
public class MyCallable implements Callable<Object>{
public int index;
    
    public MyCallable(int index){
        this.index=index;
    }
    
    @Override
    public Object call() throws Exception {
        doIt();
        return this;
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
