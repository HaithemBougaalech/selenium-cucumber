@Login
Feature: Authentification
  ETQ utilisateur je souhaite m'authentifier sur l'application orange

  @Login_valid_credentials
  Scenario: Je souhaite me connceter avec des identifiants valides
    Given j'accède à l'application orange
    When Je saisis le username
    And Je saisie le mot de passe
    And Je clique sur le bouton login
    Then Je me redirige vers la page dashboard "Dashboard"

  
