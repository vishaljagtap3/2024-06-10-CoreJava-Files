import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileUtil {

    public static void listFileHierarchy(String path, int tabs) {
        File file = new File(path);
        if(!file.exists()) {
            return;
        }

        for(int i = 0; i < tabs; i++) {
            System.out.print("\t");
        }
        System.out.println((file.isFile()? "F:" : "D:") + file.getName());

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            tabs++;
            if (files != null) {
                for (File file1 : files) {
                    listFileHierarchy(file1.getAbsolutePath(), tabs);
                }
            }
        }


        return;
    }

    public static void deleteAll(String path) {
        File file = new File(path);
        if(!file.exists()) {
            return;
        }

        if(file.isFile()) {
            file.delete();
            return;
        }

        File [] files = file.listFiles();
        if(files != null) {
            for(File file1 : files) {
                deleteAll(file1.getAbsolutePath());
            }
        }

        file.delete();
        return;
    }

    public static void printFileInfo(File file) {
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length());
        System.out.println("IsFile: " + file.isFile() + " IsDir: " + file.isDirectory());
        System.out.println("Last Modified time: " + file.lastModified());
        System.out.println("RWE: " + file.canRead() + " " + file.canWrite() + " " + file.canExecute());
        System.out.println("Exists: " + file.exists());
        System.out.println("Hidden: " + file.isHidden() );
        System.out.println("------------------------------------------------");
    }

    public static boolean createFile(String path) {
        File newFile = new File(path);

        if(newFile.exists()) {
            return false;
        }

        try {
            return newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean createDirectory(String path) {
        File dir = new File(path);

        if(dir.exists()) {
            return false;
        }

        return dir.mkdir();
    }

    public static boolean createDirectoryV1(String path) {
        File dir = new File(path);

        if(dir.exists()) {
            return false;
        }

        return dir.mkdirs();
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);

       /* if(!file.exists()) {
            return false;
        }*/

        return file.delete();
    }

    public static void printFilesList(String dirPath) {
        File dir = new File(dirPath);

        if(!dir.exists() || dir.isFile()) {
            return;
        }

        //get the list of all the files under a directory
        //String [] fileNames = dir.list();

        //String [] fileNames = dir.list(new MyFileNameFilter());
        String [] fileNames = dir.list(new MyFileNameFilter());
        for(String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    public static void printFilesListV1(String dirPath) {
        File dir = new File(dirPath);

        if(!dir.exists() || dir.isFile()) {
            return;
        }

        //File [] files = dir.listFiles();
        //File [] files = dir.listFiles( new MyFileFilter());
        File [] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() && file.getName().startsWith("d");
            }
        });
        for(File file : files) {
            System.out.println( (file.isFile() ? "F: " : "D: ") + file.getName());
        }
    }

}


class MyFileFilter implements FileFilter {
    @Override
    public boolean accept(File file) {
        return file.isDirectory() && file.getName().startsWith("d");
    }
}


class MyFileNameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {

        return name.startsWith("d");

        /*if(name.startsWith("d")) {
            return true;
        }
        return false;*/
    }
}