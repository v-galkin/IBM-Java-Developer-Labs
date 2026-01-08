enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

enum Status {
    NEW("New"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getValue() {
        return this.label;
    }
}


public class Task {
    private String name;
    private String description;
    private Priority priority = Priority.LOW;
    private Status status = Status.NEW; 

    public Task(String taskName, String description, Priority priority) {
        this.name = taskName;
        this.description = description;
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        String message = 
                        "Task Name: " + this.name + "\n" +
                        "Task Description: " + this.description + "\n" +
                        "Task Priority: " + this.priority + "\n" +
                        "Task Status: " + this.status + "\n";

        return message;
    }
}