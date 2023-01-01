@regression
Feature: verify checkout order functionality

  Background: User has opened application
    Given user open aplikasi rupa rupa mobile

  Scenario: verify checkout order with invalid data
    When the user tap on "Rumah Tangga" category button
    And the user tap on Lihat Semua "Rumah Tangga" category button
    And the user tap on Filter button
    And the user tap on Promo button
    And the user tap on "Buy 1 Get 1" checkbox
    And the user tap on "New Arrivals" checkbox
    And the user tap on Simpan button
    And the user tap on Terapkan button
    And the user scroll down to products
    And the user tap on first product
    And the user tap on tambah ke keranjang button
    And the user tap on lanjut ke keranjang button
    And the user tap on sign in section
    And the user fill on random email and password in sign in form
    Then the login error message should be displayed