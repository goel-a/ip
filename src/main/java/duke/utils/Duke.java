package duke.utils;

/**
 * Represents an instance of the task
 * manager
 */
public class Duke {

    /**
     * Instance of TaskList to store and
     * manage list of tasks.
     */
    private TaskList tl;


    private Command cd;


    /**
     * Constructor Method for Duke
     */
    public Duke() {
        tl = new TaskList(Storage.getSavedList());
        cd = new Command();
    }


    /**
     * Returns duke's response to the provided
     * input.
     *
     * @param input the input from the user
     * @return String response to be displayed
     */
    public String getResponse(String input) {
        try {
            return Parser.parse(input, this.tl, this.cd);
        } catch (DukeException e) {
            return Ui.showError(e);
        }
    }

    public void saveListToDisk() {
        this.tl.saveListToStorage();
    }

}
