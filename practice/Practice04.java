package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 入力された加算／減算演算の結果を出力するプログラムを作成しなさい。

入力する数は、すべて整数とする。
演算記号は「+」(和) 「-」(差)を使用する。
演算の式は、最低1回の演算を行うものとし、複数回の演算を行う場合もある。
四則演算の記法に乗っ取り、先に行うべき演算は「（」および「）」でくくるものとし、入れ子構造も可とする。【正しい:  23 + 58 + 7 – ( 10 + 3 ) – ( 3 – ( 5 + 4  – ( 8 – 2 ) ) )】
負の数も含む。負の数の場合は、数値の直前に空白を挟まずに「-」（マイナス）を付加して入力するものとし、数値の範囲は-10000～10000とする。
演算の途中経過における取りうる値の反は-10000～10000とする。
入力例

  23 + 58 + 7 - ( 10 + 3 ) - ( 3 - 2 - ( 5 + 4 - ( 8 - 2 ) + 8 ) )

出力例

  85
 */

public class Practice04 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 入力パラメータを読み込む
        String input = br.readLine();
        String[] param = input.split(" ");//入力値を空白で分解する
        //回答
        int sum = calc(param,0,param.length - 1);
        System.out.println(sum);
	}
	public static int calc(String[] param, int startIdx, int endIdx) {
		int sum = 0 ;
		String type = null;
		for (int idx = startIdx ; idx < endIdx+1; idx++) {
			if(param[idx].equals("+") || param[idx].equals("-")) {
				type = param[idx];
			} else if (param[idx].equals("(")) {
				int endOfFormula = checkEndOfFormula(param,idx);
				if (type != null){
					if(type.equals("+")) {
						sum += calc(param, idx+1, endOfFormula-1);
					} else if (type.equals("-")) {
						sum -= calc(param, idx+1, endOfFormula-1);
					}
				} else {
					sum = calc(param, idx+1, endOfFormula-1);
				}
				idx = endOfFormula ;
			} else {
				int num = Integer.parseInt(param[idx]);
				if(type != null){
                    if(type.equals("+")){
                        sum = sum + num;
                    }else if(type.equals("-")){
                        sum = sum - num;
                    }
                }else{
                    sum = num ;
                }
			}
		}
		return sum;
	}
	
	public static int checkEndOfFormula(String[] param, int startIdx) {
		int end = startIdx + 1 ;
		int startCount = 0;
		for (int idx= startIdx + 1; idx < param.length; idx ++) {
			end = idx ;
			if(param[idx].equals("(")) {
				startCount ++;
			}else if(param[idx].equals(")")) {
				if(startCount == 0) {
					break ;
				} else {
					startCount-- ;
				}
			}
		}
		return end;
	}
} 
