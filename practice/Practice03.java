package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
入力された加算／減算演算の結果を出力するプログラムを作成しなさい。

入力する数は、すべて整数とする。
演算記号は「+」(和) 「-」(差)を使用する。
演算の式は、最低1回の演算を行うものとし、複数回の演算を行う場合もある。（正しい:      23 + 58 + 7）
負の数も含む。負の数の場合は、数値の直前に空白を挟まずに「-」（マイナス）を付加して入力するものとし、数値の範囲は-10000～10000とする。
演算の途中経過における取りうる値の反は-10000～10000とする。
入力例

  23 + 58 + 7

出力例

  88
*/

public class Practice03 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力パラメータを読み込む
        String input = br.readLine();
        String[] param = input.split(" ");//入力値を空白で分解する
        //回答
        String type = null;
        int sum = 0;
        for (int idx=0; idx<param.length; idx++) {
	    	if (param[idx].equals("+") || param[idx].equals("-")) {
	    		type = param[idx];
	    	} else {
	    		int num = Integer.parseInt(param[idx]);
	    		if (type !=null) {
	    			if (type.equals("+")) {
	    				sum += num;
	    			} else if (type.equals("-")) {
	    				sum -= num;
	    			}
	    		} else {
	    			sum = num;
	    		}
	    	}
        }
        System.out.println(sum);
        
	}
}
