import java.util.*;

class Patient {

private String name, gender, city, address, guardianname, guardianaddress, status;
	private int age, patientid;
	private long phonenumber, guardiansphonenumber, aadharnumber;

public String getName() {
		return name;
	}

public void setName(String name) {
		this.name = name;
	}

public String getGender() {
		return gender;
	}

public void setGender(String gender) {
		this.gender = gender;
	}

public String getCity() {
		return city;
	}

public void setCity(String city) {
		this.city = city;
	}

public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGuardianname() {
		return guardianname;
		}

public void setGuardianname(String guardianname) {
		this.guardianname = guardianname;
	}
	public String getGuardianaddress() {
		return guardianaddress;
	}
	public void setGuardianaddress(String guardianaddress) {
		this.guardianaddress = guardianaddress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public long getPhonenumber() {
	return phonenumber;
	}

public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getGuardiansphonenumber() {
		return guardiansphonenumber;
	}
	public void setGuardiansphonenumber(long guardiansphonenumber) {
		this.guardiansphonenumber = guardiansphonenumber;
	}
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

class ArogyaHospitals {
	ArrayList<Patient> al = new ArrayList<Patient>();
	int count = 200;

	public void addPatient(Scanner s, int p) {

		for (int i = 1; i <= p; i++) {
			count++;
			Patient p1 = new Patient();
			System.out.println("Patient Id is automatically generated");
			p1.setPatientid(count);

			System.out.println("Enter his/her Name: ");
			p1.setName(s.next());

			do {
				System.out.println("Enter Patient Age: ");
				int a = s.nextInt();
				if (a >= 1 && a <= 99) {
					p1.setAge(a);
					break;
				} else {
					System.out.println("Enter the age between 1 & 99 ");
				}
			} while (true);

			System.out.println("Enter gender of the patient: ");
			p1.setGender(s.next());

			String input;
			boolean valid = false;
			int count = 0;

			do {
				if (count == 0) {
					s.nextLine();
				}
				System.out.println("Enter the Contact Number:");
				input = s.nextLine();

				if (input.length() == 10 && (input.charAt(0) == '6' || input.charAt(0) == '7' || input.charAt(0) =='8'|| input.charAt(0) == '9')) {
					boolean allDigits = true;
					for (int j = 0; j < input.length(); j++) {
						if (!Character.isDigit(input.charAt(j))) {
							allDigits = false;
							break;
						}
					}
					if (allDigits) {
						valid = true;
					} else {
						count++;
						System.out.println("Invalid input. Please enter a valid 10-digit phone number.");
					}
				} else {
					count++;
					System.out.println("Please enter a valid 10-digit phone number starting with 6, 7, 8, or 9.");
				}
			} while (!valid);

			p1.setPhonenumber(Long.parseLong(input));
			System.out.println("Enter the City name: ");
			p1.setCity(s.next());
			System.out.println("Enter the Address: ");
			p1.setAddress(s.next());
			System.out.println("Enter the guardians name: ");
			p1.setGuardianname(s.next());
			System.out.println("Enter the guardians address: ");
			p1.setGuardianaddress(s.next());
			String input2;
			boolean valid2 = false;
			int count1 = 0;

			do {
				if (count1 == 0) {
					s.nextLine();
				}

				System.out.println("Enter the gurdian's Contact Number:");
				input2 = s.nextLine();

				if (input2.length() == 10 && (input2.charAt(0) == '6' || input2.charAt(0) == '7'
						|| input2.charAt(0) == '8' || input2.charAt(0) == '9')) {
					boolean allDigits = true;
					for (int l = 0; l < input.length(); l++) {
						if (!Character.isDigit(input2.charAt(l))) {
							allDigits = false;
							break;
						}
					}
					if (allDigits) {
						valid2 = true;
					} else {
						count1++;
						System.out.println("Invalid input. Please enter a valid 10-digit phone number.");
					}
				} else {
					count1++;
					System.out.println("Please enter a valid 10-digit phone number starting with 6, 7, 8, or 9.");
				}
			} while (!valid2);
			p1.setGuardiansphonenumber(Long.parseLong(input2));
			String input1;
			boolean valid1 = false;

			do {
				System.out.println("Enter the Patient Aadhar Number:");
				input1 = s.nextLine();

				if (input1.length() == 12) {
					boolean allDigits = true;
					for (int k = 0; k < input1.length(); k++) {
						if (!Character.isDigit(input1.charAt(k))) {
							allDigits = false;
							break;
						}
					}
					if (allDigits) {
						valid1 = true;
					} else {
						System.out.println("Invalid input. Please enter a valid 12-digit Aadhar number.");
					}
				} else {
					System.out.println(" Please enter a valid 12-digit Aadhar number ");
				}
			} while (!valid1);
			p1.setAadharnumber(Long.parseLong(input1));
			p1.setStatus("Not recovered");
			al.add(p1);

		}

	}

	public void searchById(Scanner s, int id) {
		int count = 0;
		for (int i = 0; i < al.size(); i++) {
			if (id == al.get(i).getPatientid()) {
				getIn(i);
				count++;

			}
		}
		if (count == 0) {
			System.out.println("Patient details not found.");
		}
	}

	public void searchByCity(Scanner s, String s1) {
		int count2 = 0;
		try {
			if (al.size() <= 0) {
				System.out.println("Patient list is Empty.");
				return;
			}

			for (int i = 0; i < al.size(); i++) {

				if (al.get(i) == null) {
					System.out.println("Patient at index " + i + " is null.");
					continue;
				}

				if (s1.equalsIgnoreCase(al.get(i).getCity())) {
					getIn(i);
					count2++;
				}

			}
			if (count2 == 0) {
				System.out.println("Entered City name is incorrect");
			}
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}

	public void display(Patient p) {
		System.out.println("Patient Name :" + p.getName());
		System.out.println("Patient ID :" + p.getPatientid());
		System.out.println("Patient Age :" + p.getAge());
		System.out.println("Patient Gender :" + p.getGender());
		System.out.println("Patient PhoneNumber :" + p.getPhonenumber());
		System.out.println("Patient City :" + p.getCity());
		System.out.println("Patient Address :" + p.getAddress());
		System.out.println("Patient Guardian Name :" + p.getGuardianname());
		System.out.println("Patient Guardian Address :" + p.getGuardianaddress());
		System.out.println("Patient Guardian PhoneNumber :" + p.getGuardiansphonenumber());
		System.out.println("Patient AadharNumber :" + p.getAadharnumber());
		System.out.println("Patient Status :" + p.getStatus());

	}

	public void searchByAge(Scanner s, int a1, int a2) {
		int count3 = 0;
		try {

			for (int i = 0; i < al.size(); i++) {
				if (al.get(i).getAge() >= a1 && al.get(i).getAge() <= a2) {
					Patient p = al.get(i);
					display(p);
					count3++;
				}
			}
			if (count3 == 0) {
				System.out.println("Patient details not found in between these ages ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removeById(Scanner s, int id1) {
		int index = -1;
		for (int i = 0; i < al.size(); i++) {
			if (id1 == al.get(i).getPatientid()) {
				index = i;
				break;
			}
		}

		if (index != -1) {
			al.remove(index);
			System.out.println("Patient details have been removed.");
		} else {
			System.out.println("Invalid ID. No patient found with the given ID.");
		}
	}

	public void getIn(int j) {

		for (int i = j; i < al.size(); i++) {
			System.out.println("Patient Name :" + al.get(i).getName());
			System.out.println("Patient ID :" + al.get(i).getPatientid());
			System.out.println("Patient Age :" + al.get(i).getAge());
			System.out.println("Patient Gender :" + al.get(i).getGender());
			System.out.println("Patient PhoneNumber :" + al.get(i).getPhonenumber());
			System.out.println("Patient City :" + al.get(i).getCity());
			System.out.println("Patient Address :" + al.get(i).getAddress());
			System.out.println("Patient Guardian Name :" + al.get(i).getGuardianname());
			System.out.println("Patient Guardian Address :" + al.get(i).getGuardianaddress());
			System.out.println("Patient Guardian PhoneNumber :" + al.get(i).getGuardiansphonenumber());
			System.out.println("Patient AadharNumber :" + al.get(i).getAadharnumber());
			System.out.println("Patient Status :" + al.get(i).getStatus());
			break;

		}
	}

	public void getAll() {
		for (int i = 0; i < al.size(); i++) {
			System.out.println("Patient Name :" + al.get(i).getName());
			System.out.println("Patient ID :" + al.get(i).getPatientid());
			System.out.println("Patient Age :" + al.get(i).getAge());
			System.out.println("Patient Gender :" + al.get(i).getGender());
			System.out.println("Patient PhoneNumber :" + al.get(i).getPhonenumber());
			System.out.println("Patient City :" + al.get(i).getCity());
			System.out.println("Patient Address :" + al.get(i).getAddress());
			System.out.println("Patient Guardian Name :" + al.get(i).getGuardianname());
			System.out.println("Patient Guardian Address :" + al.get(i).getGuardianaddress());
			System.out.println("Patient Guardian PhoneNumber :" + al.get(i).getGuardiansphonenumber());
			System.out.println("Patient AadharNumber :" + al.get(i).getAadharnumber());
			System.out.println("Patient Status :" + al.get(i).getStatus());

		}
	}

	public void markRecovery(int id2, Scanner s) {
		for (int i = 0; i < al.size(); i++) {
			if (id2 == al.get(i).getPatientid()) {
				System.out.println("Patient Name :" + al.get(i).getName() + " is recovered.");
				al.get(i).setStatus("Recovered");
			}

		}
	}

	public void viewOptions(Scanner s) {
		while (true) {
			System.out.println();
			System.out.println("========Welcome to AROGYA HOSPITALS========");
			System.out.println("1. Add Patient Details");
			System.out.println("2. Search by using PatientID");
			System.out.println("3. Search by using City Name");
			System.out.println("4. Search by using Patient Age");
			System.out.println("5. Remove by using PatientID");
			System.out.println("6. Display all the patient details");
			System.out.println("7. Mark Patient as recovered based on ID");
			System.out.println("0. EXIT");
			System.out.println("Choose your option");
			int option = s.nextInt();
			System.out.println();

			switch (option) {
			case 1: {
				System.out.println("Enter How many patient details you want to store: ");
				int p = s.nextInt();
				addPatient(s, p);

				break;
			}
			case 2: {
				System.out.println("Enter the Patient ID: ");
				int id = s.nextInt();
				searchById(s, id);
				break;

			}
			case 3: {
				System.out.println("Enter the Patient city name: ");
				String s1 = s.next();
				searchByCity(s, s1);
				break;
			}
			case 4: {
				System.out.println("Enter the Age of patient:");
				int a1 = s.nextInt();
				System.out.println("Enter the another age of patient:");
				int a2 = s.nextInt();
				searchByAge(s, a1, a2);
				break;
			}
			case 5: {
				System.out.println("Enter the PatientID: ");
				int id1 = s.nextInt();
				removeById(s, id1);
				break;
			}
			case 6: {
				System.out.println("Displaying all the Patient Details ");
				getAll();
				break;
			}
			case 7: {
				System.out.println("Enter the patient ID:");
				int id2 = s.nextInt();
				markRecovery(id2, s);
				break;
			}
			case 0: {
				System.out.println("******************************************");
				System.out.println("Thanks for Visiting Arogya Hospitals portal");
				System.out.println();
				System.out.println("            WELLCOME       ");
				System.out.println("******************************************");
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Invalid Input");
			}
				System.out.println("*********************************");
			}
		}
	}
}

public class Arogya {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArogyaHospitals ah = new ArogyaHospitals();
		ah.viewOptions(s);

	}

}
