SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS offrestage;

USE offrestage;

CREATE TABLE `admin` (
                         `id_admin` int(11) NOT NULL,
                         `nom_admin` varchar(50) NOT NULL,
                         `prenom_admin` varchar(50) NOT NULL,
                         `email_admin` varchar(50) NOT NULL,
                         `mdp_admin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `admin` (`id_admin`, `nom_admin`, `prenom_admin`, `email_admin`, `mdp_admin`) VALUES
    (1, 'nom', 'prenom', 'adresse@gmail.com', '1234');

CREATE TABLE `candidature` (
                               `id_offre` int(50) NOT NULL,
                               `id_etudiant` int(50) NOT NULL,
                               `nom_entreprise` varchar(50) NOT NULL,
                               `id_candidature` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `entreprise` (
                              `nom_entreprise` varchar(50) NOT NULL,
                              `adresse_ville_entreprise` varchar(50) NOT NULL,
                              `adresse_rue_entreprise` varchar(50) NOT NULL,
                              `adresse_code_postal_entreprise` varchar(50) NOT NULL,
                              `tel_entreprise` varchar(50) NOT NULL,
                              `email_entreprise` varchar(50) NOT NULL,
                              `secteur_activite` varchar(50) NOT NULL,
                              `mdp_entreprise` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `etudiant` (
                            `id_etudiant` int(11) NOT NULL,
                            `nom_etudiant` varchar(50) NOT NULL,
                            `prenom_etudiant` varchar(50) NOT NULL,
                            `date_de_naissance` varchar(50) NOT NULL,
                            `niveau_etude` varchar(50) NOT NULL,
                            `email_etudiant` varchar(50) NOT NULL,
                            `mdp_etudiant` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `offre` (
                         `id_offre` int(50) NOT NULL,
                         `libelle_offre` varchar(100) NOT NULL,
                         `description_offre` text NOT NULL,
                         `domaine_offre` varchar(50) NOT NULL,
                         `date_debut_offre` varchar(50) NOT NULL,
                         `duree_offre` varchar(11) NOT NULL,
                         `chemin_offre` varchar(75) NOT NULL,
                         `valide_offre` tinyint(1) NOT NULL DEFAULT '0',
                         `nom_entreprise` varchar(50) NOT NULL,
                         `email_entreprise` varchar(50) NOT NULL,
                         `adresse_ville_entreprise` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `admin`
    ADD PRIMARY KEY (`id_admin`),
  ADD UNIQUE KEY `id_admin` (`id_admin`);

ALTER TABLE `candidature`
    ADD PRIMARY KEY (`id_candidature`);

ALTER TABLE `entreprise`
    ADD PRIMARY KEY (`nom_entreprise`);

ALTER TABLE `etudiant`
    ADD PRIMARY KEY (`id_etudiant`),
  ADD UNIQUE KEY `adresse_mail` (`email_etudiant`);

ALTER TABLE `offre`
    ADD PRIMARY KEY (`id_offre`);

ALTER TABLE `admin`
    MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `candidature`
    MODIFY `id_candidature` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `etudiant`
    MODIFY `id_etudiant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `offre`
    MODIFY `id_offre` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;