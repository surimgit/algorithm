package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class prob2 {

	public static void main(String[] args) throws FileNotFoundException {
		 String fileName = "d:\\address.txt";
		 Scanner scanner = new Scanner(new File(fileName));
		 StringBuilder stringBuilder = new StringBuilder();
		 ArrayList<Infor> inforList = new ArrayList<>();
		 while(scanner.hasNextLine()) {
			 stringBuilder.append((scanner.nextLine())).append("\n");
		 }
		 String[] answer = stringBuilder.toString().split("\n");
		 for(int i = 0; i < answer.length; i++) {
			 String[] temp = answer[i].split("\\|");
			 Infor infor = new Infor(temp[0].trim(), temp[1].trim(), temp[2].trim(),
					 temp[3].trim(),temp[4].trim(), temp[5].trim());
			 inforList.add(infor);
		 }
		
		 ArrayList<Infor> sortedList = sort(inforList, Comparator.comparing(infor -> infor.getAddress().replaceAll("[\\s-0-9]", "")));
		 int i = 0;
		 while(i < sortedList.size()) {
			 System.out.println(sortedList.get(i).getName()); 
			 System.out.println("	Company: " + sortedList.get(i).getCompany());
			 System.out.println("	Address: " + sortedList.get(i).getAddress());
			 System.out.println("	Zipcode: " + sortedList.get(i).getZipcode());
			 System.out.println("	Phones: " + sortedList.get(i).getPhones());
			 System.out.println("	Email: " + sortedList.get(i).getEmail());
			 i++;
		 }
	}

	
	public static ArrayList<Infor> sort(ArrayList<Infor> inforList, Comparator<Infor> comparator) {
		ArrayList<Infor> sortedlist = new ArrayList<>(inforList);
		sortedlist.sort(comparator);
		return sortedlist;
	}

	
}

	
	class Infor{
		private String Name;
		private String Company;
		private String Address;
		private String Zipcode;
		private String Phones;
		private String Email;
		
		public Infor(String Name, String Company, String Address, String Zipcode, String Phones, String Email) {
			this.Name = Name;
			this.Company = Company;
			this.Address = Address;
			this.Zipcode = Zipcode;
			this.Phones = Phones;
			this.Email = Email;
		    }
		
		public String getName() {
			return Name;
		}
		
		public String getCompany() {
			return Company;
		}
		
		public String getAddress() {
			return Address;
		}
		
		public String getZipcode() {
			return Zipcode;
		}

		public String getPhones() {
			return Phones;
		}

		public String getEmail() {
			return Email;
		}
		
	
	}