public enum FileSystemCommand {
    HELP, LS, CD, PWD, MKDIR, TOUCH, RM, RENAME, FIND, INFO, EXIT, UNKNOWN;

    public static FileSystemCommand fromString(String input) {
        try {
            return FileSystemCommand.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException iae) {
            return UNKNOWN;
        }
    }
}