/****
*Rotate an array 90 degree clockwise, in place.
*
* The process is to do two movements:
* First, transpose with respect to the top left/ bottom right.
* Second, reverse each row. 
* The space cost is constant, with a temp variable used to complete in place.
* The time cost is O(n^2), as we must manipulate each cell of the matrix twice.
*/

int[][] rotateImage(int[][] a) {
    int temp;
    int m = a.length;
    for (int i = 0; i< m; i++) {
        for (int k = i+1; k < m; k++) {
            temp = a[i][k];
            a[i][k] = a[k][i];
            a[k][i] = temp;
        }
    }
    
    for (int i = 0; i < m; i++) {
        for (int k = 0; k < m/2; k++) {
            temp = a[i][k];
            a[i][k] = a[i][m-k-1];
            a[i][a.length-k-1] = temp;
        }
    }
    
    return a;
}
