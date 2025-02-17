public class ShortWordFilter implements Filter {

    private int maxChar; //Made the char length filter a parameter instead of a hard-coded value; will be 5 for this lab

    public ShortWordFilter(int maxChar) {
        this.maxChar = maxChar;
    }

    public ShortWordFilter() {
        this.maxChar = 4; //Default value will filter all strings of 4 or less characters (i.e, less than 5)
    }

    public int getMaxChar() {
        return maxChar;
    }

    public void setMaxChar(int maxChar) {
        this.maxChar = maxChar;
    }

    @Override
    public boolean accept(Object x) {
        String input = (String) x;
        return input.length() <= this.maxChar;
    }

    @Override
    public String toString() {
        return "ShortWordFilter{" +
                "maxChar=" + maxChar +
                '}';
    }
}
