#EN
# 🏠 ImmoSmart

ImmoSmart is a real estate platform that allows users to publish, search, and explore properties. The project also includes a smart property valuation system and user reviews.

## 🎯 Project Goal

The goal of ImmoSmart is to simplify real estate transactions by providing:

- Property listing management
- Property search and discovery
- User reviews and ratings
- Smart property valuation
- A scalable and modern architecture

This project is being developed as a startup-oriented solution with a long-term vision of integrating Artificial Intelligence.

---

## 🚀 MVP Features

### 👤 User Management
- User registration
- User authentication
- Profile management
- Role management

### 🏠 Property Management
- Create property listings
- Update property listings
- Delete property listings
- Browse available properties
- View property details

### 📍 Location Management
- City
- Neighborhood
- Country

### ⭐ Reviews
- Add reviews to properties
- View property reviews

### 🖼️ Image Management
- Upload property images
- View property images

### 🔍 Property Search
- Search by city
- Search by property type
- Search by price range

### 🤖 Property Valuation
- Estimate property value based on:
  - Location
  - Property type
  - Surface area
  - Market criteria

---

## 🏗️ Architecture

Architecture chosen:

```text
Modular Monolith
```

Project structure:

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

## 🛠️ Technologies

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL

### Tools
- Git
- GitHub
- Postman
- Trello

---

## 🗄️ Data Model

### Main Entities

- User
- Role
- Property
- Location
- Review
- Image

### Relationships

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

- [x] Requirements definition
- [x] Use case diagram
- [x] Data model (ERD)
- [x] Project architecture
- [ ] Authentication system
- [ ] Property management
- [ ] Review management
- [ ] Image management
- [ ] Property search
- [ ] Property valuation

### Phase 2

- [ ] JWT Authentication
- [ ] Swagger API Documentation
- [ ] Performance optimization
- [ ] Cloud deployment

### Phase 3

- [ ] Advanced Artificial Intelligence
- [ ] Property recommendations
- [ ] Real estate market analysis
- [ ] Mobile application

---

## 🧠 AI Vision

In the long term, ImmoSmart will integrate:

- Smart property valuation
- Personalized recommendations
- Predictive market analysis
- AI-powered real estate assistant

---

## 👨‍💻 Author

Developed by:

**Your Name**

---

## 📄 License

This project is currently under development and intended for educational and entrepreneurial purposes.

---------------------------------------------------------------------
#FR
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
