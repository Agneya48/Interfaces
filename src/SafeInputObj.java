import java.util.Scanner;

public class SafeInputObj {


    private Scanner pipe = new Scanner(System.in);



    public SafeInputObj() {}

    public SafeInputObj(Scanner pipe) {
        this.pipe = pipe;
    }


    /**
     * Get a String which contains at least one character
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public String getNonZeroLenString(String prompt) {

        String retString = ""; // Loop runs until String isn't blank
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;

    }

    /**
     * Get an int value with no constraints
     * @param prompt - input prompt msg should not include range info
     * @return - unconstrained int value
     */
    public int getInt(String prompt) {

        boolean okInput = false;
        int retInt = 0;
        String buffer = ""; /*decided to just parse int from a string, to avoid blank input like just pressing or
        the spacebar leading to weird behavior.*/
        do {
            System.out.print("\n" + prompt + ": ");
            buffer = pipe.nextLine();

            try {
                retInt = Integer.parseInt(buffer);
                okInput = true;
            } catch (NumberFormatException error) {
                System.out.print("Invalid int parsing " + error.getMessage());
                okInput = false;
            }

        } while(!okInput); //should only exit when an int is input

        return retInt;
    }


    /**
     * Get an unconstrained double value
     * @param prompt - input prompt msg should not contain range info
     * @return  - an unconstrained double value
     */
    public double getDouble(String prompt) {
        boolean okInput = false;
        double retDouble = 0.0;
        String buffer = ""; //Again, just decided using wrappers to parse is less headache.

        do {
            System.out.print(prompt + ": ");
            buffer = pipe.nextLine();

            try {
                retDouble = Double.parseDouble(buffer);
                okInput = true;
            } catch (NumberFormatException error) {
                System.out.println("Invalid");
                okInput = false;
            }

        } while(!okInput); //should only exit when an int is input

        return retDouble;
    }


    /**
     * Get an int value within a specified numeric range
     * @param prompt - input prompt msg should not include range info
     * @param low - low end of inclusive range
     * @param high - high end of inclusive range
     * @return - int value within the inclusive range
     */
    public int getRangedInt(String prompt, int low, int high) {
        boolean okInput = false;
        int inputInt = 0;
        int retRangedInt = 0;
        String buffer = "";

        do{
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            buffer = pipe.nextLine();
            try {
                inputInt = Integer.parseInt(buffer);
                if (inputInt >= low && inputInt <= high) {
                    retRangedInt = inputInt;
                    okInput = true;
                }
                else {
                    System.out.print("Outside valid range \n");
                }
            } catch (NumberFormatException error) {
                System.out.print("Invalid input\n");
            }
        } while(!okInput);

        return retRangedInt;
    }


    /**
     * get a double value within an inclusive range
     * @param prompt - input prompt msg should not contain range info
     * @param low - low value inclusive
     * @param high - high value inclusive
     * @return  - double value within the specified inclusive range
     */
    public double getRangedDouble(String prompt, double low, double high) {
        boolean okInput = false;
        double inputDouble = 0.0;
        double retRangedDouble = 0.0;
        String buffer = "";

        do{
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            buffer = pipe.nextLine();
            try {
                inputDouble = Double.parseDouble(buffer);
                if (inputDouble >= low && inputDouble <= high) {
                    retRangedDouble = inputDouble;
                    okInput = true;
                }
                else {
                    System.out.print("Input double outside valid range.");
                }
            } catch (NumberFormatException error) {
                System.out.print("Invalid double parsing " + error.getMessage());
            }
        } while(!okInput);

        return retRangedDouble;
    }


    /**
     * Get a [Y/N] confirmation from the user
     * @param prompt -input prompt msg for user
     * @return - true for yes false for no
     */
    public boolean getYNConfirm(String prompt) {
        boolean retYN = false;
        boolean done = false;
        String continueInput = "";
        do {
            System.out.print(prompt +": ");
            continueInput = pipe.nextLine();
            if(continueInput.equalsIgnoreCase("Y") || continueInput.equalsIgnoreCase("yes")) {
                retYN = true;
                done = true;
            }
            else if (continueInput.equalsIgnoreCase("N") || continueInput.equalsIgnoreCase("no")) {
                retYN = false;
                done = true;
            }
            else {
                System.out.print("Invalid. Please pick either y/yes or n/no");
            }
        } while(!done);

        return retYN;
    }


    /**
     * Prompts user for a String that matches a given regex pattern
     * @param prompt - prompt for user
     * @param regEx - java style RegEx pattern to constrain the input
     * @return a String that matches the RegEx pattern supplied
     */
    public String getRegExString (String prompt, String regEx) {
        //show the prompt
        //input the data
        //test to see if the value matches valid regex format
        boolean okRegInput = false;
        String value = "";
        do {
            System.out.print(prompt + ": ");
            value = pipe.nextLine();
            if(value.matches(regEx)) {
                okRegInput = true;
            }
            else {
                System.out.println("Invalid");
            }

        }while(!okRegInput);
        return value;
    }
}
