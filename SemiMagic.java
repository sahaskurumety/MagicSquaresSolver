import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class SemiMagic {

    public static boolean isFullSolution(int[][] square) {
    	int size = square.length;
    	//System.out.println("values size: "+values.length);
    	for(int r = size-1; r>=0;r--) {
    		for(int c = size-1 ; c>=0;c--) {
    			if (square[r][c]==0) return false;
    		}
    	}
    	return true;
    	
    }

    public static boolean reject(int[][] square, int[][] reference) {
        if(isGoodSquare(square)) {
        	return false;
        }
        return true;
    }

    public static int[][] extend(int[][] square, int[][] reference) {
    	int size = square.length;
    	int[][] temp = new int[size][size];
    	boolean placed = false;
    	for(int r = 0; r<size; r++) {
    		for(int c = 0; c<size; c++) {
    			if(square[r][c]!=0 || placed == true) {
    				temp[r][c]=square[r][c];
    			}else {
    				temp[r][c] = 1;
    				placed = true;
    			}
    		}
    	}
    	if(placed == false) return null;
    	return temp;
        
    }

    public static int[][] next(int[][] square, int[][] reference) {
    	int size = square.length;
    	int[][] temp = new int[size][size];
    	for(int r = 0; r<size; r++) {
    		for(int c = 0; c<size; c++) {
    			temp[r][c] = square[r][c];
    		}
    	}
    	int maxVal = size*size;
    	
    	
    	int i = -1;
    	
    	for(int k = 0; k<size*size; k++) {
    		if(reference[k/size][k%size]==0 && temp[k/size][k%size]>0) {
    				i=k;
    		}
    	}
    	if(i==-1||square[i/size][i%size]>=maxVal) return null;
    	temp[i/size][i%size]= temp[i/size][i%size]+1;
    	return temp;
    	
    	
    	
    	/*
    	
    	int i=0;
    	//set i to index of first index followed by a 0
    	for(int k = 0; k<size*size; k++) {
    		if(k==size*size-1) {
    			i = k;
    			break;
    		}
    		if(square[(k+1)/size][(k+1)%size] == 0) {
    			i = k;
    			break;
    		}
    	}
    	//goes backward from i to find first spot where an element can be edited, sets i to that
    	
    	boolean openRef = false;
    	for(int j = i; j>=0; j--) {
    		if(reference[j/size][j%size]==0) {
    			i = j;
    			openRef = true;
    			break;
    		}
    	}
    	if(!openRef) return null;

    	
    	if(square[i/size][i%size]==maxVal) {
    		return null;
    	}else {
    		temp[i/size][i%size] = temp[i/size][i%size]+1;
    	}
    	
    	return temp;
		*/
    	
    	
    	// TODO: Complete this method
    }

    static void testIsFullSolution() {
        System.out.println("\n isFullSolution Method: \n");
        int[][] testTrue3 = new int[][]{
        	{8,1,6},
        	{3,5,7},
        	{4,9,2},
        };
        
        int[][] testTrue4= new int[][]{
    		{1,2,3,4},
        	{4,3,2,1},
        	{1,2,3,4},
        	{4,3,2,1},
    	};
        		
        		
        System.out.println("These print true, followed by their input.");
        
        System.out.println(isFullSolution(testTrue3));
        printSquare(testTrue3);
        System.out.println(isFullSolution(testTrue4));
        printSquare(testTrue4);
        
        int[][] testFalseCol = new int[][]{
        	{8,1,6},
        	{3,0,7},
        	{4,2,9},
        };
        int[][] testFalseRow= new int[][]{
        	{8,1,6},
        	{3,5,0},
        	{4,9,7},
        };
        int[][] testFalseDup = new int[][]{
        	{1,4},
        	{2,0},
        };
        int[][] testFalse4= new int[][]{
    		{0,2,17,3},
        	{1,1,13,1},
        	{1,0,10,1},
        	{1,1,15,1},
    	};
        System.out.println("\nThese should print false, followed by their input.");
        System.out.println(isFullSolution(testFalseCol));
        printSquare(testFalseCol);
        System.out.println(isFullSolution(testFalseRow));
        printSquare(testFalseRow);
        System.out.println(isFullSolution(testFalseDup));
        printSquare(testFalseDup);
        System.out.println(isFullSolution(testFalse4));
        printSquare(testFalse4);
    }

    static void testReject() {
    	System.out.println("\n Reject Method:");
    	
    	int[][] testBlankRef3 = new int[][]{
        	{0,0,0},
        	{0,0,0},
        	{0,0,0},
        }; 
        int[][] testBlankRef4= new int[][]{
    		{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
    	};
        int[][] testFillRef3 = new int[][]{
        	{1,5,9},
        	{6,7,2},
        	{8,4,3},
        };   	
    	int[][] testFalseSq1= new int[][]{
        	{8,1,6},
        	{3,0,7},
        	{4,2,0},
    	};
    	int[][] testFalseSq2= new int[][]{
        	{1,5,9},
        	{6,7,2},
        	{8,3,4},
    	};
    	int[][] testTrueSqDup= new int[][]{
        	{13,1,1},
        	{1,13,1},
        	{1,1,13},
    	};
    	int[][] testTrueSqSum= new int[][]{
    		{1,5,9},
        	{6,7,2},
        	{8,4,3},
    	};
    	
    	int[][] testTrueDup= new int[][]{
    		{5,5,5},
        	{5,5,5},
        	{5,5,5},
    	};
    	
    	int[][] testTrueSqRef= new int[][]{
    		{1,5,9},
        	{6,7,2},
        	{8,4,3},
    	};
    	int[][] testTrueUnderRow= new int[][]{
    		{1,2,3,4},
        	{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
    	};
    	int[][] testTrueUnderCol= new int[][]{
    		{1,0,0,0},
        	{2,0,0,0},
        	{3,0,0,0},
        	{4,0,0,0},
    	};
    	int[][] testFalse4= new int[][]{
    		{1,0,0,0},
        	{4,0,0,0},
        	{15,0,0,0},
        	{14,0,0,0},
    	};

    	System.out.println("\nThese should print true, followed by their input.");
    		System.out.println(reject(testTrueSqDup, testBlankRef3));
    		printSquare(testTrueSqDup);
    		System.out.println(reject(testTrueSqSum, testBlankRef3));
    		printSquare(testTrueSqSum);
    		System.out.println(reject(testTrueSqRef, testFillRef3));
    		printSquare(testTrueDup);
    		System.out.println(reject(testTrueDup, testBlankRef3));
    		printSquare(testTrueUnderCol);
    		System.out.println(reject(testTrueUnderRow, testBlankRef3));
    		printSquare(testTrueUnderRow);
    		System.out.println(reject(testTrueUnderCol, testBlankRef3));
    		printSquare(testTrueUnderCol);
        System.out.println("\nThese should print false, followed by their input.");
    		System.out.println(reject(testFalseSq1, testBlankRef3));
    		printSquare(testFalseSq1);
    		System.out.println(reject(testFalseSq2, testBlankRef3));
    		printSquare(testFalseSq2);
    		System.out.println(reject(testFalse4, testBlankRef4));
    		printSquare(testFalse4);
    		
    }

    static void testExtend() {
    	int[][] testBlankRef2 = new int[][]{
        	{0,0},
        	{0,0},
    	};
    	int[][] testBlankRef3 = new int[][]{
        	{0,0,0},
        	{0,0,0},
        	{0,0,0},
    	};
    	int[][] testBlankRef4 = new int[][]{
        	{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
    	};
    	
    	int[][] testBlankTrue3 = new int[][]{
        	{5,3,7},
        	{4,0,0},
        	{0,0,0},
    	};
    	
    	int[][] testTrue2 = new int[][]{
        	{0,1},
        	{3,2},
    	};
    	
    	int[][] testBlankFalse3 = new int[][]{
        	{1,2,3},
        	{4,5,6},
        	{7,8,9},
    	};
    	
    	int[][] testBlankFalse2 = new int[][]{
        	{5,2},
        	{4,1},
    	};
    	int[][] testBlankTrue4 = new int[][]{
        	{3,8,7,3},
        	{0,4,0,0},
        	{0,0,10,0},
        	{0,5,0,0},
    	};
    	int[][] testTrue1 = {{0}};
    	
    	int[][] testFalse4 = new int[][]{
        	{1,1,1,1},
        	{1,1,1,1},
        	{1,1,1,1},
        	{1,1,1,1},
    	};
    	
    	System.out.println("\n Extend Method");
    	System.out.println("\nThese should print the array, first being before extend method and second after.\nThe following should print the extended squares:");
    	
    	System.out.println("Square 1:");
    	printSquare(testBlankRef2);
    	int[][] temp = extend(testBlankRef2,testBlankRef2);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	
    	System.out.println("Square 2:");
    	printSquare(testTrue2);
    	temp = extend(testTrue2,testBlankRef2);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	
    	System.out.println("Square 3:");
    	printSquare(testBlankTrue3);
    	temp = extend(testBlankTrue3, testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	
    	System.out.println("Square 4:");
    	printSquare(testBlankTrue4);
    	temp = extend(testBlankTrue4, testBlankRef4);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	
    	System.out.println("Square 5:");
    	printSquare(testTrue1);
    	temp = extend(testTrue1, testBlankRef4);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	
    	
    	
    	System.out.println("These should print \"Cannot Extend\" before printing the input.");
    	
    	System.out.println("Square 6:");
    	temp = extend(testBlankFalse2, testBlankRef2);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	printSquare(testBlankFalse2);
    	
    	System.out.println("Square 7:");
    	temp = extend(testBlankFalse3, testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	printSquare(testBlankFalse3);
    	
    	System.out.println("Square 8:");
    	temp = extend(testFalse4, testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Extend");
    	printSquare(testFalse4);
    	
    	
    	
    	
    }

    static void testNext() {
        System.out.println("\nNext Method");
        System.out.println("These should print the input, the reference array (to show uneditable items),\nThen the final array after 'next' method. ");
        int[][] testBlankRef3 = new int[][]{
        	{0,0,0},
        	{0,0,0},
        	{0,0,0},
    	};
    	int[][] testBlankRef4 = new int[][]{
        	{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
        	{0,0,0,0},
    	};
    	int[][] testFullRef3 = new int[][]{
        	{1,2,4},
        	{3,5,6},
        	{9,9,8},
    	};
    	
    	int[][] testRef4 = new int[][]{
        	{1,1,1,1},
        	{1,1,1,0},
        	{1,1,0,1},
        	{1,1,1,1},
    	};
    	
    	int[][] testRef3 = new int[][]{
        	{0,1,1},
        	{1,0,1},
        	{1,1,1},
    	};
    	int[][] testTrue4 = new int[][]{
        	{1,1,1,1},
        	{1,1,1,0},
        	{1,1,1,1},
        	{1,1,1,1},
    	};
    	int[][] testTrue1 = new int[][]{
        	{1,1,1},
        	{1,1,1},
        	{1,1,1},
    	};
    	
    	int[][] testFalseFull = new int[][]{
        	{9,9,9},
        	{9,9,9},
        	{9,9,9},
    	};
    	
    	int[][] testFalse3 = new int[][]{
        	{0,0,0},
        	{0,9,0},
        	{0,0,0},
    	};
    	
    	int[][] testLastMax4 = new int[][]{
        	{1,1,1,1},
        	{1,1,1,1},
        	{1,1,1,1},
        	{1,1,1,16},
    	};
    	int[][] testLastMaxRef4 = new int[][]{
        	{0,0,0,0},
        	{0,1,0,0},
        	{0,0,0,0},
        	{0,0,1,16},
    	};
    	
    	
    	System.out.println("Square 1:");
    	printSquare(testTrue1);
    	printSquare(testBlankRef3);
    	int[][]temp = next(testTrue1,testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Find Next");
    	
    	
    	System.out.println("Square 2:");
    	printSquare(testTrue1);
    	printSquare(testRef3);
    	temp = next(testTrue1,testRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Find Next");
    	
    	
    	System.out.println("Square 3:");
    	printSquare(testTrue4);
    	printSquare(testRef4);
    	temp = next(testTrue4,testRef4);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Find Next");
    	
    	
    	System.out.println("Square 4:");
    	printSquare(testLastMax4);
    	printSquare(testLastMaxRef4);
    	temp = next(testLastMax4,testLastMaxRef4);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot Find Next");
    	
    	System.out.println("These should print their input square then reference, followed by \"Cannot find Next\".");
    	
    	
    	System.out.println("Square 5:");
    	printSquare(testTrue1);
    	printSquare(testFullRef3);
    	temp = next(testTrue1,testFullRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot find Next\n");
    	
    	
    	System.out.println("Square 6:");
    	printSquare(testFalseFull);
    	printSquare(testBlankRef3);
    	temp = next(testFalseFull,testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot find Next\n");
    	
    	
    	System.out.println("Square 7:");
    	printSquare(testLastMax4);
    	printSquare(testBlankRef4);
    	temp = next(testLastMax4,testBlankRef4);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot find Next\n");
    	
    	
    	System.out.println("Square 8:");
    	printSquare(testBlankRef3);
    	printSquare(testBlankRef3);
    	temp = next(testBlankRef3,testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot find Next\n");
    	
    	
    	System.out.println("Square 9:");
    	printSquare(testFalse3);
    	printSquare(testBlankRef3);
    	temp = next(testFalse3,testBlankRef3);
    	if(temp!=null) printSquare(temp);
    	else System.out.println("Cannot find Next\n");
    	
    	
    }

    /**
     * Returns a string representation of a number, padded with enough zeros to
     * align properly for the current size square.
     * @param num the number to pad
     * @param size the size of the square that we are padding to
     * @return the padded string of num
     */
    static String pad(int num, int size) {
        // Determine the max value for a square of this size
        int max = size * size;
        // Determine the length of the max value
        int width = Integer.toString(max).length();
        // Convert num to string
        String result = Integer.toString(num);
        // Pad string with 0s to the desired length
        while (result.length() < width) {
            result = " " + result;
        }
        return result;
    }

    /**
     * Prints a square
     * @param square the square to print
     */
    public static void printSquare(int[][] square) {
        if (square == null) {
            System.out.println("Null (no solution)");
            return;
        }
        int size = square.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(pad(square[i][j], size) + " ");
            }
            System.out.print("\n");

        }

        System.out.print("\n");
    }

    /**
     * Reads a square of a specified size from a plaintext file
     * @param filename the name of the file to read from
     * @param size the size of the square in the file
     * @return the square
     * @throws FileNotFoundException if the named file is not found
     */
    public static int[][] readSquare(String filename, int size)
                throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int[][] square = new int[size][size];
        int val = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = scanner.nextInt();
            }
        }
        return square;
    }

    /**
     * Solves the magic square
     * @param square the partial solution
     * @return the solution, or null if none
     */
    public static int[][] solve(int[][] square,int[][] reference) {
        if (reject(square,reference)) return null;
        if (isFullSolution(square)) return square;
        int[][] attempt = extend(square,reference);
        while (attempt != null) {
            int[][] solution = solve(attempt,reference);
            if (solution != null) return solution;
            attempt = next(attempt,reference);
        }
        return null;
    }
    

    private static boolean isGoodSquare(int[][] square) {
    	int size = square.length;
    	
    	for(int k=size-1;k>=0;k--) {
    		if(!isGoodRow(square,k)||!isGoodCol(square,k)) return false;
    	}
    	if(hasDuplicates(square)) return false;
    	
    	
        return true;
      
        
    	
    }
    private static boolean isGoodRow(int[][] square, int row) {
    	int size = square.length;
    	int goalSum = size*(size*size+1)/2;
    	int sum = 0;
    	boolean isFull = true;
    	for(int c = 0; c<size;c++) {
    		if(square[row][c]==0) {
    			isFull=false;
    		}
    		else
    		sum+= square[row][c];
    	}
    	if(isFull) return sum == goalSum;
    	return sum<=goalSum;
    }
    
    private static boolean isGoodCol(int[][] square, int col) {
    	int size = square.length;
    	int goalSum = size*(size*size+1)/2;
    	int sum = 0;
    	boolean isFull = true;
    	for(int r = 0; r<size;r++) {
    		if(square[r][col]==0) {
    			isFull=false;
    		}
    		else
    		sum+= square[r][col];
    	}
    	if(isFull) return sum == goalSum;
    	return sum<=goalSum;
    }
    private static boolean hasDuplicates(int[][] square) {

    	int i = 0;
    	int temp = square[0][0];
    	int size = square.length;
    	while(i<size*size) {
    		temp = square[i/size][i%size];
    		if(temp!=0) {
    			for(int k = 0; k<i; k++) {
    				if(temp==square[k/size][k%size]) return true;
    			}
    		}
    		i++;
    		
    	}
    	return false;
    	
    }
    
    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
       if (args.length >= 1 && args[0].equals("-t")) {
            System.out.println("Running tests...");
            testIsFullSolution();
            testReject();
            testExtend();
            testNext();
    		} else if (args.length >= 1) {
            try {
                // First get the specified size
                int size =  Integer.parseInt(args[0]);

                int[][] square;
                int[][] reference;
                if (args.length >= 2) {
                    // Read the square from the file
                    square = readSquare(args[1], size);
                    reference = readSquare(args[1], size);
                } else {
                    // Initialize to a blank square
                    square = new int[size][size];
                    reference = new int[size][size];
                }
                System.out.println("Initial square:");
                printSquare(square);

                System.out.println("\nSolution:");
                int[][] result = solve(square,reference);
                printSquare(result);
            } catch (NumberFormatException e) {
                // This happens if the first argument isn't an int
                System.err.println("First argument must be the size");
            } catch (FileNotFoundException e) {
                // This happens if the second argument isn't an existing file
                System.err.println("File " + args[1] + " not found");
            }
        }else {
            System.err.println("See usage in assignment description");
        }
       long endTime = System.currentTimeMillis();
       System.out.println("Took " + ((endTime-startTime))+ "ms");
    }
 }

