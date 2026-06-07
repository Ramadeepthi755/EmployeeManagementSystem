package util;

public class EmailTest {

    public static void main(String[] args) {

        EmailUtil.sendEmail(
                "bramadeepthi1234@gmail.com",
                "Test Mail",
                "Hello from EMS");

        System.out.println("Method Called");
    }
}