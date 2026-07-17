package dao;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Anggota;

public class AnggotaDAO {

    public void tambahAnggota(Anggota anggota) {

        String sql =
        "INSERT INTO anggota(nama,kelas) VALUES(?,?)";

        try {

            Connection conn =
            DatabaseConnection.getConnection();

            PreparedStatement pst =
            conn.prepareStatement(sql);

            pst.setString(1,
            anggota.getNama());

            pst.setString(2,
            anggota.getKelas());

            pst.executeUpdate();

            System.out.println(
            "\nData anggota berhasil ditambahkan.");

        }

        catch(SQLException e){

            System.out.println(
            "\nGagal menambahkan data.");

            System.out.println(
            e.getMessage());

        }

    }


    public void tampilAnggota(){

        String sql =
        "SELECT * FROM anggota";


        try{

            Connection conn =
            DatabaseConnection.getConnection();

            PreparedStatement pst =
            conn.prepareStatement(sql);

            ResultSet rs =
            pst.executeQuery();


            System.out.println(
            "\n===== DATA ANGGOTA =====");


            while(rs.next()){


                System.out.println(
                "ID      : "
                +rs.getInt("id_anggota"));

                System.out.println(
                "Nama    : "
                +rs.getString("nama"));

                System.out.println(
                "Kelas   : "
                +rs.getString("kelas"));

                System.out.println(
                "----------------------");

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