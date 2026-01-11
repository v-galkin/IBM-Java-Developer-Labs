import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileSystemManager - A command-line file management system
 * 
 * This class provides a shell-like interface for managing files and directories
 */
public class FileSystemManager {
    
    // The current working directory
    private File currentDirectory;
    
    // Scanner for user input
    private Scanner scanner;
    
    // Date formatter for file timestamps
    private SimpleDateFormat dateFormat;
    
    /**
     * Constructor to initialize the file system manager
     */
    public FileSystemManager() {
        // TODO: Initialize the current directory to the user's current directory
        // Hint: Use System.getProperty("user.dir") to get the current working directory
        currentDirectory = new File(System.getProperty("user.dir"));
        
        // TODO: Initialize the scanner for reading user input
        scanner = new Scanner(System.in);
        
        // TODO: Initialize the date formatter for displaying timestamps
        // Hint: Use "yyyy-MM-dd HH:mm:ss" as the date format pattern
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * Start the file system manager
     */
    public void start() {
        System.out.println("Welcome to the File System Manager!");
        System.out.println("Type 'help' to see available commands.");
        
        boolean running = true;
        while (running) {
            // TODO: Display the current directory path as a prompt
            System.out.print(currentDirectory.getAbsolutePath() + "> ");
            
            // TODO: Read user command
            String userInput = scanner.nextLine().trim();

            // TODO: Process the command
            // If command is "exit", set running to false
            // Otherwise, call processCommand() method
            if(userInput.equalsIgnoreCase("exit")) {
                System.out.println("Closing the application.");
            } else {
                processCommand(userInput);
            }
        }
        
        // TODO: Close the scanner before exiting
        scanner.close();
    }
    
    /**
     * Process a user command
     * 
     * @param command The command entered by the user
     * @return true to continue, false to exit
     */
    private boolean processCommand(String command) {
        // Split the command into parts (command name and arguments)
        String[] parts = command.trim().split("\\s+", 2);
        String commandName = parts[0].toLowerCase();
        String args = (parts.length > 1) ? parts[1] : "";

        FileSystemCommand fileSystemCommand = FileSystemCommand.fromString(commandName);
        
        switch (fileSystemCommand) {
            case HELP:
                displayHelp();
                break;
            case LS:
                // TODO: Implement listing files and directories
                listFiles();
                break;
            case CD:
                // TODO: Implement changing directories
                // Hint: Handle "cd .." (parent directory) and "cd directoryName"
                changeDirectory(args);
                break;
            case PWD:
                // TODO: Implement displaying current directory path
                System.out.println(currentDirectory.getAbsolutePath());
                break;
            case MKDIR:
                // TODO: Implement creating a new directory
                createDirectory(args);
                break;
            case TOUCH:
                // TODO: Implement creating a new file
                createFile(args);
                break;
            case RM:
                // TODO: Implement deleting a file or directory
                delete(commandName);
                break;
            case RENAME:
                // TODO: Implement renaming a file or directory
                // Hint: The args will contain both old and new names
                rename(commandName, args);
                break;
            case FIND:
                // TODO: Implement searching for files by name pattern
                findFiles(args);
                break;
            case INFO:
                // TODO: Implement displaying file information
                displayFileInfo(args);
                break;
            case EXIT:
                System.out.println("Closing the application.");
                return false;
            default:
                System.out.println("Unknown command. Type 'help' for available commands.");
        }
        
        return true;
    }
    
    /**
     * Display help information
     */
    private void displayHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  help              - Display this help message");
        System.out.println("  ls                - List files in current directory");
        System.out.println("  cd <directory>    - Change to specified directory (use .. for parent)");
        System.out.println("  pwd               - Print current directory path");
        System.out.println("  mkdir <name>      - Create a new directory");
        System.out.println("  touch <name>      - Create a new file");
        System.out.println("  rm <name>         - Delete a file or directory");
        System.out.println("  rename <old> <new> - Rename a file or directory");
        System.out.println("  find <pattern>    - Search for files matching pattern");
        System.out.println("  info <name>       - Display file information");
        System.out.println("  exit              - Exit the program");
    }
    
    /**
     * List files and directories in the current directory
     */
    private void listFiles() {
        // TODO: Get the list of files and directories in the current directory
        File files[] = currentDirectory.listFiles();
        
        // TODO: Display the list of files and directories
        // For each file, show:
        // - 'd' if it's a directory or '-' if it's a file
        // - The file name
        if (files == null || files.length == 0) {
            System.out.println("No files in the current directory.");
        }

        for (File file : files) {
            char fileType;

            if (file.isDirectory()) {
                fileType = 'd';
            } else {
                fileType = '-';
            }

            System.out.println(fileType + " " + file.getName());
        }
    }
    
    /**
     * Change to a different directory
     * 
     * @param dirName The name of the directory to change to
     */
    private void changeDirectory(String dirName) {
        // TODO: Implement changing to a directory
        // If dirName is "..", go to parent directory
        // Otherwise, change to the specified directory if it exists

        // Ensure that file name was provided
        if(dirName == null || dirName.isBlank()) {
            System.out.println("Please use: cd <directory path> without <>.");
            return;
        }

        // Hold targetDIrectory path
        File targetDirectory;

        // Check if we need to go one level above
        // if not then create path to the new file
        if(dirName.equals("..")) {
            // Get path to the parent directory(one level above)
            targetDirectory = currentDirectory.getParentFile();

            if(targetDirectory == null) {
                System.out.println("Already at the root directory.");
            }
        } else {
            targetDirectory = new File(currentDirectory, dirName);
        }

        // Ensure that the target directory exist
        if(!targetDirectory.exists()) {
            System.out.println(targetDirectory + " does not exist");
            return;
        }

        // Ensure that the target directory is a directory not a file
        if(!targetDirectory.isDirectory()) {
            System.out.println(targetDirectory + " not a directory");
            return;
        }

        // follow the path
        currentDirectory = targetDirectory;
    }
    
