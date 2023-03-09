class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for(int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            if(w < h) {
                int tmp = w;
                w = h;
                h = tmp;
            } 
            if(w > width) width = w;
            if(h > height) height = h;
        }
        return width * height;
    }
}