public class ObjInputTest {
    public static void main(String[] args) {

        SafeInputObj in = new SafeInputObj();

        in.getNonZeroLenString("Enter a non-zero length string");

        in.getInt("Enter an integer");

        in.getDouble("Enter a double");

        in.getRangedInt("Enter a number between 1 and 10", 1, 10);

        in.getRangedDouble("Enter a double between 1.0 and 10.0", 1.0, 10.0);

        System.out.println(in.getYNConfirm("Do you want to continue?[Y/N]"));

        in.getRegExString("Enter a 6 digit long number" , "^\\d{6}$");

    }
}
