package application;

import java.util.Objects;

public class Martyr implements Comparable<Martyr> {

	private String Name;
	private String Age;
	private String Location;
	private String Date;
	private String District;
	private String Gender;

	public Martyr(String name, String age, String eventLocation, String dateOfDeath, String gender, String district) {
		super();
		setName(name);
		setAge(age);
		setLocation(eventLocation);
		setDate(dateOfDeath);
		setGender(gender);
		setDistrict(district);
	}

	public Martyr() {
		super();

	}

	public String getName() {

		return Name;
	}

	public void setName(String name) {
		if (name.isEmpty()) {
			System.out.println("is empty name ");
			
		} else {
			Name = name;
		}
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		try {
			int ag = Integer.parseInt(age);
			if (age.isEmpty() || (ag > 130 || ag < 0)) {
				System.out.println("is empty age or invild age ");
				Age = "0";
			} else {
				Age = age;
			}
		} catch (Exception e) {

		}
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		if (gender.isEmpty()) {
			System.out.println("Invalid gender: " + gender);
		} else {
			Gender = gender;
		}
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		if (location.isEmpty()) {
			System.out.println("is empty Location ");
			
		} else {
			Location = location;
		}
	
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		if (date.isEmpty()) {
			System.out.println("is empty Date ");
			
		} else {
			Date = date;
		}
		
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		if (district.isEmpty()) {
			System.out.println("is empty District ");
			
		} else {
			District = district;
		}
		
		
	}

	 @Override
	    public int hashCode() {
	        return Objects.hash(Name, Date);
	    }
	

	@Override
	public String toString() {
		return Name + "," + Age + "," + Location + "," + District + "," + Date + "," + Gender;
	}

	@Override
	public int compareTo(Martyr o) {
		try {

			int Aqe1 = Integer.parseInt(this.Age);
			int Aqe2 = Integer.parseInt(o.Age);
			if (Aqe1 > Aqe2) {
				return 1;
			} else if (Aqe1 < Aqe2) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	

	

}
