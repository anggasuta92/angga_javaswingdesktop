/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.entity;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class MataKuliah {
    private String kode;
    private String nama;
    private int jmlSks;    
    /**
     * @return the kode
     */
    public String getKode() {
        return kode;
    }

    /**
     * @param kode the kode to set
     */
    public void setKode(String kode) {
        this.kode = kode;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jmlSks
     */
    public int getJmlSks() {
        return jmlSks;
    }

    /**
     * @param jmlSks the jmlSks to set
     */
    public void setJmlSks(int jmlSks) {
        this.jmlSks = jmlSks;
    }
    
}
