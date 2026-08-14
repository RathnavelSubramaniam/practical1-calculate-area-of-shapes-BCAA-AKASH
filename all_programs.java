class Point
{
private double x;
private double y;
public Point(double x, double y)
{
this.x = x;
this.y = y;
}
public double getX()
{
return x;
}
public double getY()
{
return y;
}
}
// Step 1: Define the Quadrilateral class
class Quadrilateral {
Point point1;
Point point2;
Point point3;
Point point4;
public Quadrilateral(Point p1, Point p2, Point p3, Point p4)
{
this.point1 = p1;
this.point2 = p2;
this.point3 = p3;
this.point4 = p4;
}
}
// Step 1: Define the Trapezoid class as a subclass of Quadrilateral
class Trapezoid extends Quadrilateral
{
public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
super(p1, p2, p3, p4);
}
public double calculateArea(){
    double base1 =Math.abs(point1.getX()-point2.getX());
    double base2 =Math.abs(point3.getX()-point4.getX());
    double height=Math.abs(point1.getY()-point3.getY());
    return(base1+base2)* height/2.0;
}
}
class Rectangle extends Quadrilateral{
    public Rectangle(Point p1,Point p2,Point p3,Point p4)
    {
        super(p1,p2,p3,p4);
    }
    public double calculateArea(){
        double length =Math.abs(point1.getX()-point2.getX());
        double width=Math.abs(point2.getY()-point4.getY());
        return length * width;
    }
}
class Square extends Rectangle{
    public Square(Point p1,double sideLength){
        super(p1, new Point(p1.getX()+sideLength,p1.getY()),
        new Point(p1.getX()+sideLength,p1.getY()+sideLength),
        new Point(p1.getX(),p1.getY()+sideLength));
    }
    public double calculateArea(){
        double sideLength = Math.abs(point1.getX()-point2.getX());
        return sideLength * sideLength;
    }
}
    class practical1{
        public static void main(String[] args){
            Point p1 = new Point(0,0);
            Point p2 = new Point(4,0);
            Point p3 = new Point(4,3);
            Point p4 = new Point(0,3);
            Trapezoid trapezoid= new Trapezoid(p1,p2,p3,p4);
            Rectangle rectangle = new Rectangle(p1,p2,p3,p4);
            Square square = new Square(p1,3);
            System.out.println("Area of trapezoid="+trapezoid.calculateArea());
            System.out.println("Area of rectangle="+rectangle.calculateArea());
            System.out.println("Area of square="+square.calculateArea());

        }
    }

package program;



class ExceptionA extends Exception {

	public ExceptionA(String message) {

	super(message);

	}

}

	class ExceptionB extends ExceptionA {

	public ExceptionB(String message) {

	super(message);

	}

	}

	class practical2 {
		public static void main(String[] args)

	{

	try {

	throw new ExceptionA (";This is ExceptionA");

	}

	catch (Exception e) {

	System.out.println(";Caught: " + e.getMessage()); }

	try {

	throw new ExceptionB(" ;This is ExceptionB");

	}

	catch (Exception e)

	{

	System.out.println(";Caught: " + e.getMessage());

	}

	try {

	throw new java.io.IOException(";This is an IOException");

	}

	catch (Exception e) {

	System.out.println(";Caught: " + e.getMessage());

	}

	try {

	String nullString = null;



	System.out.println(nullString.length());

	}

	catch (Exception e) {

	System.out.println(";Caught: " + e.getMessage());

	} }}

import java.util.ArrayList;import java.util.Scanner;
public class practical3 {    public static void main(String[]args){        Scanner scanner=new Scanner(System.in);        System.out.println("Enter a line of text");        String inputLine=scanner.nextLine();        String[]words=inputLine.split(" ");        ArrayList<String>wordsStartingWithB=new ArrayList<>();        for(String word:words) {            if(word.toLowerCase().startsWith("b")) {                wordsStartingWithB.add(word);            }        }        ArrayList<String>wordsEndingWithED=new ArrayList<>();        for(String word:words) {            if(word.toUpperCase().endsWith("ED")) {                wordsEndingWithED.add(word);            }        }        System.out.println("Words starting with 'b':"+ wordsStartingWithB);        System.out.println("Words ending with 'ED':"+ wordsEndingWithED);    }}import java.time.LocalDate;import java.time.Period;import java.time.format.DateTimeFormatter;import java.util.Scanner;
public class AgeCalculator {	public static void main(String[] aegs) {		Scanner scanner = new Scanner(System.in);		System.out.println("Enter the moth you were born(1 to 12):");		int month = scanner.nextInt();		System.out.println("Enter the day of the month you were born:");		int day=scanner.nextInt();		System.out.println("Enter the year you were born (four digits):");		int year=scanner.nextInt();		LocalDate birthDate = LocalDate.of(year, month, day);		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMMM dd,yyyy");		System.out.println("Your birth date is "+formatter.format(birthDate));		LocalDate currentDate =LocalDate.now();		System.out.println("Today's date is "+ formatter.format(currentDate));		Period age = Period.between(birthDate,currentDate);		int ageInYears=age.getYears();		System.out.println("Your age is:"+ ageInYears+"years.");	}}
import java.util.HashMap;
public class CharacterCount {	public static void main(String[] args) {		String inputString="HELLO THERE";		HashMap<Character,Integer>charCountMap=countCharacters(inputString);		printCharacterCount(charCountMap);	}	public static HashMap<Character,Integer> countCharacters(String inputString){		HashMap<Character,Integer>charCountMap=new HashMap<>();		for(int i = 0; i<inputString.length();i++) {			char c = inputString.charAt(i);			if (Character.isLetter(c)) {				c = Character.toUpperCase(c);				if(charCountMap.containsKey(c)) {					charCountMap.put(c,charCountMap.get(c)+1);				}				else {					charCountMap.put(c, 1);				}			}					}		return charCountMap;	}		public static void printCharacterCount(HashMap<Character,Integer> charCountMap) {			for(char c:charCountMap.keySet()) {				System.out.println(c + ":"+charCountMap.get(c));			}		}	}
public class SelectionSort {public static<T extends Comparable<T>> void SelectionSort(T[]array) {	int n =array.length;	for(int i=0;i<n-1;i++) {		int minIndex=i;		for (int j=i+1;j<n;j++) {			if(array[j].compareTo(array[minIndex])<0) {				minIndex=j;			}		} T temp=array[minIndex]; array[minIndex]=array[i]; array[i]=temp;	}}public static void main(String[]args) {	Integer[]intArray= {5,3,9,1,7};	Float[]floatArray= {5.5f,3.3f,9.9f,1.1f,7.7f};	System.out.println("OriginalInteger Array:");	printArray(intArray);	System.out.println("Original Float Array :");	printArray(floatArray);	SelectionSort(intArray);	SelectionSort(floatArray);	System.out.println("Sorted Integer Array :");	printArray(intArray);	System.out.println("Sorted Float Array :");	printArray(floatArray);}public static <T> void printArray(T[] array) {	for(T element:array) {		System.out.print(element+" ");		}	System.out.println();	}}

