
//The selected language is java.


    //Test 1
    private int testOne(String a, String b) {

        if (a == null || b == null){
            throw new IllegalArgumentException("none of the arguments can be null");
        }

        int result = 0;

        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        while (a.length() > 0) {
            //The index of where you start searching for the character.
            int indexA = 0;
            //Counter that holdes the number of occurences of the same character.
            int countA = 0;
            //Get the index of the first character in a or the one after it if it has been detected
            //Increment the counter.
            //Select the index of the character that follows the one detected for a further search.
            while ((indexA = a.indexOf(a.charAt(0), indexA)) != -1) {
                countA++;
                indexA++;
            }

            int indexB = 0;
            int countB = 0;
            while ((indexB = b.indexOf(a.charAt(0), indexB)) != -1) {
                countB++;
                indexB++;
            }

            result += Math.abs(countA - countB);

            //Remove the characters that has been counted.
            b = b.replaceAll(String.valueOf(a.charAt(0)), "");
            a = a.replaceAll(String.valueOf(a.charAt(0)), "");
        }

        return result;
    }
    //End of test 1

    //Test 2.
    private Integer[] testTwo(String[] a, String[] b) {
        if (a == null || b == null){
            throw new IllegalArgumentException("none of the arguments can be null");
        }

        Integer[] result = new Integer[b.length];

        for (int i = 0; i < b.length; i++){
            int occurrences = 0;
            for (String tempA : a) {
                // If the two strings are null they are considered the same.
                if ((b[i] == null && tempA == null) || (b[i] != null && tempA != null && b[i].equals(tempA))){
                    occurrences++;
                }
            }
            result[i] = occurrences;
        }

        return result;

    }
    //End of test 2.

    //Test 3
    private int testThree(String hostName){
        if (hostName == null){
            return 0;
        }
        //Creating a regex expression that matches a char sequence containing characters, numbers, dot, - or _
        String regexPattern = "^[a-zA-Z0-9\\.\\-_]+$";

        Pattern pattern = Pattern.compile(regexPattern);

        if (!pattern.matcher(hostName).matches()){
            return 0;
        }

        return hostName.split("\\.").length;

    }
    //End of test 3.

    //Test 4
    private interface Callback{
        //The callback method that will be executed by f4.
        void call();
    }

    private boolean mIsAbleToPerform = true;
    private boolean mIsFirstCall = true;
    private Thread mTimeManager = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(300);
                mIsAbleToPerform = true;
            } catch (InterruptedException e) {
                System.out.println("The system interrupted the sleep process with exception: " + e);
            }
        }
    });

    private void f4(Callback cb) {
        //This should not be called if it's the first time or after less then 300ms of being called again.
        if (mIsAbleToPerform && !mIsFirstCall){
            cb.call();
            mTimeManager.start();
            mIsAbleToPerform = false;
        }
        mIsFirstCall = false;
    }
    //End of test 4.