import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOps {

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoose the File manager menu item:");
            System.out.println("1. Print Working Directory");
            System.out.println("2. Create a new file");
            System.out.println("3. Rename created file");
            System.out.println("4. Delete first file");
            System.out.println("5. Delete renamed file");
            System.out.println("6. Show files List");
            System.out.println("0. Exit");

            Scanner userInput = new Scanner(System.in);
            String chosenOperation = userInput.nextLine();
            System.out.println("Chosen item is: " + chosenOperation);

            if (chosenOperation.contains("0") || chosenOperation.contains("exit")) {
                System.out.println("Successfully finished, Goodbye!");
                break;
            }
            switch (chosenOperation) {
                case "1":
                    printWorkingDirectory();
                    break;
                case "2":
                    createFile();
                    break;
                case "3":
                    renameFile();
                    break;
                case "4":
                    deleteFirstFile();
                    break;
                case "5":
                    deleteRenamedFile();
                    break;
                case "6":
                    fileList();
                    break;
                default:
                    System.out.println("No defined operation for your choice");
            }
        }
    }


    public static void printWorkingDirectory() {
        System.out.println("Your working directory is: " + System.getProperty("user.dir"));
    }

    public static void createFile() {
        File file = new File("/Users/mariashulyakovskaya/IdeaProjects/FileOperator/myNewFile.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("myNewfile.txt File is successfully created in the project root directory");
            } else {
                System.out.println("myNewfile.txt File already exists in the project root directory");
            }
        } catch (IOException e) {  //Added by Idea
            e.printStackTrace();
        }

    }

    public static void renameFile() {
        File file = new File("/Users/mariashulyakovskaya/IdeaProjects/FileOperator/myNewFile.txt");
        File newFile = new File("/Users/mariashulyakovskaya/IdeaProjects/FileOperator/myRenamedFile.txt");
        if (file.renameTo(newFile)) {
            System.out.println("myNewFile.txt File is successfully renamed to myRenamedFile.txt");
        } else {
            System.out.println("Sorry! File can't be renamed");
        }
    }

    public static void deleteFirstFile() {
        File file = new File("/Users/mariashulyakovskaya/IdeaProjects/FileOperator/myNewFile.txt");
        if (file.delete()) {
            System.out.println("myNewFile.txt File is successfully deleted");
        } else {
            System.out.println("Sorry! File can't be deleted");
        }
    }

    public static void deleteRenamedFile() {
        File file = new File("/Users/mariashulyakovskaya/IdeaProjects/FileOperator/myRenamedFile.txt");
        if (file.delete()) {
            System.out.println("myRenamedFile.txt File is successfully deleted");
        } else {
            System.out.println("Sorry! File can't be deleted");
        }
    }

    public static void fileList() {
        File file = new File(System.getProperty("user.dir"));
        String[] fileNames = file.list();
        System.out.println(Arrays.toString(fileNames));
    }

}


