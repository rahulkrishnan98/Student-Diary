import java.util.*;
import java.io.*;
public class Session {
	User sessionUser;
	
	Session(String user, String pass){
		this.init();
		for(ArrayList<User> arr: User.totalUsers){
			if(arr != null){
				for(User n: arr){
					if(n.username.equals(user) && n.password.equals(pass)){
						this.sessionUser = n;
						System.out.println("---------------------------------");
						System.out.println("");
						System.out.println("Hi " + n.name + "!");
						System.out.println(" ");
						return;
					}
				}
			}
		}
		System.out.println("Session Creation failed, Invalid Login!");
		System.exit(0);
	}
	
	public static void main(String[] args){
		System.out.println("----------Amrita Student Diary---------");
		Scanner input = new Scanner(System.in);
		System.out.println("Username: ");
		String username = input.nextLine();
		System.out.println("Password: ");
		String password = input.nextLine();
//		Administrator admin = new Administrator("Gopal","gkrishnan724","root");
//		Counsellor s = new Counsellor("Gopal2","gk","root");
		Session currentSession = new Session(username,password);
		
		currentSession.sessionUser.displayMenu();
	}
	
	public static void init(){
		User.totalUsers.add(Student.get());
		User.totalUsers.add(Counsellor.get());
		User.totalUsers.add(Administrator.get());
		Branch.get();
		Subject.get();
	}
	
	
}

