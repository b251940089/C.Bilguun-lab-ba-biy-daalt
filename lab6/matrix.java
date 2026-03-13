package lab6;
public class matrix {
	
	private int[][] operand1; //first
	private int[][] operand2; //second
	private String operator; // +-* 
	//Constructor
	public matrix(int [][] operand1, int[][] operand2 , String operator ) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;}
   //+
private int[][] addition(int [][] operand1, int [][] operand2) {
	int rows = operand1.length;
	int cols = operand1[0].length;
	int[][] result = new int[rows][cols];
	for (int i=0;i<rows;i++) {
 for (int j=0;j<cols;j++) {
	 result[i][j] = operand1[i][j] + operand2[i][j];}}
 return result; } 
   //-
private int[][] subtraction(int [][] operand1, int [][] operand2) {
	int rows = operand1.length;
	int cols = operand1[0].length;
	int[][] result = new int[rows][cols];
	for (int i=0;i<rows;i++) {
 for (int j=0;j<cols;j++) {
	 result[i][j] = operand1[i][j] - operand2[i][j];}}
 return result;}
 //* 
private int[][] multiplication(int [][] operand1, int [][] operand2) {
	int r1 = operand1.length;
	int c1 = operand1[0].length;
	int c2 = operand2[0].length;
	int [][] result= new int [r1][c2];
	for (int i=0;i<r1;i++) {
		for(int j=0;j<c2;j++) {
			for(int k=0;k<c1;k++) {
				result[i][j] += operand1[i][k] * operand2[k][j]; }}}
	return result; }
// divide
private int[][] divide(int [][] operand1, int [][] operand2) {
    int rows = operand1.length;
    int cols = operand1[0].length;
    int [][] result = new int [rows][cols];
    for (int i=0;i<rows;i++) {
        for(int j=0;j<cols;j++) {
            if(operand2[i][j] == 0) {
                System.out.println("Алдаа: 0-ээр хуваах боломжгүй!");
                result[i][j] = 0;}        
            else{
                result[i][j] = operand1[i][j] / operand2[i][j];}}}
    return result;}
// choose your character
public int [][] chooseoperation(){
	int [][] result = null;
	if (operator.equals("+")) {
	    result = addition(operand1, operand2);}
	else if(operator.equals("-"))  {
	    result = subtraction(operand1, operand2);}
	else if(operator.equals("*"))  {
	    result = multiplication(operand1, operand2);}
	else if(operator.equals("/"))  {
	    result = divide(operand1, operand2);}
		 printmatrix(result);
		 return result; }
	//final product
	private void printmatrix(int [][] pmatrix) 
	{
        System.out.println("Result Matrix:");
        for(int i=0;i<pmatrix.length;i++)
    {
            for(int j=0;j<pmatrix[0].length;j++)
            {
                System.out.print(pmatrix[i][j] + " ");
            }
            System.out.println();   }}}
    
