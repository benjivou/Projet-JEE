-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 31 mai 2020 à 12:54
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cours_jee_exemple2`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `Likes` int(11) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `content`, `date`, `id_utilisateur`, `Likes`) VALUES
(0, 'Bonnjour c\'est super', '2020-05-28', 4, 4),
(3, 'super', '2020-05-26', 3, 3),
(6, 'super top', '2020-05-26', 3, 3),
(7, 'vraiment top', '2020-05-26', 3, 3),
(8, 'C\'était vraiment trop bien', '2020-05-26', 4, 3),
(10, 'Super génial', '2020-05-27', 6, 3),
(11, 'C\'est vraiment trop bien, on s\'amuse et on apprend beaucoup de choses !!!!!', '2020-05-27', 7, 3),
(12, 'C\'était franchement très sympa !!!!', '2020-05-28', 6, 3);

-- --------------------------------------------------------

--
-- Structure de la table `likes`
--

CREATE TABLE `likes` (
  `idLike` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `idCommentaire` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `likes`
--

INSERT INTO `likes` (`idLike`, `idUtilisateur`, `idCommentaire`) VALUES
(41, 3, 0),
(40, 3, 3),
(42, 3, 6),
(45, 3, 7),
(44, 3, 8),
(43, 3, 10),
(47, 3, 11),
(46, 3, 12),
(31, 4, 0),
(30, 4, 3),
(35, 4, 6),
(37, 4, 7),
(32, 4, 8),
(36, 4, 10),
(39, 4, 11),
(38, 4, 12),
(52, 7, 0),
(48, 7, 3),
(56, 7, 6),
(49, 7, 7),
(54, 7, 8),
(55, 7, 10),
(57, 7, 11),
(53, 7, 12);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_utilisateur` int(11) NOT NULL,
  `email` varchar(60) NOT NULL,
  `mot_de_passe` varchar(32) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `date_inscription` datetime NOT NULL,
  `prenom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `email`, `mot_de_passe`, `nom`, `date_inscription`, `prenom`) VALUES
(3, 'toto@gmail.com', 'toto', 'toto', '2020-05-19 20:43:24', 'toto'),
(4, 'benjivou2@gmail.com', 'toto', 'ben', '2020-05-26 14:03:06', 'Vouillon'),
(5, 'benjivou@gmail.co', 'toto', 'Vouillon', '2020-05-26 14:09:02', 'Vouillon'),
(6, 'juju@ju.com', 'juju', 'juju', '2020-05-27 12:25:50', 'juju'),
(7, 'tutu@tu.tu', 'tutu', 'tutu', '2020-05-27 21:37:00', 'tutu'),
(8, 'benjivottu2@gmail.comt', 'ttt', 'ttt', '2020-05-30 14:34:52', 'Vouillon');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`idLike`),
  ADD UNIQUE KEY `idUtilisateur` (`idUtilisateur`,`idCommentaire`),
  ADD KEY `idCommentaire` (`idCommentaire`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_utilisateur`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `likes`
--
ALTER TABLE `likes`
  MODIFY `idLike` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `id_utilisateur` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`idCommentaire`) REFERENCES `commentaire` (`id_commentaire`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
