package dao;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KasKeluar;

public class KasKeluarDAO {


    public void tambahKasKeluar(KasKeluar keluar){

        String sql =
        "INSERT INTO kas_keluar(tanggal,keperluan,nominal) VALUES(?,?,?)";


        try{

            Connection conn =
            DatabaseConnection.getConnection();

            PreparedStatement pst =
            conn.prepareStatement(sql);


            pst.setString(1,
            keluar.getTanggal());

            pst.setString(2,
            keluar.getKeperluan());

            pst.setDouble(3,
            keluar.getNominal());


            pst.executeUpdate();


            System.out.println(
            "\nKas Keluar Berhasil Ditambahkan.");

        }


        catch(SQLException e){

            System.out.println(
            "\nTerjadi Kesalahan.");

            System.out.println(
            e.getMessage());

        }


    }



    public void tampilKasKeluar(){


        String sql =
        "SELECT * FROM kas_keluar";


        try{


            Connection conn =
            DatabaseConnection.getConnection();

            PreparedStatement pst =
            conn.prepareStatement(sql);

            ResultSet rs =
            pst.executeQuery();



            System.out.println(
            "\n===== RIWAYAT KAS KELUAR =====");


            while(rs.next()){


                System.out.println(
                "ID         : "
                +rs.getInt("id_keluar"));

                System.out.println(
                "Tanggal    : "
                +rs.getString("tanggal"));

                System.out.println(
                "Keperluan  : "
                +rs.getString("keperluan"));

                System.out.println(
                "Nominal    : "
                +rs.getDouble("nominal"));

                System.out.println(
                "--------------------------");

            }


        }


        catch(SQLException e){


            System.out.println(
            "\nTerjadi Kesalahan.");

            System.out.println(
            e.getMessage());


        }


    }


}