# 🏠 ImmoSmart

ImmoSmart est une plateforme immobilière permettant aux particuliers de publier, rechercher et consulter des biens immobiliers. Le projet intègre également un système d'estimation intelligente des biens et des avis utilisateurs.

## 🎯 Objectif du projet

L'objectif d'ImmoSmart est de simplifier les transactions immobilières en proposant :

- Publication d'annonces immobilières
- Recherche avancée de biens
- Gestion des avis utilisateurs
- Estimation intelligente des prix
- Interface moderne et évolutive

Ce projet est développé dans une logique startup avec une vision long terme d'intégration de l'Intelligence Artificielle.

---

## 🚀 Fonctionnalités MVP

### 👤 Gestion des utilisateurs
- Inscription
- Connexion
- Gestion du profil
- Gestion des rôles

### 🏠 Gestion des biens immobiliers
- Création d'annonces
- Modification d'annonces
- Suppression d'annonces
- Consultation des biens
- Consultation des détails d'un bien

### 📍 Gestion des localisations
- Ville
- Quartier
- Pays

### ⭐ Gestion des avis
- Ajouter un avis
- Consulter les avis d'un bien

### 🖼️ Gestion des images
- Ajouter des images à un bien
- Consulter les images d'un bien

### 🔍 Recherche immobilière
- Recherche par ville
- Recherche par type de bien
- Recherche par prix

### 🤖 Estimation immobilière
- Estimation du prix d'un bien selon :
  - Localisation
  - Surface
  - Type de bien
  - Critères du marché

---

## 🏗️ Architecture

Architecture choisie :

```text
Monolithe Modulaire
```

Organisation du projet :

```text
src/main/java
│
├── user
├── role
├── property
├── location
├── review
├── image
├── estimation
└── common
```

---

## 🛠️ Technologies utilisées

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Base de données
- MySQL

### Outils
- Git
- GitHub
- Postman
- Trello

---

## 🗄️ Modèle de données

### Entités principales

- User
- Role
- Property
- Location
- Review
- Image

### Relations

```text
Role
 │
 └── User
        │
        ├── Property
        │       │
        │       ├── Location
        │       ├── Image
        │       └── Review
        │
        └── Review
```

---

## 📋 Roadmap

### Phase 1 - MVP

- [x] Cahier des charges
- [x] Diagramme de cas d'utilisation
- [x] MCD
- [x] Architecture du projet
- [ ] Authentification
- [ ] Gestion des biens
- [ ] Gestion des avis
- [ ] Gestion des images
- [ ] Recherche immobilière
- [ ] Estimation des biens

### Phase 2

- [ ] JWT
- [ ] Documentation Swagger
- [ ] Optimisation des performances
- [ ] Déploiement Cloud

### Phase 3

- [ ] Intelligence Artificielle avancée
- [ ] Recommandation de biens
- [ ] Analyse du marché immobilier
- [ ] Application mobile

---

## 🧠 Vision IA

À long terme, ImmoSmart intégrera :

- Estimation intelligente des biens
- Recommandation personnalisée
- Analyse prédictive du marché
- Assistant immobilier IA

---

## 👨‍💻 Auteur

Projet développé par :

**Jean ANANI**

---

## 📄 Licence

Projet personnel en cours de développement.
