package com.tolpp.algorithms.dp.lcs;

/**
 * @author tolpp
 */
public class LongestCommonSubsequence {

    private LongestCommonSubsequence(){ }

    public static Result findLCS(String str1, String str2) {
        int M = str1.length();
        int N = str2.length();

        int[][] cozum = new int[M+1][N+1];// Altkümelerin harfler için ne kadar kere ortak olduğunu tuttuğum matrisim

        // LCS uzunluğunun ve tüm alt problemlerin dinamik programlamayla hesaplandığı kısım
        for (int i = M-1; i >= 0; i--) {//Dizi elemanlarını tersten gelerek kontrol ediyorum
            for (int j = N-1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j))
                    cozum[i][j] = cozum[i+1][j+1] + 1;// eşleşme varsa bu harfin olduğu fazladan bir alt küme daha olduğunu belirtmek için matris üzerinde bu harflein bulunduğu konumdaki değeri 1 artırıyorum
                else
                    cozum[i][j] = Math.max(cozum[i+1][j], cozum[i][j+1]);// Eşleşme yoksa, o ana kadarki en uzun altküme uzunluğunu en uzun altküme olarak alıyorum
            }
        }

        // cozum[][] matrisini kullanarak LCS nin bulunması
        int i = 0;
        int j = 0;
        StringBuilder outBuilder = new StringBuilder();
        while(i < M && j < N) {
            if (str1.charAt(i) == str2.charAt(j))
            {// i ve j değerlerine göre str1, str2 stringleri üzerinde dolaşarak eşleşme olup olmadığını kontrol ediyorum
                outBuilder.append(str2.charAt(j));
                i++;
                j++;
            }
            else if (cozum[i+1][j] >= cozum[i][j+1]) i++;//her zaman en uzun alt kümeye gidebilmek için bu kontrolleri yapıyorum
            else j++;
        }
        return new Result(outBuilder.toString());
    }

    public static class Result {
        private final String string;

        private Result(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public int getLength() {
            return string.length();
        }
    }
}
