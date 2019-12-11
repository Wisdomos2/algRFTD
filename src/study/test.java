package study;

public class test {
    public static void main(String[] args) {

        System.out.println((1 >>> 4));

        for(int i=1;i<(1<<4);i++) {
            System.out.println(i);
        }

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
