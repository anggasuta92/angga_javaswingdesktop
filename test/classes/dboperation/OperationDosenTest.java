/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.dboperation;

import java.util.Vector;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Angga Suta Dharmawan 16101650
 */
public class OperationDosenTest {
    @Test
    public void test_tampil(){
        Vector test = OperationDosen.tampil(0, 0, "", "");
        assertNotEquals(0, test.size());
        assertNotNull(test);
    }
}
