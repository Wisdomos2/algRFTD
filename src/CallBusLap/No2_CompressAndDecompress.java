package CallBusLap;

public class No2_CompressAndDecompress {
    /*
        문자열 압축 문제
     */
    public static void main(String[] args) {

        String originString = "ZZZAAAAAAAAAABBCCQAA";
        String compressedString = compress(originString);
        String decompressedString = decompress(compressedString);
        System.out.println("--------------------------------------------------");
        System.out.println("입력문자 : " + originString);
        System.out.println("문자열 압축결과 : " + compress(originString));
        System.out.println("문자열 압축해제 결과 : "+ decompressedString);

        System.out.println("--------------------------------------------------");
        System.out.println("***TEST CASE***");
        test();
        return;
    }

    private static String compress(String any) {
        String resultString = "";
        String anyArr[] = any.split("");

        int sameLetterCount = 1;

        String tempLetter = null;

        for(int i=0;i<anyArr.length;i++) {
            if(tempLetter == null && i == 0) {
                tempLetter = anyArr[i];
                continue;
            }

            if(anyArr[i].equals(tempLetter)) {
                sameLetterCount++;
                if(i == anyArr.length-1) {
                    resultString = resultString + sameLetterCount + tempLetter;
                }
            }
            else if(!anyArr[i].equals(tempLetter)) {
                resultString = resultString + sameLetterCount + tempLetter;
                tempLetter = anyArr[i];
                sameLetterCount = 1;
                if(i == anyArr.length-1) {
                    resultString = resultString + sameLetterCount + tempLetter;
                }
            }
        }

        return resultString;
    }

    private static String decompress(String compressed) {
        String resultString = "";
        String compressedArr[] = compressed.split("");


        String tempLetterNum = null;
        for(int i=0;i<compressedArr.length;i++) {
            if(tempLetterNum == null && i == 0) {
                tempLetterNum = compressedArr[i];
                continue;
            }
            if(Character.isDigit(compressed.charAt(i))) {
                tempLetterNum = tempLetterNum + compressedArr[i];
            }
            if(Character.isLetter(compressed.charAt(i))) {
                int castTempLetterNum = Integer.parseInt(tempLetterNum);
                for(int k=0;k<castTempLetterNum;k++) {
                    resultString = resultString + compressedArr[i];
                }
                tempLetterNum = "";
            }
        }


        return resultString;
    }

    private static void test() {
        System.out.println("--------------------------------------------------");
        String originString1 = "AABBCC";
        String compressedString1 = compress(originString1);
        String decompressedString1 = decompress(compressedString1);
        System.out.println("입력문자 : " + originString1);
        System.out.println("문자열 압축결과 : " + compressedString1);
        System.out.println("문자열 압축해제 결과 : " + decompressedString1);
        System.out.println("입력문자와 문자열 압축해제 후 같은지 확인 : " + sameOriginAndDecompressed(originString1,decompressedString1));
        System.out.println("--------------------------------------------------");
        String originString2 = "GHGHGHGHGHGHGHGHGHHGG";
        String compressedString2 = compress(originString2);
        String decompressedString2 = decompress(compressedString2);
        System.out.println("입력문자 : " + originString2);
        System.out.println("문자열 압축결과 : " + compressedString2);
        System.out.println("문자열 압축해제 결과 : " + decompressedString2);
        System.out.println("입력문자와 문자열 압축해제 후 같은지 확인 : " + sameOriginAndDecompressed(originString2,decompressedString2));
        System.out.println("--------------------------------------------------");
    }

    private static boolean sameOriginAndDecompressed(String originString, String decompressedString) {
        if(originString.equals(decompressedString)) {
            return true;
        }
        else {
            return false;
        }
    }
}
