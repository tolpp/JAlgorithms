package com.tolpp.algorithms.dp.lcs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tolpp
 */
public class LongestCommonSubsequenceTest {
    @Test
    public void findLCS() throws Exception {
        LongestCommonSubsequence.Result lcs = LongestCommonSubsequence.findLCS("ZTR123AAAAB", "KLMN12BAB");
        assertEquals("12AB", lcs.getString());
        assertEquals(4, lcs.getLength());

        lcs = LongestCommonSubsequence.findLCS("ABCDGH", "AEDFHR");
        assertEquals("ADH", lcs.getString());
        assertEquals(3, lcs.getLength());
    }

}