/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baasankhuu.d
 */
public class PathTest {

    private static void listenForChanges(File file)  {
        Path path = file.toPath();
        if (file.isDirectory()) {
            try {
                WatchService ws = path.getFileSystem().newWatchService();
                path.register(ws, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
                WatchKey watch = null;
                while (true) {
                    System.out.println("Watching directory: " + file.getPath());
                    try {
                        watch = ws.take();
                    } catch (InterruptedException ex) {
                        System.err.println("Interrupted");
                    }
                    List<WatchEvent<?>> events = watch.pollEvents();
                    watch.reset();
                    for (WatchEvent<?> event : events) {
                        Kind<Path> kind = (Kind<Path>) event.kind();
                        Path context = (Path) event.context();
                        if (kind.equals(StandardWatchEventKinds.OVERFLOW)) {
                            System.out.println("OVERFLOW");
                        } else if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                            System.out.println("Created: " + context.getFileName());
                        } else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {
                            System.out.println("Deleted: " + context.getFileName());
                        } else if (kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                            Modified(file.toString(), context.getFileName().toString());
                           
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(PathTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Not a directory. Will exit.");
        }
    }
    private static void Modified(String path,String fileName) throws IOException{
    if(fileName.equals("cpuinfo")){
       try (BufferedReader br = new BufferedReader(new FileReader(path.concat("\\").concat(fileName)))) {

			String sCurrentLine;

           try {
               while ((sCurrentLine = br.readLine()) != null) {
                   System.out.println(sCurrentLine);
               }
           } catch (IOException ex) {
               Logger.getLogger(PathTest.class.getName()).log(Level.SEVERE, null, ex);
           }

		} catch (FileNotFoundException e) {
                    Logger.getLogger(PathTest.class.getName()).log(Level.SEVERE, null, e);
		}

    }
    }
    public static void main(String[] args) {

        File file = new File("D:\\sessions");
        System.out.println("Listening on: " + file);
        listenForChanges(file);

    }
}
