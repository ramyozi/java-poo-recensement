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

			System.out.println(
					"Choississez une population minimum (en milliers d'habitants): ");
			String saisieMin = scanner.nextLine();

			System.out.println(
					"Choississez une population maximum (en milliers d'habitants): ");
			String saisieMax = scanner.nextLine();

			int min = Integer.parseInt(saisieMin) * 1000;
			int max = Integer.parseInt(saisieMax) * 1000;

			List<Ville> villes = rec.getVilles();
			for (Ville ville : villes) {
				if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
					if (ville.getPopulation() >= min
							&& ville.getPopulation() <= max) {
						System.out.println(ville);
					}
				}
			}
		} catch (NumberFormatException e) {
			System.err.println(
					"Erreur : Veuillez saisir un code de département valide (chiffres uniquement).");
		} catch (IllegalArgumentException e) {
			System.err.println("Erreur : " + e.getMessage());
		}
	}

}
