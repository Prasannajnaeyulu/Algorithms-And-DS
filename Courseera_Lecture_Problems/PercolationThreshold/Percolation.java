import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdRandom;

public class Percolation {

    int[][] sites;
    int[][] visited;
    QuickFindUF quickfinduf;
    int n;
    private int prev = -1;
    int countOpenSites;

    private void checkIndices(int row, int col) {
        if (row <= 0 || col <= 0)
            throw new IllegalArgumentException("value should be greater than zero");
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("value should be greater than zero");
        this.n = n;
        quickfinduf = new QuickFindUF(n * n);
        sites = new int[n][n];
        visited = new int[n][n];
        // Assuming the value 0 indicates site is blocked
        // the value 1 indicates site is open
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sites[i][j] = 0;
                visited[i][j] = -1;
            }
        }
    }

    private void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sites[i][j] + " ");
            }
            System.out.println();
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkIndices(row, col);
        if (!isOpen(row, col)) {
            sites[row - 1][col - 1] = 1;
            countOpenSites++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIndices(row, col);
        return sites[row - 1][col - 1] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkIndices(row, col);
        return isOpen(row, col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countOpenSites;
    }

    private boolean percolate(int row, int col) {
        // Base case
        // if either a row or col is out of bounds or the site at the given row or col is not opened return
        // If the row and col is already visited return
        if (row > n - 1 || col > n - 1 || row < 0 || col < 0 || sites[row][col] != 1) {
            return false;
        }

        if (row == 0) {
            return true;
        }
        if (prev == -1)
            prev = row * n + col;
        else {
            int a = quickfinduf.find(prev);
            int b = quickfinduf.find(row * n + col);
            if (a != b)
                quickfinduf.union(prev, row * n + col);
            prev = -1;
        }
        visited[row][col] = 1;
        // traverse from the left
        if (col - 1 >= 0 && visited[row][col - 1] != 1)
            percolate(row, col - 1);
        if (col + 1 < n && visited[row][col + 1] != 1)
            percolate(row, col + 1);
        if (row - 1 >= 0 && visited[row - 1][col] != 1)
            percolate(row - 1, col);
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        System.out.println("Checking whether the system percolates or not");
        for (int j = 0; j < n; j++) {
            if (percolate(n - 1, j))
                return true;
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = 2;
        int count = 0;
        Percolation p = new Percolation(n);
        while (count++ < (n * n + n)) {
            p.print();
            int nOpenSites = p.numberOfOpenSites();
            int row = StdRandom.uniform(1, n + 1);
            int col = StdRandom.uniform(1, n + 1);
            System.out.println("Opening Site at row: " + row + " Col: " + col);
            p.open(row, col);
            // This is to ensure the above open call opened a new site
            if (p.numberOfOpenSites() > nOpenSites) {
                if (p.percolates()) {
                    System.out.println("Number of Open sites: " + p.numberOfOpenSites());
                    System.out.println("System percolates and the threshold is: " + p.numberOfOpenSites() / (n * n));
                    return;
                }
            }
        }
    }
}
