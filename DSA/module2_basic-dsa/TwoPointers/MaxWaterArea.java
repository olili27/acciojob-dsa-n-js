public class MaxWaterArea {
    int maxArea(int [] heights) {
        int n = heights.length;

        int maxArea = 0;
        int i = 0;
        int j = n - 1;

        while(i < j){
            int h = Math.min(heights[i], heights[j]);
            int width = j - i;

            int current_area = h * width;
            if(current_area > maxArea) {
                maxArea = current_area;
            }
            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
