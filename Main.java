class Patient {
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;
    private String bloodType;
    private String phoneNumber;

    public Patient(int id, String name, int birthYear, double height, double weight,
                   String bloodType, String phoneNumber) {

        this.id = id;
        this.name = name;

        if (birthYear > 0) {
            this.birthYear = birthYear;
        } else {
            System.out.println("อายุติดลบไม่ได้ครับน้องไปเกิดใหม่นะ");
            this.birthYear = 0;
        }

        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("ความสูงติดลบไม่ได้ครับน้องไปกินนมนะ");
            this.height = 0.0;
        }

        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("น้ำหนักติดลบไม่ได้ครับน้องไปกินข้าวนะ");
            this.weight = 0.0;
        }

        if (bloodType != null &&
                (bloodType.equals("A") || bloodType.equals("B") ||
                        bloodType.equals("AB") || bloodType.equals("O"))) {
            this.bloodType = bloodType;
        } else {
            System.out.println("ไม่มีข้อมูลกรุปเลือดนี้ในระบบ ABO");
            this.bloodType = "Unknown";
        }

        if (phoneNumber != null && phoneNumber.matches("\\d{9,10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("เบอร์โทรศัพท์ไม่ถูกต้องไปเปิดเบอร์ใหม่นะจะ");
            this.phoneNumber = "Unknown";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBMI() {
        if (height <= 0 || weight <= 0) {
            return 0.0;
        }
        double heightM = height / 100.0;
        return weight / (heightM * heightM);
    }

    public int getAge(int currentYear) {
        if (currentYear <= 0 || currentYear < birthYear || birthYear < 0) {
            System.out.println("*error ยังไม่เกิด อายุเท่ากับ 0 นะน้องนะ");
            return 0;
        }
        return currentYear - birthYear;
    }

    public void displayDetails(int currentYear) {
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Patient BMI: " + getBMI());
        System.out.println("--------------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        int currentYear = 2024;

        Patient patient = new Patient(
                1001, "John Doe", 1978, 175.5, 78.0,
                "AB", "0812345678"
        );
        patient.displayDetails(currentYear);

        Patient invalidPatient = new Patient(
                1002, "Joe Dohn", 2200, -160.0, -65.0,
                "A+", "12A45"
        );
        invalidPatient.displayDetails(currentYear);
    }
}
