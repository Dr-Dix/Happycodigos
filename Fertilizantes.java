package com.mycompany.happyfarm;

import com.mycompany.happyfarm.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Fertilizantes {
private int codFert;
private String nomeFert;
private String caractNutri; 
private String compQuimica; 
private String tipoDeSolo;
private String estagiodaPlanta; 

    public Fertilizantes() {
        this.codFert = codFert;
        this.nomeFert = nomeFert;
        this.caractNutri = caractNutri;
        this.compQuimica = compQuimica;
        this.tipoDeSolo = tipoDeSolo;
        this.estagiodaPlanta = estagiodaPlanta;
    }

    public String getEstagiodaPlanta() {
        return estagiodaPlanta;
    }

    public void setEstagiodaPlanta(String estagiodaPlanta) {
        this.estagiodaPlanta = estagiodaPlanta;
    }

    public int getCodFert() {
        return codFert;
    }

    public void setCodFert(int codFert) {
        this.codFert = codFert;
    }

    public String getNomeFert() {
        return nomeFert;
    }

    public void setNomeFert(String nomeFert) {
        this.nomeFert = nomeFert;
    }

    public String getCaractNutri() {
        return caractNutri;
    }

    public void setCaractNutri(String caractNutri) {
        this.caractNutri = caractNutri;
    }

    public String getCompQuimica() {
        return compQuimica;
    }

    public void setCompQuimica(String compQuimica) {
        this.compQuimica = compQuimica;
    }

    public String getTipoDeSolo() {
        return tipoDeSolo;
    }

    public void setTipoDeSolo(String tipoDeSolo) {
        this.tipoDeSolo = tipoDeSolo;
    }
   
   public void inserir() {
    String sql = "INSERT INTO  TbFertilizantes (nomeFert, caractNutri, compQuimica, tipoDeSolo, estagioDaPlanta) VALUES (?, ?, ?, ?, ?)";
    ConnectionFactory factory = new ConnectionFactory();
    try (Connection c = factory.obtemConexao()) {
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, nomeFert); 
        ps.setString(2, caractNutri);
        ps.setString(3, compQuimica);
        ps.setString(4, tipoDeSolo); 
        ps.setString(5, estagiodaPlanta);
        ps.execute();
        System.out.println("sql --- " + sql);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
     public void apagar (){
                   String sql = "DELETE FROM  TbFertilizantes  WHERE codFert = ?";
                   ConnectionFactory factory = new ConnectionFactory();
                    try (Connection c = factory.obtemConexao()){
                           PreparedStatement ps = c.prepareStatement(sql);
                              ps.setInt(1, codFert);
                              ps.execute();
                                             }  
                    catch (Exception e){ 
                    e.printStackTrace();   
                                    }
                    }
     public void listar() {
    String sql = "SELECT * FROM TbFertilizantes";
    ConnectionFactory factory = new ConnectionFactory();
    try (Connection c = factory.obtemConexao()) {
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int codSafra = rs.getInt("Codigo Safra");
            String nomeFert = rs.getString("nomeFert");
            String caractNutri = rs.getString("caractNutri");
            String compQuimica = rs.getString("compQuimica");
            String tipoDeSolo = rs.getString("tipoDeSolo");
            String estagiodaPlanta = rs.getString("estagioDaPlanta");
            String aux = String.format("codSafra: %d, nomeFert: %s, caractNutri: %s, compQuimica: %s, tipoDeSolo: %s, estagioDaPlanta: %s",
                    codSafra,
                    nomeFert,
                    caractNutri,
                    compQuimica,
                    tipoDeSolo,
                    estagiodaPlanta);

            JOptionPane.showMessageDialog(null, aux);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void atualizarCurso() throws SQLException {
    ConnectionFactory factory = new ConnectionFactory();
    String sql = "UPDATE TbFertilizantes SET nomeFert = ?, caractNutri = ?, compQuimica = ?, tipoDeSolo = ?, estagioDaPlanta = ? WHERE codFert = ?";
    try (Connection c = factory.obtemConexao();
         PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setString(1, nomeFert);
        ps.setString(2, caractNutri);
        ps.setString(3, compQuimica);
        ps.setString(4, tipoDeSolo);
        ps.setString(5, estagiodaPlanta);
        ps.setInt(6, codFert);
        ps.executeUpdate();
    }
}
}
