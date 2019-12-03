package study;

public class test {
    public static void main(String[] args) {
        System.out.println(testfucn(0));
    }

    public static int testfucn(int i) {
        if(i==10) {
            return -1;
        }
        else {
            i += 2;
            testfucn(i);
        }
        return i;
    }
}
