package exercicio02;

public class Participant {
    private int idParticipant;
    private String RG;
    private String name;
    private String surname;
    private int age;
    private String celNumber;
    private String emergencyNumber;
    private String bloodGroup;
    private Categories circuit;
    private double valueToPay;

    // constructor
    public Participant(int idParticipant, String RG, String name, String surname, int age, String celNumber, String emergencyNumber, String bloodGroup) {
        this.idParticipant = idParticipant;
        this.RG = RG;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.celNumber = celNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    public Participant() {
    }

    public Participant(int age) {
        this.age = age;
    }

    // getters and setters

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCelNumber() {
        return celNumber;
    }

    public void setCelNumber(String celNumber) {
        this.celNumber = celNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Categories getCircuit() {
        return circuit;
    }

    public void setCircuit(Categories circuit) {
        this.circuit = circuit;
        this.valueToPay = this.calculate();
    }

    public double getValueToPay() {
        return valueToPay;
    }

    //methods

    public double calculate() {
        switch (circuit.getIdCategory()) {
            case 1:
                if (age < 18) {
                    valueToPay = 1300;
                }
                if (age > 18) {
                    valueToPay = 1500;
                }
                break;
            case 2:
                if (age < 18) {
                    valueToPay = 2000;
                }
                if (age > 18) {
                    valueToPay = 2300;
                }
                break;
            case 3:
                if (age < 18) {
                    notMajority();
                }
                if (age > 18) {
                    valueToPay = 2800;
                }
                break;
            default:
                System.out.println("error");
        }

        return valueToPay;
    }

    public void notMajority() {

        System.out.println("participant cannot to participate.");
    }

    @Override
    public String toString() {
        return "ID: " + getIdParticipant() + " - name: " + getName() + " - " + circuit + " ----- Value to pay: " + getValueToPay() + "";
    }
}
