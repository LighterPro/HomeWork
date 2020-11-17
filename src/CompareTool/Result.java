package CompareTool;

class Result {
    private PersonalData objectOne = null;
    private PersonalData objectTwo = null;
    private TwoStringComparator firstNamesComparator = null;
    private TwoStringComparator secondNamesComparator = null;
    private TwoStringComparator patronymicNamesComparator = null;

    private boolean isValid = false;
    private int errCnt = 0;

    public Result(PersonalData objectOne, PersonalData objectTwo) {
        this.objectOne = objectOne;
        this.objectTwo = objectTwo;
        this.firstNamesComparator = new TwoStringComparator(objectOne.getFirstName(), objectTwo.getFirstName());
        this.secondNamesComparator = new TwoStringComparator(objectOne.getSecondName(), objectTwo.getSecondName());
        this.patronymicNamesComparator = new TwoStringComparator(objectOne.getPatronymicName(), objectTwo.getPatronymicName());
        isValid = firstNamesComparator.isValid() & secondNamesComparator.isValid() & patronymicNamesComparator.isValid();
        errCnt = firstNamesComparator.getErrCnt() + secondNamesComparator.getErrCnt() + patronymicNamesComparator.getErrCnt();
    }

    private static String printBorder() {
        StringBuilder border = new StringBuilder();
        for (int i = 0; i < 150; i++) {
            border.append("-");
        }
        return border.toString();
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                        "|%-20s|%-52s|%-52s|%-10s|%-10s|%n" +
                        "%s%n" +
                        "|%-20s|%-52s|%-52s|%-10s|%-10s|%n" +
                        "|%-20s|%-52s|%-52s|%-10s|%-10s|%n" +
                        "|%-20s|%-52s|%-52s|%-10s|%-10s|%n" +
                        "%s%n" +
                        "OBJECT 1: %s%n" +
                        "OBJECT 2: %s%n" +
                        "Result: isValid = %b; errCnt = %d ",
                printBorder(),
                "", "OBJECT 1", "OBJECT 2", "isValid", "errCnt",
                printBorder(),
                "first name", objectOne.getFirstName(), objectTwo.getFirstName(), firstNamesComparator.isValid(), firstNamesComparator.getErrCnt(),
                "second name", objectOne.getSecondName(), objectTwo.getSecondName(), secondNamesComparator.isValid(), secondNamesComparator.getErrCnt(),
                "patronymic name", objectOne.getPatronymicName(), objectTwo.getPatronymicName(), patronymicNamesComparator.isValid(), patronymicNamesComparator.getErrCnt(),
                printBorder(),
                objectOne.toString(),
                objectTwo.toString(),
                isValid, errCnt
        );
    }


}
