/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.entity;

import java.util.Date;

/**
 *
 * @author Angga Suta Dharmawan - 16101650
 */
public class Absensi {
    private String kodeKelas;
    private String nim;
    private Date tanggal;

    /**
     * @return the kodeKelas
     */
    public String getKodeKelas() {
        return kodeKelas;
    }

    /**
     * @param kodeKelas the kodeKelas to set
     */
    public void setKodeKelas(String kodeKelas) {
        this.kodeKelas = kodeKelas;
    }

    /**
     * @return the nim
     */
    public String getNim() {
        return nim;
    }

    /**
     * @param nim the nim to set
     */
    public void setNim(String nim) {
        this.nim = nim;
    }

    /**
     * @return the tanggal
     */
    public Date getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
