package org.example.folder;

import org.example.folder.folderClasses.PrintDirHierarchy;


public class Main {
    //2 Files обладает способом обхода дерева каталогов.
    // Более подробно можно об этом почитать в статье https://habr.com/ru/articles/437694/
    //Создайте программу, которая будет принимать путь к существующей папке на Вашем компьютере.
    // После этого программа должна вывести имена файлов и папок на каждом уровне,
    // начиная с текущей папки до корня дерева (диска C или другого диска).
    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator";
        PrintDirHierarchy.printDirHierarchy(path);
    }
}
