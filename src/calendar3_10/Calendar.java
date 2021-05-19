package calendar3_10;

import java.util.Scanner;

//월을 입력하면 해당월의 달력을 출력한다.
//달력 모양은 1단계에서 작성한 모양으로 만든다.
//1일은 일요일로 정해도 무방하다.
//-1을 입력받기 전까지 반복 입력받는다.
//프롬프트를 출력한다.
public class Calendar {
	static int[] MONTH_LAST_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) {
		System.out.println("월을 입력하세요.");
		System.out.print("> ");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		
			//int만 입력가능 
			while(!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("숫자만 입력해주세요.");
			}
			
			int month = scanner.nextInt();
		
			//-1 입력시 끝
			if(month == -1) {
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				break;
			}
			
			String days = "  일 월  화  수  목 금  토\n"
				    	+ "----------------------\n";
			
			//입력한 월의 일수만큼 loop 돌면서 저장
			for(int i=1; i<=getMonthMaxDay(month); i++) {
				
				//7 : 공백 2칸 + 줄바꿈
				if(i == 7) {
					days = days +"  "+ Integer.toString(i)+"\n";
					
				//7로 나눠서 나머지가 0 : 공백 1칸 + 줄바꿈
				}else if(i%7 == 0) {
					days = days +" "+ Integer.toString(i)+"\n";
					
				//10미만 : 공백 2칸
				}else if(i < 10) {
					days = days +"  "+ Integer.toString(i);
					
				//그 외 : 공백 1칸 
				}else {
					days = days +" "+ Integer.toString(i);
				}
			}
		
			System.out.print(days);
			
			//풀이 소스 
			//%3d 쓰니까 되게 간단하네 -ㅅ-)..
//			for(int i=1; i<=getMonthMaxDay(month); i++) {
//				System.out.printf("%3d", i);
//				
//				//7로 나눈 나머지 0
//				if(i%7 == 0) {
//					System.out.println();
//				}
//			}
		}
	}

	//입력한 월의 마지막 날짜를 리턴
	public static int  getMonthMaxDay(int m) {
		return MONTH_LAST_DAY[m-1];
	}
}
