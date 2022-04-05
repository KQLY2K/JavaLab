package com.company;

import java.net.*;
import java.util.Scanner;

public class CrawlerTask extends Thread {
    private URLPool pool;

    public CrawlerTask(URLDepthPair link) {
        pool = new URLPool(); // объект
        pool.addLink(link); // добавляем ссылку
    }

    @Override
    public void run() { // переопределяем ран
        URLDepthPair link = pool.getLink();
        System.out.println(link.toString()); // вывод ссылки
        System.out.println(Thread.activeCount());// кол-во активных потоков
        Crawler.CountURLs++; //счётчик
        if(link.getDepth() == Crawler.getMaxDepth()) return; // проверка

        findLinks(link);
    }

    private void findLinks(URLDepthPair link)
    {
        try { // проверка ссылки
            URL url = new URL(link.getURL());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.findWithinHorizon("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", 0) != null) {
                String newURL = scanner.match().group(2);
                URLDepthPair newLink =  createNewLink(newURL, link);
                if (newLink == null) continue;
                CreateNewThread(newLink); // создаём поток
            }
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private URLDepthPair createNewLink(String newURL, URLDepthPair link){
        if (newURL.startsWith("/")) {
            newURL = link.getURL() + newURL;
        }
        else if (!newURL.startsWith("https")) return null; // проверка

        return new URLDepthPair(newURL, link.getDepth() + 1);
    }

    private void CreateNewThread(URLDepthPair link)  { // создаём поток для сылки
        CrawlerTask task = new CrawlerTask(link);
        task.start();
    }
}