import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class inpuArray implements Comparable<inpuArray> {
    int value;
    int index;

    public inpuArray(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(inpuArray o) {
        return this.value - o.value;
    }
}

public class Study_P1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inpuArray[] array = new inpuArray[n];
        for (int i = 0; i < n; i++) {
        	array[i] = new inpuArray(Integer.parseInt(br.readLine()), i);
        }
        br.close();
        Arrays.sort(array);
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < array[i].index - i) {
                max = array[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}