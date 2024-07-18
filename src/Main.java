import java.io.File;

public class Main {
    public static void main(String[] args) {

        String basePath = "/Users/vishal/java/workspaces/demo_files/";

        //File file = new File(basePath, "magicfile.txt");

        /*File file1 = new File(basePath + "demo.pdf");
        FileUtil.printFileInfo(file1);
        FileUtil.printFileInfo(new File(basePath + "sample1.jpg"));
        FileUtil.printFileInfo(new File(basePath + "data"));
        FileUtil.printFileInfo(new File(basePath + "data_new"));

        boolean isCreated = FileUtil.createFile(basePath + "my_resume.txt");
        FileUtil.createFile(basePath + "my_song.mp3");

        FileUtil.createDirectory(basePath + "pictures");
        FileUtil.createDirectory(basePath + "videos");

        isCreated = FileUtil.createDirectoryV1(basePath + "assignments/java/io");
        System.out.println("dir created: " + isCreated);
        */

        /*boolean isDeleted = FileUtil.deleteFile(basePath + "demo.pdf");
        System.out.println(isDeleted);

        isDeleted = FileUtil.deleteFile(basePath + "demo.java");
        System.out.println(isDeleted);

        isDeleted = FileUtil.deleteFile(basePath + "demo.txt");
        System.out.println(isDeleted);*/

        /*boolean isDeleted = FileUtil.deleteFile(basePath + "data");
        System.out.println(isDeleted);

        isDeleted = FileUtil.deleteFile(basePath + "videos");
        System.out.println(isDeleted);

        isDeleted = FileUtil.deleteFile(basePath + "assignments");
        System.out.println(isDeleted);*/

        /*FileUtil.printFilesList(basePath);
        System.out.println("--------------------------");
        FileUtil.printFilesList("/Users/vishal/");*/

        FileUtil.printFilesListV1(basePath);
        System.out.println("--------------------------");
        FileUtil.printFilesListV1("/Users/vishal/");

    }
}
