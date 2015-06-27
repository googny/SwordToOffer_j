package datastructure.string;

public class ReplaceBlankTest {
    ReplaceBlank replaceBlank;

    @org.junit.Before
    public void setUp() throws Exception {
        replaceBlank = new ReplaceBlank();
    }

    @org.junit.Test
    public void testReplaceBlank() throws Exception {
        char[] chars = new char[100];
        String string = "    ";
        System.arraycopy(string.toCharArray(), 0, chars, 0, string.length());
        replaceBlank.replaceBlank(chars, string.length());


        string = "We are Happy!";
        System.arraycopy(string.toCharArray(), 0, chars, 0, string.length());
        replaceBlank.replaceBlank(chars, string.length());


        string = "Make  Love  Make  Me  Happy!  ";
        System.arraycopy(string.toCharArray(), 0, chars, 0, string.length());
        replaceBlank.replaceBlank(chars, string.length());

        return;
    }
}