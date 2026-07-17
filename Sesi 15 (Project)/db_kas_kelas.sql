-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Jul 2026 pada 16.46
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kas_kelas`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_kas_masuk` (IN `p_id_anggota` INT, IN `p_tanggal` DATE, IN `p_nominal` DOUBLE)   INSERT INTO kas_masuk(id_anggota,tanggal,nominal)
VALUES(p_id_anggota,p_tanggal,p_nominal)$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `total_saldo` () RETURNS DOUBLE DETERMINISTIC RETURN (

(SELECT IFNULL(SUM(nominal),0)
FROM kas_masuk)

-

(SELECT IFNULL(SUM(nominal),0)
FROM kas_keluar)

)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`id_anggota`, `nama`, `kelas`) VALUES
(1, 'Reggie', 'TI24G'),
(2, 'Reggie', 'TI24G'),
(3, 'Yusup', 'TI24A');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kas_keluar`
--

CREATE TABLE `kas_keluar` (
  `id_keluar` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `keperluan` varchar(150) NOT NULL,
  `nominal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kas_keluar`
--

INSERT INTO `kas_keluar` (`id_keluar`, `tanggal`, `keperluan`, `nominal`) VALUES
(1, '2026-07-16', 'Beli Spidol', 10000.00);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kas_masuk`
--

CREATE TABLE `kas_masuk` (
  `id_masuk` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `nominal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kas_masuk`
--

INSERT INTO `kas_masuk` (`id_masuk`, `id_anggota`, `tanggal`, `nominal`) VALUES
(1, 1, '2026-07-15', 50000.00),
(2, 3, '2026-07-16', 10000.00),
(3, 2, '2026-07-16', 7000.00);

--
-- Trigger `kas_masuk`
--
DELIMITER $$
CREATE TRIGGER `trg_log_kas_masuk` AFTER INSERT ON `kas_masuk` FOR EACH ROW BEGIN
    INSERT INTO log_transaksi(keterangan)
    VALUES(
        CONCAT(
            'Kas masuk ditambahkan oleh anggota ID ',
            NEW.id_anggota,
            ' sebesar ',
            NEW.nominal
        )
    );
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `log_transaksi`
--

CREATE TABLE `log_transaksi` (
  `id_log` int(11) NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT current_timestamp(),
  `keterangan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `log_transaksi`
--

INSERT INTO `log_transaksi` (`id_log`, `waktu`, `keterangan`) VALUES
(1, '2026-07-14 17:41:11', 'Kas masuk ditambahkan oleh anggota ID 1 sebesar 50000.00'),
(2, '2026-07-16 13:54:08', 'Kas masuk ditambahkan oleh anggota ID 3 sebesar 10000.00'),
(3, '2026-07-16 14:05:37', 'Kas masuk ditambahkan oleh anggota ID 2 sebesar 7000.00');

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `v_laporan_kas`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `v_laporan_kas` (
`nama` varchar(100)
,`tanggal` date
,`nominal` decimal(10,2)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `v_laporan_kas`
--
DROP TABLE IF EXISTS `v_laporan_kas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_laporan_kas`  AS SELECT `a`.`nama` AS `nama`, `km`.`tanggal` AS `tanggal`, `km`.`nominal` AS `nominal` FROM (`anggota` `a` join `kas_masuk` `km` on(`a`.`id_anggota` = `km`.`id_anggota`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indeks untuk tabel `kas_keluar`
--
ALTER TABLE `kas_keluar`
  ADD PRIMARY KEY (`id_keluar`);

--
-- Indeks untuk tabel `kas_masuk`
--
ALTER TABLE `kas_masuk`
  ADD PRIMARY KEY (`id_masuk`),
  ADD KEY `id_anggota` (`id_anggota`);

--
-- Indeks untuk tabel `log_transaksi`
--
ALTER TABLE `log_transaksi`
  ADD PRIMARY KEY (`id_log`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `kas_keluar`
--
ALTER TABLE `kas_keluar`
  MODIFY `id_keluar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `kas_masuk`
--
ALTER TABLE `kas_masuk`
  MODIFY `id_masuk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `log_transaksi`
--
ALTER TABLE `log_transaksi`
  MODIFY `id_log` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kas_masuk`
--
ALTER TABLE `kas_masuk`
  ADD CONSTRAINT `kas_masuk_ibfk_1` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
