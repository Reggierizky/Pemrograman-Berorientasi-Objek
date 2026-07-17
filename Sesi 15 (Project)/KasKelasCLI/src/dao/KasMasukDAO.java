package dao;

import database.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KasMasuk;

public class KasMasukDAO {

    public void tambahKasMasuk(KasMasuk masuk) {

        String sql = "{CALL tambah_kas_masuk(?,?,?)}";

        try {

            Connection conn =
            DatabaseConnection.getConnection();

            CallableStatement cs =
            conn.prepareCall(sql);

            cs.setInt(1,
            masuk.getIdAnggota());

            cs.setString(2,
            masuk.getTanggal());

            cs.setDouble(3,
            masuk.getNominal());

            cs.execute();

            System.out.println(
            "\nKas Masuk Berhasil Ditambahkan.");

        }

        catch(SQLException e){

            System.out.println(
            "\nGagal Menambahkan Data.");

            System.out.println(
            e.getMessage());

        }

    }



    public void tampilKasMasuk(){

        String sql =
        "SELECT * FROM v_laporan_kas";


        try{

            Connection conn =
            DatabaseConnection.getConnection();

            PreparedStatement pst =
            conn.prepareStatement(sql);

            ResultSet rs =
            pst.executeQuery();


            System.out.println(
            "\n===== RIWAYAT KAS MASUK =====");


            while(rs.next()){


                System.out.println(
                "Nama     : "
                +rs.getString("nama"));

                System.out.println(
                "Tanggal  : "
                +rs.getString("tanggal"));

                System.out.println(
                "Nominal  : "
                +rs.getDouble("nominal"));

                System.out.println(
                "----------------------");

            }


        }

        catch(SQLException e){

            System.out.println(
            e.getMessage());

        }


    }



    public void tampilTotalSaldo(){

        String sql =
        "SELECT total_saldo() AS saldo";


        try{


            Connection conn =
            DatabaseConnection.getConnection();

            PreparedStatement pst =
            conn.prepareStatement(sql);

            ResultSet rs =
            pst.executeQuery();


            if(rs.next()){


                System.out.println(
                "\nTOTAL SALDO KAS : Rp "
                +rs.getDouble("saldo"));

            }


        }

        catch(SQLException e){

            System.out.println(
            e.getMessage());

        }

    }


}