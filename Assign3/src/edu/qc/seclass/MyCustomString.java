package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{

    //Representing a string, defined as a sequence of characters.
    String string;

    public String getString(){

        //Returns the current string and if the string is empty, it should return null.
        if(this.string.isEmpty()){
            return null;
        }

        else{
            return this.string;
        }
    }

    public void setString(String string){

        //setting the value of the current string.
        this.string=string;
    }

    public int countNumbers() {

        //If current string is empty, method will return 0.
        if(this.string.isEmpty()){
            return 0;
        }

        //if current string is null, nullpointerexception is thrown
        if(this.string == null){
            throw new NullPointerException();
        }

        //Returns the number of numbers in the current string, where a number is defined as a contiguous sequence of digits.
        int numCount= 0;

        for(int i= 0; i< this.string.length(); i++) {

            char c= this.string.charAt(i);

            if(Character.isDigit(c)==false){
            }

            else if(i== this.string.length()-1) {
                numCount++;
            }

            else if(Character.isDigit(this.string.charAt(i+1))) {
            }

            else {
                numCount++;
            }
        }

        return numCount;
    }

    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {

        //using StringBuilder
        StringBuilder stringResult = new StringBuilder();

        //Throw nullpointerexception if the string is null and n is greater than 0
        if(this.string== null && n> 0){
            throw new NullPointerException();
        }

        //throw IllegalArgumentException if n is less than or equal to 0
        else if(n<= 0){
            throw new IllegalArgumentException();
        }

        //return empty string if string is empty or has less than n characters
        else if(this.string.length()< n ||this.string.isEmpty()) {
                return "";
        }

        else {

            if (startFromEnd== true) {

                //using insert and append for beginning and end
                for(int i= this.string.length() -n; i>= 0; i -=n) {

                    stringResult.insert(0, this.string.charAt(i));
                }
                    return stringResult.toString();
                }

            else {

                for(int i= n - 1; i< this.string.length(); i +=n) {
                    stringResult.append(this.string.charAt(i));
                    }

                return stringResult.toString();
            }
        }
    }


        public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {

        //throw IllegalArgumentException if startPosition >endPosition
        if(startPosition> endPosition){
            throw new IllegalArgumentException();
        }

        //Throw MyIndexOutOfBoundsException if start position is less than or equal to end position, also when either is <1 or greater than string length
        if((startPosition<= endPosition)&& (startPosition<1||endPosition<1 || startPosition> this.string.length()||endPosition> this.string.length())) {
            throw new MyIndexOutOfBoundsException();
        }

        //Throw NullPointerException if startPosition<= endPosition, startPosition and endPosition are greater than 0, and the current string is null
        if(startPosition<= endPosition &&(startPosition>0 && endPosition>0) && this.string==null) {
            throw new NullPointerException();
        }

        String str = string.substring(startPosition-1, endPosition);

        str= str.replaceAll("0", "Zero");
        str= str.replaceAll("1", "One");
        str= str.replaceAll("2", "Two");
        str= str.replaceAll("3", "Three");
        str= str.replaceAll("4", "Four");
        str= str.replaceAll("5", "Five");
        str= str.replaceAll("6", "Six");
        str= str.replaceAll("7", "Seven");
        str= str.replaceAll("8", "Eight");
        str= str.replaceAll("9", "Nine");

        this.string= string.substring(0, startPosition-1) + str + string.substring(endPosition);
    }
}
