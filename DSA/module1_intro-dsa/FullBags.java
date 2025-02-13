import java.util.Arrays;

public class FullBags {
    public static void main(String[] args) {
        int [] capacity = {2,3,4,5};
        int [] rocks = {1,2,4,4};
        int [] vacancy = new int [capacity.length];
        int extra = 2;

        for(int i=0; i<capacity.length; i++) {
            vacancy[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(vacancy);
        

        int count  = 0;
            for(int j=0; j<vacancy.length; j++) {
                if(vacancy[j] != 0) {
                    if(vacancy[j] <= extra) {
                        extra = extra - vacancy[j];
                        count++;
                    } else {
                        break;
                    }
                } else {
                    count++;
                }
            }

            System.out.println(Arrays.toString(vacancy) + " " + count);
    }
}
