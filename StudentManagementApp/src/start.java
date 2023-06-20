import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;

public class start {

	public static void main(String[] args) throws IOException{
		System.out.println("welcome to Student management app");
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to add student");
			System.out.println("Press 2 to delete student");
			System.out.println("Press 3 to display student");
			System.out.println("Press 4 to exit student");
			int c = Integer.parseInt(br.readLine());
			if (c==1){
				//add student
				System.out.println("Enter Student Name");
				String name = br.readLine();
				System.out.println("Enter Student city");
				String city = br.readLine();
				System.out.println("Enter Student Salary");
				int salary = br.read();
				
				Student st = new Student(name,city,salary);
				System.out.println(st);
				}
			else if (c==2) {
				//delete student
			}else if (c==3) {
				//display student
			}else if (c==4) {
				//exit
				break;
			}else {
				
			}
		}
		System.out.println("Thank you for using my application");
		System.out.println("See you soon....Bye bye");
	}

}
