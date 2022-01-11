public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        int odds=0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                if (mat[i][j]%2==1||mat[i][j]%2==-1){
                    odds++;
                }
            }
        }
        return odds;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        int largest=mat[0][0];
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                if (largest<mat[i][j]){
                    largest=mat[i][j];
                }
            }
        }
        return largest;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        for(int i=0; i<mat.length; i++) {
            int first=mat[i][0];
            for(int j=1; j<mat[i].length; j++) {

                mat[i][j - 1] = mat[i][j];

            }
            mat[i][mat[i].length-1]=first;
        }
        return mat;
    }

    // Creates a 2D array of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        int [][] newMat=new int [arraySize][arraySize];
        for(int i=0; i<arraySize; i++) {
            for(int j=0; j<arraySize; j++) {
                newMat[i][j]=i+j;
            }
        }
        return newMat;
    }










    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        int total=0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                total+=mat[i][j];
            }
        }
        return ((double)(total)/(mat.length*mat[0].length));
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        if (mat.length*mat[0].length%2==0){ //even
            int totalLength=(mat.length*mat[0].length)/2;
            for(int i=0; i<mat.length; i++) {
                for(int j=0; j<mat[i].length; j++) {
                    totalLength--;
                    if (totalLength==0){
                        if (j==mat[i].length-1){
                            return (mat[i][j]+mat[i+1][0])/2;
                        }
                        else{
                            return (mat[i][j]+mat[i][j+1])/2;
                        }

                    }
                }
            }
        }
        else{ //odd
            int totalLength=(mat.length*mat[0].length)/2+1;
            for(int i=0; i<mat.length; i++) {
                for(int j=0; j<mat[i].length; j++) {
                    totalLength--;
                    if (totalLength==0){
                        return (mat[i][j]);
                    }
                }
            }
        }
        return 0.0;
    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        int arr[]=new int[mat.length*mat[0].length];
        int count=0;
        //int count1=0;
        //int maxCount=0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                arr[count]=(int)(mat[i][j]);
                count++;
            }
        }

        int maxValue = 0, maxCount = 0, i, j;
        int n=arr.length;

        for (i = 0; i < n; ++i) {
            int count1 = 0;
            for (j = 0; j < n; ++j) {
                if (arr[j] == arr[i])
                    ++count1;
            }

            if (count1 > maxCount) {
                maxCount = count1;
                maxValue = arr[i];
            }
        }
        return maxValue;
    }


    public static void main(String[] args) {
        int[][] m1 = {
                {1,  2,  4,  6},
                {7,  9,  10, 12},
                {14, 15, 17, 18},
                {22, 23, 27, 30}
        };
        leftShift(m1);
        int[][] m2 = {
                {42, 37, 23, -5,  9},
                {11,  6, 22, 12, 13},
                {14,  5, 17, 13, 20},
                {1,   4, 27,  7, 32},
                {21, -3,  5,  7, 99},
                {6,  2,  38,  1, 44} };
        countOdds(m2);

    }
}
