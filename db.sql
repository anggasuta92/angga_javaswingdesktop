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
  `kode_kelas` varchar(10) NOT NULL,
  `nim` varchar(10) NOT NULL,
  `tanggal` datetime NOT NULL,
  PRIMARY KEY  (`kode_kelas`,`nim`,`tanggal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `absensi` */

insert  into `absensi`(`kode_kelas`,`nim`,`tanggal`) values 
('002','1','2018-01-06 00:00:00'),
('002','10','2018-01-06 00:00:00'),
('002','11','2018-01-06 00:00:00'),
('002','2','2018-01-06 00:00:00'),
('002','3','2018-01-06 00:00:00'),
('002','5','2018-01-06 00:00:00'),
('002','6','2018-01-06 00:00:00'),
('002','7','2018-01-06 00:00:00'),
('002','8','2018-01-06 00:00:00'),
('002','9','2018-01-06 00:00:00');

/*Table structure for table `anggota_kelas` */

DROP TABLE IF EXISTS `anggota_kelas`;

CREATE TABLE `anggota_kelas` (
  `kode_kelas` varchar(10) NOT NULL,
  `nim` varchar(10) NOT NULL,
  PRIMARY KEY  (`kode_kelas`,`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `anggota_kelas` */

insert  into `anggota_kelas`(`kode_kelas`,`nim`) values 
('002','1'),
('002','10'),
('002','11'),
('002','2'),
('002','3'),
('002','4'),
('002','5'),
('002','6'),
('002','7'),
('002','8'),
('002','9');

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
('001','V','MK-002','10160002','201','Sabtu',17,20,20,40),
('002','Q','MK-001','10160001','1111','Sabtu',0,0,2,0);

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
('1','Mahasiswa Intan','Denpasar','1998-04-26','P','Teknik Informatika','MDI',2016),
('10','Mahasiswa Ria','Bangli','1998-07-14','P','Teknik Informatika','MDI',2016),
('11','Mahasiswa Nugroho','Badung','1998-12-27','L','Teknik Informatika','KAB',2016),
('2','Mahasiswa Diah','Gianyar','1997-11-19','P','Teknik Informatika','KAB',2016),
('3','Mahasiswa Maria','Bangli','1998-05-29','P','Teknik Informatika','KAB',2016),
('4','Mahasiswa Ratih','Badung','1998-01-01','P','Sistem Komputer','SK',2016),
('5','Mahasiswa Pratiwi','Jembrana','1998-03-02','P','Teknik Informatika','DGM',2016),
('6','Mahasiswa Kartika','Denpasar','1999-02-27','P','Teknik Informatika','MDI',2016),
('7','Mahasiswa Wulandari','Gianyar','1998-07-06','P','Teknik Informatika','KAB',2016),
('8','Mahasiswa Novita','Karangasem','1998-03-24','P','Sistem Komputer','SK',2016),
('9','Mahasiswa Aditya','Buleleng','1997-12-31','L','Teknik Informatika','DGM',2016);

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
('USER0004','Mrs. Maya','maya','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
