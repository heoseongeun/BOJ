class Solution {
    public int[] solution(int brown, int yellow) {
        for(int w = 1; w <= yellow; w++) {
            int h = yellow / w;
            if(yellow % w == 0 && ((h + w) * 2) + 4 == brown)
                return new int[] {h + 2, w + 2};
        }
        return null;
    }
}