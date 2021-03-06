import java.util.*;
import java.util.LinkedList;

/**
 * Created by ashi on 9/2/17.
 * Given a list of absolute file paths, write a program to create a directory structure from it.
 And given a directory structure, output a list of absolute file paths.
 */
public class DirectoryStructure {

    private class File {
        String fileName;
        public File(String fileName){
            this.fileName = fileName;
        }
    }
    private class Directory {
        String name;
        List<Directory> directories =  new LinkedList<>();
        List<File> files=new LinkedList<>();

        public Directory(String name) {
            this.name = name;
        }

        public void addDirectory(Directory directory){
            this.directories.add(directory);
        }

        public void addFile(Directory parent, File file){
            parent.files.add(file);
        }


    }

    Directory createDirectoryStructure(List<String> absolutePaths) {
        for(String absolutePath : absolutePaths) {
            String tokens[] = absolutePath.split("/");
            for (String i :
                    tokens) {
                Directory parent = new Directory(i);
                if (i.contains(".")) {

                    File file = new File(i);
                    parent.addFile(parent,file);

                } else {
                    parent.addDirectory(parent);
                }

            }

        }
        return null;
    }

    public void printDirectory(DirectoryStructure directory){
        System.out.println(directory);
    }

    List<String> createAbsoluteFilePaths(Directory root) {
        return null;
    }

    public static void main(String[] args) {
        String absolutePath1 = "home/ash/doc2.txt";
        String absolutePath2 = "home/aishu/doc3.txt";
        List fileList = new LinkedList();
        fileList.add(absolutePath1);
        fileList.add(absolutePath2);
        DirectoryStructure directoryStructure = new DirectoryStructure();
        directoryStructure.createDirectoryStructure(fileList);
        directoryStructure.printDirectory(directoryStructure);


    }




}

