package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {
		try {
			System.out.println(
					"Quel est le code du département recherché ? ");
			String choix = scanner.nextLine();
			if (!codeDepartementExiste(choix, rec.getVilles())) {
				throw new IllegalArgumentException(
						"Le code du département est inconnu.");
			}

			System.out.println(
					"Choississez une population minimum (en milliers d'habitants): ");
			String saisieMin = scanner.nextLine();
			int min = 0;
			try {
				min = Integer.parseInt(saisieMin) * 1000;
				if (min < 0) {
					throw new IllegalArgumentException(
							"La population minimum ne peut pas être négative.");
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(
						"La population minimum doit être un nombre entier.");
			}
			System.out.println(
					"Choississez une population maximum (en milliers d'habitants): ");
			String saisieMax = scanner.nextLine();
			int max = 0;
			try {
				max = Integer.parseInt(saisieMax) * 1000;
				if (max < 0) {
					throw new IllegalArgumentException(
							"La population maximum ne peut pas être négative.");
				}
				if (max < min) {
					throw new IllegalArgumentException(
							"La population maximum doit être supérieure à la population minimum.");
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(
						"La population maximum doit être un nombre entier.");
			}

			List<Ville> villes = rec.getVilles();
			for (Ville ville : villes) {
				if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
					if (ville.getPopulation() >= min
							&& ville.getPopulation() <= max) {
						System.out.println(ville);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			System.err.println("Erreur : " + e.getMessage());
		}
	}

	// Cette fonction vérifie si un code de département existe dans la liste des
	// villes
	private boolean codeDepartementExiste(String codeDepartement,
			List<Ville> villes) {
		for (Ville ville : villes) {
			if (ville.getCodeDepartement()
					.equalsIgnoreCase(codeDepartement)) {
				return true;
			}
		}
		return false;
	}
}
