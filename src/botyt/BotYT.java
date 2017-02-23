/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botyt;

import java.awt.AWTException;
import org.apache.commons.lang3.tuple.Pair;
import java.util.*;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maurilio
 */
public class BotYT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, AWTException {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        SystemTray tray = SystemTray.getSystemTray();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("trayIcon.jpg");

        PopupMenu menu = new PopupMenu();

        MenuItem messageItem = new MenuItem("Show Message");
        messageItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("www.java2s.com");
            }
        });
        menu.add(messageItem);

        MenuItem closeItem = new MenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(closeItem);
        TrayIcon icon = new TrayIcon(image, "SystemTray Demo", menu);
        icon.setImageAutoSize(true);

        tray.add(icon);
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        List<Pair<String, Long>> links = new ArrayList<>();
        links.add(Pair.of("https://www.youtube.com/watch?v=F_9DMvpGuQ4", Long.valueOf(559)));
        links.add(Pair.of("https://www.youtube.com/watch?v=t4YT98kPXzc", Long.valueOf(1095)));
        links.add(Pair.of("https://www.youtube.com/watch?v=1wnZImJOKKU", Long.valueOf(846)));
        links.add(Pair.of("https://www.youtube.com/watch?v=yDiwggC-vt8", Long.valueOf(586)));
        for (Pair<String, Long> m : links) {
            new Thread(new ThreadScrap(m.getKey(), m.getValue())).start();
        }
    }

}
