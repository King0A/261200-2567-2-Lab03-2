public class Patient {
    private String name;
    private int age;
    private double height; // in meters
    private double weight; // in kilograms
    private String bloodGroup;
    private String phoneNumber;

    public Patient(String name, int age, double height, double weight, String bloodGroup, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method to calculate BMI
    public double getBMI() {
        if (height > 0 && weight > 0) {
            return weight / (height * height);
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Patient patient = new Patient("John Doe", 30, 1.75, 70, "O+", "123-456-7890");
        System.out.println("Patient's BMI: " + patient.getBMI());
    }
}