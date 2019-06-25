package Z.References;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 	^	문자열 시작
  	$	문자열 종료
  	.	임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 	*	앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
  	+	앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
  	?	앞 문자가 없거나 하나 있을 수 있습니다.
  	[]	문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
  	{}	횟수 또는 범위를 나타냅니다.
  	()	괄호안의 문자를 하나의 문자로 인식합니다.
  	|	패턴을 OR 연산을 수행할 때 사용합니다.
  	\s	공백 문자
  	\S	공백 문자가 아닌 나머지 문자
  	\w	알파벳이나 문자
  	\W	알파벳이나 숫자를 제외한 문자
  	\d	[0-9] 숫자
  	\D	숫자를 제외한 모든 문자
  	(?i)	대소문자를 구분하지 않습니다.
  	UserName / 소문자. 숫자. _-포함 / 3글자 이상 16글자 이하 /^[a-z0-9_-]{3,16}$/
  	Password / 소문자. 숫자. _-포함 / 6글자 이상 18글자 이하 /^[a-z0-9_-]{6,18}$/
  	Email / 소문자. 숫자. _-포함 / @ / 소문자와 . 2글자 이상 6글자이하 /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
  	
  	
  	참고사이트 : http://highcode.tistory.com/6
*/
public class Example_RegularExpression {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int onlyNum = 0;
        String inputVal = null;
        
		/* 정규식패턴 입력 */
		Pattern p = Pattern.compile("(^[0-9]*$)");
		
		/* 사용될 문자열 입력 */
        inputVal = sc.nextLine();
        
        /* 입력된 문자열과 매칭 */
        Matcher m = p.matcher(inputVal);
        
        /* 일치여부 True/False로 리턴 */
        if(m.find())
        {
            onlyNum = Integer.parseInt(inputVal);
            System.out.println(onlyNum);
        }
        else
        {
            System.out.println("No Number");
        }    
	}
}
