package application;

public class Name implements Comparable<Name> {
    private String name;
    private String frequency;
    private String gender;

    public Name(String name, String gndar, String frequency) {
        super();
        this.name = name;
        this.frequency = frequency;
        setGender(gndar);
    }

    public Name() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. The name should not be null or empty.");
        }
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        if (frequency != null && !frequency.isEmpty()) {
            this.frequency = frequency;
        } else {
            System.out.println("Invalid frequency. The frequency should not be null or empty.");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && !gender.isEmpty()) {
            char firstChar = gender.toUpperCase().charAt(0);
            if (firstChar == 'M' || firstChar == 'F') {
                this.gender = String.valueOf(firstChar);
            } else {
                System.out.println("Invalid gender. The gender should be 'F' or 'M'.");
            }
        } else {
            System.out.println("Invalid gender. The gender should not be null or empty.");
        }
    }

    @Override
    public int compareTo(Name o) {
        if ((this.name.compareToIgnoreCase(o.getName())==0 )&&( this.gender.compareToIgnoreCase(o.getGender())==0)) {
        	
        	return 0;
        }
        
        return -1 ;
    }

    @Override
    public String toString() {
        return name + ","  + gender + ","+frequency  ;
       
    }
}
