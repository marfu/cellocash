-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 10, 2018 at 01:51 PM
-- Server version: 5.5.59-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cellocash`
--

-- --------------------------------------------------------

--
-- Table structure for table `agence_bancaire`
--

CREATE TABLE IF NOT EXISTS `agence_bancaire` (
  `IDENTIFIANT_AGENCE` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE_AGENCE` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESIGNATION_AGENCE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE_AGENCE_BANCAIRE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_PAYS_FK` bigint(20) DEFAULT NULL,
  `PREFIXE_COMPTE_ORDINAIRE` int(11) DEFAULT NULL,
  `PREFIXE_COMPTE_EPARGNE` int(11) DEFAULT NULL,
  `pays_fk` bigint(20) NOT NULL,
  `STATUT` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_AGENCE`),
  KEY `FK_t9viup3aeg0a37f7i751rfaqo` (`TYPE_AGENCE_BANCAIRE_FK`),
  KEY `FK_793qhh3oixscvumrfg1phdjj5` (`IDENTIFIANT_BANQUE_FK`),
  KEY `FK_sb9fwwadfk6n3ojy30jkv2kk1` (`IDENTIFIANT_PAYS_FK`),
  KEY `pays_fk` (`pays_fk`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `agence_bancaire`
--

INSERT INTO `agence_bancaire` (`IDENTIFIANT_AGENCE`, `CODE_AGENCE`, `DESIGNATION_AGENCE`, `TYPE_AGENCE_BANCAIRE_FK`, `IDENTIFIANT_BANQUE_FK`, `IDENTIFIANT_PAYS_FK`, `PREFIXE_COMPTE_ORDINAIRE`, `PREFIXE_COMPTE_EPARGNE`, `pays_fk`, `STATUT`) VALUES
(1, '001', 'Agence vallon', 2, 3, 1, 0, 0, 0, b'1'),
(2, '002', 'Agence plateau', 1, 3, 1, 0, 0, 0, b'1'),
(3, '001', 'Agence adjame', 1, 1, 1, 0, 0, 0, b'1'),
(4, '002', 'Agence plateau', 2, 1, 1, 0, 0, 0, b'1'),
(5, '003', 'Agence cocody', 1, 1, 1, 0, 0, 0, b'1'),
(6, '004', 'Agence abobo', 2, 1, 1, 0, 0, 0, b'1'),
(7, '003', 'test', 1, 3, 1, 0, 0, 0, b'1'),
(8, '4', 'test', 1, 1, 1, 0, 0, 0, b'1'),
(9, '001', 'test', 1, 1, NULL, 0, 0, 0, b'1'),
(10, '', '', 1, 1, NULL, 10, 10, 0, b'1'),
(11, '0', 'TEST', 1, 1, NULL, 10, 10, 1, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `banque_cellocash`
--

CREATE TABLE IF NOT EXISTS `banque_cellocash` (
  `IDENTIFIANT_BANQUE` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE_BANQUE` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NOM_DE_LA_BANQUE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PREFIXE_COMPTE_ORDINAIRE` int(11) DEFAULT NULL,
  `PREFIXE_COMPTE_EPARGNE` int(11) DEFAULT NULL,
  `IDENTIFIANT_PAYS_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_BANQUE`),
  KEY `FK_qh1xh82ydunlf0yjhly5nrxhd` (`IDENTIFIANT_PAYS_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `banque_cellocash`
--

INSERT INTO `banque_cellocash` (`IDENTIFIANT_BANQUE`, `CODE_BANQUE`, `NOM_DE_LA_BANQUE`, `PREFIXE_COMPTE_ORDINAIRE`, `PREFIXE_COMPTE_EPARGNE`, `IDENTIFIANT_PAYS_FK`) VALUES
(1, '001', 'BOA', 10, 10, 1),
(3, '002', 'SGBCI', 10, 15, 2),
(4, '003', 'BANQUE D''ABIDJAN', 10, 5, 1),
(5, '002', 'test', 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `banque_rib`
--

CREATE TABLE IF NOT EXISTS `banque_rib` (
  `code_banque` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `designation_Banque` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sigle` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`code_banque`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `banque_visa`
--

CREATE TABLE IF NOT EXISTS `banque_visa` (
  `code_banque` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `designation_Banque` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sigle` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`code_banque`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `caisse_banque`
--

CREATE TABLE IF NOT EXISTS `caisse_banque` (
  `NUMERO_CELLOCASH` bigint(20) NOT NULL,
  `NOM_DU_CAISSIER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NUMERO_TELEPHONE` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PERSONNE_A_CONTACTER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOLDE_MAXIMUM` double DEFAULT NULL,
  `SOLDE_MINIMUM` double DEFAULT NULL,
  `IDENTIFIANT_AGENCE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`NUMERO_CELLOCASH`),
  KEY `FK_c9tfu3oiwyh3p95f3o2hhk6uq` (`IDENTIFIANT_AGENCE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `ID_CLIENT` bigint(20) NOT NULL,
  `ADRESSE_EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CATEGORIE_CLIENT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CIVILITE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATE_ETABLISSEMENT` datetime DEFAULT NULL,
  `DATE_DE_NAISSANCE` datetime DEFAULT NULL,
  `LANGUE_IVR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LANGUE_WEB` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NOM_CLIENT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NUMERO_DE_COMPTE_EPARGNE` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NUMERO_DE_COMPTE_ORDINANIRE` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NUMERO_DE_LA_PIECE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NUMERO_DE_TELEPHONE` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PAGEFACEBOOK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHOTO_IDENTITE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PIECE_IDENTITE_RECTO` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PIECE_IDENTITE_VERSO` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRENOM_CLIENT` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PROFESSION` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QUARTIER` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SITUATION_MATRIMONIALE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE_PIECE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `VILLE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `VIREMENT_DE_SALAIRE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `commissionbusiness`
--

CREATE TABLE IF NOT EXISTS `commissionbusiness` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_COMMISSION` bigint(20) NOT NULL,
  `CODE_TAXE` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESIGNATION_COMMISSION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oex3u63qcmpbydj07i6rp1aow` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `commissionbusiness`
--

INSERT INTO `commissionbusiness` (`id`, `libelle`, `IDENTIFIANT_COMMISSION`, `CODE_TAXE`, `DESIGNATION_COMMISSION`, `IDENTIFIANT_BANQUE_FK`) VALUES
(2, 'test', 0, '8888', '8888888', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `commissions_business`
--

CREATE TABLE IF NOT EXISTS `commissions_business` (
  `IDENTIFIANT_COMMISSION` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE_TAXE` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESIGNATION_COMMISSION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_COMMISSION`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `commissions_business`
--

INSERT INTO `commissions_business` (`IDENTIFIANT_COMMISSION`, `CODE_TAXE`, `DESIGNATION_COMMISSION`) VALUES
(1, 'test', '0012');

-- --------------------------------------------------------

--
-- Table structure for table `commissions_client`
--

CREATE TABLE IF NOT EXISTS `commissions_client` (
  `CODE_TAXE` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `DESIGNATION_COMMISSION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_AGENCE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_COMMISSION_CLIENT` bigint(20) NOT NULL,
  PRIMARY KEY (`CODE_TAXE`),
  UNIQUE KEY `UK_9eir59w38pvhl57gjxonf11mp` (`CODE_TAXE`),
  KEY `FK_5uc9jnlfxqevvevi0s4mk8pim` (`IDENTIFIANT_AGENCE_FK`),
  KEY `FK_1ea1sf4ex9hgju27f240bjauk` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `commission_ligne_business`
--

CREATE TABLE IF NOT EXISTS `commission_ligne_business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMISSION_EN_POURCENTAGE_CLIENT` double DEFAULT NULL,
  `COMMISSION_EN_VALEUR_CLIENT` double DEFAULT NULL,
  `DATE_EFFET` datetime DEFAULT NULL,
  `MONTANT_BORNE_SUPERIEUR` double DEFAULT NULL,
  `NUMERO_LIGNE_BUSINESS` int(11) DEFAULT NULL,
  `PART_COMMISSION_DEALER_EN_POURCENTAGE` double DEFAULT NULL,
  `PART_COMMISSION_DEALER_EN_VALEUR` double DEFAULT NULL,
  `PART_COMMISSION_SUB_DEALER_EN_POURCENTAGE` double DEFAULT NULL,
  `PART_COMMISSION_SUB_DEALER_EN_VALEUR` double DEFAULT NULL,
  `REFERENCE_COMMISSION_BUSINESS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE_DE_VALEUR` bit(1) DEFAULT NULL,
  `COMMISSION_BUSINESS_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_OPERATION_CELLOCASH_FK` bigint(20) DEFAULT NULL,
  `agenceBancaire_fk` bigint(20) NOT NULL,
  `banque_Cellocash_fk` bigint(20) NOT NULL,
  `DESIGNATION_COMMISSION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pays_fk` bigint(20) NOT NULL,
  `IDENTIFIANT_ProgrammeFacturationBusiness_FK` bigint(20) DEFAULT NULL,
  `dateFin` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `agenceBancaire_fk` (`agenceBancaire_fk`),
  KEY `bankque_fk` (`banque_Cellocash_fk`),
  KEY `pays_fk` (`pays_fk`),
  KEY `FK_34k27gu6smehtjypocso50ml7` (`IDENTIFIANT_OPERATION_CELLOCASH_FK`),
  KEY `FK_jyi9n4ttct0jptto6p9na313e` (`IDENTIFIANT_ProgrammeFacturationBusiness_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `commission_ligne_business`
--

INSERT INTO `commission_ligne_business` (`id`, `COMMISSION_EN_POURCENTAGE_CLIENT`, `COMMISSION_EN_VALEUR_CLIENT`, `DATE_EFFET`, `MONTANT_BORNE_SUPERIEUR`, `NUMERO_LIGNE_BUSINESS`, `PART_COMMISSION_DEALER_EN_POURCENTAGE`, `PART_COMMISSION_DEALER_EN_VALEUR`, `PART_COMMISSION_SUB_DEALER_EN_POURCENTAGE`, `PART_COMMISSION_SUB_DEALER_EN_VALEUR`, `REFERENCE_COMMISSION_BUSINESS`, `TYPE_DE_VALEUR`, `COMMISSION_BUSINESS_FK`, `IDENTIFIANT_OPERATION_CELLOCASH_FK`, `agenceBancaire_fk`, `banque_Cellocash_fk`, `DESIGNATION_COMMISSION`, `pays_fk`, `IDENTIFIANT_ProgrammeFacturationBusiness_FK`, `dateFin`) VALUES
(3, 0, 0, NULL, 0, 0, 0, 0, 0, 0, NULL, b'0', NULL, 1, 1, 1, NULL, 1, 1, NULL),
(4, 0, 0, '2018-05-10 00:00:00', 0, 0, 0, 0, 0, 0, NULL, b'0', NULL, 1, 1, 1, NULL, 1, 1, NULL),
(5, 0, 0, '2018-05-23 00:00:00', 0, 0, 0, 0, 0, 0, NULL, b'0', NULL, 1, 1, 3, NULL, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `commission_taxe`
--

CREATE TABLE IF NOT EXISTS `commission_taxe` (
  `CODE_TAXE` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `DESIGNATION_COMMISSION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESIGNATION_DE_LA_TAXE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_AGENCE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_COMMISSION_TAXE` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`IDENTIFIANT_COMMISSION_TAXE`),
  UNIQUE KEY `UK_mpcff7s4i9t1kk7j4xviw54ea` (`CODE_TAXE`),
  KEY `FK_9eriy6scy2rite0fna5c6tsk4` (`IDENTIFIANT_AGENCE_FK`),
  KEY `FK_nfkfcvnsnnhbm1xuq0rv72oge` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `commission_taxe`
--

INSERT INTO `commission_taxe` (`CODE_TAXE`, `DESIGNATION_COMMISSION`, `DESIGNATION_DE_LA_TAXE`, `IDENTIFIANT_AGENCE_FK`, `IDENTIFIANT_BANQUE_FK`, `IDENTIFIANT_COMMISSION_TAXE`) VALUES
('001', 'TEST', 'TEST', NULL, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `email_operation`
--

CREATE TABLE IF NOT EXISTS `email_operation` (
  `IDENTIFIANT_EMAIL` bigint(20) NOT NULL,
  `CORPS_EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESTINATION` bit(1) DEFAULT NULL,
  `OBJET_EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SIGNATURE_EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `email_operation_operation`
--

CREATE TABLE IF NOT EXISTS `email_operation_operation` (
  `id` bigint(20) NOT NULL,
  `IDENTIFIANT_EMAIL_FK` bigint(20) DEFAULT NULL,
  `CODE_OPERATION_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6cm7lunmpc8v1mn8r664sl1w5` (`IDENTIFIANT_EMAIL_FK`),
  KEY `FK_s77xcl731c2axwl01qv3rm7ln` (`CODE_OPERATION_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `frequence_prelevement`
--

CREATE TABLE IF NOT EXISTS `frequence_prelevement` (
  `id` bigint(20) NOT NULL,
  `frequence` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `grossiste`
--

CREATE TABLE IF NOT EXISTS `grossiste` (
  `id` bigint(20) NOT NULL,
  `ADRESSE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NOM_DISTRIBUTEUR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NOM_GESTIONNAIRE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NUMERO_TELEPHONE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHOTO_RCCM1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHOTO_RCCM2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ap4iq8oebq5fp2l1qggw1loj6` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(52);

-- --------------------------------------------------------

--
-- Table structure for table `historiqueconnection`
--

CREATE TABLE IF NOT EXISTS `historiqueconnection` (
  `id` bigint(20) NOT NULL,
  `browser` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dateConnexion` date DEFAULT NULL,
  `ipAdress` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `historiqueconnection`
--

INSERT INTO `historiqueconnection` (`id`, `browser`, `dateConnexion`, `ipAdress`, `username`) VALUES
(4, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-08', '127.0.0.1', 'sayepi'),
(5, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-08', '127.0.0.1', 'sayepi'),
(6, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-08', '127.0.0.1', 'sayepi'),
(7, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-08', '127.0.0.1', 'sayepi'),
(8, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(9, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(10, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(11, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(12, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(13, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(14, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(15, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(16, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(17, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(18, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(19, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(20, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(21, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(22, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(23, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(24, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(25, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(26, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(27, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(28, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(29, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(30, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(31, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(32, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(33, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(34, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(35, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(36, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(37, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(38, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(39, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(40, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(41, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(42, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(43, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(44, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(45, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(46, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(47, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(48, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(49, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(50, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi'),
(51, 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-05-10', '127.0.0.1', 'sayepi');

-- --------------------------------------------------------

--
-- Table structure for table `impottaxe`
--

CREATE TABLE IF NOT EXISTS `impottaxe` (
  `IDENTIFIANT_IMPOT_TAXE` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_TAXE` int(11) DEFAULT NULL,
  `CODE_IMPOT_TAXE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESIGNATION_IMPOT_TAXE` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_TYPE_IMPOT_TAXE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_IMPOT_TAXE`),
  KEY `FK_gdmual0whsrcaeasnv9o8lg1e` (`IDENTIFIANT_TYPE_IMPOT_TAXE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_commission_client`
--

CREATE TABLE IF NOT EXISTS `ligne_commission_client` (
  `REFERENCE_COMMISSION_CLIENT` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id` bigint(20) NOT NULL,
  `COMMISSION_EN_POURCENTAGE` int(11) DEFAULT NULL,
  `COMMISSION_EN_VALEUR` double DEFAULT NULL,
  `DATE_EFFET` datetime DEFAULT NULL,
  `COMMISSION_BORNE_SUPERIEUR` double DEFAULT NULL,
  `NUMERO_LIGNE` int(11) DEFAULT NULL,
  `TYPE_VALEUR` bit(1) DEFAULT NULL,
  `CODE_TAXE_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE_OPERATION_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`REFERENCE_COMMISSION_CLIENT`,`id`),
  KEY `FK_ef5uu23hrffeixdagywvfm4l` (`CODE_TAXE_FK`),
  KEY `FK_2gsex6ec4dwl4eq7k02555h0p` (`CODE_OPERATION_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_commission_taxe`
--

CREATE TABLE IF NOT EXISTS `ligne_commission_taxe` (
  `REFERENCE_TAXE` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id` bigint(20) NOT NULL,
  `DATE_EFFET` datetime DEFAULT NULL,
  `DESIGNATION_TAXE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MONTANT_BORNE_SUPERIEUR` double DEFAULT NULL,
  `NUMERO_LIGNE` int(11) DEFAULT NULL,
  `TAXE_EN_POURCENTAGE` int(11) DEFAULT NULL,
  `TAXE_EN_VALEUR` double DEFAULT NULL,
  `TYPE_TAXE` bit(1) DEFAULT NULL,
  `TYPE_VALEUR` bit(1) DEFAULT NULL,
  `CODE_TAXE_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE_OPERATION_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_COMMISSION_TAXE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_IMPOT_TAXE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_OPERATION_CELLOCASH_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`REFERENCE_TAXE`,`id`),
  KEY `FK_jjiq9dw2jyf9tneeuw7uv7dv` (`CODE_TAXE_FK`),
  KEY `FK_qjf7fqyanbt2r03p1vo5hg8n5` (`CODE_OPERATION_FK`),
  KEY `FK_8ymtb5vtkgjcd1v214bqal7gv` (`IDENTIFIANT_COMMISSION_TAXE_FK`),
  KEY `FK_jtu0irv625bvuu1vnfa0uhj3s` (`IDENTIFIANT_IMPOT_TAXE_FK`),
  KEY `FK_1a31rhwvoq933hsdl7nxiv6pl` (`IDENTIFIANT_OPERATION_CELLOCASH_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `liste_des_menus`
--

CREATE TABLE IF NOT EXISTS `liste_des_menus` (
  `CODE_MENU` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `LIBELLE_MENU` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CODE_MENU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `operationcellocash`
--

CREATE TABLE IF NOT EXISTS `operationcellocash` (
  `IDENTIFIANT_OPERATION` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE_OPERATION` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LIBELLE_OPERATION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_OPERATION`),
  UNIQUE KEY `UK_6mj2p32pfm417s878cu2j03wl` (`CODE_OPERATION`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `operationcellocash`
--

INSERT INTO `operationcellocash` (`IDENTIFIANT_OPERATION`, `CODE_OPERATION`, `LIBELLE_OPERATION`) VALUES
(1, 'TEST1', 'TEST1'),
(2, 'TEST2', 'TEST2');

-- --------------------------------------------------------

--
-- Table structure for table `operation_cellocash`
--

CREATE TABLE IF NOT EXISTS `operation_cellocash` (
  `CODE_OPERATION` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `LIBELLE_OPERATION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IDENTIFIANT_OPERATION` bigint(20) NOT NULL,
  PRIMARY KEY (`IDENTIFIANT_OPERATION`),
  UNIQUE KEY `UK_9h5eew8knlvnud0n87y8ymuy9` (`CODE_OPERATION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `operation_cellocash`
--

INSERT INTO `operation_cellocash` (`CODE_OPERATION`, `LIBELLE_OPERATION`, `IDENTIFIANT_OPERATION`) VALUES
('124', 'TEST', 1),
('123', 'TEST', 2);

-- --------------------------------------------------------

--
-- Table structure for table `param_secu_liaison_role_permission`
--

CREATE TABLE IF NOT EXISTS `param_secu_liaison_role_permission` (
  `ROLE_FK` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `permissionId` bigint(20) NOT NULL,
  KEY `FK_32m57ao06chyaqriecq0p2nlt` (`permissionId`),
  KEY `FK_8coy5xe1vhqj3yqeatvbmuybh` (`ROLE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `param_secu_role_permission`
--

CREATE TABLE IF NOT EXISTS `param_secu_role_permission` (
  `permissionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menuParent_permissionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`permissionId`),
  UNIQUE KEY `UK_jctqg44gjimmejd0tcputvbyw` (`nom`),
  KEY `FK_lwleojsp30hb487dk8q4v8s02` (`menuParent_permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE IF NOT EXISTS `pays` (
  `IDENTIFIANT_PAYS` bigint(20) NOT NULL,
  `DESIGNATION_DU_PAYS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INDICATIF_PAYS` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_PAYS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pays`
--

INSERT INTO `pays` (`IDENTIFIANT_PAYS`, `DESIGNATION_DU_PAYS`, `INDICATIF_PAYS`) VALUES
(1, 'COTE D''IVOIRE', '225'),
(2, 'SENEGAL', '221');

-- --------------------------------------------------------

--
-- Table structure for table `plan_epargne`
--

CREATE TABLE IF NOT EXISTS `plan_epargne` (
  `NUMERO_DU_PLAN_EPARGNE` bigint(20) NOT NULL,
  `DATE_DE_CREATION_DU_CHAMP` datetime DEFAULT NULL,
  `DATE_DE_SUPPRESSION` datetime DEFAULT NULL,
  `DESIGNATION_DU_PLAN_EPARGNE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FREQUENCE_PRELEVEMENT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INTERET_APPLIQUE` double DEFAULT NULL,
  `NOMBRE_DE_PERIODE` int(11) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`NUMERO_DU_PLAN_EPARGNE`),
  KEY `FK_in720v2bqipnj53tad3c2vqdu` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prets`
--

CREATE TABLE IF NOT EXISTS `prets` (
  `NUMERO_PRETS` bigint(20) NOT NULL,
  `DATE_CREATION` datetime DEFAULT NULL,
  `DATE_DE_SUPPRESSION` datetime DEFAULT NULL,
  `DESIGNATION_DU_PRET` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FACTEUR` double DEFAULT NULL,
  `FREQUENCE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INTERET` double DEFAULT NULL,
  `NOMBRE_DE_REMBOURSEMENT` int(11) DEFAULT NULL,
  `TYPE_PRETS` bit(1) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`NUMERO_PRETS`),
  KEY `FK_i93fc14wkm2kvxacjg2esb4gh` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `profil_utilisateur`
--

CREATE TABLE IF NOT EXISTS `profil_utilisateur` (
  `CODE_PROFILE` bigint(20) NOT NULL,
  `DESIGNATION_PROFILE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CODE_PROFILE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `programmefacturationbusiness`
--

CREATE TABLE IF NOT EXISTS `programmefacturationbusiness` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESIGNATION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `programmefacturationbusiness`
--

INSERT INTO `programmefacturationbusiness` (`id`, `DESIGNATION`) VALUES
(1, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `id` bigint(20) NOT NULL,
  `CODE_REGION` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESIGNATION_REGION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ROLE_PK` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ROLE_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ROLE_PK`) VALUES
('ADMINISTRATEUR'),
('SUPERADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `sms_operation`
--

CREATE TABLE IF NOT EXISTS `sms_operation` (
  `CODE_SMS` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `DESTINATION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MESSAGE_SMS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CODE_SMS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sms_operation_operation`
--

CREATE TABLE IF NOT EXISTS `sms_operation_operation` (
  `id` bigint(20) NOT NULL,
  `CODE_SMS_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE_OPERATION_FK` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gm75va1db38xccen8hkjqd3vx` (`CODE_SMS_FK`),
  KEY `FK_ejhdx9n397cm6idws0dcc9r1p` (`CODE_OPERATION_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tontine_cellocash`
--

CREATE TABLE IF NOT EXISTS `tontine_cellocash` (
  `NUMERO_TONTINE` bigint(20) NOT NULL,
  `DESIGNATION_TONTINE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ECHEANCE_DE_REMBOURSEMENT` int(11) DEFAULT NULL,
  `ECHEANCE_REMBOURSEMENT_FORCE` int(11) DEFAULT NULL,
  `FREQUENCE_DE_REMBOURSEMENT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INTERET_FIN_PERIODE` double DEFAULT NULL,
  `NOMBRE_DE_MEMBRE_DU_GROUPE` int(11) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`NUMERO_TONTINE`),
  KEY `FK_40pu3h2l86d3mhgyxi9qbvtp7` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction_cellocash`
--

CREATE TABLE IF NOT EXISTS `transaction_cellocash` (
  `id` bigint(20) NOT NULL,
  `COMMENTAIRE_TRANSACTON` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATE_TRANSACTION` datetime DEFAULT NULL,
  `DESIGNATION_TRANSACTION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MONTANT_CREDIT` decimal(19,2) DEFAULT NULL,
  `MONTANT_DEBIT` decimal(19,2) DEFAULT NULL,
  `REFERENCE_TRANSACTION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOLDE_COMPTE` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `typeimpottaxe`
--

CREATE TABLE IF NOT EXISTS `typeimpottaxe` (
  `IDENTIFIANT_TYPE_IMPOT_TAXE` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESIGNATION_IMPOT_TAXE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDENTIFIANT_TYPE_IMPOT_TAXE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `type_agence_bancaire`
--

CREATE TABLE IF NOT EXISTS `type_agence_bancaire` (
  `TYPE_AGENCE_BANCAIRE` bigint(20) NOT NULL,
  `DESIGNATION_TYPE_AGENCE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`TYPE_AGENCE_BANCAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `type_agence_bancaire`
--

INSERT INTO `type_agence_bancaire` (`TYPE_AGENCE_BANCAIRE`, `DESIGNATION_TYPE_AGENCE`) VALUES
(1, 'Banque d''affaires'),
(2, 'Banque centrales');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `NOM_UTILISATEUR_PK` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ALERTE_SI_NB` bigint(11) DEFAULT '100',
  `DATE_CREATION` datetime DEFAULT NULL,
  `DATE_DERNIERE_CONNEXION` datetime DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SI_ACTIF` bit(1) DEFAULT NULL,
  `NOM_DE_FAMILLE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRENOM` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MATRICULE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MOT_DE_PASSE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_ROLE_PK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE_AGENCE_BANCAIRE_FK` bigint(20) DEFAULT NULL,
  `IDENTIFIANT_BANQUE_FK` bigint(20) DEFAULT NULL,
  `FIRST_CONNEXION` bit(1) DEFAULT NULL,
  PRIMARY KEY (`NOM_UTILISATEUR_PK`),
  KEY `FK_9jwt2xotb4jsld8ba4wj5b2rr` (`role_ROLE_PK`),
  KEY `FK_9rdvpmknswpnac41s0pgs82h8` (`TYPE_AGENCE_BANCAIRE_FK`),
  KEY `FK_7ri6mnl4jnfm9hx06m9ewdx8i` (`IDENTIFIANT_BANQUE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`NOM_UTILISATEUR_PK`, `ALERTE_SI_NB`, `DATE_CREATION`, `DATE_DERNIERE_CONNEXION`, `EMAIL`, `SI_ACTIF`, `NOM_DE_FAMILLE`, `PRENOM`, `MATRICULE`, `MOT_DE_PASSE`, `role_ROLE_PK`, `TYPE_AGENCE_BANCAIRE_FK`, `IDENTIFIANT_BANQUE_FK`, `FIRST_CONNEXION`) VALUES
('demo', 100, '2017-12-28 16:54:53', NULL, NULL, b'1', 'demo', 'demo', NULL, 'ec03f91ae56e478455e3786e91559194', 'ADMINISTRATEUR', NULL, NULL, b'1'),
('marfu', 100, '2018-05-07 23:56:37', NULL, 'Balogun@gmail.com', b'1', 'marfu', 'Balogun', NULL, '294ed1b37bcd9dcd236bc7d1dc866a62', 'ADMINISTRATEUR', 1, 1, b'1'),
('sayepi', 100, '2017-03-12 23:21:42', '2018-05-10 12:50:09', 'sayepi@prosuma.ci', b'1', 'AYEPI', 'Serge', '4493', 'b2603694cf60012b423b12f679c79da6', 'SUPERADMIN', NULL, NULL, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` bigint(20) NOT NULL,
  `IDENTIFIANT_AGENCE_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eboo5l4imaoa8itptltejkea` (`IDENTIFIANT_AGENCE_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agence_bancaire`
--
ALTER TABLE `agence_bancaire`
  ADD CONSTRAINT `FK_793qhh3oixscvumrfg1phdjj5` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`),
  ADD CONSTRAINT `FK_sb9fwwadfk6n3ojy30jkv2kk1` FOREIGN KEY (`IDENTIFIANT_PAYS_FK`) REFERENCES `pays` (`IDENTIFIANT_PAYS`),
  ADD CONSTRAINT `FK_t9viup3aeg0a37f7i751rfaqo` FOREIGN KEY (`TYPE_AGENCE_BANCAIRE_FK`) REFERENCES `type_agence_bancaire` (`TYPE_AGENCE_BANCAIRE`);

--
-- Constraints for table `banque_cellocash`
--
ALTER TABLE `banque_cellocash`
  ADD CONSTRAINT `FK_qh1xh82ydunlf0yjhly5nrxhd` FOREIGN KEY (`IDENTIFIANT_PAYS_FK`) REFERENCES `pays` (`IDENTIFIANT_PAYS`);

--
-- Constraints for table `caisse_banque`
--
ALTER TABLE `caisse_banque`
  ADD CONSTRAINT `FK_c9tfu3oiwyh3p95f3o2hhk6uq` FOREIGN KEY (`IDENTIFIANT_AGENCE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`);

--
-- Constraints for table `commissionbusiness`
--
ALTER TABLE `commissionbusiness`
  ADD CONSTRAINT `FK_oex3u63qcmpbydj07i6rp1aow` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`);

--
-- Constraints for table `commissions_client`
--
ALTER TABLE `commissions_client`
  ADD CONSTRAINT `FK_1ea1sf4ex9hgju27f240bjauk` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`),
  ADD CONSTRAINT `FK_5uc9jnlfxqevvevi0s4mk8pim` FOREIGN KEY (`IDENTIFIANT_AGENCE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`);

--
-- Constraints for table `commission_ligne_business`
--
ALTER TABLE `commission_ligne_business`
  ADD CONSTRAINT `FK_34k27gu6smehtjypocso50ml7` FOREIGN KEY (`IDENTIFIANT_OPERATION_CELLOCASH_FK`) REFERENCES `operationcellocash` (`IDENTIFIANT_OPERATION`),
  ADD CONSTRAINT `FK_jyi9n4ttct0jptto6p9na313e` FOREIGN KEY (`IDENTIFIANT_ProgrammeFacturationBusiness_FK`) REFERENCES `programmefacturationbusiness` (`id`);

--
-- Constraints for table `commission_taxe`
--
ALTER TABLE `commission_taxe`
  ADD CONSTRAINT `FK_9eriy6scy2rite0fna5c6tsk4` FOREIGN KEY (`IDENTIFIANT_AGENCE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`),
  ADD CONSTRAINT `FK_nfkfcvnsnnhbm1xuq0rv72oge` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`);

--
-- Constraints for table `email_operation_operation`
--
ALTER TABLE `email_operation_operation`
  ADD CONSTRAINT `FK_6cm7lunmpc8v1mn8r664sl1w5` FOREIGN KEY (`IDENTIFIANT_EMAIL_FK`) REFERENCES `email_operation` (`IDENTIFIANT_EMAIL`),
  ADD CONSTRAINT `FK_s77xcl731c2axwl01qv3rm7ln` FOREIGN KEY (`CODE_OPERATION_FK`) REFERENCES `operation_cellocash` (`CODE_OPERATION`);

--
-- Constraints for table `grossiste`
--
ALTER TABLE `grossiste`
  ADD CONSTRAINT `FK_ap4iq8oebq5fp2l1qggw1loj6` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`);

--
-- Constraints for table `impottaxe`
--
ALTER TABLE `impottaxe`
  ADD CONSTRAINT `FK_gdmual0whsrcaeasnv9o8lg1e` FOREIGN KEY (`IDENTIFIANT_TYPE_IMPOT_TAXE_FK`) REFERENCES `typeimpottaxe` (`IDENTIFIANT_TYPE_IMPOT_TAXE`);

--
-- Constraints for table `ligne_commission_client`
--
ALTER TABLE `ligne_commission_client`
  ADD CONSTRAINT `FK_2gsex6ec4dwl4eq7k02555h0p` FOREIGN KEY (`CODE_OPERATION_FK`) REFERENCES `operation_cellocash` (`CODE_OPERATION`),
  ADD CONSTRAINT `FK_ef5uu23hrffeixdagywvfm4l` FOREIGN KEY (`CODE_TAXE_FK`) REFERENCES `commissions_client` (`CODE_TAXE`);

--
-- Constraints for table `ligne_commission_taxe`
--
ALTER TABLE `ligne_commission_taxe`
  ADD CONSTRAINT `FK_1a31rhwvoq933hsdl7nxiv6pl` FOREIGN KEY (`IDENTIFIANT_OPERATION_CELLOCASH_FK`) REFERENCES `operationcellocash` (`IDENTIFIANT_OPERATION`),
  ADD CONSTRAINT `FK_8ymtb5vtkgjcd1v214bqal7gv` FOREIGN KEY (`IDENTIFIANT_COMMISSION_TAXE_FK`) REFERENCES `commission_taxe` (`IDENTIFIANT_COMMISSION_TAXE`),
  ADD CONSTRAINT `FK_jjiq9dw2jyf9tneeuw7uv7dv` FOREIGN KEY (`CODE_TAXE_FK`) REFERENCES `commission_taxe` (`CODE_TAXE`),
  ADD CONSTRAINT `FK_jtu0irv625bvuu1vnfa0uhj3s` FOREIGN KEY (`IDENTIFIANT_IMPOT_TAXE_FK`) REFERENCES `impottaxe` (`IDENTIFIANT_IMPOT_TAXE`),
  ADD CONSTRAINT `FK_qjf7fqyanbt2r03p1vo5hg8n5` FOREIGN KEY (`CODE_OPERATION_FK`) REFERENCES `operation_cellocash` (`CODE_OPERATION`);

--
-- Constraints for table `param_secu_liaison_role_permission`
--
ALTER TABLE `param_secu_liaison_role_permission`
  ADD CONSTRAINT `FK_32m57ao06chyaqriecq0p2nlt` FOREIGN KEY (`permissionId`) REFERENCES `param_secu_role_permission` (`permissionId`),
  ADD CONSTRAINT `FK_8coy5xe1vhqj3yqeatvbmuybh` FOREIGN KEY (`ROLE_FK`) REFERENCES `role` (`ROLE_PK`);

--
-- Constraints for table `param_secu_role_permission`
--
ALTER TABLE `param_secu_role_permission`
  ADD CONSTRAINT `FK_lwleojsp30hb487dk8q4v8s02` FOREIGN KEY (`menuParent_permissionId`) REFERENCES `param_secu_role_permission` (`permissionId`);

--
-- Constraints for table `plan_epargne`
--
ALTER TABLE `plan_epargne`
  ADD CONSTRAINT `FK_in720v2bqipnj53tad3c2vqdu` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`);

--
-- Constraints for table `prets`
--
ALTER TABLE `prets`
  ADD CONSTRAINT `FK_i93fc14wkm2kvxacjg2esb4gh` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`);

--
-- Constraints for table `sms_operation_operation`
--
ALTER TABLE `sms_operation_operation`
  ADD CONSTRAINT `FK_ejhdx9n397cm6idws0dcc9r1p` FOREIGN KEY (`CODE_OPERATION_FK`) REFERENCES `operation_cellocash` (`CODE_OPERATION`),
  ADD CONSTRAINT `FK_gm75va1db38xccen8hkjqd3vx` FOREIGN KEY (`CODE_SMS_FK`) REFERENCES `sms_operation` (`CODE_SMS`);

--
-- Constraints for table `tontine_cellocash`
--
ALTER TABLE `tontine_cellocash`
  ADD CONSTRAINT `FK_40pu3h2l86d3mhgyxi9qbvtp7` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_7ri6mnl4jnfm9hx06m9ewdx8i` FOREIGN KEY (`IDENTIFIANT_BANQUE_FK`) REFERENCES `banque_cellocash` (`IDENTIFIANT_BANQUE`),
  ADD CONSTRAINT `FK_9jwt2xotb4jsld8ba4wj5b2rr` FOREIGN KEY (`role_ROLE_PK`) REFERENCES `role` (`ROLE_PK`),
  ADD CONSTRAINT `FK_9rdvpmknswpnac41s0pgs82h8` FOREIGN KEY (`TYPE_AGENCE_BANCAIRE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`);

--
-- Constraints for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD CONSTRAINT `FK_eboo5l4imaoa8itptltejkea` FOREIGN KEY (`IDENTIFIANT_AGENCE_FK`) REFERENCES `agence_bancaire` (`IDENTIFIANT_AGENCE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