    /**
     * Create a new directory
     * 
     * @param dirName The name of the directory to create
     */
    private void createDirectory(String dirName) {
        // TODO: Implement creating a new directory
        // Create a new directory with the given name in the current directory
        
        // Ensure that file name was provided
        if(dirName == null || dirName.isBlank()) {
            System.out.println("Please use: mkdir <directory path> without <>.");
            return;
        }

        File newDirectory = new File(currentDirectory, dirName);

        if(newDirectory.exists()) {
            System.out.println(dirName + " already exists.");
            return;
        }   

        if(newDirectory.mkdir()) {
            System.out.println(newDirectory + " was created.");
        } else {
            System.out.println("Failed to create " + newDirectory);
        }
    }
    
    /**
     * Create a new file
     * 
     * @param fileName The name of the file to create
     */
    private void createFile(String fileName) {
        // TODO: Implement creating a new file
        // Create a new empty file with the given name in the current directory
        if (fileName == null || fileName.isBlank()) {
            System.out.println("Please use: touch <file name> without <>.");
            return;
        }

        File newFile = new File(currentDirectory, fileName);

        if(newFile.exists()) {
            System.out.println(fileName + " already exists.");
        }

        try {
            if(newFile.createNewFile()) {
                System.out.println(newFile + " was created.");
            } else {
                System.out.println("Failed to create " + newFile);
            }
        } catch (IOException ioe){
            System.out.println("Error creating a new file: " + ioe.getMessage());
        }

    }
    
    /**
     * Delete a file or directory
     * 
     * @param name The name of the file or directory to delete
     */
    private void delete(String name) {
        // TODO: Implement deleting a file or directory
        // If it's a directory, provide a warning and confirm deletion
            if (name == null || name.isBlank()) {
                System.out.println("Please use: rm <file/directory name> without <>.");
            return;
        }

        File target = new File(currentDirectory, name);

        if(!target.exists()){
            System.out.println(target + " does not exsist.");
        }

        if(target.isDirectory()) {
            System.out.println("Are you sure you want delete " + target + " and all of its content? y/n");
            String deleteConfirmation = scanner.nextLine();

            if(!deleteConfirmation.equals("y")) {
                System.out.println("Deletion of " + target + " was cancelled.");
            }

            if(deleteDirectoryRecursively(target)) {
                System.out.println(target + " and all of its content was deleted.");
            } else {
                System.out.println("Failed to delete " + target);
            }
        } else {
            if(target.delete()) {
                System.out.println("File " + target + "deleted.");
            } else {
                System.out.println("Failed to delete file " + target);
            }
        }
    }

    private boolean deleteDirectoryRecursively(File filesInput) {
        File[] files = filesInput.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (!deleteDirectoryRecursively(file)) {
                        return false;
                    }
                } else {
                    if (!file.delete()) {
                        return false;
                    }
                }
            }
        }
            return filesInput.delete();
    }
    
    /**
     * Rename a file or directory
     * 
     * @param oldName The current name of the file or directory
     * @param newName The new name for the file or directory
     */
    private void rename(String oldName, String newName) {
        // TODO: Implement renaming a file or directory

        if(
            (oldName == null || oldName.isBlank()) &&
            (newName == null || newName.isBlank())
        ) {
            System.out.println("Please use: rename <old name> <new name> without <>.");
        }

        File oldFile = new File(currentDirectory, oldName);
        File newFile = new File(currentDirectory, newName);

        if(!oldFile.exists()) {
            System.out.println(oldName + " does not exist.");
        }

        if(!newFile.exists()) {
            System.out.println(newFile + " does not exist."); 
        }

        if(oldFile.renameTo(newFile)) {
            System.out.println(oldName + " was renamed to " + newName);
        } else {
            System.out.println("Failed to rename " + oldName + " to " + newName);
        }
    }
    
    /**
     * Search for files matching a pattern
     * 
     * @param pattern The pattern to search for
     */
    private void findFiles(String pattern) {
        // TODO: Implement searching for files by name pattern
        // Use recursive method to search through directories
        if (pattern == null || pattern.isBlank()) {
            System.out.println("Please use: find <pattern> without <>.");
            return;
        }

        System.out.println("Searching for files: " + pattern);
        findFilesRecursive(currentDirectory, pattern);
        
    }

    private void findFilesRecursive(File currentDirectory, String pattern) {
        File[] files = currentDirectory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.getName().contains(pattern)) {
                System.out.println(getRelativePath(file));
            }

            if (file.isDirectory()) {
                findFilesRecursive(file, pattern);
            }
        }
    }

    private String getRelativePath(File file) {
        return currentDirectory.toPath().relativize(file.toPath()).toString();
    }
    
    /**
     * Display detailed information about a file
     * 
     * @param fileName The name of the file to display information for
     */
    private void displayFileInfo(String fileName) {
    // TODO: Implement displaying file information
    // Show file size, last modified date, whether it's a directory, etc.

        if (fileName == null || fileName.isBlank()) {
            System.out.println("Please use: info <file/directory name>");
            return;
        }

        File file = new File(currentDirectory, fileName);

        if (!file.exists()) {
            System.out.println(fileName + " does not exist.");
            return;
        }

        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Type: " + (file.isDirectory() ? "Directory" : "File"));
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Executable: " + file.canExecute());
        System.out.println("Last Modified: " + dateFormat.format(new Date(file.lastModified())));
    }
        
    /**
     * Main method
     */
    public static void main(String[] args) {
        FileSystemManager manager = new FileSystemManager();
        manager.start();
    }
}
