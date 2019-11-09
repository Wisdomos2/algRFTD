package Kakao2019;

public class num2 {
    public static void main(String[] args) {
        String input = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int arr[] = solution(input);

        for(int i : arr) {
            System.out.printf(i + " ");
        }

    }

    public static int[] solution(String s) {
        int[] answer = {};


        return answer;
    }
}

/*
    let result = []
        let k = []
        let answer = []
        let start = false
        let num = "";
        for (let i = 1; i < s.length - 1; i++) {
            if (s[i] === "{") {
             start = true
              }
             else if (s[i] === "}") {
                  start = false
         k.push(Number(num))
         num = ""
         result.push(k)
         k = []
        }
        else if (s[i] !== " " && s[i] !== "," && start === true) {
        num = num + s[i]
        }
        else if (s[i] === "," && start === true) {
         k.push(Number(num))
         num = ""
        }
        }
        result.sort((a, b) => {
        return a.length < b.length ? -1 : a.length > b.length ? 1 : 0;
        });
        for (let i = 0; i < result.length; i++) {
        result[i].map(item => {
        if (answer.indexOf(item) === -1) {
        answer.push(item)
        }
        })*/