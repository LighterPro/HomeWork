package CompareTool;

class Result {
    boolean isValid = false;
    int errCnt = 0;
    String stringOne = null;
    String stringTwo = null;

    void compareTwoStrings(String stringOne, String stringTwo) {
        this.stringOne = stringOne;
        this.stringTwo = stringTwo;

        //Checking for string equality
        if (stringOne.equals(stringTwo)) {
            isValid = true;
            return;
        }

        //Checking for one changed symbol
        if (stringOne.length() == stringTwo.length()) {
            //If characters at the same positions differ, increment the error counter
            for (int i = 0; i < stringOne.length(); i++) {
                if (stringOne.charAt(i) != stringTwo.charAt(i)) {
                    errCnt++;
                }
            }
            //Checking the number of differing characters
            if (errCnt <= 1) {
                isValid = true;
            }
            return;
        }

        if (stringOne.length() == stringTwo.length()) {

            return;
        }

        //If string lengths are not equal
        if (stringOne.length() != stringTwo.length()) {
            String longString = null;
            String shortString = null;
            StringBuilder tempBuffer = new StringBuilder();

            //Long and short string selection
            if (stringOne.length() > stringTwo.length()) {
                longString = stringOne;
                shortString = stringTwo;
            } else {
                longString = stringTwo;
                shortString = stringOne;
            }

            //Checking for one added or deleted character
            if (longString.length() - shortString.length() == 1) {
                //If the excess character is the last in a long string
                if ((longString.substring(0, longString.length() - 1)).equals(shortString)) {
                    isValid = true;
                    //If the excess character is NOT the last in a long string
                } else {
                    for (int i = 0; i < longString.length() - 1; i++) {
                        if (longString.charAt(i) != shortString.charAt(i)) {
                            tempBuffer = tempBuffer.append(longString.substring(0, i)).append(longString.substring(i + 1));
                            break;
                        }
                    }
                    isValid = tempBuffer.toString().equals(shortString);
                }
                errCnt = 1;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("|%-52s|%-52s|%-10s|%-10s|%n",
                stringOne, stringTwo, isValid, errCnt);
    }
}
