import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        LarrysArray solver = new LarrysArray();
        solver.solve(1, in, out);
        out.close();
    }

    static class LarrysArray {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.readInt();
            if (t <= 0 || t > 100) {
                throw new RuntimeException("t is out of range :(");
            }
            while (t-- > 0) {
                int n = in.readInt();
                if (n <= 0 || n > 1000) {
                    throw new RuntimeException("n is out of range :(");
                }
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.readInt() - 1;
                }
                if (!isPermutation(a)) {
                    throw new RuntimeException("a is not a permutation :(");
                }
                int result = 0;
                boolean[] used = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (!used[i]) {
                        int cur = i, size = 1;
                        while (!used[cur]) {
                            used[cur] = true;
                            size ^= 1;
                            cur = a[cur];
                        }
                        result ^= size;
                    }
                }
                out.printLine(result == 0 ? "YES" : "NO");
            }
        }

        boolean isPermutation(int[] a) {
            int[] x = a.clone();
            Arrays.sort(x);
            for (int i = 0; i < x.length; i++) {
                if (x[i] != i) {
                    return false;
                }
            }
            return true;
        }

    }

    static class OutputWriter {
        private PrintWriter writer;

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public OutputWriter(OutputStream stream) {
            this(new OutputStreamWriter(stream));
        }

        public void print(Object... args) {
            for (Object arg : args) {
                writer.print(arg);
            }
        }

        public void printLine(Object... args) {
            print(args);
            writer.println();
        }

        void close() {
            writer.close();
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(Reader reader) {
            this.reader = new BufferedReader(reader);
        }

        public InputReader(InputStream stream) {
            this(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String readWord() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readWord());
        }

    }
}