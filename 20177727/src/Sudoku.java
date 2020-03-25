public class Sudoku {
    private int[][] matrix;
 
    public Sudoku(int[][] matrix) {
        this.matrix = matrix;
    }
 
    public static void main(String[] args) {
        int[][] sudoku = {
                {0,0,3},
                {0,0,2},
                {0,0,1}};
        Sudoku s = new Sudoku(sudoku);
        s.backTrace(0, 0);
    }
 
    private void backTrace(int i, int j) {
        if (i == 2 && j == 3) {
            System.out.println("3宫格");
            printArray();
            return;
        }
 
        //已经到了列末尾了，还没到行尾，就换行
        if (j == 3) {
            i++;
            j = 0;
        }
 
        //如果i行j列是0，那么才进入
        if (matrix[i][j] == 0) {
            for (int k = 1; k <= 3; k++) {
                if (check(i, j, k)) {
                    //将该值赋给该空格，然后进入下一个空格
                    matrix[i][j] = k;
                    backTrace(i, j + 1);
                    //初始化该空格
                    matrix[i][j] = 0;
                }
            }
        } else {
            //如果该位置已经有值了，就进入下一个空格进行计算
            backTrace(i, j + 1);
        }
    }

    private boolean check(int row, int line, int number) {
        //判断该行该列是否有重复数字
        for (int i = 0; i < 3; i++) {
            if (matrix[row][i] == number || matrix[i][line] == number) {
                return false;
            }
        }
        
        return true;
    }
 

    public void printArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
