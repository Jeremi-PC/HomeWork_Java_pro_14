package org.example.folder.folderClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class PrintDirHierarchy {
    public static void printDirHierarchy(String path) {
        Path currentPath = Paths.get(path).toAbsolutePath();
        while (currentPath != null) {
            System.out.println("Current new dir " + currentPath);
            try (Stream<Path> stream = Files.walk(currentPath, 1)) {
                stream.forEach(o -> {
                    if (Files.isDirectory(o)) {
                        System.out.println("Current dir: " + o);
                    } else {
                        System.out.println("Current file: " + o);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            currentPath = currentPath.getParent();
        }
    }
}