/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.0.18-nt : Database - x_abs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`x_abs` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `x_abs`;

/*Table structure for table `absensi` */

DROP TABLE IF EXISTS `absensi`;

CREATE TABLE `absensi` (
  `id_anggota_kelas` int(5) NOT NULL,
  `tanggal` datetime NOT NULL,
  PRIMARY KEY  (`id_anggota_kelas`,`tanggal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `absensi` */

/*Table structure for table `dosen` */

DROP TABLE IF EXISTS `dosen`;

CREATE TABLE `dosen` (
  `nidn` varchar(15) NOT NULL,
  `nama` varchar(50) default NULL,
  `jenis_kelamin` varchar(1) default NULL,
  PRIMARY KEY  (`nidn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dosen` */

insert  into `dosen`(`nidn`,`nama`,`jenis_kelamin`) values 
('10160001','Dosen Made','L'),
('10160002','Dosen Nyoman','P'),
('10160003','Dosen Ketut','L'),
('10160004','Dosen Putu Gede','L'),
('10160005','asdasdasd','L');

/*Table structure for table `hari_libur` */

DROP TABLE IF EXISTS `hari_libur`;

CREATE TABLE `hari_libur` (
  `tanggal` date NOT NULL,
  `keterangan` varchar(100) default NULL,
  PRIMARY KEY  (`tanggal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hari_libur` */

/*Table structure for table `kelas` */

DROP TABLE IF EXISTS `kelas`;

CREATE TABLE `kelas` (
  `kode` varchar(10) NOT NULL,
  `nama` varchar(50) default NULL,
  `kode_matakuliah` varchar(10) default NULL,
  `nidn` varchar(15) default NULL,
  `ruangan` varchar(10) default NULL,
  `hari` varchar(15) default NULL,
  `jam_mulai` int(2) default '0',
  `menit_mulai` int(2) default '0',
  `jam_berakhir` int(2) default '0',
  `menit_berakhir` int(2) default '0',
  PRIMARY KEY  (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kelas` */

insert  into `kelas`(`kode`,`nama`,`kode_matakuliah`,`nidn`,`ruangan`,`hari`,`jam_mulai`,`menit_mulai`,`jam_berakhir`,`menit_berakhir`) values 
('001','V','MK-002','10160002','201','Senin',17,20,20,40);

/*Table structure for table `mahasiswa` */

DROP TABLE IF EXISTS `mahasiswa`;

CREATE TABLE `mahasiswa` (
  `nim` varchar(10) NOT NULL,
  `nama` varchar(50) default NULL,
  `tempat_lahir` varchar(50) default NULL,
  `tanggal_lahir` date default NULL,
  `jenis_kelamin` varchar(1) default NULL,
  `program_studi` varchar(50) default NULL,
  `jurusan` varchar(25) default NULL,
  `tahun_masuk` int(5) default '0',
  PRIMARY KEY  (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mahasiswa` */

insert  into `mahasiswa`(`nim`,`nama`,`tempat_lahir`,`tanggal_lahir`,`jenis_kelamin`,`program_studi`,`jurusan`,`tahun_masuk`) values 
('12340001','Mahasiswa Ahmad','Denpasar','1998-09-11','L','Teknik Informatika','DGM',2016),
('12340002','Mahasiswa Kurniawan','Gianyar','1999-01-15','L','Teknik Informatika','MDI',2016),
('12340003','Mahasiswa Ilham','Karangasem','1998-08-25','L','Teknik Informatika','KAB',2016),
('12340004','Mahasiswa Budi','Buleleng','1998-05-05','L','Sistem Komputer','SK',2016),
('12340005','Mahasiswa Adi','Bangli','1998-02-18','L','Teknik Informatika','DGM',2016),
('12340006','Mahasiswa Eko','Badung','1998-01-01','L','Teknik Informatika','MDI',2016),
('12340007','Mahasiswa Nurul','Jembrana','1998-04-09','P','Teknik Informatika','KAB',2016),
('12340008','Mahasiswa Putra','Denpasar','1998-06-09','L','Sistem Komputer','SK',2016),
('12340009','Mahasiswa Nita','Gianyar','1998-08-31','P','Teknik Informatika','DGM',2016),
('12340010','Mahasiswa Arif','Karangasem','1998-09-20','L','Teknik Informatika','MDI',2016),
('12340011','Mahasiswa Fajar','Buleleng','1997-09-18','L','Teknik Informatika','KAB',2016),
('12340012','Mahasiswa Bayux','Bangli','1997-11-15','L','Sistem Komputer','SK',2016),
('12340013','Mahasiswa Lestari','Badung','1998-04-05','P','Teknik Informatika','DGM',2016),
('12340014','Mahasiswa Anita','Jembrana','1998-08-29','P','Teknik Informatika','MDI',2016),
('12340015','Mahasiswa Muhamad','Denpasar','1997-12-29','L','Sistem Komputer','SK',2016),
('12340016','Mahasiswa Kusuma','Gianyar','1998-06-23','L','Sistem Komputer','SK',2016),
('12340017','Mahasiswa Rahmawati','Karangasem','1998-01-15','P','Teknik Informatika','DGM',2016),
('12340018','Mahasiswa Fitria','Buleleng','1997-12-13','P','Teknik Informatika','MDI',2016),
('12340019','Mahasiswa Retno','Bangli','1998-05-21','P','Teknik Informatika','KAB',2016),
('12340020','Mahasiswa Kurnia','Badung','1998-06-30','P','Sistem Komputer','SK',2016),
('12340021','Mahasiswa Widya','Jembrana','1998-06-30','P','Teknik Informatika','DGM',2016),
('12340022','Mahasiswa Intan','Denpasar','1998-04-26','P','Teknik Informatika','MDI',2016),
('12340023','Mahasiswa Diah','Gianyar','1997-11-19','P','Teknik Informatika','KAB',2016),
('12340024','Mahasiswa Agustina','Karangasem','1998-08-26','P','Sistem Komputer','SK',2016),
('12340025','Mahasiswa Made','Buleleng','1998-05-29','L','Teknik Informatika','DGM',2016),
('12340026','Mahasiswa Abdul','Bangli','1998-02-02','L','Teknik Informatika','MDI',2016),
('12340027','Mahasiswa Setiawan','Badung','1998-05-22','L','Teknik Informatika','KAB',2016),
('12340028','Mahasiswa Rizky','Jembrana','1998-01-15','L','Sistem Komputer','SK',2016),
('12340029','Mahasiswa Rini','Denpasar','1998-04-18','P','Teknik Informatika','DGM',2016),
('12340030','Mahasiswa Wahyuni','Gianyar','1998-11-01','P','Teknik Informatika','MDI',2016),
('12340031','Mahasiswa Yulia','Karangasem','1998-04-25','P','Teknik Informatika','KAB',2016),
('12340032','Mahasiswa Hidayat','Buleleng','1998-09-02','L','Sistem Komputer','SK',2016),
('12340033','Mahasiswa Hendra','Bangli','1997-12-31','L','Teknik Informatika','DGM',2016),
('12340034','Mahasiswa Eva','Badung','1998-09-21','P','Teknik Informatika','MDI',2016),
('12340035','Mahasiswa Endah','Jembrana','1997-10-12','P','Teknik Informatika','KAB',2016),
('12340036','Mahasiswa Raden','Denpasar','1998-04-27','L','Sistem Komputer','SK',2016),
('12340037','Mahasiswa Novi','Gianyar','1997-07-22','P','Teknik Informatika','DGM',2016),
('12340038','Mahasiswa Irma','Karangasem','1997-12-25','P','Teknik Informatika','MDI',2016),
('12340039','Mahasiswa Astuti','Buleleng','1997-10-15','P','Teknik Informatika','KAB',2016),
('12340040','Mahasiswa Achmad','Bangli','1997-11-08','L','Sistem Komputer','SK',2016),
('12340041','Mahasiswa Aulia','Badung','1998-06-25','P','Teknik Informatika','DGM',2016),
('12340042','Mahasiswa Puspita','Jembrana','1997-11-17','P','Teknik Informatika','MDI',2016),
('12340043','Mahasiswa Ari','Denpasar','1998-07-01','L','Teknik Informatika','KAB',2016),
('12340044','Mahasiswa Indra','Gianyar','1998-05-12','L','Sistem Komputer','SK',2016),
('12340045','Mahasiswa Dyah','Karangasem','1998-03-19','P','Teknik Informatika','DGM',2016),
('12340046','Mahasiswa Rizki','Buleleng','1998-06-27','L','Teknik Informatika','MDI',2016),
('12340047','Mahasiswa Maria','Bangli','1998-05-29','P','Teknik Informatika','KAB',2016),
('12340048','Mahasiswa Ratih','Badung','1998-01-01','P','Sistem Komputer','SK',2016),
('12340049','Mahasiswa Pratiwi','Jembrana','1998-03-02','P','Teknik Informatika','DGM',2016),
('12340050','Mahasiswa Kartika','Denpasar','1999-02-27','P','Teknik Informatika','MDI',2016),
('12340051','Mahasiswa Wulandari','Gianyar','1998-07-06','P','Teknik Informatika','KAB',2016),
('12340052','Mahasiswa Novita','Karangasem','1998-03-24','P','Sistem Komputer','SK',2016),
('12340053','Mahasiswa Aditya','Buleleng','1997-12-31','L','Teknik Informatika','DGM',2016),
('12340054','Mahasiswa Ria','Bangli','1998-07-14','P','Teknik Informatika','MDI',2016),
('12340055','Mahasiswa Nugroho','Badung','1998-12-27','L','Teknik Informatika','KAB',2016),
('12340056','Mahasiswa Putu Budi','Jembrana','1998-01-10','L','Sistem Komputer','SK',2016),
('12340057','Mahasiswa Handayani','Denpasar','1998-03-25','P','Teknik Informatika','DGM',2016),
('12340058','Mahasiswa Rahayu','Gianyar','1998-03-12','P','Teknik Informatika','MDI',2016),
('12340059','Mahasiswa Yunita','Karangasem','1998-08-22','P','Teknik Informatika','KAB',2016),
('12340060','Mahasiswa Rina','Buleleng','1998-06-08','P','Sistem Komputer','SK',2016),
('12340061','Mahasiswa Ade','Bangli','1998-03-08','P','Teknik Informatika','DGM',2016),
('12340062','Mahasiswa Maya','Badung','1998-05-08','P','Teknik Informatika','MDI',2016),
('12340063','Mahasiswa Puji','Jembrana','1998-03-30','P','Teknik Informatika','KAB',2016),
('12340064','Mahasiswa Utami','Denpasar','1998-09-12','P','Sistem Komputer','SK',2016),
('12340065','Mahasiswa Amalia','Gianyar','1998-09-01','P','Teknik Informatika','DGM',2016),
('12340066','Mahasiswa Dina','Karangasem','1998-08-08','P','Teknik Informatika','MDI',2016),
('12340067','Mahasiswa Devi','Buleleng','1998-09-21','P','Teknik Informatika','KAB',2016),
('12340068','Mahasiswa Citra','Bangli','1998-01-19','P','Sistem Komputer','SK',2016),
('12340069','Mahasiswa Arief','Badung','1998-03-04','L','Teknik Informatika','DGM',2016),
('12340070','Mahasiswa Munaroh','Jembrana','1998-09-03','P','Teknik Informatika','MDI',2016),
('12340071','Mahasiswa Bagus','Denpasar','1998-03-19','L','Teknik Informatika','KAB',2016),
('12340072','Mahasiswa Surya','Gianyar','1998-06-02','L','Sistem Komputer','SK',2016),
('12340073','Mahasiswa Amelia','Karangasem','1998-11-06','P','Teknik Informatika','DGM',2016),
('12340074','Mahasiswa Prima','Buleleng','1998-07-25','L','Teknik Informatika','MDI',2016),
('12340075','Mahasiswa Anggara','Bangli','1998-01-24','L','Teknik Informatika','KAB',2016),
('12340076','Mahasiswa Hadi','Badung','1998-02-05','L','Sistem Komputer','SK',2016),
('12340077','Mahasiswa Diana','Jembrana','1998-01-04','P','Teknik Informatika','DGM',2016),
('12340078','Mahasiswa Anggraini','Denpasar','1998-10-17','P','Teknik Informatika','MDI',2016),
('12340079','Mahasiswa Wulan','Gianyar','1998-07-02','P','Teknik Informatika','KAB',2016),
('12340080','Mahasiswa Saputra','Karangasem','1998-02-15','L','Sistem Komputer','SK',2016),
('12340081','Mahasiswa Yuni','Buleleng','1998-04-02','P','Teknik Informatika','DGM',2016);

/*Table structure for table `mata_kuliah` */

DROP TABLE IF EXISTS `mata_kuliah`;

CREATE TABLE `mata_kuliah` (
  `kode` varchar(10) NOT NULL,
  `nama` varchar(50) default NULL,
  `jml_sks` int(3) default '0',
  PRIMARY KEY  (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mata_kuliah` */

insert  into `mata_kuliah`(`kode`,`nama`,`jml_sks`) values 
('MK-001','Object Oriented Programming',4),
('MK-002','Soft Skill 1',3),
('MK-003','Sistem Informasi Manajemen',3),
('MK-004','Pengantar Manajemen Bisnis',3);

/*Table structure for table `rombel` */

DROP TABLE IF EXISTS `rombel`;

CREATE TABLE `rombel` (
  `kode` int(5) NOT NULL auto_increment,
  `kode_kelas` varchar(10) default NULL,
  `no_absen` int(5) default NULL,
  `nim` varchar(10) default NULL,
  PRIMARY KEY  (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rombel` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `kode` varchar(10) NOT NULL,
  `full_name` varchar(50) default NULL,
  `username` varchar(15) default NULL,
  `password` varchar(15) default NULL,
  PRIMARY KEY  (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`kode`,`full_name`,`username`,`password`) values 
('USER0001','Mr. John Doe','admin',''),
('USER0002','Mr. Example 1','user01',''),
('USER0003','Mr. Budi Yulianto, S.Kom.','budi',''),
('USER0004','Mrs. Maya','maya','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
