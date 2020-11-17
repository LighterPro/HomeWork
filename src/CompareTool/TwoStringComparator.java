package CompareTool;

import java.util.HashMap;
import java.util.Map;

public class TwoStringComparator {

    private String stringOne = null;
    private String stringTwo = null;
    private boolean isValid = false;
    private int errCnt = 0;

    public boolean isValid() {
        return isValid;
    }

    public int getErrCnt() {
        return errCnt;
    }

    public TwoStringComparator(String stringOne, String stringTwo) {
        this.stringOne = stringOne;
        this.stringTwo = stringTwo;
        this.compareTwoStrings(stringOne, stringTwo);

    }

    private void compareTwoStrings(String stringOne, String stringTwo) {

        //Checking for string equality
        if (stringOne.equals(stringTwo)) {
            isValid = true;
            return;
        }


        //Checking for lengths are equal
        if (stringOne.length() == stringTwo.length()) {
            //Checking rearrange or change symbols
            ComparisonResult result = checkRearrangedOrChanged(stringOne, stringTwo);
            isValid = result.isValid;
            errCnt = result.getErrCnt();
            return;
        }

        //If string lengths are not equal
        if (stringOne.length() != stringTwo.length()) {
            String longString = null;
            String shortString = null;


            //Long and short string selection
            if (stringOne.length() > stringTwo.length()) {
                longString = stringOne;
                shortString = stringTwo;
            } else {
                longString = stringTwo;
                shortString = stringOne;
            }

            //Checking for one added or deleted character
            StringBuilder tempBuffer = new StringBuilder();
            if (longString.length() - shortString.length() == 1) {
                if ((longString.substring(0, longString.length() - 1)).equals(shortString)) { //If the excess character is the last in a long string
                    isValid = true;
                    errCnt = 1;
                    return;
                } //If the excess character is NOT the last in a long string
                for (int i = 0; i < longString.length() - 1; i++) {
                    if (longString.charAt(i) != shortString.charAt(i)) {
                        tempBuffer = tempBuffer.append(longString.substring(0, i)).append(longString.substring(i + 1));
                        break;
                    }
                }
                isValid = tempBuffer.toString().equals(shortString);
                if (isValid) {
                    errCnt = 1;
                    return;
                }
            }

            //Checking long string contains short string
            if (longString.contains(shortString)) {
                errCnt = longString.length() - shortString.length();
                return;
            }

            int tempMinErrCnt = 100;
            int tempErrCnt = 0;
            for (int i = 0; i <= longString.length() - shortString.length(); i++) {
                String tmpString = longString.substring(i, i + shortString.length());
                ComparisonResult result = checkRearrangedOrChanged(tmpString, shortString);
                tempErrCnt = result.getErrCnt();
                if (tempErrCnt < tempMinErrCnt) {
                    tempMinErrCnt = tempErrCnt;
                }
            }
            errCnt = tempMinErrCnt + (longString.length() - shortString.length());
        }

    }

    private ComparisonResult checkRearrangedOrChanged(String stringOne, String stringTwo) {
        int tempErrCnt = 0;
        int tempErrCntRearrange = 0;
        boolean tempIsValid = false;

        for (int i = 0; i < stringOne.length(); ) {
            if (stringOne.charAt(i) == stringTwo.charAt(i)) {
                i++; //Skip if characters are equal
                continue;
            }
            if (stringOne.charAt(i) != stringTwo.charAt(i)) {
                //Check symbols are rearranged or changed
                if (i == stringOne.length() - 1) { //Checking that the character is the last
                    tempErrCnt++;
                    break;
                }
                if (stringOne.charAt(i) == stringTwo.charAt(i + 1) && stringOne.charAt(i + 1) == stringTwo.charAt(i)) {
                    i += 2; //Symbols rearranged, increase counter by 2
                    tempErrCntRearrange++;
                } else {
                    i++; //Symbols changed
                    tempErrCnt++;
                }
            }
        }
        tempIsValid = (((tempErrCntRearrange <= 2) && (tempErrCnt == 0)) | (tempErrCnt <= 1));
        tempErrCnt = tempErrCntRearrange + tempErrCnt;
        return new ComparisonResult(tempIsValid, tempErrCnt);
    }

    final class ComparisonResult {

        private boolean isValid = false;
        private int errCnt = 0;

        public boolean isValid() {
            return isValid;
        }

        public int getErrCnt() {
            return errCnt;
        }


        public ComparisonResult(boolean isValid, int errCnt) {
            this.isValid = isValid;
            this.errCnt = errCnt;
        }

    }

}

