/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botyt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Maurilio
 */
public class ThreadScrap implements Runnable {

    private String link;
    private long segundos;

    public ThreadScrap(String link, long segundos) {
        this.link = link;
        this.segundos = segundos * 1000;
    }

    @Override
    public void run() {
        while (true) {
            WebDriver driver = new ChromeDriver();
            driver.get(link);
            try {
                Thread.sleep(segundos);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadScrap.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                driver.close();
                driver.quit();
            }

        }
    }

}
