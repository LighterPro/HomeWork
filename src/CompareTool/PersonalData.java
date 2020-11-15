package CompareTool;

public class PersonalData {
    private String firstName;
    private String secondName;
    private String patronymicName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", firstName, secondName, patronymicName);
    }
}